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
 * This test script contains test method(s) for Coach Products and Tools page under 'Shop By' menu.
 *  @author Jaya
 */
public class TestCoachProductsAndToolsShop extends BaseTest{

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
	 * Positive Test script for verifying viewing of Equipment and Gear Shop Page as coach user.
	 */ 
	@Test
	public void testEquipmentAndGearShopAsCoachUser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Shop' link");
		selenium.logComment("Clicking on 'Coach Products and Tools' link");
		selenium.logComment("Clicking on 'Coach Packs' link");
		selenium.logComment("Clicking on 'Promotional Items' link");
		selenium.logComment("Clicking on 'Shakeology Items' link");
		selenium.logComment("Clicking on 'Training Tools' link");
		selenium.logComment("Clicking on 'Home' link");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
		}
		
		selenium.logComment("Clicking on 'Shop' link");
		ShoppingCartPage shopPage = dashboardPage.clickShopLink();	
		
		selenium.logComment("Clicking on 'Coach Products and Tools' link");
		shopPage.goToCoachProductsAndTools();
		
	/*	selenium.logComment("Clicking on 'Beachbody Sharing Tools' link");
		shopPage.goToBeachbodySharingTools();
		assertTrue("Expected text 'Beachbody Sharing Tools' is not displayed.", selenium.isElementPresent(Shop.BEACHBODY_SHARING_TOOLS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );*/
		
		selenium.logComment("Clicking on 'Coach Packs' link");
		shopPage.goToCoachPacks();
		assertTrue("Expected text 'Coach Packs' is not displayed.", selenium.isElementPresent(Shop.COACH_PACKS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Promotional Items' link");
		shopPage.goToPromotionalItems();
		assertTrue("Expected text 'Promotional Items' is not displayed.", selenium.isElementPresent(Shop.PROMOTIONAL_ITEMS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Shakeology Items' link");
		shopPage.goToShakeologyItems();
		assertTrue("Expected text 'Shakeology Items' is not displayed.", selenium.isElementPresent(Shop.SHAKEOLOGY_ITEMS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Training Tools' link");
		shopPage.goToTrainingTools();
		assertTrue("Expected text 'Training Tools' is not displayed.", selenium.isElementPresent(Shop.TRAINING_TOOLS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
			
		selenium.logComment("Clicking on 'Home' link");
		shopPage.clickHomeLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/**
	 * Positive Test script for verifying viewing of Equipment and Gear Shop Page as Free user.
	 */ 
	@Test
	public void testEquipmentAndGearShopAsFreeUser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Shop' link");
		selenium.logComment("Clicking on 'Coach Products and Tools' link");
		selenium.logComment("Clicking on 'Shakeology Items' link");
		selenium.logComment("Clicking on 'Home' link");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.coach.username"), ConfigFileReader.getConfigItemValue("tbb.coach.password"));
		}
		
		selenium.logComment("Clicking on 'Shop' link");
		ShoppingCartPage shopPage = dashboardPage.clickShopLink();	
		
		selenium.logComment("Clicking on 'Coach Products and Tools' link");
		shopPage.goToCoachProductsAndTools();
		
		selenium.logComment("Clicking on 'Shakeology Items' link");
		shopPage.goToShakeologyItems();
		assertTrue("Expected text 'Shakeology Items' is not displayed.", selenium.isElementPresent(Shop.SHAKEOLOGY_ITEMS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
			
		selenium.logComment("Clicking on 'Home' link");
		shopPage.clickHomeLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}