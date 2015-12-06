package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Greenberry;
import com.tbb.constants.UIRepository.ShakeologyRecipesTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Greenberry Page in Shakeology Recipes Page 
 * @author Jaya
 */
public class ShakeologyRecipesGreenberryPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Shakeology Recipes - Greenberry Page.
	 * @param	selenium
	 */
	public ShakeologyRecipesGreenberryPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Shakeology Recipes - Greenberry Page");
		this.selenium = selenium;
		assertTrue("This is not Shakeology Recipes - Greenberry Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Greenberry"), selenium);
	}
	
	/**
	 * Navigate to Shakeology Recipe - Chocolate Page
	 * @return Chocolate Page
	 */
	public ShakeologyRecipesChocolatePage goToChocolatePage() {
		selenium.click(ShakeologyRecipesTab.NAV_MENU_CHOCOLATE_RECIPES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShakeologyRecipesChocolatePage(selenium); 
	}

	/**
	 * Navigate to Shakeology Recipes Page
	 * @return Shakeology Recipes Page
	 */
	public ShakeologyRecipesPage goToShakeologyRecipesPage() {
		selenium.click(ShakeologyRecipesTab.NAV_MENU_SHAKEOLOGY_RECIPES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShakeologyRecipesPage(selenium); 
	}

	/**
	 * Returns the number of calorie links Eg: Less than 200 Calories displayed on the page.
	 * @return int
	 */
	public int getCalorieLinksCount() {
		return selenium.getXpathCount(Greenberry.CALORIE_LINKS).intValue();
	}

	/**
	 * Returns the number of rows of shakes ingredient rows displayed on the page.
	 * @return int
	 */
	public int getGreenberryShakesRowCount() {
		return selenium.getXpathCount(Greenberry.SHAKEOLOGY_TABLE_ROWS).intValue();
	}
}