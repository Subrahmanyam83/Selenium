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
import com.tbb.pages.getfit.FitnessProgramsPage;
import com.tbb.pages.getfit.GetFitPage;
/**
 * 
 * This test script contains test method(s) for Fitness Programs page under Get-Fit module
 * @author Gaurav
 */
public class TestFitnessProgramsPage extends BaseTest {

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
	 * This test verifies UI of Fitness Programs page. It verifies whether all the required 
	 * firness programs are listed there.
	 */
	@Test
	public void testFitnessProgramsPage() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Get Fit' link");
		selenium.logComment("Going to 'Fitness Program' page");
		selenium.logComment("Verifying UI of page");
		selenium.logComment("Getting titles of Fitness Programs and verifying that");
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
		
		selenium.logComment("Going to 'Fitness Program' page");
		FitnessProgramsPage fitnessProgramsPage = getFitPage.goToFitnessProgramsPage();
		
		selenium.logComment("Verifying UI of page");
		fitnessProgramsPage.verifyUI();
		
		selenium.logComment("Getting titles of Fitness Programs and verifying that");
		ArrayList fitnessPrograms = fitnessProgramsPage.getFitnessProgramsTitles();
		String[] fitnessProgramsData = new String[] {"P90X®", "P90X2™", "INSANITY®", "INSANITY: THE ASYLUM™", "Tony Horton's 10-Minute Trainer®", "ChaLEAN Extreme®", "Brazil Butt Lift®", "TurboFire®", "Body Gospel®", "Debbie Siebers' Slim in 6®", "Power 90®", "Turbo Jam®", "P90X ONE on ONE®", "RevAbs®", "Hip Hop Abs®"};
		List<String> fitnessProgramsDataList = Arrays.asList(fitnessProgramsData);
		assertTrue("Required Fitness program not displayed", fitnessProgramsDataList.equals(fitnessPrograms), selenium);
		
		selenium.logComment("Getting titles of RRMs and verifying that");
		ArrayList rrmTitles = fitnessProgramsPage.getRRMsTitles();
		String[] rrmTitlesData = new String[] {"Featured Products", "Enter to Win Up to $100k", "Shakeology®"};
		List<String> rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed", rrmTitlesDataList.equals(rrmTitles), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
				
		
	}
}
