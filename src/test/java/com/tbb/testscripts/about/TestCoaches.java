package com.tbb.testscripts.about;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.AboutCoaches;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.about.CoachesPage;
import com.tbb.pages.connect.MemberGallerySearchResultsPage;

/**
 * 
 * This test script contains test method(s) for Coaches page under About module
 * @author Jaya
 */
public class TestCoaches extends BaseTest{

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
	 * Positive Test script for verifying viewing of About Coaches Page.
	 * It verifies if all the required elements are present on the Coaches page. 
	 */ 
	@Test 
	public void testCoaches(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifies whether are on Home page.");
		selenium.logComment("Clicks on 'Sign In' Link.");
		selenium.logComment("Enters valid username and password.");
		selenium.logComment("Clicks on 'About' link.");
		selenium.logComment("Click on About Coaches link.");
		selenium.logComment("Verifies that all the required elements are present on the Coaches page.");
		selenium.logComment("Verifies that user can view Entire Gallery page.");
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
		
		selenium.logComment("Clicking on About Coaches link");
		CoachesPage coachesPage = aboutPage.goToCoachesPage();
		
		selenium.logComment("Verifying that all the required elements are present on the Coaches page.");
		assertTrue("Expected image is not available", selenium.isElementPresent(AboutCoaches.COACHES_HEADER), selenium);
		assertTrue("Expected page header is not available", selenium.isElementPresent(AboutCoaches.COACHES_INTRO_TEXT), selenium);
		assertTrue("Expected image is not available", selenium.isElementPresent(AboutCoaches.COACHES_IMAGE), selenium);
		assertTrue("Expected introductory text is not available", selenium.isElementPresent(AboutCoaches.MEET_A_FEW_OF_OUR_INSPIRINT_COACHES_TEXT), selenium);
		assertTrue("Expected button is not available", selenium.isElementPresent(AboutCoaches.SEE_ENTIRE_GALLERY_LINK), selenium);
		assertTrue("Number of Inspiring Coaches pics displayed is incorrect.", coachesPage.getAllInspiringCoachesPicsCount()==36, selenium );
		assertTrue("Expected page footer is not available", selenium.isElementPresent(AboutCoaches.WHAT_ARE_TEAM_BEACHBODY_COACHES_HEADER), selenium);
		assertTrue("Number of Inspiring Coaches pics displayed is incorrect.", coachesPage.getAllTBBCoachesPicsCount()==3, selenium );
		assertTrue("Number of Inspiring Coaches pics displayed is incorrect.", coachesPage.getAllTBBCoachesTextCount()==3, selenium );
			
		selenium.logComment("Verifying that user can view Entire Gallery page.");
		MemberGallerySearchResultsPage memberGallerySearchResultsPage = coachesPage.clickSeeEntireGalleryLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}