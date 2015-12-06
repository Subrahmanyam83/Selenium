package com.tbb.pages.coach;

//import static com.tbb.framework.BaseTest.assertTrue;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.CoachDestinations;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Coach Destinations Page.
 * @author Gaurav
 */
public class CoachDestinationsPage  extends BaseTest {
	

		
	protected LoggingSelenium selenium;

	
	/**
	 * This is constructor for this class. It validates that the user is on Coach Destinations Page.
	 * @param	selenium
	 */
	public CoachDestinationsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Coach Destinations Page");
		this.selenium = selenium;
		assertTrue("This is not Coach Destinations Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Home - Coach Destinations"), selenium);
	}	
	
	/**
	 * Verifies UI of Page
	 */
	public void verifyUI() {
		assertTrue("'Contact Us' link not displyed in header navigation", selenium.isElementPresent(CoachDestinations.HEADER_CONTACT_US_LINK), selenium);
		assertTrue("'Not a Coach?' link not displyed in header navigation", selenium.isElementPresent(CoachDestinations.HEADER_NOT_A_COACH_LINK), selenium);
		assertTrue("'Spanish Language Option' not displyed in header navigation", selenium.isElementPresent(CoachDestinations.HEADER_SPANISH_LANGUAGE_LINK), selenium);
		
		assertTrue("Banner Heading not displayed", selenium.isElementPresent(CoachDestinations.BANNER_HEADING), selenium);
		assertTrue("Link 'Home' not displayed", selenium.isElementPresent(CoachDestinations.HOME_LINK), selenium);
		assertTrue("Link 'How to Qualify' not displayed", selenium.isElementPresent(CoachDestinations.HOW_TO_QUALIFY_LINK), selenium);
		assertTrue("Link 'Rewards' not displayed", selenium.isElementPresent(CoachDestinations.REWARDS_LINK), selenium);
		assertTrue("Link 'Testimonials' not displayed", selenium.isElementPresent(CoachDestinations.TESTIMONIALS_LINK), selenium);
		assertTrue("Link 'Travel Info' not displayed", selenium.isElementPresent(CoachDestinations.TRAVEL_INFO_LINK), selenium);
		if(!ConfigFileReader.getConfigItemValue("browser").equals("*iexploreproxy"))
		assertTrue("Link 'Facebook Like' not displayed", selenium.isElementPresent(CoachDestinations.FACEBOOK_LIKE_LINK), selenium);
				
		assertTrue("Number of Coach Destinations not correct", getDestinationsCountOnHomePage() == 2, selenium);
		assertTrue("Link 'How to Qualify' not displayed", selenium.isElementPresent(CoachDestinations.DESTINATION_ATLANTIS_HOW_TO_QUALIFY_LINK), selenium);
		assertTrue("Link 'Discover Atlantis' not displayed", selenium.isElementPresent(CoachDestinations.DESTINATION_ATLANTIS_DISCOVER_ATLANTIS_LINK), selenium);
		
		assertTrue("Photo Gallery not displayed", selenium.isElementPresent(CoachDestinations.PHOTO_GALLERY), selenium);
		assertTrue("'Last Photo' link not displayed", selenium.isElementPresent(CoachDestinations.PHOTO_GALLERY_LAST_PHOTO_LINK), selenium);
		assertTrue("'Next Photo' link not displayed", selenium.isElementPresent(CoachDestinations.PHOTO_GALLERY_NEXT_PHOTO_LINK), selenium);
		
		assertTrue("Feature Video not displayed", selenium.isElementPresent(CoachDestinations.FEATURE_1_VIDEO), selenium);
		assertTrue("Feature ''2011 Trip Qualifiers' not displayed", selenium.isElementPresent(CoachDestinations.FEATURE_2_TRIP_QUALIFIERS), selenium);
		assertTrue("Feature 'What's New' not displayed", selenium.isElementPresent(CoachDestinations.FEATURE_3_WHATS_NEW), selenium);
		
		assertTrue("Number of Members under Success Club Cruise should be more than 0", getSuccessClubCruiseMembersCount() > 0 , selenium);
		assertTrue("Number of Members under Chairman's Adventure Club should be more than 0", getChairmanClubAdventureMembersCount() > 0, selenium);
	
		assertTrue("'Footer Logo' not displayed", selenium.isElementPresent(CoachDestinations.FOOTER_LOGO), selenium);
		assertTrue("'Footer Home' Link not displayed", selenium.isElementPresent(CoachDestinations.FOOTER_HOME_LINK), selenium);
		assertTrue("'Footer How to Qualify' Link not displayed", selenium.isElementPresent(CoachDestinations.FOOTER_HOW_TO_QUALIFY_LINK), selenium);
		assertTrue("'Footer Rewards' Link not displayed", selenium.isElementPresent(CoachDestinations.FOOTER_REWARDS_LINK), selenium);
		assertTrue("'Footer Testimonials' Link not displayed", selenium.isElementPresent(CoachDestinations.FOOTER_TESTIMONIALS_LINK), selenium);
		assertTrue("'Footer Travel Info' Link not displayed", selenium.isElementPresent(CoachDestinations.FOOTER_TRAVEL_INFO_LINK), selenium);
	}

	/**
	 * Returns number of TRIP_QUALIFIERS_SUCCESS_CLUB_CRUISE_MEMBER
	 */
	public int getSuccessClubCruiseMembersCount() {
		return selenium.getXpathCount(CoachDestinations.FEATURE_2_TRIP_QUALIFIERS_SUCCESS_CLUB_CRUISE_MEMBER).intValue();
	}
	
	
	/**
	 * Returns number of TRIP_QUALIFIERS_CHAIRMAN_CLUB_ADVENTURE_MEMBER
	 */
	public int getChairmanClubAdventureMembersCount() {
		return selenium.getXpathCount(CoachDestinations.FEATURE_2_TRIP_QUALIFIERS_CHAIRMAN_CLUB_ADVENTURE_MEMBER).intValue();
	}
	
	
	/**
	 * Return number of Destinations shown on Home page
	 */
	public int getDestinationsCountOnHomePage() {
		return selenium.getXpathCount(CoachDestinations.COACH_DESTINATION_2012).intValue();
	}
	
	/**
	 * Navigates to 'How to Qualify' page
	 */
	public HowToQualifyPage clickHowToQualifyLink() {
		selenium.click(CoachDestinations.HOW_TO_QUALIFY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HowToQualifyPage(selenium);
	}
	
	/**
	 * Navigates to 'Rewards' page
	 */
	public RewardsPage clickRewardsLink() {
		selenium.click(CoachDestinations.REWARDS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new RewardsPage(selenium);
	}
	
	/**
	 * Navigates to 'Testimonials' page
	 */
	public TestimonialsPage clickTestimonialsLink() {
		selenium.click(CoachDestinations.TESTIMONIALS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TestimonialsPage(selenium);
	}
	
	/**
	 * Navigates to 'Travel Info' page
	 */
	public TravelInfoPage clickTravelInfoLink() {
		selenium.click(CoachDestinations.TRAVEL_INFO_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TravelInfoPage(selenium);
	}	
	
}
