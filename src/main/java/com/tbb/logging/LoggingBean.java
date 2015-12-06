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
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

/**
 * All data of a Selenium command already processed by remote-control and other informations to be formatted and logged.
 * 
 * @author Robert Zimmermann
 * 
 * $Id: LoggingBean.java 114 2008-05-02 13:10:44Z Steffen_K $
 */
public class LoggingBean {
    private String commandName = "";

    private String[] args;

    private String result = "";

    private String callingClass = "";

    private boolean commandSuccessful;

    private boolean waitInvolved;

    private long cmdStartMillis;

    private long cmdEndMillis;

    private String sourceMethod;

    private boolean excludeFromLogging = false;

    private long waitDeltaMillis = 0;

    private List<LoggingBean> children = new ArrayList<LoggingBean>();

    public void addChild(LoggingBean loggingBean) {
        children.add(loggingBean);
    }

    public List<LoggingBean> getChildren() {
        return children;
    }

    public boolean hasChildren() {
        return getChildren().size() > 0;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String[] getArgs() {
        return (String[]) ArrayUtils.clone(args);
    }

    public void setArgs(String[] args) {
        this.args = (String[]) ArrayUtils.clone(args);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCallingClass() {
        return callingClass;
    }

    public void setCallingClass(String callingClass) {
        this.callingClass = callingClass;
    }

    public boolean isCommandSuccessful() {
        return commandSuccessful;
    }

    public void setCommandSuccessful(boolean commandSuccessful) {
        this.commandSuccessful = commandSuccessful;
    }

    /**
     * Extract remote-control part out of combined result.
     * 
     * @return the remote-control part of the combined result
     */
    public String getSrcResult() {
        String[] results = this.result.split(",");
        String srcResult = "";
        if (results.length > 0) {
            srcResult = results[0];
        }
        return srcResult;
    }

    /**
     * Extract core part out of combined result.
     * 
     * @return the selenium-core part of the combined result
     */
    public String getSelResult() {
        int firstCommaIndex = this.result.indexOf(",");
        return this.result.substring(firstCommaIndex + 1);
    }

    /**
     * Do not rely on stability of this method. Subject to change in further releases.
     * 
     * @return commandName and its args as one String
     */
    @Override
    public String toString() {
        return "commandName=" + commandName + ", args=" + ArrayUtils.toString(args);
    }

    public long getCmdStartMillis() {
        return cmdStartMillis;
    }

    public void setCmdStartMillis(long cmdStartMillis) {
        this.cmdStartMillis = cmdStartMillis;
    }

    public long getCmdEndMillis() {
        return cmdEndMillis;
    }

    public void setCmdEndMillis(long cmdEndMillis) {
        this.cmdEndMillis = cmdEndMillis;
    }

    public boolean isWaitInvolved() {
        return waitInvolved;
    }

    public void setWaitInvolved(boolean waitInvolved) {
        this.waitInvolved = waitInvolved;
    }

    public String getSourceMethod() {
        return sourceMethod;
    }

    public void setSourceMethod(String sourceMethod) {
        this.sourceMethod = sourceMethod;
    }

    /**
     * Return time spent depending on type of command.
     * 
     * Current differentiation:
     * 
     * 1) inside Wait (wait's are combined into one event)
     * 
     * 2) how long on single command took
     * 
     * @return time (millis) spent for a command or summarized over all issued wait's
     */
    public long getDeltaMillis() {
        if (getWaitDeltaMillis() > 0) {
            return getWaitDeltaMillis();
        } else {
            return this.cmdEndMillis - this.cmdStartMillis;
        }
    }

    public boolean isExcludeFromLogging() {
        return excludeFromLogging;
    }

    public void setExcludeFromLogging(boolean excludeFromLogging) {
        this.excludeFromLogging = excludeFromLogging;
    }

    public long getWaitDeltaMillis() {
        return waitDeltaMillis;
    }

    public void setWaitDeltaMillis(long waitDeltaMillis) {
        this.waitDeltaMillis = waitDeltaMillis;
    }
}
