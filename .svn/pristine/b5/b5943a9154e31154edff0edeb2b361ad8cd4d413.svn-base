package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.MemberGallery;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
import com.tbb.pages.MemberProfilePage;
import com.tbb.pages.about.AboutPage;

/**
 * 
 * Page Object encapsulates the Member Gallery Page
 * @author Gaurav
 */
public class MemberGalleryPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Member Gallery Page.
	 * @param	selenium
	 */
	public MemberGalleryPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Member Gallery Page");
		this.selenium = selenium;
		assertTrue("This is not Member Gallery Page, current page is: " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Member Gallery"), selenium);
	}

	/**
	 * Search Members on TeamBeachBody web site 
	 * @param searchKeyword The member name that needs to be searched.
	 * @return MemberGalleryPage 
	 */	
	public MemberGallerySearchResultsPage searchMembers(String searchKeyword){
		selenium.type(MemberGallery.SEARCH_MEMBERS_TEXTBOX, searchKeyword);
		selenium.click(MemberGallery.SEARCH_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MemberGallerySearchResultsPage(selenium);
	}

	/**
	 * Add Members on TeamBeachBody web site as your buddy 
	 * @param buddyName The member name who has to be added as buddy. 
	 */	
	public MemberProfilePage addBuddy(String buddyName){

		selenium.waitForElementPresent(MemberGallery.VIEW_PROFILE);
		
		if(selenium.isElementPresent("css=span[class='is-buddy pending-true']")==false){
			selenium.waitForElementPresent(MemberGallery.ADD_AS_A_BUDDY);
			selenium.click(MemberGallery.ADD_AS_A_BUDDY);

			selenium.waitForElementPresent(MemberGallery.YES_BUTTON);
			selenium.click(MemberGallery.YES_BUTTON);

			selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		}
		return new MemberProfilePage(selenium);	
	}


	/**
	 * Returns number of Profiles shown 
	 */
	public int ProfileAreasCount() {
		return selenium.getXpathCount(MemberGallery.MEMBER_PROFILE_AREA).intValue();
	}

	/**
	 * Verifies UI of Member Gallery Page
	 */
	public void verifyUI() {
		assertTrue("Member Gallery Image not shown", selenium.waitForElementPresent(MemberGallery.MEMBER_GALLERY_IMAGE), selenium);
		assertTrue("25 Profile Areas not shown", ProfileAreasCount() == 25, selenium);
		assertTrue("Link 'See entire gallery' is not displayed", selenium.waitForElementPresent(MemberGallery.SEE_ENTIRE_GALLERY_LINK), selenium);
		assertTrue("Link 'Reset to all' is not displayed", selenium.waitForElementPresent(MemberGallery.RESET_TO_ALL_LINK), selenium);
	}	

	/**
	 * Clicks on 'Connect' link in the top menu bar. 
	 * @return ConnectPage
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ConnectPage(selenium);
	}

	/**
	 * Clicks on Sign out link to sign user out of the web site. 
	 */
	public HomePage clickSignOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);		
	}

	/**
	 * Clicks on 'About' link in the top menu bar. 
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click(Dashboard.ABOUT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);	
	}


}
