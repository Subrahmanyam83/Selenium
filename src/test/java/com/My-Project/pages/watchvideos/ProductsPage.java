
package com.tbb.pages.watchvideos;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.WatchVideosProducts;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Watch Videos - Products Page.
 * @author Jaya
 */
public class ProductsPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - Products Page.
	 * @param	selenium
	 */
	public ProductsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - Products Page.");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - Products Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Products"), selenium);
	}
	
	/**
	 * Clicks on Watch Videos link at the top menu bar. Navigates user to Watch Videos Page. 
	 * @return Watch Videos Page
	 */
	public WatchVideosPage clickWatchVideosLink() {
		selenium.click(Dashboard.WATCH_VIDEOS_MENU_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WatchVideosPage(selenium);
	}

	/**
	 * Navigates user to Shakeology Page.
	 */
	public void goToShakeology() {
		selenium.click(WatchVideosProducts.SHAKEOLOGY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Navigates user to P90X Page.
	 */
	public void goToP90X() {
		selenium.click(WatchVideosProducts.P90X_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);			
	}

	/**
	 * Navigates user to INSANITY Page.
	 */
	public void goToINSANITY() {
		selenium.click(WatchVideosProducts.INSANITY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Brazil Butt Lift Page.
	 */
	public void goToBrazilButtLift() {
		selenium.click(WatchVideosProducts.BRAZIL_BUTT_LIFT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Turbo Fire Page.
	 */
	public void goToTurboFire() {
		selenium.click(WatchVideosProducts.TURBO_FIRE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Body Gospel Page.
	 */
	public void goToBodyGospel() {
		selenium.click(WatchVideosProducts.BODY_GOSPEL_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Slim in 6 Page.
	 */
	public void goToSlimIn6() {
		selenium.click(WatchVideosProducts.SLIM_IN_6_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Power 90 Page.
	 */
	public void goToPower90() {
		selenium.click(WatchVideosProducts.POWER_90_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Turbo Jam Page.
	 */
	public void goToTurboJam() {
		selenium.click(WatchVideosProducts.TURBO_JAM_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to 10-Minute Trainer Page.
	 */
	public void goTo10MinuteTrainer() {
		selenium.click(WatchVideosProducts.TEN_MINUTE_TRAINER_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to P90X ONE on ONE Page.
	 */
	public void goToP90XONEonONE() {
		selenium.click(WatchVideosProducts.P90X_ONE_ON_ONE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to RevAbs Page.
	 */
	public void goToRevAbs() {
		selenium.click(WatchVideosProducts.REVABS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Hip Hop AbsPage.
	 */
	public void goToHipHopAbs() {
		selenium.click(WatchVideosProducts.HIP_HOP_ABS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to ChaLEAN Extreme Page.
	 */
	public void goToChaLEANExtreme() {
		selenium.click(WatchVideosProducts.CHALEAN_EXTREME_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}
	
	/**
	 * Navigates user to Rocking BodyPage.
	 */
	public void goToRockinBody() {
		selenium.click(WatchVideosProducts.ROCKIN_BODY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to KSPY2 Page.
	 */
	public void goToKSPY2() {
		selenium.click(WatchVideosProducts.KSPY2_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Total Body Solution Page.
	 */
	public void goToTotalBodySolution() {
		selenium.click(WatchVideosProducts.TOTAL_BODY_SOLUTION_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Navigates user to Yoga Booty Ballet Page.
	 */
	public void goToYogaBootyBallet() {
		selenium.click(WatchVideosProducts.YOGA_BOOTY_BALLET_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}
}