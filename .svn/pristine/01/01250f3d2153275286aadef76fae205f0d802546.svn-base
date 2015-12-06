package com.tbb.testscripts.connect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.SuccessStories;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.SuccessStoriesPage;

/**
 * 
 * This test script contains test method(s) for Success Stories page under Connect module
 * @author Jaya
 */

public class TestSuccessStories extends BaseTest implements SuccessStories{

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
	 * This is data provider for testViewSuccessStories Test Script.
	 */ 
	@DataProvider(name = "viewSuccessStoriesDataProvider")
	public Object[][] createSuccessStoriesData() {
		return new Object[][] {
				{ "5", "2"},
		};
	}
	/**
	 * Positive Test script for verifying viewing of Success Stories Page.
	 * It verifies if all the required elements are present on the Page. 
	 */ 
	@Test (dataProvider = "viewSuccessStoriesDataProvider")
	public void testViewSuccessStories(String items_per_page_value, String page_number){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Connect' link");
		selenium.logComment("Navigate to 'Success Story' page");
		selenium.logComment("Verifying that all the required elements are present in the top results bar.");
		selenium.logComment("Verifying the bottom results label matches the top results label.");
		selenium.logComment("Verifying Gender/Age dropdown values are correct.");
		selenium.logComment("Verifying the top results bar elements based on number of search results.");
		selenium.logComment("Verifying the bottom results bar elements based on number of search results.");
		selenium.logComment("Verifying navigating to last page in search results.");
		selenium.logComment("Verifying navigating to first page in search results.");
		selenium.logComment("Verifying navigating to next page in search results.");
		selenium.logComment("Verifying navigating to previous page in search results.");
		selenium.logComment("Verifying Items per Page dropdown values are correct.");
		selenium.logComment("Verifying number of rows displayed on the Success Stories page.");
		selenium.logComment("Verifying the items per page dropdown is working correctly. Changing the drop down value is changing the number of rows displayed.");
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

		selenium.logComment("Clicking on 'Connect' link");
		ConnectPage connectPage = dashboardPage.clickConnectLink();

		selenium.logComment("Navigate to 'Success Story' page");
		SuccessStoriesPage successStoriesPage = connectPage.goToSuccessStoriesPage();

		selenium.logComment("Verifying that all the required elements are present in the top results bar.");
		assertTrue("Expected page header is not displayed.", selenium.isElementPresent(SUCCESS_STORY_HEADER), selenium);
		assertTrue("Expected Gender/Age label is not displayed.", selenium.isElementPresent(GENDER_AGE_LABEL), selenium);
		assertTrue("Expected Gender/Age drop down is not displayed.", selenium.isElementPresent(GENDER_AGE_DROPDOWN), selenium);	
		assertTrue("Expected search results label is not displayed at the top of the page.", selenium.isElementPresent(TOP_RESULTS_LABEL), selenium);
		assertTrue("Expected search results label is not displayed at the top of the page.", selenium.isElementPresent(BOTTOM_RESULTS_LABEL), selenium);

		selenium.logComment("Verifying the bottom results label matches the top results label.");	
		String topResultsLabel = selenium.getText(TOP_RESULTS_LABEL);
		assertTrue("Expected search results at the top of the page do not match the results at the bottom of the page.", (selenium.getText(BOTTOM_RESULTS_LABEL)).equals(topResultsLabel), selenium);

		selenium.logComment("Verifying Gender/Age dropdown values are correct.");
		assertTrue("Expected Gender/Age dropdown values are not correct.", Arrays.equals(successStoriesPage.getGenderAgeDropdownValues(), new String[]{"","Male: 18-29","Female: 18-29", "Male: 30-39", "Female: 30-39", "Male: 40-49", "Female: 40-49", "Male: 50+", "Female: 50+"}), selenium);

		assertTrue("Expected table header is not displayed at the top of the page.", selenium.isElementPresent(TABLE_HEADER), selenium);

		/* If Success story results have more than one page, then 'Showing 1-20 of n results' is displayed, along with the drop downs for items, pages and navigation arrows. 
		 * If Success Story results have only one page, then 'Showing n results' is displayed, and drop downs for items, pages and navigation arrows are hidden.  
		 * Verifying the elements of the page based on the above logic. 
		 */		
		if(topResultsLabel.contains("of")){

			selenium.logComment("Verifying the top results bar elements based on number of search results.");
			assertTrue("Expected items per page label is not displayed at the top of the page.", selenium.isElementPresent(TOP_ITEMS_PER_PAGE_LABEL), selenium);
			assertTrue("Expected items per page drop down is not displayed at the top of the page.", selenium.isElementPresent(TOP_ITEMS_PER_PAGE_DROPDOWN), selenium);
			assertTrue("Expected Page number selector label is not displayed at the top of the page.", selenium.isElementPresent(TOP_PAGE_LABEL), selenium);
			assertTrue("Expected First navigator arrow is not displayed at the top of the page.", selenium.isElementPresent(DISABLED_TOP_FIRST_ARROW), selenium);
			assertTrue("Expected Previous navigator arrow is not displayed at the top of the page.", selenium.isElementPresent(DISABLED_TOP_PREVIOUS_ARROW), selenium);
			assertTrue("Expected Next navigator arrow is not displayed at the top of the page.", selenium.isElementPresent(ENABLED_TOP_NEXT_ARROW), selenium);
			assertTrue("Expected Last navigator arrow is not displayed at the top of the page.", selenium.isElementPresent(ENABLED_TOP_LAST_ARROW), selenium);

			selenium.logComment("Verifying the bottom results bar elements based on number of search results.");		
			assertTrue("Expected items per page label is not displayed at the bottom of the page.", selenium.isElementPresent(BOTTOM_ITEMS_PER_PAGE_LABEL), selenium);
			assertTrue("Expected Page number selector label is not displayed at the bottom of the page.", selenium.isElementPresent(BOTTOM_PAGE_LABEL), selenium);
			assertTrue("Expected First navigator arrow is not displayed at the bottom of the page.", selenium.isElementPresent(BOTTOM_FIRST_ARROW), selenium);
			assertTrue("Expected Previous navigator arrow is not displayed at the bottom of the page.", selenium.isElementPresent(BOTTOM_PREVIOUS_ARROW), selenium);
			assertTrue("Expected Next navigator arrow is not displayed at the bottom of the page.", selenium.isElementPresent(BOTTOM_NEXT_ARROW), selenium);
			assertTrue("Expected Last navigator arrow is not displayed at the bottom of the page.", selenium.isElementPresent(BOTTOM_LAST_ARROW), selenium);

			selenium.logComment("Verifying navigating to last page in search results.");	
			successStoriesPage.navigateToLastPage();
			assertTrue("First arrow is not enabled.", selenium.isVisible(ENABLED_TOP_FIRST_ARROW), selenium);
			assertTrue("Prev arrow is not enabled.", selenium.isVisible(ENABLED_TOP_PREVIOUS_ARROW), selenium);
			assertTrue("Next arrow is enabled.", selenium.isVisible(DISABLED_TOP_NEXT_ARROW), selenium);
			assertTrue("Last arrow is enabled.", selenium.isVisible(DISABLED_TOP_LAST_ARROW), selenium);

			selenium.logComment("Verifying navigating to first page in search results.");
			successStoriesPage.navigateToFirstPage();
			assertTrue("First arrow is enabled.", selenium.isVisible(DISABLED_TOP_FIRST_ARROW), selenium);
			assertTrue("Prev arrow is enabled.", selenium.isVisible(DISABLED_TOP_PREVIOUS_ARROW), selenium);
			assertTrue("Next arrow is not enabled.", selenium.isVisible(ENABLED_TOP_NEXT_ARROW), selenium);
			assertTrue("Last arrow is not enabled.", selenium.isVisible(ENABLED_TOP_LAST_ARROW), selenium);

			selenium.logComment("Verifying navigating to next page in search results.");
			successStoriesPage.navigateToNextPage();
			assertTrue("First arrow is not enabled.", selenium.isVisible(ENABLED_TOP_FIRST_ARROW), selenium);
			assertTrue("Prev arrow is not enabled.", selenium.isVisible(ENABLED_TOP_PREVIOUS_ARROW), selenium);

			selenium.logComment("Verifying navigating to previous page in search results.");
			successStoriesPage.navigateToPrevPage();
			assertTrue("Next arrow is not enabled.", selenium.isVisible(ENABLED_TOP_NEXT_ARROW), selenium);
			assertTrue("Last arrow is not enabled.", selenium.isVisible(ENABLED_TOP_LAST_ARROW), selenium);	 		

			selenium.logComment("Verifying Items per Page dropdown values are correct.");
			assertTrue("Expected Items per Page dropdown values are not correct.", Arrays.equals(successStoriesPage.getItemsPerPageDropdownValues(), new String[]{"5","10","20","30","50","75"}), selenium);

			selenium.logComment("Verifying number of rows displayed on the Success Stories page.");
			String items_per_page = selenium.getSelectedValue(TOP_ITEMS_PER_PAGE_DROPDOWN);
			assertTrue("Number of rows displayed is incorrect.", successStoriesPage.getRowsCount()==(Integer.parseInt(items_per_page)), selenium );

			selenium.logComment("Verifying the items per page dropdown is working correctly. Changing the drop down value is changing the number of rows displayed.");
			successStoriesPage.selectItemsPerPage(items_per_page_value);	
			assertTrue("Number of rows displayed is incorrect.", successStoriesPage.getRowsCount()==(Integer.parseInt(items_per_page_value)), selenium );
		}		
				
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
}