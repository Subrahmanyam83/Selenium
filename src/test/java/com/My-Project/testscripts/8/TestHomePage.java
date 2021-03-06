package com.tbb.testscripts.general;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

/**
 *
 * This test script contains test method(s) for verifying functionality related to User's Home page
 *  @author Gaurav
 */

public class TestHomePage extends BaseTest {
	

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
	 * This test verifies UI of Home page.
	 * It also verifies:
	 * User Status Bar Headings
     * site's description and current time
	 * Ticker's Heading
	 * visibilility of Newsletter portlet
	 * visibilility of Video portlet
	 * visibilility of What's New portlet
	 * visibilility of Hot Topics portlet
	 * visibilility of Daily Winner Portlet
	 * visibilility of Shakeology portlet
	 * visibilility of Coach Club Upsell portlet on LRM
	 * visibilility of Featured Products
	 * visibilility of Success Stories
	 * visibilility of Coach Club Upsell portlet on RRM
	 * 
	 */
	@Test
	public void testHomePage(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Home' link");
		selenium.logComment("Verifying User Status Bar Headings");
		selenium.logComment("Verifying site's description and current time");
		selenium.logComment("Verifying Ticker's Heading");
		selenium.logComment("Verifying visibilility of Newsletter portlet");
		selenium.logComment("Verifying visibilility of Video portlet");
		selenium.logComment("Verifying visibilility of What's New portlet");
		selenium.logComment("Verifying visibilility of Hot Topics portlet");
		selenium.logComment("Verifying visibilility of Daily Winner Portlet");
		selenium.logComment("Verifying visibilility of Shakeology portlet");
		selenium.logComment("Verifying visibilility of Coach Club Upsell portlet on LRM");
		selenium.logComment("Verifying visibilility of Featured Products");
		selenium.logComment("Verifying visibilility of Success Stories");
		selenium.logComment("Verifying visibilility of Coach Club Upsell portlet on RRM");
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
		
		
		selenium.logComment("Clicking on 'Home' link");
		homePage = dashboardPage.clickHome();
		
		
		selenium.logComment("Verifying User Status Bar Headings");
		String actualValues[] = homePage.getUserStatusBarDocks(); // This method verifies whether required element is visible or not. If yes, then returns main headings of 6 docks.
		String expectedValues[] = {"My Dashboard", "Inbox", "Buddies", "Workouts", "What's new at Team Beachbody?", "Goal Tracker"};
		assertTrue("Correct Values not shown on User Status Bar", Arrays.equals(actualValues, expectedValues), selenium);
		
			
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMMMMMMMMM dd, yyyy");
		Date currentDateTime = new Date(System.currentTimeMillis());
				
		selenium.logComment("Verifying site's description and current time");
		assertTrue("Site Description on Site's Home page is not correct", homePage.getSiteDesciption().equals("A community for fit and healthy living"), selenium );
		assertTrue("Current time on Site's Home page is not correct", homePage.getCurrentDate().equals(DATE_FORMAT.format(currentDateTime)), selenium );
		
		selenium.logComment("Verifying Ticker's Heading");
		assertTrue("Ticker has different heading.", homePage.getTickerHeading().equals("Team Beachbody Keeps Growing"), selenium );
		
		selenium.logComment("Verifying visibilility of Newsletter portlet");
		assertTrue("Newsletter Portlet is not visible", homePage.newsLetterPortletExists(), selenium);
		
		selenium.logComment("Verifying visibilility of Video portlet");
		assertTrue("Video is not visible", homePage.videoPortletExists(), selenium);
				
		selenium.logComment("Verifying visibilility of What's New portlet");
		assertTrue("Whats New Portlet is not visible", homePage.whatsNewPortletExists(), selenium);
		
		selenium.logComment("Verifying visibilility of Hot Topics portlet");
		assertTrue("Hot Topics Portlet is not visible", homePage.hotTopicsPortletExists(), selenium);
		
		selenium.logComment("Verifying visibilility of Daily Winner Portlet");
		assertTrue("Daily Winner Portlet is not visible", homePage.dailyWinnerExistsOnLRM(), selenium);
		
		selenium.logComment("Verifying visibilility of Shakeology portlet");
		assertTrue("Shakeology Portlet is not visible", homePage.shakeologyExistsOnLRM(), selenium);
		
		selenium.logComment("Verifying visibilility of Coach Club Upsell portlet on LRM");
		assertTrue("Coach Club Up Sell is not visible on LRM", homePage.coachClubUpSellExistsOnLRM(), selenium);
		
		selenium.logComment("Verifying visibilility of Featured Products");
		assertTrue("Featured Products Portlet is not visible", homePage.featuredProductsExistsOnRRM(), selenium);
		
		selenium.logComment("Verifying visibilility of Success Stories");
		assertTrue("Success Stories Portlet is not visible", homePage.successStroiesExistsOnRRM(), selenium);
		
			
		selenium.logComment("Verifying visibilility of Coach Club Upsell portlet on RRM");
		assertTrue("Coach/Club Up Sell is not visible", homePage.coachClubUpSellExistsOnRRM(), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
				
		
	}
}
