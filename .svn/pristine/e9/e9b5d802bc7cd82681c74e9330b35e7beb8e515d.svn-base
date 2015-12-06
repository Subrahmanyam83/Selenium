package com.tbb.testscripts.clubukuser;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.MessageBoards;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.MessageBoardsPage;

/**
 * 
 * This test script contains test method(s) for alerts shown on Message Boards page for UK Club user.
 * @author Jaya
 */
public class TestMessageBoardsAlert extends BaseTest{

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
	 * Positive Test script for verifying that the Club UK User alert is displayed on Message Boards Page.
	 */ 
	@Test
	public void testMessageBoardsAlertAsClubUKuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Connect Page.");
		selenium.logComment("Navigate to Message Boards Page.");
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards main page.");
		selenium.logComment("Navigating to Message Boards - Categories Tab.");
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards - Categories Tab.");
		selenium.logComment("Navigating to Message Boards - My Posts Tab.");
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards - My Posts.");
		selenium.logComment("Navigating to Message Boards - Recent Posts Tab.");
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards - Recent Posts Tab.");
		selenium.logComment("Navigating to Message Boards - Statistics Tab.");
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards - Statistics Tab.");
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
		
		selenium.logComment("Navigate to Connect Page.");	
		ConnectPage connectPage = dashboardPage.clickConnectLink();
		
		selenium.logComment("Navigate to Message Boards Page.");	
		MessageBoardsPage messageBoardsPage = connectPage.goToMessageBoardsPage();
		
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards main page.");		
		assertTrue("Alert is missing.", (selenium.isVisible(MessageBoards.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Alert text is missing.", (selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigating to Message Boards - Categories Tab.");	
		messageBoardsPage.clickCategoriesTab();
		
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards - Categories Tab.");		
		assertTrue("Alert is missing.", (selenium.isVisible(MessageBoards.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Alert text is missing.", (selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigating to Message Boards - My Posts Tab.");	
		messageBoardsPage.clickMyPostsTab();
		
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards - My Posts.");		
		assertTrue("Alert is missing.", (selenium.isVisible(MessageBoards.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Alert text is missing.", (selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigating to Message Boards - Recent Posts Tab.");	
		messageBoardsPage.clickRecentPostsTab();
		
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards - Recent Posts Tab.");		
		assertTrue("Alert is missing.", (selenium.isVisible(MessageBoards.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Alert text is missing.", (selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigating to Message Boards - Statistics Tab.");	
		messageBoardsPage.clickStatisticsTab();
		
		selenium.logComment("Verifying alert is available to Club UK User on Message Boards - Statistics Tab.");		
		assertTrue("Alert is missing.", (selenium.isVisible(MessageBoards.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Alert text is missing.", (selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/**
	 * Positive Test script for verifying that the Free User does not see Club UK user alert on Message Boards page.
	 */ 
	@Test
	public void testMessageBoardsAlertAsFreeuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Connect Page.");
		selenium.logComment("Navigate to Message Boards Page.");
		selenium.logComment("Verifying alert is not available to Free User on Message Boards main page.");
		selenium.logComment("Navigating to Message Boards - Categories Tab.");
		selenium.logComment("Verifying alert is not available to Free User on Message Boards - Categories Tab.");
		selenium.logComment("Navigating to Message Boards - My Posts Tab.");
		selenium.logComment("Verifying alert is not available to Free User on Message Boards - My Posts.");
		selenium.logComment("Navigating to Message Boards - Recent Posts Tab.");
		selenium.logComment("Verifying alert is not available to Free User on Message Boards - Recent Posts Tab.");
		selenium.logComment("Navigating to Message Boards - Statistics Tab.");
		selenium.logComment("Verifying alert is not available to Free User on Message Boards - Statistics Tab.");
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

		selenium.logComment("Navigate to Connect Page.");	
		ConnectPage connectPage = dashboardPage.clickConnectLink();
		
		selenium.logComment("Navigate to Message Boards Page.");	
		MessageBoardsPage messageBoardsPage = connectPage.goToMessageBoardsPage();
		
		selenium.logComment("Verifying alert is not available to Free User on Message Boards main page.");		
		assertTrue("Club UK User Alert text is available to free user.", !(selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigating to Message Boards - Categories Tab.");	
		messageBoardsPage.clickCategoriesTab();
		
		selenium.logComment("Verifying alert is not available to Free User on Message Boards - Categories Tab.");		
		assertTrue("Club UK User Alert text is available to free user.", !(selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigating to Message Boards - My Posts Tab.");	
		messageBoardsPage.clickMyPostsTab();
		
		selenium.logComment("Verifying alert is not available to Free User on Message Boards - My Posts.");		
		assertTrue("Club UK User Alert text is available to free user.", !(selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigating to Message Boards - Recent Posts Tab.");	
		messageBoardsPage.clickRecentPostsTab();
		
		selenium.logComment("Verifying alert is not available to Free User on Message Boards - Recent Posts Tab.");		
		assertTrue("Club UK User Alert text is available to free user.", !(selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigating to Message Boards - Statistics Tab.");	
		messageBoardsPage.clickStatisticsTab();
		
		selenium.logComment("Verifying alert is not available to Free User on Message Boards - Statistics Tab.");		
		assertTrue("Club UK User Alert text is available to free user.", !(selenium.isTextPresent("Shakeology® is not available for sale in the UK at this time. Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}