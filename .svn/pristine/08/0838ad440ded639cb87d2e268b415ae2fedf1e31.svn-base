package com.tbb.testscripts.about;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.AboutDailySweepstakes;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.about.DailySweepstakesPage;
import com.tbb.pages.getfit.WowySuperGymPage;

/**
 * 
 * This test script contains test method(s) for Daily Sweepstakes page under About module
 * @author Jaya
 */
public class TestDailySweepstakes extends BaseTest{

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
	 * This is data provider for testDailySweepstakes Test Script.
	 */ 
	@DataProvider(name = "viewAboutDailySweepstakesDataProvider")
	public Object[][] createAboutDailySweepstakesData() {
		return new Object[][] {
				{ "mgupta@beachbody.com", "b@b2011"},
		};
	}
	/**
	 * Positive Test script for verifying viewing of Daily Sweep stakes Page.
	 * It verifies if all the required elements are present on the Daily Sweep stakes menu. 
	 */ 
	@Test (dataProvider = "viewAboutDailySweepstakesDataProvider")
	public void testDailySweepstakes(String userName,String password){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifies whether on Home Page");
		selenium.logComment("Clicks on Sign In link");
		selenium.logComment("Enters valid username and password");
		selenium.logComment("Clicks on about link");
		selenium.logComment("Clicks on Daily Sweep stakes link");
		selenium.logComment("Verifies whether all the required elements are present on the Daily Sweep stakes page.");
		selenium.logComment("Verifies whether user can navigate to Work out Now page.");
		selenium.logComment("Clicks on 'About' link");
		selenium.logComment("Clicks on Daily Sweep stakes link");
		selenium.logComment("Verifies whether user can navigate to the Beachbody challenge page.");
		selenium.logComment("Executes assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}
		
		selenium.logComment("Clicking on 'About' link");
		AboutPage aboutPage = dashboardPage.clickAboutLink();
		
		selenium.logComment("Clicking on Daily Sweep stakes link");
		DailySweepstakesPage dailySweepstakesPage = aboutPage.goToDailySweepstakesPage();
		
		selenium.logComment("Verifying that all the required elements are present on the Daily Sweep stakes page.");
		assertTrue("Expected image is not available", selenium.isElementPresent(AboutDailySweepstakes.DAILY_SWEEPSTAKES_TOP_IMAGE), selenium);
		assertTrue("Expected page header is not available", selenium.isElementPresent(AboutDailySweepstakes.DAILY_SWEEPSTAKES_HEADER), selenium);
		assertTrue("Expected image is not available", selenium.isElementPresent(AboutDailySweepstakes.DAILY_SWEEPSTAKES_SMALL_IMAGE), selenium);
		assertTrue("Expected introductory text is not available", selenium.isElementPresent(AboutDailySweepstakes.ALL_DAILY_SWEEPSTAKES_INTRO_TEXT), selenium);
		assertTrue("Expected button is not available", selenium.isElementPresent(AboutDailySweepstakes.WORKOUT_NOW_BUTTON), selenium);
		assertTrue("Expected button is not available", selenium.isElementPresent(AboutDailySweepstakes.ENTER_THE_BEACHBODY_CHALLENGE_BUTTON), selenium);
		assertTrue("Expected page footer is not available", selenium.isElementPresent(AboutDailySweepstakes.DAILY_SWEEPSTAKES_FOOTER), selenium);
		assertTrue("Expected footer link is not available", selenium.isElementPresent(AboutDailySweepstakes.WOWY_SUPERGYM_DAILY_SWEEPSTAKES_RULES_LINK), selenium);
		
		selenium.logComment("Verifying that user can navigate to Work out Now page.");
		WowySuperGymPage wowySuperGymPage = dailySweepstakesPage.clickWorkOutNowButton();
		
		selenium.logComment("Clicking on 'About' link");
		aboutPage = wowySuperGymPage.clickAboutLink();
		
		selenium.logComment("Clicking on Daily Sweep stakes link");
		dailySweepstakesPage = aboutPage.goToDailySweepstakesPage();
		
		selenium.logComment("Verifying that user can navigate to the Beachbody challenge page.");
		dailySweepstakesPage.clickEnterTheBeachbodyChallengeButton();	
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
		}
}