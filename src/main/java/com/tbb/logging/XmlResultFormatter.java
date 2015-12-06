/*
 * Copyright 2008 united internet (unitedinternet.com) Mirko Friedenhagen
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
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.XStream;

/**
 * Formats all logging events as XML.
 *
 * Alternate formatter for logging. Be sure to pass an encoding-aware writer
 * together with encoding name to the 2 parameters constuctor.
 *
 * @author Mirko Friedenhagen
 *
 */
public class XmlResultFormatter implements LoggingResultsFormatter {

    static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"%s\"?>\n";
    
    static final String ROOT_ELEMENT = "testResult";
    
    static final SimpleDateFormat FILENAME_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
    
    private Writer resultsWriter;

    private String resultFileEncoding = "ISO-8859-1";

    private XStream xstream;
    
    private String automaticScreenshotPath = ".";
    
    private String screenShotBaseUri = "";

    /**
     * Write results to the specified writer.
     * Note: encoding ISO-8859-1 is assumed
     *
     * It is recommended to use the 2-parameter constructor.
     *
     * @param myResultsWriter where results will be written in "ISO-8859-1" encoding
     */
    public XmlResultFormatter(Writer myResultsWriter) {
        resultsWriter = myResultsWriter;
        xstream = new XStream();
        xstream.alias("loggingBean", LoggingBean.class);
        xstream.alias("testMetricsBean", TestMetricsBean.class);
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
    public XmlResultFormatter(Writer myResultsWriter, String myResultFileEncoding) {
        this(myResultsWriter);
        resultFileEncoding = myResultFileEncoding;
    }

    /** {@inheritDoc} */
    public void booleanCommandLogEvent(LoggingBean loggingBean) {
    }

    /** {@inheritDoc} */
    public void commandLogEvent(LoggingBean loggingBean) {
        // commands are logged per method
    }

    /** {@inheritDoc} */
    public void commentLogEvent(LoggingBean loggingBean) {
        // commands are logged per method
    }

    /** {@inheritDoc} */
    public void methodLogEvent(LoggingBean loggingBean) {
        xstream.toXML(loggingBean, resultsWriter);
    }

    /** {@inheritDoc} */
    public void footerLogEvent() {
        logToWriter(String.format("</%s>\n", ROOT_ELEMENT));
    }

    /** {@inheritDoc} */
    public String generateFilenameForAutomaticScreenshot(String baseName) {
        final String constWaitTimeoutScreenshotFileName = "automatic" + baseName + "Screenshot" + timeStampForFileName() + ".png";
        return this.automaticScreenshotPath + File.separator + constWaitTimeoutScreenshotFileName;
    }

    /**
     * Generates a Date-Time String based on the current Time.
     * To be used for and in filenames.
     *
     * @return current date-time as string
     */
     String timeStampForFileName() {
        Date currentDateTime = new Date(System.currentTimeMillis());
        return FILENAME_DATETIME_FORMAT.format(currentDateTime);
    }

    /** {@inheritDoc} */
    public String getAutomaticScreenshotPath() {
        return automaticScreenshotPath;
    }

    /** {@inheritDoc} */
    public String getScreenShotBaseUri() {
        return screenShotBaseUri;
    }

    /** {@inheritDoc} */
    public void headerLogEvent(TestMetricsBean metricsBean) {
        logToWriter(String.format(XML_HEADER, resultFileEncoding));
        logToWriter(String.format("<%s>\n", ROOT_ELEMENT));
        xstream.toXML(metricsBean, resultsWriter);
        logToWriter("\n");
    }

    /**
     * @param message
     */
    void logToWriter(final String message) {
        try {
            resultsWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** {@inheritDoc} */
    public void setAutomaticScreenshotPath(String automaticScreenshotPath) {
        this.automaticScreenshotPath = new File(automaticScreenshotPath).getAbsolutePath();
    }

    /** {@inheritDoc} */
    public void setScreenShotBaseUri(String screenShotBaseUri) {
        this.screenShotBaseUri = screenShotBaseUri == null ? "" : screenShotBaseUri;
    }
}
