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
 * This test script contains test method(s) for Fitness Programs page under 'Shop By' menu.
 * @author Jaya
 */
public class TestFitnessProgramShop extends BaseTest{

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
	 * Positive Test script for verifying viewing of Shop Page.
	 * It verifies if all the required elements are present on Shop Page. 
	 */ 
	@Test
	public void testFitnessProgramShop(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Shop' link");
		selenium.logComment("Clicking on 'Fitness Program' link");
		selenium.logComment("Clicking on '10-Minute Trainer' link");
		selenium.logComment("Clicking on 'Asylum' link");
		selenium.logComment("Clicking on 'Best Sellers' link");
		selenium.logComment("Clicking on 'Body Gospel' link");
		selenium.logComment("Clicking on 'Brazil Butt Lift' link");
		selenium.logComment("Clicking on 'ChaLEAN Extreme' link");
		selenium.logComment("Clicking on 'Hip Hop Abs' link");
		selenium.logComment("Clicking on 'INSANITY' link");
		selenium.logComment("Clicking on 'KSPY T2' link");
		selenium.logComment("Clicking on 'More Programs' link");
		selenium.logComment("Clicking on 'New Products' link");
		selenium.logComment("Clicking on 'P90X' link");
		selenium.logComment("Clicking on 'P90X One on One' link");
		selenium.logComment("Clicking on 'Power 90' link");
		selenium.logComment("Clicking on 'RevAbs' link");
		selenium.logComment("Clicking on 'Rockin Body' link");
		selenium.logComment("Clicking on 'Slim in 6' link");
		selenium.logComment("Clicking on 'Total Body Solution' link");
		selenium.logComment("Clicking on 'Turbo Jam' link");
		selenium.logComment("Clicking on 'TurboFire' link");
		selenium.logComment("Clicking on 'Yoga Booty Ballet' link");
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
		
		selenium.logComment("Clicking on 'Fitness Program' link");
		shopPage.goToFitnessProgramsPage();
		
		selenium.logComment("Clicking on '10-Minute Trainer' link");
		shopPage.goToTenMinuteTrainer();
		assertTrue("Expected text '10-Minute Trainer' is not displayed.", selenium.isElementPresent(Shop.TEN_MINUTE_TRAINER_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Asylum' link");
		shopPage.goToAsylum();
		assertTrue("Expected text 'Asylum' is not displayed.", selenium.isElementPresent(Shop.ASYLUM_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Best Sellers' link");
		shopPage.goToFitnessProgramBestSellers();
		assertTrue("Expected text 'Best Sellers' is not displayed.", selenium.isElementPresent(Shop.BEST_SELLERS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Body Gospel' link");
		shopPage.goToBodyGospel();
		assertTrue("Expected text 'Body Gospel' is not displayed.", selenium.isElementPresent(Shop.BODY_GOSPEL_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Brazil Butt Lift' link");
		shopPage.goToBrazilButtLift();
		assertTrue("Expected text 'Brazil Butt Lift' is not displayed.", selenium.isElementPresent(Shop.BRAZIL_BUTT_LIFT_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'ChaLEAN Extreme' link");
		shopPage.goToChaleanExtreme();
		assertTrue("Expected text 'ChaLEAN Extreme' is not displayed.", selenium.isElementPresent(Shop.CHALEAN_EXTREME_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Hip Hop Abs' link");
		shopPage.goToHipHopAbs();
		assertTrue("Expected text 'Hip Hop Abs' is not displayed.", selenium.isElementPresent(Shop.HIP_HOP_ABS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'INSANITY' link");
		shopPage.goToInsanity();
		assertTrue("Expected text 'INSANITY' is not displayed.", selenium.isElementPresent(Shop.INSANITY_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'KSPY T2' link");
		shopPage.goToKSPYT2();
		assertTrue("Expected text 'KSPY T2' is not displayed.", selenium.isElementPresent(Shop.KSPY_T2_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'More Programs' link");
		shopPage.goToMorePrograms();
		assertTrue("Expected text 'More Programs' is not displayed.", selenium.isElementPresent(Shop.MORE_PROGRAMS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'New Products' link");
		shopPage.goToNewProducts();
		assertTrue("Expected text 'New Products' is not displayed.", selenium.isElementPresent(Shop.NEW_PRODUCTS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'P90X' link");
		shopPage.goToP90X();
		assertTrue("Expected text 'P90X' is not displayed.", selenium.isElementPresent(Shop.P90X_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'P90X One on One' link");
		shopPage.goToP90XOneOnOne();
		assertTrue("Expected text 'P90X One on One' is not displayed.", selenium.isElementPresent(Shop.P90X_ONE_ON_ONE_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Power 90' link");
		shopPage.goToPower90();
		assertTrue("Expected text 'Power 90' is not displayed.", selenium.isElementPresent(Shop.POWER_90_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'RevAbs' link");
		shopPage.goToRevAbs();
		assertTrue("Expected text 'RevAbs' is not displayed.", selenium.isElementPresent(Shop.REVABS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Rockin Body' link");
		shopPage.goToRockinBody();
		assertTrue("Expected text 'Rockin Body' is not displayed.", selenium.isElementPresent(Shop.ROCKING_BODY_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Slim in 6' link");
		shopPage.goToSlimIn6();
		assertTrue("Expected text 'Slim in 6' is not displayed.", selenium.isElementPresent(Shop.SLIM_IN_6_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Total Body Solution' link");
		shopPage.goToTotalBodySolution();
		assertTrue("Expected text 'Total Body Solution' is not displayed.", selenium.isElementPresent(Shop.TOTAL_BODY_SOLUTION_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Turbo Jam' link");
		shopPage.goToTurboJam();
		assertTrue("Expected text 'Turbo Jam' is not displayed.", selenium.isElementPresent(Shop.TURBO_JAM_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'TurboFire' link");
		shopPage.goToTurboFire();
		assertTrue("Expected text 'TurboFire' is not displayed.", selenium.isElementPresent(Shop.TURBO_FIRE_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Yoga Booty Ballet' link");
		shopPage.goToYogaBootyBallet();
		assertTrue("Expected text 'Yoga Booty Ballet' is not displayed.", selenium.isElementPresent(Shop.YOGA_BOOTY_BALLET_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Home' link");
		shopPage.clickHomeLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}