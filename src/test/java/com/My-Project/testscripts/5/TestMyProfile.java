package com.tbb.testscripts.connect;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.MyProfile;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.NotificationsPage;
import com.tbb.pages.profile.MyProfilePage;

/**
 *
 * This test script contains test method(s) for My Profile page under Connect module
 *  @author Jaya
 */
public class TestMyProfile extends BaseTest{

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
	 * Positive Test script for verifying viewing of My Profile Page.
	 * It verifies if all the required elements are present on the My Profile Page. 
	 */ 
	@Test
	public void testViewMyProfilePage(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Clicking on 'Connect' link");
		selenium.logComment("Clicking on 'My Profile' Link from left side menu");
		selenium.logComment("Verifying the required elements are present on the My Profile Page.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");	
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}
		
		selenium.logComment("Clicking on 'Connect' link");
		ConnectPage connectPage = dashboardPage.clickConnectLink();

		selenium.logComment("Clicking on 'My Profile' Link from left side menu");
		connectPage.goToMyProfilePage();

		selenium.logComment("Verifying the required elements are present on the My Profile Page.");
		assertTrue("Expected profile photo is not available", selenium.isElementPresent(MyProfile.PROFILE_PHOTO), selenium);
		assertTrue("Expected edit photos link is not available", selenium.isElementPresent(MyProfile.EDIT_PHOTOS), selenium);
		assertTrue("Expected edit privacy settings link is not available", selenium.isElementPresent(MyProfile.EDIT_PRIVACY_SETTINGS), selenium);
		assertTrue("Expected view buddy notifications link is not available", selenium.isElementPresent(MyProfile.VIEW_NOTIFICATIONS), selenium);

		assertTrue("Expected progress bar is not available", selenium.isElementPresent(MyProfile.PROGRESS_BAR), selenium);
		assertTrue("Expected finish profile link is not available", selenium.isElementPresent(MyProfile.EDIT_PROFILE), selenium);
		assertTrue("Expected My Photos header is not available", selenium.isElementPresent(MyProfile.MY_PHOTOS_HEADER), selenium);
		assertTrue("Expected Profile Info is not available", selenium.isElementPresent(MyProfile.PROFILE_INFO), selenium);
		assertTrue("Expected Add Photos Now link is not available", selenium.isElementPresent(MyProfile.ADD_PHOTOS_NOW), selenium);
		assertTrue("Expected My Buddies Header is not available", selenium.isElementPresent(MyProfile.MY_BUDDIES_HEADER), selenium);
		assertTrue("Expected Edit Buddies link is not available", selenium.isElementPresent(MyProfile.EDIT_BUDDIES), selenium);

		assertTrue("Expected Screen name header is not available", selenium.isElementPresent(MyProfile.SCREEN_NAME_HEADER), selenium);
		assertTrue("Expected member profile intro text is not available", selenium.isElementPresent(MyProfile.MEMBER_PROFILE_INTRO_TEXT), selenium);
		assertTrue("Expected member profile info is not available", selenium.isElementPresent(MyProfile.MEMBER_PROFILE_INFO), selenium);
		assertTrue("Expected edit basic information link is not available", selenium.isElementPresent(MyProfile.EDIT_BASIC_INFORMATION), selenium);
		assertTrue("Expected start personal bio link is not available", selenium.isElementPresent(MyProfile.START_PERSONAL_BIO), selenium);

		assertTrue("Expected my progress label is not available", selenium.isElementPresent(MyProfile.MY_PROGRESS_LABEL), selenium);
		assertTrue("Expected my fitness goal label is not available", selenium.isElementPresent(MyProfile.MY_FITNESS_GOAL_LABEL), selenium);
		assertTrue("Expected edit progress and goals link is not available", selenium.isElementPresent(MyProfile.EDIT_PROGRESS_AND_GOALS), selenium);
		assertTrue("Expected my progress intro text is not available", selenium.isElementPresent(MyProfile.MY_PROGRESS_INTRO_TEXT), selenium);

		assertTrue("Expected Programs label is not available", selenium.isElementPresent(MyProfile.PROGRAMS_LABEL), selenium);
		assertTrue("Expected Edit Programs link is not available", selenium.isElementPresent(MyProfile.EDIT_PROGRAMS), selenium);
		assertTrue("Expected Meal Plan label is not available", selenium.isElementPresent(MyProfile.MEAL_PLAN_LABEL), selenium);
		assertTrue("Expected workout programs label is not available", selenium.isElementPresent(MyProfile.WORKOUT_PROGRAMS_LABEL), selenium);
		assertTrue("Expected gear label is not available", selenium.isElementPresent(MyProfile.GEAR_LABEL), selenium);
		assertTrue("Expected supplements label is not available", selenium.isElementPresent(MyProfile.SUPPLEMENTS_LABEL), selenium);

		assertTrue("Expected Add new blog entry link is not available", selenium.isElementPresent(MyProfile.ADD_NEW_BLOG_ENTRY), selenium);
		assertTrue("Expected Start your blog link is not available", selenium.isElementPresent(MyProfile.START_YOUR_BLOG), selenium);		
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
		}

	/**
	 * Positive Test script for verifying if the user has buddy invites on My Profile Page.
	 * It verifies if the link for Buddy invites is working fine. 
	 * It tests the ability to accept invites and the number of invites remaining after.
	 */ 
	@Test
	public void testBuddyInvitesMyProfilePage(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Clicking on 'Connect' link");
		selenium.logComment("Clicking on 'My Profile' Link from left side menu");
		selenium.logComment("Extracting the number of buddy requests.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");		
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username"), ConfigFileReader.getConfigItemValue("tbb.password"));
		}
		
		selenium.logComment("Clicking on 'Connect' link");
		ConnectPage connectPage = dashboardPage.clickConnectLink();

		selenium.logComment("Clicking on 'My Profile' Link from left side menu");
		MyProfilePage myProfilePage = connectPage.goToMyProfilePage();

		selenium.logComment("Extracting the number of buddy requests.");
		String notificationsText = selenium.getText(MyProfile.VIEW_NOTIFICATIONS);
		notificationsText = notificationsText.replace("New Buddy Request(s)", " ");
		int numberOfBuddyRequests = Integer.parseInt(notificationsText.trim());

		NotificationsPage notificationsPage = myProfilePage.viewNewBuddyRequests();

		assertTrue("Expected text is not available", selenium.isTextPresent("You have "+numberOfBuddyRequests+" new notifications"), selenium);

		if((numberOfBuddyRequests)>0){
			
			selenium.logComment("Verifying the number of buddy requests displayed is correct.");
			assertTrue("Expected text is not available", selenium.isTextPresent("Showing "+numberOfBuddyRequests+" result."), selenium);
			
			selenium.logComment("Accepting the buddy request.");
			notificationsPage.acceptBuddyRequest();			
			assertTrue("Expected text is not available", selenium.isTextPresent("Your request processed successfully."), selenium);
			
			selenium.logComment("Reducing the number of buddy requests as one buddy request was accepted.");
			numberOfBuddyRequests = (numberOfBuddyRequests-1);
			
			selenium.logComment("Verifying the correct number of notifications is displayed on Notifications page");
			assertTrue("Expected text is not available", selenium.isTextPresent("You have "+numberOfBuddyRequests+" new notifications"), selenium);
			
			selenium.logComment("Clicking on My Profile Link in the left hand side menu to navigate to My Profile Page.");
			notificationsPage.clickProfileLink();
			
			selenium.logComment("Verifying the correct number of notifications is displayed on Notifications page after accepting buddy request.");
			notificationsText = selenium.getText(MyProfile.VIEW_NOTIFICATIONS);
			notificationsText = notificationsText.replace("New Buddy Request(s)", " ");
			int newNumberOfBuddyRequests = Integer.parseInt(notificationsText.trim());
			assertTrue("Expected text is not available", (newNumberOfBuddyRequests==(numberOfBuddyRequests)), selenium);
		}
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
	}
}