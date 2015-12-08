package com.tbb.pages.getfit;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.TargetHeartRateCalcultor;
import com.tbb.constants.UIRepository.WorkoutSheets;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Workout Sheets page and exposes the functionality available on that page 
 * @author Gaurav
 * 
 *
 */
public class WorkoutSheetsPage  extends BaseTest {
	private LoggingSelenium selenium;

	/**
	 * Constructor for WorkoutSheets Page. Verifies whether we are on Workout Sheets page.
	 * @param selenium
	 */
	public WorkoutSheetsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Workout Sheets' Page Class");
		assertTrue(
				"This is not 'Workout Sheets' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: Fitness Tools: Workout Sheets"), selenium);
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
	 * Verifies UI of page
	 */
	public void verifyUI() {
		assertTrue("'Workout Sheet' heading not displayed", selenium.getText(WorkoutSheets.HEADING).equals("Workout Sheets"), selenium);
		int workoutSheetsCount = getWorkoutSheetsCount();
		for(int i=1; i<=workoutSheetsCount; i++) {
			assertTrue("'Workout Sheet Image' not displayed", selenium.isElementPresent(WorkoutSheets.PDF_SHEET + "[" + i + "]" + WorkoutSheets.PDF_SHEET_IMAGE), selenium);
			assertTrue("'Workout Sheet Title' not displayed", selenium.isElementPresent(WorkoutSheets.PDF_SHEET + "[" + i + "]" + WorkoutSheets.PDF_SHEET_TITLE), selenium);
			assertTrue("'Workout Sheet Download Button' not displayed", selenium.isElementPresent(WorkoutSheets.PDF_SHEET + "[" + i + "]" + WorkoutSheets.PDF_SHEET_DOWNLOAD_BUTTON), selenium);
		}
		
		assertTrue("'P90Xcel (Microsoft Excel 2003 and 2007)' Link not displayed", selenium.isElementPresent(WorkoutSheets.MS_EXCEL_P90_XCEL_SPREADSHEET), selenium);
		assertTrue("'P90XcelPlus (Microsoft Excel 2003 and 2007)' Link not displayed", selenium.isElementPresent(WorkoutSheets.MS_EXCEL_P90_XCEL_PLUS_SPREADSHEET), selenium);
	}
	
	/**
	 * Returns count of Workout sheets displayed
	 */
	public int getWorkoutSheetsCount() {
		return selenium.getXpathCount(WorkoutSheets.PDF_SHEET).intValue();
	}
	
	/**
	 * Returns titles of Workout sheets displayed
	 */
	public ArrayList<String> getWorkoutSheetsTitles() {
		ArrayList<String> workoutSheetsTitles = new ArrayList<String>();
		int workoutSheetsCount = getWorkoutSheetsCount();
		for(int i=1; i<=workoutSheetsCount; i++) {
			workoutSheetsTitles.add(selenium.getText(WorkoutSheets.PDF_SHEET + "[" + i + "]" + WorkoutSheets.PDF_SHEET_TITLE));
		}
		
		return workoutSheetsTitles;
	}
	
	
	/**
	 * Returns count of RRMs
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(TargetHeartRateCalcultor.RRM_ITEM).intValue();
	}
	
	
	/** 
	 * Returns title of RRMs
	 */
	public ArrayList<String> getRRMsTitles() {
		ArrayList<String> rRMsTitles = new ArrayList<String>();
		int rRMsTitlesCount = getRRMsCount();
		for(int i=1; i<=rRMsTitlesCount; i++) {
			rRMsTitles.add(selenium.getText(TargetHeartRateCalcultor.RRM_ITEM + "[" + i + "]" + TargetHeartRateCalcultor.RRM_TILE));
		}
		return rRMsTitles;
	}
	
	
	
}
