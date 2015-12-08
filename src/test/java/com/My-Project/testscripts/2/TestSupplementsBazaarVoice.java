package com.tbb.testscripts.bazaarvoice;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.TestConsts;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.eatsmart.EatSmartPage;
import com.tbb.pages.eatsmart.ShakeologyAndSupplementsPage;

/**
 * 
 * This test script contains test method(s) for Supplements Bazaar Voice page under About module
 * @author Jaya
 */
public class TestSupplementsBazaarVoice extends BaseTest{

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
	 * Positive Test script for verifying viewing of Supplements: Bazaar Voice.
	 */ 
	@Test
	public void testSupplementsBazaarVoice(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Clicking on 'Eat Smart' link");
		selenium.logComment("Clicking on 'Shakeology and Supplements' link");
		selenium.logComment("Verifying the number of stars displayed.");
		selenium.logComment("Verifying that ratings and reviews are displayed.");
		selenium.logComment("Verifying the elements in 'Summary of Customer Ratings & Reviews' section.");
		selenium.logComment("Verifying the elements in 'Summary of Customer Ratings & Reviews' section.");
		selenium.logComment("Verifying the number of reviews displayed is more than one.");
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
		
		selenium.logComment("Clicking on 'Eat Smart' link");
		EatSmartPage eatSmartPage = dashboardPage.clickEatSmartLink();

		selenium.logComment("Clicking on 'Shakeology and Supplements' link");
		ShakeologyAndSupplementsPage shakeologyAndSupplementsPage = eatSmartPage.goToShakeologyAndSupplementsPage();
		
		selenium.logComment("Verifying the number of stars displayed.");
		assertTrue("All 5 stars are not displayed", shakeologyAndSupplementsPage.getStarsCount()==5, selenium );

		selenium.logComment("Verifying that ratings and reviews are displayed.");
		assertTrue("Expected rating out of 5 is not displayed.", selenium.isElementPresent("css=span[class='rating-number']"), selenium);
		assertTrue("Expected number of reviews is not displayed.", selenium.isElementPresent("css=span[class='rating-link']>a"), selenium);
		
		String number_of_reviews;
		number_of_reviews = (selenium.getText("css=span[class='rating-link']>a"));
		number_of_reviews = number_of_reviews.replace("reviews", " ").trim();
			
		//System.out.println("number of Reviews: " + Integer.parseInt(number_of_reviews));
		selenium.click("css=span[class='rating-link']>a");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		
		assertTrue("Page header is missing.", selenium.isElementPresent("css=div#top_area>h2"), selenium);
		assertTrue("Page image is missing.", selenium.isElementPresent("css=div#left_area>img"), selenium);
		assertTrue("5 Stars image is missing.", selenium.isElementPresent("css=div.BVRRRatingSummaryStyle2 div.BVRROverallRatingContainer div.BVRRRatingContainerStar div[class='BVRRRatingEntry BVRROdd'] div[class='BVRRRating BVRRRatingNormal BVRRRatingOverall'] div.BVRRRatingNormalImage>img"), selenium);
		assertTrue("Ratings info icon is missing.", selenium.isElementPresent("css=div[class='BVRRRatingsHistogramButtonScript']"), selenium);
		//assertTrue("'Read all Reviews' link is missing.", selenium.isTextPresent("Real all " +number_of_reviews+ "reviews"), selenium);
		assertTrue("'Write a review' link is missing.", selenium.isElementPresent("css=div[class='BVRRRatingSummaryLink BVRRRatingSummaryLinkWrite']"), selenium);
		
		assertTrue("'Buy Shakeology now!' label is missing.", selenium.isElementPresent("css=div#right_area>h4"), selenium);
		assertTrue("Price label is missing.", selenium.isElementPresent("css=p.price"), selenium);		
		assertTrue("Discount label is missing.", selenium.isElementPresent("css=p.note"), selenium);
		assertTrue("'Buy Now' button is missing.", selenium.isElementPresent("css=a.btn-blue>span"), selenium);
		
		assertTrue("Expected Text is missing.", selenium.isElementPresent("css=div#left_area>h5"), selenium);
		assertTrue("Expected Text is missing.", selenium.isTextPresent("Want a simple way to transform your health? All it takes is one glass of Shakeology® a day. This ultra-premium nutritional health shake contains the world's most powerful superfoods. It's the perfect combination of antioxidants, phytonutrients, enzymes, prebiotics, protein and many rare ingredients – including adaptogens, camu-camu, and sacha inchi – giving you the essential nutrients you can't get from an ordinary diet."), selenium);
		assertTrue("Expected Text is missing.", selenium.isTextPresent("Replace one meal a day with Chocolate or Greenberry Shakeology to increase your energy, reduce cravings, lose weight, improve digestion and regularity, and transform your health.* It tastes great, and it's just 140 calories."), selenium);
		
		assertTrue("Video image is missing.", selenium.isElementPresent("css=div#video_area>p>a"), selenium);
		assertTrue("Video link is missing.", selenium.isElementPresent("css=p#video_link"), selenium);
		
		assertTrue("'What you Get' header is missing.", selenium.isElementPresent("css=div[class='grey_header_left grey_border_header_left']"), selenium);
		assertTrue("'View All Features' link is missing.", selenium.isElementPresent("css=div[class='grey_header_right grey_border_header_right'] p"), selenium);
		assertTrue("'Choose your pack' section is missing.", selenium.isElementPresent("css=div[class='grey_border_bottom']"), selenium);
		assertTrue("'Learn More' link is missing.", selenium.isElementPresent("css=p.hide>a"), selenium);
		
		selenium.logComment("Verifying the elements in 'Summary of Customer Ratings & Reviews' section.");
		assertTrue("'Summary of Customer Ratings & Reviews' is missing.", selenium.isElementPresent("css=span[class='BVRRTitle BVRRQuickTakeTitle']"), selenium);
		assertTrue("Image containing 5 stars is missing.", selenium.isElementPresent("css=div[class='BVRRRatingSummary BVRRPrimaryRatingSummary'] div[class='BVRRRatingSummaryStyle2'] div[class='BVRROverallRatingContainer'] div[class='BVRRRatingContainerStar'] div[class='BVRRRatingEntry BVRROdd'] div[class='BVRRRating BVRRRatingNormal BVRRRatingOverall'] div.BVRRRatingNormalImage>img"), selenium);
		assertTrue("Ratings Breakdown icon is missing.", selenium.isElementPresent("css=div[class='BVRRRatingSummary BVRRPrimaryRatingSummary'] div.BVRRRatingSummaryStyle2 div.BVRRRatingsHistogramButton div.BVRRRatingsHistogramButtonScript img.BVRRRatingsHistogramButtonImage"), selenium);
		
		assertTrue("Expected Text 'Quality' is not displayed.", selenium.isTextPresent("Quality"), selenium);
		assertTrue("Expected Quality Rating image is not displayed.", selenium.isElementPresent("css=div.BVRRSecondaryRatingsContainer div[class='BVRRRatingContainerStar'] div[class='BVRRRatingEntry BVRROdd'] div[class='BVRRRating BVRRRatingNormal BVRRRatingQuality'] div.BVRRRatingNormalImage>img"), selenium);
		assertTrue("Expected Text 'Effectiveness' is not displayed.", selenium.isTextPresent("Effectiveness"), selenium);		
		assertTrue("Expected Text 'Taste' is not displayed.", selenium.isTextPresent("Taste"), selenium);
		assertTrue("Expected Text 'Overall Satisfaction' is not displayed.", selenium.isTextPresent("Overall Satisfaction"), selenium);
		
		selenium.logComment("Verifying the number of reviews displayed is more than one.");
		assertTrue("No reviews are displayed.", shakeologyAndSupplementsPage.getReviewCount()>=1, selenium );

		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}