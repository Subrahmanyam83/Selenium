package com.tbb.testscripts.general;

import java.lang.reflect.Method;
import java.util.Arrays;

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
 * This test script contains test method(s) for verifying functionality related to User Staus Bar
 * @author Gaurav
 */
public class TestUserStatusBar extends BaseTest {
	
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
	 * This method verifies Under all user docks we are getting required links when user expands a particular user dock
	 */
	@Test
	public void testUserStatusBar() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Verifying Inbox Dock Links");
		selenium.logComment("Verifying Buddies Dock Links");
		selenium.logComment("Verifying Workout Dock Links");
		selenium.logComment("Verifying Goal Tracker Dock Links");
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
	
		
		homePage = dashboardPage.clickHome();
		
		selenium.logComment("Verifying Inbox Dock Links");	
		String actualInboxLinks[] = homePage.getInboxLinks(); 
		String expectedInboxLinks[] = {"Inbox", "Message Center", "Go to Inbox"};
		assertTrue("Correct Values not shown on User Status Bar", Arrays.equals(actualInboxLinks, expectedInboxLinks) , selenium);
		
		
		selenium.logComment("Verifying Buddies Dock Links");	
		String actualBuddiesLinks[] = homePage.getBuddiesLinks(); 		
		String expectedBuddiesLinks[] = {"Buddies", "Find New Buddies", "View my Buddy Invitations", "View my Buddies"};
		assertTrue("Correct Values not shown on User Status Bar", Arrays.equals(actualBuddiesLinks, expectedBuddiesLinks) , selenium);
		
		selenium.logComment("Verifying Workout Dock Links");	
		String actualWorkoutLinks[] = homePage.getWorkoutsLinks(); // This method verifies whether required element is visible or not. If yes, then returns main headings of 6 docks.
		String expectedWorkoutLinks[] = {"Workouts", "Schedule a workout", "Go to Supergym�"};
		assertTrue("Correct Values not shown on User Status Bar", Arrays.equals(actualWorkoutLinks, expectedWorkoutLinks) , selenium);
		
		selenium.logComment("Verifying Goal Tracker Dock Links");	
		String actualGoalTrackerLinks[] = homePage.getGoalTrackerLinks(); // This method verifies whether required element is visible or not. If yes, then returns main headings of 6 docks.
		String expectedGoalTrackerLinks[] = {"Goal Tracker", "Go to Goals"};
		assertTrue("Correct Values not shown on User Status Bar", Arrays.equals(actualGoalTrackerLinks, expectedGoalTrackerLinks) , selenium);

		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
				
	}
	
}
