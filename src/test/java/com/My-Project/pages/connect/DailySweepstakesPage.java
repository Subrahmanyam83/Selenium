package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Contests;
import com.tbb.constants.UIRepository.DailySweepstakes;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
//import static com.tbb.framework.BaseTest.assertTrue;
/**
 * 
 * Page Object encapsulates the Daily Sweepstakes Page
 * @author Jaya
 */
public class DailySweepstakesPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Daily Sweepstakes Page.
	 * @param	selenium
	 */
	public DailySweepstakesPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Daily Sweepstakes Page");
		this.selenium = selenium;

		assertTrue("This is not Daily Sweepstakes Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Contests: Daily Sweepstakes"), selenium);
	}
	
	/**
	 * Clicks on 'The Beachbody Challenge' link in the left hand menu. Navigates user to The Beachbody Challenge Page. 
	 * @return TheBeachbodyChallengePage
	 */
	public TheBeachbodyChallengePage goToTheBeachbodyChallenge() {
		selenium.click(DailySweepstakes.NAV_MENU_THE_BEACHBODY_CHALLENGE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TheBeachbodyChallengePage(selenium);
	}

	/**
	 * Clicks on Last arrow at the top of the search results. 
	 */
	public void clickLastArrow() {
		selenium.click(DailySweepstakes.TOP_ENABLED_LAST_ARROW);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on the First arrow at the top of the search results. 
	 */
	public void clickFirstArrow() {
		selenium.click(DailySweepstakes.TOP_ENABLED_FIRST_ARROW);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on the Next arrow at the top of the search results. 
	 */
	public void clickNextArrow() {
		selenium.click(DailySweepstakes.TOP_ENABLED_NEXT_ARROW);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on the Previous Arrow at the top of the search results. 
	 */
	public void clickPrevArrow() {
		selenium.click(DailySweepstakes.TOP_ENABLED_PREV_ARROW);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on 'Contest FAQ' link in the left hand menu. Navigates to the Contest FAQ Page. 
	 * @return ContestFAQPage
	 */
	public ContestFAQPage goToContestFAQPage() {
		selenium.click(Contests.LEFT_MENU_CONTEST_FAQ_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ContestFAQPage(selenium);		
	}	
}