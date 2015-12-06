package com.tbb.pages.getfit;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.FitnessTools;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Fiteness Tools page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class FitnessToolsPage  extends BaseTest {


	private LoggingSelenium selenium;

	/**
	 * Constructor for 'Fitness Tools' page. Verifies whether we are on 'Fitness Tool' page.
	 * @param selenium
	 */
	public FitnessToolsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Fitness Tools' Page Class");
		assertTrue(
				"This is not 'Fitness Tools' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: Fitness Tools"), selenium);
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
	 * Verify UI of Fitness Tools Page
	 */
	public void verifyUI() {
		assertTrue("Heading 'Fitness Tools' is not present", selenium.getText(FitnessTools.FITNESS_TOOLS_HEADING).equals("Fitness Tools"), selenium);
		int fitnessToolsCount = getFitnessToolsCount();
		for(int i=1; i<=fitnessToolsCount; i++) {
		assertTrue("Fitness Tools images are not getting displayed", selenium.isElementPresent(FitnessTools.FITNESS_TOOLS_ITEM + "[" + i + "]" + FitnessTools.FITNESS_TOOLS_IMAGE), selenium);
		}
		assertTrue("Link 'Body Fat Calculator' is not present", selenium.isElementPresent(FitnessTools.BODY_FAT_CALCULATOR_LINK), selenium);
		assertTrue("Link 'Healthy Weight Calculator' is not present", selenium.isElementPresent(FitnessTools.HEALTHY_WEIGHT_CALCULATOR_LINK), selenium);
		assertTrue("Link 'Caloric Needs Calculator' is not present", selenium.isElementPresent(FitnessTools.CALORIC_NEEDS_CALCULATOR_LINK), selenium);
	}
	
	
	/**
	 * Return count of Tools
	 */
	public int getFitnessToolsCount() {
		return selenium.getXpathCount(FitnessTools.FITNESS_TOOLS_ITEM).intValue();
	}
	
	
	
	/** 
	 * Returns title of tools
	 */
	public ArrayList<String> getFitnessToolsTitles() {
		ArrayList<String> fitnessToolTitles = new ArrayList<String>();
		int fitnessToolsCount = getFitnessToolsCount();
		for(int i=1; i<=fitnessToolsCount; i++) {
			fitnessToolTitles.add(selenium.getText(FitnessTools.FITNESS_TOOLS_ITEM + "[" + i + "]/a"));
		}
		return fitnessToolTitles;
	}
	
	/**
	 * Returns count of RRMs
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(FitnessTools.RRM_ITEM).intValue();
	}
	
	
	/** 
	 * Returns title of RRMs
	 */
	public ArrayList<String> getRRMsTitles() {
		ArrayList<String> rRMsTitles = new ArrayList<String>();
		int rRMsTitlesCount = getRRMsCount();
		for(int i=1; i<=rRMsTitlesCount; i++) {
			rRMsTitles.add(selenium.getText(FitnessTools.RRM_ITEM + "[" + i + "]" + FitnessTools.RRM_TILE));
		}
		return rRMsTitles;
	}

	/**
	 * Navigates to 'Target Heart Rate' tool 
	 * @return
	 */
	public TargetHeartRateCalcultorPage clickTargetHeartRate() {
		selenium.click(FitnessTools.TARGET_HEART_RATE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TargetHeartRateCalcultorPage(selenium);
		
	}
	
	
	/**
	 * Navigates to 'Workout Sheets' tool 
	 * @return
	 */
	public WorkoutSheetsPage clickWorkoutSheets() {
		selenium.click(FitnessTools.WORKOUT_SHEETS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutSheetsPage(selenium);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
