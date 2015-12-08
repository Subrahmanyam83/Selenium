package com.tbb.pages.watchvideos;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.WatchVideosTeamBeachbody;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Watch Videos - TeamBeachbody Page.
 * @author Jaya
 */
public class TeamBeachbodyPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - TeamBeachbody Page.
	 * @param	selenium
	 */
	public TeamBeachbodyPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - TeamBeachbody Page.");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - TeamBeachbody Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Team Beachbody"), selenium);
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
	 * Navigates user to News Page. 
	 */
	public void goToNews() {
		selenium.click(WatchVideosTeamBeachbody.NEWS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Navigates user to Giving Back Page. 
	 */
	public void goToGivingBack() {
		selenium.click(WatchVideosTeamBeachbody.GIVING_BACK_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Navigates user to Inside TBB Page. 
	 */
	public void goToInsideTBB() {
		selenium.click(WatchVideosTeamBeachbody.INSIDE_TBB_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}
}