package com.tbb.pages.getfit;

/**
 * @author xebia
 * Page Object encapsulates the Trainer Leandro Page
 */

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Trainers;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * This page object represents Trainer Leandro page and exposes the functionality available on that page 
 * @author Jaya
 */
public class TrainerLeandroPage  extends BaseTest {
	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Trainer Leandro Page.
	 * @param	selenium
	 * @throws  IllegalStateException if the user is on a different page than Trainer Leandro Page.
	 */
	public TrainerLeandroPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Trainer Leandro Page Class");
		assertTrue("This is not Trainer Leandro Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Get Fit: Trainers: Leandro Carvalho"), selenium);
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