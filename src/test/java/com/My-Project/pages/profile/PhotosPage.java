package com.tbb.pages.profile;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.constants.UIRepository.PhotosTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Photos Page
 * @author Xebia
 */
public class PhotosPage  extends BaseTest  implements PhotosTab {

	
	/**
	 * This is constructor for this class. It validates that the user is on Photos Page.
	 * @param	selenium
	 */
	public PhotosPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Photos Page");
		this.selenium = selenium;
		assertTrue("This is not Photos Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Edit Profile: Photos"), selenium);
	}

	/**
	 * Clicks on Terms of use link.
	 */
	public void clickTermsOfUseLink() {
		selenium.click(TERMS_OF_USE_LINK);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * Clicks on close link for Terms of Use. 
	 */
	public void closeTermsOfUseLink() {
		selenium.click("css=a[href='javascript:_USER_PROFILE_PHOTOS_WAR_userprofileportlet_hideTermsOfUse()']");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * Returns the number of Photos displayed on the Edit Photos Page. 
	 * @return int
	 */
	public int getPhotosCount() {
		return selenium.getXpathCount(PHOTOS).intValue();
	}

	/**
	 * Returns the number of Browse Photo displayed on the Edit Photos Page. 
	 * @return int
	 */
	public int getBrowseTextboxCount() {
		return selenium.getXpathCount(BROWSE).intValue();
	}

	/**
	 * Returns the number of Update Photo buttons displayed on the Edit Photos Page. 
	 * @return int
	 */
	public int getUpdatePhotoCount() {
		return selenium.getXpathCount(UPDATE_PHOTOS).intValue();
	}

	/**
	 * Returns the number of month drop downs displayed on the Edit Photos Page. 
	 * @return int
	 */
	public int getMonthDropdownCount() {
		return selenium.getXpathCount(MONTH_DROPDOWN).intValue();
	}

	/**
	 * Returns the number of day drop downs displayed on the Edit Photos Page. 
	 * @return int
	 */
	public int getDayDropdownCount() {
		return selenium.getXpathCount(DAY_DROPDOWN).intValue();
	}

	/**
	 * Returns the number of year drop downs displayed on the Edit Photos Page. 
	 * @return int
	 */
	public int getYearDropdownCount() {
		return selenium.getXpathCount(YEAR_DROPDOWN).intValue();
	}

	/**
	 * Returns the number of calender icons displayed on the Edit Photos Page. 
	 * @return int
	 */
	public int getCalenderIconCount() {
		return selenium.getXpathCount(CALENDAR_ICON).intValue();
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
}