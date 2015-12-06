package com.tbb.framework;


import static com.tbb.framework.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.tbb.framework.ThreadSafeSeleniumSessionStorage.session;
import static com.tbb.framework.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.tbb.constants.TestConsts;
import com.tbb.logging.HtmlResultFormatter;
import com.tbb.logging.LoggingCommandProcessor;
import com.tbb.logging.LoggingDefaultSelenium;
import com.tbb.logging.LoggingResultsFormatter;
import com.tbb.logging.LoggingSelenium;
import com.tbb.logging.LoggingUtils;
import com.thoughtworks.selenium.SeleniumException;



/**
 * This class defines the basic common attributes of a test class. All test
 * classes will be extend this class. It provides selenium capability
 * (Running/stopping selenium server, initiating / closing selenium instance) to
 * its sub-classes along with access to Log4J object.
 * 
 * @author xebia
 * 
 */
public class BaseTest {

	public static int signInCount = 0;
	static StringBuilder messages;
	protected static SeleniumServer server;
	protected static String testName;
	
	protected static long start_time;
	static boolean failedRetry;
	static int failedRetryTimes = 0;
	static int passed_test = 0, failed_test = 0, skip_test = 0;
	static int total_test_in_current_suite = 0;
	static int stringNumberGen = 0;
	
	public static String highlightingEnabled = ConfigFileReader.getConfigItemValue("selenium.highlight");
	public static String takeFrequentScreenshots = ConfigFileReader.getConfigItemValue("selenium.takeFrequentScreenshots");
	
	public String assertionMode = ConfigFileReader.getConfigItemValue("testng.assertion.mode");
	
	// New Variables used at the time of parallel execution
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	SimpleDateFormat FILENAME_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	public String currentTimeStamp = currentDate();  // This method needs a Date format so DATE_FORMAT
	public String resultHtmlFileName;
	public String relativeResultHtmlFileName;
	//protected String RESULTS_BASE_PATH = "results" + File.separator	+ currentTimeStamp + "_" + generateRandomString() + File.separator + "SeleniumLogs";
	protected String RESULTS_BASE_PATH = ConfigFileReader.getConfigItemValue("resultspath") + File.separator + "results" + File.separator	+ currentTimeStamp + "_" + generateRandomString();
	LoggingResultsFormatter htmlFormatter = null;
	BufferedWriter loggingWriter =  null;
	public static String currentScreenShotPath;
	
	boolean lastTestMethodResult = true;
	
	protected LoggingSelenium selenium = null;
    public static final String TIMEOUT = "120000";
	protected static final Logger logger = Logger.getLogger(BaseTest.class);
	static {
		DOMConfigurator.configure("src/test/java/resources/config/log4j.xml");
	}
	
	/**
	 * This method sets escape-output property to false so that we can insert html logs into TestNG reports.
	 */
	@BeforeClass
	public void setUpTestClass() {
		System.setProperty("org.uncommons.reportng.escape-output","false");
		
	}

	/**
	 * IMPORTANT: THIS METHOD IS SPECIFIC TO SELENIUM-GRID EXECUTION. SO UNCOMMENT @BeforeMethod LINE when using for that purpose
	 * This method gets executed before every @Test method and calls startSeleniumSession method of ThreadSafeSeleniumSessionStorage class which is responsible for starting parallel sessions of LoggingSelenium.
	 * We are passing an object of resultFormatter also which is needed to create an object of  LoggingSelenium.
	 * @throws Exception
	 */
    //@BeforeMethod(groups = {"default", "example"}, alwaysRun = true)
	
	
	
    protected void startSession() throws Exception 
    {
        /*startSeleniumSession("localhost", 4444, "*chrome",
        	"http://www.abc.com", LoggingResultsFormatter);
        selenium = session();*/
        
        selenium.setTimeout(TIMEOUT);
        selenium.open("/");
		selenium.windowFocus();
		selenium.windowMaximize();
    }

    /**
     * This method gets executed after every @Test method and it calls closeSeleniumSession method of ThreadSafeSeleniumSessionStorage class.
     * It closes loggingwrite object also so that Selenium Log file gets generated and closed in a correct manner.
     * @throws Exception
     */
    //@AfterMethod(groups = {"default", "example"}, alwaysRun = true)
    protected void closeSession() throws Exception {
    	
        closeSeleniumSession();
        closeSeleniumLogFile();
    }
    
	/**
	 * This method just provides object of LoggingResultsFormatter which is needed to create instance of LoggingSelenium class.
	 * @return Instance of LoggingResultsFormatter
	 */
    public LoggingResultsFormatter createResultFormatter() {

		try {
			final String RESULT_FILE_ENCODING = "UTF-8";
			final String SCREENSHOT_PATH = "screenshots";

	
			String resultsPath = new File(RESULTS_BASE_PATH).getAbsolutePath();
			String screenshotsResultsPath = new File(RESULTS_BASE_PATH + File.separator + SCREENSHOT_PATH).getAbsolutePath();
		

			if (!new File(resultsPath).exists()) {
				new File(resultsPath).mkdirs();
			}
			if (!new File(screenshotsResultsPath).exists()) {
				new File(screenshotsResultsPath).mkdirs();
			}
	
			resultHtmlFileName = resultsPath + File.separator + "report_" + timeStampForFileName() + ".html";
			System.err.println("resultHtmlFileName=" + resultHtmlFileName);
			loggingWriter = LoggingUtils.createWriter(resultHtmlFileName, RESULT_FILE_ENCODING, true);

			htmlFormatter = new HtmlResultFormatter(loggingWriter, RESULT_FILE_ENCODING);

			htmlFormatter.setScreenShotBaseUri(SCREENSHOT_PATH + "/");

			htmlFormatter.setAutomaticScreenshotPath(screenshotsResultsPath);
		} catch (SeleniumException ex) {
			
			
		}

		return htmlFormatter;
	}
	
	
	
	
	/**
	 * This method returns a LoggingSelenium instance. Launches the browser with a new
	 * Selenium session. Use this only if you want to have one selenium
	 * instance.
	 * 
	 * @return Selenium session
	 */

	public LoggingSelenium createDefaultSeleniumInstance(String browser,
			String url) {

		boolean quit = false;
		// if (selenium == null) {
		try {
			final String RESULT_FILE_ENCODING = "UTF-8";
			final String SCREENSHOT_PATH = "screenshots";

			String resultsPath = new File(RESULTS_BASE_PATH).getAbsolutePath();
			String screenshotsResultsPath = new File(RESULTS_BASE_PATH
					+ File.separator + SCREENSHOT_PATH).getAbsolutePath();

			if (!new File(resultsPath).exists()) {
				new File(resultsPath).mkdirs();
			}
			if (!new File(screenshotsResultsPath).exists()) {
				new File(screenshotsResultsPath).mkdirs();
			}
			
			currentScreenShotPath = screenshotsResultsPath;
	
			String partialFileName =  File.separator + testName
			+ "report_" + timeStampForFileName() + ".html";
			
			resultHtmlFileName = resultsPath + partialFileName;
			relativeResultHtmlFileName = RESULTS_BASE_PATH + partialFileName;
			
			
			System.err.println("resultHtmlFileName=" + resultHtmlFileName);
			loggingWriter = LoggingUtils.createWriter(resultHtmlFileName,
					RESULT_FILE_ENCODING, true);

			LoggingResultsFormatter htmlFormatter = new HtmlResultFormatter(
					loggingWriter, RESULT_FILE_ENCODING);

			htmlFormatter.setScreenShotBaseUri(SCREENSHOT_PATH + "/");
			htmlFormatter.setAutomaticScreenshotPath(screenshotsResultsPath);
			LoggingCommandProcessor myProcessor = new LoggingCommandProcessor(
					ConfigFileReader.getConfigItemValue("selenium.server.host"), 4444, browser , url, htmlFormatter);
			myProcessor.setExcludedCommands(new String[] {"captureEntirePageScreenshotToString", "captureScreenshot"});
			selenium = new LoggingDefaultSelenium(myProcessor);

/*			RemoteControlConfiguration rcc = server.getConfiguration();
			File profileLocation = new File(ConfigFileReader.getConfigItemValue("selenium.firefox.profile"));
			rcc.setProfilesLocation(profileLocation);
			rcc.setFirefoxProfileTemplate(profileLocation);
			rcc.setReuseBrowserSessions(true);
			selenium.start(rcc);
			
			BrowserConfigurationOptions bb = new BrowserConfigurationOptions();
			bb.setProfile(profile)*/
			selenium.start();

			selenium.setSpeed(ConfigFileReader.getConfigItemValue("selenium.speed"));
			selenium.setTimeout("120000");
			//selenium.deleteAllVisibleCookies();
			
			try {
				selenium.open(url);
			}catch(Exception e) {
				//selenium.refresh();
				selenium.waitForElementPresent("css=a:contains('Sign In')");
				
			}
					
			//selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
			selenium.waitForElementPresent("css=a:contains('Sign In')");
			selenium.windowMaximize();
			selenium.windowFocus();
			

	

		} catch (SeleniumException ex) {
			logger.error(ex.getMessage());
			quit = true;
			// }
		}
		if (quit) {
			stopSeleniumInstance();
			System.exit(0);
		}

		return selenium;
	}

	/**
	 * This method calls close method on BufferedWriter's instance so that LoggingSelenium log file can be generated.
	 * 
	 * @throws Exception
	 */
	public void closeSeleniumLogFile() {

		try {
			if (null != loggingWriter) {
				loggingWriter.close();
				loggingWriter = null;
			}
		} catch (IOException e) {
			// do nothing
		}

	}
	
	/**
	 * This method stops LoggingSelenium session and sets its instance to null.
	 */
	public void stopSeleniumInstance() {
		// Comment these lines just for UrgentWowyTest 
		/*logger.info("Taking screen shot before closing selenium instance");
		if (lastTestMethodResult == true) captureScreenShot(selenium, currentScreenShotPath);*/

		try {
	
		logger.info("Clicking on 'Sign Out' if not signed out");
		//if(selenium.isElementPresent("css=a:contains(Sign Out)")) {
		if(selenium.isTextPresent("Sign Out")) {
			selenium.click("css=a:contains(Sign Out)");
			selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		}
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
		
		logger.info("Setting sign  in count to 0");
		signInCount = 0;
		
		try {
			logger.info("Stopping selenium session");
			selenium.stop();
			logger.info("Setting selenium Instance as null");
			selenium = null;

			if (null != loggingWriter) {
				loggingWriter.close();
				loggingWriter = null;
			}
		} catch (Exception e) {
			// do nothing
		}
	}
	
	
	/**
	 * This method stops selenium server and sets its instance to null.
	 */
	public void stopSeleniumServer() {
		try {
			logger.info("Stopping selenium server");
			server.stop();
			logger.info("Setting selenium server as null");
			server = null;

		} catch (Exception e) {
			// do nothing
		}
	}



	// @BeforeSuite
	public void abs1(ITestContext context) {
		int total_test_in_current_suite = context.getAllTestMethods().length;
		logger.info("Total Test Method To Run in '"
				+ context.getSuite().getName() + "' Test Suite :: "
				+ total_test_in_current_suite);
		int time_remaining = total_test_in_current_suite * 5;
		logger.info("Expected time to finish :: " + time_remaining + " mins");
		start_time = System.currentTimeMillis();

	}

	/**
	 * Method to start selenium server
	 * 
	 * @author Gaurav Bansal
	 * 
	 * 
	 */
	public void startSeleniumServer() {
		logger.info("Starting Selenium Server.........This might take around 10-15 seconds.");
		RemoteControlConfiguration rcc = new RemoteControlConfiguration();
		rcc.setPort(4444);
		rcc.setTimeoutInSeconds(600);
		rcc.setSingleWindow(false);
		
		rcc.setFirefoxProfileTemplate(new File(ConfigFileReader.getConfigItemValue("selenium.firefox.profile")));
		//rcc.setAvoidProxy(true);
		rcc.setTrustAllSSLCertificates(true);

			
		try {
			server = new SeleniumServer(false, rcc);
			server.boot();
			

		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info("Server is already running so reusing that.....");
		}
	}

	/**
	 * This method creates LoggingSelenium Instance by calling  createDefaultSeleniumInstance method.
	 * @param method
	 * @return
	 */
	public LoggingSelenium createSeleniumInstance(Method method) {
		// public LoggingSelenium createSeleniumInstance() {
		testName = method.getName();
		return createDefaultSeleniumInstance(
				ConfigFileReader.getConfigItemValue("selenium.browser"), "http://"
						+ ConfigFileReader.getConfigItemValue("application.url"));
	}

	
	/**
	 * This method stops Selenium Instance, Selenium Server and closes Selenium Logging file object.
	 */
	public void tearDown() {
		logger.info("Stopping Selenium session and selenium server");
		try {
			stopSeleniumInstance();
	//		stopSeleniumServer();
			closeSeleniumLogFile();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This methods logs test statistics after every test method.
	 * @param context
	 * @param result
	 */
	public void testStatistics(ITestContext context, ITestResult result) {
		logger.info(result.getName() + "   " + result.getStatus());
		total_test_in_current_suite = context.getAllTestMethods().length;
		skip_test = context.getSkippedTests().size();
		/*
		 * int passed_test = context.getPassedTests().size(); int failed_test =
		 * context.getFailedTests().size();
		 */

		int testResult = result.getStatus();
		switch (testResult) {
		case 1:
			// check for failedRetry = true. It means last time this method got
			// failed and this time got passed so lets modify passed and failed
			// count
			if (failedRetry) {
				passed_test++;
				failed_test--;
				failedRetry = false;
			}
			passed_test++;
			break;

		case 2:
			// if failedRetry is false ie. this is the result of fresh test
			// method and not previously failed test method.
			if (!failedRetry) {
				failed_test++;
			}
			failedRetry = true;
			failedRetryTimes++; // it will have 1 and 2 corresponding to retry
								// times
			if (failedRetryTimes == 3) {
				failedRetry = false;
				failedRetryTimes = 0;
			}
			break;

		case 3:
			skip_test++;
			break;

		default:
			logger.info("Unexpected Test Result");
		}
		int net_test = total_test_in_current_suite
				- (passed_test + failed_test + skip_test);
		int methods_executed = passed_test + failed_test;
		logger.info("############################################");
		logger.info("Number of Test Methods Executed :: " + methods_executed);
		logger.info("Number of Passed Tests :: " + passed_test);
		logger.info("Number of Failed Tests :: " + failed_test);
		logger.info("Number of Skipped Tests :: " + skip_test);
		logger.info("Execution time spent so far :: "
				+ timeSpentSoFar(start_time, System.currentTimeMillis()));
		logger.info("############################################");
		logger.info("Test Method yet to run :: " + net_test);
		int time_remaining = net_test * 5;
		logger.info("Expected time to finish :: " + time_remaining + " mins");

		float failed_ratio = checkFailedThreshold(failed_test,
				total_test_in_current_suite);
		float failed_skipped_ratio = checkFailedThreshold(
				(failed_test + skip_test), total_test_in_current_suite);

		logger.info("% of Failed Test Methods " + failed_ratio);
		logger.info("% of Failed and Skipped Test Methods "
				+ failed_skipped_ratio);

		if (failed_ratio >= 5.5) {
			System.err
					.println("Stopping the Test Execution as % of Failed Tests has become more than threshold");
			System.exit(0);
			// TO DO: Stop the selenium server. In case TestNG is running test
			// methods/classes/tests in parallel, then we have to ensure that
			// all threads all closed and system exist
			// gracefully.
		}
	}

	/**
	 * This method returns % of test cases failed out of total test methods in test suite.
	 * @param failed_test
	 * 				Number of Failed or Failed + Skipped Tests Methods
	 * @param total_test_in_current_suite
	 * 				Number of Total Test Methods in Test Suite 
	 * @return
	 * 				Float value of required data
	 */
	public float checkFailedThreshold(int failed_test,
			int total_test_in_current_suite) {
		BigDecimal failed_test_bd = new BigDecimal(failed_test);
		BigDecimal total_test_bd = new BigDecimal(total_test_in_current_suite);
		return failed_test_bd.divide(total_test_bd, 10, BigDecimal.ROUND_UP)
				.setScale(2, BigDecimal.ROUND_UP).floatValue();

	}

	/**
	 * This method calculates time difference between given two time values.
	 * This is being used to calculate time spent so far (Test Execution Start Time - Current time after each Test Method execution).
	 * @param start_time
	 * 				Test Execution Start Time 
	 * @param end_time
	 * 				Current time after each Test Method execution
	 */
	public String timeSpentSoFar(long sTime, long eTime) {
		long start_time_ms = sTime;
		long end_time_ms = eTime;
		long net_time_s = (end_time_ms - start_time_ms) / (1000);
		if (net_time_s < 60) {
			return ("Time Lapsed " + net_time_s + " secs");
		} else if ((net_time_s / 60 >= 60)) {

			long hours = (net_time_s / 120);
			long min = net_time_s % 120;
			return ("Time lapsed " + hours + " hours " + min + " mins");
		} else {
			long min = net_time_s / 60;
			long sec = net_time_s % 60;

			return ("Time Lapsed " + min + " mins " + sec + " secs");
		}
	}

	/**
	 * This static method returns the running selenium instance.
	 */

	public LoggingSelenium getSelenium() {
		return selenium;
	}

	/**
	 * This method returns current date and time in string having a specific
	 * format created through SimpleDateFormat.
	 * 
	 * @return String
	 */
	public final String timeStampForFileName() {
		Date currentDateTime = new Date(System.currentTimeMillis());
		return FILENAME_DATETIME_FORMAT.format(currentDateTime);
	}

	/**
	 * This method returns current date and time in string having a specific
	 * format created through SimpleDateFormat.
	 * 
	 * @return String
	 */
	public final String currentDate() {
		Date currentDateTime = new Date(System.currentTimeMillis());
		return DATE_FORMAT.format(currentDateTime);
	}

	/**
	 * This method evaluates a boolean expression and based on success/failure, stores failure message in an instance of StringBuilder class.
	 * @param success Condition to Check, should return true/false
	 * @param message Failure Message to log in case conditions evaluates to false
	 * @param messages Messages container to store Failure messages
	 */
	public void assertSoft(boolean success, String message,
			StringBuilder messages, LoggingSelenium selenium) {
		if (!success) {
			messages.append("<br>" + message + "<br>");
			// Comment this line for UrgentWowyTest if there is a need
			//captureScreenShot(selenium, currentScreenShotPath);
			selenium.logAssertion("Assertion Error", message , "");
		}
			
	}

	/**
	 * This method scans StringBuilder instance to have any string. In case it find one or more, it throws AssertionError to mark test method failed.
	 * @param sb Instance of StringBuilder class.
	 */
	public void assertEmpty(StringBuilder sb) {
		if (sb.length() > 0) {
			lastTestMethodResult = false;
		logger.info("There are few assertion errors.");
		//selenium.logAssertion("All Failed Assertions", sb.toString(), "");
		com.tbb.logging.LoggingAssert.assertTrue("All Failed Assertions" + sb.toString() , sb.length() == 0, selenium);
		}
	}
	
	/**
	 * This method has been written to override assertTrue method from LoggingAssert. This method internally call assertSoft method.
	 * @param msg Failure Messsage
	 * @param condition Condition to check
	 * @param selenium instance of LoggingSelenium
	 */
	public void assertTrue(String msg, boolean condition, LoggingSelenium selenium) {
		if (assertionMode.equalsIgnoreCase("soft")) assertSoft(condition, msg, messages, selenium);
		else com.tbb.logging.LoggingAssert.assertTrue(msg, condition, selenium);
	}

	/**
	 * This method is just to re-initialize instance of StringBuilder before every test method so that it does contain assertion results of previous test methods. 
	 */
	@BeforeMethod
	public void setMessageBuilder() {
		messages  = new StringBuilder();
	}
	
	/**
	 * This method invokes assertEmpty method so that system can find out whether there were any assertion errors.
	 */
	public void emptyMessageBuilder() {
		try {
			assertEmpty(messages);
		} catch(Exception e) { logger.info(e.getMessage()); }
		
	}
	
	
	/**
	 * Method to put current thread into sleep for given miliseconds
	 * 
	 * @param time
	 *            Time in milliseconds
	 */
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A utility that generates String of given length of characters out of a fixed string.
	 * The random string lowercase characters and numbers.
	 * 
	 * @param length
	 *            length of string to be generated
	 * @return the generated random String
	 */
	public static String generateRandomLengthString(final int length) {
		/**
		 * the list of characters that the random string can contains
		 */
		final String validCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		/**
		 * random generator to generate random indexes in a range
		 */
		final Random randomGenerator = new Random();
		/**
		 * random index to pick a character from valid characters
		 */
		int randIndex = 0;
		/**
		 * the random string for return
		 */
		String randomString = "";

		for (int i = 0; i < length; i++) {
			randIndex = randomGenerator.nextInt(validCharacters.length());
			randomString = randomString
					+ validCharacters.substring(randIndex, randIndex + 1);
		}
		return randomString;
	}

	/**
	 * This method generates a random string of 2 characters.
	 * @return
	 */
	public String generateRandomString() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32).substring(0, 2);

	}
	
	/**
	 * This method takes screen shot of web page. After taking screen shot, it
	 * saves that to file with test method name and time stamp. This also writes
	 * a comment (having link to screenshot) to selenium logging file created
	 * through LoggingSelenium.
	 */
	public void captureScreenShot(LoggingSelenium selenium, String screenshotsResultsPath) {

		try {
			
			final String SCREENSHOT_PATH = "screenshots";
			/*
			String screenshotsResultsPath = new File(RESULTS_BASE_PATH
					+ File.separator + SCREENSHOT_PATH).getAbsolutePath();
	

			if (!new File(screenshotsResultsPath).exists()) {
				new File(screenshotsResultsPath).mkdirs();
			}*/
			
			String imageName = "Image" + timeStampForFileName()
			+ ".png";
			
			String finalImage = screenshotsResultsPath + File.separator
			+ imageName;
	

			
			String browser = ConfigFileReader.getConfigItemValue("browser");
			if (browser.equals("*chrome") || browser.equals("*firefox") || browser.equals("*iehta")) {
				// call captureEntirePageScreenshotToString method and it will
				// return Base64 encoded string referring to screen shot
				String base64Screenshot = selenium
						.captureEntirePageScreenshotToString("");
				
				// Decode that Base64 encoded string to get actual screen shot.
				// Finally this screen shot will be written to file object.
				byte[] decodedScreenshot = Base64.decode(base64Screenshot);

				// create instance of FileOutputStream by passing it filename
				FileOutputStream fos = new FileOutputStream(new File(finalImage));

				// Write decoded screenshot to fileoutputstream object
				fos.write(decodedScreenshot);
				fos.close();
			}
			else {
			     selenium.captureScreenshot(finalImage);
			}
			
	
			String failedSS = "<a href=\"file://" + finalImage
					+ "\">Screenshot for previous action " + "</a>";
			logger.debug(finalImage);
			//selenium.logComment(failedSS);
			selenium.logComment("<a href=\"" + SCREENSHOT_PATH + "/" + imageName + "\"><img src=\"" + SCREENSHOT_PATH + "/" + imageName + "\" alt=\"Page Screen Shot\" width=\"150\" height=\"300\" border=\"5\"/></a>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to override selenium type method. This waits for given element to
	 * present for 60 seconds Once it gets that element, it types the given
	 * value in that element. Otherwise it fails the assertion.
	 * 
	 * @param element
	 *            Locator for element
	 * @param value
	 *            Value to type in locator
	 */
	public void type(String element, String value) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.type(element, value);
	}
	
	public void typeKeys(String element, String value) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.typeKeys(element, value);
	}

	public void addSelection (String element, String optionLocator ) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.addSelection(element, optionLocator);
	}

	
	/**
	 * Method to override selenium highlight method. This waits for given
	 * element to present for 60 seconds Once it gets that element, it
	 * highlights element. Otherwise it fails the assertion.
	 * 
	 * @param element
	 *            Locator for element
	 */
	public void highlight(String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.highlight(element);
	}


	/**
	 * Method to override selenium click method. This waits for given element to
	 * present for 60 seconds Once it gets that element, it clicks that.
	 * Otherwise it fails the assertion.
	 * 
	 * @param element
	 *            Locator for element
	 */
	public void click(String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.click(element);
	}
	
	public void type(String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.type(element);
	}
	
	
	public void clickAt(String element, String coordString ) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.clickAt(element, coordString);
	}
	
	public void contextMenu (String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.contextMenu (element);
	}
	
	public void contextMenuAt (String element, String coordString ) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.contextMenuAt (element, coordString);
	}
	
	public void doubleClick (String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.doubleClick (element);
	}
	
	public void doubleClickAt  (String element, String coordString ) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.doubleClickAt  (element, coordString);
	}

	public void dragAndDrop(String element, String movementsString  ) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.dragAndDrop(element, movementsString );
	}

	public void dragAndDropToObject (String sourceElement, String destinationElement  ) {
		assertTrue("Element " + sourceElement + " not found",
				waitForElementPresent(sourceElement), selenium);
		assertTrue("Element " + destinationElement + " not found",
				waitForElementPresent(destinationElement), selenium);
		
		selenium.dragAndDropToObject(sourceElement, destinationElement );
	}
	
	public void fireEvent(String element, String eventName  ) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.fireEvent(element, eventName );
	}
	

	
	
	/**
	 * Method to override selenium select method. This waits for given element
	 * to present for 60 seconds Once it gets that element, it selects given value in that select box.
	 * Otherwise it fails the assertion.
	 * 
	 * @param element
	 *            Locator for element
	 */
	public void select(String element, String optionLocator ) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.select(element, optionLocator );
	}

	public void removeSelection (String element, String optionLocator ) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.removeSelection (element, optionLocator );
	}
	
	public void removeAllSelections(String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.removeAllSelections(element);
	}
	/**
	 * Method to override selenium check method. This waits for given element to
	 * present for 60 seconds Once it gets that element, it checks that.
	 * Otherwise it fails the assertion.
	 * 
	 * @param element
	 *            Locator for element
	 */
	public void check(String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.check(element);
	}

	public void selectFrame(String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.selectFrame(element);
	}
	
	/**
	 * Method to override selenium uncheck method. This waits for given element
	 * to present for 60 seconds Once it gets that element, it unchecks that.
	 * Otherwise it fails the assertion.
	 * 
	 * @param element
	 *            Locator for element
	 */
	public void uncheck(String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.uncheck(element);
	}

	/**
	 * Method to override selenium focus method. This waits for given element to
	 * present for 60 seconds Once it gets that element, it focuses on that.
	 * Otherwise it fails the assertion.
	 * 
	 * @param element
	 *            Locator for element
	 */
	public void focus(String element) {
		assertTrue("Element " + element + " not found",
				waitForElementPresent(element), selenium);
		selenium.focus(element);
	}



	public boolean waitForElementPresent(String locator) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (selenium.isElementPresent(locator))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}
	
	public boolean isTextPresent(String textToCheck) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (selenium.isTextPresent(textToCheck))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}
	
	/**
	 * 
	 * @param locator
	 * @param value
	 * @return
	 */
	public boolean waitForAtrribute(String locator, String value) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (value.equals(selenium.getAttribute(locator)))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	/**
	 * 
	 * @param locator
	 * @param value
	 * @return
	 */
	public boolean waitForNotAtrribute(String locator, String value) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (!value.equals(selenium.getAttribute(locator)))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}

	}

	/**
	 * 
	 * @param locator
	 * @param value
	 * @return
	 */
	public boolean waitForAlertPresent() {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (selenium.isAlertPresent())
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}

	}

	/**
	 * 
	 * @param locator
	 * @param value
	 * @return
	 */
	public boolean waitForConfirmationPresent() {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (selenium.isConfirmationPresent())
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}

	}

	public boolean waitForEditable(String locator) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (selenium.isEditable(locator))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	public boolean waitForTextNotPresent(String locator,
			String textToCheck) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (!textToCheck.equals(selenium.getText(locator)))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	public boolean waitForValueNotPresent(String locator,
			String valueToCheck) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (!valueToCheck.equals(selenium.getValue(locator)))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	public boolean waitForElementNotVisible(String locator) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (!selenium.isVisible(locator))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	public boolean waitForSelectOptions(String promptText) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (promptText.equals(selenium.getPrompt()))
					return false;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	public boolean waitForSelectOptions(String locator, String pattern) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (pattern.equals(selenium.getSelectOptions(locator)))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	public boolean waitForSelectedLabels(String locator, String pattern) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (pattern.equals(selenium.getSelectedLabels(locator)))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	public boolean waitForSelectedIndexes(String locator, String pattern) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (pattern.equals(selenium.getSelectedIndexes(locator)))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	public boolean waitForSelectedValue(String locator, String pattern) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (pattern.equals(selenium.getSelectedValue(locator)))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}

	public boolean waitForSomethingSelected(String locator) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				if (selenium.isSomethingSelected(locator))
					return true;
			} catch (Exception e) {
			}
			sleep(1000);
		}
	}
	
	public void analyzeLinks() {
		int linksCount = selenium.getXpathCount("//a").intValue();

		ArrayList<String> linksWithText = new ArrayList<String>();
		ArrayList<String> linksWithNoText = new ArrayList<String>();

		for (int i = 1; i <= linksCount; i++) {
			
			if (!selenium.getText("xpath=(//a)[" + i + "]").equals("")) {
				linksWithText.add(selenium.getText("xpath=(//a)[" + i + "]"));
			} else {
				linksWithNoText.add(selenium.getAttribute("xpath=(//a)[" + i + "]@href"));
			}
		}

		java.util.Iterator<String> iterator = linksWithText.iterator();

		int i = 0;
		while (iterator.hasNext()) {
			i = i + 1;
			logger.info("Link " + i + " " + iterator.next().toString());
		}
		
		iterator = linksWithNoText.iterator();

		i = 0;
		while (iterator.hasNext()) {
			i = i + 1;
			logger.info("Link " + i + " with no Text so logging href " + iterator.next().toString());
		}
		
	}

	public void analyzeHiddenElements() {
		int hiddenElementsCount = selenium.getXpathCount("//*[contains(@type, 'hidden')]").intValue();
		ArrayList<String> hiddenElements = new ArrayList<String>();
		
		String id = "not defined", name = "not defined", value = "not defined", className = "not defined";
		for (int i = 1; i <= hiddenElementsCount; i++) {
			try { id = selenium.getAttribute("xpath=(//*[contains(@type, 'hidden')])[" + i + "]@id"); } catch (Exception e) {}
			try { name = selenium.getAttribute("xpath=(//*[contains(@type, 'hidden')])[" + i + "]@name");} catch (Exception e) {}
			try { value = selenium.getAttribute("xpath=(//*[contains(@type, 'hidden')])[" + i + "]@value");} catch (Exception e) {}
			try { className = selenium.getAttribute("xpath=(//*[contains(@type, 'hidden')])[" + i + "]@class");} catch (Exception e) {}
								
				hiddenElements.add("Hidden Element: " + i + "|| id: " + id + "|| name: " + name + "|| value: " + value + "|| class: " + className);	
			 
		}
		
		java.util.Iterator<String> iterator = hiddenElements.iterator();

		while (iterator.hasNext()) {
			logger.info(iterator.next().toString());
		}
	}
	
	/**
	 * Returns true if aText is non-null and has visible content.
	 * 
	 */
	private static boolean textHasContent(String aText) {
		String EMPTY_STRING = "";
		return (aText != null) && (!aText.trim().equals(EMPTY_STRING));
	}

	/**
	 * Returns true if aNumber is in range of aLow and aHigh.
	 * 
	 * 
	 */
	private static boolean isInRange(int aNumber, int aLow, int aHigh) {
		return aNumber >= aLow && aNumber <= aHigh ? true : false;
	}

	/**
	 * Returns true if aNumber is in range of aLow and aHigh.
	 * 
	 * 
	 */
	private static boolean matches(String aPattern, String aText) {
		return aText.matches(aPattern) ? true : false;
	}


/**
 * This method is used to verify validity of username. 
 * @param username Value of Username
 * @param minLen Minimum length of username
 * @param maxLen Maximum length of username
 * @return
 */
	public static boolean validateUsername( String  username, int minLen, int maxLen )
	{
	    if (username.matches("^[a-z0-9_-]{" + minLen + "," + maxLen + "}$")) {
	    	return true;
	    } else
	    	return false;
	}
	
	/**
	 * This verifies validity of password.
	 * @param password Value of Password
	 * @param minLen Minimum length of password
	 * @param maxLen Maximum length of password
	 * @return
	 */
	public static boolean validatePassword( String  password, int minLen, int maxLen )
	{
	    if (password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{" + minLen + "," + maxLen + "}")) {
	    	return true;
	    } else
	    	return false;
	}
	

	/**
	 * This verifies validity of email addresses
	 * @param emailAddress Value of EMail Addresses
	 * @return
	 */
	public static boolean validateEmailAddress( String  emailAddress)
	{
	    if (emailAddress.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
	    	return true;
	    } else
	    	return false;
	}
	

	public void getEnvInfo() {
		//To Get the name of the browser
		System.out.println("Name of the browser used"+selenium.getEval("navigator.appName;"));

		//To Get the code name of the browser using Selenium
		System.out.println("Code name of the browser"+selenium.getEval("navigator.appCodeName;"));

		// To Get the browser version using Selenium
		System.out.println("browser version of the selenium"+selenium.getEval("navigator.appVersion;"));

		//To Get the Operating System Details using Selenium
		System.out.println(" "+selenium.getEval("navigator.userAgent;"));

		//To Get whether the cookies are enabled in the browser
		System.out.println("Cookies are enabled: "+selenium.getEval("navigator.cookieEnabled;"));

		//To Get the Language Details of the Browser
		System.out.println("Language used by the browser:"+selenium.getEval("navigator.userLanguauge;"));

		//To Get Default language of the Operating System
		System.out.println("Default Language used by the Operating System: "+selenium.getEval("navigator.systemLanguage;"));

		
	}

}
