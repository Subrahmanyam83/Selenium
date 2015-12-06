package com.tbb.pages.getfit;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Trainers;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Trainer Brett page and exposes the functionality available on that page 
 * @author Jaya
 */
public class TrainerBrettPage  extends BaseTest {

	protected LoggingSelenium selenium;

	/**
	 * Constructor for 'Trainers' page. Verifies whether we are on 'Trainer Brett's' page.	 * 
	 * @param selenium
	 * @throws  IllegalStateException if the user is on a different page than 'Trainer Brett's' page.
	 */
	public TrainerBrettPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Trainer' Page Class");
		assertTrue(
				"This is not 'Trainer Brett's' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: Trainers: Brett Hoebel"), selenium);
	}
	
	public TrainersPage clickTrainerslink() {
		selenium.click(Trainers.TRAINERS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainersPage(selenium);		
	}	
}