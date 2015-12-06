package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Contests;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
//import static com.tbb.framework.BaseTest.assertTrue;
/**
 * 
 * Page Object encapsulates the Beachbody Challenge Page
 * @author Jaya
 */
public class TheBeachbodyChallengePage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on The Beachbody Challenge Page.
	 * @param	selenium
	 */
	public TheBeachbodyChallengePage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Beachbody Challenge Page");
		this.selenium = selenium;
		assertTrue("This is not The Beachbody Challenge Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - The Beachbody Challenge"), selenium);
	}
	
	/** Clicks on 'Contest FAQ' link in the left hand menu. Navigates user to Contest FAQ Page. 
	 * @return ContestFAQPage
	 */
	public ContestFAQPage goToContestFAQPage() {
		selenium.click(Contests.LEFT_MENU_CONTEST_FAQ_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ContestFAQPage(selenium);
	}
}