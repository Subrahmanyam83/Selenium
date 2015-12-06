package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.ChatRooms;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
//import static com.tbb.framework.BaseTest.assertTrue;
/**
 * 
 * Page Object encapsulates the Public Chat Rooms Page
 * @author Gaurav
 */
public class PublicChatPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Public Chat Rooms Page.
	 * @param	selenium
	 */
	public PublicChatPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Public Chat Rooms Page");
		this.selenium = selenium;
		assertTrue("This is not Public Chat Rooms Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Chat Rooms: Public"), selenium);
	}
	
	/**
	 * Clicks on 'VIP' link under 'Chat Room' in left hand side menu of the web page. 
	 * @return VIP Chat Page
	 */
	public VIPChatPage goToVIPChatPage() {
		selenium.click(ChatRooms.NAV_MENU_VIP_CHAT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new VIPChatPage(selenium);
	}
	
	/**
	 * Clicks on Connect Link in the top menu bar. 
	 * @return Connect Page
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ConnectPage(selenium);
	}
}