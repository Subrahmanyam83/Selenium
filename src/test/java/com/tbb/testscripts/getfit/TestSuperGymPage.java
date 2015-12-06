package com.tbb.testscripts.getfit;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Workout;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.InboxPage;
import com.tbb.pages.getfit.GetFitPage;
import com.tbb.pages.getfit.ScheduleWorkoutPage;
import com.tbb.pages.getfit.WhosWorkingOutPage;
import com.tbb.pages.getfit.WowySuperGymPage;

/**
 * 
 * This test script contains test method(s) for SuperGym page under Get-Fit module
 * @author Gaurav
 */
public class TestSuperGymPage extends BaseTest {
	
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
	 * This test verifies Next workout section where user can see next and previous workouts.
	 */
	@Test
	public void testNextWorkoutSection() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		selenium.logComment("Veriyfying whether there is any workout scheduled for user");
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
		
		selenium.logComment("Veriyfying whether there is any workout scheduled for user");
		if (selenium.isTextPresent(Workout.NEXT_WORKOUT_MESSAGE)) {
			selenium.logComment("There are no workouts scheduled for today");
			
			selenium.logComment("Verifying exitence of 'Scheduled a Workout' and 'Add a Full Program Schedule' buttons");
			assertTrue("Required button is not displayed", selenium.waitForElementPresent(Workout.NEXT_WORKOUT_SCHEDULE_A_WORKOUT_BUTTON), selenium);
			assertTrue("Required button is not displayed", selenium.waitForElementPresent(Workout.NEXT_WORKOUT_ADD_A_FULL_PROGRAM_SCHEDULE_BUTTON), selenium);
			
		} else {
			selenium.logComment("There are workouts scheduled");
			selenium.logComment("Getting the details of next workout scheduled");
			String scheduledWorkout[] = wowySuperGymPage.getNextWorkoutScheduledDetails();
			selenium.logComment("Next Workout Scheduled Program is " + scheduledWorkout[0] + " and Routine is " + scheduledWorkout[1] );
			
			selenium.logComment("Verifying exitence of Navigation Next and Previuos Links");
			assertTrue("Required Next Link is not displayed", selenium.waitForElementPresent(Workout.NEXT_WORKOUT_NAVIGATION_NEXT), selenium);
			assertTrue("Required Previous Link is not displayed", selenium.waitForElementPresent(Workout.NEXT_WORKOUT_NAVIGATION_PREVIOUS), selenium);
			
			selenium.logComment("Getting Number of scheduled workouts for selected date");
			selenium.logComment("Number of scheduled workouts for selected date = " + wowySuperGymPage.getScheduledWorkoutsCount());
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
					
		}
	}
	
	/**
	 * This test verifies My Workout section along with creating a one-click work out.
	 */
	@Test
	public void testMyWorkoutSection() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		selenium.logComment("Getting SuperGym and Local Time");
		selenium.logComment("Getting selected date from Calendar");
		selenium.logComment("Getting My Workout Statistics");
		selenium.logComment("Creating One-click workout");
		selenium.logComment("Verifying Number of Buddies, Selected Program and Selected Routine");
		selenium.logComment("Clicking Wowy SuperGym Link");
		selenium.logComment("Clicking on 'Workout now' link to go to current workout to click on 'Finished' button ");
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
		
		selenium.logComment("Getting SuperGym and Local Time");
		selenium.logComment("SuperGym Time = " + wowySuperGymPage.getMyWorkoutCalendarSuperGymTime() + ", Local Time = " + wowySuperGymPage.getMyWorkoutCalendarLocalTime());
		
		selenium.logComment("Getting selected date from Calendar");
		selenium.logComment("Selected Date = " +  wowySuperGymPage.getMyWorkoutCalendarSelectedDate());
		
		selenium.logComment("Getting My Workout Statistics");
		String[] workoutStatistics = wowySuperGymPage.getMyWorkoutStatistics();
		selenium.logComment(workoutStatistics[0]);
		selenium.logComment(workoutStatistics[1]);
		selenium.logComment(workoutStatistics[2]);
		
		selenium.logComment("Creating One-click workout");
		WhosWorkingOutPage whosWorkingOutPage = wowySuperGymPage.createOneClickWorkout("Other Activities", "20 Minutes");
		selenium.logComment("Verifying Number of Buddies, Selected Program and Selected Routine");
		String timeBuddyInfo = whosWorkingOutPage.getSuperGymWorkoutProgressTimeBuddiesInfo();
		assertTrue("Number of buddies should be 0 in one-click workout", timeBuddyInfo.contains("0 Buddies"), selenium);
		
		
		String ProgramRoutineInfo = whosWorkingOutPage.getSuperGymWorkoutProgramsRoutineInfo();
		assertTrue("Actual Selected Program is not as expected", ProgramRoutineInfo.contains("Other Activities"), selenium);
		assertTrue("Actual Selected Routine is not as expected", ProgramRoutineInfo.contains("20 Minutes"), selenium);
		
		selenium.logComment("Clicking Wowy SuperGym Link");
		wowySuperGymPage = whosWorkingOutPage.clickWowySuperGymLink();
		
		
		selenium.logComment("Clicking on 'Workout now' link to go to current workout to click on 'Finished' button ");
		whosWorkingOutPage = wowySuperGymPage.clickWorkoutNowLink();
		whosWorkingOutPage.finishCurrentWorkout();
		
		assertTrue("Required Text not displayed", selenium.isTextPresent("Great Job!"), selenium);
		
		assertTrue("Required Text not displayed", selenium.getText("css=span#supergym-wo-progress-remaining-time").equals("Completed"), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
					
	}
	
	/**
	 * This test verifies SuperGym stats and logs that information in console and log file.
	 */
	@Test
	public void testWOWYSuperGymStats() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		selenium.logComment("Getting SuperGym Statistics");
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
		
		selenium.logComment("Getting SuperGym Statistics");
		String[] superGymStatistics = wowySuperGymPage.getWOWYSuperGymStatistics();
		selenium.logComment(superGymStatistics[0]);
		selenium.logComment(superGymStatistics[1]);
		selenium.logComment(superGymStatistics[2]);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
	}
	
	
	/**
	 * This test verifies that user can schedule a workout and while scheduling user can also
	 * invlite his/her buddy to join that workout.
	 */
	@Test
	public void testScheduleWorkout() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		selenium.logComment("Scheduling a workout and inviting buddy");
		selenium.logComment("Scheduling a workout and inviting buddy");
		selenium.logComment("Logging out of site and logging again");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
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
		
		selenium.logComment("Scheduling a workout and inviting buddy");
		ScheduleWorkoutPage scheduleWorkoutPage = wowySuperGymPage.clickScheduleAWorkoutLink();
		
		selenium.logComment("Scheduling a workout and inviting buddy");
		wowySuperGymPage = scheduleWorkoutPage.scheduleWorkout("Other Activities", "20 Minutes" , "JAsnani");
		
		selenium.logComment("Logging out of site and logging again");
		homePage =  wowySuperGymPage.signOut();
		
		selenium.logComment("Clicking on 'Sign In' Link");
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial("jgupta@xebia.com", "password");
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser("jgupta@xebia.com", "password");
		}
		
		homePage = dashboardPage.clickHome();
	
		InboxPage inboxPage = homePage.goToInbox();
		selenium.click("//tr[@class=\"message results-row  unread \"]/td//span[contains(text(), 'Workout invitation')]");
		
		
		selenium.click("css=a:contains(click here)");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		
		assertTrue("Workout time has already occurred", !selenium.isTextPresent("This workout has already occurred."), selenium);
		
		homePage = inboxPage.signOut();
		
		selenium.logComment("Clicking on 'Sign In' Link");
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Clicking on 'Get Fit' link");
		getFitPage = dashboardPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		wowySuperGymPage = getFitPage.goToWowySupergymPage();
		
				
		while(selenium.isElementPresent(Workout.NEXT_WORKOUT_NAVIGATION_NEXT)) {
			selenium.click(Workout.NEXT_WORKOUT_NAVIGATION_NEXT);
		}
			
		assertTrue("Required text not displayed", selenium.isTextPresent("Buddy Accepted"), selenium);
		
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
				
	}
	
}
