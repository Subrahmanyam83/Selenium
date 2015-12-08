package com.tbb.pages.about;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.AboutDailySweepstakes;
import com.tbb.constants.UIRepository.AboutJoinUpgrade;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.connect.TheBeachbodyChallengePage;
import com.tbb.pages.getfit.WowySuperGymPage;
//import static com.tbb.framework.BaseTest.assertTrue;
/**
 *
 * Page Object encapsulates the Daily Sweep stakes Page.
 *  @author Jaya
 */

public class DailySweepstakesPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Daily Sweep stakes Page.
	 * @param	selenium
	 */
	public DailySweepstakesPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Daily Sweepstakes Page.");
		this.selenium = selenium;
		assertTrue("This is not Daily Sweepstakes Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - About: Daily Sweepstakes"), selenium);
	}
	
	/**
	 * Clicks on Workout Now Button. 
	 * @return Wowy Super Gym Page
	 */
	public WowySuperGymPage clickWorkOutNowButton() {
		selenium.click(AboutDailySweepstakes.WORKOUT_NOW_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WowySuperGymPage(selenium);
	}

	/**
	 * Clicks on Enter the Beachbody Challenge Button
	 * @return The Beachbody Challenge Page
	 */
	public TheBeachbodyChallengePage clickEnterTheBeachbodyChallengeButton() {
		selenium.click(AboutDailySweepstakes.ENTER_THE_BEACHBODY_CHALLENGE_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TheBeachbodyChallengePage(selenium);		
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