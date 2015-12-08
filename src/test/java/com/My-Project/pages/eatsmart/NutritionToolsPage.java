package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.NutritionToolsTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Nutrition Tools Page
 * @author Jaya
 */
public class NutritionToolsPage  extends BaseTest implements NutritionToolsTab {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Nutrition Tools Page.
	 * @param	selenium
	 */
	public NutritionToolsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Nutrition Tools Page");
		this.selenium = selenium;
		assertTrue("This is not Nutrition Tools Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart: Nutrition Tools"), selenium);
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
	 * Navigate to Body Fat Page.
	 * @return BodyFatPage
	 */
	public BodyFatCalculatorPage clickBodyFatButton() {
        selenium.click(BODY_FAT_BUTTON);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new BodyFatCalculatorPage(selenium);
	}
	
	/**
	 * Navigate to Healthy Weight Page.
	 * @return HealthyWeightPage
	 */
	public HealthyWeightPage clickHealthyWeightButton() {
        selenium.click(HEALTHY_WEIGHT_BUTTON);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new HealthyWeightPage(selenium);
	}
	
	/**
	 * Navigate to Caloric Needs Page.
	 * @return CaloricNeedsPage
	 */
	public CaloricNeedsPage clickCaloricNeedsButton() {
        selenium.click(CALORIC_NEEDS_BUTTON);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new CaloricNeedsPage(selenium);
	}
	
	/**
	 * Clicks on Body Fat Image. Navigates user to Body Fat Calculator Page. 
	 * @return BodyFatCalculatorPage
	 */
	public BodyFatCalculatorPage clickBodyFatImage() {
		selenium.click(BODY_FAT_TOOL_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new BodyFatCalculatorPage(selenium);		
	}
	
	/**
	 * Clicks on Healthy weight image. Navigates user to Healthy weight page. 
	 * @return HealthyWeightPage
	 */
	public HealthyWeightPage clickHealthyWeightImage() {
		selenium.click(HEALTHY_WEIGHT_TOOL_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HealthyWeightPage(selenium);
	}
	
	/**
	 * Clicks on Caloric Needs Image. Navigates user to Caloric Needs Page. 
	 * @return CaloricNeedsPage
	 */
	public CaloricNeedsPage clickCaloricNeedsImage() {
		selenium.click(CALORIC_NEEDS_TOOL_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CaloricNeedsPage(selenium);
	}
}