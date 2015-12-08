package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.NutritionTipsTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Nutrition Tips Page
 * @author Jaya
 */
public class NutritionTipsPage  extends BaseTest implements NutritionTipsTab {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Nutrition Tips Page.
	 * @param	selenium
	 */
	public NutritionTipsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Nutrition Tips Page");
		this.selenium = selenium;
		assertTrue("This is not Nutrition Tips Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart: Nutrition Tips"), selenium);
	}
	/**
	 * Navigate to Eat Smart Link.
	 * @return EatSmartPage
	 */
	public EatSmartPage clickEatSmartLink() {
		selenium.click(Dashboard.EAT_SMART_MENU_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EatSmartPage(selenium);
	}
	
	/**
	 * Types search keyword in Nutrition Tip search text box. 
	 * @param tipKeyword
	 */
	public void typeSearchKeyword(String tipKeyword) {
		selenium.type(TIP_SEARCH_TEXTBOX, tipKeyword);		
	}
	
	/**
	 * Clicks on Tip Search Icon as club user. 
	 */
	public void clickSearchAsClubUser() {
		selenium.click(TIP_SEARCH_ICON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}
	
	/**
	 * Clicks on Tip Search Icon as Free user. Navigates user to Club only Page. 
	 */
	public void clickSearchAsFreeUser() {
		selenium.click(TIP_SEARCH_ICON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}
	
	/**
	 * Clicks on Tip name from the search results to allow the user to view the tip. 
	 * @param tipKeyword
	 */
	public void clickTipName(String tipKeyword) {
		selenium.click("css=span:contains("+tipKeyword+")");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}
}