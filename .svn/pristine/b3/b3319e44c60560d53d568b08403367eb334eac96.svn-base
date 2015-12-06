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

import com.thoughtworks.selenium.Selenium;

/**
 * Extends Selenium with ability to log comments and write the log.
 *
 * @author Robert Zimmermann
 *
 * $Id: LoggingSelenium.java 111 2008-04-18 15:21:02Z ralf2511 $
 */
public interface LoggingSelenium extends Selenium {
    /**
     * Extension of Selenium to provide ability to log comments.
     *
     * @param comment the comment to be handled by the used formatter
     */
    void logComment(final String comment);

    /**
     * Take a screen shot and write the location to the log.
     *
     * Will be used in case of an error (thrown exception).
     *
     * @param baseName middle part of the generated filename. can be extended (with e.g. a timestamp) by the used
     *        LoggingResultsFormatter.
     */
    void logAutomaticScreenshot(final String baseName);

    /**
     * Log an assertion.
     *
     * Needed by LoggingAssert class, which wraps junit4 assertions.
     *
     * @param assertionName Name of the thrown assertion
     * @param assertionMessage Message of the thrown assertion
     * @param assertionCondition Failed condition which led to this assertion.
     */
    void logAssertion(final String assertionName, final String assertionMessage, final String assertionCondition);

    /**
     * Log an resource (binary) file. Normally use in case of error to add
     * screen shot or more informations about test conditions to the log.
     *
     * @param description A text that describes the reource
     * @param pathFile Full path and file to the resource
     */
    void logResource(final String description, final String pathFile);
    
    
    void click(String locator);
    boolean waitForElementPresent(String locator);
    boolean waitForTextPresent(String text);
    boolean waitForTextNotPresent(String text);
    boolean waitForEitherTextPresent(String text1, String text2);
    boolean isElementPresent(String locator);

	void type(String locator);
}
