package com.tbb.pages.getfit;

/**
 * @author xebia
 * Page Object encapsulates the Trainer Debbie Page
 */

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Trainers;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * This page object represents Trainer Debbie page and exposes the functionality available on that page 
 * @author Jaya
 */
public class TrainerDebbiePage  extends BaseTest {
	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Trainer Debbie Page.
	 * @param	selenium
	 * @throws  IllegalStateException if the user is on a different page than Trainer Debbie Page.
	 */
	public TrainerDebbiePage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Trainer Debbie Page Class");
		assertTrue("This is not Trainer Debbie Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Get Fit: Trainers: Debbie Siebers"), selenium);
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