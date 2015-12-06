package com.tbb.testscripts.profile;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.ProgressAndGoalsTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.profile.MyProfilePage;
import com.tbb.pages.profile.ProgressAndGoalsPage;
/**
 *
 * This test script contains test method(s) for Progress and Goals section in Profile page.
 *  @author Jaya
 */
public class TestProgressAndGoalsPage extends BaseTest implements ProgressAndGoalsTab {

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
	 * This is data provider for testSaveOverallGoal Test Script.
	 */ 
	@DataProvider(name = "saveGoalAndFitnessStoryDataProvider")
	public Object[][] createSaveGoalAndFitnessStoryData() {
		
		Calendar cal = Calendar.getInstance();
		 int today_day = cal.get(Calendar.DATE);
		 String day = Integer.toString(today_day);
		 
		 int today_year = cal.get(Calendar.YEAR);
		 String year = Integer.toString(today_year);
		 
		 String[] monthName = {"January", "February", "March", "April", "May", "June", "July",
				             "August", "September", "October", "November", "December"};
		 String month = monthName[cal.get(Calendar.MONTH)];
		 
			return new Object[][] {
					{ "Increase Energy", month, day, year, "Imperial(lbs/in)", "Wow I feel so energetic after losing 10 pounds."},
			};
	}

	/***
	 * Positive Test script for modifying and saving Overall Goal and Fitness Story
	 */ 
	@Test (dataProvider = "saveGoalAndFitnessStoryDataProvider")
	public void testSaveOverallGoal(String goal, String month, String day, String year, String measureUnit, String transformationStory) throws InterruptedException {
	
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page.");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Progress and Goals Page.");
		selenium.logComment("Clicking on 'Edit' link for Overall Goal And Fitness Story section on Progress and Goals Page.");
		selenium.logComment("Verifying all the required fields are present on the Progress and Goals page");
		selenium.logComment("Selecting Overall Goal details.");
		selenium.logComment("Clicking on Save link for saving overall goal and fitness story.");
		selenium.logComment("Verifying that the overall goal and fitness story entered is saved correctly.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		

		selenium.logComment("Verifying whether user is on Home page.");
		HomePage homePage = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Navigating to Profile Page.");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();
		
		selenium.logComment("Navigating to Edit Progress and Goals Page.");
		ProgressAndGoalsPage progressAndGoalsPage = myProfilePage.editProgressAndGoals();
		
		selenium.logComment("Clicking on 'Edit' link for Overall Goal And Fitness Story section on Progress and Goals Page.");
		progressAndGoalsPage.clickEditOverallGoalAndFitnessStoryLink();
		
		selenium.logComment("Verifying all the required fields are present on the Progress and Goals page");
		assertTrue("My Transformation Story textarea is still uneditable.", selenium.isEditable(STORY_TEXTAREA), selenium);
		assertTrue("Overall goal drop down is not available", selenium.isElementPresent(OVERALL_GOAL), selenium);
		assertTrue("Month drop down is not available", selenium.isElementPresent(WORKOUT_START_MONTH_DROPDOWN), selenium);
		assertTrue("Date drop down is not available", selenium.isElementPresent(WORKOUT_START_DAY_DROPDOWN), selenium);
		assertTrue("Year drop down is not available", selenium.isElementPresent(WORKOUT_START_YEAR_DROPDOWN), selenium);
		assertTrue("Calender icon is not available", selenium.isElementPresent(WORKOUT_START_DATE_CALENDER), selenium);
		assertTrue("Calender icon is not available", selenium.isElementPresent(MEASUREMENT_UNIT_DROPDOWN), selenium);
		assertTrue("My Transformation Story is not available", selenium.isElementPresent(STORY_TEXTAREA), selenium);

		selenium.logComment("Selecting Overall Goal details.");
		progressAndGoalsPage.selectGoal(goal);
		progressAndGoalsPage.selectWorkOutStartDateUsingDropdowns(month, day, year);
		progressAndGoalsPage.enterTransformationStory(transformationStory);
		
		selenium.logComment("Clicking on Save link for saving overall goal and fitness story.");
		progressAndGoalsPage.saveGoalAndFitnessStory();  

		selenium.logComment("Verifying that the overall goal and fitness story entered is saved correctly.");
		assertTrue("Success message is not available", selenium.isElementPresent(SUCCESS_MESSAGE), selenium);
		assertTrue("Overall goal is not saved successfully", selenium.getText(STORY_SECTION).contains(goal), selenium);
		assertTrue("Expected Workout month not saved.", month.equals(selenium.getSelectedLabel(WORKOUT_START_MONTH_DROPDOWN)), selenium);
		assertTrue("Expected Workout day not saved.", day.equals(selenium.getSelectedValue(WORKOUT_START_DAY_DROPDOWN)), selenium);
		assertTrue("Expected Workout year not saved.", year.equals(selenium.getSelectedValue(WORKOUT_START_YEAR_DROPDOWN)), selenium);    
		assertTrue("My Transformation Story is not saved successfully", selenium.getText(STORY_TEXTAREA).contains(transformationStory), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}

	/***
	 * This is data provider for testSubmitBodyMeasurementFirstTime Test Script.
	 */ 
	@DataProvider(name = "submitBodyMeasurementFirstTimeDataProvider")
	public Object[][] createBodyMeasurementData() {
		 
		Calendar cal = Calendar.getInstance();
		 int today_day = cal.get(Calendar.DATE);
		 if (today_day==1) 
			 today_day=today_day+1;
		 else if (today_day>=28)
			 today_day=27;
		 else 
			 today_day=today_day + 1;
		 String day = Integer.toString(today_day);
		 
		 return new Object[][] {
				{ day, "72", "10", "20", "30", "40", "30", "45", "15", "25", "35", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105","110","115","120", "125"},
		};
	}

	@Test (dependsOnMethods = { "testSaveOverallGoal" }, dataProvider = "submitBodyMeasurementFirstTimeDataProvider")
	public void testSubmitBodyMeasurementFirstTime ( String day, String startingWeight, 
			String startingWaist, String startingHips, String startingChest, String startingRightArm, 
			String startingLeftArm, String startingRightThigh, String startingLeftThigh, String startingBodyFat, 
			String startingCholesterolHDL, String startingCholesterolLDL, String startingBloodPressureSYS, 
			String startingBloodPressureDIA, String projectedWeight, String projectedWaist, String projectedHips, 
			String projectedChest, String projectedRightArm, String projectedLeftArm, String projectedRightThigh, 
			String projectedLeftThigh, String projectedBodyFat, String projectedCholesterolHDL, 
			String projectedCholesterolLDL, String projectedBloodPressureSYS, String projectedBloodPressureDIA) throws InterruptedException {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page.");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Progress and Goals Page.");
		selenium.logComment("Clicking on 'Edit' link for Overall Goal And Fitness Story section on Progress and Goals Page.");
		selenium.logComment("Selecting Overall Goal details.");
		selenium.logComment("Clicking on Save link for saving overall goal and fitness story.");
		selenium.logComment("Entering Body Measurement details.");
		selenium.logComment("Clicking on Submit Body Measurement button.");
		selenium.logComment("Verifying that the Body Measurement is submitted successfully.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		

		selenium.logComment("Verifying whether user is on Home page.");
		HomePage homePage = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Navigating to Profile Page.");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();
		
		selenium.logComment("Navigating to Edit Progress and Goals Page.");
		ProgressAndGoalsPage progressAndGoalsPage = myProfilePage.editProgressAndGoals();
		
		selenium.logComment("Clicking on 'Edit' link for Overall Goal And Fitness Story section on Progress and Goals Page.");
		progressAndGoalsPage.clickEditOverallGoalAndFitnessStoryLink();
		
		selenium.logComment("Selecting Overall Goal details.");
		progressAndGoalsPage.selectWorkOutStartDateUsingDropdowns(day);
		
		selenium.logComment("Clicking on Save link for saving overall goal and fitness story.");
		progressAndGoalsPage.saveGoalAndFitnessStory();  
		
		selenium.logComment("Entering Body Measurement details.");
		progressAndGoalsPage.addStartingMeasurements(startingWeight, startingWaist, startingHips, startingChest, startingRightArm, startingLeftArm, startingRightThigh, startingLeftThigh, startingBodyFat, startingCholesterolHDL, startingCholesterolLDL, startingBloodPressureSYS, startingBloodPressureDIA);
		progressAndGoalsPage.addProjectedGoalMeasurements(projectedWeight, projectedWaist, projectedHips, projectedChest, projectedRightArm, projectedLeftArm, projectedRightThigh, projectedLeftThigh, projectedBodyFat, projectedCholesterolHDL, projectedCholesterolLDL, projectedBloodPressureSYS, projectedBloodPressureDIA);
		
		selenium.logComment("Clicking on Submit Body Measurement button.");
		progressAndGoalsPage.submitBodyMeasurementFirstTime();

		selenium.logComment("Verifying that the Body Measurement is submitted successfully.");
		assertTrue("Success Message is not available.", selenium.isElementPresent(SUCCESS_MESSAGE), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}

	/***
	 * This is data provider for testSubmitFitnessStatsFirstTime Test Script.
	 */ 
	@DataProvider(name = "submitFitnessStatsFirstTimeDataProvider")
	public Object[][] createFitnessStatsData() {
		
		Calendar cal = Calendar.getInstance();
		 int today_day = cal.get(Calendar.DATE);
		 if (today_day==1) 
			 today_day=today_day+1;
		 else if (today_day>=28)
			 today_day=27;
		 else 
			 today_day=today_day + 1;
		 String day = Integer.toString(today_day);
		 
		return new Object[][] {
				{ day, "72", "10", "20", "30", "40", "30", "45", "15", "25", "35", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105","110","115"},
		};
	}

	@Test (dependsOnMethods = { "testSaveOverallGoal" }, dataProvider = "submitFitnessStatsFirstTimeDataProvider")
	public void testSubmitFitnessStatsFirstTime (String day, String startMorningRestingHeartRate, 
			String startPullUps, String startVerticalLeap, String startPushUpsFromToes, String startInchesFromToes, 
			String startInsAndOutsToFailure, String startSeatedWallSquatMin, String startSeatedWallSquatSec, 
			String startArmCurlsToFailureHash, String startArmCurlsToFailureBy, String startHeartRateMaximizer1, 
			String startHeartRateMaximizer3, String goalMorningRestingHeartRate, String goalPullUps, 
			String goalVerticalLeap, String goalPushUpsFromToes, String goalInchesFromToes, 
			String goalInsAndOutsToFailure, String goalSeatedWallSquatMin, String goalSeatedWallSquatSec, 
			String goalArmCurlsToFailureHash, String goalArmCurlsToFailureBy, String goalHeartRateMaximizer1, 
			String goalHeartRateMaximizer3) throws InterruptedException {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName + ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page.");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Progress and Goals Page.");
		selenium.logComment("Clicking on 'Edit' link for Overall Goal And Fitness Story section on Progress and Goals Page.");
		selenium.logComment("Selecting Overall Goal details.");
		selenium.logComment("Clicking on Save link for saving overall goal and fitness story.");
		selenium.logComment("Entering Fitness Stats details.");
		selenium.logComment("Clicking on Submit Fitness Stats button.");
		selenium.logComment("Verifying that the Fitness Stats are submitted successfully.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		

		selenium.logComment("Verifying whether user is on Home page.");
		HomePage homePage = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Navigating to Profile Page.");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();
		
		selenium.logComment("Navigating to Edit Progress and Goals Page.");
		ProgressAndGoalsPage progressAndGoalsPage = myProfilePage.editProgressAndGoals();
		
		selenium.logComment("Clicking on 'Edit' link for Overall Goal And Fitness Story section on Progress and Goals Page.");
		progressAndGoalsPage.clickEditOverallGoalAndFitnessStoryLink();
		
		selenium.logComment("Selecting Overall Goal details.");
		progressAndGoalsPage.selectWorkOutStartDateUsingDropdowns(day);
		
		selenium.logComment("Clicking on Save link for saving overall goal and fitness story.");
		progressAndGoalsPage.saveGoalAndFitnessStory();  
		
		selenium.logComment("Entering Fitness Stats details.");
		progressAndGoalsPage.addStartingFitnessStats(startMorningRestingHeartRate, startPullUps, startVerticalLeap, startPushUpsFromToes, startInchesFromToes, startInsAndOutsToFailure, startSeatedWallSquatMin, startSeatedWallSquatSec, startArmCurlsToFailureHash, startArmCurlsToFailureBy, startHeartRateMaximizer1, startHeartRateMaximizer3);
		progressAndGoalsPage.addGoalFitnessStats(goalMorningRestingHeartRate, goalPullUps, goalVerticalLeap, goalPushUpsFromToes, goalInchesFromToes, goalInsAndOutsToFailure, goalSeatedWallSquatMin, goalSeatedWallSquatSec, goalArmCurlsToFailureHash, goalArmCurlsToFailureBy, goalHeartRateMaximizer1, goalHeartRateMaximizer3);
		
		selenium.logComment("Clicking on Submit Fitness Stats button.");
		progressAndGoalsPage.submitFitnessStatsFirstTime();

		selenium.logComment("Verifying that the Fitness Stats are submitted successfully.");
		assertTrue("Success Message is not available.", selenium.isElementPresent(SUCCESS_MESSAGE), selenium);
			
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}

	/***
	 * This is data provider for testResetOverallGoal Test Script.
	 */ 
	@DataProvider(name = "resetGoalAndFitnessStoryDataProvider")
	public Object[][] createResetOverallGoalData() {
		return new Object[][] {
				{ "Tone Up", "January", "16", "2011", "Metric(kg/cm)", "Wow I feel toned up"},
		};
	}

	 /***
	 * Positive Test script for modifying and resetting Overall Goal and Fitness Story
	 */ 
	@Test (dataProvider = "resetGoalAndFitnessStoryDataProvider")
	public void testResetOverallGoal(String goal, String month, String day, String year, String measureUnit, String transformationStory) throws InterruptedException {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Launching Website.");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Progress and Goals Page.");
		selenium.logComment("Extracting existing form data on Edit Progress and Goals Page.");
		selenium.logComment("Selecting Overall Goal details.");
		selenium.logComment("Clicking on Reset button.");
		selenium.logComment("Verifying that all the fields are reset successfully.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

		selenium.logComment("Launching Website.");
		HomePage homePage = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Navigating to Profile Page.");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();
		
		selenium.logComment("Navigating to Edit Progress and Goals Page.");
		ProgressAndGoalsPage progressAndGoalsPage = myProfilePage.editProgressAndGoals();
		
		selenium.logComment("Navigating to Edit Progress and Goals Page.");
		progressAndGoalsPage.clickEditOverallGoalAndFitnessStoryLink();

		selenium.logComment("Extracting existing form data on Edit Progress and Goals Page.");
		Map<String, String> map = progressAndGoalsPage.getExistingFormData();

		selenium.logComment("Selecting Overall Goal details.");
		progressAndGoalsPage.selectGoal(goal);
		progressAndGoalsPage.selectWorkOutStartDateUsingDropdowns(month, day, year);
		progressAndGoalsPage.enterTransformationStory(transformationStory);

		selenium.logComment("Clicking on Reset button.");
		progressAndGoalsPage.resetGoalAndFitnessStory();  

		selenium.logComment("Verifying that all the fields are reset successfully.");
		assertTrue("Overall Goal drop down was not reset", selenium.getText(OVERALL_GOAL).equals(map.get(OVERALL_GOAL)), selenium);
		assertTrue("Workout Month was not reset", selenium.getSelectedValue(WORKOUT_START_MONTH_DROPDOWN).equals(map.get(WORKOUT_START_MONTH_DROPDOWN)), selenium);
		assertTrue("Workout Day was not reset", selenium.getSelectedValue(WORKOUT_START_DAY_DROPDOWN).equals(map.get(WORKOUT_START_DAY_DROPDOWN)), selenium);
		assertTrue("Workout Year was not reset", selenium.getSelectedValue(WORKOUT_START_YEAR_DROPDOWN).equals(map.get(WORKOUT_START_YEAR_DROPDOWN)), selenium);
		assertTrue("My Transformation Story was not reset", selenium.getText(STORY_TEXTAREA).equals(map.get(STORY_TEXTAREA)), selenium);
				
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
}

