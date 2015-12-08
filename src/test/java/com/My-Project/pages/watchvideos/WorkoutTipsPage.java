package com.tbb.pages.watchvideos;

import com.tbb.constants.TestConsts;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Watch Videos - Work out Tips Page.
 * @author Jaya
 */
public class WorkoutTipsPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - Work out Tips Page.
	 * @param	selenium
	 */
	public WorkoutTipsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - Work out Tips Page.");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - Work out Tips Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Workout Tips"), selenium);
	}
	
	/**
	 * Clicks on Watch Videos link at the top menu bar. Navigates user to Watch Videos Page. 
	 * @return Watch Videos Page
	 */
	public WatchVideosPage clickWatchVideosLink() {
		selenium.click("css=a:contains(Watch Videos)");	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WatchVideosPage(selenium);
	}
}