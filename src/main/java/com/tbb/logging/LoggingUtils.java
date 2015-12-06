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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility Methods to support easy usage from an (junit4 driven) selenium test.
 * 
 * @author Robert Zimmermann
 * 
 * $Id: LoggingUtils.java 52 2008-02-05 19:58:00Z bobbyde $
 */
public final class LoggingUtils {

    private LoggingUtils() {
        // static class only
    }

    /**
     * Create an BufferedWriter handling encodings right. The writer is only created. Nothing will be written yet. Checks that the
     * file to be written is writeable. Replacing existing files is configurable. Closing the writer has to taken care of on the
     * caller side.
     * 
     * @param resultFileNameAndPath location and filename where to write later
     * @param resultEncoding any encoding supported by the used jdk. UTF-8 is recommended.
     * @param replaceExistingFile if true try to replace an already existing file.
     * @return BufferedWriter ready to be written to
     * @throws RuntimeException if file already exists or file cannot be written or if an IOException occurs during writer
     *         creation
     */
    public static BufferedWriter createWriter(final String resultFileNameAndPath, final String resultEncoding,
            boolean replaceExistingFile) throws RuntimeException {
        BufferedWriter loggingWriter = null;
        try {
            // check early if we can create and write to this file
            File resultFile = new File(resultFileNameAndPath);
            if (replaceExistingFile && resultFile.exists()) {
                resultFile.delete();
            }
            boolean newFileCreated = resultFile.createNewFile();
            if (!newFileCreated) {
                throw new RuntimeException("Failed to create new file: '"
                        + resultFileNameAndPath
                        + "'. Does this file already exist?");
            }
            // TODO: do we need this check? if the new file could be created previously we should be able to write to it
            if (!resultFile.canWrite()) {
                throw new RuntimeException("Cannot write to file: '" + resultFileNameAndPath + "'");
            }
            // http://www.jorendorff.com/articles/unicode/java.html
            loggingWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(resultFileNameAndPath), resultEncoding));
        } catch (IOException ioExc) {
            // try to close loggingWriter not needed as it could not be created here
            throw new RuntimeException("ERROR while creating file: '" + resultFileNameAndPath + "'", ioExc);
        }
        return loggingWriter;
    }

    /**
     * Create an BufferedWriter handling encodings right. The writer is only created. Nothing will be written yet. Checks that no
     * such file already exists and the file to be written is writeable. Closing the writer has to taken care of on the caller
     * side.
     * 
     * @param resultFileNameAndPath location and filename where to write later
     * @param resultEncoding any encoding supported by the used jdk. UTF-8 is recommended.
     * @return BufferedWriter ready to be written to
     * @throws RuntimeException if file already exists or file cannot be written or if an IOException occurs during writer
     *         creation
     * @deprecated use the 3 parameters version instead
     */
    @Deprecated
    public static BufferedWriter createWriter(final String resultFileNameAndPath, final String resultEncoding)
            throws RuntimeException {
        return createWriter(resultFileNameAndPath, resultEncoding, false);
    }

    /**
     * Current date-time as string with format "yyyy-MM-dd_HH-mm". Example result: 2007-12-28_12-28
     * 
     * @return fixed format "yyyy-MM-dd_HH-mm" date-time as string
     */
    public static String timeStampForFileName() {
        return timeStampForFileName("yyyy-MM-dd_HH-mm");
    }

    /**
     * Current date-time string with provided format.
     * 
     * @see SimpleDateFormat
     * @param simpleDateFormat string format to be used
     * @return date-time as string in given format
     */
    public static String timeStampForFileName(final String simpleDateFormat) {
        Date currentDateTime = new Date(System.currentTimeMillis());
        SimpleDateFormat humanReadableFormat = new SimpleDateFormat(simpleDateFormat);
        return humanReadableFormat.format(currentDateTime);
    }

    /**
     * Presets the args array with default values if the are absent. creates if necessary: - new array - default values for args
     * array as many as presetNumArgs TODO: there should be an utility method in eg. common.utils that does similar things
     * 
     * @param loggingBean args array to be taken from here
     * @param presetNumArgs number of array elements to be preset
     * @param defaultValue default value to be used for missing array elements
     * @return array containing previous values and filled with default ones - will be created if null previously
     */
    static String[] getCorrectedArgsArray(LoggingBean loggingBean, int presetNumArgs, String defaultValue) {
        String[] currentArgs;
        if (null == loggingBean || null == loggingBean.getArgs()) {
            currentArgs = new String[] {};
        } else {
            currentArgs = loggingBean.getArgs();
        }
        String[] newArgs = new String[presetNumArgs];
        for (int i = 0; i < currentArgs.length; i++) {
            newArgs[i] = currentArgs[i];
        }
        for (int i = currentArgs.length; i < presetNumArgs; i++) {
            newArgs[i] = defaultValue;
        }
        return newArgs;
    }
}
