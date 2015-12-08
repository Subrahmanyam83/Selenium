package com.tbb.testscripts.shop;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.Shop;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.shop.ShoppingCartPage;

/**
 * 
 * This test script contains test method(s) for Nutrition and Supplements page under 'Shop By' menu.
 * @author Jaya
 */
public class TestNutritionAndSupplementsShop extends BaseTest{

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
	 * Positive Test script for verifying viewing of Trainers Shop Page.
	 */ 
	@Test
	public void testTrainersShop(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Shop' link");
		selenium.logComment("Clicking on 'Nutrition and Supplements' link");
		selenium.logComment("Clicking on 'Best Sellers' link");
		selenium.logComment("Clicking on 'Health and Wellness' link");
		selenium.logComment("Clicking on 'Nutrition Packs' link");
		selenium.logComment("Clicking on 'P90X Nutrition' link");
		selenium.logComment("Clicking on 'Shakeology' link");
		selenium.logComment("Clicking on 'Sports Performance' link");
		selenium.logComment("Clicking on 'Weight Management' link");
		selenium.logComment("Clicking on 'Home' link");
		selenium.logComment("Executes assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.clubuser"), ConfigFileReader.getConfigItemValue("tbb.clubpassword"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.clubuser"), ConfigFileReader.getConfigItemValue("tbb.clubpassword"));
		}
		
		selenium.logComment("Clicking on 'Shop' link");
		ShoppingCartPage shopPage = dashboardPage.clickShopLink();	
		
		selenium.logComment("Clicking on 'Nutrition and Supplements' link");
		shopPage.goToNutritionAndSupplements();
		
		selenium.logComment("Clicking on 'Best Sellers' link");
		shopPage.goToNutritionAndSupplementsBestSellers();
		assertTrue("Expected text 'Best Sellers' is not displayed.", selenium.isElementPresent(Shop.NUTRITION_BEST_SELLERS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Health and Wellness' link");
		shopPage.goToHealthAndWellness();
		assertTrue("Expected text 'Health and Wellness' is not displayed.", selenium.isElementPresent(Shop.HEALTH_AND_WELLNESS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Nutrition Packs' link");
		shopPage.goToNutritionPacks();
		assertTrue("Expected text 'Nutrition Packs' is not displayed.", selenium.isElementPresent(Shop.NUTRITION_PACKS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'P90X Nutrition' link");
		shopPage.goToP90XNutrition();
		assertTrue("Expected text 'P90X Nutrition' is not displayed.", selenium.isElementPresent(Shop.P90X_NUTRITION_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Shakeology' link");
		shopPage.goToShakeology();
		assertTrue("Expected text 'Shakeology' is not displayed.", selenium.isElementPresent(Shop.SHAKEOLOGY_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Sports Performance' link");
		shopPage.goToSportsPerformance();
		assertTrue("Expected text 'Sports Performance' is not displayed.", selenium.isElementPresent(Shop.SPORTS_PERFORMANCE_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Weight Management' link");
		shopPage.goToWeightManagement();
		assertTrue("Expected text 'Weight Management' is not displayed.", selenium.isElementPresent(Shop.WEIGHT_MANAGEMENT_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
			
		selenium.logComment("Clicking on 'Home' link");
		shopPage.clickHomeLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}