package com.tbb.pages.profile;



import java.util.HashMap;
import java.util.Map;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.BasicInformationTab;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
/**
 * 
 * Page Object encapsulates the Basic Information Page
 * @author Jaya
 */
public class BasicInformationPage   extends BaseTest implements BasicInformationTab  {

	/**
	 * This is constructor for this class. It validates that the user is on Basic Information Page.
	 * @param	selenium
	 * @throws  IllegalStateException if the user is on a different page than Basic Information Page.
	 */
	public BasicInformationPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Basic Information Class");
		assertTrue("This is not Edit Profile: Basic Information Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Edit Profile: Basic Information"), selenium);
	}	

	/**
	 * The method viewscreenNameHelp can be used to view help for Screen Name 
	 * @return BasicInformationPage
	 */	
	public BasicInformationPage viewscreenNameHelp(){
		selenium.click(SCREEN_NAME_HELP);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		selenium.getText(SCREEN_NAME_HELP_WINDOW).contains("Choose the screen name you'd like to use to identify yourself throughout Team Beachbody, including the Message Boards (15 characters maximum). Your screen name will be part of the URL extension of your profile (i.e. teambeachbody.com/screenname or beacbhodycoach.com/screenname), so be sure it represents the image you'd like to present to people.");
		selenium.click(SCREEN_NAME_HELP_WINDOW_CLOSE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		return new BasicInformationPage(selenium);		
	}

	/**
	 * The method checkScreenNameAvailability can be used to check if screen name entered is available.
	 * @param	screenName 
	 * @return 	boolean 	It returns true if Screen Name is available, otherwise false
	 */	
	public boolean checkScreenNameAvailability(String screenName) {
		selenium.type(SCREEN_NAME_TEXTBOX, screenName);
		selenium.click(CHECK_AVAILABILITY_BUTTON);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
			e.printStackTrace();
	}
		selenium.getText(AVAILABILITY_LABEL);
		if(selenium.getText(AVAILABILITY_LABEL).contains("Available"))
			return true;
		else 
			return false;
	}

	/**
	 * This method viewbirthdayHelp can be used to view help for Birthday 
	 * @return	BasicInformationPage
	 */	
	public BasicInformationPage viewbirthdayHelp(){
		selenium.click(BIRTHDAY_HELP);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		selenium.getText(BIRTHDAY_HELP_WINDOW).contains("You must be at least 18 years of age or older to participate in the Million Dollar Body Game.");
		selenium.click(BIRTHDAY_HELP_WINDOW_CLOSE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		return new BasicInformationPage(selenium);		
	}

	/**
	 * This function selectDateUsingDropDowns allows user to select Birthday Date using drop downs.
	 * @param month
	 * @param day
	 * @param year
	 */	
	public void selectDateUsingDropDowns(String month, String day, String year) {
		selenium.select(BIRTHDAY_MONTH, month);
		selenium.select(BIRTHDAY_DAY, day);
		selenium.select(BIRTHDAY_YEAR, year);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function selectDateUsingCalendar allows user to select date using Calendar on Basic Information Page
	 * @param month
	 * @param day
	 * @param year
	 */	
	public void selectDateUsingCalendar(String month, String day, String year){
		selenium.click(CALENDAR_ICON);
		selenium.waitForCondition(CALENDAR, "2000"); 
		selenium.select(CALENDAR_YEAR_DROPDOWN, year);
		selenium.select(CALENDAR_MONTH_DROPDOWN, month);
		selenium.select(CALENDAR_DAYS, day);
	}

	/**
	 * This function selectGender() allows user to select Gender on Basic Information Page
	 * @param gender
	 */	
	public void selectGender(String gender){
		if(gender.equals("female"))
			selenium.click(FEMALE_RADIO_BUTTON);
		else
			selenium.click(MALE_RADIO_BUTTON);
	}

	/**
	 * This function selectTimeZone() allows user to select Time-Zone on Basic Information Page
	 * @param timezone
	 */	
	public void selectTimeZone(String timezone) {
		selenium.select(TIMEZONE, timezone);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function typeBio() allows user to type bio on Basic Information Page
	 * @param bio
	 */	
	public void typeBio(String bio){
		selenium.type(BIO, bio);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function saveBasicInformation() allows user to save changes on Basic Information Page
	 * @return BasicInformationPage
	 */	
	public BasicInformationPage saveBasicInformation(){
		selenium.click(SAVE_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new BasicInformationPage(selenium);
	}

	/**
	 * The function resetBasicInformation() resets the values of Edit Profile fields on Basic Information Page
	 * @return BasicInformationPage
	 */	
	public BasicInformationPage resetBasicInformation(){
		selenium.click(RESET_BUTTON);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new BasicInformationPage(selenium);
	}

	/**
	 * The function getExistingFormData() returns all the existing values shown on the Basic Information Page.  
	 * @return map
	 */	
	public Map<String, String> getExistingFormData() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(SCREEN_NAME_TEXTBOX, selenium.getValue(SCREEN_NAME_TEXTBOX));
		map.put(BIRTHDAY_MONTH, selenium.getSelectedLabel(BIRTHDAY_MONTH));
		map.put(BIRTHDAY_DAY, selenium.getSelectedValue(BIRTHDAY_DAY));
		map.put(BIRTHDAY_YEAR, selenium.getSelectedValue(BIRTHDAY_YEAR));
		map.put(FEMALE_RADIO_BUTTON, new Boolean(selenium.isChecked(FEMALE_RADIO_BUTTON)).toString());
		map.put(MALE_RADIO_BUTTON, new Boolean(selenium.isChecked(MALE_RADIO_BUTTON)).toString());
		map.put(TIMEZONE, selenium.getSelectedLabel(TIMEZONE));
		map.put(BIO, selenium.getValue(BIO));
		return map;
	}

	/**
	 * The function signOut() allows user to sign out of the web site.  
	 * @return HomePage
	 */	
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);
	}
	
	/**
	 * Navigates user to Edit Profile Page
	 * @return	EditProfilePage
	 */	
	public EditProfilePage clickLRMProfileLink() {
		selenium.click(LRMProfile.LRM_PROFILE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EditProfilePage(selenium);
	}

	/**
	 * Navigates user to Groups Page
	 * @return	GroupsPage
	 */	
	public GroupsPage clickLRMGroupsLink(){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selenium.click(LRMProfile.LRM_GROUPS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new GroupsPage(selenium);
	}
}


