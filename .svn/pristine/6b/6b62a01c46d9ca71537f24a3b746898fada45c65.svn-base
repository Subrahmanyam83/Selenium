package com.tbb.testscripts.getfit;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.WOWYSuperGymStats;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.getfit.GetFitPage;
import com.tbb.pages.getfit.WOWYSuperGymStatsPage;
import com.tbb.pages.getfit.WowySuperGymPage;
/**
 *
 * This test script contains test method(s) for Wowy SuperGym Stats page under Get-Fit module
 *  @author Gaurav
 */

public class TestWOWYSuperGymStats extends BaseTest {

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
	 * This test verifies following:
	 * Verifies count of 'Recent Top SuperGym Users'
	 * Verifies presence of 'Go to Member Gallery' link
	 * Verifies count of 'Top Workout Groups'
	 * Verifies presence of 'Find more groups' link
	 * Verifies count of 'Team Beachbody Programs'
	 * Verifies presence of 'See all programs' link
	 */
	@Test
	public void testWOWYSuperGymStatsPage() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		selenium.logComment("Clicking on 'More statistics' Link");
		selenium.logComment("Verifying count of 'Recent Top SuperGym Users'");
		selenium.logComment("Verifying presence of 'Go to Member Gallery' link");
		selenium.logComment("Verifying count of 'Team Beachbody Programs'");
		selenium.logComment("Verifying presence of 'See all programs' link");
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
	
			
		selenium.logComment("Clicking on 'Get Fit' link");
		GetFitPage getFitPage = dashboardPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		WowySuperGymPage wowySuperGymPage = getFitPage.goToWowySupergymPage();
		
		selenium.logComment("Clicking on 'More statistics' Link");
		WOWYSuperGymStatsPage wOWYSuperGymStatsPage = wowySuperGymPage.clickMoreStatistics();
		if(ConfigFileReader.getConfigItemValue("application.url").equals("www.teambeachbody.com")) {
			selenium.logComment("Verifying count of 'Recent Top SuperGym Users'");
			assertTrue("Count of Recent Top SuperGym Users  should be 5", wOWYSuperGymStatsPage.getRecentTopSuperGymUsersCount() == 5, selenium);
		}
		
		selenium.logComment("Verifying presence of 'Go to Member Gallery' link");
		assertTrue("'Go to Member Gallery' link is not displayed", selenium.isElementPresent(WOWYSuperGymStats.GO_TO_MEMBER_GALLERY_LINK), selenium);
		
		selenium.logComment("Verifying count of 'Top Workout Groups'");
		assertTrue("Count of Top Workout Groups  should be 6", wOWYSuperGymStatsPage.getTopWorkoutGroupsCount() == 6, selenium);
		
		selenium.logComment("Verifying presence of 'Find more groups' link");
		assertTrue("'Find more groups' link is not displayed", selenium.isElementPresent(WOWYSuperGymStats.FIND_MORE_GROUPS_LINK), selenium);
	
		selenium.logComment("Verifying count of 'Team Beachbody Programs'");
		assertTrue("Count of Team Beachbody Programs  should be 4", wOWYSuperGymStatsPage.getTeamBeachbodyProgramsCount() == 4, selenium);
		
		selenium.logComment("Verifying presence of 'See all programs' link");
		assertTrue("'See all programs' link is not displayed", selenium.isElementPresent(WOWYSuperGymStats.SEE_ALL_PROGRAMS_LINK), selenium);
			
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
	}
	
	
	/**
	 * This test verifies that user can send buddy invite to one of the Top Users.
	 */
	@Test
	public void testTopUserBuddyInvite() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		selenium.logComment("Clicking on 'More statistics' Link");
		selenium.logComment("Clicking on First top user's screen name");
		selenium.logComment("Verifying whether 'Add as Buddy' button exists. If yes, click on it");
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
		
		selenium.logComment("Clicking on 'Get Fit' link");
		GetFitPage getFitPage = dashboardPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		WowySuperGymPage wowySuperGymPage = getFitPage.goToWowySupergymPage();
		
		selenium.logComment("Clicking on 'More statistics' Link");
		WOWYSuperGymStatsPage wOWYSuperGymStatsPage = wowySuperGymPage.clickMoreStatistics();
		
		selenium.logComment("Clicking on First top user's screen name");
		selenium.click(WOWYSuperGymStats.RECENT_FIRST_TOP_USER);
		
		selenium.logComment("Verifying whether 'Add as Buddy' button exists. If yes, click on it");
		assertTrue("'Add as a Buddy' button not present", selenium.waitForElementPresent(WOWYSuperGymStats.RECENT_TOP_USER_PROFILE_POP_UP_ADD_AS_A_BUDDY_BUTTON), selenium );
		selenium.click(WOWYSuperGymStats.RECENT_TOP_USER_PROFILE_POP_UP_ADD_AS_A_BUDDY_BUTTON);
		selenium.click(WOWYSuperGymStats.RECENT_TOP_USER_PROFILE_POP_UP_NO_BUTTON);
			
	/*	selenium.logComment("Clicking on 'Close' link");
		selenium.click("css=div.profile-table.popup div.profile-area-close");*/
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
				
		
		
	}
}
