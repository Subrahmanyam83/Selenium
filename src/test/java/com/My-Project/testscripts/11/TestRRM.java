package com.tbb.testscripts.others;

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
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.getfit.FitnessProgramsPage;
import com.tbb.pages.getfit.GetFitPage;
import com.tbb.pages.watchvideos.SuccessStoriesPage;
import com.tbb.pages.watchvideos.WatchVideosPage;

/**
 *
 * This test script contains test method for verifying TBB Help/FAQ section shows required 
 * info. It also verifies navigation among different available help and faq links.
 *  @author Gaurav
 */
public class TestRRM extends BaseTest {

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
	 * This test verifies RRM Appearance on different pages. 
	 */
	
	@Test
	public void testRRMAppearanceOnDifferentPages() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Getting titles of RRMs and verifying that on Dashboard Page");
		selenium.logComment("Navigating to Get Fit - Fitness Programs Page.");
		selenium.logComment("Getting titles of RRMs and verifying that on Fitnesss Programs Page");
		selenium.logComment("Navigating to Eat Smart Page.");
		selenium.logComment("Getting titles of RRMs and verifying that on Eat Smart Page");
		selenium.logComment("Navigating to Connect Page.");
		selenium.logComment("Getting titles of RRMs and verifying that on Connect Page");
		selenium.logComment("Navigating to Watch Videos - Success Stories Page.");
		selenium.logComment("Getting titles of RRMs and verifying that on Success Stories Page");
		selenium.logComment("Navigating to About Page.");
		selenium.logComment("Getting titles of RRMs and verifying that on About Page");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		
		selenium.logComment("Verifying whether user is on Home page");
		HomePage home = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = home.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = home.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}
		
		selenium.logComment("Getting titles of RRMs and verifying that on Dashboard Page");
		ArrayList rrmTitles = dashboardPage.getRRMsTitles();
		String[] rrmTitlesData = new String[] {"Featured Products", "Enter to Win Up to $100k", "Shakeology®"};
		List<String> rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed on Dashboard Page.", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Navigating to Get Fit - Fitness Programs Page.");
		GetFitPage getFitPage = dashboardPage.clickGetFitLink();
		FitnessProgramsPage fitnessProgramsPage = getFitPage.clickFitnessProgramsLearnMore();
		
		selenium.logComment("Getting titles of RRMs and verifying that on Fitnesss Programs Page");
		rrmTitles = fitnessProgramsPage.getRRMsTitles();
		rrmTitlesData = new String[] {"Featured Products", "Enter to Win Up to $100k", "Shakeology®"};
		rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed on Fitness Programs Page.", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Navigating to Eat Smart Page.");
		EatSmartPage eatSmartPage = fitnessProgramsPage.clickEatSmartLink();
		
		selenium.logComment("Getting titles of RRMs and verifying that on Eat Smart Page");
		rrmTitles = eatSmartPage.getRRMsTitles();
		rrmTitlesData = new String[] {"My Meal Planner", "Shakeology®", "Nutrition Tips", "Success Stories"};
		rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed on Eat Smart Page.", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Navigating to Connect Page.");
		ConnectPage connectPage = eatSmartPage.clickConnectLink();
		
		selenium.logComment("Getting titles of RRMs and verifying that on Connect Page");
		rrmTitles = connectPage.getRRMsTitles();
		rrmTitlesData = new String[] {"Find Buddies", "Message Boards", "My Coach", "Success Stories"};
		rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed on Connect Page.", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Navigating to Watch Videos - Success Stories Page.");
		WatchVideosPage watchVideosPage = connectPage.clickWatchVideosLink();
		SuccessStoriesPage successStoriesPage = watchVideosPage.clickSuccessStoriesWatchNow();
		
		selenium.logComment("Getting titles of RRMs and verifying that on Success Stories Page");
		rrmTitles = successStoriesPage.getRRMsTitles();
		rrmTitlesData = new String[] {"Compare Products", "Enter to Win Up to $100k", "Find Buddies", "Message Boards", "Nutrition Tips"};
		rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed on Success Stories Page.", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Navigating to About Page.");
		AboutPage aboutPage = successStoriesPage.clickAboutLink();
		
		selenium.logComment("Getting titles of RRMs and verifying that on About Page");
		rrmTitles = aboutPage.getRRMsTitles();
		rrmTitlesData = new String[] {"My Meal Planner", "Success Stories", "Shakeology®"};
		rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed on About Page.", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}  
}
