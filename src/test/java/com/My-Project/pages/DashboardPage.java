package com.tbb.pages;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.Home;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.coach.CoachFAQPage;
import com.tbb.pages.coach.CoachPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.eatsmart.MyMealPlannerPage;
import com.tbb.pages.eatsmart.RecipesPage;
import com.tbb.pages.getfit.GetFitPage;
import com.tbb.pages.profile.MyProfilePage;
import com.tbb.pages.shop.ShoppingCartPage;
import com.tbb.pages.watchvideos.WatchVideosPage;

/**
 *
 * Page Object encapsulates the Club Only Page
 *  @author Gaurav
 */
public class DashboardPage extends BaseTest{

	private LoggingSelenium selenium;

	/**
	 * This is constructor for this class. It validates that the user is on Dashboard Page.
	 * @param	selenium
	 */
	public DashboardPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Dashboard Class");
		if (!selenium.getTitle().equals("Team Beachbody - Dashboard")) {
			selenium.click("css=a[href='/dashboard']");
			selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		}
		assertTrue("This is not Dashboard of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Dashboard"), selenium);
	}

	/**
	 * Clicks on Sign out link to sign out user from the web site.
	 * @return Home Page
	 */
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent("css=a:contains(Sign In)");
		return new HomePage(selenium);
	}

	/**
	 * Navigate to My Profile page
	 * @return My Profile Page
	 */
	public MyProfilePage clickProfile() {
		selenium.click(Dashboard.PROFILE_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyProfilePage(selenium);
	}

	/**
	 * Navigate to Home page from Dashboard page
	 * @return Home Page
	 */
	public HomePage clickHome(){
		selenium.click(Dashboard.HOME_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HomePage(selenium);
	}

	/**
	 * Returns highlighted date
	 * @return String
	 */
	public String getHighlightedDate() {
		return selenium.getText(Dashboard.HIGHLIGHTED_DATE_TAB);
	}

	/**
	 * Returns Scheduled workouts for user
	 * @return String
	 */
	public String getScheduledWorkouts() {
		return selenium.getText(Dashboard.SCHEDULED_WORKOUTS_TEXT);
	}

	/**
	 * Returns an array of select options available for programs. 
	 * @return Array of Strings
	 */
	
	public String[] getPrograms() {
		return selenium.getSelectOptions(Dashboard.PROGRAMS_SELECT);
	}

	/**
	 * Selects the given workout from the list of options available. 
	 * @param workout
	 */
	public void setProgram(String workout) {
		selenium.select(Dashboard.PROGRAMS_SELECT, workout);
	}

	/**
	 * Returns an array of select options available for Routines.
	 * @return Array of Routine Names
	 */
	public String[] getRoutines() {
		return selenium.getSelectOptions(Dashboard.ROUTINES_SELECT);
	}

	/**
	 * Returns the number of buddies displayed on Dashboard Page. 
	 * @return int 
	 */
	public int getBuddiesCount() {
		return selenium.getXpathCount(Dashboard.BUDDIES_IMAGE).intValue();

	}

	//Sprint 2
	/**
	 * Returns an array of buddy names 
	 * @return Array of Buddy Names
	 */

	public String[] getBuddiesNames() {
		int buddiesCount = selenium.getXpathCount(Dashboard.BUDDIES_IMAGE).intValue();
		String[] buddiesNames = null;
		if (buddiesCount > 0) {
			buddiesNames = new String[buddiesCount];
			for(int i=1; i<=buddiesCount; i++){
				buddiesNames[i-1] = selenium.getText(Dashboard.BUDDY_NAME + "[" + i + "]/a");
			}
		}
		return buddiesNames;
	}

	/**
	 * Returns count of recent messages count 
	 * @return int
	 */
	public int getRecentMessagesCount() {
		return selenium.getXpathCount(Dashboard.RECENT_MESSAGE).intValue();
	}

	public int getRightRailModulesCount() {
		return  selenium.getXpathCount(Dashboard.RIGHT_RAIL_MODULE).intValue();
	}

	/**
	 * Returns the title content of the right rail modules displayed on Dashboard page. 
	 * @return Array of Titles 
	 */
	public String[] showTitleContentForRRMs() {
		String[] titleContent = new String[3];
		titleContent[0] = selenium.getText(Dashboard.RIGHT_RAIL_MODULE_1_TITLE) + "/n" + selenium.getText(Dashboard.RIGHT_RAIL_MODULE_1_TEXT);
		titleContent[1] = selenium.getText(Dashboard.RIGHT_RAIL_MODULE_2_TITLE) + "/n" + selenium.getText(Dashboard.RIGHT_RAIL_MODULE_2_TEXT);
		titleContent[2] = selenium.getText(Dashboard.RIGHT_RAIL_MODULE_3_TITLE) + "/n" + selenium.getText(Dashboard.RIGHT_RAIL_MODULE_3_TEXT);
		return titleContent;
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
	 * Navigates user to My Meal Planner Page
	 * @return My Meal Planner Page
	 */
	public MyMealPlannerPage clickMyMealPlannerLink(){
		selenium.click(Dashboard.MY_MEAL_PLANNER_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyMealPlannerPage(selenium);
	}

	/**
	 * Navigates user to Recipes Page
	 * @return Recipes Page
	 */
	public RecipesPage clickRecipesLink() {
		selenium.click(Dashboard.RECIPES_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new RecipesPage(selenium);
	}

	/**
	 * Navigates user to Eat Smart Page
	 * @return Eat Smart Page
	 */
	public EatSmartPage clickEatSmartLink() {
		selenium.click(Dashboard.EAT_SMART_MENU_LINK);
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
	 * Navigates user to About Page.
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click(Dashboard.ABOUT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
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
	 * Navigates to Coach FAQ Page
	 * @return Coach FAQ Page
	 */
	public CoachFAQPage clickCoachFAQLink() {
		selenium.mouseOver(Dashboard.COACH_LINK);
		try {Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace();}
		selenium.mouseOver(Dashboard.COACH_COACH_FAQ_LINK + "[2]");
		try {Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace();}
		selenium.click(Dashboard.COACH_COACH_FAQ_LINK + "[@class='hover']/a");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CoachFAQPage(selenium);
	}

	/**
	 * Navigates user to Shopping Cart Page. 
	 * @return Shopping Cart Page
	 */
	public ShoppingCartPage clickShopLink() {
		selenium.click(Dashboard.SHOP_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ShoppingCartPage(selenium);
	}	
	
	/**
	 * Clicks on 'Start Up Wizard' link
	 * @return 
	 */
	public GettingStartedWizardPage clickStartUpWizard() {
		selenium.click(Dashboard.START_UP_WIZARD);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new GettingStartedWizardPage(selenium);
	}
	
	/**
	 * Navigates user to My Account Page. 
	 * @return My Account Page
	 */
	public MyAccountPage clickMyAccountLink() {
		selenium.click(Dashboard.MY_ACCOUNT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyAccountPage(selenium);
	}

	/**
	 * Clicks on Start Up Wizard link.
	 * @param wait
	 * @return
	 */
	public GettingStartedWizardPage clickStartUpWizard(Boolean wait) {
		selenium.click("css=a:contains(Start Up Wizard)");
		return new GettingStartedWizardPage(selenium);
	}

	/**
	 * Clicks on Like button for Facebook on dashboard page. 
	 */
	public void clickLike() {
		selenium.click("css=a[class='connect_widget_like_button clearfix like_button_no_like'] span.liketext");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Clicks on Team Beachbody logo image at the top of the web page.  
	 */
	public void clickTopmostTeamBeachbodyImage() {
		selenium.click("css=a.png");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}
	
	/**
	 * Logins into facebook account with provided username and password.
	 * @param facebookUsername
	 * @param facebookPassword
	 */

	public void likeFacebookAsUnlinkedAccount(String facebookUsername,
			String facebookPassword) {
		selenium.selectWindow(selenium.getAllWindowTitles()[1]);
		selenium.type("css=input.inputtext", facebookUsername);
		selenium.type("css=input.inputpassword", facebookPassword);
		selenium.click("css=input[name='login']");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.selectWindow(null);
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
	 * Clicks on Link Facebook Account in Dashboard page. 
	 * @param facebookUsername
	 * @param facebookPassword
	 */
	public void linkFacebookAccount(String facebookUsername,
			String facebookPassword) {
		selenium.click(Dashboard.LINK_ACCOUNT);	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.selectWindow(selenium.getAllWindowTitles()[1]);
		selenium.type("css=input.inputtext", facebookUsername);
		selenium.type("css=input.inputpassword", facebookPassword);
		selenium.click("css=input[name='login']");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.click("css=input[value='Allow']");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.selectWindow(null);
		
	}

	/**
	 * Clicks on Sign facebook sign out link. 
	 * @return HomePage
	 */
	public HomePage clickFacebookSignOut() {
		selenium.click("css=span.fb_button_text");
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
			rrmTitles.add(selenium.getText(Dashboard.DASHBOARD_PROGRAM_RRM_SECTION + "[" + i + "]" + Dashboard.DASHBOARD_PROGRAM_RRM_TITLE));
		}
		return rrmTitles;
	}
	
	/**
	 * Returns number of RRMs
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(Dashboard.DASHBOARD_PROGRAM_RRM_SECTION).intValue();
	}
}
