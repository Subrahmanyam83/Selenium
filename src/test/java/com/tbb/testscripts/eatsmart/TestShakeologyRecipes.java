package com.tbb.testscripts.eatsmart;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.Chocolate;
import com.tbb.constants.UIRepository.Greenberry;
import com.tbb.constants.UIRepository.RecipesTab;
import com.tbb.constants.UIRepository.ShakeologyRecipesTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.eatsmart.ShakeologyRecipesChocolatePage;
import com.tbb.pages.eatsmart.ShakeologyRecipesGreenberryPage;
import com.tbb.pages.eatsmart.ShakeologyRecipesPage;

/**
 * 
 * This test script contains test method(s) for Shakeology Receipes page under Eat-Smart module
 * @author Jaya
 */
public class TestShakeologyRecipes extends BaseTest implements RecipesTab{

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
	 * Test script for viewing Shakeology Recipes page as Free user. 
	 */
	@Test 
	public void testViewShakeologyRecipesPage() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Eat Smart' link");
		selenium.logComment("Clicking on 'Shakeology Recipes' link");
		selenium.logComment("Verifying that all the required elements are present on the recipes page.");
		selenium.logComment("Verifying that Greenberry Recipes button is working.");
		selenium.logComment("Navigating back to Shakeology Recipes Page from Greenberry Recipes Page.");
		selenium.logComment("Verifying that Chocolate Recipes button is working.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		}

		selenium.logComment("Clicking on 'Eat Smart' link");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Clicking on 'Shakeology Recipes' link");
		ShakeologyRecipesPage shakeologyRecipesPage = eatSmartPage.goToShakeologyRecipesPage();

		selenium.logComment("Verifying that all the required elements are present on the recipes page.");		
		assertTrue("Expected page header is not available.", selenium.isElementPresent(ShakeologyRecipesTab.SHAKEOLOGY_RECIPES_HEADER), selenium);
		assertTrue("Expected image is not available.", selenium.isElementPresent(ShakeologyRecipesTab.SHAKEOLOGY_RECIPES_IMAGE), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("Like the taste of rich chocolate? How about berries? Whichever you prefer, we have a recipe for you. These shakes take just minutes to make, and we have tons of combinations to choose from. They're a delicious way to get the nutrients you need every day. Tasty and naturally energizing, Shakeology helps you improve your health and lose weight.*"), selenium);
		assertTrue("Expected label 'Choose a delicious recipe below:' is not available.", selenium.isElementPresent(ShakeologyRecipesTab.CHOOSE_A_DELICIOUS_RECIPE_BELOW_LABEL), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("Each one includes the calorie count so you can add it to your Meal Planner on Team Beachbody®."), selenium);
		assertTrue("Expected label 'Greenberry' is not available.", selenium.isElementPresent(ShakeologyRecipesTab.GREENBERRY_LABEL), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("With the taste of sweet tangy berries, it's naturally energizing, and a delicious way to get more of the nutrients you need every day. Made from more than 70 powerful superfoods and nutritious ingredients from around the world, it provides incredible health, energy, and weight loss benefits—all in 140 nutrient-rich calories."), selenium);
		assertTrue("Expected button 'Greenberry Recipes' is not available.", selenium.isElementPresent(ShakeologyRecipesTab.GREENBERRY_RECIPES_BUTTON), selenium);
		assertTrue("Expected label 'Chocolate' is not available.", selenium.isElementPresent(ShakeologyRecipesTab.CHOCOLATE_LABEL), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("With the taste of rich chocolate, it's naturally energizing, and a delicious way to get more of the nutrients you need every day. Made from more than 70 powerful superfoods and nutritious ingredients from around the world, it provides incredible health, energy, and weight loss benefits—all in 140 nutrient-rich calories."), selenium);
		assertTrue("Expected button 'Chocolate Recipes' is not available.", selenium.isElementPresent(ShakeologyRecipesTab.CHOCOLATE_RECIPES_BUTTON), selenium);
		assertTrue("Expected page footer is not available.", selenium.isElementPresent(ShakeologyRecipesTab.FDA_STATEMENT), selenium);

		selenium.logComment("Verifying that Greenberry Recipes button is working.");		
		ShakeologyRecipesGreenberryPage greenberryPage =  shakeologyRecipesPage.clickGreenberryRecipesButton();
		
		selenium.logComment("Navigating back to Shakeology Recipes Page from Greenberry Recipes Page.");
		shakeologyRecipesPage = greenberryPage.goToShakeologyRecipesPage();

		selenium.logComment("Verifying that Chocolate Recipes button is working.");	
		shakeologyRecipesPage.clickChocolateReciesButton();

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
	
	/**
	 * Test script for viewing Shakeology Recipes - Greenberry page as Free user. 
	 */
	@Test 
	public void testViewGreenberryShakeologyRecipesPage() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Eat Smart' link");
		selenium.logComment("Clicking on 'Shakeology Recipes' link");
		selenium.logComment("Clicking on 'Greenberry Recipes' link");
		selenium.logComment("Verifying that all the required elements are present on the Greenberry page.");
		selenium.logComment("Verifying number of calorie links.");
		selenium.logComment("Verifying the headers of calorie links and table rows.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		}

		selenium.logComment("Clicking on 'Eat Smart' link");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Clicking on 'Shakeology Recipes' link");
		ShakeologyRecipesPage shakeologyRecipesPage = eatSmartPage.goToShakeologyRecipesPage();

		selenium.logComment("Clicking on 'Greenberry Recipes' link");
		ShakeologyRecipesGreenberryPage greenberryPage = shakeologyRecipesPage.goToGreenberryPage();
		
		selenium.logComment("Verifying that all the required elements are present on the Greenberry page.");		
		assertTrue("Expected page header is not available.", selenium.isElementPresent(Greenberry.GREENBERRY_PAGE_HEADER), selenium);
		assertTrue("Expected image is not available.", selenium.isElementPresent(Greenberry.GREENBERRY_PAGE_IMAGE), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("Here's how to make it: For each of these delicious recipes, add 1 serving of Greenberry Shakeology and ice to taste (add more ice for a thicker shake) to the ingredients listed. Mix in blender until creamy."), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("You've got the choices: Fresh or frozen fruit. Regular, skim (nonfat), almond, or rice milk (the more milk you add, the creamier). Enjoy!*"), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("*Keep in mind that substitutions will affect nutrition values listed."), selenium);
			
		selenium.logComment("Verifying number of calorie links.");
		assertTrue("All links are not displayed", greenberryPage.getCalorieLinksCount()==3, selenium );
		
		selenium.logComment("Verifying the headers of calorie links and table rows.");
		assertTrue("Expected text is not displayed.", selenium.isTextPresent("Less than 200 Calories"), selenium );
		assertTrue("Expected text is not displayed.", selenium.isTextPresent("200–300 Calories"), selenium );
		assertTrue("Expected text is not displayed.", selenium.isTextPresent("300–400 Calories"), selenium );
		assertTrue("Expected text is not displayed.", greenberryPage.getGreenberryShakesRowCount()>0, selenium );
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
	

	/**
	 * Test script for viewing Shakeology Recipes - Chocolate page as Free user. 
	 */
	@Test 
	public void testViewChocolateShakeologyRecipesPage() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Eat Smart' link");
		selenium.logComment("Clicking on 'Shakeology Recipes' link");
		selenium.logComment("Clicking on 'Chocolate Recipes' link");
		selenium.logComment("Verifying that all the required elements are present on the Chocolate page.");
		selenium.logComment("Verifying number of calorie links.");
		selenium.logComment("Verifying the headers of calorie links and table rows.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		}

		selenium.logComment("Clicking on 'Eat Smart' link");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Clicking on 'Shakeology Recipes' link");
		ShakeologyRecipesPage shakeologyRecipesPage = eatSmartPage.goToShakeologyRecipesPage();

		selenium.logComment("Clicking on 'Chocolate Recipes' link");
		ShakeologyRecipesChocolatePage chocolatePage = shakeologyRecipesPage.clickChocolateReciesButton();
		
		selenium.logComment("Verifying that all the required elements are present on the Chocolate page.");		
		assertTrue("Expected page header is not available.", selenium.isElementPresent(Chocolate.CHOCOLATE_PAGE_HEADER), selenium);
		assertTrue("Expected image is not available.", selenium.isElementPresent(Chocolate.CHOCOLATE_PAGE_IMAGE), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("Here's how to make it: For each of these delicious recipes, add 1 serving of Chocolate Shakeology and ice to taste (add more ice for a thicker shake) to the ingredients listed. Mix in blender until creamy."), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("You've got the choices: Fresh or frozen fruit. Regular, skim (nonfat), almond, or rice milk (the more milk you add, the creamier). And almond butter instead of peanut butter—use whichever you like better. Enjoy!*"), selenium);
		assertTrue("Expected text is not available.", selenium.isTextPresent("*Keep in mind that substitutions will affect nutrition values listed."), selenium);
			
		selenium.logComment("Verifying number of calorie links.");
		assertTrue("All links are not displayed", chocolatePage.getCalorieLinksCount()==3, selenium );
		
		selenium.logComment("Verifying the headers of calorie links and table rows.");
		assertTrue("Expected text is not displayed.", selenium.isTextPresent("Less than 200 Calories"), selenium );
		assertTrue("Expected text is not displayed.", selenium.isTextPresent("200–300 Calories"), selenium );
		assertTrue("Expected text is not displayed.", selenium.isTextPresent("300–400 Calories"), selenium );
		assertTrue("Expected text is not displayed.", chocolatePage.getChocolateShakesRowCount()>0, selenium );
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
}