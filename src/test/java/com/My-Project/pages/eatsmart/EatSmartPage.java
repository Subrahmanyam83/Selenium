package com.tbb.pages.eatsmart;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.EatSmart;
import com.tbb.constants.UIRepository.Home;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.connect.ConnectPage;
/**
 * 
 * Page Object encapsulates the Eat Smart Page
 * @author Jaya
 */
public class EatSmartPage  extends BaseTest implements EatSmart {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Eat Smart Page.
	 * @param	selenium
	 */
	public EatSmartPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Eat Smart Page");
		this.selenium = selenium;
		assertTrue("This is not Eat Smart Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart"), selenium);
	}
	
	/**
	 * Returns the number of links on the left hand side menu.
	 * @return int
	 */
	public int getMenuLinksCount() {
		return selenium.getXpathCount(EatSmart.NAV_MENU_ITEMS).intValue();
	}
	
	/**
	 * Returns the text of links on the left hand side menu.
	 * @return String array
	 */
	public String[] getMenuLinksText() {
		int menuItemsCount = getMenuLinksCount();
		String[] menuLinksNames = null;
		if (menuItemsCount > 0) {
			menuLinksNames = new String[menuItemsCount];
			for (int i = 1; i <= menuItemsCount; i++) {
				menuLinksNames[i - 1] = selenium
						.getText(EatSmart.NAV_MENU_ITEMS_TEXT_XPATH + "[" + i + "]/a");
			}
		}
		return menuLinksNames;
	}
	
	/**
	 * Navigates user to My Meal Planner Page by clicking on My Meal Planner link on the left hand side menu.
	 * @return MyMealPlannerPage
	 */
	public MyMealPlannerPage goToMyMealPlannerPage() {
		selenium.click(EatSmart.NAV_MENU_MY_MEAL_PLANNER_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyMealPlannerPage(selenium);
	}
	
	/**
	 * Navigates user to Recipes Page by clicking on Recipes link on the left hand side menu.
	 * @return RecipesPage
	 */
	public RecipesPage goToRecipesPage() {
		selenium.click(EatSmart.NAV_MENU_RECIPES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new RecipesPage(selenium);
	}
	
	/**
	 * Navigates user to Shakeology Recipes Page by clicking on Shakeology Recipes link on the left hand side menu.
	 * @return ShakeologyRecipesPage
	 */
	public ShakeologyRecipesPage goToShakeologyRecipesPage() {
		selenium.click(EatSmart.NAV_MENU_SHAKEOLOGY_RECIPES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShakeologyRecipesPage(selenium);
	}

	/**
	 * Navigates user to Nutrition Tools Page by clicking on Nutrition Tools link on the left hand side menu.
	 * @return NutritionToolsPage
	 */
	public NutritionToolsPage goToNutritionToolsPage() {
		selenium.click(EatSmart.NAV_MENU_NUTRITION_TOOLS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new NutritionToolsPage(selenium);
	}

	/**
	 * Navigates user to Nutrition Tips Page by clicking on Nutrition Tips link on the left hand side menu.
	 * @return NutritionTipsPage
	 */
	public NutritionTipsPage goToNutritionTipsPage() {
		selenium.click(EatSmart.NAV_MENU_NUTRITION_TIPS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new NutritionTipsPage(selenium);
	}

	/**
	 * Navigates user to Shakeology And Supplements Page by clicking on Shakeology And Supplements link on the left hand side menu.
	 * @return ShakeologyAndSupplementsPage
	 */
	public ShakeologyAndSupplementsPage goToShakeologyAndSupplementsPage() {
		selenium.click(EatSmart.NAV_MENU_SHAKEOLOGY_AND_SUPPLEMENTS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShakeologyAndSupplementsPage(selenium);
	}

	/**
	 * Navigates user to Michi's Ladder Page by clicking on Michi's Ladder link on the left hand side menu.
	 * @return MichisLadderPage
	 */
	public MichisLadderPage goToMichisLadderPage() {
		selenium.click(EatSmart.NAV_MENU_MICHI_LADDER_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MichisLadderPage(selenium);
	}
	
	/**
	 * Returns the number of links on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getContentLinksCount() {
		return selenium.getXpathCount(EatSmart.CONTENT_LINK_ITEMS).intValue();
	}
	
	/**
	 * Returns the text of the links on the content displayed in the center of the page. 
	 * @return String array
	 */
	public String[] getContentLinksText() {
		int contentItemsCount = getContentLinksCount();
		String[] contentLinksNames = null;
		if (contentItemsCount > 0) {
			contentLinksNames = new String[contentItemsCount];
			for (int i = 1; i <= contentItemsCount; i++) {
				contentLinksNames[i-1] = selenium
						.getText(EatSmart.CONTENT_LINK_ITEMS + "[" + i
								+ "]/h2");
			}
		}
		return contentLinksNames;
	}

	/**
	 * Navigates user to Dashboard Page. 
	 * @return DashboardPage
	 */
	public DashboardPage clickDashboardLink() {
		selenium.click(EatSmart.DASHBOARD_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new DashboardPage(selenium);
	}

	/**
	 * Clicks on TBB Logo and navigates to TBB Home page
	 * @return
	 */
	public HomePage clickTBBLogo() {
		selenium.click(Home.TBB_LOGO);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HomePage(selenium);
	}

	/**
	 * Returns title of RRMs
	 */
	public ArrayList getRRMsTitles() {
		ArrayList<String> rrmTitles = new ArrayList();
		int rrmsCount = getRRMsCount();
		for (int i =1; i<=rrmsCount; i++) {
			rrmTitles.add(selenium.getText(EatSmart.EATSMART_PROGRAM_RRM_SECTION + "[" + i + "]" + EatSmart.EATSMART_PROGRAM_RRM_TITLE));
		}
		return rrmTitles;
	}
	
	/**
	 * Returns number of RRMs
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(EatSmart.EATSMART_PROGRAM_RRM_SECTION).intValue();
	}

	/**
	 * Navigate to Connect Link. 
	 * @return ConnectPage
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ConnectPage(selenium);
	}
}