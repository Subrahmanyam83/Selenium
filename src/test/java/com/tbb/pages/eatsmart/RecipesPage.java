package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.RecipesTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Recipes Page
 * @author Jaya
 */
public class RecipesPage  extends BaseTest implements RecipesTab{

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Recipes Page.
	 * @param	selenium
	 */
	public RecipesPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Recipes Page");
		this.selenium = selenium;

		assertTrue("This is not Recipes Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart: Recipes"), selenium);
	}
	
	/**
	 * Searches the corresponding recipe for a given search keyword.
	 * @param	recipeKeyword
	 */
	public void searchRecipe(String recipeKeyword) {
		selenium.type(SEARCH_TEXT_BOX, recipeKeyword);	
		selenium.click(SEARCH_ICON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
	
	/**
	 * Clicks on the recipe link containing the search keyword to navigate to the corresponding recipe.
	 * @param	recipeKeyword
	 */
	public void viewRecipe(String recipeKeyword){
		selenium.click("css=span:contains("+recipeKeyword+")");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
	/**
	 * Navigate to Eat Smart Link
	 * @return EatSmartPage
	 */
	public EatSmartPage clickEatSmartLink() {
        selenium.click(Dashboard.EAT_SMART_MENU_LINK);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new EatSmartPage(selenium);
	}
}