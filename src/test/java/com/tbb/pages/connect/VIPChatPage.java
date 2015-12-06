package com.tbb.pages.connect;


import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the VIP Chat Rooms Page
 * @author Gaurav
 */
public class VIPChatPage extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on VIP Chat Rooms Page.
	 * @param	selenium
	 */
	public VIPChatPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of VIP Chat Rooms Page");
		this.selenium = selenium;

		if(ConfigFileReader.getConfigItemValue("tbb.user.type").equals("free")) {
			assertTrue("User is not shown a 'Club-Only' page, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Club Only"), selenium);
		} else if (ConfigFileReader.getConfigItemValue("tbb.user.type").equals("club")) {
			assertTrue("This is not VIP Chat Rooms Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Chat Rooms: VIP"), selenium);
		}		
	}

	/**
	 * Navigates to Main Connect page 
	 * @return instance of ConnectPage
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ConnectPage(selenium);
	}
}