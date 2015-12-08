/*
 * Copyright 2008 Robert Zimmermann
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

/**
 * Special logging commands to extend CommandProcessor of Selenium.
 *
 * @author Robert Zimmermann
 *
 * $Id: SeleniumCommandExtensions.java 111 2008-04-18 15:21:02Z ralf2511 $
 */
public enum SeleniumCommandExtensions {
    // TODO: adjust eclipse code formatter to keep enum element each on one line
    COMMAND_EXTENSION_LOG_COMMENT("X-1and1-logComment"),
    COMMAND_EXTENSION_LOG_AUTO_SCREENSHOT("X-1and1-logAutoScreenshot"),
    COMMAND_EXTENSION_LOG_ASSERTION("X-1and1-logAssertion"),
    COMMAND_EXTENSION_LOG_RESOURCE("X-1and1-logResource");

    private String name;

    private SeleniumCommandExtensions(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }
}
