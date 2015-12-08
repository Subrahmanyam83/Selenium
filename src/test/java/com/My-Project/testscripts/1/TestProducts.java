package com.tbb.testscripts.about;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.AboutProducts;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.about.ProductsPage;
import com.tbb.pages.getfit.FitnessProgramsPage;

/**
 * 
 * This test script contains test method(s) for products page under About module
 * @author Jaya
 */
public class TestProducts extends BaseTest{

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
	 * Positive Test script for verifying viewing of About Products Page.
	 * It verifies if all the required elements are present on the Coaches menu. 
	 */ 
	@Test
	public void testProducts(){
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifies whether are on Home page");
		selenium.logComment("Clicks on 'Sign In' Link");
		selenium.logComment("Enters valid username and password");
		selenium.logComment("Clicks on 'About' link");
		selenium.logComment("Clicks on About Products link");
		selenium.logComment("Verifies that all the required elements are present on the Products page.");
		selenium.logComment("Verifies that user can navigate to Work out Now page.");
		selenium.logComment("Clicks on 'About' link");
		selenium.logComment("Clicks on Products link");
		selenium.logComment("Verifies that user can navigate to  page.");
		selenium.logComment("Executes assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		

		
		
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
		
		selenium.logComment("Clicking on 'About' link");
		AboutPage aboutPage = dashboardPage.clickAboutLink();
		
		selenium.logComment("Clicking on About Products link");
		ProductsPage productsPage = aboutPage.goToProductsPage();
		
		selenium.logComment("Verifying that all the required elements are present on the Products page.");
		assertTrue("Expected header is not available", selenium.isElementPresent(AboutProducts.PRODUCTS_HEADER), selenium);
		assertTrue("Expected intro text is not available", selenium.isElementPresent(AboutProducts.PRODUCTS_INTRO_TEXT), selenium);
		assertTrue("Number of products displayed is incorrect.", productsPage.getAllProductsCount()==2, selenium );
		assertTrue("Expected header is not available", selenium.isElementPresent(AboutProducts.FITNESS_PROGRAMS_HEADER), selenium);
		assertTrue("Expected image is not available", selenium.isElementPresent(AboutProducts.FITNESS_PROGRAMS_IMAGE), selenium);
		assertTrue("Expected text is not available", selenium.isElementPresent(AboutProducts.FITNESS_PROGRAMS_TEXT), selenium);
		assertTrue("Expected link is not available", selenium.isElementPresent(AboutProducts.FIND_YOUR_IDEAL_FITNESS_PROGRAM_NOW_LINK), selenium);
		assertTrue("Expected header is not available", selenium.isElementPresent(AboutProducts.NUTRITION_AND_SUPPLEMENTS_HEADER), selenium);
		assertTrue("Expected image is not available", selenium.isElementPresent(AboutProducts.NUTRITION_AND_SUPPLEMENTS_IMAGE), selenium);
		assertTrue("Expected text is not available", selenium.isElementPresent(AboutProducts.NUTRITION_AND_SUPPLEMENTS_TEXT), selenium);
		assertTrue("Expected link is not available", selenium.isElementPresent(AboutProducts.FIND_A_SUPPLEMENT_NOW_LINK), selenium);
			
		selenium.logComment("Verifying that user can navigate to Work out Now page.");
		FitnessProgramsPage fitnessProgramsPage = productsPage.clickFindYourIdealFitnessProgramNowLink();
		
		selenium.logComment("Clicking on 'About' link");
		aboutPage = fitnessProgramsPage.clickAboutLink();
		
		selenium.logComment("Clicking on Products link");
		productsPage = aboutPage.goToProductsPage();
		
		selenium.logComment("Verifying that user can navigate to  page.");
		productsPage.clickFindaSupplementNowLink();		
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		}
}