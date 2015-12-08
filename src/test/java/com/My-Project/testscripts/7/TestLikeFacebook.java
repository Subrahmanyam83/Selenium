package com.tbb.testscripts.facebook;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;

public class TestLikeFacebook extends BaseTest{

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
	 * This is data provider for testFacebookLikeAbilityUnlinkedAccount Test Script.
	 */ 
	@DataProvider(name = "likeOnFBDataProvider")
	public Object[][] createLikeFBUserData() {
		return new Object[][] {
				{"prnshrm9@gmail.com", "beachbody"},
		};
	}
	/**
	 * Test script for verifying viewing Like ability of facebook.
	 */ 
	@Test (dataProvider = "likeOnFBDataProvider")
	public void testFacebookLikeAbilityUnlinkedAccount(String facebookUsername, String facebookPassword){
			selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
			Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
			
			
			
			selenium.logComment("################## Scope of this test method ######################");
			selenium.logComment("Verifying whether are on Home page");
			selenium.logComment("Clicking on 'Sign In' Link");
			selenium.logComment("Entering valid username and password");
			selenium.logComment("Verify clicking on Like link.");
			selenium.logComment("Verifying Logging into facebook.");
			selenium.logComment("Verifying refreshing the dashboard page.");
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
			
			selenium.logComment("Verify clicking on Like link.");
			assertTrue("All links are not displayed", selenium.isElementPresent("css=a[class='connect_widget_like_button clearfix like_button_no_like'] span.liketext"), selenium );
			dashboardPage.clickLike();			
					
			selenium.logComment("Verifying Logging into facebook.");			
			dashboardPage.likeFacebookAsUnlinkedAccount(facebookUsername, facebookPassword);
			
			selenium.logComment("Verifying refreshing the dashboard page.");	
			dashboardPage.clickTopmostTeamBeachbodyImage();
			
			selenium.logComment("Executing assertEmpty method");
			emptyMessageBuilder();
		}
}