package com.tbb.testscripts.others;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.coach.CoachPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.getfit.GetFitPage;
import com.tbb.pages.watchvideos.WatchVideosPage;

/**
 *
 * This test script contains test method for verifying that TBB Logo navigation is working fine
 * from different pages.
 *  @author Gaurav
 */
public class TestTBBLogoNavigation extends BaseTest {

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
	
	/*
	 * This test verifies that Logo Navigation is working fine from following important pages:
	 * Logo Navigation (LN) from home page
	 * LN from Sign In Page
	 * LN from Dashboard page
	 * LN from Get Fit Page
	 * LN from Eat Smart Page
	 * LN from Connect page
	 * LN from Watch Videos Page
	 * LN from About Page
	 * LN from Coach Page
	 */
	
	@Test
	public void testLogoNavigation() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on TBB Logo");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on TBB Logo");
		selenium.logComment("Navigating to 'Get Fit' page");
		selenium.logComment("Navigating to 'Eat Smart' page");
		selenium.logComment("Navigating to 'Connect' page");
		selenium.logComment("Navigating to 'Watch Videos' page");
		selenium.logComment("Navigating to 'About' page");
		selenium.logComment("Navigating to 'Coach' page");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on TBB Logo");
		homePage = homePage.clickTBBLogo();
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.clubuser"), ConfigFileReader.getConfigItemValue("tbb.clubpassword"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.clubuser"), ConfigFileReader.getConfigItemValue("tbb.clubpassword"));
		}
	
		selenium.logComment("Clicking on TBB Logo");
		homePage = dashboardPage.clickTBBLogo();
		

		selenium.logComment("Navigating to 'Get Fit' page");
		GetFitPage getFitPage = homePage.clickGetFitLink();
		selenium.logComment("Clicking on TBB Logo");
		homePage = getFitPage.clickTBBLogo();
		
		
		selenium.logComment("Navigating to 'Eat Smart' page");
		EatSmartPage eatSmartPage = homePage.clickEatSmartLink();
		selenium.logComment("Clicking on TBB Logo");
		homePage = eatSmartPage.clickTBBLogo();	
		
		
		selenium.logComment("Navigating to 'Connect' page");
		ConnectPage connectPage = homePage.clickConnectLink();
		selenium.logComment("Clicking on TBB Logo");
		homePage = connectPage.clickTBBLogo();
		
		selenium.logComment("Navigating to 'Watch Videos' page");
		WatchVideosPage watchVideosPage = homePage.clickWatchVideosLink();
		selenium.logComment("Clicking on TBB Logo");
		homePage = watchVideosPage.clickTBBLogo();
		
		
		selenium.logComment("Navigating to 'About' page");
		AboutPage aboutPage = homePage.clickAboutLink();
		selenium.logComment("Clicking on TBB Logo");
		homePage = aboutPage.clickTBBLogo();
		
		
		selenium.logComment("Navigating to 'Coach' page");
		CoachPage coachPage = homePage.clickCoachLink();
		selenium.logComment("Clicking on TBB Logo");
		homePage = coachPage.clickTBBLogo();
			
	}
}
