/*
 * Copyright 2007/2008 united internet (unitedinternet.com) Robert Zimmermann
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

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 *
 * Post process LoggingBean events queue.
 *
 * Combine single Wait-events to one
 *
 * Summarize time spent in methods
 *
 * @author Robert Zimmermann
 *
 * $Id: EventQueuePostProcessor.java 130 2008-07-21 15:19:53Z bobbyde $
 */
public class EventQueuePostProcessor {
    private LoggingResultsFormatter formatter;

    boolean logMethodsAsComments = true;

    /**
     * Loop through loggingEventsQueue and output it to the formatter.
     *
     * Right now filtering is included to feed HtmlResultsFormatter the same way it was donne in 1.0
     *
     * @param outputFormatter formatter handling formatting and storing of the gathered log-events
     * @param loggingEventsQueue all logging events including every event inside a wait and commands not to be logged
     * @param seleniumTestMetrics some basic metrics and an brief abstract of the test run
     */
    public EventQueuePostProcessor(LoggingResultsFormatter outputFormatter, List<LoggingBean> loggingEventsQueue,
            TestMetricsBean seleniumTestMetrics, boolean logMethodsAsComments) {
        this.formatter = outputFormatter;
        this.logMethodsAsComments = logMethodsAsComments;
        formatAllGatheredInformations(loggingEventsQueue, seleniumTestMetrics);
    }

    /**
     * Calls command-type dependent method in formatter. Decides whether command is a comment, has boolean result or is just a
     * normal command.
     *
     * @param loggingBean containing details of the command to be formatted and logged
     */
    void formatAndOutputCommand(LoggingBean loggingBean) {

        if (SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_COMMENT.getName().equals(loggingBean.getCommandName())) {
            formatter.commentLogEvent(loggingBean);
            return;
        }

        boolean srcResult = false;
        String result = loggingBean.getResult();

        // FIXME: these if's should be done inside LoggingBean.
        if (result.startsWith(LoggingCommandProcessor.SELENIUM_RC_OK_RESULT)) {
            if (result.endsWith(LoggingCommandProcessor.SELENIUM_CORE_BOOLEAN_RESULT_TRUE)
                    || result.endsWith(LoggingCommandProcessor.SELENIUM_CORE_BOOLEAN_RESULT_FALSE)) {
                loggingBean.setCommandSuccessful(result.endsWith(LoggingCommandProcessor.SELENIUM_CORE_BOOLEAN_RESULT_TRUE));
                formatter.booleanCommandLogEvent(loggingBean);
                return;
            } else {
                srcResult = true;
            }
        }
        loggingBean.setCommandSuccessful(srcResult);
        formatter.commandLogEvent(loggingBean);
    }

    /**
     * Added text prefix if we are inside a wait loop.
     */
    private static final String WAIT_PREFIX = "(Wait)";

    /**
     * Loop through loggingEventsQueue and output it to the formatter.
     *
     * Right now filtering is included to feed HtmlResultsFormatter the same way it was done in 1.0
     *
     * @param loggingEventsQueue all logging events including every event inside a wait and commands not to be logged
     * @param seleniumTestMetrics some basic metrics and an brief abstract of the test run
     */
    void formatAllGatheredInformations(List<LoggingBean> loggingEventsQueue, TestMetricsBean seleniumTestMetrics) {
        formatter.headerLogEvent(seleniumTestMetrics);

        boolean insideWait = false;
        long startWaitMillis = 0;
        LoggingBean lastWaitLoggingEvent = null;
        String currentMethodName = "";
        LoggingBean rootLoggingBean = new LoggingBean();
        boolean completeResult = true;
        for (LoggingBean currentLoggingEvent : loggingEventsQueue) {

            if (currentLoggingEvent.isWaitInvolved()) {
                lastWaitLoggingEvent = currentLoggingEvent;
                if (!insideWait) {
                    insideWait = true;
                    startWaitMillis = currentLoggingEvent.getCmdStartMillis();
                } // else do nothing as we are inside a wait
            } else {
                if (insideWait) {
                    insideWait = false;
                    lastWaitLoggingEvent.setWaitDeltaMillis(currentLoggingEvent.getCmdEndMillis() - startWaitMillis);
                    startWaitMillis = 0;
                    // lastWaitLoggingEvent is really the last wait command. So output it to the formatter now
                    String s = lastWaitLoggingEvent.getCommandName();
                    if (!s.startsWith(WAIT_PREFIX)) {
                        lastWaitLoggingEvent.setCommandName(WAIT_PREFIX + s);
                    }
                    formatAndOutputCommand(lastWaitLoggingEvent);
                }
                if (!currentLoggingEvent.getSourceMethod().equals(currentMethodName)) {
                    if (StringUtils.isNotEmpty(currentMethodName)) {
                        postProcessMethod(completeResult, rootLoggingBean, currentMethodName);
                        completeResult = true;
                    }

                    currentMethodName = currentLoggingEvent.getSourceMethod();
                    rootLoggingBean = new LoggingBean();
                    rootLoggingBean.setCallingClass(currentLoggingEvent.getCallingClass());
                    logNewMethodEntered(currentMethodName, rootLoggingBean);
                }
                formatAndOutputCommand(currentLoggingEvent);
                rootLoggingBean.addChild(currentLoggingEvent);
            }
            completeResult = completeResult && currentLoggingEvent.isCommandSuccessful();
        }

        postProcessMethod(completeResult, rootLoggingBean, currentMethodName);
        formatter.footerLogEvent();
    }

    /**
     * Log test data after execution of each test method.
     *
     * @param completeMethodResult result for the whole test method, true if all tests succeded
     * @param currentLoggingBean logging bean containing the method data
     * @param currentMethod current executed method
     */
    void postProcessMethod(boolean completeMethodResult, LoggingBean currentLoggingBean, String currentMethod) {
        currentLoggingBean.setCommandSuccessful(completeMethodResult);
        currentLoggingBean.setArgs(new String[] {"executing " + currentLoggingBean.getCallingClass() + "::" + currentMethod});
        formatter.methodLogEvent(currentLoggingBean);
    }

    /**
     * Log method-name just entered executing a selenium command as a comment.
     * @param currentMethodName actual method
     * @param loggingBean comment loggingbean
     */
    void logNewMethodEntered(final String currentMethodName, LoggingBean loggingBean) {
        if (logMethodsAsComments) {
            loggingBean.setCommandName(SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_COMMENT.getName());
            loggingBean.setArgs(new String[] {"executing " + currentMethodName + "()"});
            formatAndOutputCommand(loggingBean);
        }
    }
}
