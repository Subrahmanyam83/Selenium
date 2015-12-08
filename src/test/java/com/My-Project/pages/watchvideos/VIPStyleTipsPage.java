package com.tbb.pages.watchvideos;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 *
 * Page Object encapsulates the Watch Videos - VIP Style Tips Page
 *  @author Jaya
 */
public class VIPStyleTipsPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - VIP Style Tips Page.
	 * @param	selenium
	 */
	public VIPStyleTipsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - VIP Style Tips Page");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - VIP Style Tips Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - VIP Style Tips"), selenium);
	}
	
	/**
	 * Clicks on Watch Videos link at the top menu bar. Navigates user to Watch Videos Page. 
	 * @return Watch Videos Page
	 */
	public WatchVideosPage clickWatchVideosLink() {
		selenium.click(Dashboard.WATCH_VIDEOS_MENU_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WatchVideosPage(selenium);
	}
}