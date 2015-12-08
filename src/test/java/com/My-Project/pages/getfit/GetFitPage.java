package com.tbb.pages.getfit;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.GetFit;
import com.tbb.constants.UIRepository.Home;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
import com.tbb.pages.eatsmart.EatSmartPage;

/**
 * This page object represents Get-Fit page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class GetFitPage  extends BaseTest {

	private LoggingSelenium selenium;

	/**
	 * Constructor for 'Get Fit' page. Verifies whether we are on 'Get Fit' page.
	 * @param selenium
	 */
	public GetFitPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Get Fit' Page Page Class");
		assertTrue(
				"This is not 'Get Fit' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit"),
				selenium);
	}

	/**
	 * Navigates to 'Get Fit' page from Left side menu
	 * @return
	 */
	public GetFitPage goToGetFitPage() {
		selenium.click(GetFit.NAV_MENU_GET_FIT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new GetFitPage(selenium);
	}

	/**
	 * Navigates to 'Wowy SuperGym' page from Left side menu
	 * @return
	 */
	public WowySuperGymPage goToWowySupergymPage() {
		selenium.click(GetFit.NAV_MENU_WOWY_SUPERGYM_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WowySuperGymPage(selenium);
	}

	/**
	 * Navigates to 'Fitness Tools' page from Left side menu
	 * @return
	 */
	public FitnessToolsPage goToFitnessToolsPage() {
		selenium.click(GetFit.NAV_MENU_FITNESS_TOOLS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new FitnessToolsPage(selenium);
	}

	/**
	 * Navigates to 'Fitness Programs' page from Left side menu
	 * @return
	 */
	public FitnessProgramsPage goToFitnessProgramsPage() {
		selenium.click(GetFit.NAV_MENU_FITNESS_PROGRAMS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new FitnessProgramsPage(selenium);
	}

	
	
	/**
	 * Navigates to 'Fitness Tips' page from Left side menu
	 * @return
	 */
	public FitnessTipsPage goToFitnessTipsPage() {
		selenium.click(GetFit.NAV_MENU_FITNESS_TIPS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new FitnessTipsPage(selenium);
	}

	
	/**
	 * Navigates to 'Trainers' page from Left side menu
	 * @return
	 */
	public TrainersPage goToTrainersPage() {
		selenium.click(GetFit.NAV_MENU_TRAINERS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainersPage(selenium);
	}

	
	/**
	 * Navigates to 'Workout Sheets' page from Left side menu
	 * @return
	 */
	public WorkoutSheetsPage goToWorkoutSheetsPage() {
		selenium.click(GetFit.NAV_MENU_WORKOUT_SHEETS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutSheetsPage(selenium);
	}

	
	/**
	 * Navigates to 'Workout Groups' page from Left side menu
	 * @return
	 */
	public WorkoutGroupsPage goToWorkoutGroupsPage() {
		selenium.click(GetFit.NAV_MENU_WORKOUT_GROUPS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutGroupsPage(selenium);
	}

	
	/**
	 * Returns count of Links given in left side menu
	 * @return number of links dispalyed in left side menu
	 */
	public int getMenuLinksCount() {
		return selenium.getXpathCount(GetFit.NAV_MENU_ITEMS).intValue();
	}

	
	/**
	 * Returns array of Links' Title given in left side menu
	 * @return String[] having Links' Title given in left side menu
	 */
	public String[] getMenuLinksText() {
		int menuItemsCount = getMenuLinksCount();
		String[] menuLinksNames = null;
		if (menuItemsCount > 0) {
			menuLinksNames = new String[menuItemsCount];
			for (int i = 1; i <= menuItemsCount; i++) {
				menuLinksNames[i - 1] = selenium
						.getText(GetFit.NAV_MENU_ITEMS_TEXT_XPATH + "[" + i
								+ "]/a");
			}
		}
		return menuLinksNames;
	}

	
	/**
	 * Navigates to 'Wowy SuperGyms' page from right side content area
	 * @return
	 */
	public WowySuperGymPage clickWowySuperGymLearnMore() {
		selenium.click(GetFit.WOWY_SUPERGYM_CONTENT_LEARN_MORE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WowySuperGymPage(selenium);
	}

	
	/**
	 * Navigates to 'Fitness Tools' page from right side content area
	 * @return
	 */	
	public FitnessToolsPage clickFitnessToolsLearnMore() {
		selenium.click(GetFit.FITNESS_TOOLS_CONTENT_LEARN_MORE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new FitnessToolsPage(selenium);
	}

	
	/**
	 * Navigates to 'Fitness Programs' page from right side content area
	 * @return
	 */	
	public FitnessProgramsPage clickFitnessProgramsLearnMore() {
	
		selenium.click(GetFit.FITNESS_PROGRAMS_CONTENT_LEARN_MORE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new FitnessProgramsPage(selenium);
	}

	
	/**
	 * Navigates to 'Fitness Tips' page from right side content area
	 * @return
	 */	
	public FitnessTipsPage clickFitnessTipsLearnMore() {
		selenium.click(GetFit.FITNESS_TIPS_CONTENT_LEARN_MORE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new FitnessTipsPage(selenium);
	}

	
	/**
	 * Navigates to 'Trainers' page from right side content area
	 * @return
	 */	
	public TrainersPage clickTrainersLearnMore() {
		selenium.click(GetFit.TRAINERS_CONTENT_LEARN_MORE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainersPage(selenium);
	}

	
	/**
	 * Returns count of 'Learn More' links given in right side content area
	 * @return number of links dispalyed in left side menu
	 */
	public int getContentLinksCount() {
		return selenium.getXpathCount(GetFit.CONTENT_LINK_ITEMS).intValue();
	}

	
	
	/**
	 * Returns array of Links' Title given in right side content area
	 * @return String[] having Links' Title given in right side content area
	 */
	public String[] getContentLinksText() {
		int contentItemsCount = getContentLinksCount();
		String[] contentLinksNames = null;
		if (contentItemsCount > 0) {
			contentLinksNames = new String[contentItemsCount];
			for (int i = 1; i <= contentItemsCount; i++) {
				contentLinksNames[i-1] = selenium
						.getText(GetFit.CONTENT_LINK_ITEMS + "[" + i
								+ "]/h2");
			}
		}
		return contentLinksNames;
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
		rrmsCount = rrmsCount-1; 
		for (int i =1; i<=rrmsCount; i++) {
			rrmTitles.add(selenium.getText(GetFit.GETFIT_PROGRAM_RRM_SECTION + "[" + i + "]" + GetFit.GETFIT_PROGRAM_RRM_TITLE));
		}
		return rrmTitles;
	}
	
	/**
	 * Returns number of RRMs
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(GetFit.GETFIT_PROGRAM_RRM_SECTION).intValue();
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
