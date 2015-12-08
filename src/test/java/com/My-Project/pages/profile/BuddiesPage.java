package com.tbb.pages.profile;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Buddies;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.constants.UIRepository.MemberProfile;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.MemberProfilePage;
import com.tbb.pages.connect.MemberGallerySearchResultsPage;
/**
 * 
 * Page Object encapsulates the Buddies Page
 * @author Jaya
 */
public class BuddiesPage  extends BaseTest  implements Buddies {

	/**
	 * This is constructor for this class. It validates that the user is on
	 * Buddies Page.
	 * 
	 * @param selenium
	 */
	public BuddiesPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Buddies Page");
		this.selenium = selenium;
		assertTrue("This is not Buddies Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Edit Profile: Buddies"), selenium);
	}

	/**
	 * Search Members on TeamBeachBody web site
	 * 
	 * @param searchKeyword
	 * @return MemberGalleryPage
	 */
	public MemberGallerySearchResultsPage searchMembers(String searchKeyword) {
		selenium.type(SEARCH_MEMBERS_TEXTBOX, searchKeyword);
		selenium.click(SEARCH_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MemberGallerySearchResultsPage(selenium);
	}

	/**
	 * Navigates user to profile of the given buddy name
	 * 
	 * @param buddyName
	 * @return MemberProfilePage
	 */
	public MemberProfilePage viewBuddyProfile(String buddyName) {
		selenium.click("css=a.small:contains(" + buddyName + ")");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MemberProfilePage(selenium);
	}

	/**
	 * Remove Selected list of Buddies.
	 */
	public void removeSelectedBuddies() {
		selenium.click(REMOVE_SELECTED_BUDDIES_BUTTON);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click(YES_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	public void searchMyBuddies(String buddyName) {
		selenium.type(SEARCH_MY_BUDDIES_TEXTBOX, buddyName);
		selenium.click(SEARCH_MY_BUDDIES_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * The function signOut() allows user to sign out of the web site.
	 * 
	 * @return HomePage
	 */
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);
	}

	/**
	 * Navigates to Dashboard Link
	 * @return
	 */
	public DashboardPage clickDashboardLink() {
		selenium.click(MemberProfile.DASHBOARD_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new DashboardPage(selenium);

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