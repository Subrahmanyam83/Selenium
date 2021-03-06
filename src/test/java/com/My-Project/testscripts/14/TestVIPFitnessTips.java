package com.tbb.testscripts.watchvideos;

import java.lang.reflect.Method;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.watchvideos.WatchVideosPage;
/**
 *
 * This test script contains test method(s) for VIP Fitness Tips page under 'Watch Videos' module.
 *  @author Jaya
 */
public class TestVIPFitnessTips extends BaseTest {

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
	 * Positive Test script for verifying viewing of left menu of Watch Videos Page.
	 * It verifies if all the required elements are present on the left hand side Watch Videos menu and are working correctly. 
	 */ 
	@Test
	public void testVIPFitnessTips(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Watch Videos' link");
		selenium.logComment("Navigating to VIP Fitness Tips Page");
		selenium.logComment("Verifying that all the required elements are present on VIP Fitness Tips Page");
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
		
		selenium.logComment("Clicking on 'Watch Videos' link");
		WatchVideosPage watchVideosPage = dashboardPage.clickWatchVideosLink();

		selenium.logComment("Navigating to VIP Fitness Tips Page");
		watchVideosPage.clickVIPFitnessTipsWatchNow();

		selenium.logComment("Verifying that all the required elements are present on VIP Fitness Tips Page");
		Screen s = new Screen();
		String path = ConfigFileReader.getConfigItemValue("sikuli.scripts.images") + "watch_videos\\";
		try {			 
			s.wait(path + "SCROLL_BAR_SOURCE_POSITION.png", 10);
			s.dragDrop(path + "SCROLL_BAR_SOURCE_POSITION.png", path + "SCROLL_BAR_END_POSITION.png", 0);
			
			s.wait(path + "PLAY.png", 10);
			s.exists(path + "VIDEO_START_TIME.png");
			s.hover(path + "PLAY.png");
			s.click(path + "PLAY_ICON_HIGHLIGHTED.png", 0);
			s.hover(path + "SCROLL_BAR.png");
			s.wait(path + "PAUSE.png", 15);

			s.hover(path + "EMAIL.png");
			s.click(path + "EMAIL_HIGHLIGHTED.png", 0);
			s.wait(path + "EMAIL_TO_FRIEND_FORM.png", 15);
			
			s.click(path + "YOUR_EMAIL_TEXTBOX.png", 0);
			s.type(path + "YOUR_EMAIL_TEXTBOX.png", "jgupta@xebia.com",0);
			
			s.click(path + "FRIENDS_EMAIL_TEXTBOX.png", 0);
			s.type(path + "FRIENDS_EMAIL_TEXTBOX.png", "jgupta@gmail.com",0);
			
			s.click(path + "MESSAGE_TEXTBOX.png", 0);
			s.type(path + "MESSAGE_TEXTBOX.png", "Hi Sending Video",0);
			
			s.click(path + "SEND_BUTTON.png", 0);
			s.wait(path + "YOUR_EMAIL_WAS_SENT_LABEL.png", 15);

			s.hover(path + "SHARE.png");
			s.click(path + "SHARE_HIGHLIGHTED.png",0);
			s.wait(path + "SHARE_THIS_VIDEO_FORM.png", 15);
			s.wait(path + "COPY_LINK_BUTTON.png", 15);
			s.click(path + "COPY_LINK_BUTTON.png", 0);
			s.wait(path + "COPIED_LABEL.png", 15);

			s.hover(path + "GET_LINK.png");
			s.click(path + "GET_LINK_HIGHLIGHTED.png", 0);
			s.wait(path + "LINK_TO_THIS_VIDEO_FORM.png", 15);
			s.wait(path + "COPY_LINK_BUTTON.png", 15);
			s.click(path + "COPY_LINK_BUTTON.png", 0);
			s.wait(path + "COPIED_LABEL.png", 15);

			s.hover(path + "GET_CODE.png");
			s.click(path + "GET_CODE_ICON_HIGHLIGHTED.png", 0);
			s.wait(path + "ADD_TO_THIS_WEBSITE_FORM.png", 15);
			s.wait(path + "COPY_LINK_BUTTON.png", 15);
			s.click(path + "COPY_CODE_BUTTON.png", 0);
			s.wait(path + "COPIED_LABEL.png", 15);

			s.hover(path + "FULL_SCREEN_ICON.png");
			s.click(path + "FULL_SCREEN_ICON_HIGHLIGHTED.png", 0);
			s.wait(path + "MINIMIZE_ICON.png", 15);
			s.hover(path + "MINIMIZE_ICON.png");
			s.wait(path + "MINIMIZE_ICON_HIGHLIGHTED.png", 15);
			s.click(path + "MINIMIZE_ICON_HIGHLIGHTED.png", 0);
			s.wait(path + "FULL_SCREEN_ICON.png", 15);

			s.hover(path + "SPEAKER_ICON.png");
			s.click(path + "SPEAKER_ICON_HIGHLIGHTED.png", 0);
			s.wait(path + "SOUND_BAR.png", 10);
			s.hover(path + "MENU_ICON.png");
			s.click(path + "MENU_ICON_HIGHLIGHTED.png", 0);
			s.wait(path + "RELATED_VIDEO_LABEL.png", 15);
			s.hover(path + "PAUSE.png");
			s.click(path + "PAUSE_ICON_HIGHLIGHTED.png", 0);
			
			s.dragDrop(path + "SCROLL_BAR_SOURCE_POSITION.png", path + "SCROLL_BAR_END_POSITION3.png", 0);
			s.exists(path + "EPISODES.png");
			s.exists(path + "DISABLED_PREV_ARROW.png");
			
			if(s.exists(path + "ENABLED_NEXT_ARROW.png") != null){
				s.hover(path + "ENABLED_NEXT_ARROW.png");
				s.click(path + "DOUBLE_SIDED_ARROW.png", 0);
				s.exists(path + "ENABLED_PREV_ARROW.png");
			}
			else{
				s.exists(path + "DISABLED_NEXT_ARROW.png");
			}			
		} 
		catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}