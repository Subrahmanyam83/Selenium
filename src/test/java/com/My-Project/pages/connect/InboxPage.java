package com.tbb.pages.connect;

//import static com.tbb.framework.BaseTest.assertTrue;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.Inbox;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;

/**
 * 
 * Page Object encapsulates the Inbox Page
 * @author Gaurav
 */
public class InboxPage  extends BaseTest {
	private LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Inbox Page.
	 * @param	selenium
	 */
	public InboxPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Inbox Page Class");
		assertTrue(
				"This is not Inbox page, current page is: "
				+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Inbox"), selenium);
	}

	/**
	 * Clicks on Inbox link.
	 */
	public void clickInbox() {
		selenium.click(Inbox.INBOX_LINK);
	}

	/**
	 * Clickx on Drafts Link. 
	 */
	public void clickDrafts() {
		selenium.click(Inbox.DRAFTS_LINK);
	}

	/**
	 * Clicks on Sent Messages link.
	 */
	public void clickSentMessages() {
		selenium.click(Inbox.SENT_MESSAGES_LINK);
	}

	/**
	 * Clicks on Trash Link. 
	 */
	public void clickTrash() {
		selenium.click(Inbox.TRASH_LINK);
	}

	/**
	 * Clicks on Compose Message Link.
	 */
	public void clickComposeMessage() {
		selenium.click(Inbox.COMPOSE_MESSAGE_LINK);
	}

	/**
	 * Clicks on SELECT: ALL link on Inbox Page.
	 */
	public void clickSelectAll() {
		selenium.click(Inbox.SELECT_ALL);
	}

	/**
	 * Clicks on SELECT: NONE on Inbox Page. 
	 */
	public void clickSelectNone() {
		selenium.click(Inbox.SELECT_NONE);
	}

	/**
	 * Clicks on SELECT: READ on Inbox Page.
	 */
	public void clickSelectRead() {
		selenium.click(Inbox.SELECT_READ);
	}

	/**
	 * Clicks on SELECT: UNREAD on Inbox Page. 
	 */
	public void clickSelectUnread() {
		selenium.click(Inbox.SELECT_UNREAD);
	}

	/**
	 * Checks whether there is any message in the container
	 * @return True   If 'No Messages found' text is not displayed. 
	 * 		   False  If 'No Messages found' text is displayed.
	 */
	public boolean messageExits() {
		if (selenium.waitForTextNotPresent("Loading Messages...")) {
			if(selenium.isTextPresent("No messages found.")) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Returns number of messages in the table
	 * @return int
	 */
	public int getNumberOfMessages() {
		return (selenium.getXpathCount(Inbox.MESSAGE_ROW).intValue());
	}	

	/**
	 * Returns number of Read messages in the table
	 * @return int
	 */
	public int getNumberOfReadMessages() {
		return (selenium.getXpathCount(Inbox.READ_MESSAGE_ROW).intValue());
	}

	/**
	 * Returns number of Unread messages in the table
	 * @return int
	 */
	public int getNumberOfUnreadMessages() {
		return (selenium.getXpathCount(Inbox.UNREAD_MESSAGE_ROW).intValue());
	}

	/**
	 * Types Buddy name and subject of the Inbox compose message Page and clicks on send. 
	 * @param buddyName
	 * @param subject
	 * @param content
	 */
	public void sendMessage(String buddyName, String subject, String content) {
		selenium.type(Inbox.COMPOSE_MESSAGE_SEND_TO_TEXTAREA, buddyName);
		selenium.type(Inbox.COMPOSE_MESSAGE_SEND_SUBJECT_TEXTBOX, subject);
		selenium.click(Inbox.COMPOSE_MESSAGE_SEND_BUTTON);
	}

	/**
	 * Clicks on Sign Out link to sign out of the web site. 
	 * @return HomePage
	 */
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);
	}
}
