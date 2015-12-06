package com.tbb.pages.about;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.About;
import com.tbb.constants.UIRepository.Home;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;

//import static com.tbb.framework.BaseTest.assertTrue;

/**
 * 
 * Page Object encapsulates the About Page.
 * @author Jaya
 */

public class AboutPage extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on About Page.
	 * @param	selenium
	 */
	public AboutPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of About Page.");
		this.selenium = selenium;
		assertTrue("This is not About Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - About"), selenium);
	}
	
	/**
	 * Clicks on Daily Sweepstakes link in the left hand menu of the web page. 
	 * @return Daily Sweepstakes Page
	 */
	public DailySweepstakesPage goToDailySweepstakesPage() {
		selenium.click(About.NAV_MENU_DAILY_SWEEPSTAKES);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new DailySweepstakesPage(selenium);
	}

	/**
	 * Clicks on Products link in the left hand menu of the web page. 
	 * @return Products Page
	 */
	public ProductsPage goToProductsPage() {
		selenium.click(About.NAV_MENU_PRODUCTS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProductsPage(selenium);
	}

	/**
	 * Clicks on Coaches link in the left hand menu of the web page. 
	 * @return Coaches Page
	 */
	public CoachesPage goToCoachesPage() {
		selenium.click(About.NAV_MENU_COACHES);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CoachesPage(selenium);
	}

	/**
	 * Clicks on Community link in the left hand menu of the web page. 
	 * @return Community Page
	 */
	public CommunityPage goToCommunityPage() {
		selenium.click(About.NAV_MENU_COMMUNITY);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CommunityPage(selenium);
	}

	/**
	 * Clicks on Join/Upgrade link in the left hand menu of the web page. 
	 * @return Join/Upgrade Page
	 */
	public JoinUpgradePage goToJoinUpgradePage() {
		selenium.click(About.NAV_MENU_JOIN);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new JoinUpgradePage(selenium);
	}

	/**
	 * Clicks on Newsletters link in the left hand menu of the web page. 
	 * @return Newsletters Page
	 */
	public NewslettersPage goToNewslettersPage() {
		selenium.click(About.NAV_MENU_NEWSLETTERS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new NewslettersPage(selenium);
	}

	/**
	 * Returns the number of links on the left hand side menu.
	 * @return int
	 */
	public int getMenuLinksCount() {
		return selenium.getXpathCount(About.MENU_LINKS_XPATH).intValue();		
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
						.getText(About.NAV_MENU_ITEMS_TEXT_XPATH + "[" + i + "]/a");
			}
		}
		return menuLinksNames;
	}

	/**
	 * Returns the number of links on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getContentLinksCount() {
		return selenium.getXpathCount(About.CONTENT_LINKS_XPATH).intValue();
	}
	
	/**
	 * Returns the number of images on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getImageLinksCount() {
		return selenium.getXpathCount(About.IMAGE_LINKS_XPATH).intValue();
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
						.getText(About.CONTENT_LINKS_TEXT_XPATH + "[" + i
								+ "]/h2");
			}
		}
		return contentLinksNames;
	}

	/**
	 * Returns the number of learn more links displayed on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getLearnMoreLinksCount() {
		return selenium.getXpathCount(About.LEARN_MORE_LINKS_XPATH).intValue();
	}

	/**
	 * Clicks on Learn More link for Join/Upgrade. Navigates user to Join/Upgrade Page. 
	 * @return JoinUpgradePage
	 */
	public JoinUpgradePage clickJoinUpgradeLearnMore() {
		selenium.click(About.JOIN_UPGRADE_LEARN_MORE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new JoinUpgradePage(selenium);
	}

	/**
	 * Clicks on Learn More link for Products. Navigates user to Products Page. 
	 * @return ProductsPage
	 */
	public ProductsPage clickProductsLearnMore() {
		selenium.click(About.PRODUCTS_LEARN_MORE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProductsPage(selenium);
	}
	
	/**
	 * Clicks on Learn More link for Community. Navigates user to Community Page. 
	 * @return CommunityPage
	 */
	public CommunityPage clickCommunityLearnMore() {
		selenium.click(About.COMMUNITY_LEARN_MORE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CommunityPage(selenium);
	}
	
	/**
	 * Clicks on Learn More link for Coaches. Navigates user to Coaches Page. 
	 * @return CoachesPage
	 */
	public CoachesPage clickCoachesLearnMore() {
		selenium.click(About.COACHES_LEARN_MORE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CoachesPage(selenium);
	}
	
	/**
	 * Clicks on Learn More link for Daily Sweepstakes. Navigates user to Daily Sweepstakes Page. 
	 * @return DailySweepstakesPage
	 */
	public DailySweepstakesPage clickDailySweepstakesLearnMore() {
		selenium.click(About.DAILY_SWEEPSTAKES_LEARN_MORE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new DailySweepstakesPage(selenium);
	}
	
	/**
	 * Clicks on Learn More link for Newsletters. Navigates user to Newsletters Page. 
	 * @return NewslettersPage
	 */
	public NewslettersPage clickNewslettersLearnMore() {
		selenium.click(About.NEWSLETTERS_LEARN_MORE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new NewslettersPage(selenium);
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
			rrmTitles.add(selenium.getText(About.ABOUT_PROGRAM_RRM_SECTION + "[" + i + "]" + About.ABOUT_PROGRAM_RRM_TITLE));
		}
		return rrmTitles;
	}
	
	/**
	 * Returns number of RRMs
	 * @return int
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(About.ABOUT_PROGRAM_RRM_SECTION).intValue();
	}
}