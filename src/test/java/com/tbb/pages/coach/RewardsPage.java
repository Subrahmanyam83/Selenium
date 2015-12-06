package com.tbb.pages.coach;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 *
 * Page Object encapsulates the Rewards Page.
 *  @author Gaurav
 */

public class RewardsPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Rewards Page.
	 * @param	selenium
	 */
	public RewardsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Rewards Page");
		this.selenium = selenium;
		assertTrue("This is not Rewards Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Rewards - Coach Destinations"), selenium);
	}
	
	/**
	 * Navigates to 'Home' page 
	 */
	public CoachDestinationsPage clickHomeLink() {
		selenium.click(Dashboard.HOME_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CoachDestinationsPage(selenium);
	}

}
