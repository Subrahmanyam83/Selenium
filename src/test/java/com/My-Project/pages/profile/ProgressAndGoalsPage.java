package com.tbb.pages.profile;

import java.util.HashMap;
import java.util.Map;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.EatSmart;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.constants.UIRepository.ProgressAndGoalsTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
import com.tbb.pages.eatsmart.NutritionToolsPage;

/**
 * 
 * Page Object encapsulates the Personal Info Page
 * @author Jaya
 */

public class ProgressAndGoalsPage  extends BaseTest  implements ProgressAndGoalsTab {

	/**
	 * Validates the user is on Progress And Goals Page.
	 * @throws  IllegalStateException if the user is on a different page than Progress And Goals Page.
	 */
	public ProgressAndGoalsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Progress And Goals Page");
		assertTrue("This is not Edit Profile: Progress And Goals Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Edit Profile: Progess and Goals"), selenium);
	}	

	/**
	 * This function allows user to navigate to edit mode of Overall Goal and Fitness Story. 
	 */
	public ProgressAndGoalsPage clickEditOverallGoalAndFitnessStoryLink(){
		selenium.click(EDIT_LINK);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ProgressAndGoalsPage(selenium);
	}

	/**
	 * This function allows user to navigate to edit mode of Overall Goal and Fitness Story. 
	 * @param 	goal
	 */
	public void selectGoal(String goal){
		selenium.select(OVERALL_GOAL, goal);
	}	

	/**
	 * This function allows user to select Work out start date of Overall Goal and Fitness Story. 
	 * @param month
	 * @param day
	 * @param year
	 */
	public void selectWorkOutStartDateUsingDropdowns(String month, String day, String year){
		selenium.select(WORKOUT_START_MONTH_DROPDOWN, month);
		selenium.select(WORKOUT_START_DAY_DROPDOWN, day);
		selenium.select(WORKOUT_START_YEAR_DROPDOWN, year);
	}	

	/**
	 * Allows user to select work out start day of overall goal and fitness story
	 * @param day
	 */
	public void selectWorkOutStartDateUsingDropdowns(String day){
		selenium.select(WORKOUT_START_DAY_DROPDOWN, day);
	}
	
	/**
	 * This function allows user to select measurement units of Overall Goal and Fitness Story. 
	 * @param measureUnit
	 */
	public void selectMeasurementUnit(String measureUnit){
		selenium.select(MEASUREMENT_UNIT_DROPDOWN, measureUnit);
	}	

	/**
	 * This function allows user to enter his transformation story.  
	 * @param myTransformationStory
	 */
	public void enterTransformationStory(String myTransformationStory){
		selenium.type(STORY_TEXTAREA, myTransformationStory);
	}	

	/**
	 * This function clicks on the save button on Progress and Goals Page.
	 * @return	ProgressAndGoalsPage
	 */	
	public ProgressAndGoalsPage saveGoalAndFitnessStory(){
		selenium.click(SAVE_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProgressAndGoalsPage(selenium);
	}

	/**
	 * This function clicks on the Reset button on Progress and Goals Page.
	 */	
	public void resetGoalAndFitnessStory(){
		selenium.click(RESET_BUTTON);
	}	

	/**
	 * This function returns all the existing values shown on the Progress and Goals Page.  
	 * @return map
	 */	
	public Map<String, String> getExistingFormData() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(OVERALL_GOAL, selenium.getText(OVERALL_GOAL));
		map.put(WORKOUT_START_MONTH_DROPDOWN, selenium.getSelectedValue(WORKOUT_START_MONTH_DROPDOWN));
		map.put(WORKOUT_START_DAY_DROPDOWN, selenium.getSelectedValue(WORKOUT_START_DAY_DROPDOWN));
		map.put(WORKOUT_START_YEAR_DROPDOWN, selenium.getSelectedValue(WORKOUT_START_YEAR_DROPDOWN));
		map.put(MEASUREMENT_UNIT_DROPDOWN, selenium.getSelectedValue(MEASUREMENT_UNIT_DROPDOWN));
		map.put(STORY_TEXTAREA, selenium.getText(STORY_TEXTAREA));
		return map;
	}

	/**
	 * This function puts the starting measurements on the page.   
	 * @param weight, waist, hips, chest, rightArm, leftArm, rightThigh, leftThigh
	 * @param bodyFat, cholesterolHDL, String cholesterolLDL, bloodPressureSYS, bloodPressureDIA
	 */	
	public void addStartingMeasurements(String weight, String waist, 
			String hips, String chest, String rightArm, String leftArm, 
			String rightThigh, String leftThigh, String bodyFat, 
			String cholesterolHDL, String cholesterolLDL, 
			String bloodPressureSYS, String bloodPressureDIA) {
		selenium.type(STARTING_WEIGHT, weight);
		selenium.type(STARTING_WAIST, waist);
		selenium.type(STARTING_HIPS, hips);
		selenium.type(STARTING_CHEST, chest);
		selenium.type(STARTING_RIGHT_ARM, rightArm);
		selenium.type(STARTING_LEFT_ARM, leftArm);		
		selenium.type(STARTING_RIGHT_THIGH, rightThigh);
		selenium.type(STARTING_LEFT_THIGH, leftThigh);
		selenium.type(STARTING_BODY_FAT_PERCENT, bodyFat);
		selenium.type(STARTING_CHOLESTEROL_HDL, cholesterolHDL);
		selenium.type(STARTING_CHOLESTEROL_LDL, cholesterolLDL);
		selenium.type(STARTING_BLOOD_PRESSURE_SYS, bloodPressureSYS);
		selenium.type(STARTING_BLOOD_PRESSURE_DIA, bloodPressureDIA);
	}

	/**
	 * This function puts the projected measurements on the page.   
	 * @param weight, waist, hips, chest, rightArm, leftArm, rightThigh, leftThigh, bodyFat 
	 * @param cholesterolHDL, cholesterolLDL, bloodPressureSYS, bloodPressureDIA
	 */	
	public void addProjectedGoalMeasurements(String weight, String waist, 
			String hips, String chest, String rightArm, String leftArm, 
			String rightThigh, String leftThigh, String bodyFat, 
			String cholesterolHDL, String cholesterolLDL, 
			String bloodPressureSYS, String bloodPressureDIA) {
		selenium.type(PROJECTED_WEIGHT, weight);
		selenium.type(PROJECTED_WAIST, waist);
		selenium.type(PROJECTED_HIPS, hips);
		selenium.type(PROJECTED_CHEST, chest);
		selenium.type(PROJECTED_RIGHT_ARM, rightArm);
		selenium.type(PROJECTED_LEFT_ARM, leftArm);		
		selenium.type(PROJECTED_RIGHT_THIGH, rightThigh);
		selenium.type(PROJECTED_LEFT_THIGH, leftThigh);
		selenium.type(PROJECTED_BODY_FAT_PERCENT, bodyFat);
		selenium.type(PROJECTED_CHOLESTEROL_HDL, cholesterolHDL);
		selenium.type(PROJECTED_CHOLESTEROL_LDL, cholesterolLDL);
		selenium.type(PROJECTED_BLOOD_PRESSURE_SYS, bloodPressureSYS);
		selenium.type(PROJECTED_BLOOD_PRESSURE_DIA, bloodPressureDIA);		
	}

	/**
	 * This function submits the Body Measurement Form on Progress And Goals Page.
	 * @return ProgressAndGoalsPage
	 */	
	public ProgressAndGoalsPage submitBodyMeasurementFirstTime() {
		selenium.click(SUBMIT_BODY_MEASUREMENT);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProgressAndGoalsPage(selenium);
	}

	/**
	 * This function puts the Starting measurements for Fitness Stats Form on Progress And Goals Page.   
	 * @param  startMorningRestingHeartRate
	 * @param  startPullUps, startVerticalLeap
	 * @param  startPushUpsFromToes, startInchesFromToes
	 * @param  startInsAndOutsToFailure, startSeatedWallSquatMin
	 * @param  startSeatedWallSquatSec, startArmCurlsToFailureHash
	 * @param  startArmCurlsToFailureBy, startHeartRateMaximizer1
	 * @param  startHeartRateMaximizer3
	 */	
	public void addStartingFitnessStats(String startMorningRestingHeartRate,
			String startPullUps, String startVerticalLeap,
			String startPushUpsFromToes, String startInchesFromToes,
			String startInsAndOutsToFailure, String startSeatedWallSquatMin,
			String startSeatedWallSquatSec, String startArmCurlsToFailureHash, 
			String startArmCurlsToFailureBy, String startHeartRateMaximizer1,
			String startHeartRateMaximizer3) {
		selenium.type(STARTING_MORNING_RESTING_HEART_RATE, startMorningRestingHeartRate);
		selenium.type(STARTING_PULL_UPS, startPullUps);
		selenium.type(STARTING_VERTICAL_LEAP, startVerticalLeap);
		selenium.type(STARTING_PUSH_UPS_FROM_TOES, startPushUpsFromToes);
		selenium.type(STARTING_INCHES_FROM_TOES, startInchesFromToes);
		selenium.type(STARTING_INS_AND_OUTS_TO_FAILURE, startInsAndOutsToFailure);
		selenium.type(STARTING_SEATED_WALL_SQUAT_MIN, startSeatedWallSquatMin);
		selenium.type(STARTING_SEATED_WALL_SQUAT_SEC, startSeatedWallSquatSec);
		selenium.type(STARTING_ARM_CURLS_TO_FAILURE_HASH, startArmCurlsToFailureHash);
		selenium.type(STARTING_ARM_CURLS_TO_FAILURE_BY, startArmCurlsToFailureBy);
		selenium.type(STARTING_HEART_RATE_MAXIMIZER_1ST, startHeartRateMaximizer1);
		selenium.type(STARTING_HEART_RATE_MAXIMIZER_3RD, startHeartRateMaximizer3);
	}

	/**
	 * This function puts the Projected measurements for Fitness Stats Form on Progress And Goals Page.   
	 * @param goalMorningRestingHeartRate
	 * @param goalPullUps, goalVerticalLeap
	 * @param goalPushUpsFromToes, goalInchesFromToes
	 * @param goalInsAndOutsToFailure, goalSeatedWallSquatMin
	 * @param goalSeatedWallSquatSec, goalArmCurlsToFailureHash
	 * @param goalArmCurlsToFailureBy goalHeartRateMaximizer1
	 * @param goalHeartRateMaximizer3
	 */	
	public void addGoalFitnessStats(String goalMorningRestingHeartRate,
			String goalPullUps, String goalVerticalLeap,
			String goalPushUpsFromToes, String goalInchesFromToes,
			String goalInsAndOutsToFailure, String goalSeatedWallSquatMin, 
			String goalSeatedWallSquatSec, String goalArmCurlsToFailureHash,
			String goalArmCurlsToFailureBy, String goalHeartRateMaximizer1,
			String goalHeartRateMaximizer3) {
		selenium.type(PROJECTED_MORNING_RESTING_HEART_RATE, goalMorningRestingHeartRate);
		selenium.type(PROJECTED_PULL_UPS, goalPullUps);
		selenium.type(PROJECTED_VERTICAL_LEAP, goalVerticalLeap);
		selenium.type(PROJECTED_PUSH_UPS_FROM_TOES, goalPushUpsFromToes);
		selenium.type(PROJECTED_INCHES_FROM_TOES, goalInchesFromToes);
		selenium.type(PROJECTED_INS_AND_OUTS_TO_FAILURE, goalInsAndOutsToFailure);
		selenium.type(PROJECTED_SEATED_WALL_SQUAT_MIN, goalSeatedWallSquatMin);
		selenium.type(PROJECTED_SEATED_WALL_SQUAT_SEC, goalSeatedWallSquatSec);
		selenium.type(PROJECTED_ARM_CURLS_TO_FAILURE_HASH, goalArmCurlsToFailureHash);
		selenium.type(PROJECTED_ARM_CURLS_TO_FAILURE_BY, goalArmCurlsToFailureBy);
		selenium.type(PROJECTED_HEART_RATE_MAXIMIZER_1ST, goalHeartRateMaximizer1);
		selenium.type(PROJECTED_HEART_RATE_MAXIMIZER_3RD, goalHeartRateMaximizer3);
	}

	/**
	 * This function submits the Fitness Stats on Progress And Goals Page.   
	 * @return ProgressAndGoalsPage
	 */	
	public ProgressAndGoalsPage submitFitnessStatsFirstTime() {
		selenium.click(SUBMIT_FITNESS_STATS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProgressAndGoalsPage(selenium);
	}
	
	/**
	 * Signs out the user from the web site.   
	 */
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);
	}

	/**
	 * Navigates to Nutrition Tools link in menu bar.
	 * @return NutritionToolsPage
	 */
	public NutritionToolsPage goToNutritionToolsPage() {
		selenium.click(Home.TBB_LOGO);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.click(Dashboard.EAT_SMART_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.click(EatSmart.NUTRITION_TOOLS_LEARN_MORE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new NutritionToolsPage(selenium);
	}
	
	/**
	 * Navigates user to Edit Profile Page
	 * @return	EditProfilePage
	 */	
	public EditProfilePage clickLRMProfileLink() {
		selenium.click(LRMProfile.LRM_PROFILE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EditProfilePage(selenium);
	}
}