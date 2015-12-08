package com.tbb.pages.watchvideos;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.WatchVideosCoaches;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Watch Videos - Coaches Page.
 * @author Jaya
 */
public class CoachesPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - Coaches Page.
	 * @param	selenium
	 */
	public CoachesPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - Coaches Page.");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - Coaches Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Coaches"), selenium);
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

	/**
	 * Navigates user to Events Page. 
	 */
	public void goToEvents() {
		selenium.click(WatchVideosCoaches.EVENTS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Navigates user to Personal Stories Page. 
	 */
	public void goToPersonalStories() {
		selenium.click(WatchVideosCoaches.PERSONAL_STORIES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Giving Back Page. 
	 */
	public void goToGivingBack() {
		selenium.click(WatchVideosCoaches.GIVING_BACK_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
}