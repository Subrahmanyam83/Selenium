package com.tbb.testscripts.eatsmart;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.RecipesTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.RecipesPage;


/**
 * 
 * This test script contains test method(s) for Recipes page under Eat-Smart module
 * @author Jaya
 */
public class TestRecipes extends BaseTest implements RecipesTab{

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
	 * This is data provider for testViewBlog Test Script.
	 */ 
	@DataProvider(name = "recipeDataProvider")
	public Object[][] createBlogData() {
		return new Object[][] {
				{ "Turkey Burger"},
		};
	}
	/**
	 * Positive Test script for viewing a Recipe. 
	 */
	@Test (dataProvider = "recipeDataProvider")
	public void testViewRecipe(String recipeKeyword) {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Recipes' link");
		selenium.logComment("Verifying that all the required elements are present on the recipes page.");
		selenium.logComment("Searching for a recipe.");
		selenium.logComment("Click on the recipe name found in search results based on search keyword.");
		selenium.logComment("Verifying the searched recipe keyword is present in the Recipe Header");
		selenium.logComment("Verifying that the recipe details are displayed.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}
		
		selenium.logComment("Clicking on 'Recipes' link");
		RecipesPage recipesPage = dashboardPage.clickRecipesLink();
		
		selenium.logComment("Verifying that all the required elements are present on the recipes page.");
		assertTrue("Expected header Recipes is not available.", selenium.isElementPresent(RECIPES_HEADER), selenium);
		assertTrue("Expected text 'Welcome to Team Beachbody's...' is not available.", selenium.isTextPresent("Welcome to Team Beachbody’s favorite recipes. These dishes are made with healthy, fresh ingredients that will give you lots of energy and keep you satisfied so you'll stick with your diet plan. Choose from breakfast or lunch and dinner, soup or salad, breads, dips and sauces, and tasty but still healthful desserts that are sure to please everyone in your household. You’ll be amazed at how good you'll feel when you eat nutritious and delicious meals. Enjoy."), selenium);
		assertTrue("Expected text 'To rate any recipe...' is not available.", selenium.isTextPresent("(To rate any recipe from 1 to 5, simply click on the stars underneath.)"), selenium);
		assertTrue("Expected text 'This week's featured...' is not available.", selenium.isTextPresent("This week's featured recipe "), selenium);
		assertTrue("Expected text 'Recipes For' is not available.", selenium.isTextPresent("Recipes For"), selenium);
		assertTrue("Expected meal drop down is not available.", selenium.isElementPresent(MEAL_DROP_DOWN), selenium);
		assertTrue("Expected search text box is not available.", selenium.isElementPresent(SEARCH_TEXT_BOX), selenium);
		assertTrue("Expected search icon is not available.", selenium.isElementPresent(SEARCH_ICON), selenium);
		
		selenium.logComment("Searching for a recipe.");
		recipesPage.searchRecipe(recipeKeyword);
		
		selenium.logComment("Click on the recipe name found in search results based on search keyword.");
		recipesPage.viewRecipe(recipeKeyword);
		
		selenium.logComment("Verifying the searched recipe keyword is present in the Recipe Header");
		assertTrue("Expected recipe header is not available.", selenium.isElementPresent("css=div.recipe-wrapper>h2:contains("+recipeKeyword+")"), selenium);
		
		selenium.logComment("Verifying that the recipe details are displayed.");
		assertTrue("Expected recipe header is not available.", selenium.isTextPresent("Preparation Time:"), selenium);
		assertTrue("Expected recipe header is not available.", selenium.isTextPresent("Cooking Time"), selenium);
		assertTrue("Expected recipe header is not available.", selenium.isTextPresent("Nutritional Information"), selenium);
		assertTrue("Expected recipe header is not available.", selenium.isElementPresent("css=a:contains(Back to Recipes)"), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}
	
	/**
	 * Positive Test script for viewing a Recipe. 
	 */
	@Test (dataProvider = "recipeDataProvider")
	public void testSearchRecipe(String recipeKeyword) {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Recipes' link");
		selenium.logComment("Searching for a recipe");
		selenium.logComment("Verifying the searched recipe keyword is present in the search results");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}
		
		selenium.logComment("Clicking on 'Recipes' link");
		RecipesPage recipesPage = dashboardPage.clickRecipesLink();
		
		selenium.logComment("Searching for a recipe");
		recipesPage.searchRecipe(recipeKeyword);
		
		selenium.logComment("Verifying the searched recipe keyword is present in the search results");
		selenium.isElementPresent("css=span:contains("+recipeKeyword+")");
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
		}
}