package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.MemberGallery;
import com.tbb.constants.UIRepository.MemberGallerySearch;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
import com.tbb.pages.about.AboutPage;

/**
 * 
 * Page Object encapsulates the Member Gallery Search Results Page
 * @author Jaya
 */
public class MemberGallerySearchResultsPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Member Gallery Search Results Page.
	 * @param	selenium
	 */
	public MemberGallerySearchResultsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Member Gallery Search Results Page");
		this.selenium = selenium;
		assertTrue("This is not Member Gallery Search Results Page, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Member Gallery Search Results"), selenium);
	}
	
	/**
	 * Clicks on 'About' link in the top menu bar. 
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click(MemberGallerySearch.ABOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);	
	}
	
	/**
	 * Add Members on TeamBeachBody web site as your buddy 
	 * @param buddyName The member name who has to be added as buddy. 
	 */	
	public void addBuddy(String buddyName){

		selenium.waitForElementPresent(MemberGallery.VIEW_PROFILE);
		
		if(selenium.isElementPresent("css=span[class='is-buddy pending-true']")==false){
			selenium.waitForElementPresent(MemberGallery.ADD_AS_A_BUDDY);
			selenium.click(MemberGallery.ADD_AS_A_BUDDY);

			selenium.waitForElementPresent(MemberGallery.YES_BUTTON);
			selenium.click(MemberGallery.YES_BUTTON);

			selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		}
	}
	
	/**
	 * Clicks on Member Profile Photo
	 */
	public void clickMemberProfilePic() {
		selenium.click(MemberGallery.MEMBER_PROFILE_PHOTO);
	}

	/**
	 * Clicks on Sign Out link on home page. 
	 * @return
	 */
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HomePage(selenium);
	}
}