package com.tbb.pages.getfit;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.Workout;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
import com.tbb.pages.about.AboutPage;
/**
 * 
 * Page Object encapsulates the Wowy Super Gym Page
 * @author Gaurav
 */
public class WowySuperGymPage  extends BaseTest {

	private LoggingSelenium selenium;

	/**
	 * Constructor for WowySuperGymPage. Verifies whether we are on Wowy SuperGym Page
	 * 
	 * @param selenium
	 */
	public WowySuperGymPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Wowy SuperGym' Page Class");
		assertTrue(
				"This is not 'Wowy SuperGym' page, current page is: "
				+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: WOWY SuperGym™"), selenium);
	}										

	/**
	 * Navigate to Get Fit Link
	 */
	public GetFitPage clickGetFitLink() {
		selenium.click(Dashboard.GET_FIT_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new GetFitPage(selenium);
	}

	/**
	 * Returns details of next upcoming scheduled workout
	 * @return Workout Program & Routine and its date & time
	 */
	public String[] getNextWorkoutScheduledDetails() {
		return new String[] {selenium.getText(Workout.NEXT_WORKOUT_DETAIL) , selenium.getText(Workout.NEXT_WORKOUT_TIME) + " " +  selenium.getText(Workout.NEXT_WORKOUT_DATE) };
	}

	/**
	 * Returns count of scheduled workouts for selected date
	 * @return Number of scheduled workouts for selected date
	 */
	public String getScheduledWorkoutsCount() {
		String scheduledWorkoutsCount = selenium.getText(Workout.NEXT_WORKOUT_SCHEDULED_WORKOUTS_COUNT_FOR_SELECTED_DATE);
		scheduledWorkoutsCount = scheduledWorkoutsCount.substring(0, 1);
		return scheduledWorkoutsCount;
	}


	/**
	 * Returns SuperGym time
	 * @return String text having SuperGym Time
	 */
	public String getMyWorkoutCalendarSuperGymTime() {
		return selenium.getText(Workout.MY_WORKOUT_CALENDER_WOWY_SUPERGYM_TIME);
	}

	/**
	 * Returns Local time
	 * @return String text having Local Time
	 * 
	 */
	public String getMyWorkoutCalendarLocalTime() {
		return selenium.getText(Workout.MY_WORKOUT_CALENDER_LOCAL_TIME);
	}

	/**
	 * Returns information about selected date
	 * @return String text having selected day in calendar
	 */
	public String getMyWorkoutCalendarSelectedDate() {
		if(selenium.isElementPresent(Workout.MY_WORKOUT_CALENDAR_WEEKDAY_SELECTED_DATE)) {
			return selenium.getText(Workout.MY_WORKOUT_CALENDAR_WEEKDAY_SELECTED_DATE);
		} else {
			return selenium.getText(Workout.MY_WORKOUT_CALENDAR_WEEKEND_SELECTED_DATE);	
		}
	}

	/**
	 * Method to give workout statistic
	 * @return String[] having details about number of  Scheduled workouts, SuperGym workouts completed and Other workouts completed
	 */
	public String[] getMyWorkoutStatistics() {
		String[] myWorkoutStatistics = new String[3];
		myWorkoutStatistics[0] = "Scheduled workouts = " + selenium.getText(Workout.MY_WORKOUT_CALENDAR_SCHEDULED_WORKOUTS);
		myWorkoutStatistics[1] = "SuperGym workouts completed  = " + selenium.getText(Workout.MY_WORKOUT_CALENDAR_SUPERGYM_WORKOUTS_COMPLETED);
		myWorkoutStatistics[2] = "Other workouts completed = " + selenium.getText(Workout.MY_WORKOUT_CALENDAR_OTHER_WORKOUTS_COMPLETED);

		return myWorkoutStatistics;
	}

	/**
	 * Creates one-click workout by selecting a program, routine
	 * @param program Workout program that a user intends to perform
	 * @param routine Workout Routine that a user intends to perform
	 * @return Instance of WhosWorkingOutPage
	 */
	public WhosWorkingOutPage createOneClickWorkout(String program, String routine) {
		selenium.select(Workout.MY_WORKOUT_CALENDAR_PROGRAM_SELECT, program);
		selenium.select(Workout.MY_WORKOUT_CALENDAR_ROUTINE_SELECT, routine);
		selenium.click(Workout.MY_WORKOUT_CALENDAR_START_NOW_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForTextPresent("Number of people working out now");
		return new WhosWorkingOutPage(selenium);
	}

	/**
	 * Navigates to 'Schedule a Workout' page
	 */
	public ScheduleWorkoutPage clickScheduleAWorkoutLink() {
		selenium.click(Workout.MY_WORKOUT_CALENDAR_SCHEDULE_A_WORKOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ScheduleWorkoutPage(selenium);
	}

	/**
	 * Navigates to 'Add a New Auto Schedule' page
	 */
	public void clickAddANewAutoScheduleLink() {
		selenium.click(Workout.MY_WORKOUT_CALENDAR_ADD_A_NEW_AUTO_SCHEDULE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		//return new WhosWorkingOutPage(selenium);
	}

	/**
	 * Navigates to 'Add a Completed Workout' page
	 */
	public void clickAddACompletedWorkoutLink() {
		selenium.click(Workout.MY_WORKOUT_CALENDAR_ADD_A_COMPLETED_WORKOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		//return new WhosWorkingOutPage(selenium);
	}

	/**
	 * Navigates to 'Who's Working Out' page
	 * @return
	 */
	public WhosWorkingOutPage clickWorkoutNowLink() {
		selenium.click(Workout.MY_WORKOUT_CALENDAR_WORK_OUT_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WhosWorkingOutPage(selenium);
	}

	/**
	 * Returns WOWY SuperGym™ statistics
	 */
	public String[] getWOWYSuperGymStatistics(){
		String[] superGymStatistics = new String[3];

		int spanCount = selenium.getXpathCount(Workout.STAT_TOTAL_WORKOUTS_COMPLETED_TODAY + "/span").intValue();
		String workoutCompletedToday = "";
		for(int i=spanCount; i>0; i--) {
			workoutCompletedToday = workoutCompletedToday + selenium.getText(Workout.STAT_TOTAL_WORKOUTS_COMPLETED_TODAY + "/span[" + i + "]");
		}
		superGymStatistics[0] = "Total workouts completed today = " + workoutCompletedToday;

		spanCount = selenium.getXpathCount(Workout.STAT_TODAY_PEAK + "/span").intValue();
		String todayPeak = "";
		for(int i=spanCount; i>0; i--) {
			todayPeak = todayPeak + selenium.getText(Workout.STAT_TODAY_PEAK + "/span[" + i + "]");
		}
		superGymStatistics[1] = "Today Peak = " + todayPeak;


		spanCount = selenium.getXpathCount(Workout.STAT_PEOPLE_COUNT_WORKING_OUT_NOW + "/span").intValue();
		String workingOutNow = "";
		for(int i=spanCount; i>0; i--) {
			workingOutNow = workingOutNow + selenium.getText(Workout.STAT_PEOPLE_COUNT_WORKING_OUT_NOW + "/span[" + i + "]");
		}
		superGymStatistics[2] = "Number of people working out now = " + workingOutNow;



		/*	superGymStatistics[0] = "Total workouts completed today = " + selenium.getText(Workout.STAT_TOTAL_WORKOUTS_COMPLETED_TODAY);
		superGymStatistics[1] = "Today Peak = " + selenium.getText(Workout.STAT_TODAY_PEAK);
		superGymStatistics[2] = "Number of people working out now = " + selenium.getText(Workout.STAT_PEOPLE_COUNT_WORKING_OUT_NOW);*/


		return superGymStatistics; 
	}

	/**
	 * Navigates to 'More Statistics' page
	 */
	public WOWYSuperGymStatsPage clickMoreStatistics() {
		selenium.click(Workout.STAT_MORE_STATISTICS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WOWYSuperGymStatsPage(selenium);
	}

	/**
	 * Clicks on Sign out link to sign out user from the website. 
	 * @return HomePage
	 */
	public HomePage signOut() {
		selenium.waitForElementPresent(Home.SIGNOUT_LINK);
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);
	}

	/**
	 * Clicks on About Link in the top menu bar
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click(Dashboard.ABOUT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}
































}
