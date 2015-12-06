package com.tbb.testscripts.clubukuser;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.MyMealPlannerTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.EatSmartPage;

/**
 * 
 * This test script contains test method(s) for alerts shown on Meal Planner page for UK Club user.
 * @author Jaya
 */
public class TestMealPlannerAlert extends BaseTest{

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
	 * Positive Test script for verifying viewing Meal Planner Alert as Club UK user.
	 */ 
	@Test
	public void testMealPlannerAlertAsClubUKuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Eat Smart Page.");
		selenium.logComment("Navigate to My Meal Planner Page.");
		selenium.logComment("Verifying alert is available.");
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
		
		selenium.logComment("Navigate to My Meal Planner Page.");	
		eatSmartPage.goToMyMealPlannerPage();
		
		selenium.logComment("Verifying alert is available.");		
		assertTrue("Club UK User Alert is missing.", selenium.isElementPresent(MyMealPlannerTab.CLUB_UK_USER_ALERT), selenium);
		assertTrue("Club UK User Alert text is missing.", selenium.isTextPresent("NOTE: All measurements on this site are displayed in imperial units. Convert to metric units if desired."), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/**
	 * Positive Test script for verifying that Club UK user alert is not displayed on Meal Planner page on logging in as Free user.
	 */ 
	@Test
	public void testMealPlannerAlertAsFreeuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Eat Smart Page.");
		selenium.logComment("Navigate to My Meal Planner Page.");
		selenium.logComment("Verifying alert should not be present.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		}
		
		selenium.logComment("Navigate to Eat Smart Page.");	
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();
		
		selenium.logComment("Navigate to My Meal Planner Page.");	
		eatSmartPage.goToMyMealPlannerPage();
		
		selenium.logComment("Verifying alert should not be present.");		
		assertTrue("Club UK User Alert text is available to free user.", !(selenium.isTextPresent("NOTE: All measurements on this site are displayed in imperial units. Convert to metric units if desired.")), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}