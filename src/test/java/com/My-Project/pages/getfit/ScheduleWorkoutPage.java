package com.tbb.pages.getfit;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.ScheduleWorkout;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * This page object represents Schedule Workout page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class ScheduleWorkoutPage  extends BaseTest {
	
	private LoggingSelenium selenium;

	/**
	 * Constructor for WowySuperGymPage. Verifies whether we are on Wowy SuperGym Page
	 * 
	 * @param selenium
	 */
	public ScheduleWorkoutPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Schedule Workout' Page Class");
		assertTrue(
				"This is not 'Schedule Workout' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: Supergym: Schedule Workout"), selenium);
	}
	
	public WowySuperGymPage scheduleWorkout(String program, String routine, String buddyName)
	{
		selenium.select(ScheduleWorkout.STEP1_PROGRAM_SELECT, program);
		selenium.select(ScheduleWorkout.STEP1_ROUTINE_SELECT, routine);
		selenium.click(ScheduleWorkout.STEP1_ADD_TO_SESSION_BUTTON);
		selenium.click(ScheduleWorkout.STEP1_CONTINUE_BUTTON);
		
		
		selenium.click(ScheduleWorkout.STEP2_WORKOUT_BUDDY_CHECK_BOX.replace("Buddy_Name", buddyName));
		selenium.type(ScheduleWorkout.STEP2_WORKOUT_INVITATION_MESSAGE, "Sample Message");
		selenium.click(ScheduleWorkout.STEP2_REVIEW_AND_CONFIRM_BUTTON);
		
		selenium.click(ScheduleWorkout.STEP3_CONFIRM_BUTTON);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click(ScheduleWorkout.SUCCESS_POP_UP_I_AM_DONE_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		
		return new WowySuperGymPage(selenium);
		
	}
	

}
