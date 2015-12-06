package com.tbb.testscripts.clubukuser;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.ShakeologyRecipesTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.eatsmart.ShakeologyRecipesGreenberryPage;
import com.tbb.pages.eatsmart.ShakeologyRecipesPage;
/**
 * 
 * This test script contains test method(s) for alerts shown on Shakeology page for UK Club user.
 * @author Jaya
 */
public class TestShakeologyAlert extends BaseTest{

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
	 * Test script for verifying that Club UK User alert is displayed on Shakeology, Greenberry 
	 * and Chocolate Page to the Club UK User.
	 */ 
	@Test
	public void testShakeologyAlertAsClubUKuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Eat Smart Page.");
		selenium.logComment("Navigate to Shakeology Recipes Page.");
		selenium.logComment("Verifying that Club UK User alert is available on Shakeology Recipes Page.");
		selenium.logComment("Navigate to Greenberry Page.");
		selenium.logComment("Verifying that Club UK User alert is available on Greenberry Page.");
		selenium.logComment("Navigate to Chocolate Page.");
		selenium.logComment("Verifying that Club UK User alert is available on Chocolate Page.");
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
		
		selenium.logComment("Navigate to Shakeology Recipes Page.");	
		ShakeologyRecipesPage shakeologyRecipesPage = eatSmartPage.goToShakeologyRecipesPage();
		
		selenium.logComment("Verifying that Club UK User alert is available on Shakeology Recipes Page.");		
		assertTrue("Club UK User Alert is missing from Shakeology Recipes Page.", (selenium.isElementPresent(ShakeologyRecipesTab.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Shakeology Recipes page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to Greenberry Page.");	
		ShakeologyRecipesGreenberryPage greenberryPage = shakeologyRecipesPage.goToGreenberryPage();
		
		selenium.logComment("Verifying that Club UK User alert is available on Greenberry Page.");		
		assertTrue("Club UK User Alert is missing from Greenberry Page.", (selenium.isElementPresent(ShakeologyRecipesTab.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Greenberry page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);

		selenium.logComment("Navigate to Chocolate Page.");	
		greenberryPage.goToChocolatePage();
		
		selenium.logComment("Verifying that Club UK User alert is available on Chocolate Page.");		
		assertTrue("Club UK User Alert is missing from Chocolate Page.", (selenium.isElementPresent(ShakeologyRecipesTab.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Chocolate page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/**
	 * Test script for verifying that the Club UK User alert is not displayed on Shakeology, 
	 * Greenberry and Chocolate Page for Free User.
	 */ 
	@Test
	public void testShakeologyAlertAsFreeUser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Eat Smart Page.");
		selenium.logComment("Navigate to Shakeology Recipes Page.");
		selenium.logComment("Verifying that Club UK User alert is available on Shakeology Recipes Page.");
		selenium.logComment("Navigate to Greenberry Page.");
		selenium.logComment("Verifying that Club UK User alert is available on Greenberry Page.");
		selenium.logComment("Navigate to Chocolate Page.");
		selenium.logComment("Verifying that Club UK User alert is available on Chocolate Page.");
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
		
		selenium.logComment("Navigate to Shakeology Recipes Page.");	
		ShakeologyRecipesPage shakeologyRecipesPage = eatSmartPage.goToShakeologyRecipesPage();
		
		selenium.logComment("Verifying that Club UK User alert is available on Shakeology Recipes Page.");		
		assertTrue("Alert text is missing.", !(selenium.isVisible("css=div.portlet-borderless-container > div > div > p > span.portlet-msg-error")), selenium);
		 
		selenium.logComment("Navigate to Greenberry Page.");	
		ShakeologyRecipesGreenberryPage greenberryPage = shakeologyRecipesPage.goToGreenberryPage();
		
		selenium.logComment("Verifying that Club UK User alert is available on Greenberry Page.");		
		assertTrue("Alert text is missing.", !(selenium.isVisible("css=div.portlet-borderless-container > div > div > p > span.portlet-msg-error")), selenium);
		
		selenium.logComment("Navigate to Chocolate Page.");	
		greenberryPage.goToChocolatePage();
		
		selenium.logComment("Verifying that Club UK User alert is available on Chocolate Page.");		
		assertTrue("Alert text is missing.", !(selenium.isVisible("css=div.portlet-borderless-container > div > div > p > span.portlet-msg-error")), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}