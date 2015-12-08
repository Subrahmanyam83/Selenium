package com.tbb.pages.getfit;

/**
 * @author xebia
 * Page Object encapsulates the Trainer Tony's Page.
 */

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Trainers;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Trainer Tony page and exposes the functionality available on that page 
 * @author Jaya
 */

public class TrainerTonyPage extends BaseTest {
	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Trainer Tony's Page.
	 * @param	selenium
	 * @throws  IllegalStateException if the user is on a different page than Trainer Tony's Page.
	 */
	public TrainerTonyPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Trainer Tony's Page Class");
		assertTrue("This is not Trainer Tony's Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Get Fit: Trainers: Tony Horton"), selenium);
	}
	
	/**
	 * Navigates user to Trainers page. 
	 * @return TrainersPage
	 */
	public TrainersPage clickTrainerslink() {
		selenium.click(Trainers.TRAINERS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainersPage(selenium);		
	}		
}