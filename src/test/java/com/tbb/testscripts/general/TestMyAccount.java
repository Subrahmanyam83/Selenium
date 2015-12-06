package com.tbb.testscripts.general;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.MyAccount;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.MyAccountPage;
import com.tbb.pages.SignInPage;

/**
 * 
 * This test script contains test method(s) for verifying functionality related to My Account page
 * @author Gaurav
 */

public class TestMyAccount extends BaseTest{

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
	 * This is data provider for testSaveMyAccountAsFreeUser Test Script.
	 */ 
	@DataProvider(name = "freeMyAccountData")
	public Object[][] createfreeMyAccountUserData() {
		return new Object[][] {
				{"jgupta@xebia.com", "Jaya", "Gupta", "United States", "612, Park Centra", "Sector 30", "New York", "New York", "10001", "9966013697"},
		};
	}
	
	/**
	 * Test script for saving My Account - Personal Information as free user.
	 */ 
	@Test (dataProvider = "freeMyAccountData")
	public void testSaveMyAccountAsFreeUser(String email, String firstName, String lastName, String country, String address, String apt, String city, String state, String zip, String phone){
		
			selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
			Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
			
			selenium.logComment("################## Scope of this test method ######################");
			selenium.logComment("Verifying whether are on Home page");
			selenium.logComment("Clicking on 'Sign In' Link");
			selenium.logComment("Entering valid username and password");
			selenium.logComment("Navigate to My Account.");
			selenium.logComment("Enter the Personal Information.");
			selenium.logComment("Verifying clicking on 'Save' button.");
			selenium.logComment("Verifying if the success message is displayed.");
			selenium.logComment("Executing assertEmpty method");
			selenium.logComment("################## Scope of this test method ######################");
			
				
			selenium.logComment("Verifying whether are on Home page");
			HomePage homePage  = new HomePage(selenium);
			
			selenium.logComment("Clicking on 'Sign In' Link");
			DashboardPage dashboardPage;
			if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
				dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
			} else {
				SignInPage signInPage = homePage.clickSignIn();
				
				selenium.logComment("Entering valid username and password");
				dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
			}
			
			selenium.logComment("Navigate to My Account.");
			MyAccountPage myAccountPage = dashboardPage.clickMyAccountLink();
			
			selenium.logComment("Enter the Personal Information.");
			myAccountPage.typePersonalInfoAsFreeUser(email, firstName, lastName, country, address, apt, city, state, zip, phone);
					
			selenium.logComment("Verifying clicking on 'Save' button.");			
			myAccountPage.clickSaveButton();
			
			selenium.logComment("Verifying if the success message is displayed.");	
			assertTrue("Success Message portlet is not available after clicking on Save Button.", selenium.isElementPresent("css=div.portlet-msg-success"), selenium );
			assertTrue("Success Message text is not available after clicking on Save Button.", selenium.isTextPresent("Your request processed successfully. "), selenium );
						
			selenium.logComment("Executing assertEmpty method");
			emptyMessageBuilder();
		}
	
	/***
	 * This is data provider for testSaveMyAccountAsClubUKUser Test Script.
	 */ 
	@DataProvider(name = "clubUKUserMyAccountData")
	public Object[][] createClubUKMyAccountUserData() {
		return new Object[][] {
				{"asukclub10051@beachbodytest.com", "SoftekUK1", "UKCLUB1"},
		};
	}
	
	/**
	 * Test script for saving My Account - Personal Information as Club UK user.
	 */  
	@Test (dataProvider = "clubUKUserMyAccountData")
	public void testSaveMyAccountAsClubUKUser(String email, String firstName, String lastName){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to My Account.");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to My Account.");
		selenium.logComment("Enter the Personal Information.");
		selenium.logComment("Verifying clicking on 'Save' button.");
		selenium.logComment("Verifying if the success message is displayed.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
				
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.clubuk.username"), ConfigFileReader.getConfigItemValue("tbb.clubuk.userpassword"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.clubuk.username"), ConfigFileReader.getConfigItemValue("tbb.clubuk.userpassword"));
		}
		
		selenium.logComment("Navigate to My Account.");
		MyAccountPage myAccountPage = dashboardPage.clickMyAccountLink();
		
		selenium.logComment("Enter the Personal Information.");
		myAccountPage.typePersonalInfoAsClubUKUser(email, firstName, lastName);
				
		selenium.logComment("Verifying clicking on 'Save' button.");			
		myAccountPage.clickSaveButton();
		
		selenium.logComment("Verifying if the success message is displayed.");	
		assertTrue("Success Message portlet is not available after clicking on Save Button.", selenium.isElementPresent(MyAccount.SUCCESS_MESSAGE), selenium );
		assertTrue("Success Message text is not available after clicking on Save Button.", selenium.isTextPresent("Your request processed successfully."), selenium );
					
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/***
	 * This is data provider for testSaveMyAccountAsCoachUser Test Script.
	 */ 
	@DataProvider(name = "coachMyAccountData")
	public Object[][] createCoachMyAccountUserData() {
		return new Object[][] {
				{"agrover@beachbody.com", "Aarti", "Grover", "United States", "1166 Avenue of the Americas", "Ninth Floor", "New York", "New York", "10036", "2124780000", "United States", "1166 Avenue of the Americas", "Ninth Floor", "Santa Monica", "California", "90401"},
		};
	}
	
	/**
	 * Test script for saving My Account - Personal Information as Coach user.
	 */ 
	@Test (dataProvider = "coachMyAccountData")
	public void testSaveMyAccountAsCoachUser(String email, String firstName, String lastName, String country, String address, String apt, String city, String state, String zip, String phone, String billingCountry, String billingAddress, String billingApt, String billingCity, String billingState, String billingZip){
		
			selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
			Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
			
			selenium.logComment("################## Scope of this test method ######################");
			selenium.logComment("Verifying whether are on Home page");
			selenium.logComment("Clicking on 'Sign In' Link");
			selenium.logComment("Entering valid username and password");
			selenium.logComment("Navigate to My Account.");
			selenium.logComment("Enter the Personal Information.");
			selenium.logComment("Verifying clicking on 'Save' button.");
			selenium.logComment("Verifying if the success message is displayed.");
			selenium.logComment("Executing assertEmpty method");
			selenium.logComment("################## Scope of this test method ######################");
			
			
			
			
			
			selenium.logComment("Verifying whether are on Home page");
			HomePage homePage  = new HomePage(selenium);
			
			selenium.logComment("Clicking on 'Sign In' Link");
			DashboardPage dashboardPage;
			if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
				dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
			} else {
				SignInPage signInPage = homePage.clickSignIn();
				
				selenium.logComment("Entering valid username and password");
				dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
			}
			
			selenium.logComment("Navigate to My Account.");
			MyAccountPage myAccountPage = dashboardPage.clickMyAccountLink();
			
			selenium.logComment("Enter the Personal Information.");
			myAccountPage.typePersonalInfoAsCoachUser(email, firstName, lastName, country, address, apt, city, state, zip, phone, billingCountry, billingAddress, billingApt, billingCity, billingState, billingZip);
					
			selenium.logComment("Verifying clicking on 'Save' button.");			
			myAccountPage.clickSaveButton();
			
			selenium.logComment("Verifying if the success message is displayed.");	
			assertTrue("Success Message portlet is not available after clicking on Save Button.", selenium.isElementPresent("css=div.portlet-msg-success"), selenium );
			assertTrue("Success Message text is not available after clicking on Save Button.", selenium.isTextPresent("Your request processed successfully. "), selenium );
						
			selenium.logComment("Executing assertEmpty method");
			emptyMessageBuilder();
		}
	
	/***
	 * This is data provider for testResetMyAccountAsFreeUser Test Script.
	 */ 
	@DataProvider(name = "resetMyAccountDataProvider")
	public Object[][] createResetMyAccountFreeData() {
		return new Object[][] {
				{"jgupta@beachbody.com", "Jaya 1", "Gupta 1", "Canada", "96, Road Number 2", "Banjara Hills", "Hyderabad", "Manitoba", "313001", "8800288996"},
		};
	}

	/***
	 * Test script for modifying all field values and then doing a reset.
	 * It verifies if the values were actually reset. 
	 */ 
	@Test (dataProvider = "resetMyAccountDataProvider")
	public void testResetMyAccountAsFreeUser(String email, String firstName, String lastName, String country, String address, String apt, String city, String state, String zip, String phone) {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to My Account.");
		selenium.logComment("Extracting the existing basic information form data and storing into a map.");
		selenium.logComment("Enter the Personal Information.");
		selenium.logComment("Clicking on Reset Button.");
		selenium.logComment("Verifying that the data entered is reset and the earlier data is displayed.");
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

		selenium.logComment("Navigate to My Account.");
		MyAccountPage myAccountPage = dashboardPage.clickMyAccountLink();

		selenium.logComment("Extracting the existing basic information form data and storing into a map.");
		Map<String, String> map = myAccountPage.getExistingFormDataAsFreeUser();
		
		selenium.logComment("Enter the Personal Information.");
		myAccountPage.typePersonalInfoAsFreeUser(email, firstName, lastName, country, address, apt, city, state, zip, phone);
				
		selenium.logComment("Clicking on Reset Button.");
		myAccountPage.clickResetButton();	

		selenium.logComment("Verifying that the data entered is reset and the earlier data is displayed."); 
		assertTrue("Success message is displayed after clicking on reset.", !selenium.isElementPresent(MyAccount.SUCCESS_MESSAGE), selenium);
		assertTrue("Email was not reset.", selenium.getValue(MyAccount.EMAIL_TEXTBOX).equals(map.get(MyAccount.EMAIL_TEXTBOX)), selenium);
		assertTrue("First Name was not reset.", selenium.getValue(MyAccount.FIRST_NAME_TEXTBOX).equals(map.get(MyAccount.FIRST_NAME_TEXTBOX)), selenium);
		assertTrue("Last Name was not reset.", selenium.getValue(MyAccount.LAST_NAME_TEXTBOX).equals(map.get(MyAccount.LAST_NAME_TEXTBOX)), selenium);
		assertTrue("Country Dropdown was not reset.", selenium.getSelectedLabel(MyAccount.COUNTRY_DROPDOWN).equals(map.get(MyAccount.COUNTRY_DROPDOWN)), selenium);
		assertTrue("Address was not reset.", selenium.getValue(MyAccount.ADDRESS_TEXTBOX).equals(map.get(MyAccount.ADDRESS_TEXTBOX)), selenium);
		assertTrue("Apt, Suite, etc. textbox was not reset.", selenium.getValue(MyAccount.APT_SUITE_ETC_TEXTBOX).equals(map.get(MyAccount.APT_SUITE_ETC_TEXTBOX)), selenium);
		assertTrue("City textbox was not reset.", selenium.getValue(MyAccount.CITY_TEXTBOX).equals(map.get(MyAccount.CITY_TEXTBOX)), selenium);
		assertTrue("State/Province was not reset.", selenium.getSelectedLabel(MyAccount.STATE_DROPDOWN).equals(map.get(MyAccount.STATE_DROPDOWN)), selenium);
		assertTrue("Zip/Postal was not reset.", selenium.getValue(MyAccount.ZIP_TEXTBOX).equals(map.get(MyAccount.ZIP_TEXTBOX)), selenium);
		assertTrue("Phone was not reset.", selenium.getValue(MyAccount.PHONE_TEXTBOX).equals(map.get(MyAccount.PHONE_TEXTBOX)), selenium);

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}   
	
	/***
	 * This is data provider for testResetMyAccountAsClubUKUser Test Script.
	 */ 
	@DataProvider(name = "resetMyAccountClubUKDataProvider")
	public Object[][] createResetMyAccountClubUKData() {
		return new Object[][] {
				{"jgupta@beachbody.com", "Jaya 1", "Gupta 1"},
		};
	}

	/***
	 * Test script for modifying all field values and then doing a reset as Club UK User.
	 * It verifies if the values were actually reset. 
	 */ 
	@Test (dataProvider = "resetMyAccountClubUKDataProvider")
	public void testResetMyAccountAsClubUKUser(String email, String firstName, String lastName) {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to My Account.");
		selenium.logComment("Extracting the existing basic information form data and storing into a map.");
		selenium.logComment("Enter the Personal Information.");
		selenium.logComment("Clicking on Reset Button.");
		selenium.logComment("Verifying that the data entered is reset and the earlier data is displayed.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		
		

		selenium.logComment("Verifying whether user is on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.clubuk.username"), ConfigFileReader.getConfigItemValue("tbb.clubuk.userpassword"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.clubuk.username"), ConfigFileReader.getConfigItemValue("tbb.clubuk.userpassword"));
		}

		selenium.logComment("Navigate to My Account.");
		MyAccountPage myAccountPage = dashboardPage.clickMyAccountLink();

		selenium.logComment("Extracting the existing basic information form data and storing into a map.");
		Map<String, String> map = myAccountPage.getExistingFormDataAsClubUKUser();
		
		selenium.logComment("Enter the Personal Information.");
		myAccountPage.typePersonalInfoAsClubUKUser(email, firstName, lastName);
				
		selenium.logComment("Clicking on Reset Button.");
		myAccountPage.clickResetButton();	

		selenium.logComment("Verifying that the data entered is reset and the earlier data is displayed."); 
		assertTrue("Success message is displayed after clicking on reset.", !selenium.isElementPresent(MyAccount.SUCCESS_MESSAGE), selenium);
		assertTrue("Email was not reset.", selenium.getValue(MyAccount.EMAIL_TEXTBOX).equals(map.get(MyAccount.EMAIL_TEXTBOX)), selenium);
		assertTrue("First Name was not reset.", selenium.getValue(MyAccount.FIRST_NAME_TEXTBOX).equals(map.get(MyAccount.FIRST_NAME_TEXTBOX)), selenium);
		assertTrue("Last Name was not reset.", selenium.getValue(MyAccount.LAST_NAME_TEXTBOX).equals(map.get(MyAccount.LAST_NAME_TEXTBOX)), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}   
	
	/***
	 * This is data provider for testResetMyAccountAsCoachUser Test Script.
	 */ 
	@DataProvider(name = "resetMyAccountCoachDataProvider")
	public Object[][] createResetMyAccountCoachData() {
		return new Object[][] {
				{"jgupta@beachbody.com", "Jaya 1", "Gupta 1", "Canada", "Maple Heights", "Maple Crescent", "Gurgaon", "Yukon", "123456", "9948169260", "Canada", "E-205", "Maple", "Gurgaon", "Quebec", "89040"},
		};
	}

	/***
	 * Test script for modifying all field values and then doing a reset as Coach User.
	 * It verifies if the values were actually reset. 
	 */ 
	@Test (dataProvider = "resetMyAccountCoachDataProvider")
	public void testResetMyAccountAsCoachUser(String email, String firstName, String lastName, String country, String address, String apt, String city, String state, String zip, String phone, String billingCountry, String billingAddress, String billingApt, String billingCity, String billingState, String billingZip) {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to My Account.");
		selenium.logComment("Extracting the existing basic information form data and storing into a map.");
		selenium.logComment("Enter the Personal Information.");
		selenium.logComment("Clicking on Reset Button.");
		selenium.logComment("Verifying that the data entered is reset and the earlier data is displayed.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		
		selenium.logComment("Verifying whether user is on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
		}

		selenium.logComment("Navigate to My Account.");
		MyAccountPage myAccountPage = dashboardPage.clickMyAccountLink();

		selenium.logComment("Extracting the existing basic information form data and storing into a map.");
		Map<String, String> map = myAccountPage.getExistingFormDataAsCoachUser();
		
		selenium.logComment("Enter the Personal Information.");
		myAccountPage.typePersonalInfoAsCoachUser(email, firstName, lastName, country, address, apt, city, state, zip, phone, billingCountry, billingAddress, billingApt, billingCity, billingState, billingZip);
				
		selenium.logComment("Clicking on Reset Button.");
		myAccountPage.clickResetButton();	

		selenium.logComment("Verifying that the data entered is reset and the earlier data is displayed."); 
		assertTrue("Success message is displayed after clicking on reset.", !selenium.isElementPresent(MyAccount.SUCCESS_MESSAGE), selenium);
		assertTrue("Email was not reset.", selenium.getValue(MyAccount.EMAIL_TEXTBOX).equals(map.get(MyAccount.EMAIL_TEXTBOX)), selenium);
		assertTrue("First Name was not reset.", selenium.getValue(MyAccount.FIRST_NAME_TEXTBOX).equals(map.get(MyAccount.FIRST_NAME_TEXTBOX)), selenium);
		assertTrue("Last Name was not reset.", selenium.getValue(MyAccount.LAST_NAME_TEXTBOX).equals(map.get(MyAccount.LAST_NAME_TEXTBOX)), selenium);
		assertTrue("Country Dropdown was not reset.", selenium.getSelectedLabel(MyAccount.COUNTRY_DROPDOWN).equals(map.get(MyAccount.COUNTRY_DROPDOWN)), selenium);
		assertTrue("Address was not reset.", selenium.getValue(MyAccount.ADDRESS_TEXTBOX).equals(map.get(MyAccount.ADDRESS_TEXTBOX)), selenium);
		assertTrue("Apt, Suite, etc. textbox was not reset.", selenium.getValue(MyAccount.APT_SUITE_ETC_TEXTBOX).equals(map.get(MyAccount.APT_SUITE_ETC_TEXTBOX)), selenium);
		assertTrue("City textbox was not reset.", selenium.getValue(MyAccount.CITY_TEXTBOX).equals(map.get(MyAccount.CITY_TEXTBOX)), selenium);
		assertTrue("State/Province was not reset.", selenium.getSelectedLabel(MyAccount.STATE_DROPDOWN).equals(map.get(MyAccount.STATE_DROPDOWN)), selenium);
		assertTrue("Zip/Postal was not reset.", selenium.getValue(MyAccount.ZIP_TEXTBOX).equals(map.get(MyAccount.ZIP_TEXTBOX)), selenium);
		assertTrue("Phone was not reset.", selenium.getValue(MyAccount.PHONE_TEXTBOX).equals(map.get(MyAccount.PHONE_TEXTBOX)), selenium);
		
		//assertTrue("Billing Country dropdown was not reset.", selenium.getSelectedLabel(MyAccount.BILLING_COUNTRY).equals(map.get(MyAccount.BILLING_COUNTRY)), selenium);
		assertTrue("Billing Address was not reset.", selenium.getValue(MyAccount.BILLING_ADDRESS).equals(map.get(MyAccount.BILLING_ADDRESS)), selenium);
		assertTrue("Billing Apt, Suite, etc. was not reset.", selenium.getValue(MyAccount.BILLING_APT_SUITE_ETC).equals(map.get(MyAccount.BILLING_APT_SUITE_ETC)), selenium);
		assertTrue("Billing City was not reset.", selenium.getValue(MyAccount.BILLING_CITY).equals(map.get(MyAccount.BILLING_CITY)), selenium);
		//assertTrue("Billing State/Province dropdown was not reset.", selenium.getSelectedLabel(MyAccount.BILLING_STATE).equals(map.get(MyAccount.BILLING_STATE)), selenium);
		assertTrue("Billing Zip/Postal was not reset.", selenium.getValue(MyAccount.BILLING_ZIP).equals(map.get(MyAccount.BILLING_ZIP)), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}   
}