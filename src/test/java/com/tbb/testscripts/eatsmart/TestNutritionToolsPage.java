package com.tbb.testscripts.eatsmart;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.BodyFatCalculatorTab;
import com.tbb.constants.UIRepository.CaloricNeedsTab;
import com.tbb.constants.UIRepository.HealthyWeightTab;
import com.tbb.constants.UIRepository.NutritionToolsTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.BodyFatCalculatorPage;
import com.tbb.pages.eatsmart.CaloricNeedsPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.eatsmart.HealthyWeightPage;
import com.tbb.pages.eatsmart.NutritionToolsPage;
import com.tbb.pages.profile.MyProfilePage;
import com.tbb.pages.profile.ProgressAndGoalsPage;


/**
 * 
 * This test script contains test method(s) for Nutrition Tools page under Eat-Smart module
 * @author Jaya
 */
public class TestNutritionToolsPage extends BaseTest implements NutritionToolsTab, BodyFatCalculatorTab, HealthyWeightTab, CaloricNeedsTab {

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
	 * Positive Test script for verifying viewing of Nutrition Tools Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test 
	public void testViewNutritionToolsPage() {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to Nutrition Tools Page");
		selenium.logComment("Verifying that Nutrition Tools header is present on the Nutrition Tools Page");
		selenium.logComment("Verifying that Body Fat Image link is working.");
		selenium.logComment("Navigating to Nutrition Tools Page.");
		selenium.logComment("Verifying that Body Fat button is working.");
		selenium.logComment("Navigating to Nutrition Tools Page.");
		selenium.logComment("Verifying that Body Healthy Weight Image link is working.");
		selenium.logComment("Navigating to Nutrition Tools Page.");
		selenium.logComment("Verifying that Healthy Weight button is working.");
		selenium.logComment("Navigating to Nutrition Tools Page.");
		selenium.logComment("Verifying that Caloric Needs Image link is working.");
		selenium.logComment("Navigating to Nutrition Tools Page.");
		selenium.logComment("Verifying the text at the bottom of Nutrition Tools Page is displayed.");
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

		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Navigating to Nutrition Tools Page");
		NutritionToolsPage nutritionToolsPage = eatSmartPage.goToNutritionToolsPage();
		
		selenium.logComment("Verifying that Nutrition Tools header is present on the Nutrition Tools Page");		
		assertTrue("Expected header 'Nutrition Tools' is not displayed.", selenium.isElementPresent(NUTRITION_TOOLS_HEADER), selenium);

		selenium.logComment("Verifying that Body Fat Image link is working.");
		assertTrue("Expected 'Body Fat Tool Image' is not displayed.", selenium.isElementPresent(BODY_FAT_TOOL_IMAGE), selenium);
		BodyFatCalculatorPage bodyFatPage = nutritionToolsPage.clickBodyFatImage();

		selenium.logComment("Navigating to Nutrition Tools Page.");
		nutritionToolsPage = bodyFatPage.goToNutritionToolsPage();

		selenium.logComment("Verifying that Body Fat button is working.");
		assertTrue("Expected 'Body Fat' button is not displayed.", selenium.isElementPresent(BODY_FAT_BUTTON), selenium);
		bodyFatPage = nutritionToolsPage.clickBodyFatButton();

		selenium.logComment("Navigating to Nutrition Tools Page.");
		nutritionToolsPage = bodyFatPage.goToNutritionToolsPage();

		selenium.logComment("Verifying that Body Healthy Weight Image link is working.");
		assertTrue("Expected 'Healthy Weight Image' is not displayed.", selenium.isElementPresent(HEALTHY_WEIGHT_TOOL_IMAGE), selenium);
		HealthyWeightPage healthyWeightPage = nutritionToolsPage.clickHealthyWeightImage();

		selenium.logComment("Navigating to Nutrition Tools Page.");
		nutritionToolsPage = healthyWeightPage.goToNutritionToolsPage();

		selenium.logComment("Verifying that Healthy Weight button is working.");
		assertTrue("Expected 'Healthy Weight' Button is not displayed.", selenium.isElementPresent(HEALTHY_WEIGHT_BUTTON), selenium);
		healthyWeightPage = nutritionToolsPage.clickHealthyWeightButton();

		selenium.logComment("Navigating to Nutrition Tools Page.");
		nutritionToolsPage = healthyWeightPage.goToNutritionToolsPage();

		selenium.logComment("Verifying that Caloric Needs Image link is working.");
		assertTrue("Expected 'Caloric Needs Image' is not displayed.", selenium.isElementPresent(CALORIC_NEEDS_TOOL_IMAGE), selenium);
		CaloricNeedsPage caloricNeedsPage = nutritionToolsPage.clickCaloricNeedsImage();

		selenium.logComment("Navigating to Nutrition Tools Page.");
		nutritionToolsPage = caloricNeedsPage.goToNutritionToolsPage();

		selenium.logComment("Verifying that Caloric Needs Button is working.");
		assertTrue("Expected 'Caloric Needs Button' is not displayed.", selenium.isElementPresent(CALORIC_NEEDS_BUTTON), selenium);

		selenium.logComment("Navigating to Nutrition Tools Page.");
		nutritionToolsPage = caloricNeedsPage.goToNutritionToolsPage();

		selenium.logComment("Verifying the text at the bottom of Nutrition Tools Page is displayed.");
		assertTrue("Expected Text 'A great workout...' is not displayed.", selenium.isTextPresent("A great workout and good nutrition go hand-in-hand.  And Team Beachbody makes it simple to set nutrition goals, evaluate your progress, and stay motivated every day. Use our online tools to estimate how much body fat you have, determine if you're at a healthy weight, and calculate how many calories you need to maintain your body mass or lose extra pounds."), selenium);	
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}

	/**
	 * Positive Test script for verifying viewing of Body Fat Calculator Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test 
	public void testViewBodyFatCalclatorPage() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to Nutrition Tools Page");
		selenium.logComment("Navigating to Body Fat Calculator Page.");
		selenium.logComment("Verifying that all the required elements are present on the Body Fat Calculator Tools Page");
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

		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Navigating to Nutrition Tools Page");
		NutritionToolsPage nutritionToolsPage = eatSmartPage.goToNutritionToolsPage();

		selenium.logComment("Navigating to Body Fat Calculator Page.");
		nutritionToolsPage.clickBodyFatButton();

		selenium.logComment("Verifying that all the required elements are present on the Body Fat Calculator Tools Page");		
		assertTrue("Expected header 'Body Fat Calculator' is not displayed.", selenium.isElementPresent(BODY_FAT_CALCULATOR_HEADER), selenium);
		assertTrue("Expected Body Fat Calculator Image is not displayed.", selenium.isElementPresent(BODY_FAT_CALCULATOR_IMAGE), selenium);
		assertTrue("Expected Text 'Knowing your body...", selenium.isTextPresent("Knowing your body-fat percentage is a vital part of setting diet and fitness goals, as well as for tracking the success of your workout program. As you become more fit, you may gain lean muscle while you lose fat, so a lower body-fat reading can be a more important measure of progress than your weight on the scale. Use this tool (along with a body-fat tester for more accurate results), and you'll see how far you need to go to reach an ideal percentage for your age and gender."), selenium);
		assertTrue("Expected Body Fat Tester link is unavailable.", selenium.isElementPresent(BODY_FAT_TESTER_HERE_LINK), selenium);
		assertTrue("Expected Body Fat Portlet Title is not available.", selenium.isElementPresent(BODY_FAT_PORTLET_TITLE), selenium);
		assertTrue("Expected Learn More about Body fat link is not available.", selenium.isElementPresent(LEARN_MORE_ABOUT_BODY_FAT_LINK), selenium);
		assertTrue("Expected Your waist textbox is not available.", selenium.isElementPresent(YOUR_WAIST_TEXTBOX), selenium);
		assertTrue("Expected Your weight textbox is not available.", selenium.isElementPresent(YOUR_WEIGHT_TEXTBOX), selenium);
		assertTrue("Expected Gender dropdown is missing.", selenium.isElementPresent(YOUR_GENDER_DROPDOWN), selenium);
		assertTrue("Expected your age textbox is not available.", selenium.isElementPresent(YOUR_AGE_TEXTBOX), selenium);
		assertTrue("Expected Body Fat Tester Reading Link is unavailable.", selenium.isElementPresent(BODY_FAT_TESTER_READING_LINK), selenium);
		assertTrue("Expected Body Fat Tester Dropdown is unavailable.", selenium.isElementPresent(BODY_FAT_TESTER_DROPDOWN), selenium);
		assertTrue("Expected Calculate Body Fat Button is unavailable.", selenium.isElementPresent(CALCULATE_BODY_FAT_BUTTON), selenium);
		assertTrue("Expected Estimated Body Fat Textbox is unavailable.", selenium.isElementPresent(ESTIMATED_BODY_FAT_TEXTBOX), selenium);
		assertTrue("Expected Fat Weight Textbox is unavailable.", selenium.isElementPresent(FAT_WEIGHT_TEXTBOX), selenium);
		assertTrue("Expected Lean Weight Textbox is unavailable.", selenium.isElementPresent(LEAN_WEIGHT_TEXTBOX), selenium);
		assertTrue("Expected Lean Textbox is unavailable.", selenium.isElementPresent(LEAN_TEXTBOX), selenium);
		assertTrue("Expected Ideal From Percent Textbox is unavailable.", selenium.isElementPresent(IDEAL_FROM_PERCENT_TEXTBOX), selenium);
		assertTrue("Expected Ideal To Percent Textbox is unavailable.", selenium.isElementPresent(IDEAL_TO_PERCENT_TEXTBOX), selenium);
		assertTrue("Expected Average From Percent Textbox is unavailable.", selenium.isElementPresent(AVERAGE_FROM_PERCENT_TEXTBOX), selenium);
		assertTrue("Expected Average to percent textbox is unavailable.", selenium.isElementPresent(AVERAGE_TO_PERCENT_TEXTBOX), selenium);
		assertTrue("Expected Overfat textbox is unavailable.", selenium.isElementPresent(OVERFAT_TEXTBOX), selenium);
		assertTrue("Expected text 'Note: These Figures...' is not available.", selenium.isTextPresent("Note: These figures are only estimates. This formula does not apply to children under 15 or pregnant women."), selenium);
		assertTrue("Expected text 'This calculator requires...' is not available.", selenium.isTextPresent("This calculator requires a JavaScript-enabled browser."), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}
	  
	  /**
	 * Positive Test script for verifying viewing of Healthy Weight Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test 
	public void testViewHealthyWeightPage() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to Nutrition Tools Page");
		selenium.logComment("Navigating to Healthy Weight Page.");
		selenium.logComment("Verifying that all the required elements are present on the Healthy Weight Tools Page");
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
		
		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Navigating to Nutrition Tools Page");
		NutritionToolsPage nutritionToolsPage = eatSmartPage.goToNutritionToolsPage();

		selenium.logComment("Navigating to Healthy Weight Page.");
		nutritionToolsPage.clickHealthyWeightButton();

		selenium.logComment("Verifying that all the required elements are present on the Healthy Weight Tools Page");		
		assertTrue("Expected Healthy Weight header is not displayed.", selenium.isElementPresent(HEALTHY_WEIGHT_HEADER), selenium);
		assertTrue("Expected Healthy weight image is not displayed.", selenium.isElementPresent(HEALTHY_WEIGHT_IMAGE), selenium);
		assertTrue("Expected text 'This tool will...' is not displayed.", selenium.isTextPresent("This tool will allow you to instantly calculate your Body Mass Index (BMI), a number used by government agencies to help determine how far you are from a healthy weight. Calculating your own BMI requires a complex equation, but we make it simple: Just plug in your height and current weight. Then use our guide to see if you're overweight, underweight, or normal."), selenium);
		assertTrue("Expected healthy weight calculator portlet title is not displayed.", selenium.isElementPresent(HEALTHY_WEIGHT_CALCULATOR_PORTLET_TITLE), selenium);
		assertTrue("Expected 'Learn more about BMI Link' is not displayed.", selenium.isElementPresent(LEARN_MORE_ABOUT_BMI_LINK), selenium);
		assertTrue("Expected text 'Knowing your BMI...' is not displayed.", selenium.isTextPresent("Knowing your BMI can help you determine if you're at a healthy weight. What's your BMI?"), selenium);
		assertTrue("Expected Your height Ft textbox is not displayed.", selenium.isElementPresent(YOUR_HEIGHT_FT_TEXTBOX), selenium);
		assertTrue("Expected Your height In textbox is not displayed.", selenium.isElementPresent(YOUR_HEIGHT_IN_TEXTBOX), selenium);
		assertTrue("Expected Your weight Lbs textboxis not displayed.", selenium.isElementPresent(YOUR_WEIGHT_LBS_TEXTBOX), selenium);
		assertTrue("Expected Calculate your BMI button is not displayed.", selenium.isElementPresent(CALCULATE_YOUR_BMI_BUTTON), selenium);
		assertTrue("Expected Your BMI is Textbox is not displayed.", selenium.isElementPresent(YOUR_BMI_IS_TEXTBOX), selenium);
		assertTrue("Expected text '*These results can't...' is not displayed.", selenium.isTextPresent("* These results can't distinguish between weight from body fat and weight from muscle, so people who are extremely muscular may have high BMIs while still being very lean."), selenium);
		assertTrue("Expected text 'BMI figures and...' is not displayed.", selenium.isTextPresent("BMI figures and descriptions are courtesy the Centers for Disease Control and Prevention."), selenium);
		assertTrue("Expected text 'This calculator requires...'is not displayed.", selenium.isTextPresent("This calculator requires a JavaScript-enabled browser."), selenium);
		assertTrue("Expected text '18.5 or less...' is not displayed.", selenium.isTextPresent("18.5 or less is considered to be underweight for most people. "), selenium);
		assertTrue("Expected text '18.5 To 24.9...' is not displayed.", selenium.isTextPresent("18.5 To 24.9 is considered to be normal for most people."), selenium);
		assertTrue("Expected text '25 to 29.9...' is not displayed.", selenium.isTextPresent("25 To 29.9 is considered to be overweight for most people.*"), selenium);
		assertTrue("Expected text '30.0 or greater...' is not displayed.", selenium.isTextPresent("30.0 or greater is considered to be obese for most people.*"), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}
	  
	/**
	 * Positive Test script for verifying viewing of Caloric Needs Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test 
	public void testViewCaloricNeedsPage() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to Nutrition Tools Page");
		selenium.logComment("Navigating to Caloric Needs Page.");
		selenium.logComment("Verifying that all the required elements are present on the Caloric Needs Page");
		selenium.logComment("Selecting 'More than once a day' option to get Secondary dropdown.");
		selenium.logComment("Verifying that remaining required elements are present on the Caloric Needs Page");
		selenium.logComment("Navigating to Progress and Goals Page to find the Measurement Units.");
		selenium.logComment("Navigating to Nutrition Tools Page.");
		selenium.logComment("Navigating to Caloric Needs Page.");
		selenium.logComment("Verifying fields based on the measurement unit settings.");
		selenium.logComment("Verifying that the submit button at the bottom is available.");
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

		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Navigating to Nutrition Tools Page");
		NutritionToolsPage nutritionToolsPage = eatSmartPage.goToNutritionToolsPage();

		selenium.logComment("Navigating to Caloric Needs Page.");
		CaloricNeedsPage caloricNeedsPage = nutritionToolsPage.clickCaloricNeedsButton();

		selenium.logComment("Verifying that all the required elements are present on the Caloric Needs Page");	
		assertTrue("Expected is not displayed.", selenium.isElementPresent(CALORIC_NEEDS_HEADER), selenium);
		assertTrue("Expected is not displayed.", selenium.isTextPresent("Use this tool to calculate how many calories your body requires each day in order to maintain your current weight, and how many fewer it would take for you to lose weight. By following your Team Beachbody meal plan (and burning more calories with your Team Beachbody workout program), you'll maintain a caloric deficit but still feel satisfied and have plenty of energy."), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(CALORIC_NEEDS_IMAGE), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(CALORIC_NEEDS_CALCULATOR_PORTLET_TITLE), selenium);
		assertTrue("Expected is not displayed.", selenium.isTextPresent("Have you completed a Beachbody� program (or other fitness program) recently?"), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(BEACHBODY_RECENTLY_COMPLETED_PROGRAM_DROPDOWN), selenium);
		assertTrue("Expected is not displayed.", selenium.isTextPresent("What is your goal?"), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(GOAL_DROPDOWN), selenium);
		assertTrue("Expected is not displayed.", selenium.isTextPresent("How many times will you be exercising per day?"), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(ONCE_A_DAY_RADIO_BUTTON), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(ONCE_A_DAY_LABEL), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(MORE_THAN_ONCE_A_DAY_RADIO_BUTTON), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(MORE_THAN_ONCE_A_DAY_LABEL), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(PRIMARY_PROGRAM_LABEL), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(PRIMARY_PROGRAM_DROPDOWN), selenium);

		selenium.logComment("Selecting 'More than once a day' option to get Secondary dropdown.");	
		caloricNeedsPage.selectExercisePerDay("More than once a day", "None", "None");

		selenium.logComment("Verifying that remaining required elements are present on the Caloric Needs Page");
		assertTrue("Expected is not displayed.", selenium.isElementPresent(SECONDARY_PROGRAM_LABEL), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(SECONDARY_PROGRAM_DROPDOWN), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(RATE_YOUR_ACTIVITY_QUESTION), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(RATE_YOUR_ACTIVITY_HELP_ICON), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(ACTIVITY_LEVEL_DROPDOWN), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(GENDER_QUESTION), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(FEMALE_RADIO_BUTTON), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(FEMALE_LABEL), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(MALE_RADIO_BUTTON), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(MALE_LABEL), selenium);
		assertTrue("Expected is not displayed.", selenium.isElementPresent(YEARS_OLD_TEXTBOX), selenium);

		selenium.logComment("Navigating to Progress and Goals Page to find the Measurement Units.");
		MyProfilePage myprofilePage = caloricNeedsPage.clickProfile();
		ProgressAndGoalsPage progressAndGoalsPage = myprofilePage.editProgressAndGoals();
		String measureUnit = null;
		if((selenium.isElementPresent("css=div.goal-section div.story-section:contains(Imperial (lbs/in))"))==true)
			measureUnit="Imperial";
		else
			measureUnit="Metric";

		selenium.logComment("Navigating to Nutrition Tools Page.");
		nutritionToolsPage = progressAndGoalsPage.goToNutritionToolsPage();
		
		selenium.logComment("Navigating to Caloric Needs Page.");
		caloricNeedsPage = nutritionToolsPage.clickCaloricNeedsButton();
		
		selenium.logComment("Verifying fields based on the measurement unit settings.");
		if(measureUnit=="Metric"){		
			assertTrue("Expected is not displayed.", selenium.isElementPresent(CM_TEXTBOX), selenium);
			assertTrue("Expected is not displayed.", selenium.isElementPresent(KG_TEXTBOX), selenium);
		}else{
			assertTrue("Expected is not displayed.", selenium.isElementPresent(FT_TEXTBOX), selenium);
			assertTrue("Expected is not displayed.", selenium.isElementPresent(IN_TEXTBOX), selenium);
			assertTrue("Expected is not displayed.", selenium.isElementPresent(LBS_TEXTBOX), selenium);
		}
		selenium.logComment("Verifying that the submit button at the bottom is available.");
		assertTrue("Expected is not displayed.", selenium.isElementPresent(SUBMIT_BUTTON), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}

	/***
	 * This is data provider for testUsingBodyFatCalculator Test Script.
	 */ 
	@DataProvider(name = "BodyFatCalculatorDataProvider")
	public Object[][] createBodyFatCalculatorData() {
		return new Object[][] {
				{ "32", "140", "Female", "26", "Unknown", "32", "45", "95", "19.8", "19.8", "24.1", "24.1", "31.6", "31.6"},
		};
	}
	/**
	 * Positive Test script for verifying using Body Fat Calculator.
	 */ 
	@Test (dataProvider = "BodyFatCalculatorDataProvider")
	public void testUsingBodyFatCalculator( String waist, String weight, String gender, String age, String reading, String estimatedBodyFat, String fatWeight, String leanWeight, String leanPercent, String idealFromPercent, String idealToPercent, String averageFromPercent, String averageToPercent, String overfatPercent) {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to Nutrition Tools Page");
		selenium.logComment("Navigating to Body Fat Calculator Page.");
		selenium.logComment("Enter data in Body Fat Calculator Form.");
		selenium.logComment("Clicking on Calculate Body Fat Button.");
		selenium.logComment("Verifying that the results are calculated correctly.");
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

		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Navigating to Nutrition Tools Page");
		NutritionToolsPage nutritionToolsPage = eatSmartPage.goToNutritionToolsPage();

		selenium.logComment("Navigating to Body Fat Calculator Page.");
		BodyFatCalculatorPage bodyFatCalculatorPage = nutritionToolsPage.clickBodyFatButton();
		
		selenium.logComment("Enter data in Body Fat Calculator Form.");
		bodyFatCalculatorPage.enterWaist(waist);
		bodyFatCalculatorPage.enterWeight(weight);
		bodyFatCalculatorPage.selectGender(gender);
		bodyFatCalculatorPage.enterAge(age);
		bodyFatCalculatorPage.selectBodyFatTesterReading(reading);
		
		selenium.logComment("Clicking on Calculate Body Fat Button.");
		bodyFatCalculatorPage.clickCalculateBodyFat();
		
		selenium.logComment("Verifying that the results are calculated correctly.");
		assertTrue("Calculated Estimated body fat is incorrect.", estimatedBodyFat.equals(selenium.getValue(ESTIMATED_BODY_FAT_TEXTBOX)), selenium);
		assertTrue("Calculated Fat Weight is incorrect.", fatWeight.equals(selenium.getValue(FAT_WEIGHT_TEXTBOX)), selenium);
		assertTrue("Calculated Lean Weight is incorrect.", leanWeight.equals(selenium.getValue(LEAN_WEIGHT_TEXTBOX)), selenium);
		assertTrue("Calculated Lean Percent is incorrect.", leanPercent.equals(selenium.getValue(LEAN_TEXTBOX)), selenium);
		assertTrue("Calculated Ideal From Percent is incorrect.", idealFromPercent.equals(selenium.getValue(IDEAL_FROM_PERCENT_TEXTBOX)), selenium);
		assertTrue("Calculated Ideal To Percent is incorrect.", idealToPercent.equals(selenium.getValue(IDEAL_TO_PERCENT_TEXTBOX)), selenium);
		assertTrue("Calculated Average From Percent is incorrect.", averageFromPercent.equals(selenium.getValue(AVERAGE_FROM_PERCENT_TEXTBOX)), selenium);
		assertTrue("Calclated Average To Percent is incorrect.", averageToPercent.equals(selenium.getValue(AVERAGE_TO_PERCENT_TEXTBOX)), selenium);
		assertTrue("Calculated Overfat Percent is incorrect.", overfatPercent.equals(selenium.getValue(OVERFAT_TEXTBOX)), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}
	
	/***
	 * This is data provider for testUsingBodyFatCalculator Test Script.
	 */ 
	@DataProvider(name = "HealthyWeightCalculatorDataProvider")
	public Object[][] createHealthyWeightCalculatorData() {
		return new Object[][] {
				{ "5", "4", "135", "23.2"},
		};
	}
	  /**
	  * Positive Test script for verifying using Healthy Weight Calculator.
	  */ 
	@Test (dataProvider = "HealthyWeightCalculatorDataProvider")
	public void testUsingHealthyWeightCalculator( String heightFt, String heightIn, String weight, String bmi) {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Eat Smart Page");
		selenium.logComment("Navigating to Nutrition Tools Page");
		selenium.logComment("Navigating to Healthy Weight Page.");
		selenium.logComment("Entering details in the Healthy Weight Calculator Form.");
		selenium.logComment("Verifying that the BMI is calculated correctly.");
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

		selenium.logComment("Navigating to Eat Smart Page");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Navigating to Nutrition Tools Page");
		NutritionToolsPage nutritionToolsPage = eatSmartPage.goToNutritionToolsPage();

		selenium.logComment("Navigating to Healthy Weight Page.");
		HealthyWeightPage healthyWeightPage = nutritionToolsPage.clickHealthyWeightButton();
		
		selenium.logComment("Entering details in the Healthy Weight Calculator Form.");
		healthyWeightPage.enterHeightFt(heightFt);
		healthyWeightPage.enterHeightIn(heightIn);
		healthyWeightPage.enterWeight(weight);
		healthyWeightPage.clickCalculateYourBMI();
		
		selenium.logComment("Verifying that the BMI is calculated correctly.");		
		assertTrue("Expected BMI not calculated correctly.", bmi.equals(selenium.getValue(YOUR_BMI_IS_TEXTBOX)), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}

	/***
	 * This is data provider for testUsingCaloricNeedsCalculator Test Script.
	 */ 
	@DataProvider(name = "CaloricNeedsCalculatorDataProvider")
	public Object[][] createCaloricNeedsCalculatorData() {
		return new Object[][] {
				{"No, this is my first fitness program.", "Lose a lot of weight", "Once a day", "None", "None", "Moderately active", "Male", "27", "160", "62", "5", "4", "140", "Low-Carb Express"},
		};
	}
	
	/**
	* Positive Test script for verifying using Caloric Needs Calculator.
	*/
	@Test (dataProvider = "CaloricNeedsCalculatorDataProvider")
	public void testUsingCaloricNeedsCalculator( String recentBeachbodyProgram, String goal, String exercisePerDayOption, String primaryProgram, String secondaryProgram, String activityLevel, String gender, String age, String heightCm, String weightKg, String heightFt, String heightIn, String weightLbs, String recommendation) {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to My Profile Page");
		selenium.logComment("Navigating to Nutrition Tools Page.");
		selenium.logComment("Navigating to Caloric Needs Page.");
		selenium.logComment("Enter Caloric Needs Calculator Form data.");
		selenium.logComment("Submit Caloric Needs Form.");
		selenium.logComment("Verify that the recommendation generated is correct.");
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

		selenium.logComment("Navigating to My Profile Page");
		MyProfilePage myprofilePage = dashboardPage.clickProfile();
		ProgressAndGoalsPage progressAndGoalsPage = myprofilePage.editProgressAndGoals();
		String measureUnit = null;
		if((selenium.isElementPresent("css=div.goal-section div.story-section:contains(Imperial (lbs/in))"))==true)
			measureUnit="Imperial";
		else
			measureUnit="Metric";

		selenium.logComment("Navigating to Nutrition Tools Page.");
		NutritionToolsPage nutritionToolsPage = progressAndGoalsPage.goToNutritionToolsPage();
		
		selenium.logComment("Navigating to Caloric Needs Page.");
		CaloricNeedsPage caloricNeedsPage = nutritionToolsPage.clickCaloricNeedsButton();
		
		selenium.logComment("Enter Caloric Needs Calculator Form data.");
		caloricNeedsPage.selectRecentBeachBodyProgram(recentBeachbodyProgram);
		caloricNeedsPage.selectGoal(goal);
		caloricNeedsPage.selectExercisePerDay(exercisePerDayOption, primaryProgram, secondaryProgram);
		caloricNeedsPage.selectActivityLevel(activityLevel);
		caloricNeedsPage.selectGender(gender);
		caloricNeedsPage.enterAge(age);
		if(measureUnit=="Metric"){		
			caloricNeedsPage.enterHeightInCm(heightCm);
			caloricNeedsPage.enterWeightInKg(weightKg);
		}else{
			caloricNeedsPage.enterHeightInFt(heightFt);
			caloricNeedsPage.enterHeightInIn(heightIn);
			caloricNeedsPage.enterWeightInLbs(weightLbs);
		}
		
		selenium.logComment("Submit Caloric Needs Form.");
		caloricNeedsPage.clickSubmit();
		
		selenium.logComment("Verify that the recommendation generated is correct.");
		assertTrue("Recommendation is not displayed.", selenium.isTextPresent(recommendation), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}
}