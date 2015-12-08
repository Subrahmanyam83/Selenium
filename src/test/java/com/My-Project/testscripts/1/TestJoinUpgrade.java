package com.tbb.testscripts.about;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.AboutJoinUpgrade;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.about.JoinUpgradePage;

/**
 * 
 * This test script contains test method(s) for Join Upgrade page under About module
 * @author Jaya
 */
public class TestJoinUpgrade extends BaseTest{

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
		 * This is data provider for testViewJoinUpgrade Test Script.
		 */ 
		@DataProvider(name = "viewJoinUpgradeDataProvider")
		public Object[][] createChooseMyMealPlannerData() {
			return new Object[][] {
					{ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"), "club"},
					{ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"), "free"},
			};
		}
	
	/**
	 * Positive Test script for verifying viewing of Join/Upgrade Page.
	 * It verifies if all the required elements are present on the page.  
	 */ 
	@Test (dataProvider = "viewJoinUpgradeDataProvider")
	public void testViewJoinUpgrade(String userName, String password, String userType){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifies whether are on Home page.");
		selenium.logComment("Clicks on 'Sign In' Link.");
		selenium.logComment("Enters valid username and password.");
		selenium.logComment("Clicks on 'About' link.");
		selenium.logComment("Clicks on 'Join/Upgrade' link");
		selenium.logComment("Verifies that all the required elements are available on the Join/Upgrade Page.");
		selenium.logComment("Executes assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
	
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(userName, password);
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(userName, password);
		}
				
		selenium.logComment("Clicking on 'About' link");
		AboutPage aboutPage = dashboardPage.clickAboutLink();
		
		selenium.logComment("Clicking on 'Join/Upgrade' link");
		JoinUpgradePage joinUpgradePage = aboutPage.goToJoinUpgradePage();
		
		selenium.logComment("Verifying that all the required elements are available on the Join/Upgrade Page.");
		assertTrue("Expected Sign Up Header is not available", selenium.isElementPresent(AboutJoinUpgrade.SIGNUP_HEADER), selenium);
		assertTrue("Expected Sign up Header image text is not available", selenium.isElementPresent(AboutJoinUpgrade.SIGNUP_HEADER_IMAGE_TEXT), selenium);
		assertTrue("Expected Join header is not available", selenium.isElementPresent(AboutJoinUpgrade.JOIN_UPGRADE_PREHEADER), selenium);
		assertTrue("Expected Join Upgrade page header is not available", selenium.isElementPresent(AboutJoinUpgrade.JOIN_UPGRADE_HEADER), selenium);
		assertTrue("Expected Join Upgrade Post header is not available", selenium.isElementPresent(AboutJoinUpgrade.JOIN_UPGRADE_POSTHEADER), selenium);
		assertTrue("Expected introduction text is not available", selenium.isElementPresent(AboutJoinUpgrade.INTRO_TEXT), selenium);
		assertTrue("Expected Working out.. text is not available", selenium.isElementPresent(AboutJoinUpgrade.WORKING_OUT_IS_JUST_ONE_PIECE_SUB_HEADER), selenium);
		assertTrue("Expected sub header introduction text is not available", selenium.isElementPresent(AboutJoinUpgrade.SUB_HEADER_INTRO_TEXT), selenium);
		
		assertTrue("Expected Sign up grid header is not available", selenium.isElementPresent(AboutJoinUpgrade.SIGNUP_GRID_HEADER), selenium);		
		assertTrue("Expected Sign up grid is not available", selenium.isElementPresent(AboutJoinUpgrade.SIGNUP_GRID), selenium);
		assertTrue("All TBB Membership benefit rows are not displayed", joinUpgradePage.getMembershipBenefitRowsCount()==6, selenium );
		assertTrue("All TBB Membership benefit club column rows are not checked.", joinUpgradePage.getClubCheckedRowsCount()==6, selenium );
		assertTrue("All TBB Membership benefit club column rows are not checked.", joinUpgradePage.getFreeCheckedRowsCount()==3, selenium );
		assertTrue("All TBB Membership benefit club column rows are not checked.", joinUpgradePage.getFreeUncheckedRowsCount()==3, selenium );
		 
		assertTrue("Expected Secondary text: Join Teambeachbody Today is not available", selenium.isElementPresent(AboutJoinUpgrade.SECONDARY_TEXT_JOIN_TEAMBEACHBODY_TODAY), selenium);
		assertTrue("Expected secondary image is not available", selenium.isElementPresent(AboutJoinUpgrade.SECONDARY_IMAGE), selenium);
		assertTrue("All TBB Membership benefit club column rows are not checked.", joinUpgradePage.getSecondaryTextParagraphsCount()==3, selenium );
		
		if(userType.equals("free")){
			assertTrue("Expected is not available", selenium.isElementPresent(AboutJoinUpgrade.YES_SIGN_ME_UP_FOR_CLUB_MEMBERSHIP), selenium);
			assertTrue("Expected is not available", selenium.isElementPresent(AboutJoinUpgrade.SIGN_ME_UP_FOR_FREE_MEMBERSHIP), selenium);
			assertTrue("Expected is not available", selenium.isElementPresent(AboutJoinUpgrade.CLUB_SIGN_UP_BUTTON_AT_THE_BOTTOM), selenium);
			assertTrue("Expected is not available", selenium.isElementPresent(AboutJoinUpgrade.FREE_SIGN_UP_BUTTON_AT_THE_BOTTOM), selenium);
		}
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}