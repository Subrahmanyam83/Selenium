package com.tbb.testscripts.coach;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.tbb.pages.coach.CoachFAQPage;
import com.tbb.pages.coach.CoachPage;

/**
 * 
 * This test script contains test method(s) for Coach FAQ page under Coach module
 * @author Gaurav
 */

public class TestCoachFAQs extends BaseTest {

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
	 * This page verifies accessibility and UI of Coach FAQ page.
	 */
	@Test
	public void testCoachFAQ() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on Coach tab");
		selenium.logComment("Navigating to Coach FAQ Page");
		selenium.logComment("Verifying UI of page");
		selenium.logComment("Verifing RRMs on page");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Clicking on Coach tab");
		CoachPage coachPage = dashboardPage.clickCoachLink();
		
		selenium.logComment("Navigating to Coach FAQ Page");
		CoachFAQPage coachFAQPage = coachPage.clickCoachFAQLink();
		
		selenium.logComment("Verifying UI of page");
		coachFAQPage.verifyUI();
		
		
		selenium.logComment("Verifing RRMs on page");
		assertTrue("Count of RRMs not correct", (coachFAQPage.getRRMsCount()-2) ==3, selenium);
		ArrayList<String> rrmTitles = coachFAQPage.getRRMsTitles();
		String[] rrmTitlesData = new String[] {"Fast and Furious", "TurboFire®", "Shake ‘n take!"};
		List<String> rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("RRM Titles not correct", rrmTitlesDataList.equals(rrmTitles), selenium);
		
	}
}
