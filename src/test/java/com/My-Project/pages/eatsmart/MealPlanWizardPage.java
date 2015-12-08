package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.MealPlanWizard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Meal Plan Wizard Page
 * @author Jaya
 */
public class MealPlanWizardPage  extends BaseTest  implements MealPlanWizard {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Meal Plan Wizard Page.
	 * @param	selenium
	 */
	public MealPlanWizardPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Meal Plan Wizard Page");
		this.selenium = selenium;
		assertTrue("This is not Meal Plan Wizard Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Meal Plans: Meal Plan Wizard"), selenium);
	}

	/**
	 * Navigates user to My Meal Planner Page.
	 * @return MyMealPlannerPage
	 */
	public MyMealPlannerPage clickMyMealPlannerLink(){
		selenium.click(MY_MEAL_PLANNER_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyMealPlannerPage(selenium);
	}

	/**
	 * Selects radio button for recent program information.
	 * @param recentProgram
	 */
	public void selectRecentBeachbodyProgram(String recentProgram) {
		if (recentProgram.equals("No, this is my first fitness program."))
			selenium.click(NO_THIS_IS_MY_FIRST_PROGRAM_RADIO_BUTTON);
		else if(recentProgram.equals("Yes, I recently completed P90X®, INSANITY®, Asylum™, or TurboFire®."))
			selenium.click(YES_I_RECENTLY_COMPLETED_P90X_RADIO_BUTTON);
		else
			selenium.click(YES_I_RECENTLY_COMPLETED_A_BEACHBODY_PROGRAM_OTHER_THAN_P90X_RADIO_BUTTON);
	}

	/**
	 * Selects one of the goal radio button.
	 * @param goal
	 */
	public void selectGoal(String goal) {
		if (goal.equals("Lose a lot of weight"))
			selenium.click(LOSE_A_LOT_OF_WEIGHT_RADIO_BUTTON);
		else if(goal.equals("Lose some weight"))
			selenium.click(LOSE_SOME_WEIGHT_RADIO_BUTTON);
		else if(goal.equals("Lose the last few pounds"))
			selenium.click(LOSE_THE_LAST_FEW_POUNDS_RADIO_BUTTON);
		else if (goal.equals("Same weight, but tone up or change my body shape"))
			selenium.click(SAME_WEIGHT_BUT_TONE_UP_OR_CHANGE_MY_BODY_SHAPE_RADIO_BUTTON);
		else
			selenium.click(GAIN_WEIGHT_AND_MUSCLE_RADIO_BUTTON);
	}

	/**
	 * Selects radio button for exercise per day options. Also selects primary program and secondary program (in case of more than once a day).
	 * @param exercisePerDay
	 * @param primaryProgram
	 * @param secondaryProgram
	 */
	public void selectExcercisePerDay(String exercisePerDay, String primaryProgram, String secondaryProgram) {
		if (exercisePerDay.equals("Once a day")){
			selenium.click(ONCE_A_DAY_RADIO_BUTTON);
			selenium.select(PRIMARY_PROGRAM_DROP_DOWN, primaryProgram);
		}
		else{
			selenium.click(MORE_THAN_ONCE_A_DAY);		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selenium.select(PRIMARY_PROGRAM_DROP_DOWN, primaryProgram);
			selenium.select(SECONDARY_PROGRAM_DROP_DOWN, secondaryProgram);
		}
	}

	/**
	 * Selects radio button from Activity Level options based on activityLevel value. 
	 * @param activityLevel
	 */
	public void selectActivityLevel(String activityLevel) {
		if (activityLevel.equals("Very active or athletic"))
			selenium.click(VERY_ACTIVE_OR_ATHLETIC_RADIO_BUTTON);
		else if (activityLevel.equals("Active"))
			selenium.click(ACTIVE_RADIO_BUTTON);
		else if (activityLevel.equals("Moderately active"))
			selenium.click(MODERATELY_ACTIVE_RADIO_BUTTON);
		else if (activityLevel.equals("Occasionally active"))
			selenium.click(OCCASIONALLY_ACTIVE_RADIO_BUTTON);
		else 
			selenium.click(SEDENTARY_RADIO_BUTTON);
	}

	/**
	 * Selects vegetarian diet option based on vegDietInfo value.
	 * @param vegDietInfo
	 */
	public void selectVegDietInfo(String vegDietInfo) {
		if (vegDietInfo.equals("Yes"))
			selenium.click(VEGDIET_YES_RADIO_BUTTON);
		else
			selenium.click(VEGDIET_NO_RADIO_BUTTON);
	}

	/**
	 * Selects gender option button based on gender value.
	 * @param gender
	 */
	public void selectGender(String gender) {
		if (gender.equals("Female"))
			selenium.click(FEMALE_RADIO_BUTTON);
		else
			selenium.click(MALE_RADIO_BUTTON);
	}
	
	/**
	 * Types user age in textbox for age. 
	 * @param age
	 */
	public void enterAge(String age) {
		selenium.type(AGE_TEXTBOX, age);
	}
	
	/**
	 * Types Height in Ft in Height textbox for Ft. 
	 * @param heightFt
	 */
	public void enterHeightFt(String heightFt) {
		selenium.type(HEIGHT_FT_TEXTBOX, heightFt);
	}

	/**
	 * Types Height in In in Height Textbox for In. 
	 * @param heightIn
	 */
	public void enterHeightIn(String heightIn) {
		selenium.type(HEIGHT_IN_TEXTBOX, heightIn);
	}

	/**
	 * Types weight in lbs in weight text box. 
	 * @param weightLbs
	 */
	public void enterWeightLbs(String weightLbs) {
		selenium.type(WEIGHT_TEXTBOX, weightLbs);
	}

	/**
	 * Clicks on Submit button to submit the Meal Wizard form.
	 * @return PersonalizedMealPlanPage
	 */
	public PersonalizedMealPlanPage clickSubmit() {
		selenium.click(SUBMIT_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new PersonalizedMealPlanPage(selenium);
	}
}