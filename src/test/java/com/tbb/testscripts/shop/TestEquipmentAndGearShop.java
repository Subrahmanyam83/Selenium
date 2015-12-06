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
 * This test script contains test method(s) for Equipments and Gear page under 'Shop By' menu.
 *  @author Jaya
 */
public class TestEquipmentAndGearShop extends BaseTest{

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
	public void testEquipmentAndGearShop(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Shop' link");
		selenium.logComment("Clicking on 'Equipment and Gear' link");
		selenium.logComment("Clicking on 'Apparel' link");
		selenium.logComment("Clicking on 'Asylum Equipment' link");
		selenium.logComment("Clicking on 'Bands and Balls' link");
		selenium.logComment("Clicking on 'Chin up and Push up' link");
		selenium.logComment("Clicking on 'Health Monitors' link");
		selenium.logComment("Clicking on 'P90X Equipment' link");
		selenium.logComment("Clicking on 'Sculpting and Toning' link");
		selenium.logComment("Clicking on 'Yoga' link");
		selenium.logComment("Clicking on 'Home' link");
		selenium.logComment("Executing assertEmpty method");
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
		
		selenium.logComment("Clicking on 'Equipment and Gear' link");
		shopPage.goToEquipmentAndGear();
		
		selenium.logComment("Clicking on 'Apparel' link");
		shopPage.goToApparel();
		assertTrue("Expected text 'Apparel' is not displayed.", selenium.isElementPresent(Shop.APPAREL_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Asylum Equipment' link");
		shopPage.goToAsylumEquipment();
		assertTrue("Expected text 'Asylum Equipment' is not displayed.", selenium.isElementPresent(Shop.ASYLUM_EQUIPMENT_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Bands and Balls' link");
		shopPage.goToBandsAndBalls();
		assertTrue("Expected text 'Bands and Balls' is not displayed.", selenium.isElementPresent(Shop.BANDS_AND_BALLS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Chin up and Push up' link");
		shopPage.goToChinUpAndPushUp();
		assertTrue("Expected text 'Chin up and Push up' is not displayed.", selenium.isElementPresent(Shop.CHINUP_AND_PUSH_UP_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Health Monitors' link");
		shopPage.goToHealthMonitors();
		assertTrue("Expected text 'Health Monitors' is not displayed.", selenium.isElementPresent(Shop.HEALTH_MONITORS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'P90X Equipment' link");
		shopPage.goToP90XEquipment();
		assertTrue("Expected text 'P90X Equipment' is not displayed.", selenium.isElementPresent(Shop.P90X_EQUIPMENT_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Sculpting and Toning' link");
		shopPage.goToSculptingAndToning();
		assertTrue("Expected text 'Sculpting and Toning' is not displayed.", selenium.isElementPresent(Shop.SCULPTING_AND_TONING_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
			
		selenium.logComment("Clicking on 'Yoga' link");
		shopPage.goToYoga();
		assertTrue("Expected text 'Yoga' is not displayed.", selenium.isElementPresent(Shop.YOGA), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Home' link");
		shopPage.clickHomeLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}