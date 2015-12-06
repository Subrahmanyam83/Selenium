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
 * This test script contains test method(s) for Trainer page under Shop By menu.
 * @author Jaya
 */
public class TestTrainerShop extends BaseTest{

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
		selenium.logComment("Clicking on 'Trainer' link");
		selenium.logComment("Clicking on 'Brett Hoebel' link");
		selenium.logComment("Clicking on 'Chalene Johnson' link");
		selenium.logComment("Clicking on 'Debbie Siebers' link");
		selenium.logComment("Clicking on 'Donna Richardson' link");
		selenium.logComment("Clicking on 'Gillian and Teigh' link");
		selenium.logComment("Clicking on 'Kathy Smith' link");
		selenium.logComment("Clicking on 'Leandro Carvalho' link");
		selenium.logComment("Clicking on 'SHAUN T' link");
		selenium.logComment("Clicking on 'SHAUN T en Espanol' link");
		selenium.logComment("Clicking on 'Tony Horton' link");
		selenium.logComment("Clicking on 'Tony Horton en Espanol' link");
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
		
		selenium.logComment("Clicking on 'Trainer' link");
		shopPage.goToTrainerPage();
		
		selenium.logComment("Clicking on 'Brett Hoebel' link");
		shopPage.goToBrettHoebel();
		assertTrue("Expected text 'Brett Hoebel' is not displayed.", selenium.isElementPresent(Shop.BRETT_HOEBEL_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Chalene Johnson' link");
		shopPage.goToChaleneJohnson();
		assertTrue("Expected text 'Chalene Johnson' is not displayed.", selenium.isElementPresent(Shop.CHALENE_JOHNSON_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Debbie Siebers' link");
		shopPage.goToDebbieSiebers();
		assertTrue("Expected text 'Debbie Siebers' is not displayed.", selenium.isElementPresent(Shop.DEBBIE_SIEBERS_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Donna Richardson' link");
		shopPage.goToDonnaRichardsonJoyner();
		assertTrue("Expected text 'Donna Richardson' is not displayed.", selenium.isElementPresent(Shop.DONNA_RICHARDSON_JOYNER_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Gillian and Teigh' link");
		shopPage.goToGillianAndTeigh();
		assertTrue("Expected text 'Gillian and Teigh' is not displayed.", selenium.isElementPresent(Shop.GILLIAN_AND_TEIGH_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Kathy Smith' link");
		shopPage.goToKathySmith();
		assertTrue("Expected text 'Kathy Smith' is not displayed.", selenium.isElementPresent(Shop.KATHY_SMITH_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Leandro Carvalho' link");
		shopPage.goToLeandroCarvalho();
		assertTrue("Expected text 'Leandro Carvalho' is not displayed.", selenium.isElementPresent(Shop.LEANDRO_CARVALHO_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'SHAUN T' link");
		shopPage.goToSHAUNT();
		assertTrue("Expected text 'SHAUN T' is not displayed.", selenium.isElementPresent(Shop.SHAUN_T_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'SHAUN T en Espanol' link");
		shopPage.goToSHAUNTEnEspanol();
		assertTrue("Expected text 'SHAUN T en Espanol' is not displayed.", selenium.isElementPresent(Shop.SHAUN_T_EN_ESPANOL_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Tony Horton' link");
		shopPage.goToTonyHorton();
		assertTrue("Expected text 'Tony Horton' is not displayed.", selenium.isElementPresent(Shop.TONY_HORTON_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
		
		selenium.logComment("Clicking on 'Tony Horton en Espanol' link");
		shopPage.goToTonyHortonEnEspanol();
		assertTrue("Expected text 'Tony Horton en Espanol' is not displayed.", selenium.isElementPresent(Shop.TONY_HORTON_EN_ESPNOL_HEADER), selenium);
		assertTrue("No Add to Cart buttons are not displayed", shopPage.getAddToCartBtnCount()>0, selenium );
			
		selenium.logComment("Clicking on 'Home' link");
		shopPage.clickHomeLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}