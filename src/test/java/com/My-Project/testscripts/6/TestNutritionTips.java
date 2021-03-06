package com.tbb.testscripts.eatsmart;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.NutritionTipsTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.eatsmart.NutritionTipsPage;

/**
 *
 * This test script contains test method(s) for Nutrition Tips page under Eat-Smart module
 *  @author Jaya
 */
public class TestNutritionTips extends BaseTest implements NutritionTipsTab{

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
	@DataProvider(name = "viewNutritionToolsFreeDataProvider")
	public Object[][] createNutritonToolsData() {
		return new Object[][] {
				{"Snack"},
		};
	}

	/**
	 * Positive Test script for verifying viewing of Nutrition Tools Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test (dataProvider = "viewNutritionToolsFreeDataProvider")
	public void testViewNutritionTipsAsFreeUser(String keyword) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to Nutrition Tips Page");
		selenium.logComment("Typing the search keyword in tips search text box on Nutrition Tips Page");
		selenium.logComment("Clicking on Search icon on Nutrition Tips Page");
		selenium.logComment("Verifying that the searched keyword is present in the search results on Nutrition Tips Page");
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

		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();
		
		selenium.logComment("Navigating to Nutrition Tips Page");
		NutritionTipsPage nutritionTipsPage = eatSmartPage.goToNutritionTipsPage();
		
		assertTrue("Expected header 'Nutrition Tips' is not displayed.", selenium.isElementPresent(NUTRITION_TIPS_HEADER), selenium);
		assertTrue("Expected text 'Team Beachbody makes...' is not displayed.", selenium.isTextPresent("Team Beachbody makes it easy to put together a great diet strategy, but sticking with it can be hard! You may encounter a few obstacles on your journey to better health and fitness, but you don�t have to let them derail your plans. Check out our nutrition tips for advice on just about every diet-related question you may have. From healthy snacking tips to harnessing the power of protein for strong muscles and quicker recovery, we�ll help you follow your meal plan and build the body you deserve."), selenium);
		assertTrue("Expected text '(To rate any...' is not displayed.", selenium.isTextPresent("(To rate any tip from 1 to 5, simply click on the stars underneath.)"), selenium);
		assertTrue("Expected text 'This week's featured...' is not displayed.", selenium.isTextPresent("This week's featured tip "), selenium);
		assertTrue("Expected search textbox for 'Nutrition Tips' is not displayed.", selenium.isElementPresent(TIP_SEARCH_TEXTBOX), selenium);
		assertTrue("Expected search icon for 'Nutrition Tips' is not displayed.", selenium.isElementPresent(TIP_SEARCH_ICON), selenium);
		
		selenium.logComment("Typing the search keyword in tips search text box on Nutrition Tips Page");
		nutritionTipsPage.typeSearchKeyword(keyword);
		
		selenium.logComment("Clicking on Search icon on Nutrition Tips Page");
		nutritionTipsPage.clickSearchAsFreeUser();

		selenium.logComment("Verifying that the searched keyword is present in the search results on Nutrition Tips Page");
		assertTrue("Expected search doesn't contain the searched keyword.", selenium.isTextPresent(keyword), selenium);
		
		selenium.logComment("Clicking on one of the tip to view it.");
		nutritionTipsPage.clickTipName(keyword);
		
		selenium.logComment("Verifying the searched tip details are displayed.");
		assertTrue("Expected Tip header is not available.", selenium.isElementPresent("css=div.tip-wrapper>h2:contains("+keyword+")"), selenium);
		assertTrue("Expected recipe header is not available.", selenium.isTextPresent("Back to Nutrition Tips"), selenium);
		assertTrue("Expected text 'Your Rating' is not available.", selenium.isTextPresent("Your Rating"), selenium);
		assertTrue("Expected text 'Average' is not available.", selenium.isTextPresent("Average"), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
	
	/***
	 * This is data provider for testViewNutritionTipsAsClubUser Test Script.
	 */ 
	@DataProvider(name = "viewNutritionTipsClubDataProvider")
	public Object[][] createNutritonTipsData() {
		return new Object[][] {
				{ "Snack"},
		};
	}

	/**
	 * Positive Test script for verifying viewing tips of Nutrition Tips Page.
	 * It verifies if all the required elements are present on the page. 
	 * It then searches for a keyword and clicks on the search result with that keyword to view the tip.
	 */ 
	@Test (dataProvider = "viewNutritionTipsClubDataProvider")
	public void testViewNutritionTipsAsClubUser(String keyword) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to Nutrition Tips Page");
		selenium.logComment("Verifying that all the required elements are present on the Nutrition Tips Page");
		selenium.logComment("Typing the search keyword in tips search text box on Nutrition Tips Page");
		selenium.logComment("Clicking on Search icon on Nutrition Tips Page");
		selenium.logComment("Verifying that the searched keyword is present in the search results on Nutrition Tips Page");
		selenium.logComment("Clicking on one of the tip to view it.");
		selenium.logComment("Verifying the searched tip details are displayed.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

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

		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();
		
		selenium.logComment("Navigating to Nutrition Tips Page");
		NutritionTipsPage nutritionTipsPage = eatSmartPage.goToNutritionTipsPage();
		
		selenium.logComment("Verifying that all the required elements are present on the Nutrition Tips Page");
		assertTrue("Expected header 'Nutrition Tips' is not displayed.", selenium.isElementPresent(NUTRITION_TIPS_HEADER), selenium);
		assertTrue("Expected text 'Team Beachbody makes...' is not displayed.", selenium.isTextPresent("Team Beachbody makes it easy to put together a great diet strategy, but sticking with it can be hard! You may encounter a few obstacles on your journey to better health and fitness, but you don�t have to let them derail your plans. Check out our nutrition tips for advice on just about every diet-related question you may have. From healthy snacking tips to harnessing the power of protein for strong muscles and quicker recovery, we�ll help you follow your meal plan and build the body you deserve."), selenium);
		assertTrue("Expected text '(To rate any...' is not displayed.", selenium.isTextPresent("(To rate any tip from 1 to 5, simply click on the stars underneath.)"), selenium);
		assertTrue("Expected text 'This week's featured...' is not displayed.", selenium.isTextPresent("This week's featured tip "), selenium);
		assertTrue("Expected search textbox for 'Nutrition Tips' is not displayed.", selenium.isElementPresent(TIP_SEARCH_TEXTBOX), selenium);
		assertTrue("Expected search icon for 'Nutrition Tips' is not displayed.", selenium.isElementPresent(TIP_SEARCH_ICON), selenium);
		
		selenium.logComment("Typing the search keyword in tips search text box on Nutrition Tips Page");
		nutritionTipsPage.typeSearchKeyword(keyword);
		
		selenium.logComment("Clicking on Search icon on Nutrition Tips Page");
		nutritionTipsPage.clickSearchAsClubUser();
		
		selenium.logComment("Verifying that the searched keyword is present in the search results on Nutrition Tips Page");
		assertTrue("Expected search doesn't contain the searched keyword.", selenium.isTextPresent(keyword), selenium);
		
		selenium.logComment("Clicking on one of the tip to view it.");
		nutritionTipsPage.clickTipName(keyword);
		
		selenium.logComment("Verifying the searched tip details are displayed.");
		assertTrue("Expected Tip header is not available.", selenium.isElementPresent("css=div.tip-wrapper>h2:contains("+keyword+")"), selenium);
		assertTrue("Expected recipe header is not available.", selenium.isTextPresent("Back to Nutrition Tips"), selenium);
		assertTrue("Expected text 'Your Rating' is not available.", selenium.isTextPresent("Your Rating"), selenium);
		assertTrue("Expected text 'Average' is not available.", selenium.isTextPresent("Average"), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();				
	}
}