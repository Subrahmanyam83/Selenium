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

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Formats all logging events as HTML.
 * Trying to bring the Selenium TestRunner result look-and-feel to Junit.
 *
 * Default formatter for logging. Be sure to pass an encoding-aware writer
 * together with encoding name to the 2 parameters constuctor.
 *
 * @author Robert Zimmermann
 *
 * $Id: HtmlResultFormatter.java 135 2009-01-15 20:37:36Z bobbyde $
 */
public class HtmlResultFormatter implements LoggingResultsFormatter {
    String resultFileEncoding = "ISO-8859-1";

    static final int HTML_MAX_COLUMNS = 7;

    static final int SCREENSHOT_PREVIEW_HEIGHT = 200;

    static final int SCREENSHOT_PREVIEW_WIDHT = 200;

    static final String URL_PATH_SEPARATOR = "/";

    static final String CSS_CLASS_FAILED = "status_failed";

    static final String CSS_CLASS_PASSED = "status_passed";

    static final String CSS_CLASS_UNKNOWN = "status_maybefailed";

    static final String CSS_CLASS_DONE = "status_done";

    static final String CSS_CLASS_TITLE = "title";

    static final String TOOL_TIPP_MESSAGE_TIME_DELTA = "time delta reporting is alpha and subject to change";

    static final SimpleDateFormat LOGGING_DATETIME_FORMAT = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    static SimpleDateFormat FILENAME_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm");

    // design for testability: for easier mocking of eg windows paths on unix systems
    String localFsPathSeparator = File.separator;

    String screenShotBaseUri = "";

    String automaticScreenshotPath = ".";

    Writer resultsWriter = null;

    // customized copy from org.openqa.selenium.server.htmlrunner.HTMLTestResults
    static final String HTML_HEADER = "<html>\n"
            + "<head>"
            + "<meta content=\"text/html; charset={0}\" http-equiv=\"content-type\">"
            + "<meta content=\"cache-control\" http-equiv=\"no-cache\">"
            + "<meta content=\"pragma\" http-equiv=\"no-cache\">"
            + "<style type=\"text/css\">\n"
            + "body, table '{'\n"
            + "    font-family: Verdana, Arial, sans-serif;\n"
            + "    font-size: 12;\n"
            + "'}'\n"
            + "\n"
            + "table '{'\n"
            + "    border-collapse: collapse;\n"
            + "    border: 1px solid #ccc;\n"
            + "'}'\n"
            + "\n"
            + "th, td '{'\n"
            + "    padding-left: 0.3em;\n"
            + "    padding-right: 0.3em;\n"
            + "'}'\n"
            + "\n"
            + "a '{'\n"
            + "    text-decoration: none;\n"
            + "'}'\n"
            + "\n"
            + "."
            + CSS_CLASS_TITLE
            + " '{'\n"
            + "    font-style: italic;\n"
            + "'}'\n"
            + "\n"
            + ".selected '{'\n"
            + "    background-color: #99CCFF;\n"
            + "'}'\n"
            + "\n"
            + "."
            + CSS_CLASS_DONE
            + " '{'\n"
            + "    background-color: #FFFFCC;\n"
            + "'}'\n"
            + "\n"
            + "."
            + CSS_CLASS_PASSED
            + " '{'\n"
            + "    background-color: #7CCD7C;\n"
            + "'}'\n"
            + "\n"
            + "."
            + CSS_CLASS_FAILED
            + " '{'\n"
            + "    background-color: #FF6666;\n"
            + "'}'\n"
            + "\n"
            + "."
            + CSS_CLASS_UNKNOWN
            + " '{'\n"
            + "    background-color: #CC6699;\n"
            + "'}'\n"
            + "\n"
            + ".breakpoint '{'\n"
            + "    background-color: #cccccc;\n"
            + "    border: 1px solid black;\n"
            + "'}'\n"
            + "</style>\n"
            + "<title>Test results</title></head>\n"
            + "<body>\n"
            + " <span style=\"font-size:9px;font-family:arial,verdana,sans-serif;\">"
            //+ "HTML Logging Selenium-RC Tests"
            + "<table>"
            + "<tr>"
            + "<td><img src=\"../../../team-beach-body.gif\" alt=\"Team Beachbody\" /></td>"
            + "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>"
            + "<td align=\"center\"><img src=\"../../../xebia.jpg\" alt=\"Xebia\" /><br> Created by Xebia India</td>"
            + "</tr>"
            + "</table>"
            + "</span>"
            + "<h1>Team Beachbody Test results </h1>";
    
   
 


    static final String HTML_TABLE_HEADER = "<tr>"
            + "<td><b>Selenium-Command</b></td>"
            + "<td><b>Parameter-1</b></td>"
            + "<td><b>Parameter-2</b></td>"
            + "<td><b>Res.RC</b></td>"
            + "<td><b>Res.Selenium</b></td>"
            + "<td><b>Time [ms]</b></td>"
            + "<td><b>Calling-Class with Linenumber</b></td>"
            + "</tr>\n";

    static final String HTML_METRICS = "<table>\n"
            + "<tr><td>user-agent:</td><td>{0}</td></tr>\n"
           // + "<tr><td>selenium-rc:</td><td> v{1} [{2}]</td></tr>\n"
          //  + "<tr><td>selenium-core:</td><td> v{3} [{4}]</td></tr>\n"
            + "<tr><td>LoggingSelenium:</td><td> revision [{5}]</td></tr>\n"
            + "<tr><td>test-started:</td><td>{6}</td></tr>\n"
            + "<tr><td>test-finished:</td><td>{7}</td></tr>\n"
            + "<tr><td>test-duration [ms]:</td><td>{8}</td></tr>\n"
            + "<tr><td>commands processed:</td><td>{9}</td></tr>\n"
            + "<tr><td>verifications processed:</td><td>{10}</td></tr>\n"
            + "{11}\n"
            + "<tr><td>commands not logged:</td><td>{12}</td></tr>\n"
            + "</table>\n";

    static final String HTML_COMMENT = "<tr class=\"{0}\"><td colspan=\"{1}\">{2}</td></tr>\n";

    static final String HTML_FOOTER = "</tbody></table></body></html>";

    static final String HTML_SPECIAL = "<span style=\"font-size:9px;font-family:arial,verdana,sans-serif;\">" + "{0}</span>";

    static final String HTML_SCREENSHOT_ROW = "<tr class=\"{0}\">"
            + "<td colspan=\"{1}\" valign=\"center\" align=\"center\" halign=\"center\">{2}</td>"
            + "<td>{3}</td>"
            + "<td>{4}</td>"
            + "</tr>\n";

    static final String HTML_SCREENSHOT_IMG = "<a href=\"{0}\">"
            + "<img src=\"{1}\" width=\"{2}\" height=\"{3}\""
            + " alt=\"Selenium Screenshot\""
            + " title=\"Selenium Screenshot\"/>"
            + "<br/>{4}</a>";

    static final String HTML_EMPTY_COLUMN = "<td>&nbsp;</td>";

    /**
     * Write results to the specified writer.
     * Note: encoding ISO-8859-1 is assumed
     *
     * It is recommended to use the 2-parameter constructor.
     *
     * @param myResultsWriter where results will be written in "ISO-8859-1" encoding
     */
    public HtmlResultFormatter(Writer myResultsWriter) {
        this.resultsWriter = myResultsWriter;
    }

    /**
     * Write results with an arbitrary encoding.
     * Be sure to create the writer with the correct encoding
     * Note: resultFileEncoding is only used to set a corresponding meta-tag in the resulting HTML-file
     *
     * For Example:
     * <code>new BufferedWriter(new OutputStreamWriter(new FileOutputStream("myResultFile.html"),
     *              "UTF-8")</code>
     *
     * @param myResultsWriter writer with resultFileEncoding set. See also Example above
     * @param myResultFileEncoding any encoding supported by the running jvm
     */
    public HtmlResultFormatter(Writer myResultsWriter, String myResultFileEncoding) {
        this.resultsWriter = myResultsWriter;
        this.resultFileEncoding = myResultFileEncoding;
    }

    /**
     * {@inheritDoc}
     */
    public void commentLogEvent(LoggingBean loggingBean) {
        String[] loggingBeanArgs = LoggingUtils.getCorrectedArgsArray(loggingBean, 2, "");
        String commentToBeLogged = loggingBeanArgs[0];
        String additionalInformation = loggingBeanArgs[1];
        logToWriter(MessageFormat.format(HTML_COMMENT, CSS_CLASS_TITLE, HTML_MAX_COLUMNS, commentToBeLogged
                + extraInformationLogEvent(additionalInformation)));
    }

    String formatMetrics(TestMetricsBean metrics) {
        String failedCommandsRow = "";
        if (metrics.getFailedCommands() > 0) {
            failedCommandsRow = "<tr class=\""
                    + CSS_CLASS_FAILED
                    + "\"><td>failed commands:</td><td>"
                    + metrics.getFailedCommands()
                    + "</td></tr>\n";
            if (StringUtils.isNotBlank(metrics.getLastFailedCommandMessage())) {
                failedCommandsRow = failedCommandsRow
                        + "<tr class=\""
                        + CSS_CLASS_FAILED
                        + "\"><td>last failed message:</td><td>"
                        + metrics.getLastFailedCommandMessage()
                        + "</td></tr>\n";
            } else {
                System.err.println("WARNING: NO LastFailedCommandMessage");
            }
        }
        return MessageFormat.format(HTML_METRICS, metrics.getUserAgent(), metrics.getSeleniumRcVersion(), metrics
                .getSeleniumRcRevision(), metrics.getSeleniumCoreVersion(), metrics.getSeleniumCoreRevision(), metrics
                .getLoggingSeleniumRevision(), LOGGING_DATETIME_FORMAT.format(metrics.getStartTimeStamp()),
                LOGGING_DATETIME_FORMAT.format(metrics.getEndTimeStamp()), metrics.getTestDuration(), metrics
                        .getCommandsProcessed(), metrics.getVerificationsProcessed(), failedCommandsRow, ArrayUtils
                        .toString(metrics.getCommandsExcludedFromLogging()));
    }

    /**
     * {@inheritDoc}
     */
    public void headerLogEvent(TestMetricsBean metrics) {
        logToWriter(formatHeader(metrics));
    }

    String formatHeader(TestMetricsBean metrics) {
        String header = MessageFormat.format(HTML_HEADER, resultFileEncoding)
                + "\n"
                + formatMetrics(metrics)
                + "<table border=\"1\"><tbody>"
                + HTML_TABLE_HEADER;
        return header;
    }

    /**
     * {@inheritDoc}
     */
    public void footerLogEvent() {
        logToWriter(HTML_FOOTER);
    }

    String extraInformationLogEvent(String extraInformation) {
        String result = "";
        if (null != extraInformation) {
            result = MessageFormat.format(HTML_SPECIAL, extraInformation);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public void commandLogEvent(LoggingBean loggingBean) {
        if (!loggingBean.isExcludeFromLogging()) {
            String resultClass = loggingBean.isCommandSuccessful() ? CSS_CLASS_DONE : CSS_CLASS_FAILED;
            if ("captureScreenshot".equals(loggingBean.getCommandName())) {
                logToWriter(formatScreenshot(loggingBean, resultClass));
            } else {
                logToWriter(formatCommandAsHtml(loggingBean, resultClass, ""));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void booleanCommandLogEvent(LoggingBean loggingBean) {
        String toolTippMessage = "";
        String resultClass = "";
        if (loggingBean.isCommandSuccessful()) {
            resultClass = CSS_CLASS_PASSED;
        } else {
            resultClass = CSS_CLASS_UNKNOWN;
            toolTippMessage = "How this &quot;false&quot; result from Selenium"
                    + " is treated by the test cannot be determined here.";
        }
        logToWriter(formatCommandAsHtml(loggingBean, resultClass, toolTippMessage));
    }

    /**
     * {@inheritDoc}
     */
    public String getScreenShotBaseUri() {
        return screenShotBaseUri;
    }

    /**
     * {@inheritDoc}
     */
    public void setScreenShotBaseUri(String screenShotBaseUri) {
        this.screenShotBaseUri = screenShotBaseUri == null ? "" : screenShotBaseUri;
    }

    /**
     * {@inheritDoc}
     */
    public String generateFilenameForAutomaticScreenshot(String baseName) {
        final String constWaitTimeoutScreenshotFileName = "automatic" + baseName + "Screenshot" + timeStampForFileName() + ".png";
        return this.automaticScreenshotPath + localFsPathSeparator + constWaitTimeoutScreenshotFileName;

    }

    /**
     * {@inheritDoc}
     */
    public String getAutomaticScreenshotPath() {
        return this.automaticScreenshotPath;
    }

    /**
     * Automatic screenshots are taken if a Wait-timeout is detected.
     * Default location is current working dir (".") If another
     * (filesystem-)location is desired use this setter.
     *
     * {@inheritDoc}
     */
    public void setAutomaticScreenshotPath(String automaticScreenshotPath) {
        this.automaticScreenshotPath = new File(automaticScreenshotPath).getAbsolutePath();
    }

    String formatScreenshot(LoggingBean loggingBean, String resultClass) {
        // if screenshot could not be written there should be something like a SeleniumException
        return MessageFormat.format(HTML_SCREENSHOT_ROW, resultClass, HTML_MAX_COLUMNS - 2,
                formatScreenshotFileImgTag(loggingBean.getArgs()[0]), +loggingBean.getDeltaMillis(), loggingBean
                        .getCallingClass());
    }

    /**
     * Format img HTML tag.
     * Link has to be relative on any system
     *
     * @param absFsPathToScreenshot Absolute path to saved screenshot on the local filesystem
     * @return formatted HTML img tag
     */
    String formatScreenshotFileImgTag(String absFsPathToScreenshot) {
        String screenshotRelativeUrl;
        String screenshotPathNormalized = absFsPathToScreenshot.replace(localFsPathSeparator, URL_PATH_SEPARATOR);
        String screenShotName = screenshotPathNormalized.substring(screenshotPathNormalized.lastIndexOf(URL_PATH_SEPARATOR)
                + URL_PATH_SEPARATOR.length());

        if ("".equals(this.screenShotBaseUri)) {
            screenshotRelativeUrl = screenShotName;
        } else {
            screenshotRelativeUrl = this.screenShotBaseUri.endsWith("/") ? this.screenShotBaseUri + screenShotName
                    : this.screenShotBaseUri + URL_PATH_SEPARATOR + screenShotName;
        }
        return MessageFormat.format(HTML_SCREENSHOT_IMG, screenshotRelativeUrl, screenshotRelativeUrl, SCREENSHOT_PREVIEW_WIDHT,
                SCREENSHOT_PREVIEW_HEIGHT, screenShotName);
    }

    String formatCommandAsHtml(LoggingBean loggingBean, String resultClass, String toolTippMessage) {
        StringBuilder htmlWrappedCommand = new StringBuilder();
        htmlWrappedCommand.append("<tr class=\""
                + resultClass
                + "\" title=\""
                + toolTippMessage
                + "\" alt=\""
                + toolTippMessage
                + "\">"
                + "<td>"
                + quoteHtml(loggingBean.getCommandName())
                + "</td>");
        int writtenColumns = 0;
        if (loggingBean.getArgs() != null) {
            for (int i = 0; i < loggingBean.getArgs().length; i++) {
                writtenColumns++;
                htmlWrappedCommand.append("<td>" + quoteHtml(loggingBean.getArgs()[i]) + "</td>");
            }
        }
        // put empty columns if parameters are missing
        htmlWrappedCommand.append(generateEmptyColumns(HTML_MAX_COLUMNS - writtenColumns - (HTML_MAX_COLUMNS - 2)));

        htmlWrappedCommand.append("<td>"
                + quoteHtml(loggingBean.getSrcResult())
                + "</td><td>"
                + quoteHtml(loggingBean.getSelResult())
                + "</td><td title=\""
                + TOOL_TIPP_MESSAGE_TIME_DELTA
                + "\" alt=\""
                + TOOL_TIPP_MESSAGE_TIME_DELTA
                + "\">"
                + loggingBean.getDeltaMillis()
                + "</td><td>"
                + loggingBean.getCallingClass()
                + "</td></tr>\n");
        return htmlWrappedCommand.toString();
    }

    void logToWriter(final String formattedLogEvent) {
        try {
            this.resultsWriter.write(formattedLogEvent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generate empty HTML columns.
     *
     * @param numColsToGenerate num of columns to be generated
     * @return generated, empty columns in one string
     */
    public static final String generateEmptyColumns(final int numColsToGenerate) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numColsToGenerate; i++) {
            result.append(HTML_EMPTY_COLUMN);
        }
        return result.toString();
    }

    /**
     * Generates a Date-Time String based on the current Time.
     * To be used for and in filenames.
     *
     * TODO: maybe place this in LoggingUtils
     *
     * @return current date-time as string
     */
    public static final String timeStampForFileName() {
        Date currentDateTime = new Date(System.currentTimeMillis());
        return FILENAME_DATETIME_FORMAT.format(currentDateTime);
    }

    /**
     * {@inheritDoc}
     */
    public void methodLogEvent(LoggingBean loggingBean) {
    }

    public static final String quoteHtml(String unquoted) {
       String quoted = unquoted == null ? "" : unquoted;
       quoted = quoted.replace("&", "&amp;");
       quoted = quoted.replace("<", "&lt;");
       quoted = quoted.replace(">", "&gt;");
       return quoted;
    }

    public static SimpleDateFormat getFILENAME_DATETIME_FORMAT() {
        return FILENAME_DATETIME_FORMAT;
    }

    public static void setFILENAME_DATETIME_FORMAT(SimpleDateFormat newFormat) {
        FILENAME_DATETIME_FORMAT = newFormat;
    }
}
