package com.tbb.testscripts.bazaarvoice;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
import com.tbb.pages.getfit.TrainerGillianPage;
import com.tbb.pages.getfit.TrainerKathyPage;
import com.tbb.pages.getfit.TrainerLeandroPage;
import com.tbb.pages.getfit.TrainerShaunPage;
import com.tbb.pages.getfit.TrainerTonyPage;
import com.tbb.pages.getfit.TrainersPage;

/**
 * 
 * This test script contains test method(s) for Trainers Corner Bazaar Voice page under About module
 * @author Jaya
 */
public class TestTrainersCornerBazaarVoice extends BaseTest{

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
	 * Test script for verifying if bazaar voice is displayed on Trainer's corners.
	 */ 
	@Test
	public void testTrainersBazaarVoice(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Clicking on 'Trainers' link");
		selenium.logComment("Navigating to Tony Horton's Corner Page");
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		selenium.logComment("Navigating to 'Chalene Johnson's' Corner Page");
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		selenium.logComment("Navigating to 'Debbie Siebers's' Corner Page");
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		selenium.logComment("Navigating to 'Shaun T's' Corner Page");
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		selenium.logComment("Navigating to 'Brett Hoebel's' Corner Page");
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		selenium.logComment("Navigating to 'Leandro Carvalho's' Corner Page");
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		selenium.logComment("Navigating to 'Kathy Smith's' Corner Page");
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		selenium.logComment("Navigating to 'Donna's' Corner Page");
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}
		
		selenium.logComment("Clicking on 'Get Fit' link");
		GetFitPage getFitPage = dashboardPage.clickGetFitLink();

		selenium.logComment("Clicking on 'Trainers' link");
		TrainersPage trainersPage = getFitPage.goToTrainersPage();
		
		selenium.logComment("Navigating to Tony Horton's Corner Page");
		TrainerTonyPage trainerTonyCorner = trainersPage.clickTony();
		
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		assertTrue("Products section is not displayed.", selenium.isElementPresent(Trainers.PRODUCTS), selenium);
		assertTrue("Bazaar voice container is not displayed.", selenium.isElementPresent(Trainers.BAZAAR_VOICE), selenium );

		selenium.logComment("Navigating to 'Chalene Johnson's' Corner Page");
		trainersPage = trainerTonyCorner.clickTrainerslink();
		TrainerChalenePage trainerChaleneCorner = trainersPage.clickChalene();
		
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		assertTrue("Products section is not displayed.", selenium.isElementPresent(Trainers.PRODUCTS), selenium);
		assertTrue("Bazaar voice container is not displayed.", selenium.isElementPresent(Trainers.BAZAAR_VOICE), selenium );
		
		selenium.logComment("Navigating to 'Debbie Siebers's' Corner Page");
		trainersPage = trainerChaleneCorner.clickTrainerslink();
		TrainerDebbiePage trainerDebbieCorner = trainersPage.clickDebbie();
		
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		assertTrue("Products section is not displayed.", selenium.isElementPresent(Trainers.PRODUCTS), selenium);
		assertTrue("Bazaar voice container is not displayed.", selenium.isElementPresent(Trainers.BAZAAR_VOICE), selenium );
		
		selenium.logComment("Navigating to 'Shaun T's' Corner Page");
		trainersPage = trainerDebbieCorner.clickTrainerslink();
		TrainerShaunPage trainerShaunCorner = trainersPage.clickShaun();
		
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		assertTrue("Products section is not displayed.", selenium.isElementPresent(Trainers.PRODUCTS), selenium);
		assertTrue("Bazaar voice container is not displayed.", selenium.isElementPresent(Trainers.BAZAAR_VOICE), selenium );

		selenium.logComment("Navigating to 'Brett Hoebel's' Corner Page");
		trainersPage = trainerShaunCorner.clickTrainerslink();
		TrainerBrettPage trainerBrettCorner = trainersPage.clickBrett();
		
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		assertTrue("Products section is not displayed.", selenium.isElementPresent(Trainers.PRODUCTS), selenium);
		assertTrue("Bazaar voice container is not displayed.", selenium.isElementPresent(Trainers.BAZAAR_VOICE), selenium );

		selenium.logComment("Navigating to 'Leandro Carvalho's' Corner Page");
		trainersPage = trainerBrettCorner.clickTrainerslink();
		TrainerLeandroPage trainerLeandroCorner = trainersPage.clickLeandro();
		
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		assertTrue("Products section is not displayed.", selenium.isElementPresent(Trainers.PRODUCTS), selenium);
		assertTrue("Bazaar voice container is not displayed.", selenium.isElementPresent(Trainers.BAZAAR_VOICE), selenium );

		selenium.logComment("Navigating to 'Kathy Smith's' Corner Page");
		trainersPage = trainerLeandroCorner.clickTrainerslink();
		TrainerKathyPage trainerKathyPage = trainersPage.clickKathy();
		
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		assertTrue("Products section is not displayed.", selenium.isElementPresent(Trainers.PRODUCTS), selenium);

		selenium.logComment("Navigating to 'Kathy Smith's' Corner Page");
		trainersPage = trainerKathyPage.clickTrainerslink();
		TrainerGillianPage trainerGillianPage = trainersPage.clickGillianAndTeigh();
		
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		assertTrue("Products section is not displayed.", selenium.isElementPresent(Trainers.PRODUCTS), selenium);
		assertTrue("Bazaar voice container is not displayed.", selenium.isElementPresent(Trainers.BAZAAR_VOICE), selenium );

		selenium.logComment("Navigating to 'Donna's' Corner Page");
		trainersPage = trainerGillianPage.clickTrainerslink();
	    trainersPage.clickDonna();
		
		selenium.logComment("Verifying that 'Products' section is displayed along with Bazaar Voice");
		assertTrue("Products section is not displayed.", selenium.isElementPresent(Trainers.PRODUCTS), selenium);
		assertTrue("Bazaar voice container is not displayed.", selenium.isElementPresent(Trainers.BAZAAR_VOICE), selenium );

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}