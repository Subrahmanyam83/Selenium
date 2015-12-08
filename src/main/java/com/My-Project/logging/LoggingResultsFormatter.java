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

/**
 * The LoggingResultFormatter can be used to log in any format you want to.
 * 
 * The formatter is responsible for writing results.
 * 
 * Also the formatter is resposible for handling encodings right for whatever output storage is used.
 * 
 * Currently there is an HtmlResultFormatter implemented. There could also be an CSVFormatter, DatabaseFormatter or whatever you
 * want the log to look like.
 * 
 * @author Robert Zimmermann
 * 
 * $Id: LoggingResultsFormatter.java 116 2008-05-02 13:43:44Z Steffen_K $
 */
public interface LoggingResultsFormatter {
    /**
     * Format a comment.
     * 
     * Comments may be issued between commands by the loggingCommandProcessor, like a new method has been entered by the test.
     * 
     * @param loggingBean loggingBean containing the comment to be logged.
     */
    void commentLogEvent(LoggingBean loggingBean);

    /**
     * Formats an selenium command.
     * 
     * @param loggingBean containing all informations for logging a selenium command
     */
    void commandLogEvent(LoggingBean loggingBean);

    /**
     * Formats an selenium command which has an boolean result.
     * 
     * Important: At this state no information whether an false or true result was or is expected by the test using this
     * formatter. So an false result may be "green" for the test. Therefore all log-events here are logged as green.
     * 
     * e.g. selenium commands like isElementPresent
     * 
     * @param loggingBean containing all informations for logging a selenium command
     */
    void booleanCommandLogEvent(LoggingBean loggingBean);

    /**
     * Formats a Log Event for a complete Test Method.
     * 
     * The Logging Bean may contain several child beans holding the information of the single selenium commands.
     * 
     * @param loggingBean containing all informations for logging a test method and its commands
     */
    void methodLogEvent(LoggingBean loggingBean);
    
    /**
     * Whatever the formatter wants to do before any command will be formatted.
     * 
     * @param metricsBean metrics gathered during test-run
     */
    void headerLogEvent(TestMetricsBean metricsBean);

    /**
     * Like formatHeader() but here after all commands have been formatted.
     */
    void footerLogEvent();

    /**
     * Base URI to be linked to in the result.
     * 
     * Screenshots may be linked with an http or similar prefix to be easier accessible in whatever reporting frontend is used
     * later
     * 
     * @return the current base-uri for screenshots
     */
    String getScreenShotBaseUri();

    /**
     * Set a special uri for screenshots.
     * 
     * @param screenShotBaseUri the new uri for screenshots
     */
    void setScreenShotBaseUri(String screenShotBaseUri);

    /**
     * Generate an absolute filename for taking screenshots in case of an error (eg. timed out wait).
     * 
     * @param baseName middle part of the name to be enhanced by whatever the implementation wants to
     * @return absolute path for screenshot to be taken
     */
    String generateFilenameForAutomaticScreenshot(String baseName);

    /**
     * Path to the (filesystem-)location where screenshot should be saved. Will be used by
     * generateFilenameForAutomaticScreenshot()
     * 
     * @return current location path
     */
    String getAutomaticScreenshotPath();

    /**
     * Path to the (filesystem-)location where screenshot should be saved. Will be used by
     * generateFilenameForAutomaticScreenshot()
     * 
     * @param automaticScreenshotPath location (only path) to where screenshots should be saved
     */
    void setAutomaticScreenshotPath(String automaticScreenshotPath);
}
