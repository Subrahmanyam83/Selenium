package com.tbb.testscripts.general;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.framework.BaseTest;
import com.tbb.pages.FreeSignUpPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.about.JoinUpgradePage;
import com.tbb.utils.FileReader;

public class TestFreeSignUp extends BaseTest {
	
	// Fetching test data
	FileReader testDataFile = new FileReader("TestFreeSignUp-testFreeSignUp");
	List<String> textVerificationDataList, loginDataList, accountDataList, formSubmissionDataList = null;
	String[] testData = null;

	
	
	@BeforeClass
	public void setUp() {
		startSeleniumServer();
		
		
	}
	
	@BeforeMethod
	public void setUp(Method method) {
		createSeleniumInstance(method);
		
		testDataFile.processNextTestStep();
		textVerificationDataList = testDataFile.getMultipleValuesFromSingleTestAction();
			
		testDataFile.processNextTestStep();
		loginDataList = testDataFile.getMultipleValuesFromSingleTestAction();
		
		testDataFile.processNextTestStep();
		accountDataList = testDataFile.getMultipleValuesFromSingleTestAction();
		
		
		testDataFile.processNextTestStep();
		formSubmissionDataList = testDataFile.getMultipleValuesFromSingleTestAction();
		
		
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
	 * This test verifies Free sign up page.
	 */
	@Test
	public void testFreeSignUp() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Not a Member?' link");
		selenium.logComment("Clicking on Free Membership button");
		selenium.logComment("Checking availability of screen name");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Not a Member?' link");
		JoinUpgradePage joinUpgradePage = homePage.clickNotAMemberLink();
		
		selenium.logComment("Clicking on Free Membership button");
		FreeSignUpPage freeSignUpPage = joinUpgradePage.clickFreeMembershipButton();
		
		testData = textVerificationDataList.toArray(new String[textVerificationDataList.size()]);
		selenium.logComment("Verifying existence of required text on page");
		freeSignUpPage.verifyUI(testData);
		
		testData = loginDataList.toArray(new String[loginDataList.size()]);
		selenium.logComment("Entering information in Login Section");
		freeSignUpPage.enterLoginInformationData(testData[0], testData[1], testData[2], testData[3], testData[4], testData[5], testData[6], testData[7], testData[8], testData[9], testData[10], testData[11]);
	
		selenium.logComment("Checking availability of screen name");
		freeSignUpPage.checkAvailability(testData[6]);
	
		testData = accountDataList.toArray(new String[accountDataList.size()]);
		selenium.logComment("Entering information in Account section");
		freeSignUpPage.enterAccountInformationData(testData[0], testData[1], testData[2], testData[3], testData[4], testData[5]);
		
		testData = formSubmissionDataList.toArray(new String[formSubmissionDataList.size()]);
		selenium.logComment("Submitting the form");
		freeSignUpPage.submitSignUpForm(testData[0], testData[1]);				
	}
}
