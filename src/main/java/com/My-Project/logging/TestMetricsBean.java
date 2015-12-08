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

import org.apache.commons.lang.ArrayUtils;

/**
 * Metrics and environment information (user-agent, versions) collected during test run.
 *
 * TODO: maybe also count commandsProcessed, verificationsProcessed which were not inside a Wait
 *
 * @author robertzimmermann
 *
 * $Id: TestMetricsBean.java 96 2008-04-05 10:36:28Z bobbyde $
 */
public class TestMetricsBean {
    private long startTimeStamp;

    private long endTimeStamp;

    private static final String LOGGING_SELENIUM_REVISION = "$Revision: 96 $";

    private static final int REVISION_PREFIX_LENGTH = "$Revision: ".length();

    private long commandsProcessed = 0;

    private long failedCommands = 0;

    private long verificationsProcessed = 0;

    private String userAgent;

    private String seleniumCoreVersion;

    private String seleniumCoreRevision;

    private String seleniumRcVersion;

    private String seleniumRcRevision;

    private String lastFailedCommandMessage;

    String[] commandsExcludedFromLogging = {};

    public long getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(long startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public long getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(long endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    public long getCommandsProcessed() {
        return commandsProcessed;
    }

    public void setCommandsProcessed(long commandsProcessed) {
        this.commandsProcessed = commandsProcessed;
    }

    /**
     * Increment commandsProcessed by one.
     *
     * Convenience method to shortcut usage like this: setCommandsProcessed(getCommandsProcessed()+1)
     */
    public void incCommandsProcessed() {
        this.commandsProcessed++;
    }

    public long getFailedCommands() {
        return failedCommands;
    }

    public void setFailedCommands(long failedCommands) {
        this.failedCommands = failedCommands;
    }

    /**
     * Increment failedCommands by one.
     *
     * Convenience method to shortcut usage like this: setFailedCommands(getFailedCommands()+1)
     */
    public void incFailedCommands() {
        this.failedCommands++;
    }

    /**
     * Compute test duration out of startTimeStamp and endTimeStamp.
     *
     * wrong values are negative startTimeStamp or negative difference
     * between endTimeStamp and startTimeStamp
     *
     * @return duration in millis. will be 0 in case of missing or wrong values
     */
    public long getTestDuration() {
        long testDuration = 0;
        if (startTimeStamp > 0 && endTimeStamp > startTimeStamp) {
            testDuration = endTimeStamp - startTimeStamp;
        }
        return testDuration;
    }

    public long getVerificationsProcessed() {
        return verificationsProcessed;
    }

    public void setVerificationsProcessed(long verificationsProcessed) {
        this.verificationsProcessed = verificationsProcessed;
    }

    /**
     * Increment verificationsProcessed by one.
     *
     * Convenience method to shortcut usage like this: setVerificationsProcessed(getVerificationsProcessed()+1)
     */
    public void incVerificationsProcessed() {
        this.verificationsProcessed++;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getSeleniumCoreVersion() {
        return seleniumCoreVersion;
    }

    public void setSeleniumCoreVersion(String seleniumCoreVersion) {
        this.seleniumCoreVersion = seleniumCoreVersion;
    }

    public String getSeleniumCoreRevision() {
        return seleniumCoreRevision;
    }

    public void setSeleniumCoreRevision(String seleniumCoreRevision) {
        this.seleniumCoreRevision = seleniumCoreRevision;
    }

    public String getSeleniumRcVersion() {
        return seleniumRcVersion;
    }

    public void setSeleniumRcVersion(String seleniumRcVersion) {
        this.seleniumRcVersion = seleniumRcVersion;
    }

    public String getSeleniumRcRevision() {
        return seleniumRcRevision;
    }

    public void setSeleniumRcRevision(String seleniumRcRevision) {
        this.seleniumRcRevision = seleniumRcRevision;
    }

    public String getLastFailedCommandMessage() {
        return lastFailedCommandMessage;
    }

    public void setLastFailedCommandMessage(String lastFailedCommandMessage) {
        this.lastFailedCommandMessage = lastFailedCommandMessage;
    }

    public String getLoggingSeleniumRevision() {
        return LOGGING_SELENIUM_REVISION.substring(REVISION_PREFIX_LENGTH, LOGGING_SELENIUM_REVISION.length() - 2);
    }

    public String[] getCommandsExcludedFromLogging() {
        return (String[]) ArrayUtils.clone(commandsExcludedFromLogging);
    }

    public void setCommandsExcludedFromLogging(String[] commandsExcludedFromLogging) {
        this.commandsExcludedFromLogging = (String[]) ArrayUtils.clone(commandsExcludedFromLogging);
    }
}
