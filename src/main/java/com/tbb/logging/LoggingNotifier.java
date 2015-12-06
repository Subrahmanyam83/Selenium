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

/**
 * Notification Interface for loggingselenium caller. If you are interested
 * in notifications then instantiate the interface and set the instance with
 * the setCallbackNotifier-function.
 *
 * @author ralf2511
 */
public interface LoggingNotifier {
    /**
     * Call back function to inform the calling application in case of error.
     * Then you can do additional logging or ring a bell or what ever you want.
     *
     * @param instance Instance of the calling application
     * @param commandName The selenium command name
     * @param args The Arguments of the selenium command
     * @param result The selenium Answer
     * @param exception The problem
     * @param cmdStartMillis Start time
     * @return True (default behavior): make screen shot after this call
     *   False: do not make a screen shot
     */
    Boolean errorLogging(Object instance, String commandName, String[] args, String result, Throwable exception,
            long cmdStartMillis);

    /**
     * Call back function to inform the calling application in case of error.
     * Then do can do your make your own screen shot in case of remote connection.
     *
     * @param instance Instance of the calling application
     * @param pathFile Full path and file to the resource
     * @return True (default behavior): make internal screen shot
     *   False: do not make a (additionally?!) screen shot
     */
    Boolean makeScreenshot(Object instance, String pathFile);

}
