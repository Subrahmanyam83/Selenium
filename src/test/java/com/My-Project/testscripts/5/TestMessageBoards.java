package com.tbb.testscripts.connect;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.MessageBoards;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.MessageBoardsPage;

/**
 * 
 * This test script contains test method(s) for Message Board page under Connect module
 * @author Jaya
 */
public class TestMessageBoards extends BaseTest implements MessageBoards{

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
	 * This is data provider for testViewMessageBoards Test Script.
	 */ 
	@DataProvider(name = "viewMessageBoardsDataProvider")
	public Object[][] createMessageBoardsData() {
		return new Object[][] {
				{ "mgupta@beachbody.com", "b@b2011", "The Team Beachbody Message Boards are available 24 hours a day to provide motivation, guidance, and peer support. Whether you're seeking expert advice or just want to talk to people with similar experiences, you'll find helpful and knowledgeable friends on the Message Boards."},
		};
	}
	/**
	 * Positive Test script for verifying viewing of Message Boards Page.
	 * It verifies if all the required elements are present on the Page. 
	 */ 
	@Test (dataProvider = "viewMessageBoardsDataProvider")
	public void testViewMessageBoards(String userName,String password, String message_board_intro){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Clicking on 'Connect' link");
		selenium.logComment("Navigate to 'Message Boards' page");
		selenium.logComment("Clicking on 'Show' link to view How to post photos in your message board threads text.");
		selenium.logComment("Clicking on Hide link to hide How to post photos in your message board threads text.");
		selenium.logComment("Navigating to Categories Tab.");
		selenium.logComment("Navigating to Recent Posts Tab.");
		selenium.logComment("Verifying number of rows displayed on the results of Recent Posts Tab");
		selenium.logComment("Navigating to Statistics Tab.");
		selenium.logComment("Navigating to General Tab in Statistics tab.");
		selenium.logComment("Navigating to Top Posters Tab in Statistics tab.");
		selenium.logComment("Verifying number of rows displayed on the results of Top Posters page.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(userName, password);
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(userName, password);
		}

		selenium.logComment("Clicking on 'Connect' link");
		ConnectPage connectPage = dashboardPage.clickConnectLink();

		selenium.logComment("Navigate to 'Message Boards' page");
		MessageBoardsPage messageBoardsPage = connectPage.goToMessageBoardsPage();

		assertTrue("Expected text "+message_board_intro+ " not found.", (selenium.isTextPresent(message_board_intro)), selenium);

		selenium.logComment("Clicking on 'Show' link to view How to post photos in your message board threads text.");
		messageBoardsPage.viewHowToPostPhotos();
		
		selenium.logComment("Clicking on Hide link to hide How to post photos in your message board threads text.");
		messageBoardsPage.hideHowToPostPhotos();
		
		selenium.logComment("Navigating to Categories Tab.");
		messageBoardsPage.clickCategoriesTab();
		
		assertTrue("Expected Element Search label not found.", (selenium.isElementPresent(MessageBoards.SEARCH_LABEL)), selenium);
		assertTrue("Expected Element Search Textbox not found.", (selenium.isElementPresent(MessageBoards.SEARCH_TEXTBOX)), selenium);
		assertTrue("Expected Element not found.", (selenium.isElementPresent(MessageBoards.SEARCH_BUTTON)), selenium);
		assertTrue("Expected Element not found.", (selenium.isElementPresent(MessageBoards.SEARCH_CHECKBOX)), selenium);
		assertTrue("Expected Element not found.", (selenium.isElementPresent(MessageBoards.SEARCH_IN_THE_CATEGORIES_BELOW_ONLY_LABEL)), selenium);
		assertTrue("Expected Element not found.", (selenium.isElementPresent(MessageBoards.ADVANCED_SEARCH_LINK)), selenium);
		assertTrue("Expected Element not found.", (selenium.isElementPresent(MessageBoards.ANY_OF_THESE_WORDS_OPTION_BUTTON)), selenium);
		assertTrue("Expected Element not found.", (selenium.isElementPresent(MessageBoards.ALL_OF_THESE_WORDS_OPTION_BUTTON)), selenium);
		assertTrue("Expected Element not found.", (selenium.isElementPresent(MessageBoards.EXACT_WORDING_OR_PHRASE_OPTION_BUTTON)), selenium);			
		
		selenium.logComment("Navigating to Recent Posts Tab.");
		messageBoardsPage.clickRecentPostsTab();
		
		assertTrue("Recent Posts Tab table header is not available.", selenium.isElementPresent(MessageBoards.RECENT_POSTS_TABLE_HEADER), selenium );
		
		selenium.logComment("Verifying number of rows displayed on the results of Recent Posts Tab");
		assertTrue("Number of rows displayed is incorrect.", messageBoardsPage.getRecentPostsRowsCount()==20, selenium );
		
		selenium.logComment("Navigating to Statistics Tab.");
		messageBoardsPage.clickStatisticsTab();
		
		selenium.logComment("Navigating to General Tab in Statistics tab.");
		messageBoardsPage.clickGeneralTab();
		assertTrue("Expected text '# of Categories' not found.", (selenium.isTextPresent("# of Categories:")), selenium);
		assertTrue("Expected text '# of Posts' not found.", (selenium.isTextPresent("# of Posts")), selenium);
		assertTrue("Expected text '# of Participants' not found.", (selenium.isTextPresent("# of Participants")), selenium);

		selenium.logComment("Navigating to Top Posters Tab in Statistics tab.");
		messageBoardsPage.clickTopPostersTab();
		
		selenium.logComment("Verifying number of rows displayed on the results of Top Posters page.");
		assertTrue("Number of rows displayed is incorrect.", messageBoardsPage.getTopPostersRowsCount()==20, selenium );
			
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
}