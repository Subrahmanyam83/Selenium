package com.tbb.pages.others;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.HelpFAQ;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Super Gym Tutorial page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class SuperGymTutorialPage  extends BaseTest {

	private LoggingSelenium selenium;

	/**
	 * Constructor for SuperGym Tutorial Page. Verified whether we are on SuperGym Tutorial Page
	 * @param selenium
	 */
	public SuperGymTutorialPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'SuperGym Tutorial Page' Class");
		assertTrue(
				"This is not 'SuperGym Tutorial' Page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - SuperGym Tutorial"), selenium);
	}
	
	
	/**
	 * Verifies UI of page
	 */
	public void verifyUI() {
		assertTrue("'Enter your workouts in the Workout Calendar.' not displayed", selenium.isTextPresent("Enter your workouts in the Workout Calendar."), selenium);
		assertTrue("'Continue setting up your workout: Choose your program and routine.' not displayed", selenium.isTextPresent("Continue setting up your workout: Choose your program and routine."), selenium);
		assertTrue("'Next, choose your start time, recurrences, and Workout Buddies.' not displayed", selenium.isTextPresent("Next, choose your start time, recurrences, and Workout Buddies."), selenium);
		assertTrue("'Last, confirm that your information is correct.' not displayed", selenium.isTextPresent("Last, confirm that your information is correct."), selenium);
		assertTrue("'In a hurry? Use One-Click Workout.' not displayed", selenium.isTextPresent("In a hurry? Use One-Click Workout."), selenium);
		assertTrue("'Or enter your entire program's schedule at once with Auto-Schedule.' not displayed", selenium.isTextPresent("Or enter your entire program's schedule at once with Auto-Schedule."), selenium);
		assertTrue("'Go to the Cooldown Chat Room.' not displayed", selenium.isTextPresent("Go to the Cooldown Chat Room."), selenium);
		assertTrue("'View your upcoming workouts.' not displayed", selenium.isTextPresent("View your upcoming workouts."), selenium);
			
		
		assertTrue("'Latest Daily Winner' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div.title > span:contains(Latest Daily Winner)"), selenium);
		assertTrue("'Contests' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div.title > span:contains(Contests)"), selenium);
		assertTrue("'Find Buddies' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div >  div.title > span:contains(Find Buddies)"), selenium);
		assertTrue("'Message Boards' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div.title > span:contains(Message Boards)"), selenium);
		assertTrue("'Nutrition Tips' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div.title > span:contains(Nutrition Tips)"), selenium);

		
	}

	/**
	 * Navigates to SuperGym FAQ Page
	 * @return
	 */
	public SuperGymFAQPage clickSuperGymFAQLink() {
		selenium.click(HelpFAQ.SUPER_GYM_FAQ_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new SuperGymFAQPage(selenium);
	}
	
	
}
