package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 *
 * Page Object encapsulates the Meal Plans Page
 *  @author Jaya
 */
public class MealPlansPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Meal Plans Page.
	 * @param	selenium
	 */
	public MealPlansPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Meal Plans Page");
		this.selenium = selenium;

		assertTrue("This is not Meal Plans Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Meal Plans"), selenium);
	}
	
	/**
	 * Navigates user to Eat Smart Page. 
	 * @return EatSmartPage
	 */
	public EatSmartPage clickEatSmartLink() {
		selenium.goBack();
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.click(Dashboard.EAT_SMART_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EatSmartPage(selenium);		
	}
}