package com.tbb.testscripts.eatsmart;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.MyMealPlannerTab;
import com.tbb.constants.UIRepository.PersonalizedMealPlan;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.eatsmart.MealPlanWizardPage;
import com.tbb.pages.eatsmart.MealPlansPage;
import com.tbb.pages.eatsmart.MyMealPlannerPage;
import com.tbb.pages.eatsmart.PersonalizedMealPlanPage;
import com.tbb.pages.profile.MyProfilePage;


/**
 * 
 * This test script contains test method(s) for My Meal Planner page under Eat-Smart module
 * @author Jaya
 */
public class TestMyMealPlanner extends BaseTest implements MyMealPlannerTab, PersonalizedMealPlan{

	@BeforeClass
	public void setUp() {
		startSeleniumServer();
	}

	@BeforeMethod
	public void setUp(Method method) {
		createSeleniumInstance(method);
	}

	@AfterMethod
	public void stopSelenium() {
		stopSeleniumInstance();
	}

	@AfterClass
	public void tearDown() {
		stopSeleniumServer();
	}

	/***
	 * This is data provider for testViewMyMealPlan Test Script.
	 */ 
	@DataProvider(name = "viewMyMealPlannerDataProvider")
	public Object[][] createMealPlannerData() {
		return new Object[][] {
				{ "mgupta@beachbody.com", "b@b2011"},
		};
	}
	/***
	 * Positive Test script for viewing My Meal Planner Page.  
	 */ 
	@Test(dataProvider = "viewMyMealPlannerDataProvider")
	public void testViewMyMealPlanner(String userName,String password) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to My Meal Planner Page.");
		selenium.logComment("Verifying that all the required elements are present on My Meal Planner header section");
		selenium.logComment("Verifying that all the required elements are present on My Meal Planner Page");
		selenium.logComment("Verifying the button for Go to My Meal Planner. Navigates to Meal Plans page.");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to My Meal Planner Page");
		selenium.logComment("Verifying link for Change my Meal Plan. Navigates user to Meal Plan Wizard Page");
		selenium.logComment("Navigating to My Meal Planner Page");
		selenium.logComment("Verifying the required elements are available in Choose your new meal plan section");
		selenium.logComment("Verifying the 'Use the Meal Plan Wizard' button. Navigates user to Meal Plan Wizard Page.");
		selenium.logComment("Navigating to My Meal Planner Page");
		selenium.logComment("Verifying the required elements are available in Self Select your meal plan section");
		selenium.logComment("Clicking on 'Learn More' link under 'Balanced Slim Down Plan' content area");
		selenium.logComment("Clicking on 'Learn More' link under 'Active Lifestyle Plan' content area");
		selenium.logComment("Verifying that 'Choose Plan' dropdown and 'Select and Customize this plan' button is available.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}

		selenium.logComment("Navigating to My Meal Planner Page.");
		MyMealPlannerPage myMealPlannerPage = dashboardPage.clickMyMealPlannerLink();

		selenium.logComment("Verifying that all the required elements are present on My Meal Planner header section");
		assertTrue("Expected Header 'My Meal Planner' is unavailable.", selenium.isElementPresent(MY_MEAL_PLANNER_HEADER), selenium);
		assertTrue("Expected Text 'Team Beachbody makes it...' is unavailable.", selenium.isTextPresent("Team Beachbody® makes it easy to plan everything you’re going to eat, so you’ll always have delicious food that supports your fitness and your weight loss program. You can figure out your personal nutrition requirements, build and print out menus and shopping lists, and make sure you have plenty of variety so you’ll never get bored."), selenium);

		selenium.logComment("Verifying that all the required elements are present on My Meal Planner Page");
		assertTrue("Expected Header 'My Personalized Meal Plan' is unavailable.", selenium.isElementPresent(MY_PERSONALIZED_MEAL_PLAN_LABEL), selenium);
		assertTrue("Expected Text 'Remember, the more you...' is unavailable.", selenium.isElementPresent(MY_PERSONALIZED_MEAL_PLAN_TEXT), selenium);
		assertTrue("Expected Button 'Go to My Meal Planner' is unavailable.", selenium.isElementPresent(GO_TO_MY_MEAL_PLANNER_BUTTON), selenium);
		assertTrue("Expected Link 'Change my meal plan' is unavailable.", selenium.isElementPresent(CHANGE_MY_MEAL_PLAN_LINK), selenium);

		selenium.logComment("Verifying the button for Go to My Meal Planner. Navigates to Meal Plans page.");
		MealPlansPage mealPlansPage = myMealPlannerPage.goToMyMealPlanner();

		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = mealPlansPage.clickEatSmartLink();

		selenium.logComment("Navigating to My Meal Planner Page");
		myMealPlannerPage = eatSmartPage.goToMyMealPlannerPage();		

		selenium.logComment("Verifying link for Change my Meal Plan. Navigates user to Meal Plan Wizard Page");
		MealPlanWizardPage mealPlanWizardPage = myMealPlannerPage.ChangeMyMealPlan();

		selenium.logComment("Navigating to My Meal Planner Page");
		myMealPlannerPage = mealPlanWizardPage.clickMyMealPlannerLink();

		selenium.logComment("Verifying the required elements are available in Choose your new meal plan section");
		assertTrue("Expected Label 'Choose your new meal plan' is unavailable.", selenium.isElementPresent(CHOOSE_YOUR_NEW_MEAL_PLAN_LABEL), selenium);
		assertTrue("Expected paragraph for 'Choose your new meal plan' is unavailable.", selenium.isElementPresent(CHOOSE_YOUR_NEW_MEAL_PLAN_PARAGRAPH), selenium);
		assertTrue("Expected image for 'Meal Plan Wizard' is unavailable.", selenium.isElementPresent(MEAL_PLAN_WIZARD_IMAGE), selenium);
		assertTrue("Expected Header 'Meal Plan Wizard' is unavailable.", selenium.isElementPresent(MEAL_PLAN_WIZARD_LABEL), selenium);
		assertTrue("Expected Text 'The best way...' is unavailable.", selenium.isTextPresent("The best way to select a plan is with the Meal Plan Wizard. By asking a few simple questions, it'll determine the kinds of food and daily calorie levels that are ideal for your fitness and weight loss goals, especially if you're using a Beachbody workout program. (You'll still be able to select a different plan if you want. And whichever plan you choose, you'll be able to personalize it with your favorite foods.)"), selenium);
		assertTrue("Expected Button 'Use the Meal Plan Wizard' is unavailable.", selenium.isElementPresent(USE_THE_MEAL_PLAN_WIZARD_BUTTON), selenium);

		selenium.logComment("Verifying the 'Use the Meal Plan Wizard' button. Navigates user to Meal Plan Wizard Page.");	
		mealPlanWizardPage = myMealPlannerPage.useTheMealPlanWizard();

		selenium.logComment("Navigating to My Meal Planner Page");
		myMealPlannerPage = mealPlanWizardPage.clickMyMealPlannerLink();

		selenium.logComment("Verifying the required elements are available in Self Select your meal plan section");
		assertTrue("Expected Label 'Self Select your meal plan' is unavailable.", selenium.isElementPresent(SELF_SELECT_YOUR_MEAL_PLAN_LABEL), selenium);
		assertTrue("Expected text for 'Self Select your meal plan' is unavailable.", selenium.isElementPresent(SELF_SELECT_YOUR_MEAL_PLAN_TEXT), selenium);
		
		selenium.logComment("Clicking on 'Learn More' link under 'Balanced Slim Down Plan' content area");
		myMealPlannerPage.clickBalancedSlimDownPlanLearnMore();
		assertTrue("Expected title 'Balanced Slim Down Plan' is unavailable.", selenium.isElementPresent(BALANCED_SLIM_DOWN_PLAN_POPUP_TITLE), selenium);
		myMealPlannerPage.closeBalancedSlimDownPlanLink();

		selenium.logComment("Clicking on 'Learn More' link under 'Low-Carb Express Plan' content area");
		myMealPlannerPage.clickLowCarbExpressPlanLearnMore();
		assertTrue("Expected title 'Low-Carb Express Plan' is unavailable.", selenium.isElementPresent(LOW_CARB_EXPRESS_PLAN_POPUP_TITLE), selenium);
		myMealPlannerPage.closeLowCarbExpressPlanLink();

		selenium.logComment("Clicking on 'Learn More' link under 'Power Vegetarian Plan' content area");
		myMealPlannerPage.clickPowerVegetarianPlanLearnMore();
		assertTrue("Expected title 'Power Vegetarian Plan' is unavailable.", selenium.isElementPresent(POWER_VEGETARIAN_PLAN_POPUP_TITLE), selenium);
		myMealPlannerPage.closePowerVegetarianPlanPlanLink();

		selenium.logComment("Clicking on 'Learn More' link under 'Active Lifestyle Plan' content area");
		myMealPlannerPage.clickActiveLifestylePlanLearnMore();
		assertTrue("Expected title 'Active Lifestyle Plan' is unavailable.", selenium.isElementPresent(ACTIVE_LIFESTYLE_PLAN_POPUP_TITLE), selenium);
		myMealPlannerPage.closeActiveLifestylePlanLink();	

		selenium.logComment("Verifying that 'Choose Plan' dropdown and 'Select and Customize this plan' button is available.");
		assertTrue("Expected drop down for 'Choose Plan' is unavailable.", selenium.isElementPresent(CHOOSE_PLAN_DROP_DOWN), selenium);
		assertTrue("Expected button for 'Select and customize this plan' is unavailable.", selenium.isElementPresent(SELECT_AND_CUSTOMIZE_THIS_PLAN_BUTTON), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
	}		
	/***
	 * This is data provider for testChooseMyMealPlan Test Script.
	 */ 
	@DataProvider(name = "chooseMyMealPlannerDataProvider")
	public Object[][] createChooseMyMealPlannerData() {
		return new Object[][] {
				{ "Active Lifestyle", "1700"},
				{ "Balanced Slim Down", "1300"},
				{ "Low-Carb Express", "2400"},
				{ "Power Vegetarian", "2100"},
		};
	}
	/***
	 * Positive Test script for changing My Meal Plan.  
	 */ 
	@Test(dataProvider = "chooseMyMealPlannerDataProvider")
	public void testChooseMyMealPlan(String plan, String dailyCalories) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to My Meal Planner Page.");
		selenium.logComment("Choosing Meal Plan from dropdown.");
		selenium.logComment("Clicking on 'Select and Customize' button.");
		selenium.logComment("Select daily calorie intake from drop down.");
		selenium.logComment("Clicking on 'I Accept' button.");
		selenium.logComment("Verifying that the plan and calories are displayed correctly on Meal Plans Page.");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to My Meal Planner Page");
		selenium.logComment("Verifying that the plan and calories are saved correctly.");
		selenium.logComment("Navigating to Dashboard Page");
		selenium.logComment("Verifying that the plan and calories are displayed correctly on Dashboard.");
		selenium.logComment("Navigating to Profile Page");
		selenium.logComment("Verifying that the plan and calories are displayed on Profile page.");
		selenium.logComment("Navigating to Programs Page");
		selenium.logComment("Verifying that the plan and calories are displayed on Programs page.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}

		selenium.logComment("Navigating to My Meal Planner Page.");
		MyMealPlannerPage myMealPlannerPage = dashboardPage.clickMyMealPlannerLink();

		selenium.logComment("Choosing Meal Plan from dropdown.");
		myMealPlannerPage.choosePlan(plan);

		selenium.logComment("Clicking on 'Select and Customize' button.");
		PersonalizedMealPlanPage personalizedMealPlanPage = myMealPlannerPage.selectAndCustomizeThisPlan();

		selenium.logComment("Select daily calorie intake from drop down.");
		personalizedMealPlanPage.selectDailyCalories(dailyCalories);

		selenium.logComment("Clicking on 'I Accept' button.");
		MealPlansPage mealPlansPage = personalizedMealPlanPage.clickIAcceptButton();

		selenium.logComment("Verifying that the plan and calories are displayed correctly on Meal Plans Page.");
		if (plan.equals("Power Vegetarian"))
			assertTrue("Expected text 'Your plan is...' is unavailable.", selenium.isTextPresent("Your plan is Vegetarian Plan at " +dailyCalories+ " calories."), selenium);
		else
			assertTrue("Expected text 'Your plan is...' is unavailable.", selenium.isTextPresent("Your plan is " +plan+ " at " +dailyCalories+ " calories."), selenium);

		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = mealPlansPage.clickEatSmartLink();

		selenium.logComment("Navigating to My Meal Planner Page");
		myMealPlannerPage = eatSmartPage.goToMyMealPlannerPage();

		selenium.logComment("Verifying that the plan and calories are saved correctly.");
		assertTrue("Selected Meal Plan is not saved.", selenium.isElementPresent("css=div#personalized-meal-plan-info:contains(" +plan+ ")"), selenium);
		assertTrue("Selected Calories are not saved.", selenium.isElementPresent("css=div#personalized-meal-plan-info:contains(" +dailyCalories+ ")"), selenium);

		selenium.logComment("Navigating to Dashboard Page");
		dashboardPage = eatSmartPage.clickDashboardLink();

		selenium.logComment("Verifying that the plan and calories are displayed correctly on Dashboard.");
		assertTrue("Selected Meal Plan is not displayed on dashboard.", selenium.isElementPresent("css=div.margin-bottom span:contains(" +plan+ ")"), selenium);
		assertTrue("Selected Calories are not displayed on dashboard.", selenium.isElementPresent("css=div.margin-bottom span:contains(" +dailyCalories+ ")"), selenium);

		selenium.logComment("Navigating to Profile Page");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();

		selenium.logComment("Verifying that the plan and calories are displayed on Profile page.");
		assertTrue("Expected text 'Your current meal...' is unavailable.", selenium.isTextPresent("Your current meal plan is: " +plan+ " at " +dailyCalories+ " calories."), selenium);

		selenium.logComment("Navigating to Programs Page");
		myProfilePage.clickEditPrograms();

		selenium.logComment("Verifying that the plan and calories are displayed on Programs page.");
		assertTrue("Expected text 'Your current meal...' is unavailable.", selenium.isTextPresent("Your current meal plan is: " +plan+ " at " +dailyCalories+ " calories."), selenium);
				
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}	

	/***
	 * This is data provider for testUseMealPlanWizard Test Script.
	 */ 
	@DataProvider(name = "useMealPlanWizardDataProvider")
	public Object[][] createMealPlanWizardData() {
		return new Object[][] {
				{ "No, this is my first fitness program.", "Lose a lot of weight", "Once a day", "None", "None", "Very active or athletic", "Yes", "Male", "30", "5", "8", "150"},
				{ "Yes, I recently completed P90X®, INSANITY®, Asylum™, or TurboFire®.", "Lose some weight", "More than once a day", "Cycling - 1 hour", "Swimming - 30 minutes", "Active", "No", "Female", "26", "5", "4", "135"},
				{ "Yes, I recently completed a Beachbody® program other than P90X®, INSANITY®, Asylum™, or TurboFire®", "Same weight, but tone up or change my body shape", "Once a day", "Running - 60 minutes", "None", "Very active or athletic", "No", "Male", "28", "6", "2", "160"},
		};
	}
	/***
	 * Positive Test script for using Meal Plan Wizard.  
	 */ 
	@Test(dataProvider = "useMealPlanWizardDataProvider")
	public void testUseMealPlanWizard(String recentProgram, String goal, String exercisePerDay, String primaryProgram, String secondaryProgram, String activityLevel, String vegDietInfo, String gender, String age, String heightFt, String heightIn, String weightLbs) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to My Meal Planner Page.");
		selenium.logComment("Clicking on Use The Meal Plan Wizard button.");
		selenium.logComment("Enter The Meal Plan Wizard form data.");
		selenium.logComment("Submit The Meal Plan Wizard form data.");
		selenium.logComment("Extract the value of plan and daily calories from Personalized Meal Plan page.");
		selenium.logComment("Clicking on 'I Accept' button.");
		selenium.logComment("Verifying that correct Personalized Meal Plan and calorie count is displayed.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}

		selenium.logComment("Navigating to My Meal Planner Page.");
		MyMealPlannerPage myMealPlannerPage = dashboardPage.clickMyMealPlannerLink();

		selenium.logComment("Clicking on Use The Meal Plan Wizard button.");
		MealPlanWizardPage mealPlanWizardPage = myMealPlannerPage.useTheMealPlanWizard();

		selenium.logComment("Enter The Meal Plan Wizard form data.");
		mealPlanWizardPage.selectRecentBeachbodyProgram(recentProgram);
		mealPlanWizardPage.selectGoal(goal);
		mealPlanWizardPage.selectExcercisePerDay(exercisePerDay, primaryProgram, secondaryProgram);
		mealPlanWizardPage.selectActivityLevel(activityLevel);
		mealPlanWizardPage.selectVegDietInfo(vegDietInfo);
		mealPlanWizardPage.selectGender(gender);
		mealPlanWizardPage.enterAge(age);
		mealPlanWizardPage.enterHeightFt(heightFt);
		mealPlanWizardPage.enterHeightIn(heightIn);
		mealPlanWizardPage.enterWeightLbs(weightLbs);

		selenium.logComment("Submit The Meal Plan Wizard form data.");
		PersonalizedMealPlanPage personalizedMealPlanPage = mealPlanWizardPage.clickSubmit();

		selenium.logComment("Extract the value of plan and daily calories from Personalized Meal Plan page.");
		String plan = selenium.getSelectedLabel(PLAN_DROP_DOWN);
		String dailyCalories = selenium.getSelectedLabel(DAILY_CALORIES_DROP_DOWN);

		selenium.logComment("Clicking on 'I Accept' button.");
		personalizedMealPlanPage.clickIAcceptButton();

		selenium.logComment("Verifying that correct Personalized Meal Plan and calorie count is displayed.");
		if (plan.equals("Power Vegetarian"))
			assertTrue("Expected text 'Your plan is...' is unavailable.", selenium.isTextPresent("Your plan is Vegetarian Plan at " +dailyCalories+ " calories."), selenium);
		else
			assertTrue("Expected text 'Your plan is...' is unavailable.", selenium.isTextPresent("Your plan is " +plan+ " at " +dailyCalories+ " calories."), selenium);
			
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}	
}