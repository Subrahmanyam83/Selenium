package com.tbb.pages.eatsmart;

import com.tbb.constants.UIRepository.Chocolate;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Chocolate Page in Shakeology Recipes Page 
 * @author Jaya
 */
public class ShakeologyRecipesChocolatePage extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Shakeology Recipes - Chocolate Page.
	 * @param	selenium
	 */
	public ShakeologyRecipesChocolatePage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Shakeology Recipes - Chocolate Page");
		this.selenium = selenium;
		assertTrue("This is not Shakeology Recipes - Chocolate Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Chocolate"), selenium);
	}
	
	/**
	 * Returns the number of calorie links Eg: Less than 200 Calories displayed on the page.
	 * @return int
	 */
	public int getCalorieLinksCount() {
		return selenium.getXpathCount(Chocolate.CALORIE_LINKS).intValue();
	}

	/**
	 * Returns the number of rows of Chocolate shakes displayed on the page.
	 * @return int
	 */
	public int getChocolateShakesRowCount() {
		return selenium.getXpathCount(Chocolate.CHOCOLATE_TABLE_ROWS).intValue();
	}
}