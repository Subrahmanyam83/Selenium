package com.tbb.testscripts.clubukuser;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.SupplementsTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.EatSmartPage;

/**
 * 
 * This test script contains test method(s) for alerts shown on Supplements page for UK Club user.
 * @author Jaya
 */
public class TestSupplementsAlert extends BaseTest{

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
	 * Positive Test script for verifying that the Club UK User alert is displayed on Supplements Page.
	 */ 
	@Test
	public void testSupplementsAlertAsClubUKuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Eat Smart Page.");
		selenium.logComment("Navigate to Supplements Page.");
		selenium.logComment("Verifying alert is available on Supplements page.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.clubuk.username"), ConfigFileReader.getConfigItemValue("tbb.clubuk.userpassword"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.clubuk.username"), ConfigFileReader.getConfigItemValue("tbb.clubuk.userpassword"));
		}
		
		selenium.logComment("Navigate to Eat Smart Page.");	
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();
		
		selenium.logComment("Navigate to Supplements Page.");	
		eatSmartPage.goToShakeologyAndSupplementsPage();
		
		selenium.logComment("Verifying alert is available on Supplements page.");		
		assertTrue("Alert is missing.", (selenium.isElementPresent(SupplementsTab.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Alert text is missing.", (selenium.isTextPresent("Currently, this site is optimized for our U.S. members. Questions?")), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/**
	 * Positive Test script for verifying that the Free User does not see Club UK user alert on Supplements page.
	 */ 
	@Test
	public void testSupplementsAlertAsFreeuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Eat Smart Page.");
		selenium.logComment("Navigate to Supplements Page.");
		selenium.logComment("Verifying alert should not be present.");
		selenium.logComment("Executing assertEmpty method");
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

		selenium.logComment("Navigate to Eat Smart Page.");	
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();
		
		selenium.logComment("Navigate to Supplements Page.");	
		eatSmartPage.goToShakeologyAndSupplementsPage();
		
		selenium.logComment("Verifying alert should not be present.");		
		assertTrue("Club UK User Alert is available to free user.", !(selenium.isVisible(SupplementsTab.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}