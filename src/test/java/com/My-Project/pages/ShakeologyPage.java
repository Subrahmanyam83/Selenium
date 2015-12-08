package com.tbb.pages;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.eatsmart.EatSmartPage;

/**
 * 
 * Page Object encapsulates the Shakeology Page
 * @author Jaya
 */
public class ShakeologyPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Shakeology Page.
	 * @param	selenium
	 */
	public ShakeologyPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Shakeology Page");
		this.selenium = selenium;
		assertTrue("This is not Shakeology Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Shakeology® Health Shake"), selenium);
	}
	
	/**
	 * This method clicks on the Eat smart link and navigates user to Eat Smart Page. 
	 * @return Eat Smart Page
	 */
	public EatSmartPage clickEatSmartLink() {
		selenium.click(Dashboard.EAT_SMART_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EatSmartPage(selenium);
	}
}