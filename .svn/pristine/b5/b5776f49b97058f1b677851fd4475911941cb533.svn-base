package com.tbb.testscripts.profile;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.MemberProfilePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.MemberGallerySearchResultsPage;
import com.tbb.pages.connect.NotificationsPage;
import com.tbb.pages.profile.BuddiesPage;
import com.tbb.pages.profile.MyProfilePage;
/**
 * 
 * This test script contains test method(s) for "Edit Profile: Buddies" page under Profile section.
 *  @author Jaya
 */
public class TestBuddiesPage extends BaseTest {

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

	/***
	 * This is data provider for testSendBuddyRequest, testAcceptBuddyRequest and testRemoveBuddy Test Scripts.
	 */ 
	@DataProvider(name = "addBuddiesDataProvider")
	public Object[][] createBuddiesData() {
		return new Object[][] {
				{ "JAsnani", "jgupta@xebia.com", "password"},
		};
	}
	/***
	 * Positive Test script for sending new buddy invites.  
	 */ 
	@Test(dataProvider = "addBuddiesDataProvider")
	public void testSendBuddyRequest(String buddyName, String buddyUserName, String buddyPassword) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Buddies Page.");
		selenium.logComment("Navigating to View Buddy Profile Page.");
		selenium.logComment("Removing Buddy from My buddies.");
		selenium.logComment("Verifying that Add as a buddy button is displayed  on member profile after removing member from My Buddies.");
		selenium.logComment("Navigating to Dashboard page");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Buddies Page.");
		selenium.logComment("Search buddy name from member gallery.");
		selenium.logComment("Send buddy invite to member.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username2"), ConfigFileReader.getConfigItemValue("tbb.password2"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username2"), ConfigFileReader.getConfigItemValue("tbb.password2"));
		}

		selenium.logComment("Navigating to Profile Page.");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();

		selenium.logComment("Navigating to Edit Buddies Page.");
		BuddiesPage buddiesPage = myProfilePage.editBuddies();	

/*		selenium.logComment("Search if the member is already added as buddy.");
		buddiesPage.searchMyBuddies(buddyName);
		
		selenium.logComment("If the member is already added as buddy, then select checkbox and delete him from existing buddies.");
		if(selenium.isElementPresent(Buddies.BUDDY_PHOTO)==true){
			selenium.check(Buddies.SELECT_BUDDY_CHECKBOX);
			selenium.click(BuddiesPage.REMOVE_SELECTED_BUDDIES_BUTTON);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selenium.click(BuddiesPage.YES_BUTTON);
			selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		}			
*/
		if(selenium.isElementPresent("css=a.small:contains(" + buddyName + ")")) {
			selenium.logComment("Navigating to View Buddy Profile Page.");
			MemberProfilePage memberProfilePage = buddiesPage.viewBuddyProfile(buddyName);
			
			selenium.logComment("Removing Buddy from My buddies.");
			memberProfilePage.removeBuddy();
			
			selenium.logComment("Verifying that Add as a buddy button is displayed  on member profile after removing member from My Buddies.");
			assertTrue("Add as a Buddy button is not available after removing buddy from my buddies.", selenium.isElementPresent("css=input[value='Add as a Buddy']"), selenium);
			
			selenium.logComment("Navigating to Dashboard page");
			dashboardPage = memberProfilePage.clickDashboardLink();
			
		} else {
			selenium.logComment("Member is not yet added as buddy");
			dashboardPage = buddiesPage.clickDashboardLink();
		}		

		selenium.logComment("Navigating to Profile Page.");
		myProfilePage = dashboardPage.clickProfile();

		selenium.logComment("Navigating to Edit Buddies Page.");
		buddiesPage = myProfilePage.editBuddies();	
		
		selenium.logComment("Search buddy name from member gallery.");
		MemberGallerySearchResultsPage memberGallerySearchResultsPage = buddiesPage.searchMembers(buddyName);

		selenium.logComment("Send buddy invite to member.");
		memberGallerySearchResultsPage.clickMemberProfilePic();
		memberGallerySearchResultsPage.addBuddy(buddyName);

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();

	}	

	/**
	 * Positive Test script for verifying acceptance of Buddy requests. 
	 */
	@Test(dependsOnMethods = { "testSendBuddyRequest" }, dataProvider = "addBuddiesDataProvider")
	public void testAcceptBuddyRequest(String buddyName, String buddyUserName, String buddyPassword) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to View New Buddy Requests Page.");
		selenium.logComment("Accepting the new buddy Requests.");
		selenium.logComment("Verifying that Your request is processed successfully message is displayed.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage = new HomePage(selenium);		

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username3"), ConfigFileReader.getConfigItemValue("tbb.password3"));
		}

		selenium.logComment("Navigating to Profile Page.");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();

		selenium.logComment("Navigating to View New Buddy Requests Page.");
		NotificationsPage notifications = myProfilePage.viewNewBuddyRequests();

		selenium.logComment("Accepting the new buddy Requests.");
		notifications.acceptBuddyRequest();

		selenium.logComment("Verifying that Your request is processed successfully message is displayed.");
		assertTrue("Buddy Acceptance failed.", selenium.isElementPresent("css=div.portlet-msg-success"), selenium);

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}	

	/**
	 * Positive Test script for verifying removing Buddy from My Buddies. 
	 */
	@Test (dependsOnMethods = { "testAcceptBuddyRequest" }, dataProvider = "addBuddiesDataProvider")
	public void testRemoveBuddy(String buddyName, String buddyUserName, String buddyPassword) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Buddies Page.");
		selenium.logComment("Navigating to View Buddy Profile Page.");
		selenium.logComment("Removing Buddy from My buddies.");
		selenium.logComment("Verifying that Add as a buddy button is displayed  on member profile after removing member from My Buddies.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username2"), ConfigFileReader.getConfigItemValue("tbb.password2"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username2"), ConfigFileReader.getConfigItemValue("tbb.password2"));
		}

		selenium.logComment("Navigating to Profile Page.");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();

		selenium.logComment("Navigating to Edit Buddies Page.");
		BuddiesPage buddiesPage = myProfilePage.editBuddies();

		selenium.logComment("Navigating to View Buddy Profile Page.");
		MemberProfilePage memberProfilePage = buddiesPage.viewBuddyProfile(buddyName);

		selenium.logComment("Removing Buddy from My buddies.");
		memberProfilePage.removeBuddy();

		selenium.logComment("Verifying that Add as a buddy button is displayed  on member profile after removing member from My Buddies.");
		assertTrue("Add as a Buddy button is not available after removing buddy from my buddies.", selenium.isElementPresent("css=input[value='Add as a Buddy']"), selenium);

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();

	}	

	/***
	 * This is data provider for testSearchMyBuddy Test Script.
	 */ 
	@DataProvider(name = "searchBuddiesDataProvider")
	public Object[][] createSearchBuddyData() {
		return new Object[][] {
				{"gauravbansal"},
		};
	}
	  /**
	  * Positive Test script for searching specific buddy name from all my Buddies. 
	  */
	@Test (dataProvider = "searchBuddiesDataProvider")
	public void testSearchMyBuddy(String buddyName) {

		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Buddies Page.");
		selenium.logComment("Search for given buddy name in My Buddies.");
		selenium.logComment("Verify that the buddy name is displayed in the search results");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username2"), ConfigFileReader.getConfigItemValue("tbb.password2"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username2"), ConfigFileReader.getConfigItemValue("tbb.password2"));
		}

		selenium.logComment("Navigating to Profile Page.");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();

		selenium.logComment("Navigating to Edit Buddies Page.");
		BuddiesPage buddiesPage = myProfilePage.editBuddies();

		selenium.logComment("Search for given buddy name in My Buddies.");
		buddiesPage.searchMyBuddies(buddyName);

		selenium.logComment("Verify that the buddy name is displayed in the search results");
		assertTrue("Buddy Not Found", selenium.isTextPresent(buddyName), selenium);

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
}
