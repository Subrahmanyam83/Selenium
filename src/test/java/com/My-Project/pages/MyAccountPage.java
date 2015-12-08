package com.tbb.pages;

//import static com.tbb.framework.BaseTest.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.MyAccount;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the My Account Page
 * @author Jaya
 */
public class MyAccountPage  extends BaseTest  implements MyAccount {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on My Account Page.
	 * @param	selenium
	 */
	public MyAccountPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of My Account Page");
		this.selenium = selenium;
		assertTrue("This is not My Account Page, current page " + selenium.getLocation(), selenium.getTitle().contains("My Account"), selenium);
	}
	
	/**
	 * Types personal information in the fields available on My Account Page as Club UK User.
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public void typePersonalInfoAsClubUKUser(String email, String firstName,
			String lastName) {
		selenium.type(MyAccount.EMAIL_TEXTBOX, email);
		selenium.type(MyAccount.FIRST_NAME_TEXTBOX, firstName);
		selenium.type(MyAccount.LAST_NAME_TEXTBOX, lastName);
	}
	
	/**
	 * Types personal information in the fields available on My Account Page as Free User.
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param country
	 * @param address
	 * @param apt
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	public void typePersonalInfoAsFreeUser(String email, String firstName,
			String lastName, String country, String address, String apt,
			String city, String state, String zip, String phone) {
		selenium.type(MyAccount.EMAIL_TEXTBOX, email);
		selenium.type(MyAccount.FIRST_NAME_TEXTBOX, firstName);
		selenium.type(MyAccount.LAST_NAME_TEXTBOX, lastName);
		selenium.select(MyAccount.COUNTRY_DROPDOWN, country);
		selenium.type(MyAccount.ADDRESS_TEXTBOX, address);
		selenium.type(MyAccount.APT_SUITE_ETC_TEXTBOX, apt);
		selenium.type(MyAccount.CITY_TEXTBOX, city);
		selenium.select(MyAccount.STATE_DROPDOWN, state);
		selenium.type(MyAccount.ZIP_TEXTBOX, zip);
		selenium.type(MyAccount.PHONE_TEXTBOX, phone);		
	}
	
	/**
	 * Types personal information in the fields available on My Account Page as Free User.
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param country
	 * @param address
	 * @param apt
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param billingCountry
	 * @param billingAddress
	 * @param billingApt
	 * @param billingCity
	 * @param billingState
	 * @param billingZip
	 */
	public void typePersonalInfoAsCoachUser(String email, String firstName,
			String lastName, String country, String address, String apt,
			String city, String state, String zip, String phone,
			String billingCountry, String billingAddress, String billingApt,
			String billingCity, String billingState, String billingZip) {
		selenium.type(MyAccount.EMAIL_TEXTBOX, email);
		selenium.type(MyAccount.FIRST_NAME_TEXTBOX, firstName);
		selenium.type(MyAccount.LAST_NAME_TEXTBOX, lastName);
		selenium.select(MyAccount.COUNTRY_DROPDOWN, country);
		selenium.type(MyAccount.ADDRESS_TEXTBOX, address);
		selenium.type(MyAccount.APT_SUITE_ETC_TEXTBOX, apt);
		selenium.type(MyAccount.CITY_TEXTBOX, city);
		selenium.select(MyAccount.STATE_DROPDOWN, state);
		selenium.type(MyAccount.ZIP_TEXTBOX, zip);
		selenium.type(MyAccount.PHONE_TEXTBOX, phone);		
		selenium.select(MyAccount.BILLING_COUNTRY, billingCountry);
		selenium.type(MyAccount.BILLING_ADDRESS, billingAddress);
		selenium.type(MyAccount.BILLING_APT_SUITE_ETC, billingApt);
		selenium.type(MyAccount.BILLING_CITY, billingCity);
		selenium.select(MyAccount.BILLING_STATE, billingState);
		selenium.type(MyAccount.BILLING_ZIP, billingZip);
	}	
	
	/**
	 * Clicks on Save Button. 
	 */
	public void clickSaveButton() {
		selenium.click(MyAccount.SAVE_BUTTON);	
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}	
	
	/**
	 * Clicks on Reset Button. 
	 */
	public void clickResetButton(){
		selenium.click(MyAccount.RESET_BUTTON);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * The function getExistingFormData() returns all the existing values shown on the My Account Page of a Club UK User.  
	 * @return map
	 */	
	public Map<String, String> getExistingFormDataAsClubUKUser() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(EMAIL_TEXTBOX, selenium.getValue(EMAIL_TEXTBOX));
		map.put(FIRST_NAME_TEXTBOX, selenium.getValue(FIRST_NAME_TEXTBOX));
		map.put(LAST_NAME_TEXTBOX, selenium.getValue(LAST_NAME_TEXTBOX));
		return map;
	}	
	
	/**
	 * The function getExistingFormData() returns all the existing values shown on the My Account Page of a Free User.  
	 * @return map
	 */	
	public Map<String, String> getExistingFormDataAsFreeUser() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(EMAIL_TEXTBOX, selenium.getValue(EMAIL_TEXTBOX));
		map.put(FIRST_NAME_TEXTBOX, selenium.getValue(FIRST_NAME_TEXTBOX));
		map.put(LAST_NAME_TEXTBOX, selenium.getValue(LAST_NAME_TEXTBOX));
		map.put(COUNTRY_DROPDOWN, selenium.getSelectedLabel(COUNTRY_DROPDOWN));
		map.put(ADDRESS_TEXTBOX, selenium.getValue(ADDRESS_TEXTBOX));
		map.put(APT_SUITE_ETC_TEXTBOX, selenium.getValue(APT_SUITE_ETC_TEXTBOX));
		map.put(CITY_TEXTBOX, selenium.getValue(CITY_TEXTBOX));
		map.put(STATE_DROPDOWN, selenium.getSelectedLabel(STATE_DROPDOWN));
		map.put(ZIP_TEXTBOX, selenium.getValue(ZIP_TEXTBOX));
		map.put(PHONE_TEXTBOX, selenium.getValue(PHONE_TEXTBOX));
		return map;
	}

	/**
	 * The function getExistingFormData() returns all the existing values shown on the My Account Page of a Coach User.  
	 * @return map
	 */	
	public Map<String, String> getExistingFormDataAsCoachUser() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(EMAIL_TEXTBOX, selenium.getValue(EMAIL_TEXTBOX));
		map.put(FIRST_NAME_TEXTBOX, selenium.getValue(FIRST_NAME_TEXTBOX));
		map.put(LAST_NAME_TEXTBOX, selenium.getValue(LAST_NAME_TEXTBOX));
		map.put(COUNTRY_DROPDOWN, selenium.getSelectedLabel(COUNTRY_DROPDOWN));
		map.put(ADDRESS_TEXTBOX, selenium.getValue(ADDRESS_TEXTBOX));
		map.put(APT_SUITE_ETC_TEXTBOX, selenium.getValue(APT_SUITE_ETC_TEXTBOX));
		map.put(CITY_TEXTBOX, selenium.getValue(CITY_TEXTBOX));
		map.put(STATE_DROPDOWN, selenium.getSelectedLabel(STATE_DROPDOWN));
		map.put(ZIP_TEXTBOX, selenium.getValue(ZIP_TEXTBOX));
		map.put(PHONE_TEXTBOX, selenium.getValue(PHONE_TEXTBOX));
		
		map.put(BILLING_COUNTRY, selenium.getSelectedLabel(BILLING_COUNTRY));
		map.put(BILLING_ADDRESS, selenium.getValue(BILLING_ADDRESS));
		map.put(BILLING_APT_SUITE_ETC, selenium.getValue(BILLING_APT_SUITE_ETC));
		map.put(BILLING_CITY, selenium.getValue(BILLING_CITY));
		map.put(BILLING_STATE, selenium.getSelectedLabel(BILLING_STATE));
		map.put(BILLING_ZIP, selenium.getValue(BILLING_ZIP));
		
		return map;
	}

	/**
	 * Clicks on Unlink button on My Account page to unlink from facebook account. 
	 */
	public void clickFacebookUnlink() {
		selenium.click(MyAccount.UNLINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on TBB logo to navigate to Dashboard Page. 
	 * @return
	 */
	public DashboardPage clickTeamBeachbodyImg() {
		selenium.click(Home.TBB_LOGO);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new DashboardPage(selenium);
	}	
}
	
