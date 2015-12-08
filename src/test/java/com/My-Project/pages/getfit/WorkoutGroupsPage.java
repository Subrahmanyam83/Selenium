package com.tbb.pages.getfit;

import com.tbb.constants.TestConsts;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.about.AboutPage;
/**
 * This page object represents Workout Groups page and exposes the functionality available on that page 
 * @author Gaurav
 *
 */
public class WorkoutGroupsPage  extends BaseTest {
	private LoggingSelenium selenium;

	/**
	 * Constructor for WorkoutGroupsPage. Verified whether we are on Workout Groups Page
	 * 
	 * @param selenium
	 */
	public WorkoutGroupsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Workout Groups' Page Class");
		assertTrue(
				"This is not 'Workout Groups' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: Supergym: Workout Groups"), selenium);
	}
	
	/**
	 * Navigate to Get Fit Link
	 * @return Get Fit Page
	 */
	public GetFitPage clickGetFitLink() {
        selenium.click("css=a:contains(Get Fit)");	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new GetFitPage(selenium);
	}

	/**
	 * Navigate to About Page. 
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click("css=li a>span:contains(About)");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}
}
