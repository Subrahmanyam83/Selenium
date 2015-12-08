package com.tbb.testscripts.profile;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.PhotosTab;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.profile.MyProfilePage;
import com.tbb.pages.profile.PhotosPage;
/**
 * 
 * This test script contains test method(s) for "Edit Profile: Photos" page under Profile section.
 *  @author Jaya
 */
public class TestPhotos extends BaseTest implements PhotosTab{
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
	 * Positive Test script for viewing Photos Page. 
	 */
	@Test 
	public void testViewPhotos() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigating to Profile Page.");
		selenium.logComment("Click on 'Edit my profile photo' link.");
		selenium.logComment("Verifying that all the required elements are present on the center section of 'Photos' page.");
		selenium.logComment("Clicking on 'Terms of Use' link.");
		selenium.logComment("Verifying that 'Terms of Use' content is displayed.");
		selenium.logComment("Closing Terms of User link.");
		selenium.logComment("Verifying that 'Basic Team Beachbody Photos' header is present on Photos Page.");
		selenium.logComment("Verifying that all the photo holders are available on Photos Page.");
		selenium.logComment("Verifying that all the browse photo textboxes are available on Photos Page.");
		selenium.logComment("Verifying that all the Update photo buttons are available on Photos Page.");
		selenium.logComment("Verifying that all the Month drop downs are available on Photos Page.");
		selenium.logComment("Verifying that all the day drop downs are available on Photos Page.");
		selenium.logComment("Verifying that all the Year drop downs are available on Photos Page.");
		selenium.logComment("Verifying that all the calender icons are available on Photos Page.");
		selenium.logComment("Verifying that all the content is displayed in Photo Gallery section on Photos Page.");
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
		
		selenium.logComment("Click on 'Edit my profile photo' link.");
		PhotosPage photosPage = myProfilePage.editMyProfilePhoto();
		
		selenium.logComment("Verifying that all the required elements are present on the center section of 'Photos' page.");
		assertTrue("Expected Header 'Photos' not available.", selenium.isElementPresent(HEADER), selenium);
		assertTrue("Expected description paragraph for 'Photos' not available.", selenium.isElementPresent(PHOTOS_PARAGRAPH), selenium);
		assertTrue("Expected Watch Tutorial Video Link not available.", selenium.isElementPresent(WATCH_TUTORIAL_VIDEO), selenium);
		assertTrue("Expected Terms of Use Checkbox not available.", selenium.isElementPresent(TERMS_OF_USE_CHECKBOX), selenium);
		assertTrue("Expected Terms of Use Text not available", selenium.isTextPresent("I certify that I have the right to distribute these photos and that they do not violate the Terms of Use."), selenium);
		assertTrue("Expected Terms of Use Link not available.", selenium.isElementPresent(TERMS_OF_USE_LINK), selenium);
		
		selenium.logComment("Clicking on 'Terms of Use' link.");
		photosPage.clickTermsOfUseLink();
		
		selenium.logComment("Verifying that 'Terms of Use' content is displayed.");
		assertTrue("Expected Text 'Team Beachbody Photo Terms of Service' is not available.", selenium.isElementPresent("css=div.header>h1:contains(Team Beachbody Photo Terms of Service)"), selenium);
		assertTrue("Expected text 'Terms of Service text' is not available.", selenium.isElementPresent("css=div.faq-content>p"), selenium);
		assertTrue("Expected 'Terms of Service close button' is not available.", selenium.isElementPresent("css=a[href='javascript:_USER_PROFILE_PHOTOS_WAR_userprofileportlet_hideTermsOfUse()']"), selenium);
		
		selenium.logComment("Closing Terms of User link.");
		photosPage.closeTermsOfUseLink();		
		
		selenium.logComment("Verifying that 'Basic Team Beachbody Photos' header is present on Photos Page.");
		assertTrue("Expected Text 'Basic Team Beachbody Photos' not present.", selenium.isTextPresent("Basic Team Beachbody Photos"), selenium);
		
		selenium.logComment("Verifying that all the photo holders are available on Photos Page.");
		assertTrue("All the Photos are not displayed", photosPage.getPhotosCount()==13, selenium);	
		
		selenium.logComment("Verifying that all the browse photo textboxes are available on Photos Page.");
		assertTrue("All the browse photo text boxes are not displayed", photosPage.getBrowseTextboxCount()==4, selenium);	
		
		selenium.logComment("Verifying that all the Update photo buttons are available on Photos Page.");
		assertTrue("All the Update photo buttons are not displayed", photosPage.getUpdatePhotoCount()==3, selenium);	
		
		assertTrue("Expected heading 'Profile Photo' not present.", selenium.isElementPresent(PROFILE_PHOTO), selenium);
		assertTrue("Expected Text 'This is the photo that members will see in your profile. It will also appear in WOWY SuperGym™ when you're working out.' not present.", selenium.isTextPresent("This is the photo that members will see in your profile. It will also appear in WOWY SuperGym™ when you're working out."), selenium);
		
		assertTrue("Expected heading 'Progress Photo: Before' not present.", selenium.isElementPresent(PROGRESS_PHOTO_BEFORE), selenium);
		assertTrue("Expected Text 'Select a photo to be your 'before' picture.' not present.", selenium.isTextPresent("Select a photo to be your \"before\" picture."), selenium);
		
		selenium.logComment("Verifying that all the Month drop downs are available on Photos Page.");
		assertTrue("All the Month drop downs are not displayed", photosPage.getMonthDropdownCount()==3, selenium);	
		
		selenium.logComment("Verifying that all the day drop downs are available on Photos Page.");
		assertTrue("All the day drop downs are not displayed", photosPage.getDayDropdownCount()==3, selenium);	
		
		selenium.logComment("Verifying that all the Year drop downs are available on Photos Page.");
		assertTrue("All the Year drop downs are not displayed", photosPage.getYearDropdownCount()==3, selenium);	
		
		selenium.logComment("Verifying that all the calender icons are available on Photos Page.");
		assertTrue("All the calender icons are not displayed", photosPage.getCalenderIconCount()==1, selenium);	
		
		assertTrue("Expected heading 'Progress Photo: Current' not present.", selenium.isElementPresent(PROGRESS_PHOTO_CURRENT), selenium);
		assertTrue("Expected Text 'Select a recent photo of yourself.' not present.", selenium.isTextPresent("Select a recent photo of yourself."), selenium);
		
		selenium.logComment("Verifying that all the content is displayed in Photo Gallery section on Photos Page.");
		assertTrue("Expected heading 'Photo Gallery' is not present.", selenium.isElementPresent(PHOTO_GALLERY_HEADER), selenium);
		assertTrue("Expected Text 'You may include...' is not present.", selenium.isTextPresent("You may include up to 20 additional photos in your Team Beachbody photo gallery. Add, edit, or delete your photos below."), selenium);
		assertTrue("Expected Text 'Add a photo...' is not present.", selenium.isTextPresent("Add a photo to your gallery (20 slots available)"), selenium);
		assertTrue("Expected Text 'Choose image:' is not present.", selenium.isTextPresent("Choose image:"), selenium);
		assertTrue("Expected Text 'Title:' is not present.", selenium.isTextPresent("Title::"), selenium);
		assertTrue("Expected text box for Title is not present.", selenium.isElementPresent(TITLE_TEXTBOX), selenium);
		assertTrue("Expected text '75 character maximum' is not present.", selenium.isElementPresent(MAX_CHARACTERS_GREY), selenium);
		assertTrue("Expected Text 'Date taken' is not present.", selenium.isTextPresent("Date taken"), selenium);
		assertTrue("Expected 'Add Photo' button is not present.", selenium.isElementPresent(ADD_PHOTO_BUTTON), selenium);
		assertTrue("Expected text 'Click on any...' is not present.", selenium.isTextPresent("Click on any photo to edit or delete it"), selenium);		
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();		
		}
}
