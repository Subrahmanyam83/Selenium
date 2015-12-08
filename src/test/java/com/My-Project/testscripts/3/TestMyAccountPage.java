package com.tbb.testscripts.clubukuser;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.MyAccount;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;

/**
 * 
 * This test script contains test method(s) for alerts shown on My Accounts page for UK Club user.
 * @author Jaya
 */
public class TestMyAccountPage extends BaseTest{

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
	 * Test script for verifying that address fields are not displayed on My Account Page to the Club UK User.
	 */ 
	@Test
	public void testMyAccountAsClubUKuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to My Account Page.");
		selenium.logComment("Verifying that address fields are not available on My Account page.");
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
		
		selenium.logComment("Navigate to My Account Page.");	
		dashboardPage.clickMyAccountLink();
		
		selenium.logComment("Verifying that address fields are not available on My Account page.");		
		assertTrue("Country Label is available on My Account page.", !(selenium.isTextPresent("Country")), selenium);
		assertTrue("Country drop down is available on My Account page.", !(selenium.isElementPresent(MyAccount.COUNTRY_DROPDOWN)), selenium);
		assertTrue("Address Label is available on My Account page.", !(selenium.isTextPresent("Address")), selenium);
		assertTrue("Address textbox is available on My Account page.", !(selenium.isElementPresent(MyAccount.ADDRESS_TEXTBOX)), selenium);
		assertTrue("Apt, Suite, etc. label is available on My Account page.", !(selenium.isTextPresent("Apt, Suite, etc.")), selenium);
		assertTrue("Apt, Suite, etc. textbox is available on My Account page.", !(selenium.isElementPresent(MyAccount.APT_SUITE_ETC_TEXTBOX)), selenium);
		assertTrue("City Label is available on My Account page.", !(selenium.isTextPresent("City")), selenium);
		assertTrue("City Textbox is available on My Account page.", !(selenium.isElementPresent(MyAccount.CITY_TEXTBOX)), selenium);
		assertTrue("State/Province Label is available on My Account page.", !(selenium.isTextPresent("State/Province")), selenium);
		assertTrue("State/Province dropdown is available on My Account page.", !(selenium.isElementPresent(MyAccount.STATE_DROPDOWN)), selenium);
		assertTrue("Zip/Postal Label is available on My Account page.", !(selenium.isTextPresent("Zip/Postal")), selenium);
		assertTrue("Zip/Postal textbox is available on My Account page.", !(selenium.isElementPresent(MyAccount.ZIP_TEXTBOX)), selenium);
		assertTrue("Phone Label is available on My Account page.", !(selenium.isTextPresent("Phone")), selenium);
		assertTrue("Phone Textbox is available on My Account page.", !(selenium.isElementPresent(MyAccount.PHONE_TEXTBOX)), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/**
	 * Test script for verifying that the Free User is able to see Address fields on My Account page.
	 */ 
	@Test
	public void testMyAccountAsFreeUser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to My Account Page.");
		selenium.logComment("Verifying that address fields are not available on My Account page.");
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

		selenium.logComment("Navigate to My Account Page.");	
		dashboardPage.clickMyAccountLink();
		
		selenium.logComment("Verifying that address fields are not available on My Account page.");		
		assertTrue("Country Label is available on My Account page.", (selenium.isTextPresent("Country")), selenium);
		assertTrue("Country drop down is available on My Account page.", (selenium.isElementPresent(MyAccount.COUNTRY_DROPDOWN)), selenium);
		assertTrue("Address Label is available on My Account page.", (selenium.isTextPresent("Address")), selenium);
		assertTrue("Address textbox is available on My Account page.", (selenium.isElementPresent(MyAccount.ADDRESS_TEXTBOX)), selenium);
		assertTrue("Apt, Suite, etc. label is available on My Account page.", (selenium.isTextPresent("Apt, Suite, etc.")), selenium);
		assertTrue("Apt, Suite, etc. textbox is available on My Account page.", (selenium.isElementPresent(MyAccount.APT_SUITE_ETC_TEXTBOX)), selenium);
		assertTrue("City Label is available on My Account page.", (selenium.isTextPresent("City")), selenium);
		assertTrue("City Textbox is available on My Account page.", (selenium.isElementPresent(MyAccount.CITY_TEXTBOX)), selenium);
		assertTrue("State/Province Label is available on My Account page.", (selenium.isTextPresent("State/Province")), selenium);
		assertTrue("State/Province dropdown is available on My Account page.", (selenium.isElementPresent(MyAccount.STATE_DROPDOWN)), selenium);
		assertTrue("Zip/Postal Label is available on My Account page.", (selenium.isTextPresent("Zip/Postal")), selenium);
		assertTrue("Zip/Postal textbox is available on My Account page.", (selenium.isElementPresent(MyAccount.ZIP_TEXTBOX)), selenium);
		assertTrue("Phone Label is available on My Account page.", (selenium.isTextPresent("Phone")), selenium);
		assertTrue("Phone Textbox is available on My Account page.", (selenium.isElementPresent(MyAccount.PHONE_TEXTBOX)), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}