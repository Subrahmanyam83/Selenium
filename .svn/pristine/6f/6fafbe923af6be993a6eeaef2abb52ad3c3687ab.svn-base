package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.Notifications;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
import com.tbb.pages.profile.MyProfilePage;
//import static com.tbb.framework.BaseTest.assertTrue;
/**
 *
 * Page Object encapsulates the Notifications Page
 *  @author Jaya
 */
public class NotificationsPage  extends BaseTest {

	protected LoggingSelenium selenium;

	/**
	 * This is constructor for this class. It validates that the user is on Notifications Page.
	 * @param	selenium
	 */
	public NotificationsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Notifications Page");
		assertTrue("This is not Notifications Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Notifications"), selenium);
	}

	/**
	 * Accepts Buddy Request 
	 */	
	public void acceptBuddyRequest(){
		selenium.click(Notifications.ACCEPT_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * The function signOut() allows user to sign out of the web site.  
	 */	
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent("css=a:contains(Sign In)");
		return new HomePage(selenium);
	}
	
	/**
	 * Clicks on My Profile in the left menu. Navigates user to My Profile Page.
	 * @return My Profile Page
	 */
	public MyProfilePage clickProfileLink() {
		selenium.click(Notifications.NAV_MENU_MY_PROFILE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyProfilePage(selenium);
	}
}