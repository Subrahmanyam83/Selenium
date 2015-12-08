package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.MyMealPlannerTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the My Meal Planner Page
 * @author Jaya
 */
public class MyMealPlannerPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on My Meal Planner Page.
	 * @param	selenium
	 */
	public MyMealPlannerPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of My Meal Planner Page");
		this.selenium = selenium;
		assertTrue("This is not My Meal Planner Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart: My Meal Planner"), selenium);
	}
	/**
	 * Navigate to Eat Smart Link
	 * @return EatSmartPage
	 */
	public EatSmartPage clickEatSmartLink() {
        selenium.click(Dashboard.EAT_SMART_MENU_LINK);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new EatSmartPage(selenium);
	}
	
	/**
	 * Clicks on 'Learn More' link in Balanced Slim Down plan section. 
	 */
	public void clickBalancedSlimDownPlanLearnMore() {
		selenium.click(MyMealPlannerTab.BALANCED_SLIM_DOWN_PLAN_LEARN_MORE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * Clicks on 'Close' button for Balanced Slim Down Plan. 
	 */
	public void closeBalancedSlimDownPlanLink() {
		selenium.click(MyMealPlannerTab.BALANCED_SLIM_DOWN_PLAN_CLOSE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * Clicks on 'Learn More' button for 'Low-Carb Express' Plan. 
	 */
	public void clickLowCarbExpressPlanLearnMore() {
		selenium.click(MyMealPlannerTab.LOW_CARB_EXPRESS_PLAN_LEARN_MORE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * Clicks on 'Close' button for Low-Carb Express Plan.
	 */
	public void closeLowCarbExpressPlanLink() {
		selenium.click(MyMealPlannerTab.LOW_CARB_EXPRESS_PLAN_CLOSE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * Clicks on 'Learn More' link for 'Power Vegetarian' Plan.
	 */
	public void clickPowerVegetarianPlanLearnMore() {
		selenium.click(MyMealPlannerTab.POWER_VEGETARIAN_PLAN_LEARN_MORE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Clicks on 'Close' button for Power Vegetarian Plan.
	 */
	public void closePowerVegetarianPlanPlanLink() {
		selenium.click(MyMealPlannerTab.POWER_VEGETARIAN_PLAN_CLOSE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Click on 'Learn More' link for 'Active Lifestyle' plan. 
	 */
	public void clickActiveLifestylePlanLearnMore() {
		selenium.click(MyMealPlannerTab.ACTIVE_LIFESTYLE_PLAN_LEARN_MORE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Click on 'Close' button for 'Active Lifestyle' plan. 
	 */
	public void closeActiveLifestylePlanLink() {
		selenium.click(MyMealPlannerTab.ACTIVE_LIFESTYLE_PLAN_CLOSE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	/**
	 * Click on 'Go to Meal Planner' button. 
	 * @return MealPlansPage
	 */
	public MealPlansPage goToMyMealPlanner() {
		selenium.click(MyMealPlannerTab.GO_TO_MY_MEAL_PLANNER_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MealPlansPage(selenium);
	}
	
	/**
	 * Click on 'Change my Meal Plan' link. 
	 * @return MealPlanWizardPage
	 */
	public MealPlanWizardPage ChangeMyMealPlan() {
		selenium.click(MyMealPlannerTab.CHANGE_MY_MEAL_PLAN_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MealPlanWizardPage(selenium);		
	}
	
	/**
	 * Click on 'Use the Meal Plan Wizard' button. 
	 * @return MealPlanWizardPage
	 */
	public MealPlanWizardPage useTheMealPlanWizard() {
		selenium.click(MyMealPlannerTab.USE_THE_MEAL_PLAN_WIZARD_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MealPlanWizardPage(selenium);
	}
	
	/**
	 * Select the plan from the drop down displaying a list of different meal plans. 
	 * @param plan
	 */
	public void choosePlan(String plan) {
		selenium.select(MyMealPlannerTab.CHOOSE_PLAN_DROP_DOWN, plan);		
	}
	
	/**
	 * Click on 'Select and Customize this plan' button. Navigates user to Personalized Meal Plan Page.
	 * @return PersonalizedMealPlanPage
	 */
	public PersonalizedMealPlanPage selectAndCustomizeThisPlan() {
		selenium.click(MyMealPlannerTab.SELECT_AND_CUSTOMIZE_THIS_PLAN_BUTTON);	
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new PersonalizedMealPlanPage(selenium);
	}	
}
