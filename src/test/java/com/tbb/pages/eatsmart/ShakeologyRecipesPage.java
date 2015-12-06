package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.ShakeologyRecipesTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Shakeology Recipes Page
 * @author Jaya
 */
public class ShakeologyRecipesPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Shakeology Recipes Page.
	 * @param	selenium
	 */
	public ShakeologyRecipesPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Shakeology Recipes Page");
		this.selenium = selenium;
		assertTrue("This is not Shakeology Recipes Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Shakeology Recipes"), selenium);
	}
	/**
	 * Navigate to Eat Smart Link.
	 * @return EatSmartPage
	 */
	public EatSmartPage clickEatSmartLink() {
        selenium.click(ShakeologyRecipesTab.EAT_SMART_MENU_LINK);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new EatSmartPage(selenium);
	}
	
	/**
	 * Navigate to Shakeology Recipes - Greenberry Page. 
	 * @return Greenberry Page 
	 */
	public ShakeologyRecipesGreenberryPage goToGreenberryPage() {
		selenium.click(ShakeologyRecipesTab.NAV_MENU_GREENBERRY_RECIPES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShakeologyRecipesGreenberryPage(selenium);
	}
	
	/**
	 * Navigate to Greenberry Recipes Page. 
	 * @return Greenberry Recipes Page
	 */
	public ShakeologyRecipesGreenberryPage clickGreenberryRecipesButton() {
		selenium.click(ShakeologyRecipesTab.GREENBERRY_RECIPES_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShakeologyRecipesGreenberryPage(selenium);
	}
	
	/**
	 * Navigate to Chocolate Recipes Page. 
	 * @return Chocolate Recipes Page
	 */
	public ShakeologyRecipesChocolatePage clickChocolateReciesButton() {
		selenium.click(ShakeologyRecipesTab.CHOCOLATE_RECIPES_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShakeologyRecipesChocolatePage(selenium);
		
	}
}