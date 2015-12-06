package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.MichisLadderTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Michi's Ladder Page
 * @author Jaya
 */
public class MichisLadderPage  extends BaseTest implements MichisLadderTab{

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Michi's Ladder Page.
	 * @param	selenium
	 */
	public MichisLadderPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Michi's Ladder Page");
		this.selenium = selenium;
		assertTrue("This is not Michi's Ladder Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart: Michi's Ladder"), selenium);
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
	
	/**
	 * Returns the count or number of links with text 'Back to Top'.
	 * @return int
	 */
	public int getBackToTopLinksCount() {
		return selenium.getXpathCount(BACK_TO_TOP_LINKS).intValue();
	}
	
	/**
	 * Returns the number of tiers displayed on the Michi's Ladder Page
	 * @return int
	 */
	public int getTiersCount() {
		return selenium.getXpathCount(TIERS_CONTENT_HOLDER).intValue();
	}
	
	/**
	 * Returns the number of Tier titles displayed on the Michi's Ladder Page. 
	 * @return int
	 */
	public int getTierTitlesCount() {
		return selenium.getXpathCount(TIER_TITLES).intValue();
	}
}