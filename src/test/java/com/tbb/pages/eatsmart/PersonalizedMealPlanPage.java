package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.PersonalizedMealPlan;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 *
 * Page Object encapsulates the Personalised Meal Plan Page
 *  @author Jaya
 */
public class PersonalizedMealPlanPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Personalised Meal Plan Page.
	 * @param	selenium
	 */
	public PersonalizedMealPlanPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Personalized Meal Plan Page");
		this.selenium = selenium;
		assertTrue("This is not Personalized Meal Plan Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Personalized Meal Plan"), selenium);
	}
	
	/**
	 * Selects daily calories number from the portlet. 
	 * @param dailyCalories
	 */
	public void selectDailyCalories(String dailyCalories) {
		selenium.select(PersonalizedMealPlan.MEAL_PLAN_PORTLET_CALORIES, dailyCalories);		
	}
	
	/**
	 * Clicks on 'I Accept...' button. Navigates user to Meal Plans Page. 
	 * @return MealPlansPage
	 */
	public MealPlansPage clickIAcceptButton() {
		selenium.click(PersonalizedMealPlan.MEAL_PLAN_SUBMIT);		
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MealPlansPage(selenium);
	}
}