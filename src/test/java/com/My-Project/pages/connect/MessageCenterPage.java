package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.about.AboutPage;
/**
 * 
 * Page Object encapsulates the Message Center Page
 * @author Gaurav
 */
public class MessageCenterPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Message Center Page.
	 * @param	selenium
	 */
	public MessageCenterPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Message Center Page");
		this.selenium = selenium;
		assertTrue("This is not Message Center Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Message Center"), selenium);
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
     * Clicks on About Link in the top menu bar
     * @return About Page
     */
	public AboutPage clickAboutLink() {
		selenium.click(Dashboard.ABOUT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}
}