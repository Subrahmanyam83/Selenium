package com.tbb.testscripts.getfit;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.GetFit;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.getfit.FitnessProgramsPage;
import com.tbb.pages.getfit.FitnessTipsPage;
import com.tbb.pages.getfit.FitnessToolsPage;
import com.tbb.pages.getfit.GetFitPage;
import com.tbb.pages.getfit.TrainersPage;
import com.tbb.pages.getfit.WorkoutGroupsPage;
import com.tbb.pages.getfit.WorkoutSheetsPage;
import com.tbb.pages.getfit.WowySuperGymPage;

/**
 * 
 * This test script contains test method(s) for main Get-Fit page/tab
 * @author Gaurav
 */
public class TestGetFitPage extends BaseTest {

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
	 * This test verifies UI of Get-Fit page and accessibility of all links shown in left site menu on 
	 * that page.
	 */
	@Test
	public void testMenuLinks() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Verifying number of links in left side Menu");
		selenium.logComment("Verifying Links' title shown in left side Menu");
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		selenium.logComment("Clicking on 'Fitness Tools' Link from left side menu");
		selenium.logComment("Clicking on 'Fitness Programs' Link from left side menu");
		selenium.logComment("Clicking on 'Fitness Tips' Link from left side menu");
		selenium.logComment("Clicking on 'Trainers' Link from left side menu");
		selenium.logComment("Clicking on 'Workout Sheets' Link from left side menu");
		selenium.logComment("Clicking on 'Workout Groups' Link from left side menu");
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
		
		selenium.logComment("Verifying number of links in left side Menu");
		assertTrue("All links are not displayed", getFitPage.getMenuLinksCount()==7, selenium );
		
		selenium.logComment("Verifying Links' title shown in left side Menu");
		assertTrue("Expected Links are not displayed", Arrays.equals(getFitPage.getMenuLinksText(), new String[]{"WOWY SuperGym™","Fitness Tools", "Fitness Programs", "Fitness Tips", "Trainers", "Workout Sheets", "Workout Groups"}), selenium);
		
		selenium.logComment("Clicking on 'WOWY SuperGym™' Link from left side menu");
		WowySuperGymPage wowySuperGymPage = getFitPage.goToWowySupergymPage();
		getFitPage = wowySuperGymPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'Fitness Tools' Link from left side menu");
		FitnessToolsPage fitnessToolsPage = getFitPage.goToFitnessToolsPage();
		getFitPage = fitnessToolsPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'Fitness Programs' Link from left side menu");
		FitnessProgramsPage fitnessProgramsPage = getFitPage.goToFitnessProgramsPage();
		getFitPage = fitnessProgramsPage.clickGetFitLink();
		
		
		selenium.logComment("Clicking on 'Fitness Tips' Link from left side menu");
		FitnessTipsPage fitnessTipsPage = getFitPage.goToFitnessTipsPage();
		getFitPage = fitnessTipsPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'Trainers' Link from left side menu");
		TrainersPage trainersPage = getFitPage.goToTrainersPage();
		getFitPage = trainersPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'Workout Sheets' Link from left side menu");
		WorkoutSheetsPage workoutSheetsPage = getFitPage.goToWorkoutSheetsPage();
		getFitPage = workoutSheetsPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'Workout Groups' Link from left side menu");
		WorkoutGroupsPage workoutGroupsPage = getFitPage.goToWorkoutGroupsPage();
		getFitPage = workoutGroupsPage.clickGetFitLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
	
	}
	
	
	
	
	/**
	 * This test verifies UI of Get-Fit page and accessibility of all links shown in content area of 
	 * that page like Learn more link shown under Fitness Tools, Fitness Programs etc.
	 */
	@Test
	public void testContentLinks() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Verifying number of links in right side content area");
		selenium.logComment("Verifying title headings in right side content area");
		selenium.logComment("Clicking on 'Learn More' link under 'WOWY SuperGym™' from right side content area");
		selenium.logComment("Clicking on 'Learn More' link under 'Fitness Tools' from right side content area");
		selenium.logComment("Clicking on 'Learn More' link under 'Fitness Programs' from right side content area");
		selenium.logComment("Clicking on 'Learn More' link under 'Fitness Tips' from right side content area");
		selenium.logComment("Clicking on 'Learn More' link under 'Trainers' from right side content area");
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
		
		selenium.logComment("Verifying number of links in right side content area");
		assertTrue("All links are not displayed", getFitPage.getContentLinksCount()==5, selenium );
		
		selenium.logComment("Verifying title headings in right side content area");
		assertTrue("Expected headings are not displayed", Arrays.equals(getFitPage.getContentLinksText(), new String[]{"WOWY SuperGym™","Fitness Tools", "Fitness Programs", "Fitness Tips", "Trainers"}), selenium);
		
		selenium.logComment("Clicking on 'Learn More' link under 'WOWY SuperGym™' from right side content area");
		WowySuperGymPage wowySuperGymPage = getFitPage.clickWowySuperGymLearnMore();
		getFitPage = wowySuperGymPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'Learn More' link under 'Fitness Tools' from right side content area");
		FitnessToolsPage fitnessToolsPage = getFitPage.clickFitnessToolsLearnMore();
		getFitPage = fitnessToolsPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'Learn More' link under 'Fitness Programs' from right side content area");
		FitnessProgramsPage fitnessProgramsPage = getFitPage.clickFitnessProgramsLearnMore();
		getFitPage = fitnessProgramsPage.clickGetFitLink();
		
		
		selenium.logComment("Clicking on 'Learn More' link under 'Fitness Tips' from right side content area");
		FitnessTipsPage fitnessTipsPage = getFitPage.clickFitnessTipsLearnMore();
		getFitPage = fitnessTipsPage.clickGetFitLink();
		
		selenium.logComment("Clicking on 'Learn More' link under 'Trainers' from right side content area");
		TrainersPage trainersPage = getFitPage.clickTrainersLearnMore();
		getFitPage = trainersPage.clickGetFitLink();
		
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
				
		
	}
	
	/**
	 * This test verifies UI of Main header section shown on Get-Fit page.
	 */
	@Test 
	public void testContentHeader() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Verifying existence of 'Get Fit' heading, 'Featured this week' text, visibility of header quote, exitence of user status");
		selenium.logComment("Verifying number of links under 'Featured this week'");
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
		
		selenium.logComment("Verifying existence of 'Get Fit' heading, 'Featured this week' text, visibility of header quote, exitence of user status");
		assertTrue("Required element/text not displayed", selenium.waitForElementPresent(GetFit.CONTENT_HEADER), selenium);
		assertTrue("Required element/text not displayed", selenium.getText(GetFit.CONTENT_HEADER_HEADING).equals("Get Fit"), selenium);
		assertTrue("Required element/text not displayed", selenium.waitForTextPresent("Featured this week"), selenium);
		assertTrue("Required element/text not displayed", selenium.waitForElementPresent(GetFit.CONTENT_HEADER_USER_QUOTE), selenium);
		assertTrue("Required element/text not displayed", !selenium.getText(GetFit.CONTENT_HEADER_USER_STAT).equals(""), selenium);
		
		
		selenium.logComment("Verifying number of links under 'Featured this week'");
		assertTrue("There are no links displayed under 'Featured this week'", selenium.getXpathCount(GetFit.CONTENT_HEADER_FEARURED_LINKS).intValue() > 0, selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
				
	}
	
	
	
	
	
}
