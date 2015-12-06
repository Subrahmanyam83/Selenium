package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.CaloricNeedsTab;
import com.tbb.constants.UIRepository.EatSmart;
import com.tbb.constants.UIRepository.Home;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.profile.MyProfilePage;

/**
 * 
 * Page Object encapsulates the Caloric Needs Page
 * @author Jaya
 */
public class CaloricNeedsPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Caloric Needs Page.
	 * @param	selenium
	 */
	public CaloricNeedsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Caloric Needs Page");
		this.selenium = selenium;

		assertTrue("This is not Caloric Needs Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart: Nutrition Tools: Caloric Needs"), selenium);
	}
	
	/**
	 * Navigates user to Nutrition Tools Page. 
	 * @return NutritionToolsPage
	 */
	public NutritionToolsPage goToNutritionToolsPage() {
		selenium.click(EatSmart.NAV_MENU_NUTRITION_TOOLS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new NutritionToolsPage(selenium);
	}
	
	/**
	 * Navigates user to My Profile Page. 
	 * @return MyProfilePage
	 */
	public MyProfilePage clickProfile() {
		selenium.click(Home.PROFILE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyProfilePage(selenium);
	}
	
	/**
	 * Selects recent Program from the drop down. 
	 * @param recentProgram
	 */
	public void selectRecentBeachBodyProgram(String recentProgram) {
		selenium.select(CaloricNeedsTab.BEACHBODY_RECENTLY_COMPLETED_PROGRAM_DROPDOWN, recentProgram);
	}
	
	/**
	 * Selects specified goal from Goal drop down.
	 * @param goal
	 */
	public void selectGoal(String goal) {
		selenium.select(CaloricNeedsTab.GOAL_DROPDOWN, goal);
	}
	
	/**
	 * Selects Excercise option and then selects primary and secondary programs.
	 * @param exercisePerDayOption
	 * @param primaryProgram
	 * @param secondaryProgram
	 */
	public void selectExercisePerDay(String exercisePerDayOption, String primaryProgram, String secondaryProgram) {
		if (exercisePerDayOption.equals("Once a day")){
			selenium.click(CaloricNeedsTab.ONCE_A_DAY_RADIO_BUTTON);
			selenium.select(CaloricNeedsTab.PRIMARY_PROGRAM_DROPDOWN, primaryProgram);
		}
		else {
			selenium.click(CaloricNeedsTab.MORE_THAN_ONCE_A_DAY_RADIO_BUTTON);
			selenium.select(CaloricNeedsTab.PRIMARY_PROGRAM_DROPDOWN, primaryProgram);
			selenium.select(CaloricNeedsTab.SECONDARY_PROGRAM_DROPDOWN, secondaryProgram);
		}
	}
	
	/**
	 * Selects Activity level from drop down.
	 * @param activityLevel
	 */
	public void selectActivityLevel(String activityLevel) {
		selenium.select(CaloricNeedsTab.ACTIVITY_LEVEL_DROPDOWN, activityLevel);
	}
	
	/**
	 * Types height in Cm.
	 * @param heightCm
	 */
	public void enterHeightInCm(String heightCm) {
		selenium.type(CaloricNeedsTab.CM_TEXTBOX, heightCm);		
	}
	
	/**
	 * Selects the gender radio button. 
	 * @param gender
	 */
	public void selectGender(String gender) {
		if(gender.equals("Female"))
			selenium.click(CaloricNeedsTab.FEMALE_RADIO_BUTTON);
		else
			selenium.click(CaloricNeedsTab.MALE_RADIO_BUTTON);		
	}
	
	/**
	 * Types weight in Kg.
	 * @param weightKg
	 */
	public void enterWeightInKg(String weightKg) {
		selenium.type(CaloricNeedsTab.KG_TEXTBOX, weightKg);		
	}
	
	/**
	 * Types Height in Feet.
	 * @param heightFt
	 */
	public void enterHeightInFt(String heightFt) {
		selenium.type(CaloricNeedsTab.FT_TEXTBOX, heightFt);		
	}
	
	/**
	 * Types Height In Inches.
	 * @param heightIn
	 */
	public void enterHeightInIn(String heightIn) {
		selenium.type(CaloricNeedsTab.IN_TEXTBOX, heightIn);
	}
	
	/**
	 * Types weight in lbs.
	 * @param weightLbs
	 */
	public void enterWeightInLbs(String weightLbs) {
		selenium.type(CaloricNeedsTab.LBS_TEXTBOX, weightLbs);		
	}
	
	/**
	 * Clicks on Submit Button.
	 */
	public void clickSubmit() {
		selenium.click(CaloricNeedsTab.SUBMIT_BUTTON);		
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Enters age in textbox with label 'Years old'.
	 * @param age
	 */
	public void enterAge(String age) {
		selenium.type(CaloricNeedsTab.YEARS_OLD_TEXTBOX, age);		
	}
}