package com.tbb.pages;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.MemberProfile;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 *
 * Page Object encapsulates the Member Profile Page
 *  @author Jaya
 */
public class MemberProfilePage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Member Profile Page.
	 * @param	selenium
	 */
	public MemberProfilePage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Member Profile Page");
		this.selenium = selenium;
		assertTrue("This is not Member Profile Page, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Member Profile"), selenium);
	}
	
	/**
	 * Removes the buddy from your buddy list
	 */	
	public void removeBuddy(){	
		selenium.click(MemberProfile.REMOVE_BUDDY);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * The function signOut() allows user to sign out of the web site.  
	 * @return Home Page
	 */	
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);
	}

	/**
	 * The function clicks on the Dashboard link on the Member Profile Page. Navigates user to Dashboard Page. 
	 * @return Dashboard Page
	 */
	public DashboardPage clickDashboardLink() {
		selenium.click(MemberProfile.DASHBOARD_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new DashboardPage(selenium);		
	}
}
	
