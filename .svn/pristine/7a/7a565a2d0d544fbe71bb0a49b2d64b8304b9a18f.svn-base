package com.tbb.testscripts.getfit;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.Trainers;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.getfit.GetFitPage;
import com.tbb.pages.getfit.TrainerBrettPage;
import com.tbb.pages.getfit.TrainerChalenePage;
import com.tbb.pages.getfit.TrainerDebbiePage;
import com.tbb.pages.getfit.TrainerDonnaPage;
import com.tbb.pages.getfit.TrainerGillianPage;
import com.tbb.pages.getfit.TrainerKathyPage;
import com.tbb.pages.getfit.TrainerLeandroPage;
import com.tbb.pages.getfit.TrainerMoreExpertsPage;
import com.tbb.pages.getfit.TrainerShaunPage;
import com.tbb.pages.getfit.TrainerStevePage;
import com.tbb.pages.getfit.TrainerTonyPage;
import com.tbb.pages.getfit.TrainersPage;

/**
 * 
 * This test script contains test method(s) for Trainers page under Get-Fit module
 * @author Jaya
 */
public class TestTrainers extends BaseTest implements Trainers{

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
	 * This is data provider for testViewTrainersAsFreeUser Test Script.
	 */ 
	@DataProvider(name = "viewTrainersAsFreeDataProvider")
	public Object[][] createTrainersDataForFreeUser() {
		return new Object[][] {
				{ "Tony Horton"},
		};
	}

	/**
	 * Positive Test script for verifying viewing of Trainers Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test (dataProvider = "viewTrainersAsFreeDataProvider")
	public void testViewTrainersAsFreeUser(String trainerName) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Get Fit Page");
		selenium.logComment("Navigating to Trainers Page");
		selenium.logComment("Verifying that all the required elements are present on the Trainers Page");
		selenium.logComment("Verifying that all the trainers photos are available.");
		selenium.logComment("Verifying that all the trainers names are available.");
		selenium.logComment("Verifying that all the trainers introductions are available.");
		selenium.logComment("Clicking on a trainer name to view it.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		

		selenium.logComment("Verifying whether user is on Home page");
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

		selenium.logComment("Navigating to Get Fit Page");
		GetFitPage getFitPage = dashboardPage.clickGetFitLink();
		
		selenium.logComment("Navigating to Trainers Page");
		TrainersPage trainersPage = getFitPage.goToTrainersPage();
		
		selenium.logComment("Verifying that all the required elements are present on the Trainers Page");
		assertTrue("Expected header 'Team Beachbody Trainers' is not displayed.", selenium.isElementPresent(TRAINER_HEADING), selenium);
		assertTrue("Expected Trainers introduction text is not displayed.", selenium.isElementPresent(INTRO_TEXT), selenium);
		
		selenium.logComment("Verifying that all the trainers photos are available.");
		assertTrue("All the Photos are not displayed", trainersPage.getPhotosCount()==11, selenium);	
		
		selenium.logComment("Verifying that all the trainers names are available.");
		assertTrue("All the Trainer Names are not displayed", trainersPage.getTrainerNamesCount()==11, selenium);

		selenium.logComment("Verifying that all the trainers introductions are available.");
		assertTrue("All the Trainer intros are not displayed", trainersPage.getTrainerIntroCount()==22, selenium);
		
		selenium.logComment("Clicking on a trainer name to view it.");
		trainersPage.clickTrainerNameAsFreeUser(trainerName);
			
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}

	/**
	 * Positive Test script for verifying viewing of Trainers Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test 
	public void testViewTrainersAsClubUser() {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Get Fit Page");
		selenium.logComment("Navigating to Trainers Page");
		selenium.logComment("Verifying that all the required elements are present on the Trainers Page");
		selenium.logComment("Verifying that all the trainers photos are available.");
		selenium.logComment("Verifying that all the trainers names are available.");
		selenium.logComment("Verifying that all the trainers introductions are available.");
		selenium.logComment("Clicking on Tony's name to view his page.");
		selenium.logComment("Clicking on a trainer name to view it.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		

		selenium.logComment("Verifying whether user is on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}

		selenium.logComment("Navigating to Get Fit Page");
		GetFitPage getFitPage = dashboardPage.clickGetFitLink();
		
		selenium.logComment("Navigating to Trainers Page");
		TrainersPage trainersPage = getFitPage.goToTrainersPage();
		
		selenium.logComment("Verifying that all the required elements are present on the Trainers Page");
		assertTrue("Expected header 'Team Beachbody Trainers' is not displayed.", selenium.isElementPresent(TRAINER_HEADING), selenium);
		assertTrue("Expected Trainers introduction text is not displayed.", selenium.isElementPresent(INTRO_TEXT), selenium);
		
		selenium.logComment("Verifying that all the trainers photos are available.");
		assertTrue("All the Photos are not displayed", trainersPage.getPhotosCount()==11, selenium);	
		
		selenium.logComment("Verifying that all the trainers names are available.");
		assertTrue("All the Trainer Names are not displayed", trainersPage.getTrainerNamesCount()==11, selenium);

		selenium.logComment("Verifying that all the trainers introductions are available.");
		assertTrue("All the Trainer intros are not displayed", trainersPage.getTrainerIntroCount()==22, selenium);
		
		selenium.logComment("Clicking on Tony's name to view his page.");
		TrainerTonyPage tonyPage = trainersPage.clickTony();
		trainersPage = tonyPage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerChalenePage chalenePage = trainersPage.clickChalene();
		trainersPage = chalenePage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerDebbiePage debbiePage = trainersPage.clickDebbie();
		trainersPage = debbiePage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerShaunPage shaunPage = trainersPage.clickShaun();
		trainersPage = shaunPage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerDonnaPage donnaPage = trainersPage.clickDonna();
		trainersPage = donnaPage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerLeandroPage leandroPage = trainersPage.clickLeandro();
		trainersPage = leandroPage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerKathyPage kathyPage = trainersPage.clickKathy();
		trainersPage = kathyPage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerGillianPage gillianPage = trainersPage.clickGillianAndTeigh();
		trainersPage = gillianPage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerBrettPage brettPage = trainersPage.clickBrett();
		trainersPage = brettPage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerStevePage stevePage = trainersPage.clickSteve();
		trainersPage = stevePage.clickTrainerslink();
		
		selenium.logComment("Clicking on a trainer name to view it.");
		TrainerMoreExpertsPage moreExpertsPage = trainersPage.clickMoreExperts();
		trainersPage = moreExpertsPage.clickTrainerslink();		
				
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}	
}