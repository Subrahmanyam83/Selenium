/*
 * Copyright 2007 united internet (unitedinternet.com) Robert Zimmermann
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.tbb.logging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.thoughtworks.selenium.CommandProcessor;
import com.thoughtworks.selenium.HttpCommandProcessor;

/**
 * Logs processed selenium commands (processed via remote-control) with an arbitrary LoggingResultsFormatter. The formatter is
 * responsible for writing logging events. A List of Selenium-Commands can be excluded from logging. Default is "getHtmlSource".
 * Calls to selenium from within com.thoughtworks.selenium.Wait will be filtered and logged only once. Wait should not be the last
 * command in execution (except in error, eg. timeout situation), as there is no way up to now to know that the last Wait is not a
 * timed-out one. TODO selenium calls inside Wait are only logged once (filtered else) make this configurable TODO make name of a
 * "Wait" class configurable TODO (feature) count time taken inside a Wait and logg that, too TODO (feature) add more metrics.
 * currently verification errors can not be reliable counted
 *
 * @author Robert Zimmermann $Id: LoggingCommandProcessor.java 134 2009-01-14 20:44:21Z bobbyde $
 */
public class LoggingCommandProcessor implements CommandProcessor {
    static final String AUTO_SCREENSHOT_WAIT_TIMEOUT_FILENAME_PART = "WaitTimeout";

    private CommandProcessor realCommandProcessor;

    private LoggingResultsFormatter formatter;

    final TestMetricsBean seleniumTestMetrics = new TestMetricsBean();

    static final String SELENIUM_RC_OK_RESULT = "OK";

    static final String SELENIUM_RC_OK_RESULT_PREFIX_WITH_COMMA = SELENIUM_RC_OK_RESULT + ",";

    static final String SELENIUM_CORE_BOOLEAN_RESULT_TRUE = "true";

    static final String SELENIUM_CORE_BOOLEAN_RESULT_FALSE = "false";

    static final String WAIT_CLASS_NAME = "Wait";

    boolean logMethodsAsComments = true;

    String[] excludeCommandsFromLogging = {"getHtmlSource"};

    List<LoggingBean> loggingEventsQueue = new ArrayList<LoggingBean>();

    private LoggingNotifier callbackNotifier = null;
    private Object callbackInstance = null;

    /**
     * Constructor.
     *
     * @param commandProcessor
     *        commandProcessor to be used for communication with selenium
     * @param myFormatter
     *        formatter, responsible for formating all loggingEvents and writing them to file, db or whatever.
     */
    public LoggingCommandProcessor(CommandProcessor commandProcessor, LoggingResultsFormatter myFormatter) {
        this.formatter = myFormatter;
        this.realCommandProcessor = commandProcessor;
    }

    /**
     * Will create an HttpCommandProcessor for you.
     *
     * @param serverHost -
     *        the host name on which the Selenium Server resides
     * @param serverPort -
     *        the port on which the Selenium Server is listening
     * @param browserStartCommand -
     *        the command string used to launch the browser, e.g. "*firefox" or "c:\\program files\\internet
     *        explorer\\iexplore.exe"
     * @param browserUrl -
     *        the starting URL including just a domain name. We'll start the browser pointing at the Selenium resources on this
     *        URL, e.g. "http://www.google.com" would send the browser to
     *        "http://www.google.com/selenium-server/core/RemoteRunner.html"
     * @param myFormatter
     *        formatter, responsible for formating all loggingEvents and writing them to file, db or whatever.
     */
    public LoggingCommandProcessor(String serverHost, int serverPort, String browserStartCommand, String browserUrl,
            LoggingResultsFormatter myFormatter) {
        this.formatter = myFormatter;
        this.realCommandProcessor = new HttpCommandProcessor(serverHost, serverPort, browserStartCommand, browserUrl);
    }

    /**
     * Extends doCommand, handling special logging commands. Delegates all other commands to the realcommandProcessor.
     * {@inheritDoc}
     */
    public String doCommand(String commandName, String[] args) {
        String result = "";
        long cmdStartMillis = System.currentTimeMillis();
        if (SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_COMMENT.getName().equals(commandName)) {
            String comment = args[0] != null ? args[0] : "";
            String extraInfo = "";
            if (args.length > 1) {
                extraInfo = args[1] != null ? args[1] : "";
            }
            logComment(comment, extraInfo, cmdStartMillis);
        } else if (SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_AUTO_SCREENSHOT.getName().equals(commandName)) {
            String baseName = args[0] != null ? args[0] : "";
            doAutomaticScreenshot(baseName);
        } else if (SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_ASSERTION.getName().equals(commandName)) {
            // FIXME handle less than 3 args
            String[] loggingArgs = new String[] {args[1], args[2]};
            doExceptionLogging(args[0], loggingArgs, "", null, cmdStartMillis);
        } else if (SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_RESOURCE.getName().equals(commandName)) {
            result = LoggingCommandProcessor.SELENIUM_RC_OK_RESULT;
            long now = System.currentTimeMillis();
            LoggingBean b = new LoggingBean();
            b.setCallingClass(getRealCallingClassWithLineNumberAsString(getCurrentCallingClassAsStackTraceElement()));
            b.setWaitInvolved(isWaitInvolved());
            b.setSourceMethod("RESOURCE");
            b.setCommandName("captureScreenshot");
            b.setResult(result);
            b.setArgs(args);
            b.setCommandSuccessful(true);
            b.setCmdStartMillis(now);
            b.setCmdEndMillis(now);
            loggingEventsQueue.add(b);
        } else {
            this.seleniumTestMetrics.incCommandsProcessed();
            try {
                result = this.realCommandProcessor.doCommand(commandName, args);
            } catch (RuntimeException e) {
                doExceptionLogging(commandName, args, "", e, cmdStartMillis);
                throw e;
            }
            doLogging(commandName, args, result, cmdStartMillis);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    /*
     * getScreenshot patch needed for this public BufferedImage getScreenshot(String fileType) { return
     * this.realCommandProcessor.getScreenshot(fileType); }
     */
    /**
     * {@inheritDoc}
     */
    public boolean getBoolean(String commandName, String[] args) {
        // TODO: both?
        long cmdStartMillis = System.currentTimeMillis();
        this.seleniumTestMetrics.incCommandsProcessed();
        this.seleniumTestMetrics.incVerificationsProcessed();
        boolean result = false;
        try {
            result = this.realCommandProcessor.getBoolean(commandName, args);
        } catch (RuntimeException e) {
            doExceptionLogging(commandName, args, "", e, cmdStartMillis);
            throw (e);
        }
        doLogging(commandName, args, LoggingCommandProcessor.SELENIUM_RC_OK_RESULT_PREFIX_WITH_COMMA + result, cmdStartMillis);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public boolean[] getBooleanArray(String commandName, String[] args) {
        long cmdStartMillis = System.currentTimeMillis();
        this.seleniumTestMetrics.incCommandsProcessed();
        boolean[] results;
        try {
            results = this.realCommandProcessor.getBooleanArray(commandName, args);
        } catch (RuntimeException e) {
            doExceptionLogging(commandName, args, "", e, cmdStartMillis);
            throw e;
        }
        doLogging(commandName, args, LoggingCommandProcessor.SELENIUM_RC_OK_RESULT_PREFIX_WITH_COMMA
                + ArrayUtils.toString(results), cmdStartMillis);
        return results;
    }

    /**
     * {@inheritDoc}
     */
    public Number getNumber(String commandName, String[] args) {
        long cmdStartMillis = System.currentTimeMillis();
        this.seleniumTestMetrics.incCommandsProcessed();
        Number result;
        try {
            result = this.realCommandProcessor.getNumber(commandName, args);
        } catch (RuntimeException e) {
            doExceptionLogging(commandName, args, "", e, cmdStartMillis);
            throw e;
        }
        doLogging(commandName, args, LoggingCommandProcessor.SELENIUM_RC_OK_RESULT_PREFIX_WITH_COMMA + result, cmdStartMillis);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public Number[] getNumberArray(String commandName, String[] args) {
        long cmdStartMillis = System.currentTimeMillis();
        this.seleniumTestMetrics.incCommandsProcessed();
        Number[] results;
        try {
            results = this.realCommandProcessor.getNumberArray(commandName, args);
        } catch (RuntimeException e) {
            doExceptionLogging(commandName, args, "", e, cmdStartMillis);
            throw e;
        }
        doLogging(commandName, args, LoggingCommandProcessor.SELENIUM_RC_OK_RESULT_PREFIX_WITH_COMMA
                + ArrayUtils.toString(results), cmdStartMillis);
        return results;
    }

    /**
     * {@inheritDoc}
     */
    public String getString(String commandName, String[] args) {
        long cmdStartMillis = System.currentTimeMillis();
        this.seleniumTestMetrics.incCommandsProcessed();
        String result;
        try {
            result = this.realCommandProcessor.getString(commandName, args);
        } catch (RuntimeException e) {
            doExceptionLogging(commandName, args, "", e, cmdStartMillis);
            throw e;
        }
        doLogging(commandName, args, LoggingCommandProcessor.SELENIUM_RC_OK_RESULT_PREFIX_WITH_COMMA
                + ArrayUtils.toString(result), cmdStartMillis);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public String[] getStringArray(String commandName, String[] args) {
        long cmdStartMillis = System.currentTimeMillis();
        String[] results;
        try {
            results = this.realCommandProcessor.getStringArray(commandName, args);
        } catch (RuntimeException e) {
            doExceptionLogging(commandName, args, "", e, cmdStartMillis);
            throw e;
        }
        doLogging(commandName, args, LoggingCommandProcessor.SELENIUM_RC_OK_RESULT_PREFIX_WITH_COMMA
                + ArrayUtils.toString(results), cmdStartMillis);
        return results;
    }

    /**
     * {@inheritDoc}
     */
    public void start() {
        this.realCommandProcessor.start();
        this.seleniumTestMetrics.setStartTimeStamp(System.currentTimeMillis());
        logExecutionEnvironment();
    }

    /**
     * {@inheritDoc}
     */
    public void stop() {
        seleniumTestFinished();
        this.realCommandProcessor.stop();
        seleniumTestMetrics.setCommandsExcludedFromLogging(excludeCommandsFromLogging);
        // TODO: looks a bit awkward (instantiating and not care about the instance)
        new EventQueuePostProcessor(formatter, loggingEventsQueue, seleniumTestMetrics, logMethodsAsComments);
    }

    /**
     * List of Selenium commands to be excluded from logging. Default exclude: getHtmlSource
     *
     * @return current list of commands to be excluded
     */
    public String[] getExcludedCommands() {
        return excludeCommandsFromLogging.clone();
    }

    /**
     * List of Selenium commands to be excluded from logging Be aware that the defaults will be overwritten. Combine with an
     * getExcludedCommands to preserve defaults
     *
     * @param excludedCommands
     *        list of commands to be excluded
     */
    public void setExcludedCommands(String[] excludedCommands) {
        this.excludeCommandsFromLogging = excludedCommands.clone();
    }

    /**
     * Remember any selenium command with its result as an SeleniumLoggingBean. This is an convenience method to preset an
     * SeleniumLoggingBean
     *
     * @param commandName
     *        the commandName for and from selenium (may be a special one like for comments)
     * @param args
     *        0 to 2 parameters as used by selenium
     * @param result
     *        the result from selenium (and RC)
     * @param cmdStartMillis
     *        timestamp just before command started
     * @param cmdEndMillis
     *        timestamp after command finished
     * @return preset SeleniumLoggingBean (only preset, as the SeleniumLoggingBean can hold more information)
     */
    public static LoggingBean presetLoggingBean(String commandName, String[] args, String result, long cmdStartMillis,
            long cmdEndMillis) {
        LoggingBean loggingBean = new LoggingBean();
        loggingBean.setCommandName(commandName);
        loggingBean.setArgs(args);
        loggingBean.setResult(result);
        loggingBean.setCmdStartMillis(cmdStartMillis);
        loggingBean.setCmdEndMillis(cmdEndMillis);
        return loggingBean;
    }

    /**
     * Gather information about where and with which versions selenium is executed. FIXME: use this.getEval to get all these
     * commands logged the normal way and summarized later in the formatter
     */
    void logExecutionEnvironment() {
        final String userAgent = getEvalNoException("navigator.userAgent");
        this.seleniumTestMetrics.setUserAgent(userAgent);

        // SeleniumCore
        final String seleniumCoreVersion = getEvalNoException("window.top.Selenium.coreVersion");
        this.seleniumTestMetrics.setSeleniumCoreVersion(seleniumCoreVersion);
        final String seleniumCoreRevision = getEvalNoException("window.top.Selenium.coreRevision");
        this.seleniumTestMetrics.setSeleniumCoreRevision(seleniumCoreRevision);
        // SeleniumRC
        final String seleniumRcVersion = getEvalNoException("window.top.Selenium.rcVersion");
        this.seleniumTestMetrics.setSeleniumRcVersion(seleniumRcVersion);
        final String seleniumRcRevision = getEvalNoException("window.top.Selenium.rcRevision");
        this.seleniumTestMetrics.setSeleniumRcRevision(seleniumRcRevision);
    }

    /**
     * Get an Property via Selenium getEval catching any Exception beeing thrown.
     * @param jsExpr an JavaScript Expressing returning an String
     * @return result of calling getEval or "UNKNOWN" if any Exception is issued by Selenium
     */
    String getEvalNoException(String jsExpr) {
        String propertyValue;
        try {
            propertyValue = this.realCommandProcessor.getString("getEval",
                new String[] {jsExpr,});
        } catch (Exception exc) {
            propertyValue = "UNKNOWN";
        }
        return propertyValue;
    }

    /**
     * Log an Exception.
     *
     * @param commandName
     *        commandName which possibly is responsible for the exception
     * @param args
     *        arguments which possibly are responsible for the exception
     * @param result
     *        normally empty string as the processed command caused an exception
     * @param exception
     *        the exception thrown by the used CommandProcessor can be null
     */
    void doExceptionLogging(String commandName, String[] args, String result, Throwable exception, long cmdStartMillis) {
        Boolean screenshot = true;
        if (null!=callbackNotifier) {
            screenshot = callbackNotifier.errorLogging(callbackInstance, commandName, args, result, exception, cmdStartMillis);
        }
        if (screenshot) {
            doAutomaticScreenshot("Error");
        }
        String resultContent;
        String errorMessage;
        if (null != exception) {
            resultContent = "ERROR," + result + " " + exception.getClass().getName() + " - " + exception.getMessage();
            errorMessage = exception.getMessage();
        } else {
            resultContent = "ERROR," + result;
            if (args.length > 0) {
                errorMessage = "ERROR: " + args[0];
            } else {
                errorMessage = "INTERNAL ERROR: real error-msg could not be determined";
            }
        }
        doLogging(commandName, args, resultContent, cmdStartMillis);
        this.seleniumTestMetrics.incFailedCommands();
        this.seleniumTestMetrics.setLastFailedCommandMessage(errorMessage);
    }

    /**
     * Log the current Command.
     *
     * @param commandName
     *        commandName to be logged
     * @param args
     *        arguments to be logged
     * @param result
     *        the result to be logged
     * @param cmdStartMillis
     *        time in milliseconds when execution started
     */
    void doLogging(String commandName, String[] args, String result, long cmdStartMillis) {
        LoggingBean currentCommand = LoggingCommandProcessor.presetLoggingBean(commandName, args, result, cmdStartMillis, System
                .currentTimeMillis());
        currentCommand.setExcludeFromLogging(isCommandExcludedFromLogging(commandName));
        currentCommand.setCallingClass(getRealCallingClassWithLineNumberAsString(getCurrentCallingClassAsStackTraceElement()));
        currentCommand.setWaitInvolved(isWaitInvolved());
        String sourceMethodName = "unknown";
        StackTraceElement classOrNull = getCurrentCallingClassAsStackTraceElement();
        if (null != classOrNull) {
            sourceMethodName = classOrNull.getMethodName();
        }
        currentCommand.setSourceMethod(sourceMethodName);
        loggingEventsQueue.add(currentCommand);
    }

    /**
     * Log comment.
     *
     * @param comment
     *        the comment to be logged
     * @param extraInfo
     *        optional, additional string to be logged, which may be treated a special way or omitted by the used formatter
     */
    void logComment(String comment, String extraInfo, long cmdStartMillis) {
        doLogging(SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_COMMENT.getName(), new String[] {comment, extraInfo}, "",
                cmdStartMillis);
    }

    /**
     * Utility to check if the current command is to be excluded.
     *
     * @param commandName
     *        current command name
     * @return true, if this command name should be excluded from logging
     */
    boolean isCommandExcludedFromLogging(final String commandName) {
        return Arrays.asList(excludeCommandsFromLogging).contains(commandName);
    }

    StackTraceElement getCurrentCallingClassAsStackTraceElement() {
        return StackTraceUtils.getCurrentCallingClassAsStackTraceElement(Thread.currentThread().getStackTrace(),
                "DefaultSelenium");
    }

    String getRealCallingClassWithLineNumberAsString(StackTraceElement currentCallingClassAsStackTraceElement) {
        return StackTraceUtils.stackTraceElementWithLinenumberAsString(currentCallingClassAsStackTraceElement);
    }

    boolean isWaitInvolved() {
        return StackTraceUtils.isClassInStackTrace(Thread.currentThread().getStackTrace(), "."
                + LoggingCommandProcessor.WAIT_CLASS_NAME);
    }

    void seleniumTestFinished() {
        this.seleniumTestMetrics.setEndTimeStamp(System.currentTimeMillis());
        // Wait timed out?
        if (loggingEventsQueue.size() > 0) {
            LoggingBean lastBeanInQueue = loggingEventsQueue.get(loggingEventsQueue.size() - 1);
            if (lastBeanInQueue.isWaitInvolved()) {
                lastBeanInQueue.setResult("ERROR,wait timed out");
                doAutomaticScreenshot(LoggingCommandProcessor.AUTO_SCREENSHOT_WAIT_TIMEOUT_FILENAME_PART);
                this.seleniumTestMetrics.setLastFailedCommandMessage(lastBeanInQueue.getResult());
                this.seleniumTestMetrics.incFailedCommands();
            }
        }
    }

    void doAutomaticScreenshot(String baseFileName) {
        final String autoScreenshotFullPath = formatter.generateFilenameForAutomaticScreenshot(baseFileName);
        Boolean internal = true;
        if (null!=callbackNotifier) {
            final String pathFile = formatter.generateFilenameForAutomaticScreenshot(
                    LoggingCommandProcessor.AUTO_SCREENSHOT_WAIT_TIMEOUT_FILENAME_PART);
            internal = callbackNotifier.makeScreenshot(callbackInstance, pathFile);
        }
        if (internal) {
            doCommand("captureScreenshot", new String[] {autoScreenshotFullPath});
        }
    }

    /**
     * Is the current test failed.
     *
     * Only suitable after all commands are processed.
     * But can be called at any time.
     *
     * @return true if test failed
     */
    public boolean isTestFailed() {
        return seleniumTestMetrics.getFailedCommands() > 0;
    }

    /**
     * Set the call back notifier. If you want to stop notifications
     * set to null.
     *
     * @param callbackLoggingNotifier The call back notifier object
     * @param callbackLoggingInstance The calling instance to notify
     */
    public void setCallbackNotifier(LoggingNotifier callbackLoggingNotifier, Object callbackLoggingInstance) {
        this.callbackNotifier = callbackLoggingNotifier;
        this.callbackInstance = callbackLoggingInstance;
    }

    public boolean isLogMethodsAsComments() {
        return logMethodsAsComments;
    }

    public void setLogMethodsAsComments(boolean logMethodsAsComments) {
        this.logMethodsAsComments = logMethodsAsComments;
    }

	public String getRemoteControlServerLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setExtensionJs(String extensionJs) {
		// TODO Auto-generated method stub
		
	}

	public void start(String optionsString) {
		// TODO Auto-generated method stub
		
	}

	public void start(Object optionsObject) {
		// TODO Auto-generated method stub
		
	}
}

