package com.tbb.testscripts.coach;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.ListIterator;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.coach.CoachOnlineOfficePage;
import com.tbb.pages.coach.CoachPage;

/**
 * 
 * This test script contains test method(s) for Coach Online Office page under Coach module
 * @author Gaurav
 */

public class TestCoachOnlineOffice extends BaseTest {

	@BeforeClass
	public void setUp() {
		startSeleniumServer();
	}
	
	@BeforeMethod
	public void setUp(Method method) {
		createSeleniumInstance(method);		
	}

	
	@AfterMethod
	public void stopSelenium() {
		stopSeleniumInstance();
	}
	
	@AfterClass
	public void tearDown() {		
		stopSeleniumServer();
	}
	
	/**
	 * This test verifies UI of Coach Online Office page. Along with general UI elements it also verifies information related to
	 * Coach Personal section, Volume details, alerts, events and updates.
	 */
	@Test
	public void testCoachOnlineOffice() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on Coach tab");
		selenium.logComment("Clicking on 'Coach Online Link' ");
		selenium.logComment("Verifying UI of page");
		selenium.logComment("Logging and verifying Coach's Personal Info");
		selenium.logComment("Logging and verifying Coach's Volume Details");
		selenium.logComment("Logging and verifying Coach's Alerts");
		selenium.logComment("Logging and verifying Coach's Events & Tasks");
		selenium.logComment("Logging and verifying number of Breaking News");
		selenium.logComment("Logging out from Coach Online Office");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
		}
		
		selenium.logComment("Clicking on Coach tab");
		CoachPage coachPage = dashboardPage.clickCoachLink();
		
		selenium.logComment("Clicking on 'Coach Online Link' ");
		CoachOnlineOfficePage coachOnlineOfficePage = coachPage.clickCoachOnlineOfficeLink();
		
		selenium.logComment("Verifying UI of page");
		coachOnlineOfficePage.verifyUI();
		
		selenium.logComment("Logging and verifying Coach's Personal Info");
		ArrayList<String> coachPersonalInfo = coachOnlineOfficePage.getCoachPersonalInfo();
		ListIterator<String> litr = coachPersonalInfo.listIterator();
		    while (litr.hasNext()) {
		    	logger.info(litr.next());
		      
		    }
		
		selenium.logComment("Logging and verifying Coach's Volume Details");
		ArrayList<String> coachVolumeDetails = coachOnlineOfficePage.getCoachVolumeDetails();
		litr = coachVolumeDetails.listIterator();
		    while (litr.hasNext()) {
		    	logger.info(litr.next());
		      
		    }
		
		selenium.logComment("Logging and verifying Coach's Alerts");
		ArrayList<String> coachAlerts = coachOnlineOfficePage.getCoachAlerts();
		litr = coachAlerts.listIterator();
	    while (litr.hasNext()) {
	    	logger.info(litr.next());
	      
	    }
		
		selenium.logComment("Logging and verifying Coach's Events & Tasks");
		ArrayList<String> coachEventsTasks = coachOnlineOfficePage.getCoachEventsTasks();
		litr = coachEventsTasks.listIterator();
	    while (litr.hasNext()) {
	    	logger.info(litr.next());
	      
	    }

		selenium.logComment("Logging and verifying number of Breaking News");
		int newsCount = coachOnlineOfficePage.getBreakingNewsCount();
		logger.info("Count of Breaking News = " + newsCount);
		
		
		selenium.logComment("Logging out from Coach Online Office");
		selenium.click("css=button.button2 > div > div > span:contains(Logout)");
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();	
		
	}
}
