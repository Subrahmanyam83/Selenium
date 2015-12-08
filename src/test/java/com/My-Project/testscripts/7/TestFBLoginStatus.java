package com.tbb.testscripts.facebook;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.Home;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.MyAccountPage;
import com.tbb.pages.SignInPage;

public class TestFBLoginStatus extends BaseTest{

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
	 * This is data provider for testSignOutWithLinkedAccount Test Script.
	 */ 
	@DataProvider(name = "FBDataProvider")
	public Object[][] createLikeFBUserData() {
		return new Object[][] {
				{"prnshrm9@gmail.com", "beachbody"},
		};
	}
	/**
	 * Test script for verifying that signing out from facebook account also signs out user from teambeachbody website.
	 */ 
	@Test (dataProvider = "FBDataProvider")
	public void testSignOutWithLinkedAccount(String facebookUsername, String facebookPassword){
			selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
			Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
			
			selenium.logComment("################## Scope of this test method ######################");
			selenium.logComment("Verifying whether are on Home page");
			selenium.logComment("Clicking on 'Sign In' Link");
			selenium.logComment("Entering valid username and password");
			selenium.logComment("Verify clicking on Link Account link.");
			selenium.logComment("Verifying Logging into facebook.");
			selenium.logComment("Verifying if link account link has been removed from Dashboard.");
			selenium.logComment("Clicking on TBB Logo to refresh the page.");
			selenium.logComment("Clicking on facebook sign out button.");
			selenium.logComment("Verifying if user is signed out.");
			selenium.logComment("Clicking on 'Sign In' Link");
			selenium.logComment("Clicking on 'Sign In' Link");
			selenium.logComment("Entering valid username and password");
			selenium.logComment("Navigate to My Account Page.");
			selenium.logComment("Clicking on Unlink button on My Account Page.");
			selenium.logComment("Verifying if link account link is now available.");
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
			
			selenium.logComment("Verify clicking on Link Account link.");
			assertTrue("Link Account link is not displayed", selenium.isElementPresent(Dashboard.LINK_ACCOUNT), selenium );
			
			selenium.logComment("Verifying Logging into facebook.");			
			dashboardPage.linkFacebookAccount(facebookUsername, facebookPassword);			
					
			selenium.logComment("Verifying if link account link has been removed from Dashboard.");	
			assertTrue("Link Account link is displayed", !selenium.isElementPresent(Dashboard.LINK_ACCOUNT), selenium );
			
			selenium.logComment("Clicking on TBB Logo to refresh the page.");
			dashboardPage.clickTBBLogo();
			
			selenium.logComment("Clicking on facebook sign out button.");
			homePage = dashboardPage.clickFacebookSignOut();			
			
			selenium.logComment("Verifying if user is signed out.");	
			assertTrue("Link Account link is displayed", selenium.isElementPresent(Home.SIGN_IN_LINK), selenium );
			
			selenium.logComment("Clicking on 'Sign In' Link");
			if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
				dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
			} else {
				SignInPage signInPage = homePage.clickSignIn();
				
				selenium.logComment("Entering valid username and password");
				dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
			}
			
			selenium.logComment("Navigate to My Account Page.");
			MyAccountPage myAccountPage = dashboardPage.clickMyAccountLink();
			
			selenium.logComment("Clicking on Unlink button on My Account Page.");
			myAccountPage.clickFacebookUnlink();			
			
			selenium.logComment("Verifying if link account link is now available.");	
			assertTrue("Link Account link is displayed", selenium.isElementPresent(Dashboard.LINK_ACCOUNT), selenium );
			
			selenium.logComment("Executing assertEmpty method");
			emptyMessageBuilder();
		}	
}