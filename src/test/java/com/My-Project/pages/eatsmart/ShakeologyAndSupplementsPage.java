package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.SupplementsTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.ShakeologyPage;
import com.tbb.pages.shop.ShoppingCartPage;
/**
 * 
 * Page Object encapsulates the Shakeology And Supplements Page
 * @author Jaya
 */
public class ShakeologyAndSupplementsPage  extends BaseTest implements SupplementsTab{

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Shakeology And Supplements Page.
	 * @param	selenium
	 */
	public ShakeologyAndSupplementsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Shakeology And Supplements Page");
		this.selenium = selenium;
		assertTrue("This is not Shakeology And Supplements Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart: Supplements"), selenium);
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
	 * Returns the number of Supplement choice boxes displayed on the Supplements Page.
	 * @return int
	 */
	public int getContentBoxesCount() {
		return selenium.getXpathCount(SUPPLEMENT_CHOICE_BOXES).intValue();
	}

	/**
	 * Returns the number of Learn More links displayed on the Supplements Page.
	 * @return int
	 */
	public int getLearnMoreLinksCount() {
		return selenium.getXpathCount(LEARN_MORE_LINKS).intValue();
	}

	/**
	 * Clicks on 'Learn More' link for Shakeology. Navigates user to Shakeology Page. 
	 * @return ShakeologyPage
	 */
	public ShakeologyPage clickShakeologyLearnMoreLink() {
		selenium.click(SHAKEOLOGY_LEARN_MORE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShakeologyPage(selenium);
	}

	/**
	 * Clicks on Slimming Formula Learn More Link. Navigates user to Shopping Cart Page. 
	 * @return
	 */
	public ShoppingCartPage clickSlimmingFormulaLearnMoreLink() {
		selenium.click(SLIMMING_FORMULA_LEARN_MORE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShoppingCartPage(selenium);
	}

	/**
	 * Clicks on 'Learn More' link for 'P90X Peak Performance Protein Bars'. Navigates user to Shopping Cart Page. 
	 * @return ShoppingCartPage
	 */
	public ShoppingCartPage clickP90XPeakPerformanceProteinBarsLearnMoreLink() {
		selenium.click(P90X_PEAK_PERFORMANCE_PROTEIN_BARS_LEARN_MORE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShoppingCartPage(selenium);
	}

	/**
	 * Clicks on Sign out link to sign out of the website. 
	 */
	public void clickSignOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);		
	}

	/**
	 * Returns the number of stars displayed in bazaar voice of Shakeology.
	 * @return int
	 */
	public int getStarsCount() {
		return selenium.getXpathCount(SupplementsTab.STAR_IMAGE_XPATH).intValue();
	}
	
	/**
	 * Returns the number of reviews displayed in bazaar voice of Shakeology.
	 * @return int
	 */
	public int getReviewCount() {
		return selenium.getXpathCount(SupplementsTab.REVIEW_XPATH).intValue();
	}
}
