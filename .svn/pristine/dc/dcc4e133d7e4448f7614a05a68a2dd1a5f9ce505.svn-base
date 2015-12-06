package com.tbb.framework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tbb.logging.LoggingCommandProcessor;
import com.tbb.logging.LoggingDefaultSelenium;
import com.tbb.logging.LoggingResultsFormatter;
import com.tbb.logging.LoggingSelenium;

/**
 * Utility class making it easy to write tests based on Selenium driver in a multi-thread context.
 *
 * @author Philippe Hanrigou
 */
public class ThreadSafeSeleniumSessionStorage {

    private final static Log LOGGER = LogFactory.getLog(ThreadSafeSeleniumSessionStorage.class);

    /**
     * Thread local Selenium driver instance so that we can run in multi-threaded mode.
     */
    private static final ThreadLocal<LoggingSelenium> threadLocalSelenium = new ThreadLocal<LoggingSelenium>();
    static LoggingSelenium selenium = null;


    public static void startSeleniumSession(String seleniumHost, int seleniumPort, String browser, String webSite, LoggingResultsFormatter htmlFormatter) {
        LOGGER.info("Contacting Selenium RC at " + seleniumHost + ":" + seleniumPort);
        LoggingCommandProcessor myProcessor = new LoggingCommandProcessor(seleniumHost, seleniumPort, browser, webSite, htmlFormatter);
		myProcessor.setExcludedCommands(new String[] {});

		selenium = new LoggingDefaultSelenium(myProcessor);
        threadLocalSelenium.set(selenium);
        
        
        
        session().start();
        LOGGER.info("Got Selenese session:" + session());
    }

    public static void closeSeleniumSession() {
        LOGGER.info("Closing Selenese session: " + session());
        if (null != session()) {
            session().stop();
            resetSession();
        }
    }

    public static LoggingSelenium session() {
        return threadLocalSelenium.get();
    }


    public static void resetSession() {
        threadLocalSelenium.set(null);
    }

}