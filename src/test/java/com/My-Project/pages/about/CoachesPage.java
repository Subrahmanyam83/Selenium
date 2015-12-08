package com.tbb.pages.about;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.AboutCoaches;
import com.tbb.constants.UIRepository.AboutJoinUpgrade;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.connect.MemberGallerySearchResultsPage;

/**
 * 
 * Page Object encapsulates the Coaches Page.
 * @author Jaya
 */

public class CoachesPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Coaches Page.
	 * @param	selenium
	 */
	public CoachesPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Coaches Page.");
		this.selenium = selenium;
		assertTrue("This is not Coaches Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - About: Coaches"), selenium);
	}
	
	/**
	 * Clicks on See Entire Gallery Link. Navigates user to Member Gallery Page. 
	 * @return Member Gallery Page
	 */
	public MemberGallerySearchResultsPage clickSeeEntireGalleryLink() {
		selenium.click(AboutCoaches.SEE_ENTIRE_GALLERY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MemberGallerySearchResultsPage(selenium);
	}
	
	/**
	 * Returns the number of Coaches pics displayed on the page. 
	 * @return int
	 */
	public int getAllInspiringCoachesPicsCount() {
		return selenium.getXpathCount(AboutCoaches.ALL_INSPIRING_COACHES_PHOTOS).intValue();
	}

	/**
	 * Returns the number of 'What are Team Beachbody Coaches?' section pics displayed on the page. 
	 * @return int
	 */
	public int getAllTBBCoachesPicsCount() {
		return selenium.getXpathCount(AboutCoaches.ALL_WHAT_ARE_TBB_COACHES_PHOTOS).intValue();
	}

	/**
	 * Returns the number of 'What are Team Beachbody Coaches?' section text displayed on the page. 
	 * @return int
	 */
	public int getAllTBBCoachesTextCount() {
		return selenium.getXpathCount(AboutCoaches.ALL_WHAT_ARE_TBB_COACHES_TEXT).intValue();
	}

	/**
	 * Clicks on About link in the top menu bar. Navigates to About Page. 
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click(AboutJoinUpgrade.MENU_BAR_ABOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}
}