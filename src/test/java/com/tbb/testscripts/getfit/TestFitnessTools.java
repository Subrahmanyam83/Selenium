package com.tbb.testscripts.getfit;

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
import com.tbb.pages.getfit.FitnessToolsPage;
import com.tbb.pages.getfit.GetFitPage;
import com.tbb.pages.getfit.TargetHeartRateCalcultorPage;
import com.tbb.pages.getfit.WorkoutSheetsPage;

/**
 * 
 * This test script contains test method(s) for Fitness Tools page under Get-Fit module
 * @author Gaurav
 */
public class TestFitnessTools extends BaseTest {
	
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
	 * This test verifies UI of Fitness Tools page. It also verifies whether all three tools are
	 * displayed on main page.
	 */
	@Test
	public void testFitnessToolsPage() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Going to 'Fitness Tools' page");
		selenium.logComment("Verifying UI of page");
		selenium.logComment("Getting titles of Fitness Tools and verifying that");
		selenium.logComment("Getting titles of RRMs and verifying that");
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
		
		selenium.logComment("Going to 'Fitness Tools' page");
		FitnessToolsPage fitnessToolsPage = getFitPage.goToFitnessToolsPage();
		
		selenium.logComment("Verifying UI of page");
		fitnessToolsPage.verifyUI();
		
		selenium.logComment("Getting titles of Fitness Tools and verifying that");
		ArrayList fitnessTools = fitnessToolsPage.getFitnessToolsTitles();
		String[] fitnessToolsData = new String[] {"Target Heart Rate", "Fitness Tracker", "Workout Sheets"};
		List<String> fitnessToolsDataList = Arrays.asList(fitnessToolsData);
		assertTrue("Required Fitness Tools not displayed", fitnessToolsDataList.equals(fitnessTools), selenium);
		
		selenium.logComment("Getting titles of RRMs and verifying that");
		ArrayList rrmTitles = fitnessToolsPage.getRRMsTitles();
		String[] rrmTitlesData = new String[] {"Enter to Win Up to $100k", "Trainers’ Corner"};
		List<String> rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();	
	}
	
	/**
	 * This test verifies UI of Target Heart Rate tool page.
	 */
	@Test
	public void testTargetHeartRateTool() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Going to 'Fitness Tools' page");
		selenium.logComment("Clicking on 'Target Heart Rate' Fitness Tool");
		selenium.logComment("Verifying UI of page");
		selenium.logComment("Getting low and high values of Target Heart Rate Zones");
		selenium.logComment("Getting titles of RRMs and verifying that");
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
		
		selenium.logComment("Going to 'Fitness Tools' page");
		FitnessToolsPage fitnessToolsPage = getFitPage.goToFitnessToolsPage();
		
		selenium.logComment("Clicking on 'Target Heart Rate' Fitness Tool");
		TargetHeartRateCalcultorPage targetHeartRateCalcultorPage = fitnessToolsPage.clickTargetHeartRate();
		
		selenium.logComment("Verifying UI of page");
		targetHeartRateCalcultorPage.verifyUI();
		
		selenium.logComment("Getting low and high values of Target Heart Rate Zones");
		ArrayList heartRateZones = targetHeartRateCalcultorPage.getHeartRateZones("30", "Female");
		String[] heartRateZonesData = new String[] {"Recovery Zone 107 127", "Temperate Zone 127 147" ,"Aerobic Zone 147 166" ,"Threshold Zone 166 186" ,"Redline Zone 186 196"};
		List<String> heartRateZonesDataList = Arrays.asList(heartRateZonesData);
		assertTrue("Required Heart Rate Zone not displayed", heartRateZonesDataList.equals(heartRateZones), selenium);
		
		selenium.logComment("Getting titles of RRMs and verifying that");
		ArrayList rrmTitles = targetHeartRateCalcultorPage.getRRMsTitles();
		String[] rrmTitlesData = new String[] {"Featured Products", "Enter to Win Up to $100k"};
		List<String> rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}

	
	/**
	 * This page verifies UI of Workout sheets tool. It verifies whether all required 
	 * workout sheets are available.
	 */
	@Test
	public void testWorkoutSheetsTool() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Going to 'Fitness Tools' page");
		selenium.logComment("Clicking on 'Workout Sheets' Fitness Tool");
		selenium.logComment("Verifying UI of page");
		selenium.logComment("Getting and verifying titles of Workout Sheets");
		selenium.logComment("Getting titles of RRMs and verifying that");
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
		
		selenium.logComment("Going to 'Fitness Tools' page");
		FitnessToolsPage fitnessToolsPage = getFitPage.goToFitnessToolsPage();
		
		selenium.logComment("Clicking on 'Workout Sheets' Fitness Tool");
		WorkoutSheetsPage workoutSheetsPage = fitnessToolsPage.clickWorkoutSheets();
		
		selenium.logComment("Verifying UI of page");
		workoutSheetsPage.verifyUI();
		
		selenium.logComment("Getting and verifying titles of Workout Sheets");
		ArrayList workoutSheetsTitles = workoutSheetsPage.getWorkoutSheetsTitles();
		String[] workoutSheetsTitlesData = new String[] {"P90X® Fit Test" , "P90X® Worksheets" ,"P90X® Plus Worksheets", "P90X®/P90X® Plus\nHybrid Worksheets", "P90X®/P90X ONE on ONE®\nHybrid Worksheets", "P90X®/TurboFire®\nHybrid Worksheets", "P90X®/INSANITY®\nHybrid Worksheets", "ChaLEAN Extreme®\nWorksheets" ,"INSANITY®\nJournal Pages", "INSANITY® Fit Test Pages", "INSANITY: THE ASYLUM™", "RevAbs® Journal Page"};
		List<String> workoutSheetsTitlesDataList = Arrays.asList(workoutSheetsTitlesData);
		assertTrue("Required Heart Rate Zone not displayed", workoutSheetsTitlesDataList.equals(workoutSheetsTitles), selenium);
		
		selenium.logComment("Getting titles of RRMs and verifying that");
		ArrayList rrmTitles = fitnessToolsPage.getRRMsTitles();
		String[] rrmTitlesData = new String[] {"Featured Products", "Enter to Win Up to $100k", "Shakeology®"};
		List<String> rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}

}
