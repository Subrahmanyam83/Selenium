package com.tbb.testscripts.bazaarvoice;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.FitnessPrograms;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.getfit.FitnessProgramsPage;
import com.tbb.pages.getfit.GetFitPage;

/**
 * 
 * This test script contains test method(s) for Fitness Programs Bazaar Voice page under About module
 * @author Jaya
 */
public class TestFitnessProgramsBazaarVoice extends BaseTest{

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
	 * Positive Test script for verifying viewing of Fitness Programs: Bazaar Voice.
	 */ 
	@Test
	public void testFitnessProgramsBazaarVoice(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Clicking on 'Fitness Programs' link");
		selenium.logComment("Verifying if Bazaar voice ratings are available");
		selenium.logComment("Verifying if Bazaar voice review links are available");
		selenium.logComment("Verifying if review links are not broken.");
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

		selenium.logComment("Clicking on 'Fitness Programs' link");
		FitnessProgramsPage fitnessProgramsPage = getFitPage.goToFitnessProgramsPage();
		
		selenium.logComment("Verifying if Bazaar voice ratings are available");
		assertTrue("Expected P90X Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.P90X_RATING), selenium);
		assertTrue("Expected INSANITY Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.INSANITY_RATING), selenium);
		assertTrue("Expected Tony Horton Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.TONY_HORTON_RATING), selenium);
		assertTrue("Expected ChaLEAN Extreme Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.CHALEAN_EXTREME_RATING), selenium);
		assertTrue("Expected Brazil Butt Lift Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.BRAZIL_BUTT_LIFT_RATING), selenium);
		assertTrue("Expected Turbo Fire Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.TURBO_FIRE_RATING), selenium);
		assertTrue("Expected Body Gospel Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.BODY_GOSPEL_RATING), selenium);
		assertTrue("Expected Debbie Siebers Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.DEBBIE_SIEBERS_RATING), selenium);
		assertTrue("Expected Power 90 Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.POWER90_RATING), selenium);
		assertTrue("Expected P90X One on One Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.P90X_ONE_ON_ONE_RATING), selenium);
		assertTrue("Expected Rev Abs Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.REV_ABS_RATING), selenium);
		assertTrue("Expected Hip Hop Abs Rating is not displayed.", selenium.isElementPresent(FitnessPrograms.HIP_HOP_ABS_RATING), selenium);

		selenium.logComment("Verifying if Bazaar voice review links are available");
		assertTrue("Expected P90X Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.P90X_REVIEW_LINK), selenium);
		assertTrue("Expected INSANITY Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.INSANITY_REVIEW_LINK), selenium);
		assertTrue("Expected Tony Horton Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.TONY_HORTON_REVIEW_LINK), selenium);
		assertTrue("Expected ChaLEAN Extreme Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.CHALEAN_EXTREME_REVIEW_LINK), selenium);
		assertTrue("Expected Brazil Butt Lift Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.BRAZIL_BUTT_LIFT_REVIEW_LINK), selenium);
		assertTrue("Expected Turbo Fire Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.TURBO_FIRE_REVIEW_LINK), selenium);
		assertTrue("Expected Body Gospel Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.BRAZIL_BUTT_LIFT_REVIEW_LINK), selenium);
		assertTrue("Expected Debbie Siebers Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.DEBBIE_SIEBERS_REVIEW_LINK), selenium);
		assertTrue("Expected Power 90 Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.POWER_90_REVIEW_LINK), selenium);
		assertTrue("Expected P90X One on One Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.P90X_ONE_ON_ONE_REVIEW_LINK), selenium);
		assertTrue("Expected Rev Abs Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.REV_ABS_REVIEW_LINK), selenium);
		assertTrue("Expected Hip Hop Abs Review link is not displayed.", selenium.isElementPresent(FitnessPrograms.HIP_HOP_ABS_REVIEW_LINK), selenium);

		selenium.logComment("Verifying if review links are not broken.");
		fitnessProgramsPage.clickP90XReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickINSANITYReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickTonyHortonReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickChaleanExtremeReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickBrazilButtLiftReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickTurboFireReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickBodyGospelReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickDebbieSiebersReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickPower90Reviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickRevAbsReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		fitnessProgramsPage.clickHipHopAbsReviews();
		assertTrue("No reviews are displayed.", fitnessProgramsPage.getReviewCount()>=1, selenium );
		fitnessProgramsPage.clickFitnessProgramsLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}