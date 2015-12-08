package com.tbb.pages.getfit;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.WhosWorkingOut;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Who is working out page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class WhosWorkingOutPage  extends BaseTest {

	private LoggingSelenium selenium;
	
	/**
	 * Constructor for 'Who's Working Out' page. Verified whether we are on 'Who's Working Out' page
	 * @param selenium
	 */
	public WhosWorkingOutPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Who's Working Out' Page Class");
		assertTrue(
				"This is not 'Who's Working Out' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle()
						.equals("Team Beachbody - Get Fit: Supergym: Who's Working Out"),
				selenium);
	}

	/**
	 * Navigates to 'Wowy SuperGym' page
	 * @return
	 */
	public WowySuperGymPage clickWowySuperGymLink() {
		selenium.click(WhosWorkingOut.WOWY_SUPERGYM_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WowySuperGymPage(selenium);
	}

	/**
	 * Returns Time and Buddies info 
	 * @return String text having details about Time and Buddies info for a scheduled workout
	 */
	public String getSuperGymWorkoutProgressTimeBuddiesInfo() {
		selenium.waitForTextPresent("Number of people working out now");
		return selenium.getText(WhosWorkingOut.BUDDIES_COUNT);
	}

	/**
	 * Returns information about Scheduled Workout Program and Routine
	 * @return String text having information about Scheduled Workout Program and Routine
	 */
	public String getSuperGymWorkoutProgramsRoutineInfo() {
		return selenium.getText(WhosWorkingOut.SELECTED_PROGRAM_ROUTINE);
	}
	
	
	/**
	 * Finishes an on-going workout
	 */
	public void finishCurrentWorkout() {
		selenium.click(WhosWorkingOut.FINISHED_BUTTON);
	}

}
