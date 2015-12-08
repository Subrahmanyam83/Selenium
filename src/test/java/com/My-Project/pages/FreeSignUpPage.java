package com.tbb.pages;

//import static com.tbb.framework.BaseTest.assertTrue;

import com.tbb.constants.UIRepository.FreeSignUp;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

public class FreeSignUpPage extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Join/Upgrade Page.
	 * @param	selenium
	 */
	public FreeSignUpPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Free Sign Up Page.");
		this.selenium = selenium;
		assertTrue(
					"This is not Free Sign Up Page, current page is: "
							+ selenium.getLocation(),
					selenium.getTitle().equals("Team Beachbody - Join/Upgrade"), selenium);
		
	assertTrue("Text 'Sign Up for a Free Team Beachbody Account!' not displayed", selenium.isTextPresent("Sign Up for a Free Team Beachbody Account!"), selenium );
	}
	
	/**
	 * Verfies page UI
	 */
	public void verifyUI(String[] testData) {
		for(int i=0; i<testData.length; i++) {
			assertTrue (testData[i] + " not found", selenium.isTextPresent(testData[i]), selenium);
		}

	}
	
	/**
	 * This method enters data in 'Login Information' section
	 */
	public void enterLoginInformationData(String fname, String lname, String email, String confirmEmail, String pwd, String confirmPWD, String screenName, 
		String dob_month, String dob_day, String dob_year, String phone, String gender) {
		
		selenium.type(FreeSignUp.FIRST_NAME, fname);
		selenium.type(FreeSignUp.LAST_NAME, lname);
		selenium.type(FreeSignUp.EMAIL, email);
		selenium.type(FreeSignUp.CONFIRM_EMAIL, confirmEmail);
		selenium.type(FreeSignUp.PASSWORD, pwd);
		selenium.type(FreeSignUp.CONFIRM_PASSWORD, confirmPWD);
		selenium.type(FreeSignUp.SCREEN_NAME, screenName);
		selenium.select(FreeSignUp.DATE_OF_BRITH_MONTH, dob_month);
		selenium.select(FreeSignUp.DATE_OF_BRITH_DAY, dob_day);
		selenium.select(FreeSignUp.DATE_OF_BRITH_YEAR, dob_year);
		selenium.type(FreeSignUp.PHONE, phone);
		if (gender.equalsIgnoreCase("female"))
			selenium.check(FreeSignUp.GENDER_FEMALE);
		else
			selenium.check(FreeSignUp.GENDER_MALE);
		
		
		
		
	}
	
	
	/**
	 * This method enters data in 'Account Information' section
	 */
	public void enterAccountInformationData(String address, String address2, String city, String stateProvince, String zipPostal, String country) {
		selenium.type(FreeSignUp.ADDRESS1, address);
		selenium.type(FreeSignUp.ADDRESS2, address2);
		selenium.type(FreeSignUp.CITY, city);
		selenium.select(FreeSignUp.STATE_PROVINCE, stateProvince);
		selenium.type(FreeSignUp.ZIP_POSTAL, zipPostal);
		selenium.select(FreeSignUp.COUNTRY, country);
	}
	
	/**
	 * This method enters data in 'Coach Section' section
	 */
	public void enterCoachSectionData() {
		
	}
	
	
	/**
	 * This method submit the sign up form
	 */
	public void submitSignUpForm(String DSR, String TBBRules) {
		if (DSR.equals("yes")) selenium.check(FreeSignUp.T_N_C_DAILY_SWEEPTAKES_RULES);
		if (TBBRules.equals("yes")) selenium.check(FreeSignUp.T_N_C_TBB);
		//selenium.type(FreeSignUp.CAPTCHA_TEXT, "dont know");
		//selenium.click(FreeSignUp.SUBMIT_BUTTON);
	}
	
	
	/**
	 * This method checks availability of given screen name
	 */
	public boolean checkAvailability(String screenName) {
		selenium.type(FreeSignUp.CHECK_AVAILABILITY, screenName);
		selenium.fireEvent(FreeSignUp.CHECK_AVAILABILITY_BUTTON, "click");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (selenium.isTextPresent("Screen name is already taken"))
			return false;
		else if (selenium.isTextPresent("Available"))
			return true;
		
		return false;
	}
}
