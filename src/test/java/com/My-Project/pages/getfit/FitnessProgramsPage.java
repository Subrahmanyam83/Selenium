package com.tbb.pages.getfit;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.FitnessPrograms;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.eatsmart.EatSmartPage;

/**
 * This page object represents Fitness Programs page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class FitnessProgramsPage  extends BaseTest {


	private LoggingSelenium selenium;

	/**
	 * Constructor for Fitness Programs Page. Verified whether we are on Fitness Programs page
	 * @param selenium
	 */
	public FitnessProgramsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Fitness Programs' Page Class");
		assertTrue(
				"This is not 'Fitness Programs' page, current page is: "
				+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: Fitness Programs"), selenium);
	}

	/**
	 * Navigate to Get Fit Link
	 */
	public GetFitPage clickGetFitLink() {
		selenium.click("css=a:contains(Get Fit)");	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new GetFitPage(selenium);
	}

	/**
	 * Verifies UI and view of page
	 */
	public void verifyUI() {
		assertTrue("Heading 'Fitness Programs' not shown", selenium.getText(FitnessPrograms.FITNESS_PROGRAM_HEADING).equals("Fitness Programs") , selenium);
		assertTrue("Link 'Check out our Comparison Chart' not displayed", selenium.isElementPresent(FitnessPrograms.FITNESS_PROGRAM_COMPARISON_CHART_LINK), selenium);
		int fitnessProgramsCount = getFitnessProgramsCount();
		for (int i =1; i<=fitnessProgramsCount; i++) {
			boolean condition = selenium.isElementPresent(FitnessPrograms.FITNESS_PROGRAM_SECTION + "[" + i + "]" + FitnessPrograms.FITNESS_PROGRAM_LEARN_MORE_LINK) && selenium.isElementPresent(FitnessPrograms.FITNESS_PROGRAM_SECTION + "[" + i + "]" + FitnessPrograms.FITNESS_PROGRAM_BUY_NOW_LINK);
			String fitnessProgramTitle = selenium.getText(FitnessPrograms.FITNESS_PROGRAM_SECTION + "[" + i + "]" + FitnessPrograms.FITNESS_PROGRAM_TITLE);
			assertTrue("'Learn More' & 'Buy Now' buttons not present for " + fitnessProgramTitle , condition , selenium);

		}
	}



	/**
	 * Returns number of Fitness Programs
	 */
	public int getFitnessProgramsCount() {
		return selenium.getXpathCount(FitnessPrograms.FITNESS_PROGRAM_SECTION).intValue();
	}


	/**
	 * Returns title of Fitness Programs
	 */
	public ArrayList<String> getFitnessProgramsTitles() {
		ArrayList<String> fitnessPrograms = new ArrayList<String>();
		int fitnessProgramsCount = getFitnessProgramsCount();
		for (int i=1; i<=fitnessProgramsCount; i++) {
			fitnessPrograms.add(selenium.getText(FitnessPrograms.FITNESS_PROGRAM_SECTION + "[" + i + "]" + FitnessPrograms.FITNESS_PROGRAM_TITLE));
		}
		return fitnessPrograms;

	}


	/**
	 * Returns number of RRMs
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(FitnessPrograms.FITNESS_PROGRAM_RRM_SECTION).intValue();
	}


	/**
	 * Returns title of RRMs
	 */
	public ArrayList<String> getRRMsTitles() {
		ArrayList<String> rrmTitles = new ArrayList();
		int rrmsCount = getRRMsCount();
		for (int i =1; i<=rrmsCount; i++) {
			rrmTitles.add(selenium.getText(FitnessPrograms.FITNESS_PROGRAM_RRM_SECTION + "[" + i + "]" + FitnessPrograms.FITNESS_PROGRAM_RRM_TITLE));
		}
		return rrmTitles;

	}

	/**
	 * Clicks on About Link on top menu bar. Navigates user to About Page. 
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click("css=li a>span:contains(About)");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}

	/**
	 * Clicks on Fitness Programs link in the left hand side menu
	 */
	public void clickFitnessProgramsLink() {
		selenium.click("css=a[href='/get-fit/fitness-programs']");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Returns the number of reviews displayed in bazaar voice of Fitness Programs Page.
	 * @return int
	 */
	public int getReviewCount() {
		return selenium.getXpathCount(FitnessPrograms.REVIEW_XPATH).intValue();
	}

	/**
	 * Clicks on P90X Reviews link.
	 */
	public void clickP90XReviews() {
		selenium.click(FitnessPrograms.P90X_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on INSANITY Reviews link.
	 */
	public void clickINSANITYReviews() {
		selenium.click(FitnessPrograms.INSANITY_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Tony Horton Reviews Link. 
	 */
	public void clickTonyHortonReviews() {
		selenium.click(FitnessPrograms.TONY_HORTON_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/** 
	 * Clicks on ChaLEAN Extreme Reviews Link.
	 */
	public void clickChaleanExtremeReviews() {
		selenium.click(FitnessPrograms.CHALEAN_EXTREME_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Brazil Butt Lift Reviews link.
	 */
	public void clickBrazilButtLiftReviews() {
		selenium.click(FitnessPrograms.BRAZIL_BUTT_LIFT_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Turbo Fire Reviews Link. 
	 */
	public void clickTurboFireReviews() {
		selenium.click(FitnessPrograms.TURBO_FIRE_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Body Gospel Reviews Link. 
	 */
	public void clickBodyGospelReviews() {
		selenium.click(FitnessPrograms.BODY_GOSPEL_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Debbie Siebers Link.
	 */
	public void clickDebbieSiebersReviews() {
		selenium.click(FitnessPrograms.DEBBIE_SIEBERS_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Power 90 Reviews Link
	 */
	public void clickPower90Reviews() {
		selenium.click(FitnessPrograms.POWER_90_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Rev Abs Reviews Link. 
	 */
	public void clickRevAbsReviews() {
		selenium.click(FitnessPrograms.REV_ABS_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Hip Hop Abs Reviews Link.
	 */
	public void clickHipHopAbsReviews() {
		selenium.click(FitnessPrograms.HIP_HOP_ABS_REVIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Navigate to Eat Smart Page. 
	 * @return
	 */
	public EatSmartPage clickEatSmartLink() {
		selenium.click(Dashboard.EAT_SMART_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EatSmartPage(selenium);
	}
}
