package com.tbb.pages.connect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.ChatRooms;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Chat Rooms Page
 * @author Gaurav
 */
public class ChatRoomsPage extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Chat Rooms Page.
	 * @param	selenium
	 */
	public ChatRoomsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Chat Rooms Page");
		this.selenium = selenium;
		assertTrue("This is not Chat Rooms Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Chat Rooms"), selenium);
	}

	/**
	 * Clicks on 'Public' link under 'Chat Room' in left hand side menu of the web page. 
	 * @return Public Chat Page
	 */
	public PublicChatPage goToPublicChatPage() {
		selenium.click(ChatRooms.NAV_MENU_PUBLIC_CHAT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new PublicChatPage(selenium);
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
	 * Clicks on 'Connect' link in the top menu bar. 
	 * @return ConnectPage
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ConnectPage(selenium);
	}

	/**
	 * Returns count of VIP Chat Rooms
	 */
	public int vipChatRoomsCount(){
		return selenium.getXpathCount(ChatRooms.VIP_CHAT_ROOM_COUNT).intValue();
	}

	/**
	 * Returns count of Public Chat Rooms
	 */
	public int publicChatRoomsCount(){
		return selenium.getXpathCount(ChatRooms.PUBLIC_CHAT_ROOM_COUNT).intValue();
	}

	/**
	 * Verifies UI of Page
	 */
	public void verifyUI() {
		/*		assertTrue("Chat Room Image not shown", selenium.waitForElementPresent(ChatRooms.CHAT_ROOM_IMAGE), selenium);
		assertTrue("VIP Chat Room title not shown", selenium.isVisible(ChatRooms.VIP_CHAT_ROOM_TITLE), selenium);
		assertTrue("Public Chat Room title not shown", selenium.isVisible(ChatRooms.PUBLIC_CHAT_ROOM_TITLE), selenium);
		assertTrue("Number of VIP chat rooms cannot be less than 1", vipChatRoomsCount() > 0, selenium);
		assertTrue("Number of Public chat rooms cannot be less than 1", publicChatRoomsCount() > 0, selenium);*/

		ArrayList rrmTitles = getRRMsTitles();
		String[] rrmTitlesData = new String[] {"Message Boards", "Trainers’ Corner", "My Coach"};
		List<String> rrmTitlesDataList = Arrays.asList(rrmTitlesData);
		assertTrue("Required RRMs not displayed", rrmTitlesDataList.equals(rrmTitles), selenium);

		/*	clickChatNowButton();*/
	}

	/**
	 * Open 'Chat Now' window and click on close
	 */
	public void clickChatNowButton() {
		selenium.click(ChatRooms.CHAT_NOW_BUTTON);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.selectWindow("Team Beachbody - Connect: Chat Rooms: Cooldown Chat");
		selenium.click(ChatRooms.CLOSE_LINK);
		selenium.selectWindow(null);
	}

	/**
	 * Returns number of RRMs
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(ChatRooms.FITNESS_PROGRAM_RRM_SECTION).intValue();		
	}

	/**
	 * Returns title of RRMs
	 */
	public ArrayList<String> getRRMsTitles() {
		ArrayList<String> rrmTitles = new ArrayList();
		int rrmsCount = getRRMsCount();
		for (int i =1; i<=rrmsCount; i++) {
			rrmTitles.add(selenium.getText(ChatRooms.FITNESS_PROGRAM_RRM_SECTION + "[" + i + "]" + ChatRooms.FITNESS_PROGRAM_RRM_TITLE));
		}
		return rrmTitles;
	}








}