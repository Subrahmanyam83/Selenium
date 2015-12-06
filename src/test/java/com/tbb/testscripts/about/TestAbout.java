package com.tbb.testscripts.about;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.About;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.about.AboutPage;
import com.tbb.pages.about.CoachesPage;
import com.tbb.pages.about.CommunityPage;
import com.tbb.pages.about.DailySweepstakesPage;
import com.tbb.pages.about.JoinUpgradePage;
import com.tbb.pages.about.NewslettersPage;
import com.tbb.pages.about.ProductsPage;

/**
 * 
 * This test script contains test method(s) for About main page
 * @author Jaya
 */
public class TestAbout extends BaseTest{

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
	 * Positive Test script for verifying viewing of left hand side menu of About Page.
	 * It verifies if all the required links in the left menu are working correctly. 
	 */ 
	@Test 
	public void testAboutPageLeftMenuLinks(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifies whether on Home page.");
		selenium.logComment("Clicks on 'Sign In' Link");
		selenium.logComment("Enters valid username and password");
		selenium.logComment("Clicks on on 'Connect' link");
		selenium.logComment("Verifies number of links in left side Menu");
		selenium.logComment("Verifies Links' title shown in left side Menu");
		selenium.logComment("Clicks on 'Join/Upgrade' Link from left side menu");
		selenium.logComment("Clicks on 'Community' Link from left side menu");
		selenium.logComment("Clicks on 'Coaches' Link from left side menu");
		selenium.logComment("Clicks on 'Daily Sweepstakes' Link from left side menu");
		selenium.logComment("Clicks on 'Products' Link from left side menu");
		selenium.logComment("Clciks on 'Newsletters' Link from left side menu");
		selenium.logComment("Executes assertEmpty method");
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
		AboutPage aboutPage = dashboardPage.clickAboutLink();
		
		selenium.logComment("Verifying number of links in left side Menu");
		assertTrue("All links are not displayed", aboutPage.getMenuLinksCount()==7, selenium );
		
		selenium.logComment("Verifying Links' title shown in left side Menu");
		assertTrue("Expected Links are not displayed", Arrays.equals(aboutPage.getMenuLinksText(), new String[]{"Join/Upgrade","Community", "Coaches", "Daily Sweepstakes", "Products", "Newsletters", "Product Submissions"}), selenium);
		
		selenium.logComment("Clicking on 'Join/Upgrade' Link from left side menu");
		JoinUpgradePage joinUpgradePage = aboutPage.goToJoinUpgradePage();
		aboutPage = joinUpgradePage.clickAboutLink();
		
		selenium.logComment("Clicking on 'Community' Link from left side menu");
		CommunityPage communityPage = aboutPage.goToCommunityPage();
		aboutPage = communityPage.clickAboutLink();
		
		selenium.logComment("Clicking on 'Coaches' Link from left side menu");
		CoachesPage coachesPage = aboutPage.goToCoachesPage();
		aboutPage = coachesPage.clickAboutLink();		
		
		selenium.logComment("Clicking on 'Daily Sweepstakes' Link from left side menu");
		DailySweepstakesPage dailySweepstakesPage = aboutPage.goToDailySweepstakesPage();
		aboutPage = dailySweepstakesPage.clickAboutLink();
		
		selenium.logComment("Clicking on 'Products' Link from left side menu");
		ProductsPage productsPage = aboutPage.goToProductsPage();
		aboutPage = productsPage.clickAboutLink();
		
		selenium.logComment("Clicking on 'Newsletters' Link from left side menu");
		NewslettersPage newslettersPage = aboutPage.goToNewslettersPage();
		aboutPage = newslettersPage.clickAboutLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/**
	 * Positive Test script for verifying viewing of About Page.
	 * It verifies if all the required elements are present on the page. 
	 */ 
	@Test
	public void testAboutPageContent() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifies whether user is on Home page.");
		selenium.logComment("Clicks on 'Sign In' Link");
		selenium.logComment("Enters valid username and password");
		selenium.logComment("Navigates to Connect Page");
		selenium.logComment("Verifies number of links in center content area");
		selenium.logComment("Verifies that all the required fields are present on the About Page.");
		selenium.logComment("Verifies number of images in center content area");
		selenium.logComment("Verifies title headings in right side content area");
		selenium.logComment("Verifies 'Learn More' links in center content area");
		selenium.logComment("Clicks on 'Learn More' link under 'Join Now or Upgrade' in central content area");
		selenium.logComment("Clicks on 'Learn More' link under 'Products' in central content area");
		selenium.logComment("Clicks on 'Learn More' link under 'Community' in central content area");
		selenium.logComment("Clicks on 'Learn More' link under 'Coaches' in central content area");
		selenium.logComment("Clicks on 'Learn More' link under 'Daily Sweepstakes' in central content area");
		selenium.logComment("Clicks on 'Learn More' link under 'Newsletters' in central content area");
		selenium.logComment("Executes assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		selenium.logComment("Verifying whether user is on Home page");
		HomePage home = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = home.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = home.clickSignIn();
			
			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}
		
		selenium.logComment("Navigating to Connect Page.");
		AboutPage aboutPage = dashboardPage.clickAboutLink();
		
		selenium.logComment("Verifying number of links in center content area");
		assertTrue("All links are not displayed", aboutPage.getContentLinksCount()==6, selenium );
		
		selenium.logComment("Verifying that all the required fields are present on the About Page.");
		assertTrue("Expected Page header 'About' is not available", selenium.isElementPresent(About.HEADER), selenium);
		assertTrue("Expected intro text is not available.", selenium.isElementPresent(About.INTRO_TEXT), selenium);
		assertTrue("Expected quote is not available", selenium.isElementPresent(About.HEADER_QUOTE), selenium);
		
		selenium.logComment("Verifying number of images in center content area");
		assertTrue("All images are not displayed", aboutPage.getImageLinksCount()==6, selenium );
		
		selenium.logComment("Verifying title headings in right side content area");
		assertTrue("Expected headings are not displayed", Arrays.equals(aboutPage.getContentLinksText(), new String[]{"Join Now or Upgrade","Products", "Community", "Coaches", "WOWY SuperGym™ Daily Sweepstakes", "Newsletters"}), selenium);
				
		selenium.logComment("Verifying 'Learn More' links in center content area");
		assertTrue("All 'Learn More' links are not displayed", aboutPage.getLearnMoreLinksCount()==6, selenium );
		
		selenium.logComment("Clicking on 'Learn More' link under 'Join Now or Upgrade' in central content area");
		JoinUpgradePage joinUpgradePage = aboutPage.clickJoinUpgradeLearnMore();
		aboutPage = joinUpgradePage.clickAboutLink();
		
		selenium.logComment("Clicking on 'Learn More' link under 'Products' in central content area");
		ProductsPage productsPage = aboutPage.clickProductsLearnMore();
		aboutPage = productsPage.clickAboutLink();
		
		selenium.logComment("Clicking on 'Learn More' link under 'Community' in central content area");
		CommunityPage communityPage = aboutPage.clickCommunityLearnMore();
		aboutPage = communityPage.clickAboutLink();
				
		selenium.logComment("Clicking on 'Learn More' link under 'Coaches' in central content area");
		CoachesPage coachesPage = aboutPage.clickCoachesLearnMore();
		aboutPage = coachesPage.clickAboutLink();
		
		selenium.logComment("Clicking on 'Learn More' link under 'Daily Sweepstakes' in central content area");
		DailySweepstakesPage dailySweepstakesPage = aboutPage.clickDailySweepstakesLearnMore();
		aboutPage = dailySweepstakesPage.clickAboutLink();
		
		selenium.logComment("Clicking on 'Learn More' link under 'Newsletters' in central content area");
		NewslettersPage newslettersPage = aboutPage.clickNewslettersLearnMore();
		aboutPage = newslettersPage.clickAboutLink();
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}  
}