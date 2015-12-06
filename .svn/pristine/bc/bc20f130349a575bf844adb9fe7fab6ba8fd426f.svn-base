package com.tbb.pages.connect;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.MyCoach;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the My Coach Page
 * @author Gaurav
 */
public class MyCoachPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on My Coach Page.
	 * @param	selenium
	 */
	public MyCoachPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of My Coach Page");
		this.selenium = selenium;
		/*The below assertion to verify title of the My Coach Page is commented out as TestCoachAlert for ClubUK User
		 * has a different title for the page for every other user. So, the below code is not applicable. As the title 
		 * of the page is changing dynamically for each type of user,the assertion for title is commented.
		 */ 
		//assertTrue("This is not My Coach Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Member Profile"), selenium);
	}
	
	/**
	 * Navigates to main Connect page
	 * @return
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ConnectPage(selenium);
	}
	
	/**
	 * Verifies UI of page
	 */
	public void verifyUI() {
		assertTrue("Coach Whistle Image not displayed", selenium.waitForElementPresent(MyCoach.COACH_WHISTLE_IMAGE), selenium);
		assertTrue("Coach Image not displayed", selenium.waitForElementPresent(MyCoach.COACH_IMAGE), selenium);
		assertTrue("Coach Tag Image not displayed", selenium.waitForElementPresent(MyCoach.COACH_TAG_IMAGE), selenium);
		//assertTrue("Facebook Like link not displayed", selenium.waitForElementPresent(MyCoach.FACEBOOK_LIKE_LINK), selenium);
		assertTrue("'Add as a Buddy' button not displayed", selenium.waitForElementPresent(MyCoach.ADD_AS_A_BUDDY_BUTTON), selenium);
		assertTrue("'Report this Page' Link not displayed", selenium.waitForElementPresent(MyCoach.REPORT_THIS_PAGE_LINK), selenium);
		assertTrue("'Coach Before Image' not displayed", selenium.waitForElementPresent(MyCoach.COACH_BEFORE_IMAGE), selenium);
		assertTrue("'Coach After Image' not displayed", selenium.waitForElementPresent(MyCoach.COACH_AFTER_IMAGE), selenium);
	}
	
	/**
	 * Returns Coach's Fitness Goal
	 */
	public String getFitnessGoal() {
		return selenium.getText(MyCoach.COACH_FITNESS_GOAL);
	}	
	
	/**
	 * Returns Coach's Introduction Text
	 */
	public String getIntroductionText() {
		return selenium.getText(MyCoach.COACH_INTRODUCTION_TEXT);
	}	
	
	/**
	 * Returns Coach's Meal Plan
	 */
	public String getMealPlan() {
		return selenium.getText(MyCoach.COACH_MEAL_PLAN);
	}	
	
	/**
	 * Returns number of Workout Programs shown on page
	 */
	public int workoutProgramsCount() {
		return selenium.getXpathCount(MyCoach.COACH_WORKOUT_PROGRAMS	).intValue();
	}
	
	/**
	 * Returns titles of Workout Programs
	 */
	public ArrayList<String> getWorkoutProgramsTitles() {
		ArrayList<String> workoutProgramsTitles = new ArrayList<String>();
		int workoutProgramsCount = workoutProgramsCount();
		for(int i=1; i<=workoutProgramsCount; i++) {
			workoutProgramsTitles.add(selenium.getText(MyCoach.COACH_WORKOUT_PROGRAMS + "[" + i + "]"));
			if(i==5) {
				if(selenium.isElementPresent(MyCoach.COACH_WORKOUT_PROGRAMS_BLOCK)) {
					int blockItemCount = selenium.getXpathCount(MyCoach.COACH_WORKOUT_PROGRAMS_BLOCK + "/div").intValue();
					for(int j=1; j<=blockItemCount; j++) {
						workoutProgramsTitles.add(selenium.getText(MyCoach.COACH_WORKOUT_PROGRAMS_BLOCK + "/div" + "[" + j + "]"));
					}
				}
				break;
			}
		}
		return workoutProgramsTitles;
	}	
	
	/**
	 * Returns number of Gear Accessories shown on page
	 */
	public int gearCount() {
		return selenium.getXpathCount(MyCoach.COACH_GEAR_ACCESSORIES).intValue();
	}
	
	/**
	 * Returns titles of Gear Accessories
	 */
	public ArrayList<String> getGearTitles() {
		ArrayList<String> gearTitles = new ArrayList<String>();
		for(int i=1; i<=gearCount(); i++) {
			gearTitles.add(selenium.getText(MyCoach.COACH_GEAR_ACCESSORIES + "[" + i + "]"));
		}
		return gearTitles;
	}
	
	/**
	 * Returns number of Supplements shown on page
	 */
	public int supplementsCount() {
		return selenium.getXpathCount(MyCoach.COACH_SUPPLEMENTS).intValue();
	}
	
	/**
	 * Returns titles of Supplements
	 */
	public ArrayList<String> getSupplementTitles() {
		ArrayList<String> supplementTitles = new ArrayList<String>();
		for(int i=1; i<=supplementsCount(); i++) {
			supplementTitles.add(selenium.getText(MyCoach.COACH_SUPPLEMENTS + "[" + i + "]"));
		}
		return supplementTitles;
	}	
	
	/**
	 * Returns SuperGym Stattistics
	 */
	public String[] getSuperGymStatistics() {
		String[] stats = new String[3];
		stats[0] = selenium.getText(MyCoach.STATS_TOTAL_WORKOUTS_COMPLETED_TODAY);
		stats[1] = selenium.getText(MyCoach.STATS_TODAY_PEAK);
		stats[2] = selenium.getText(MyCoach.STATS_PEOPLE_WORKING_OUT_NOW);
		return stats;
	}	
	
	/**
	 * Returns count of workout groups
	 */
	public int workoutGroupsCount() {
		return selenium.getXpathCount(MyCoach.COACH_WORKOUT_GROUPS).intValue();
	}
	
	/**
	 * Returns list of workout groups
	 */
	public ArrayList<String> getWorkoutGroups() {
		ArrayList<String> workoutGroups = new ArrayList<String>();
		for(int i=1; i<=workoutGroupsCount(); i++) {
			workoutGroups.add(selenium.getText(MyCoach.COACH_WORKOUT_GROUPS + "[" + i + "]"));
		}
		return workoutGroups;
	}
		
	/**
	 * Returns coach next workout
	 */
	public String getNextWorkouts() {
		return selenium.getText(MyCoach.COACH_NEXT_WORKOUTS);
	}
	
	/**
	 * Returns Buddies Count
	 */
	public String getBuddiesCount() {
		return selenium.getText(MyCoach.COACH_BUDDIES_COUNT);
	}
}