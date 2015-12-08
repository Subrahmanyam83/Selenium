package com.tbb.testscripts.gsw;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.StartUpWizard;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.GettingStartedWizardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;

/**
 *
 * This test script contains test method for verifying that user can complete startup wizard with feedback
 *  @author Gaurav
 */
public class TestCompleteStartUpWizardWithFeedback extends BaseTest {
	
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
	 * This test method verifies that user can complete Start Up Wizard with feedback.
	 */
	@Test
	public void testCompleteStartUpWizardWithFeedback() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Start Up Wizard' Link");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
	
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.clubuser"), ConfigFileReader.getConfigItemValue("tbb.clubpassword"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.clubuser"), ConfigFileReader.getConfigItemValue("tbb.clubpassword"));
		}
	
		
		selenium.logComment("Clicking on 'Start Up Wizard' Link");
		GettingStartedWizardPage gettingStartedWizardPage = dashboardPage.clickStartUpWizard();
		if(selenium.isTextPresent("Welcome back.")) {
			gettingStartedWizardPage.completePreviousStartedWizard();
		}
		assertTrue("Wizard not displayed", selenium.waitForTextPresent("Let's begin with your profile. Just click \"next\" to get started."), selenium);
		
		
		gettingStartedWizardPage.clickNext();
		assertTrue("Basic Information text not displayed", selenium.waitForTextPresent("Basic Information"), selenium);
		assertTrue("Required div is not active", selenium.isElementPresent(StartUpWizard.ABOUT_ME_DIV), selenium);

		gettingStartedWizardPage.clickNext();
		assertTrue("Progress and Goals text not displayed", selenium.waitForTextPresent("Progress and Goals"), selenium);

		gettingStartedWizardPage.clickNext();
		assertTrue("Programs and Activities text not displayed", selenium.waitForTextPresent("Programs and Activities"), selenium);
	
		
		gettingStartedWizardPage.clickNext();
		assertTrue("Photos text not displayed", selenium.waitForTextPresent("Photos"), selenium);
	
		
		gettingStartedWizardPage.clickNext();
		assertTrue("WOWY SuperGym® text not displayed", selenium.waitForTextPresent("WOWY SuperGym®"), selenium);
		assertTrue("Required div is not active", selenium.isElementPresent(StartUpWizard.GET_FIT_DIV), selenium);
		
				
		gettingStartedWizardPage.clickNext();
		assertTrue("Beachbody Trainers text not displayed", selenium.waitForTextPresent("Beachbody Trainers"), selenium);
	
			
		gettingStartedWizardPage.clickNext();
		assertTrue("Eat Smart text not displayed", selenium.waitForTextPresent("Eat Smart"), selenium);
		assertTrue("Required div is not active", selenium.isElementPresent(StartUpWizard.EAT_SMART_DIV), selenium);
		
		gettingStartedWizardPage.clickNext();
		assertTrue("Connect text not displayed", selenium.waitForTextPresent("Connect"), selenium);
		assertTrue("Required div is not active", selenium.isElementPresent(StartUpWizard.CONNECT_DIV), selenium);
		
		gettingStartedWizardPage.clickNext();
		assertTrue("Message Boards text not displayed", selenium.waitForTextPresent("Message Boards"), selenium);
	
		
		gettingStartedWizardPage.clickNext();
		assertTrue("Shop text not displayed", selenium.waitForTextPresent("Shop"), selenium);
		assertTrue("Required div is not active", selenium.isElementPresent(StartUpWizard.SHOP_DIV), selenium);
		
		gettingStartedWizardPage.clickNext();
		assertTrue("Congratulations text not displayed", selenium.waitForTextPresent("Congratulations"), selenium);
		
		gettingStartedWizardPage.submitWithFeedback("Very informative");
	
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
}
