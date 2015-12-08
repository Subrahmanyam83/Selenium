package com.tbb.testscripts.getfit;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.FitnessTipsTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.getfit.FitnessTipsPage;
import com.tbb.pages.getfit.GetFitPage;

/**
 *
 * This test script contains test method(s) for Fitness Tips page under Get-Fit module
 *  @author Jaya
 */
public class TestFitnessTips extends BaseTest implements FitnessTipsTab{

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
	
	/***
	 * This is data provider for testViewNutritionTipsAsFreeUser Test Script.
	 */ 
	@DataProvider(name = "viewFitnessTipsFreeDataProvider")
	public Object[][] createFitnessTipsDataForFreeUser() {
		return new Object[][] {
				{ "Body"},
		};
	}

	/**
	 * Positive Test script for verifying viewing of Fitness Tips Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test (dataProvider = "viewFitnessTipsFreeDataProvider")
	public void testViewFitnessTipsAsFreeUser(String keyword) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Get Fit Page");
		selenium.logComment("Navigating to Fitness Tips Page");
		selenium.logComment("Verifying that all the required elements are present on the Fitness Tips Page");
		selenium.logComment("Typing the search keyword in tips search text box on Fitness Tips Page");
		selenium.logComment("Clicking on Search icon on Fitness Tips Page");
		selenium.logComment("Verifying that the searched keyword is present in the search results on Fitness Tips Page");
		selenium.logComment("Clicking on one of the tip to view it.");
		selenium.logComment("Verifying the searched tip details are displayed.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		

		selenium.logComment("Verifying whether user is on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}

		selenium.logComment("Navigating to Get Fit Page");
		GetFitPage getFitPage = dashboardPage.clickGetFitLink();
		
		selenium.logComment("Navigating to Fitness Tips Page");
		FitnessTipsPage fitnessTipsPage = getFitPage.goToFitnessTipsPage();
		
		selenium.logComment("Verifying that all the required elements are present on the Fitness Tips Page");
		assertTrue("Expected header 'Fitness Tips' is not displayed.", selenium.isElementPresent(FITNESS_TIPS_HEADER), selenium);
		assertTrue("Expected text 'Fitness tips is...' is not displayed.", selenium.isTextPresent("Fitness tips is where you'll find information on a wide variety of health and fitness topics, from preventing injury to avoiding the late-night munchies. Whatever question you have, chances are you'll find the answer here."), selenium);
		assertTrue("Expected text '(To rate any...' is not displayed.", selenium.isTextPresent("(To rate any tip from 1 to 5, simply click on the stars underneath.)"), selenium);
		assertTrue("Expected text 'This week's featured...' is not displayed.", selenium.isTextPresent("This week's featured tip "), selenium);
		assertTrue("Expected search textbox for 'Fitness Tips' is not displayed.", selenium.isElementPresent(TIP_SEARCH_TEXTBOX), selenium);
		assertTrue("Expected search icon for 'Fitness Tips' is not displayed.", selenium.isElementPresent(TIP_SEARCH_ICON), selenium);
		
		selenium.logComment("Typing the search keyword in tips search text box on Fitness Tips Page");
		fitnessTipsPage.typeSearchKeyword(keyword);
		
		selenium.logComment("Clicking on Search icon on Fitness Tips Page");
		fitnessTipsPage.clickSearchAsClubUser();
		
		selenium.logComment("Verifying that the searched keyword is present in the search results on Fitness Tips Page");
		assertTrue("Expected search doesn't contain the searched keyword.", selenium.isTextPresent(keyword), selenium);
		
		selenium.logComment("Clicking on one of the tip to view it.");
		fitnessTipsPage.clickTipName(keyword);
		
		selenium.logComment("Verifying the searched tip details are displayed.");
		assertTrue("Expected Tip header is not available.", selenium.isElementPresent("css=h2.title:contains("+keyword+")"), selenium);
		assertTrue("Expected text 'Back to Fitness Tips' is not available.", selenium.isTextPresent("Back to Fitness Tips"), selenium);
		assertTrue("Expected text 'Your Rating' is not available.", selenium.isTextPresent("Your Rating"), selenium);
		assertTrue("Expected text 'Average' is not available.", selenium.isTextPresent("Average"), selenium);	
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}
	
	/***
	 * This is data provider for testViewFitnessTipsAsClubUser Test Script.
	 */ 
	@DataProvider(name = "viewFitnessTipsClubDataProvider")
	public Object[][] createFitnessTipsDataForClubUser() {
		return new Object[][] {
				{ "Abs"},
		};
	}

	/**
	 * Positive Test script for verifying viewing tips of Fitness Tips Page.
	 * It verifies if all the required elements are present on the page. 
	 * It then searches for a keyword and clicks on the search result with that keyword to view the tip.
	 */ 
	@Test (dataProvider = "viewFitnessTipsClubDataProvider")
	public void testViewFitnessTipsAsClubUser(String keyword) {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Get Fit Page");
		selenium.logComment("Navigating to Fitness Tips Page");
		selenium.logComment("Verifying that all the required elements are present on the Fitness Tips Page");
		selenium.logComment("Typing the search keyword in tips search text box on Fitness Tips Page");
		selenium.logComment("Clicking on Search icon on Fitness Tips Page");
		selenium.logComment("Verifying that the searched keyword is present in the search results on Fitness Tips Page");
		selenium.logComment("Clicking on one of the tip to view it.");
		selenium.logComment("Verifying the searched tip details are displayed.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("Verifying whether user is on Home page");
		
		

		selenium.logComment("Verifying whether user is on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}

		selenium.logComment("Navigating to Get Fit Page");
		GetFitPage getFitPage = dashboardPage.clickGetFitLink();
		
		selenium.logComment("Navigating to Fitness Tips Page");
		FitnessTipsPage fitnessTipsPage = getFitPage.goToFitnessTipsPage();
		
		selenium.logComment("Verifying that all the required elements are present on the Fitness Tips Page");
		assertTrue("Expected header 'Fitness Tips' is not displayed.", selenium.isElementPresent(FITNESS_TIPS_HEADER), selenium);
		assertTrue("Expected text 'Fitness tips is...' is not displayed.", selenium.isTextPresent("Fitness tips is where you'll find information on a wide variety of health and fitness topics, from preventing injury to avoiding the late-night munchies. Whatever question you have, chances are you'll find the answer here."), selenium);
		assertTrue("Expected text '(To rate any...' is not displayed.", selenium.isTextPresent("(To rate any tip from 1 to 5, simply click on the stars underneath.)"), selenium);
		assertTrue("Expected text 'This week's featured...' is not displayed.", selenium.isTextPresent("This week's featured tip "), selenium);
		assertTrue("Expected search textbox for 'Fitness Tips' is not displayed.", selenium.isElementPresent(TIP_SEARCH_TEXTBOX), selenium);
		assertTrue("Expected search icon for 'Fitness Tips' is not displayed.", selenium.isElementPresent(TIP_SEARCH_ICON), selenium);
		
		selenium.logComment("Typing the search keyword in tips search text box on Fitness Tips Page");
		fitnessTipsPage.typeSearchKeyword(keyword);
		
		selenium.logComment("Clicking on Search icon on Fitness Tips Page");
		fitnessTipsPage.clickSearchAsClubUser();
		
		selenium.logComment("Verifying that the searched keyword is present in the search results on Fitness Tips Page");
		assertTrue("Expected search doesn't contain the searched keyword.", selenium.isTextPresent(keyword), selenium);
		
		selenium.logComment("Clicking on one of the tip to view it.");
		fitnessTipsPage.clickTipName(keyword);
		
		selenium.logComment("Verifying the searched tip details are displayed.");
		assertTrue("Expected Tip header is not available.", selenium.isElementPresent("css=h2.title:contains("+keyword+")"), selenium);
		assertTrue("Expected text 'Back to Fitness Tips' is not available.", selenium.isTextPresent("Back to Fitness Tips"), selenium);
		assertTrue("Expected text 'Your Rating' is not available.", selenium.isTextPresent("Your Rating"), selenium);
		assertTrue("Expected text 'Average' is not available.", selenium.isTextPresent("Average"), selenium);	
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}
}