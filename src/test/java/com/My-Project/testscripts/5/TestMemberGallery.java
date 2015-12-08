package com.tbb.testscripts.connect;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.MemberGallery;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.MemberProfilePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.MemberGalleryPage;
import com.tbb.pages.connect.MemberGallerySearchResultsPage;
import com.tbb.pages.connect.NotificationsPage;
import com.tbb.pages.profile.BuddiesPage;
import com.tbb.pages.profile.MyProfilePage;

/**
 * 
 * This test script contains test method(s) for Member Gallery page under Connect module
 * @author Gaurav
 */
public class TestMemberGallery extends BaseTest {

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
	
	/**
	 * This test verifies that a logged in user can search some member and send buddy invitation. Also person who got the buddy invitation can accept that.
	 * This also verifies that user's member gallery is shown correctly.
	 */
	@Test
	public void testMemberGallery() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Buddies Page.");
		selenium.logComment("Removing Buddy from My buddies.");
		selenium.logComment("Verifying that Add as a buddy button is displayed  on member profile after removing member from My Buddies.");
		selenium.logComment("Navigating to Dashboard page");
		selenium.logComment("Clicking on 'Connect' tab");
		selenium.logComment("Clicking 'Member Gallery' link");
		selenium.logComment("Verifying UI of Page");
		selenium.logComment("Searching for a member");
		selenium.logComment("Adding as buddy to searched member");
		selenium.logComment("Signing out from current user");
		selenium.logComment("Clicking on 'Sign In' Link");
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
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Navigating to Profile Page.");
		MyProfilePage myProfilePage = dashboardPage.clickProfile();
		
		selenium.logComment("Navigating to Edit Buddies Page.");
		BuddiesPage buddiesPage = myProfilePage.editBuddies();
		
		if(selenium.isElementPresent("css=a.small:contains(JAsnani)")) {
			selenium.logComment("Navigating to View Buddy Profile Page.");
			MemberProfilePage memberProfilePage = buddiesPage.viewBuddyProfile("JAsnani");
			
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

		selenium.logComment("Clicking on 'Connect' tab");
		ConnectPage connectPage = dashboardPage.clickConnectLink();
		
		selenium.logComment("Clicking 'Member Gallery' link");
		MemberGalleryPage memberGalleryPage = connectPage.clickMemberGalleryLearnMore();
		
		selenium.logComment("Verifying UI of Page");
		memberGalleryPage.verifyUI();
		
		selenium.logComment("Searching for a member");
		MemberGallerySearchResultsPage memberGallerySearchResultsPage = memberGalleryPage.searchMembers("JAsnani");
		
		selenium.logComment("Adding as buddy to searched member");
		selenium.click("css=span.small:contains(JAsnani)");
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		
		if(!selenium.isTextPresent("Buddy Invitation Sent")) {
		memberGallerySearchResultsPage.addBuddy("JAsnani");
		
		selenium.logComment("Signing out from current user");
		homePage = memberGallerySearchResultsPage.signOut();
		} else {
			selenium.click(MemberGallery.CLOSE_PROFILE_AREA);
			selenium.logComment("Signing out from current user");
			homePage = memberGalleryPage.clickSignOut();
		}
		
		selenium.logComment("Clicking on 'Sign In' Link");
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial("jgupta@xebia.com", "password");
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser("jgupta@xebia.com", "password");
		}
			
		selenium.logComment("Navigating to Profile Page.");
		myProfilePage = dashboardPage.clickProfile();
		
		selenium.logComment("Navigating to View New Buddy Requests Page.");
		NotificationsPage notifications = myProfilePage.viewNewBuddyRequests();
		
		selenium.logComment("Accepting the new buddy Requests.");
		notifications.acceptBuddyRequest();
		
		selenium.logComment("Verifying that Your request is processed successfully message is displayed.");
		assertTrue("Buddy Acceptance failed.", selenium.isElementPresent(MemberGallery.SUCCESS_MESSAGE), selenium);
				
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();	
	}
}
