package com.tbb.testscripts.about;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.AboutCommunity;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.about.CommunityPage;
import com.tbb.pages.connect.MemberGalleryPage;
import com.tbb.pages.connect.MemberGallerySearchResultsPage;
import com.tbb.pages.connect.MessageBoardsPage;
import com.tbb.pages.connect.MessageCenterPage;
import com.tbb.pages.getfit.WorkoutGroupsPage;
import com.tbb.pages.profile.BlogPage;

/**
 *
 * This test script contains test method(s) for Community page under About module
 *  @author Jaya
 */
public class TestCommunity extends BaseTest{

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
	 * Positive Test script for verifying viewing of About Community Page.
	 * It verifies if all the required elements are present on the Community page. 
	 */ 
	@Test 
	public void testCommunity(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifies whether are on Home page.");
		selenium.logComment("Clicks on 'Sign In' Link.");
		selenium.logComment("Enters valid username and password.");
		selenium.logComment("Clicks on 'About' link.");
		selenium.logComment("Clicks on About Community link.");
		selenium.logComment("Verifies that all the required elements are present on the Coaches page.");
		selenium.logComment("Verifies that user can view Entire Gallery page.");
		selenium.logComment("Navigates to About link.");
		selenium.logComment("Clicks on About Community link.");
		selenium.logComment("Verifies the Find Buddies Now link.");
		selenium.logComment("Navigates to About link.");
		selenium.logComment("Clicks on About Community link.");
		selenium.logComment("Verifies Find Workout Groups link.");
		selenium.logComment("Navigates to About link.");
		selenium.logComment("Clicks  About Community link.");
		selenium.logComment("Verifies the Visit Message Boards link.");
		selenium.logComment("Navigates to About link.");
		selenium.logComment("Clicks on About Community link.");
		selenium.logComment("Verifies Visit Blog link.");
		selenium.logComment("Navigates to About link.");
		selenium.logComment("Clicks on About Community link.");
		selenium.logComment("Verifies Visit the Message Center link.");
		selenium.logComment("Navigates to About link.");
		selenium.logComment("Clicks on About Community link.");
		selenium.logComment("Verifies Visit Wowy Supergym link.");
		selenium.logComment("Executes assertEmpty method.");
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

		selenium.logComment("Clicking on 'About' link");
		AboutPage aboutPage = dashboardPage.clickAboutLink();

		selenium.logComment("Clicking on About Community link");
		CommunityPage communityPage = aboutPage.goToCommunityPage();

		selenium.logComment("Verifying that all the required elements are present on the Coaches page.");
		assertTrue("Expected image is not available", selenium.isElementPresent(AboutCommunity.COMMUNITY_HEADER), selenium);
		assertTrue("Expected page header is not available", selenium.isElementPresent(AboutCommunity.COMMUNITY_INTRO_TEXT), selenium);
		assertTrue("Expected image is not available", selenium.isElementPresent(AboutCommunity.COMMUNITY_IMAGE), selenium);
		assertTrue("Expected introductory text is not available", selenium.isElementPresent(AboutCommunity.JUST_A_FEW_OF_OUR_ACTIVE_MEMBERS_TEXT), selenium);
		assertTrue("Expected button is not available", selenium.isElementPresent(AboutCommunity.SEE_ENTIRE_MEMBER_GALLERY_LINK), selenium);
		assertTrue("Expected page footer is not available", selenium.isElementPresent(AboutCommunity.DISABLED_PREVIOUS_ARROW), selenium);
		assertTrue("Expected image is not available", selenium.isElementPresent(AboutCommunity.ENABLED_NEXT_ARROW), selenium);
		communityPage.clickNextArrow();
		assertTrue("Expected page header is not available", selenium.isElementPresent(AboutCommunity.ENABLED_PREVIOUS_ARROW), selenium);
		assertTrue("Number of Inspiring Coaches pics displayed is incorrect.", communityPage.getAllImagesBetweenArrowsCount()==32, selenium );
		assertTrue("Expected introductory text is not available", selenium.isElementPresent(AboutCommunity.TEAM_BEACHBODY_IS_YOUR_TOTAL_FITNESS_SOLUTION_TEXT), selenium);
		assertTrue("Expected button is not available", selenium.isElementPresent(AboutCommunity.TOTAL_FITNESS_SOLUTION_INTRO_TEXT), selenium);
		assertTrue("Number of Inspiring Coaches pics displayed is incorrect.", communityPage.getAllFitnessSolutionImagesCount()==6, selenium );
		assertTrue("Number of Inspiring Coaches pics displayed is incorrect.", communityPage.getAllFitnessSolutionHeaderCount()==6, selenium );
		assertTrue("Number of Inspiring Coaches pics displayed is incorrect.", communityPage.getAllFitnessSolutionTextCount()==6, selenium );
		assertTrue("Number of Inspiring Coaches pics displayed is incorrect.", communityPage.getAllFitnessSolutionLinksCount()==6, selenium );
		assertTrue("Expected introductory text is not available", selenium.isElementPresent(AboutCommunity.FIND_BUDDIES_NOW_LINK), selenium);
		assertTrue("Expected button is not available", selenium.isElementPresent(AboutCommunity.FIND_WORKOUT_GROUPS_LINK), selenium);
		assertTrue("Expected introductory text is not available", selenium.isElementPresent(AboutCommunity.VISIT_MESSAGE_BOARDS_LINK), selenium);
		assertTrue("Expected button is not available", selenium.isElementPresent(AboutCommunity.VISIT_BLOGS_LINK), selenium);
		assertTrue("Expected introductory text is not available", selenium.isElementPresent(AboutCommunity.VISIT_THE_MESSAGE_CENTER_LINK), selenium);
		assertTrue("Expected button is not available", selenium.isElementPresent(AboutCommunity.VISIT_WOWY_SUPERGYM_LINK), selenium);

		selenium.logComment("Verifying that user can view Entire Gallery page.");
		MemberGallerySearchResultsPage memberGallerySearchResultsPage = communityPage.clickSeeEntireGalleryLink();

		selenium.logComment("Navigating to About link");
		aboutPage = memberGallerySearchResultsPage.clickAboutLink();

		selenium.logComment("Clicking on About Community link");
		communityPage = aboutPage.goToCommunityPage();

		selenium.logComment("Verifying the Find Buddies Now link.");
		MemberGalleryPage memberGalleryPage = communityPage.clickFindBuddiesNowLink();

		selenium.logComment("Navigating to About link");
		aboutPage = memberGalleryPage.clickAboutLink();

		selenium.logComment("Clicking on About Community link");
		communityPage = aboutPage.goToCommunityPage();

		selenium.logComment("Verifying Find Workout Groups link.");
		WorkoutGroupsPage workoutGroupsPage = communityPage.clickFindWorkoutGroupsLink();

		selenium.logComment("Navigating to About link");
		aboutPage = workoutGroupsPage.clickAboutLink();

		selenium.logComment("Clicking on About Community link");
		communityPage = aboutPage.goToCommunityPage();

		selenium.logComment("Verifying the Visit Message Boards link.");
		MessageBoardsPage messageBoardsPage = communityPage.clickVisitMessageBoardsLink();

		selenium.logComment("Navigating to About link");
		aboutPage = messageBoardsPage.clickAboutLink();

		selenium.logComment("Clicking on About Community link");
		communityPage = aboutPage.goToCommunityPage();

		selenium.logComment("Verifying Visit Blog link.");
		BlogPage blogPage = communityPage.clickVisitBlogsLink();

		selenium.logComment("Navigating to About link");
		aboutPage = blogPage.clickAboutLink();

		selenium.logComment("Clicking on About Community link");
		communityPage = aboutPage.goToCommunityPage();

		selenium.logComment("Verifying Visit the Message Center link.");
		MessageCenterPage messageCenterPage = communityPage.clickVisitTheMessageCenterLink();

		selenium.logComment("Navigating to About link");
		aboutPage = messageCenterPage.clickAboutLink();

		selenium.logComment("Clicking on About Community link");
		communityPage = aboutPage.goToCommunityPage();

		selenium.logComment("Verifying Visit Wowy Supergym link.");
		communityPage.clickVisitWowySupergymLink();

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}