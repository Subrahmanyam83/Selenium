package com.tbb.pages;

import org.sikuli.script.Screen;
import org.testng.Reporter;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.Home;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.about.JoinUpgradePage;
import com.tbb.pages.coach.CoachPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.InboxPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.eatsmart.MyMealPlannerPage;
import com.tbb.pages.getfit.GetFitPage;
import com.tbb.pages.others.SupportHomePage;
import com.tbb.pages.profile.MyProfilePage;
import com.tbb.pages.watchvideos.WatchVideosPage;
import com.thoughtworks.selenium.SeleniumException;


/**
 * 
 * Page Object encapsulates the Team BeachBody Home page.
 * @author Gaurav
 */

public class HomePage  extends BaseTest {

	
	private LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Home Page.
	 * @param	selenium
	 */
	public HomePage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Home Page Class");
		assertTrue(
				"This is not Home page, current page is: "
				+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Home"), selenium);
	}

	/**
	 * Navigate to Sign in page
	 */
	public SignInPage clickSignIn() {
		//selenium.deleteAllVisibleCookies();
		selenium.click(Home.SIGN_IN_LINK);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new SignInPage(selenium);
	}

	/**
	 * Navigate to My Profile page
	 */
	public MyProfilePage clickProfile() {
		selenium.click("css=a.profile");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyProfilePage(selenium);
	}

	/**
	 * Verifies whether User status bar is visible to user. Fetches all main
	 * headings and returns on calling function
	 */
	public String[] getUserStatusBarDocks() {
		String headings[] = new String[6];
		// Check whether userdock is visible
		assertTrue("User Status Bar is not visible",
				selenium.isVisible("css=div#userdock"), selenium);
		headings[0] = selenium
		.getText(Home.MY_DASHBOARD_DOCK_TITLE);
		headings[1] = selenium
		.getText(Home.INBOX_DOCK_TITLE);
		headings[2] = selenium
		.getText(Home.BUDDIES_DOCK_TITLE);
		headings[3] = selenium
		.getText(Home.WORKOUTS_DOCK_TITLE);
		headings[4] = selenium
		.getText(Home.USER_MESSAGE_DOCK_TITLE);
		headings[5] = selenium
		.getText(Home.GOAL_TRACKER_DOCK_TITLE);

		return headings;

	}

	/**
	 * Returns site description from home page
	 */
	public String getSiteDesciption() {
		String siteDesc;
		siteDesc = selenium.getText(Home.SITE_DESCRIPTION);
		return siteDesc;
	}

	/**
	 * Returns current time from home page
	 */
	public String getCurrentDate() {
		String currentTime;
		currentTime = selenium.getText(Home.CURRENT_DATE);
		return currentTime;
	}

	/**
	 * Verifies whether ticker is visible. If yes, returns Ticker's Headings.
	 * 
	 * @return
	 */
	public String getTickerHeading() {
		assertTrue("Ticker is not visible",
				selenium.isVisible(Home.TIKCER), selenium);
		String tickerHeading = selenium.getText(Home.TIKCER + " > h3");
		return tickerHeading;
	}

	/**
	 * Verifies whether News Letters exist on site's home page
	 */

	public boolean newsLetterPortletExists() {
		try {
			return selenium
			.isVisible(Home.NEWSLETTER_PORTLETS_SECTION)
			&& selenium
			.isVisible(Home.NEWSLETTER_SHOP_PORTLET)
			&& selenium
			.isVisible(Home.NEWSLETTER_EAT_PORTLET)
			&& selenium
			.isVisible(Home.NEWSLETTER_FIT_PORTLET) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}

	}

	/**
	 * Verifies whether Video exists on site's home page
	 */
	public boolean videoPortletExists() {
		try {
			return selenium
			.isVisible(Home.VIDEO_PORTLET_SECTION) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}
	}

	/**
	 * Verifies whether What's New Portlet exists on site's home page
	 */
	public boolean whatsNewPortletExists() {
		try {
			return selenium
			.isVisible(Home.WHATSNEW_PORTLET_SECTION) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}

	}

	/**
	 * Verifies whether Hot Topics on the Message Boards exist on site's home
	 * page
	 */
	public boolean hotTopicsPortletExists() {
		try {
			return selenium.isVisible(Home.HOT_TOPICS_PORTLET_SECTION) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}
	}

	/**
	 * Verifies whether DailyWinner exist on site's home page
	 */
	public boolean dailyWinnerExistsOnLRM() {
		try {
			return selenium
			.isVisible(Home.DAILY_WINNER_PORTLET) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}
	}

	/**
	 * Verifies whether Shakelogy exist on site's home page
	 */
	public boolean shakeologyExistsOnLRM() {
		try {
			return selenium.isVisible(Home.SHAKEOLOGY_PORTLET) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}

	}

	/**
	 * Verifies whether Coach or Club Upsell exist on site's home page
	 */
	public boolean coachClubUpSellExistsOnLRM() {
		try {
			return selenium.isVisible(Home.COACH_CLUB_UPSELL_LRM_PORTLET) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}
	}

	/**
	 * Verifies whether Featured Products exist on site's home page
	 */
	public boolean featuredProductsExistsOnRRM() {
		try {
			return selenium.isVisible(Home.FEATURED_PRODUCTS_PORTLET) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}
	}

	/**
	 * Verifies whether Success Stories exist on site's home page
	 */
	public boolean successStroiesExistsOnRRM() {
		try {
			return selenium.isVisible(Home.SUCCESS_STORIES_PORTLET) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}
	}

	/**
	 * Verifies whether Coach or Club Upsell exist on site's home page
	 */
	public boolean coachClubUpSellExistsOnRRM() {
		try {
			return selenium.isVisible(Home.COACH_CLUB_UPSELL_RRM_PORTLET) ? true
					: false;
		} catch (SeleniumException e) {
			Reporter.log(e.getMessage());
			return false;
		}
	}

	/**
	 * Gets links under Inbox Userdock
	 */
	public String[] getInboxLinks() {
		String inboxUserDock[] = new String[3];
		inboxUserDock[0] = selenium
		.getText(Home.INBOX_DOCK_LINK);
		inboxUserDock[1] = selenium
		.getText(Home.INBOX_MESSAGE_CENTER_LINK);
		inboxUserDock[2] = selenium
		.getText(Home.INBOX_GO_TO_INBOX_LINK);

		return inboxUserDock;
	}

	/**
	 * Gets links under Buddies Userdock
	 */
	public String[] getBuddiesLinks() {
		String biddiesUserDock[] = new String[4];
		biddiesUserDock[0] = selenium
		.getText(Home.BUDDIES_DOCK_LINK);
		biddiesUserDock[1] = selenium
		.getText(Home.BUDDIES_FIND_NEW_BUDDIES_LINK);
		biddiesUserDock[2] = selenium
		.getText(Home.BUDDIES_VIEW_MY_BUDDY_INVITATIONS_LINK);
		biddiesUserDock[3] = selenium
		.getText(Home.BUDDIES_VIEW_MY_BUDDIES_LINK);

		return biddiesUserDock;
	}

	/**
	 * Gets links under Workouts Userdock
	 */
	public String[] getWorkoutsLinks() {
		String workoutUserDock[] = new String[3];
		workoutUserDock[0] = selenium
		.getText(Home.WORKOUT_DOCK_LINK);
		workoutUserDock[1] = selenium
		.getText(Home.WORKOUT_SCHEDULE_A_WORKOUT_LINK);
		workoutUserDock[2] = selenium
		.getText(Home.WORKOUT_GO_TO_SUPERGYM_LINK);

		return workoutUserDock;
	}

	/**
	 * Gets links under Goal Tracker Userdock
	 */
	public String[] getGoalTrackerLinks() {
		String goalTrackerUserDock[] = new String[2];
		goalTrackerUserDock[0] = selenium
		.getText(Home.GOAL_TRACKER_DOCK_LINK);
		goalTrackerUserDock[1] = selenium
		.getText(Home.GOAL_TRACKER_GO_TO_GOALS_LINK);

		return goalTrackerUserDock;
	}

	/**
	 * Gets links under Inbox Userdock
	 */
	public InboxPage goToInbox() {
		selenium.click(Home.INBOX_DOCK_LINK);
		selenium.waitForElementPresent(Home.INBOX_GO_TO_INBOX_LINK);
		selenium.click(Home.INBOX_GO_TO_INBOX_LINK);
		selenium.waitForPageToLoad("50000");

		return new InboxPage(selenium);
	}


	/**
	 * This method handles Sign In functionality for IE and Safari.
	 */
	public DashboardPage clickSignInSpecial(String username, String password) {
		selenium.deleteAllVisibleCookies();
		try {
			if(ConfigFileReader.getConfigItemValue("browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("browser").equals("*iehta")) 
				ieCase(username, password);
			if(ConfigFileReader.getConfigItemValue("browser").equals("*safariproxy")) 
				safariCase(username, password);
			if(ConfigFileReader.getConfigItemValue("browser").equals("*chrome")) 
				firefoxCase(username, password);
			Thread.sleep(2000);
			selenium.waitForElementPresent("css=a:contains(Dashboard)");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DashboardPage(selenium);
	}
	

	/**
	 * This method signs in the Team Beachbody website in Safari browser.
	 * @param username
	 * @param password
	 * @return Dashboard Page
	 */
	public DashboardPage firefoxCase(String username, String password) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}    
			String path = ConfigFileReader.getConfigItemValue("sikuli.scripts.images") + "Firefox_Security.sikuli\\";
			Screen s = new Screen();
			try{
				s.wait(path + "SignIn-3.png", 20);
				s.click(path + "SignIn-3.png", 0);

				if(BaseTest.signInCount==0) {
					s.wait(path + "1314078885612.png", 90);
					s.click(path + "1314078899912.png", 0);
					BaseTest.signInCount++;
				}

				s.wait(path + "SianIntoTeam.png", 90);
				s.click(path + "SianIntoTeam.png", 0);

				s.wait(path + "ZHIBII.png", 60);
				s.click(path + "ZHIBII.png", 0);
				s.type(null, username, 0);

				s.click(path + "HSSWUIUCdSBS.png", 0);
				s.type(null, password, 0);

				s.click(path + "SignIn-1.png", 0);
				s.wait(path + "HomeDashboar.png", 60);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return new DashboardPage(selenium);
		}
		


	/**
	 * This method signs in the Team Beachbody website in Internet Explorer browser.
	 * @param username
	 * @param password
	 * @return Dashboard Page
	 */
	public DashboardPage ieCase(String username, String password) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		String path = ConfigFileReader.getConfigItemValue("sikuli.scripts.images") + "IE_Security.sikuli\\";
		Screen s = new Screen();
		try{
			s.wait(path + "SignIn-3.png", 20);
			s.click(path + "SignIn-3.png", 0);

			if(BaseTest.signInCount==0) {   
				s.wait(path + "Continuetoth-1.png", 20);
				s.click(path + "Continuetoth-1.png", 0);
				s.wait(path + "Clickherefor.png", 60);
				BaseTest.signInCount++;
			}                   

			s.wait(path + "SianIntoTeam.png", 60);
			s.click(path + "SianIntoTeam.png", 0); 	

			s.wait(path + "fTI8I.png", 20);
			s.click(path + "fTI8I.png", 0);
			s.type(null, username, 0);

			s.click(path + "HSSWUIUCdSBS.png", 0);
			s.type(null, password, 0);

			s.click(path + "SignIn-1.png", 0);
			s.wait(path + "HomeDashboar.png", 60);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new DashboardPage(selenium);
	}	

	/**
	 * This method signs in the Team Beachbody website in Safari browser.
	 * @param username
	 * @param password
	 * @return Dashboard Page
	 */
	public DashboardPage safariCase(String username, String password) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}    
		String path = ConfigFileReader.getConfigItemValue("sikuli.scripts.images") + "Safari_Security.sikuli\\";
		Screen s = new Screen();
		try{
			s.wait(path + "SignIn-3.png", 20);
			s.click(path + "SignIn-3.png", 0);

			if(BaseTest.signInCount==0) {
				s.wait(path + "1314078885612.png", 90);
				s.click(path + "1314078899912.png", 0);
				BaseTest.signInCount++;
			}

			s.wait(path + "SianIntoTeam.png", 90);
			s.click(path + "SianIntoTeam.png", 0);

			s.wait(path + "ZHIBII.png", 60);
			s.click(path + "ZHIBII.png", 0);
			s.type(null, username, 0);

			s.click(path + "HSSWUIUCdSBS.png", 0);
			s.type(null, password, 0);

			s.click(path + "SignIn-1.png", 0);
			s.wait(path + "HomeDashboar.png", 60);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new DashboardPage(selenium);
	}
	
	
	/**
	 * Navigate to Get Fit Link
	 * @return Get Fit Page
	 */
	public GetFitPage clickGetFitLink() {
		selenium.click(Dashboard.GET_FIT_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new GetFitPage(selenium);
	}
	
	
	/**
	 * Navigates to Eat Smart Link
	 * @return Instance of EatSmartPage
	 */
	public EatSmartPage clickEatSmartLink() {
		selenium.click("css=a>span:contains(Eat Smart)");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EatSmartPage(selenium);
	}
	
	
	/**
	 * Navigates user to Connect Page
	 * @return Connect Page
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ConnectPage(selenium);
	}


	/**
	 * Navigates user to Watch Videos Page.
	 * @return Watch Videos Page
	 */
	public WatchVideosPage clickWatchVideosLink() {
		selenium.click(Dashboard.WATCH_VIDEOS_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WatchVideosPage(selenium);
	}
	
	/**
	 * Navigates user to Coach tab main page.
	 * @return Coach Page
	 */
	public CoachPage clickCoachLink() {
		selenium.click(Dashboard.COACH_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CoachPage(selenium);
		
	}
	
	
	/**
	 * Navigates user to About Page.
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click(Dashboard.ABOUT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}


	

	
	/**
	 * Navigates user to My Meal Planner Page
	 * @return My Meal Planner Page
	 */
	public MyMealPlannerPage clickMyMealPlannerLink(){
		selenium.click(Dashboard.MY_MEAL_PLANNER_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyMealPlannerPage(selenium);
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
	 * Navigates to Help/FAQ page
	 * @return
	 */
	public SupportHomePage clickHelpFAQLink() {
		selenium.click(Home.HELP_FAQ_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new SupportHomePage(selenium);
	}

	/**
	 * Navigates to Sign Up page
	 */
	public JoinUpgradePage clickNotAMemberLink() {
		selenium.click(Home.SIGN_UP_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new JoinUpgradePage(selenium);
	}

	/**
	 * Searches the website for a given string. 
	 * @param string
	 */
	public void globalSearch(String searchText) {
		selenium.type("css=form#search-bar>input[class='text']", searchText);
		selenium.click("css=span.btn-white>input[value='Go']");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}


	
}

