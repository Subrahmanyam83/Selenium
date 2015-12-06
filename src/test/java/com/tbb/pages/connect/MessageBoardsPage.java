package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.MessageBoards;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.about.AboutPage;
/**
 * 
 * Page Object encapsulates the Message Boards Page
 * @author Jaya
 */
public class MessageBoardsPage  extends BaseTest implements MessageBoards{

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Message Boards Page.
	 * @param	selenium
	 */
	public MessageBoardsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Message Boards Page");
		this.selenium = selenium;
		assertTrue("This is not Message Boards Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Message Boards"), selenium);
	}
	
	/**
	 * Clicks on Connect link in the top menu bar. 
	 * @return Connect Page
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ConnectPage(selenium);
	}
	
	/**
	 * Clicks on 'Show' link to view How to Post text.
	 */
	public void viewHowToPostPhotos() {
		selenium.click(HOW_TO_POST_SHOW_LINK);
		selenium.waitForElementPresent(HOW_TO_POST_TEXT);
	}
	
	/**
	 * Clicks on 'Hide' link to hide How to Post text. 
	 */
	public void hideHowToPostPhotos() {
		selenium.click(HOW_TO_POST_HIDE_LINK);
		selenium.waitForElementPresent(HOW_TO_POST_SHOW_LINK);
	}
	
	/**
	 * Clicks on Categories Tab.
	 */
	public void clickCategoriesTab() {
		selenium.click(CATEGORIES_TAB);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
	
	/**
	 * Clicks on My Posts Tab.
	 */
	public void clickMyPostsTab() {
		selenium.click(MY_POSTS_TAB);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}
	
	/**
	 * Clicks on My Subscriptions Tab. 
	 */
	public void clickMySubscriptionsTab() {
		selenium.click(MY_SUBSCRIPTIONS_TAB);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}
	
	/**
	 * Clicks on Recent Posts Tab. 
	 */
	public void clickRecentPostsTab() {
		selenium.click(RECENT_POSTS_TAB);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}
	
	/**
	 * Clicks on Statistics Tab.
	 */
	public void clickStatisticsTab() {
		selenium.click(STATISTICS_TAB);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}
	
	/**
	 * Clicks on Banned Users Tab. 
	 */
	public void clickBannedUsersTab() {
		selenium.click(BANNED_USRS_TAB);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on General Tab. 
	 */
	public void clickGeneralTab() {
		selenium.click(MessageBoards.GENERAL_TAB);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Top Posters Tab. 
	 */
	public void clickTopPostersTab() {
		selenium.click(MessageBoards.TOP_POSTERS_TAB);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Returns the number of rows of Top Posters displayed on the page. 
	 * @return int
	 */
	public int getTopPostersRowsCount() {
		return selenium.getXpathCount(MessageBoards.ALL_TOP_POSTERS_RESULTS).intValue();
	}

	/*public void clickLastArrow() {
		selenium.click(MessageBoards.TOP_ENABLED_LAST_ARROW);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	public void clickFirstArrow() {
		selenium.click(MessageBoards.TOP_ENABLED_FIRST_ARROW);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	public void clickNextArrow() {
		selenium.click(MessageBoards.TOP_ENABLED_NEXT_ARROW);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	public void clickPrevArrow() {
		selenium.click(MessageBoards.TOP_ENABLED_PREVIOUS_ARROW);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}*/

	/**
	 * Returns the number of recent posts rows.
	 * @return int 
	 */
	public int getRecentPostsRowsCount() {
		int row = selenium.getXpathCount(MessageBoards.ALL_RECENT_POSTS_ODD_ROWS).intValue();
		int altrow = selenium.getXpathCount(MessageBoards.ALL_RECENT_POSTS_EVEN_ROWS).intValue();
		return (row+altrow);
	}

	/**
	 * Clicks on About Link on top menu bar. Navigates user to About Page. 
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click("css=li a>span:contains(About)");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}	
}