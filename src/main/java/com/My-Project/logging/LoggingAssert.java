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

import org.hamcrest.Matcher;

/**
 * Wrapped junit4 assertions to enable logging them.
 * 
 * Only a couple junit4 assertions are wrapped here. And these always expect a message (use null if you do not care)
 * 
 * TODO: use reflection proxy or AOP to get this working more smoothly
 * 
 * Maybe wrap also these? fail(String message), assertArrayEquals(String message, Object[] expecteds, Object[] actuals)
 * 
 * @author Robert Zimmermann
 * 
 * $Id: LoggingAssert.java 66 2008-02-11 22:27:05Z bobbyde $
 */
public final class LoggingAssert {

    private LoggingAssert() {
        // static class only
    }

    /**
     * As in Junit4 (see there for details).
     * 
     * Additionaly an selenium object is needed to enable logging.
     * 
     * @param message always needed - please provide a good description what may have been wrong
     * @param condition condition to be checked for true
     * @param selenium selenium object to be logged through
     */
    public static void assertTrue(java.lang.String message, boolean condition, LoggingSelenium selenium) {
        try {
            org.junit.Assert.assertTrue(message, condition);
        } catch (AssertionError e) {
            selenium.logAssertion("assertTrue", message, "condition=" + condition);
            throw e;
        }
    }

    /**
     * As in Junit4 (see there for details).
     * 
     * Additionaly an selenium object is needed to enable logging.
     * 
     * @param message always needed - please provide a good description what may have been wrong
     * @param condition condition to be checked for false
     * @param selenium selenium object to be logged through
     */
    public static void assertFalse(java.lang.String message, boolean condition, LoggingSelenium selenium) {
        try {
            org.junit.Assert.assertFalse(message, condition);
        } catch (AssertionError e) {
            selenium.logAssertion("assertFalse", message, "condition=" + condition);
            throw e;
        }
    }

    /**
     * As in Junit4 (see there for details).
     * 
     * Additionaly an selenium object is needed to enable logging.
     * 
     * @param message always needed - please provide a good description what may have been wrong
     * @param expected what is expected
     * @param actual what is to be checked for equality
     * @param selenium selenium object to be logged through
     */
    public static void assertEquals(java.lang.String message, Object expected, Object actual, LoggingSelenium selenium) {
        try {
            org.junit.Assert.assertEquals(message, expected, actual);
        } catch (AssertionError e) {
            selenium.logAssertion("assertEquals", message, "expected=" + expected + " actual=" + actual);
            throw e;
        }
    }

    /**
     * As in Junit4 (see there for details).
     * 
     * Additionaly an selenium object is needed to enable logging.
     * 
     * @param <T> see junit4 for details
     * @param message always needed - please provide a good description what may have been wrong
     * @param actual what is to be checked for equality
     * @param matcher see junit4 for details on possible matcher
     * @param selenium selenium object to be logged through
     */
    public static <T> void assertThat(java.lang.String message, T actual, Matcher<T> matcher, LoggingSelenium selenium) {
        try {
            org.junit.Assert.assertThat(message, actual, matcher);
        } catch (AssertionError e) {
            selenium.logAssertion("assertThat", message, e.getMessage());
            throw e;
        }
    }
}
