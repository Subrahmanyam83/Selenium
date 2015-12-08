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
 * Utility Methods to support searching in StackStraces related to Selenium and the logging extension.
 * 
 * @author Robert Zimmermann
 * 
 * $Id: StackTraceUtils.java 52 2008-02-05 19:58:00Z bobbyde $
 */
public final class StackTraceUtils {

    /**
     * for the string representation of calling code.
     */
    public static final String LINE_NUMBER_SEPARATOR = "#";

    private StackTraceUtils() {
        // Static Class
    }

    /**
     * Debugs on stderr the current stack-trace.
     */
    public static void debugStackTrace() {
        StackTraceElement[] testElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : testElements) {
            System.err.println(stackTraceElementWithLinenumberAsString(stackTraceElement));
        }
    }

    /**
     * Generates a string representation of the current class with linenumber.
     * 
     * @param stackTraceElement to get class name and linenumber
     * @return string representation
     */
    public static String stackTraceElementWithLinenumberAsString(StackTraceElement stackTraceElement) {
        if (null != stackTraceElement) {
            return stackTraceElement.getClassName() + LINE_NUMBER_SEPARATOR + stackTraceElement.getLineNumber();
        } else {
            return "Internal ERROR stackTraceElement should not be null";
        }
    }

    /**
     * Compare Helper.
     * 
     * @param stackTraceElement search className here
     * @param wantedClassName search for this name
     * @return found or not
     */
    public static boolean isClassName(StackTraceElement stackTraceElement, String wantedClassName) {
        String className = stackTraceElement.getClassName();
        return className.contains(wantedClassName);
    }

    /**
     * Search through the current StackTrace looking for the first element after preceedingClassName.
     * 
     * @param testElements StackTrace Array to be searched in
     * @param preceedingClassName ClassName to be just before wanted element in the trace
     * @return element following preceedingClassName or preceedingClassName if no further element left. null if
     *         preceedingClassName wasn't there
     */
    public static StackTraceElement getCurrentCallingClassAsStackTraceElement(StackTraceElement[] testElements,
            String preceedingClassName) {
        boolean found = false;
        StackTraceElement currentCallingClassAsStackTraceElement = null;
        for (StackTraceElement stackTraceElement : testElements) {
            if (found) {
                currentCallingClassAsStackTraceElement = stackTraceElement;
                break;
            }
            if (StackTraceUtils.isClassName(stackTraceElement, preceedingClassName)) {
                found = true;
                currentCallingClassAsStackTraceElement = stackTraceElement;
            }
        }
        return currentCallingClassAsStackTraceElement;
    }

    /**
     * Is named class in StackTrace Array?
     * 
     * @param testElements StackTrace Array to be searched in
     * @param className ClassName to be searcher for
     * @return true if class seen in testElements false else
     */
    public static boolean isClassInStackTrace(StackTraceElement[] testElements, String className) {
        boolean result = false;
        for (StackTraceElement stackTraceElement : testElements) {
            if (stackTraceElement.getClassName().endsWith(className)) {
                result = true;
            }
        }
        return result;
    }
}
