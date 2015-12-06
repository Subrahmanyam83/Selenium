package com.tbb.pages.watchvideos;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.WatchVideosVIPWorkouts;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Watch Videos - VIP Workouts Page
 * @author Jaya
 */
public class VIPWorkoutsPage  extends BaseTest  {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - VIP Workouts Page.
	 * @param	selenium
	 */
	public VIPWorkoutsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - VIP Workouts Page");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - VIP Workouts Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - VIP Workouts"), selenium);
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
		selenium.click(WatchVideosVIPWorkouts.TONY_HORTON_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Navigates user to Chalene Johnson Page. 
	 */
	public void goToChaleneJohnson() {
		selenium.click(WatchVideosVIPWorkouts.CHALENE_JOHNSON_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Shaun T Page. 
	 */
	public void goToShaunT() {
		selenium.click(WatchVideosVIPWorkouts.SHAUN_T_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Debbie Siebers Page. 
	 */
	public void goToDebbieSiebers() {
		selenium.click(WatchVideosVIPWorkouts.DEBBIE_SIEBERS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Gillian And Teigh Page. 
	 */
	public void goToGillianAndTeigh() {
		selenium.click(WatchVideosVIPWorkouts.GILLIAN_AND_TEIGH_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Leandro Carvalho Page. 
	 */
	public void goToLeandroCarvalho() {
		selenium.click(WatchVideosVIPWorkouts.LEANDRO_CARVALHO_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Brett Hoebel Page. 
	 */
	public void goToBrettHoebel() {
		selenium.click(WatchVideosVIPWorkouts.BRETT_HOEBEL_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Super Workouts Page. 
	 */
	public void goToSuperWorkouts() {
		selenium.click(WatchVideosVIPWorkouts.SUPER_WORKOUTS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
}