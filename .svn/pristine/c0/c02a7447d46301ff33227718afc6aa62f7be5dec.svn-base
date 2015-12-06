package com.tbb.testscripts.connect;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.Inbox;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.InboxPage;

/**
 * 
 * This test script contains test method(s) for Inbox page under Connect module
 * @author Gaurav
 */
public class TestInboxPage extends BaseTest {


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
	 * This test verifies that user is able to open all pages viz. Inbox, Drafts, Compose and Sent pages.
	 */
	@Test
	public void testInboxDraftsSentMessagesTrashComposeMessage() {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName + ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Home' link");
		selenium.logComment("Clicking on 'Go To Inbox' link");
		selenium.logComment("Clicking Inbox Link");
		selenium.logComment("Verifying Inbox Page has opened");
		selenium.logComment("Clicking Drafts Link");
		selenium.logComment("Verifying Drafts Page has opened");
		selenium.logComment("Clicking Sent Messages Link");
		selenium.logComment("Verifying Sent Messages Page has opened");
		selenium.logComment("Clicking Trash Link");
		selenium.logComment("Verifying Trash Page has opened");
		selenium.logComment("Clicking Compose Message Link");
		selenium.logComment("Verifying Compose Page has opened");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");	
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}

		selenium.logComment("Clicking on 'Home' link");
		homePage = dashboardPage.clickHome();

		selenium.logComment("Clicking on 'Go To Inbox' link");
		InboxPage inboxPage = homePage.goToInbox();
	

		selenium.logComment("Clicking Inbox Link");
		inboxPage.clickInbox();

		selenium.logComment("Verifying Inbox Page has opened");
		boolean condition =  selenium.waitForTextPresent("From") ||  selenium.waitForTextPresent("No messages found.");
		assertTrue("Required Text Not found", condition, selenium);
	

		selenium.logComment("Clicking Drafts Link");
		inboxPage.clickDrafts();		

		selenium.logComment("Verifying Drafts Page has opened");
		condition =  selenium.waitForTextPresent("Subject") ||  selenium.waitForTextPresent("No messages found.");
		assertTrue("Required Text Not found", condition, selenium);	
	

		selenium.logComment("Clicking Sent Messages Link");
		inboxPage.clickSentMessages();

		selenium.logComment("Verifying Sent Messages Page has opened");
		condition =  selenium.waitForTextPresent("To") ||  selenium.waitForTextPresent("No messages found.");
		assertTrue("Required Text Not found", condition, selenium);	
	

		selenium.logComment("Clicking Trash Link");
		inboxPage.clickTrash();		

		selenium.logComment("Verifying Trash Page has opened");
		condition =  selenium.waitForEitherTextPresent("Subject", "No messages found.");
		assertTrue("Required Text Not found", condition, selenium);	
	

		selenium.logComment("Clicking Compose Message Link");
		inboxPage.clickComposeMessage();		

		selenium.logComment("Verifying Compose Page has opened");
		condition =  selenium.waitForElementPresent(Inbox.COMPOSE_MESSAGE_DISCARD_BUTTON); 
		assertTrue("Required Element Not found", condition, selenium);	
		

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();				
	}

	/**
	 * This test verifies that user is able to select all, none, read and unread messages from a list of given messages.
	 */
	@Test
	public void testSelectAllNoneReadUnread() {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName + ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Home' link");
		selenium.logComment("Clicking on 'Go To Inbox' link from Inbox User Dock show in User Status Bar");
		selenium.logComment("Clicking Inbox Link");
		selenium.logComment("Verifying Inbox Page has opened");
		selenium.logComment("Verifying Inbox Page has opened");
		selenium.logComment("Verifying whether there any any messages on Inbox Page");
		selenium.logComment("Getting number of Messages from message table");
		selenium.logComment("Selecting All Messages");
		selenium.logComment("Verifying all messages are selected");
		selenium.logComment("There are no messages");
		selenium.logComment("Selecting None Messages");
		selenium.logComment("Verifying no messages is selected");
		selenium.logComment("There are no messages");
		selenium.logComment("Selecting Read Messages");
		selenium.logComment("Verifying all Read message are selected");
		selenium.logComment("There are no read messages");
		selenium.logComment("Selecting Unread Messages");
		selenium.logComment("Verifying all Unread Messages are selected");
		selenium.logComment("There are no Unread messages");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}

		selenium.logComment("Clicking on 'Home' link");
		homePage = dashboardPage.clickHome();

		selenium.logComment("Clicking on 'Go To Inbox' link from Inbox User Dock show in User Status Bar");
		InboxPage inboxPage = homePage.goToInbox();

		selenium.logComment("Clicking Inbox Link");
		inboxPage.clickInbox();		

		selenium.logComment("Verifying Inbox Page has opened");
		boolean condition =  selenium.waitForTextPresent("From") ||  selenium.waitForTextPresent("No messages found.");
		assertTrue("Required Text Not found", condition, selenium);
	

		selenium.logComment("Verifying whether there any any messages on Inbox Page");
		assertTrue("There are no messages", inboxPage.messageExits(), selenium);

		selenium.logComment("Getting number of Messages from message table");
		int messagesCount = inboxPage.getNumberOfMessages() - 1;
		selenium.logComment("Number of message = " + messagesCount);

		selenium.logComment("Selecting All Messages");
		inboxPage.clickSelectAll();
	

		selenium.logComment("Verifying all messages are selected");
		if(inboxPage.getNumberOfMessages() > 0) {
			for(int i=2; i<=inboxPage.getNumberOfMessages(); i++) {
				boolean isChecked = selenium.isChecked(Inbox.MESSAGE_ROW + "[" + i + "]/td/input");
				assertTrue("Message is not checked", isChecked, selenium);
			} 
		} else
			selenium.logComment("There are no messages");

		selenium.logComment("Selecting None Messages");
		inboxPage.clickSelectNone();
	

		selenium.logComment("Verifying no messages is selected");
		if(inboxPage.getNumberOfMessages() > 0) {
			for(int i=2; i<=inboxPage.getNumberOfMessages(); i++) {
				boolean isChecked = selenium.isChecked(Inbox.MESSAGE_ROW + "[" + i + "]/td/input");
				assertTrue("Message is checked, while it should not be", !isChecked, selenium);
			}
		} else
			selenium.logComment("There are no messages");

		selenium.logComment("Selecting Read Messages");
		inboxPage.clickSelectRead();
	

		selenium.logComment("Verifying all Read message are selected");
		if(inboxPage.getNumberOfReadMessages() > 0) {
			for(int i=1; i<=inboxPage.getNumberOfReadMessages(); i++) {
				boolean isChecked = selenium.isChecked(Inbox.READ_MESSAGE_ROW + "[" + i + "]//input");
				assertTrue("Read Message is not checked", isChecked, selenium);
			}

		} else
			selenium.logComment("There are no read messages");

		selenium.logComment("Selecting Unread Messages");
		inboxPage.clickSelectUnread();
	

		selenium.logComment("Verifying all Unread Messages are selected");
		if(inboxPage.getNumberOfUnreadMessages() > 0) {
			for(int i=1; i<=inboxPage.getNumberOfUnreadMessages(); i++) {
				boolean isChecked = selenium.isChecked(Inbox.UNREAD_MESSAGE_ROW + "[" + i + "]//input");
				assertTrue("Unread Message is not checked", isChecked, selenium);
			}

		} else
			selenium.logComment("There are no Unread messages");

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();

	}


	/**
	 * This test verifies that user is able to compose and send a message to buddy.
	 */
	@Test
	public void testComposeMessage() {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName + ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Getting and verifying number of buddies for this user");
		selenium.logComment("Getting Names of all Buddies");
		selenium.logComment("Clicking on 'Home' link");
		selenium.logComment("Clicking on 'Go To Inbox' link from Inbox User Dock show in User Status Bar");
		selenium.logComment("Clicking 'Compose Message' link");
		selenium.logComment("Verifying Compose Page has opened");
		selenium.logComment("Sending message to a buddy");
		selenium.logComment("Verifying message has been sent");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}

		selenium.logComment("Getting and verifying number of buddies for this user");
		assertTrue("There are no buddies for this user so no message can be sent", dashboardPage.getBuddiesCount() > 0, selenium);

		selenium.logComment("Getting Names of all Buddies");
		String[] buddiesNames = dashboardPage.getBuddiesNames();

		selenium.logComment("Clicking on 'Home' link");
		homePage = dashboardPage.clickHome();

		selenium.logComment("Clicking on 'Go To Inbox' link from Inbox User Dock show in User Status Bar");
		InboxPage inboxPage = homePage.goToInbox();		

		selenium.logComment("Clicking 'Compose Message' link");
		inboxPage.clickComposeMessage();

		selenium.logComment("Verifying Compose Page has opened");
		boolean condition =  selenium.waitForElementPresent(Inbox.COMPOSE_MESSAGE_DISCARD_BUTTON); 
		assertTrue("Required Element Not found", condition, selenium);	

		selenium.logComment("Sending message to a buddy");
		inboxPage.sendMessage("JAsnani", "Hello from Automation Framework", "As of now content is not being used");

		selenium.logComment("Verifying message has been sent");
		assertTrue("Update message 'Your message has been sent.' is not displayed", selenium.waitForTextPresent("Your message has been sent."), selenium);

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();				
	}
}
