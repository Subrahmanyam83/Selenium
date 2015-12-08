package com.tbb.pages.watchvideos;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.WatchVideosCelebrityTrainers;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Watch Videos - Celebrity Trainers Page.
 * @author Jaya
 */
public class CelebrityTrainersPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - Celebrity Trainers Page.
	 * @param	selenium
	 */
	public CelebrityTrainersPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - Celebrity Trainers Page.");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - Celebrity Trainers Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Celebrity Trainers"), selenium);
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
	 * Navigates user to Tony Horton Page.
	 */
	public void goToTonyHorton() {
		selenium.click(WatchVideosCelebrityTrainers.TONY_HORTON_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Chalene Johnson Page.
	 */
	public void goToChaleneJohnson() {
		selenium.click(WatchVideosCelebrityTrainers.CHALENE_JOHNSON_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Shaun T Page.
	 */
	public void goToShaunT() {
		selenium.click(WatchVideosCelebrityTrainers.SHAUN_T_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Debbie Siebers Page.
	 */
	public void goToDebbieSiebers() {
		selenium.click(WatchVideosCelebrityTrainers.DEBBIE_SIEBERS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
}