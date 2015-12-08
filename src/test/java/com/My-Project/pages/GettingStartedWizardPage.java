package com.tbb.pages;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.StartUpWizard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object encapsulates the Getting Started Wizard page
 * @author Xebia
 *
 */
public class GettingStartedWizardPage extends BaseTest {

	private LoggingSelenium selenium;
	
	/**
	 * Constructor for GettingStartedWizardPage. It also checks whether wizard is starting from scratch. If it finds that it is resuming already initiated wizard then
	 * it completes full cycle of wizard and again launch wizard to get its first screen. 
	 * 
	 * @param selenium
	 */
	public GettingStartedWizardPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of GettingStartedWizardPage Class");
		
	/*	if(selenium.isTextPresent("Welcome back.")) {
			selenium.click(StartUpWizard.CONTINUE_BUTTON);
			while (!selenium.isTextPresent("Congratulations")) {
				selenium.click(StartUpWizard.NEXT_BUTTON);
				selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
			}
			selenium.click(StartUpWizard.SUBMIT_BUTTON);
			selenium.click(StartUpWizard.FINISH_BUTTON);
			//new DashboardPage(selenium).clickStartUpWizard();
			selenium.click(Dashboard.START_UP_WIZARD);
			selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		}*/
		
	}

	/**
	 * This method clicks on 'Next' button of wizard.
	 */
	public void clickNext() {
		selenium.click(StartUpWizard.NEXT_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	
	}

	/**
	 * This method completes the wizard without giving feedback.
	 */
	public void submitWithoutFeedback() {
		selenium.click(StartUpWizard.SUBMIT_BUTTON);
		assertTrue("Thanks for your feedback text not displayed", selenium.waitForTextPresent("Thanks for your feedback."), selenium);
		selenium.click(StartUpWizard.FINISH_BUTTON);
		
	}

	/**
	 * This method completes the wizard with feedback.
	 * @param feedback
	 */
	public void submitWithFeedback(String feedback) {
		selenium.type(StartUpWizard.FEEDBACK_TEXTAREA, feedback);
		selenium.click(StartUpWizard.SUBMIT_BUTTON);
		assertTrue("Thanks for your feedback text not displayed", selenium.waitForTextPresent("Thanks for your feedback."), selenium);
		selenium.click(StartUpWizard.FINISH_BUTTON);
		
	}
	
	
	/**
	 * This method will complete the already initiated Wizard so that test script can start GSW from beginning.
	 */
	public void completePreviousStartedWizard() {
		
			selenium.click(StartUpWizard.CONTINUE_BUTTON);
			while (!selenium.isTextPresent("Congratulations")) {
				selenium.click(StartUpWizard.NEXT_BUTTON);
				selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
			}
			selenium.click(StartUpWizard.SUBMIT_BUTTON);
			selenium.click(StartUpWizard.FINISH_BUTTON);
			//new DashboardPage(selenium).clickStartUpWizard();
			selenium.click(Dashboard.START_UP_WIZARD);
			selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		
	}
	

}
