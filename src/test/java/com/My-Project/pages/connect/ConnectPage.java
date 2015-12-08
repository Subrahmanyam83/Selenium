package com.tbb.pages.connect;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Connect;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.Home;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.profile.MyProfilePage;
import com.tbb.pages.watchvideos.WatchVideosPage;

//import static com.tbb.framework.BaseTest.assertTrue;

/**
 * 
 * Page Object encapsulates the Connect Page
 * @author Jaya
 */

public class ConnectPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Connect Page.
	 * @param	selenium
	 */
	public ConnectPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Connect Page");
		this.selenium = selenium;
		assertTrue("This is not Connect Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect"), selenium);
	}
	
	/**
	 * Returns the number of links on the left hand side menu.
	 * @return int
	 */
	public int getMenuLinksCount() {
		return selenium.getXpathCount(Connect.NAV_MENU_ITEMS_XPATH).intValue();		
	}
	
	/**
	 * Returns the text of links on the left hand side menu.
	 * @return String array
	 */
	public String[] getMenuLinksText() {
		int menuItemsCount = getMenuLinksCount();
		String[] menuLinksNames = null;
		if (menuItemsCount > 0) {
			menuLinksNames = new String[menuItemsCount];
			for (int i = 1; i <= menuItemsCount; i++) {
				menuLinksNames[i - 1] = selenium
						.getText(Connect.NAV_MENU_ITEMS_TEXT_XPATH + "[" + i + "]/a");
			}
		}
		return menuLinksNames;
	}

	/**
	 * Clicks on 'Contests' link in left hand menu and navigates user to Contests Page
	 * @return ContestsPage
	 */
	public ContestsPage goToContestsPage() {
		selenium.click(Connect.NAV_MENU_CONTESTS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ContestsPage(selenium);
	}
	
	/**
	 * Clicks on 'Success Stories' link in left hand menu and navigates user to Success Stories Page
	 * @return SuccessStoriesPage
	 */
	public SuccessStoriesPage goToSuccessStoriesPage() {
		selenium.click(Connect.NAV_MENU_SUCCESS_STORIES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new SuccessStoriesPage(selenium);
	}
	
	/**
	 * Clicks on 'Message Boards' link in left hand menu and navigates user to Message Boards Page
	 * @return MessageBoardsPage
	 */
	public MessageBoardsPage goToMessageBoardsPage() {
		selenium.click(Connect.NAV_MENU_MESSAGE_BOARDS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MessageBoardsPage(selenium);
	}
	
	/**
	 * Clicks on 'Member Gallery' link in left hand menu and navigates user to Member Gallery Page
	 * @return MemberGalleryPage
	 */
	public MemberGalleryPage goToMemberGalleryPage() {
		selenium.click(Connect.NAV_MENU_MEMBER_GALLERY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MemberGalleryPage(selenium);
	}
	
	/**
	 * Clicks on 'Chat Rooms' link in left hand menu and navigates user to Chat Rooms Page
	 * @return ChatRoomsPage
	 */
	public ChatRoomsPage goToChatRoomsPage() {
		selenium.click(Connect.NAV_MENU_CHAT_ROOMS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ChatRoomsPage(selenium);
	}

	/**
	 * Clicks on 'My Coach' link in left hand menu and navigates user to My Coach Page
	 * @return MyCoachPage
	 */
	public MyCoachPage goToMyCoachPage() {
		selenium.click(Connect.NAV_MENU_MY_COACH_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForTextPresent("My coach is");
		return new MyCoachPage(selenium);
	}
	
	/**
	 * Clicks on 'My Coach' link in left hand menu and navigates user to My Coach Page
	 * @return MyCoachPage
	 */
	public MyCoachPage goToMyCoachPageAsClubUKUser() {
		selenium.click(Connect.NAV_MENU_MY_COACH_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyCoachPage(selenium);
	}
	
	/**
	 * Clicks on 'Message Center' link in left hand menu and navigates user to Message Center Page
	 * @return MessageCenterPage
	 */
	public MessageCenterPage goToMessageCenterPage() {
		selenium.click(Connect.NAV_MENU_MESSAGE_CENTER_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MessageCenterPage(selenium);
	}
	
	/**
	 * Clicks on 'My Profile' link in left hand menu and navigates user to My Profile Page
	 * @return MyProfilePage
	 */
	public MyProfilePage goToMyProfilePage() {
		selenium.click(Connect.NAV_MENU_MY_PROFILE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyProfilePage(selenium);
	}

	/**
	 * Returns the number of links on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getContentLinksCount() {
		return selenium.getXpathCount(Connect.CONTENT_LINKS_XPATH).intValue();
	}

	/**
	 * Returns the text of the links on the content displayed in the center of the page. 
	 * @return String array
	 */
	public String[] getContentLinksText() {
		int contentItemsCount = getContentLinksCount();
		String[] contentLinksNames = null;
		if (contentItemsCount > 0) {
			contentLinksNames = new String[contentItemsCount];
			for (int i = 1; i <= contentItemsCount; i++) {
				contentLinksNames[i-1] = selenium
						.getText(Connect.CONTENT_LINKS_TEXT_XPATH + "[" + i
								+ "]/h2");
			}
		}
		return contentLinksNames;
	}

	/**
	 * Returns the number of images on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getImageLinksCount() {
		return selenium.getXpathCount(Connect.IMAGE_LINKS_XPATH).intValue();
	}

	/**
	 * Returns the number of learn more links displayed on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getLearnMoreLinksCount() {
		return selenium.getXpathCount(Connect.LEARN_MORE_LINKS_XPATH).intValue();
	}

	/**
	 * Clicks on Learn More link for Contests. Navigates user to Contests Page. 
	 * @return ContestsPage
	 */
	public ContestsPage clickContestsLearnMore() {
		selenium.click(Connect.LEARN_MORE_CONTESTS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ContestsPage(selenium);
	}

	/**
	 * Clicks on Learn More link for Success Stories. Navigates user to Success Stories Page. 
	 * @return SuccessStoriesPage
	 */
	public SuccessStoriesPage clickSuccessStoriesLearnMore() {
		selenium.click(Connect.LEARN_MORE_SUCCESS_STORIES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new SuccessStoriesPage(selenium);
	}

	/**
	 * Clicks on Learn More link for Message Boards. Navigates user to Message Boards Page. 
	 * @return MessageBoardsPage
	 */
	public MessageBoardsPage clickMessageBoardsLearnMore() {
		selenium.click(Connect.LEARN_MORE_MESSAGE_BOARDS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MessageBoardsPage(selenium);
	}

	/**
	 * Clicks on Learn More link for Member Gallery. Navigates user to Member Gallery Page. 
	 * @return MemberGalleryPage
	 */
	public MemberGalleryPage clickMemberGalleryLearnMore() {
		selenium.click(Connect.LEARN_MORE_MEMBER_GALLERY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MemberGalleryPage(selenium);
	}

	/**
	 * Clicks on Learn More link for Chat Rooms. Navigates user to Chat Rooms Page. 
	 * @return ChatRoomsPage
	 */
	public ChatRoomsPage clickChatRoomsLearnMore() {
		selenium.click(Connect.LEARN_MORE_CHAT_ROOMS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ChatRoomsPage(selenium);
	}

	/**
	 * Clicks on Learn More link for My Coach. Navigates user to My Coach Page. 
	 * @return MyCoachPage
	 */
	public MyCoachPage clickCoachLearnMore() {
		selenium.click(Connect.LEARN_MORE_COACH_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForTextPresent("My coach is");
		return new MyCoachPage(selenium);
	}

	/**
	 * Clicks on Learn More link for Message Center. Navigates user to Message Center Page. 
	 * @return MessageCenterPage
	 */
	public MessageCenterPage clickMessageCenterLearnMore() {
		selenium.click(Connect.LEARN_MORE_MESSAGE_CENTER_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MessageCenterPage(selenium);
	}

	/**
	 * Clicks on Learn More link for My Profile. Navigates user to My Profile Page. 
	 * @return MyProfilePage
	 */
	public MyProfilePage clickMyProfileLearnMore() {
		selenium.click(Connect.LEARN_MORE_MY_PROFILE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyProfilePage(selenium);
	}

	/**
	 * Clicks on TBB Logo and navigates to TBB Home page
	 * @return
	 */
	public HomePage clickTBBLogo() {
		selenium.click(Home.TBB_LOGO);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HomePage(selenium);
	}

	/**
	 * Returns title of RRMs
	 */
	public ArrayList getRRMsTitles() {
		ArrayList<String> rrmTitles = new ArrayList();
		int rrmsCount = getRRMsCount();
		for (int i =1; i<=rrmsCount; i++) {
			rrmTitles.add(selenium.getText(Connect.CONNECT_PROGRAM_RRM_SECTION + "[" + i + "]" + Connect.CONNECT_PROGRAM_RRM_TITLE));
		}
		return rrmTitles;
	}
	
	/**
	 * Returns number of RRMs
	 * @return int
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(Connect.CONNECT_PROGRAM_RRM_SECTION).intValue();
	}

	/**
	 * Navigate to Watch Videos Page. 
	 * @return WatchVideosPage
	 */
	public WatchVideosPage clickWatchVideosLink() {
		selenium.click(Dashboard.WATCH_VIDEOS_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WatchVideosPage(selenium);
	}

	/**
	 * Navigate to About Page
	 * @return
	 */
	public AboutPage clickAboutLink() {
		selenium.click(Dashboard.ABOUT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}
}