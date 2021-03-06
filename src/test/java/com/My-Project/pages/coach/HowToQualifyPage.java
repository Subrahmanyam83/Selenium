package com.tbb.pages.coach;
import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the How To Qualify Page.
 * @author Gaurav
 */

public class HowToQualifyPage  extends BaseTest {
	
	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on How to Qualify Page.
	 * @param	selenium
	 */
	public HowToQualifyPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of How to Qualify Page");
		this.selenium = selenium;
		assertTrue("This is not How to Qualify Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("How To Qualify - Coach Destinations"), selenium);
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
