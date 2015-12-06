package com.tbb.pages.watchvideos;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.WatchVideosSuccessStories;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.about.AboutPage;

/**
 * 
 * Page Object encapsulates the Watch Videos - Success Stories Page.
 * @author Jaya
 */
public class SuccessStoriesPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - Success Stories Page.
	 * @param	selenium
	 */
	public SuccessStoriesPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - Success Stories Page.");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - Success Stories Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Success Stories"), selenium);
	}

	/**
	 * Clicks on Watch Videos link at the top menu bar. Navigates user to Watch Videos Page. 
	 * @return Watch Videos Page
	 */
	public WatchVideosPage clickWatchVideosLink() {
		selenium.click(WatchVideosSuccessStories.WATCH_VIDEOS_MENU_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WatchVideosPage(selenium);
	}

	/**
	 * Navigates user to Coach Business Success Page. 
	 */
	public void goToCoachBusinessSuccess() {
		selenium.click(WatchVideosSuccessStories.COACH_BUSINESS_SUCCESS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Shakeology Success Page. 
	 */
	public void goToShakeologySuccess() {
		selenium.click(WatchVideosSuccessStories.SHAKEOLOGY_SUCCESS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Navigates user to P90X Page. 
	 */
	public void goToP90X() {
		selenium.click(WatchVideosSuccessStories.P90X_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to INSANITY Page. 
	 */
	public void goToINSANITY() {
		selenium.click(WatchVideosSuccessStories.INSANITY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Brazil Butt Lift Page. 
	 */
	public void goToBrazilButtLift() {
		selenium.click(WatchVideosSuccessStories.BRAZIL_BUTT_LIFT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Turbo Fire Page. 
	 */
	public void goToTurboFire() {
		selenium.click(WatchVideosSuccessStories.TURBO_FIRE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Slim in 6 Page. 
	 */
	public void goToSlimIn6() {
		selenium.click(WatchVideosSuccessStories.SLIM_IN_6_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Power 90 Page. 
	 */
	public void goToPower90() {
		selenium.click(WatchVideosSuccessStories.POWER_90_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Turbo Jam Page. 
	 */
	public void goToTurboJam() {
		selenium.click(WatchVideosSuccessStories.TURBO_JAM_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to 10-Minute Trainer Page. 
	 */
	public void goTo10MinuteTrainer() {
		selenium.click(WatchVideosSuccessStories.TEN_MINUTE_TRAINER_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Hip Hop Abs Page. 
	 */
	public void goToHipHopAbs() {
		selenium.click(WatchVideosSuccessStories.HIP_HOP_ABS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to ChaLEAN Extreme Page. 
	 */
	public void goToChaLEANExtreme() {
		selenium.click(WatchVideosSuccessStories.CHALEAN_EXTREME_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Yoga Booty Ballet Page. 
	 */
	public void goToYogaBootyBallet() {
		selenium.click(WatchVideosSuccessStories.YOGA_BOOTY_BALLET_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to KSPY2 Page. 
	 */
	public void goToKSPY2() {
		selenium.click(WatchVideosSuccessStories.KSPY2_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Shaun T Fit Kids Page. 
	 */
	public void goToShaunTsFitKidsClub() {
		selenium.click(WatchVideosSuccessStories.SHAUN_T_FIT_KIDS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigates user to Rockin' Body Page. 
	 */
	public void goToRockinBody() {
		selenium.click(WatchVideosSuccessStories.ROCKIN_BODY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Returns title of RRMs
	 */
	public ArrayList getRRMsTitles() {
		ArrayList<String> rrmTitles = new ArrayList();
		int rrmsCount = getRRMsCount();
		for (int i =1; i<=rrmsCount; i++) {
			rrmTitles.add(selenium.getText(WatchVideosSuccessStories.WATCHVIDEOS_SUCCESS_STORIES_PROGRAM_RRM_SECTION + "[" + i + "]" + WatchVideosSuccessStories.WATCHVIDEOS_SUCCESS_STORIES_PROGRAM_RRM_TITLE));
		}
		return rrmTitles;
	}
	
	/**
	 * Returns number of RRMs
	 * @return int
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(WatchVideosSuccessStories.WATCHVIDEOS_SUCCESS_STORIES_PROGRAM_RRM_SECTION).intValue();
	}

	/**
	 * Navigate to About Page. 
	 * @return
	 */
	public AboutPage clickAboutLink() {
		selenium.click(Dashboard.ABOUT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}
}