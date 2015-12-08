package com.tbb.testscripts.connect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.MyCoachPage;


/**
 * 
 * This test script contains test method(s) for My Coach page under Connect module
 * @author Gaurav
 */
public class TestCoach extends BaseTest {
	
	
	
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
	 * This test method verifies 'Connect -> My Coach' page for logged in user. It verifies 
	 * a) Coach images
	 * b) Number of Coach's buddies
	 * c) Coach's Fitness Goals
	 * d) Coach's Introduction
	 * e) Coach's Meal plan, Workout programs, Gear, Supplements
	 */
	@Test
	public void testConnectMyCoach() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Connect' tab");
		selenium.logComment("Clicking 'My Coach' link");
		selenium.logComment("Verifying UI of Page");
		selenium.logComment("Getting and verifying Fitness Goal");
		selenium.logComment("Getting and verifying Introduction Text");
		selenium.logComment("Getting and verifying Workout Programs");
		selenium.logComment("Getting and Verifying Supplments");
		selenium.logComment("Getting and verifying workout groups");
		selenium.logComment("Getting and verifying next workouts");
		selenium.logComment("Getting and Verifying SuperGym Statistics");
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
	

		selenium.logComment("Clicking on 'Connect' tab");
		ConnectPage connectPage = dashboardPage.clickConnectLink();
		
		selenium.logComment("Clicking 'My Coach' link");
		MyCoachPage myCoachPage = connectPage.clickCoachLearnMore();
		
		selenium.logComment("Verifying UI of Page");
		myCoachPage.verifyUI();
		
		selenium.logComment("Getting and verifying Fitness Goal");
		assertTrue("Fitness Goal not correct", myCoachPage.getFitnessGoal().equals("My fitness goal: Get Healthy"), selenium);
		
		selenium.logComment("Getting and verifying Introduction Text");
		assertTrue("Introduction Text not correct", myCoachPage.getIntroductionText().equals("Transformation story"), selenium);
		
		selenium.logComment("Getting and verifying Workout Programs");
		ArrayList<String> workoutPrograms = myCoachPage.getWorkoutProgramsTitles();
		String[] workoutProgramsData = new String[] {"P90X®", "ChaLEAN Extreme®", "10-Minute Trainer®" ,"P90X One on One™", "INSANITY® - primary program", "RevAbs™", "Running / Walking", "Cardio / Aerobics", "Yoga / Pilates", "Weightlifting", "TurboFire®", "INSANITY: THE ASYLUM™"};
		List<String> workoutProgramsDataList = Arrays.asList(workoutProgramsData);
		assertTrue("Required Workout program not displayed", workoutProgramsDataList.equals(workoutPrograms), selenium);
		
	/*	selenium.logComment("Getting and verifying Gear Accessories");
		ArrayList<String> gearAccessories = myCoachPage.getGearTitles();
		String[] gearAccessoriesData = new String[] {"Heart Rate Monitor", "Resistance Bands", "PowerStands™"};
		List<String> gearAccessoriesDataList = Arrays.asList(gearAccessoriesData);
		assertTrue("Required Gear Accessories not displayed", gearAccessoriesDataList.equals(gearAccessories), selenium);*/
		
		selenium.logComment("Getting and Verifying Supplments");
		ArrayList<String> supplementTitles = myCoachPage.getSupplementTitles();
		String[] supplementTitlesData = new String[] {"Shakeology®", "ActiVit® Multi-Vitamins", "Whey Protein Powder", "P90X® Peak Results and Recovery Formula"};
		List<String> supplementTitlesDataList = Arrays.asList(supplementTitlesData);
		assertTrue("Required Supplements not displayed", supplementTitlesDataList.equals(supplementTitles), selenium);
		
		selenium.logComment("Getting and verifying workout groups");
	    ArrayList<String> workoutGroups = myCoachPage.getWorkoutGroups();
	    String[] workoutGroupsData = new String[] {"Average Joe's"};
	    List<String> workoutGroupsDataList = Arrays.asList(workoutGroupsData);
	    assertTrue("Required Workout Groups not displayed", workoutGroupsDataList.equals(workoutGroups), selenium); 
	        
		selenium.logComment("Getting and verifying next workouts");
		assertTrue("Required Next Workouts Not displayed", myCoachPage.getNextWorkouts().equals("No workouts scheduled"), selenium);
		
	    selenium.logComment("Getting and Verifying SuperGym Statistics");
	    String[] stats = myCoachPage.getSuperGymStatistics();
	    String[] statsData = new String[] {"103", "57", "55"};
	    //assertTrue("Required SuperGym stats not displayed", stats.equals(statsData), selenium);
	        
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
			
		
	}
	
}
