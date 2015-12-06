package com.tbb.testscripts.clubukuser;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.Contests;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.ContestsPage;
import com.tbb.pages.connect.DailySweepstakesPage;
import com.tbb.pages.connect.TheBeachbodyChallengePage;

/**
 * 
 * This test script contains test method(s) for alerts shown on Contest page for UK Club user.
 * @author Jaya
 */
public class TestContestAlert extends BaseTest{

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
	 * Test script for verifying that the Club UK User alert is displayed on Contests Page.
	 */ 
	@Test
	public void testContestsAlertAsClubUKuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Connect Page.");
		selenium.logComment("Navigate to Contests Page.");
		selenium.logComment("Verifying alert is available on Contests main page.");
		selenium.logComment("Navigate to Daily Sweepstakes Page.");
		selenium.logComment("Verifying alert is available on Contests - Daily Sweepstakes Page.");
		selenium.logComment("Navigate to Contest FAQ Page.");
		selenium.logComment("Verifying alert is available on Contests - Contest FAQ Page.");
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
		
		selenium.logComment("Navigate to Contests Page.");	
		ContestsPage contestsPage = connectPage.goToContestsPage();
		
		selenium.logComment("Verifying alert is available on Contests main page.");		
		assertTrue("Club UK User Alert is missing.", (selenium.isElementPresent(Contests.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing.", (selenium.isTextPresent("Sweepstakes and contests currently only available to U.S. residents.")), selenium);
		
		selenium.logComment("Navigate to Daily Sweepstakes Page.");	
		DailySweepstakesPage dailySweepstakesPage = contestsPage.goToDailySweepstakesPage();
		
		selenium.logComment("Verifying alert is available on Contests - Daily Sweepstakes Page.");		
		assertTrue("Club UK User Alert is missing.", (selenium.isElementPresent(Contests.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing.", (selenium.isTextPresent("Sweepstakes and contests currently only available to U.S. residents.")), selenium);
		
		selenium.logComment("Navigate to Contest FAQ Page.");	
		dailySweepstakesPage.goToContestFAQPage();
		
		selenium.logComment("Verifying alert is available on Contests - Contest FAQ Page.");		
		assertTrue("Club UK User Alert is missing.", (selenium.isElementPresent(Contests.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing.", (selenium.isTextPresent("Sweepstakes and contests currently only available to U.S. residents.")), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/**
	 * Test script for verifying that the Free User does not see Club UK user alert on Contests page.
	 */ 
	@Test
	public void testContestsAlertAsFreeuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Connect Page.");
		selenium.logComment("Navigate to Contests Page.");
		selenium.logComment("Verifying alert is available on Contests main page.");
		selenium.logComment("Navigate to Daily Sweepstakes Page.");
		selenium.logComment("Verifying alert is available on Contests - Daily Sweepstakes Page.");
		selenium.logComment("Navigate to The Beachbody Challenge Page.");
		selenium.logComment("Verifying alert is not available on Contests - The Beachbody Challenge Page.");
		selenium.logComment("Navigate to Contest FAQ Page.");
		selenium.logComment("Verifying alert is available on Contests - Contest FAQ Page.");
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
		
		selenium.logComment("Navigate to Contests Page.");	
		ContestsPage contestsPage = connectPage.goToContestsPage();
		
		selenium.logComment("Verifying alert is available on Contests main page.");		
		assertTrue("Club UK User Alert text is available to free user on Contests main page.", !(selenium.isTextPresent("Sweepstakes and contests currently only available to U.S. residents.")), selenium);
		
		selenium.logComment("Navigate to Daily Sweepstakes Page.");	
		DailySweepstakesPage dailySweepstakesPage = contestsPage.goToDailySweepstakesPage();
		
		selenium.logComment("Verifying alert is available on Contests - Daily Sweepstakes Page.");		
		assertTrue("Club UK User Alert text is available to free user on Daily Sweepstakes page.", !(selenium.isTextPresent("Sweepstakes and contests currently only available to U.S. residents.")), selenium);
		
		selenium.logComment("Navigate to The Beachbody Challenge Page.");	
		TheBeachbodyChallengePage theBeachbodyChallengePage = dailySweepstakesPage.goToTheBeachbodyChallenge();
		
		selenium.logComment("Verifying alert is not available on Contests - The Beachbody Challenge Page.");		
		assertTrue("Club UK User Alert text is available to free user on The Beachbody Challenge Page.", !(selenium.isTextPresent("Sweepstakes and contests currently only available to U.S. residents.")), selenium);
		
		selenium.logComment("Navigate to Contest FAQ Page.");	
		theBeachbodyChallengePage.goToContestFAQPage();
		
		selenium.logComment("Verifying alert is available on Contests - Contest FAQ Page.");		
		assertTrue("Club UK User Alert text is available to free user on Contest FAQ Page.", !(selenium.isTextPresent("Sweepstakes and contests currently only available to U.S. residents.")), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}