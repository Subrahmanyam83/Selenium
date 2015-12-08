/*
 * Copyright 2008 united internet (unitedinternet.com) ralf2511
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

import com.thoughtworks.selenium.Wait;

/**
 * Extends the selenium wait class with error handling.
 *
 * @author ralf2511
 */
public abstract class LoggingWait extends Wait {
    private LoggingSelenium logging;

    /**
     * Create new wait instance.
     *
     * @param selenium Instance of LoggingSelenium to bail out exceptions
     */
    public LoggingWait(final LoggingSelenium selenium) {
        logging = selenium;
    }

    /**
     * {@inheritDoc}
     * Overrides the wait function and catch the timeout.
     */
    @Override
    public void wait(String message, long timeoutInMilliseconds, long intervalInMilliseconds) {
        try {
            super.wait(message, timeoutInMilliseconds, intervalInMilliseconds);
        } catch (WaitTimedOutException e) {
            if (null != logging) {
                logging.logAssertion("WaitTimedOutException" , e.getMessage(),
                        "Timeout after [msec]: " + Long.valueOf(timeoutInMilliseconds).toString());
            }
            throw e;
        }
    }

}
