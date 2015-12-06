package com.tbb.pages.about;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.AboutJoinUpgrade;
import com.tbb.constants.UIRepository.AboutProducts;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.eatsmart.ShakeologyAndSupplementsPage;
import com.tbb.pages.getfit.FitnessProgramsPage;

/**
 * 
 * Page Object encapsulates the Products Page
 * @author Jaya
 */

public class ProductsPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Products Page.
	 * @param	selenium
	 */
	public ProductsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Products Page");
		this.selenium = selenium;
		assertTrue("This is not Products Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - About: Products"), selenium);
	}
	
	/**
	 * Clicks on Find your ideal Fitness Programs Now link
	 * @return Fitness Programs Page
	 */
	public FitnessProgramsPage clickFindYourIdealFitnessProgramNowLink() {
		selenium.click(AboutProducts.FIND_YOUR_IDEAL_FITNESS_PROGRAM_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new FitnessProgramsPage(selenium);
	}

	/**
	 * Clicks on Find a Supplement Now link
	 * @return Shakeology And Supplements Page
	 */
	public ShakeologyAndSupplementsPage clickFindaSupplementNowLink() {
		selenium.click(AboutProducts.FIND_A_SUPPLEMENT_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShakeologyAndSupplementsPage(selenium);		
	}

	/**
	 * Returns the number of rows of products boxes displayed on the page. 
	 * @return int
	 */
	public int getAllProductsCount() {
		return selenium.getXpathCount(AboutProducts.ALL_PRODUCTS).intValue();
	}

	/**
	 * Clicks on About link in the top menu bar. Navigates to About Page. 
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click(AboutJoinUpgrade.MENU_BAR_ABOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}
}