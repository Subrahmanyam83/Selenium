package com.tbb.pages.getfit;

import java.util.ArrayList;

import com.tbb.constants.UIRepository.TargetHeartRateCalcultor;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Target Health Rate Calculator page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class TargetHeartRateCalcultorPage  extends BaseTest  {

	private LoggingSelenium selenium;

	/**
	 * Constructor for 'Target Heart Rate Calculator' page. Verifies whether we are on 'Target Heart Rate Calculator' page.
	 * @param selenium
	 */
	public TargetHeartRateCalcultorPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Target Heart Rate Calculator' Page Class");
		assertTrue(
				"This is not 'Target Heart Rate Calculator' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: Fitness Tools: Target Heart Rate"), selenium);
	}
	
	/**
	 * Verifies UI of page
	 */
	public void verifyUI() {
		selenium.isElementPresent(TargetHeartRateCalcultor.TARGET_HEART_RATE_CALCULATOR_HEADER);
		selenium.isElementPresent(TargetHeartRateCalcultor.TARGET_HEART_RATE_CALCULATOR_IMAGE);
	}
	
	
	/**
	 * Calculates Heart Rate Zones and retruns those values
	 */
	public ArrayList<String> getHeartRateZones(String age, String gender) {
		ArrayList<String> heartRateZones = new ArrayList<String>();
		selenium.type(TargetHeartRateCalcultor.AGE_TEXTBOX, age );
		selenium.select(TargetHeartRateCalcultor.GENDER_SELECT, gender);
		selenium.click(TargetHeartRateCalcultor.CALCULATE_HEART_RATE_ZONES_BUTTON);
		int heartRateZoneRowsCount = selenium.getXpathCount(TargetHeartRateCalcultor.HEART_RATE_ZONES_TABLE_ROW).intValue();
		for(int i=2; i<=heartRateZoneRowsCount; i++) {
			String rowContent = selenium.getText(TargetHeartRateCalcultor.HEART_RATE_ZONES_TABLE_ROW + "[" + i + "]" + TargetHeartRateCalcultor.RECOVERY_ZONE_NAME);
			rowContent = rowContent + " " + selenium.getValue(TargetHeartRateCalcultor.HEART_RATE_ZONES_TABLE_ROW + "[" + i + "]" + TargetHeartRateCalcultor.RECOVERY_ZONE_LOW);
			rowContent = rowContent + " " + selenium.getValue(TargetHeartRateCalcultor.HEART_RATE_ZONES_TABLE_ROW + "[" + i + "]" + TargetHeartRateCalcultor.RECOVERY_ZONE_HIGH);
			heartRateZones.add(rowContent);
		}
		
		return heartRateZones;
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
