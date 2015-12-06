package com.tbb.testscripts.profile;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.GroupsTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.WorkoutGroupDetailPage;
import com.tbb.pages.WorkoutGroupsPage;
import com.tbb.pages.WorkoutGroupsSearchPage;
import com.tbb.pages.profile.BasicInformationPage;
import com.tbb.pages.profile.GroupsPage;
import com.tbb.pages.profile.MyProfilePage;
/**
 * 
 * This test script contains test method(s) for "Edit Profile: Groups" page under Profile section.
 *  @author Jaya
 */
public class TestGroupsPage extends BaseTest implements GroupsTab {
	
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
	 * Positive Test script for joining two groups: PowerHouse and Brazil Butts. 
	 */ 
	@Test 
	public void testGroupsPage() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Basic Information Page.");
		selenium.logComment("Navigating to Groups Page.");
		selenium.logComment("Clicking on 'View Workout Groups' link.");
		selenium.logComment("Clicking on 'See all Groups' link.");
		selenium.logComment("Clicking on Powerhouse Group link.");
		selenium.logComment("Joining the group.");
		selenium.logComment("Navigating to Edit Profile Page.");
		selenium.logComment("Navigating to Edit Basic Information Page.");
		selenium.logComment("Navigating to Groups Page.");
		selenium.logComment("Clicking on 'View Workout Groups' link.");
		selenium.logComment("Clicking on 'See all Groups' link.");
		selenium.logComment("Clicking on Brazil Butts Group link.");
		selenium.logComment("Joining the group.");
		selenium.logComment("Signing out of the website.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");	
		
		
		
		
		selenium.logComment("Verifying whether user is on Home page");
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
		
		selenium.logComment("Navigating to Edit Basic Information Page.");
		BasicInformationPage basicInformationPage = myProfilePage.clickEditBasicInformation();
		
		selenium.logComment("Navigating to Groups Page.");
		GroupsPage groupsPage = basicInformationPage.clickLRMGroupsLink();
		
		selenium.logComment("Clicking on 'View Workout Groups' link.");
		WorkoutGroupsPage workoutGroupsPage = groupsPage.viewWorkoutGroupsLink();
		
		selenium.logComment("Clicking on 'See all Groups' link.");
		WorkoutGroupsSearchPage workoutGroupsSearchPage = workoutGroupsPage.clickSeeAllGroupsLink();
		
		selenium.logComment("Clicking on Powerhouse Group link.");
		WorkoutGroupDetailPage workoutGroupDetailPage = workoutGroupsSearchPage.viewPowerhouseGroup();
		
		selenium.logComment("Joining the group.");
		workoutGroupDetailPage.joinThisGroup();
		
		selenium.logComment("Navigating to Edit Profile Page.");
		myProfilePage = workoutGroupDetailPage.clickProfile();
		
		selenium.logComment("Navigating to Edit Basic Information Page.");
		basicInformationPage = myProfilePage.clickEditBasicInformation();
		
		selenium.logComment("Navigating to Groups Page.");
		groupsPage = basicInformationPage.clickLRMGroupsLink();
		
		selenium.logComment("Clicking on 'View Workout Groups' link.");
		workoutGroupsPage = groupsPage.viewWorkoutGroupsLink();
		
		selenium.logComment("Clicking on 'See all Groups' link.");
		workoutGroupsSearchPage = workoutGroupsPage.clickSeeAllGroupsLink();
		
		selenium.logComment("Clicking on Brazil Butts Group link.");
		workoutGroupDetailPage = workoutGroupsSearchPage.viewBrazilButtsGroup();
		
		selenium.logComment("Joining the group.");
		workoutGroupDetailPage.joinThisGroup();
		
		selenium.logComment("Signing out of the website.");
		homePage = workoutGroupDetailPage.signOut();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}	 
	
	
	/***
	 * Positive Test script for testing reset of selected groups. 
	 */ 
	@Test (dependsOnMethods = { "testGroupsPage" })
	public void testResetSelectedGroups() throws InterruptedException {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Launching website.");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Basic Information Page.");
		selenium.logComment("Navigating to Groups Page.");
		selenium.logComment("Selecting all the groups on the Groups Page.");
		selenium.logComment("Resetting the selections on Groups Page.");
		selenium.logComment("Verifying if the selected checkboxes were reset successfully on Groups Page.");
		selenium.logComment("Signing out of the website.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		selenium.logComment("Launching website.");
		selenium.open("/");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		
		selenium.logComment("Verifying whether user is on Home page");
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
		
		selenium.logComment("Navigating to Edit Basic Information Page.");
		BasicInformationPage basicInformationPage = myProfilePage.clickEditBasicInformation();
		
		selenium.logComment("Navigating to Groups Page.");
		GroupsPage groupsPage = basicInformationPage.clickLRMGroupsLink();
		
		selenium.logComment("Selecting all the groups on the Groups Page.");
		selenium.check(POWERHOUSE_CHECKBOX);
		selenium.check(BRAZIL_BUTT_CHECKBOX);
		
		selenium.logComment("Resetting the selections on Groups Page.");
		groupsPage.resetSelectedGroups();
		
		selenium.logComment("Verifying if the selected checkboxes were reset successfully on Groups Page.");
		assertTrue("Checkbox was not reset", new Boolean(selenium.isChecked(POWERHOUSE_CHECKBOX)).toString().equals("false"), selenium);
		assertTrue("Checkbox was not reset", new Boolean(selenium.isChecked(BRAZIL_BUTT_CHECKBOX)).toString().equals("false"), selenium);
		
		selenium.logComment("Signing out of the website.");
		homePage = groupsPage.signOut();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
		
		}

	/***
	 * Positive Test script for leaving selected groups. 
	 * The user gets a success message at the end. 
	 */ 
	@Test (dependsOnMethods = { "testResetSelectedGroups" })

	public void testLeaveSelectedGroups() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Launching website.");
		selenium.logComment("Verifying whether user is on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Navigating to Edit Basic Information Page.");
		selenium.logComment("Navigating to Groups Page.");
		selenium.logComment("Selecting all the groups on the Groups Page.");
		selenium.logComment("Leaving the selected groups on the Groups Page.");
		selenium.logComment("Verifying that Your request is processed successfully message is displayed on the Groups Page.");
		selenium.logComment("Signing out of the website.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		selenium.logComment("Launching website.");
		selenium.open("/");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		
		selenium.logComment("Verifying whether user is on Home page");
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
		
		selenium.logComment("Navigating to Edit Basic Information Page.");
		BasicInformationPage basicInformationPage = myProfilePage.clickEditBasicInformation();
		
		selenium.logComment("Navigating to Groups Page.");
		GroupsPage groupsPage = basicInformationPage.clickLRMGroupsLink();
	
		selenium.logComment("Selecting all the groups on the Groups Page.");
		selenium.check(POWERHOUSE_CHECKBOX);
		selenium.check(BRAZIL_BUTT_CHECKBOX);
		
		selenium.logComment("Leaving the selected groups on the Groups Page.");
		groupsPage.leaveSelectedGroups();
		
		selenium.logComment("Verifying that Your request is processed successfully message is displayed on the Groups Page.");
		assertTrue("Leave Group Success message is not displayed.", selenium.isElementPresent("css=div.portlet-msg-success"), selenium);
		
		selenium.logComment("Signing out of the website.");
		homePage = groupsPage.signOut();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}	
}

