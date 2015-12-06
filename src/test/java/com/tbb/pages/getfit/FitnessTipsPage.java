package com.tbb.pages.getfit;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.FitnessTipsTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.ClubOnlyPage;

/**
 * This page object represents Fitness Tips page and exposes the functionality available on that page 
 * @author Jaya
 */
public class FitnessTipsPage  extends BaseTest implements FitnessTipsTab {

	private LoggingSelenium selenium;

	public FitnessTipsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Fitness Tips' Page Class");
		assertTrue(
				"This is not 'Fitness Tips' page, current page is: "
				+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: Fitness Tips"), selenium);
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
	 * Type tip in search textbox. 
	 * @param keyword
	 */
	public void typeSearchKeyword(String keyword) {
		selenium.type(TIP_SEARCH_TEXTBOX, keyword);		
	}

	public ClubOnlyPage clickSearchAsFreeUser() {
		selenium.click(TIP_SEARCH_ICON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ClubOnlyPage(selenium);
	}

	public void clickSearchAsClubUser() {
		selenium.click(TIP_SEARCH_ICON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	public void clickTipName(String keyword) {
		selenium.click("css=span:contains("+keyword+")");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}
}
