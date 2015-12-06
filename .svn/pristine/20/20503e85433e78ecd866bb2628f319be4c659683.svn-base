package com.tbb.pages.watchvideos;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.WatchVideosVIPFitnessTips;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 *
 * Page Object encapsulates the Watch Videos - VIP Fitness Tips Page
 *  @author Jaya
 */
public class VIPFitnessTipsPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - VIP Fitness Tips Page.
	 * @param	selenium
	 */
	public VIPFitnessTipsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - VIP Fitness Tips Page");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - VIP Fitness Tips Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - VIP Fitness Tips"), selenium);
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
		selenium.click(WatchVideosVIPFitnessTips.TONY_HORTON_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Navigates user to Chalene Johnson Page. 
	 */
	public void goToChaleneJohnson() {
		selenium.click(WatchVideosVIPFitnessTips.CHALENE_JOHNSON_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Shaun T Page. 
	 */
	public void goToShaunT() {
		selenium.click(WatchVideosVIPFitnessTips.SHAUN_T_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Debbie Siebers Page. 
	 */
	public void goToDebbieSiebers() {
		selenium.click(WatchVideosVIPFitnessTips.DEBBIE_SIEBERS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Gillian & Teigh Page.
	 */
	public void goToGillianAndTeigh() {
		selenium.click(WatchVideosVIPFitnessTips.GILLIAN_AND_TEIGH_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Leandro Carvalho Page. 
	 */
	public void goToLeandroCarvalho() {
		selenium.click(WatchVideosVIPFitnessTips.LEANDRO_CARVALHO_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Brett Hoebel Page. 
	 */
	public void goToBrettHoebel() {
		selenium.click(WatchVideosVIPFitnessTips.BRETT_HOEBEL_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Super Workouts Page. 
	 */
	public void goToSuperWorkouts() {
		selenium.click(WatchVideosVIPFitnessTips.SUPER_WORKOUTS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}
}