package com.tbb.testscripts.eatsmart;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.EatSmart;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.eatsmart.MichisLadderPage;
import com.tbb.pages.eatsmart.MyMealPlannerPage;
import com.tbb.pages.eatsmart.NutritionTipsPage;
import com.tbb.pages.eatsmart.NutritionToolsPage;
import com.tbb.pages.eatsmart.RecipesPage;
import com.tbb.pages.eatsmart.ShakeologyAndSupplementsPage;
import com.tbb.pages.eatsmart.ShakeologyRecipesPage;


/**
 * 
 * This test script contains test method(s) for main Eat-Smart page/tab.
 * @author Jaya
 */
public class TestEatSmart extends BaseTest implements EatSmart{

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
	
	/**
	 * Positive Test script for verifying viewing of Eat Smart Page.
	 * It verifies if all the required elements are present on the left hand side Eat Smart menu. 
	 */ 
	@Test 
	public void testMenuLinks(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Eat Smart' link");
		selenium.logComment("Verifying number of links in left side Menu");
		selenium.logComment("Verifying Links' title shown in left side Menu");
		selenium.logComment("Clicking on 'My Meal Planner' Link from left side menu");
		selenium.logComment("Clicking on 'Recipes' Link from left side menu");
		selenium.logComment("Clicking on 'Shakeology Recipes' Link from left side menu");
		selenium.logComment("Clicking on 'Nutrition Tools' Link from left side menu");
		selenium.logComment("Clicking on 'Nutrition Tips' Link from left side menu");
		selenium.logComment("Clicking on 'Shakeology And Supplements Page' Link from left side menu");
		selenium.logComment("Clicking on 'Michi's Ladder' Link from left side menu");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Clicking on 'Eat Smart' link");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();
		
		selenium.logComment("Verifying number of links in left side Menu");
		assertTrue("All links are not displayed", eatSmartPage.getMenuLinksCount()==7, selenium );
		
		selenium.logComment("Verifying Links' title shown in left side Menu");
		assertTrue("Expected Links are not displayed", Arrays.equals(eatSmartPage.getMenuLinksText(), new String[]{"My Meal Planner","Recipes", "Shakeology Recipes", "Nutrition Tools", "Nutrition Tips", "Shakeology & Supplements", "Michi's Ladder"}), selenium);
		
		selenium.logComment("Clicking on 'My Meal Planner' Link from left side menu");
		MyMealPlannerPage myMealPlannerPage = eatSmartPage.goToMyMealPlannerPage();
		eatSmartPage = myMealPlannerPage.clickEatSmartLink();
		
		selenium.logComment("Clicking on 'Recipes' Link from left side menu");
		RecipesPage recipesPage = eatSmartPage.goToRecipesPage();
		eatSmartPage = recipesPage.clickEatSmartLink();
		
		selenium.logComment("Clicking on 'Shakeology Recipes' Link from left side menu");
		ShakeologyRecipesPage shakeologyRecipesPage = eatSmartPage.goToShakeologyRecipesPage();
		eatSmartPage = shakeologyRecipesPage.clickEatSmartLink();		
		
		selenium.logComment("Clicking on 'Nutrition Tools' Link from left side menu");
		NutritionToolsPage nutritionToolsPage = eatSmartPage.goToNutritionToolsPage();
		eatSmartPage = nutritionToolsPage.clickEatSmartLink();
		
		selenium.logComment("Clicking on 'Nutrition Tips' Link from left side menu");
		NutritionTipsPage nutritionTipsPage = eatSmartPage.goToNutritionTipsPage();
		eatSmartPage = nutritionTipsPage.clickEatSmartLink();
		
		selenium.logComment("Clicking on 'Shakeology And Supplements Page' Link from left side menu");
		ShakeologyAndSupplementsPage shakeologyAndSupplementsPage = eatSmartPage.goToShakeologyAndSupplementsPage();
		eatSmartPage = shakeologyAndSupplementsPage.clickEatSmartLink();
		
		selenium.logComment("Clicking on 'Michi's Ladder' Link from left side menu");
		MichisLadderPage michisLadderPage = eatSmartPage.goToMichisLadderPage();
		eatSmartPage = michisLadderPage.clickEatSmartLink();			
			
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
	
	/**
	 * Positive Test script for verifying viewing of Eat Smart Page.
	 * It verifies if all the required elements are present on the centre page content. 
	 */ 
	@Test 
	public void testEatSmartPageContent() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Eat Smart Page.");
		selenium.logComment("Verifying number of links in right side content area");
		selenium.logComment("Verifying title headings in right side content area");
		selenium.logComment("Verifying that all the required fields are present on the Eat Smart Page.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");		
		
		
		
		selenium.logComment("Verifying whether user is on Home page");
		HomePage homePage = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Navigating to Eat Smart Page.");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();
		
		selenium.logComment("Verifying number of links in right side content area");
		assertTrue("All links are not displayed", eatSmartPage.getContentLinksCount()==7, selenium );
		
		selenium.logComment("Verifying title headings in right side content area");
		assertTrue("Expected headings are not displayed", Arrays.equals(eatSmartPage.getContentLinksText(), new String[]{"My Meal Planner","Recipes", "Shakeology® Recipes", "Nutrition Tools", "Nutrition Tips", "Supplements", "Michi's Ladder"}), selenium);
		
		selenium.logComment("Verifying that all the required fields are present on the Eat Smart Page.");
		assertTrue("Expected Page header 'Eat Smart' is not available", selenium.isElementPresent(EAT_SMART_PAGE_HEADER), selenium);
		assertTrue("Expected text 'A great fitness...' is not available", selenium.isTextPresent("A great fitness program and a healthy diet go hand in hand. Team Beachbody makes it easy for you to lose weight while eating delicious food. With a nutritious diet and a fun workout program you'll be seeing results in no time."), selenium);
		assertTrue("Expected text 'Featured this week' is not available", selenium.isTextPresent("Featured this week"), selenium);
		assertTrue("There are no links displayed under 'Featured this week'", selenium.getXpathCount(EatSmart.CONTENT_HEADER_FEARURED_LINKS).intValue() > 0, selenium);
		assertTrue("Expected user stats are not available", selenium.isElementPresent(USER_STATS), selenium);
		
		assertTrue("Expected My Meal Planner image is not available", selenium.isElementPresent(MY_MEAL_PLANNER_IMAGE), selenium);
		assertTrue("Expected text 'Whether you...' is not available", selenium.isTextPresent("Whether you're trying to lose weight, get fit and ripped, or just eat healthier, finding the right meal plan is the perfect way to start. Team Beachbody will help you make great food choices so you can maximize your results."), selenium);
		assertTrue("Expected My Meal Planner Learn More link is not available", selenium.isElementPresent(MY_MEAL_PLANNER_LEARN_MORE_LINK), selenium);
		
		assertTrue("Expected Recipes image is not available", selenium.isElementPresent(RECIPES_IMAGE), selenium);
		assertTrue("Expected text 'Eating well...' is not available", selenium.isTextPresent("Eating well doesn't have to be time-consuming or complicated, and it should always taste great. Team Beachbody has hundreds of healthy, satisfying recipes that your whole family will love. With options for breakfast, lunch, and dinner you'll lose fat and gain lean muscle without ever feeling deprived."), selenium);
		assertTrue("Expected Recipes Learn More link is not available", selenium.isElementPresent(RECIPES_LEARN_MORE_LINK), selenium);
		
		assertTrue("Expected Recipes image is not available", selenium.isElementPresent(SHAKEOLOGY_IMAGE), selenium);
		assertTrue("Expected text 'Eating well...' is not available", selenium.isTextPresent("We searched the world for the most potent whole-food ingredients available for health, energy, and weight loss, and combined them with great taste in one delicious shake. The result is the Healthiest Meal of the Day®. It's the easiest way to get more of the nutrients you need every day.* Choose any of our recipes—all starting at 140 calories per serving. "), selenium);
		assertTrue("Expected Recipes Learn More link is not available", selenium.isElementPresent(SHAKEOLOGY_LEARN_MORE_LINK), selenium);
		
		assertTrue("Expected Nutrition Tools image is not available", selenium.isElementPresent(NUTRITION_TOOLS_IMAGE), selenium);
		assertTrue("Expected text 'Lose weight...' is not available", selenium.isTextPresent("Lose weight and keep your metabolism fired up with the help of Team Beachbody's Nutrition Tools. You'll learn how to determine your body fat, find a healthy target weight, and figure out how many calories you should eat each day to achieve your perfect body."), selenium);
		assertTrue("Expected Nutrition Tools Learn More link is not available", selenium.isElementPresent(NUTRITION_TOOLS_LEARN_MORE_LINK), selenium);
		
		assertTrue("Expected Nutrition Tips image is not available", selenium.isElementPresent(NUTRITION_TIPS_IMAGE), selenium);
		assertTrue("Expected text 'Team Beachbody diet...' is not available", selenium.isTextPresent("Team Beachbody diet experts share their tips on how to eat smart every day. They will help you solve all of your diet dilemmas with practical, easy-to-follow suggestions for staying on track and enjoying your food."), selenium);
		assertTrue("Expected Nutrition Tips Learn More link is not available", selenium.isElementPresent(NUTRITION_TIPS_LEARN_MORE_LINK), selenium);
		
		assertTrue("Expected Supplements image is not available", selenium.isElementPresent(SUPPLEMENTS_IMAGE), selenium);
		assertTrue("Expected text 'Reach your health...' is not available", selenium.isTextPresent("Reach your health and weight-loss goals faster with the right supplements. Specifically tailored to complement Team Beachbody fitness programs, our supplements will help you lose fat, build lean, strong muscles, and boost your overall health."), selenium);
		assertTrue("Expected Supplements Learn More link is not available", selenium.isElementPresent(SUPPLEMENTS_LEARN_MORE_LINK), selenium);
		
		assertTrue("Expected Michi's ladder image is not available", selenium.isElementPresent(MICHIS_LADDER_IMAGE), selenium);
		assertTrue("Expected text 'Michi's ladder is...' is not available", selenium.isTextPresent("Michi's Ladder is a food guide that takes all the guesswork out of healthy eating. Foods are divided into tiers from best to worst choices, and all you have to do is eat from the top levels of the ladder to have a near-perfect diet."), selenium);
		assertTrue("Expected Michi's ladder Learn More link is not available", selenium.isElementPresent(MICHIS_LADDER_LEARN_MORE_LINK), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
	}  
}