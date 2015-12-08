package com.tbb.pages.profile;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.constants.UIRepository.MyProfile;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.ClubOnlyPage;
import com.tbb.pages.connect.ConnectPage;
import com.tbb.pages.connect.NotificationsPage;
/**
 * 
 * Page Object encapsulates the My Profile Page
 * @author Xebia
 */
public class MyProfilePage  extends BaseTest  implements  MyProfile {

	/**
	 * Validates the user is on My Profile Page.
	 * @param	selenium
	 * @throws  IllegalStateException if the user is on a different page than My Profile Page.
	 */
	public MyProfilePage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of MyProfilePage Class");
		assertTrue("This is not Team Beachbody - My Profile Page, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - My Profile"), selenium);
	}
	
	/**
	 * Navigates user to Edit Profile Photo Page 
	 * @return PhotosPage
	 */	
	public PhotosPage editMyProfilePhoto(){
		selenium.click(EDIT_PHOTOS);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new PhotosPage(selenium);
	}
	
	/**
	 * Navigates user to Edit Privacy Settings Page 
	 * @return PrivacyPage
	 */	
	public PrivacyPage editPrivacySettings(){
		selenium.click(EDIT_PRIVACY_SETTINGS);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new PrivacyPage(selenium);
	}
	
	/**
	 * Navigates user to Notifications Page 
	 * @return NotificationsPage
	 */	
	public NotificationsPage viewNewBuddyRequests(){
		selenium.click(VIEW_NOTIFICATIONS);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new NotificationsPage(selenium);
	}
	
	/**
	 * Navigates user to EditProfile Page 
	 * @return EditProfilePage
	 */	
	public EditProfilePage finishProfile(){
		selenium.click(EDIT_PROFILE);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new EditProfilePage(selenium);
	}
	
	/**
	 * Navigates user to Photos Page 
	 * @return PhotosPage
	 */	
	public PhotosPage addPhotosNow(){
		selenium.click(ADD_PHOTOS_NOW);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new PhotosPage(selenium);
	}
	
	/**
	 * Navigates user to Edit Buddies Page 
	 * @return BuddiesPage
	 */	
	public BuddiesPage editBuddies(){
		selenium.click(EDIT_BUDDIES);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new BuddiesPage(selenium);
	}
	
	/**
	 * Navigates user to Edit Basic Information Page 
	 * @return BasicInformationPage
	 */	
	public BasicInformationPage clickEditBasicInformation(){
		selenium.click(EDIT_BASIC_INFORMATION);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return new BasicInformationPage(selenium);
	}
	
	/**
	 * Navigates user to Edit Basic Information Page 
	 * @return BasicInformationPage
	 */	
	public BasicInformationPage startMyPersonalBio(){
		selenium.click(START_PERSONAL_BIO);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new BasicInformationPage(selenium);
	}
	
	/**
	 * Navigates user to Progress And Goals Page 
	 * @return ProgressAndGoalsPage
	 */	
	public ProgressAndGoalsPage editProgressAndGoals(){
		selenium.click(EDIT_PROGRESS_AND_GOALS);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ProgressAndGoalsPage(selenium);
	}
	
	/**
	 * Navigates user to Programs Page 
	 * @return ProgramsPage
	 */	
	public ProgramsPage clickEditPrograms(){
		selenium.click(EDIT_PROGRAMS);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ProgramsPage(selenium);
	}

	/**
	 * Navigates user to Connect Page. 
	 * @return ConnectPage
	 */
	public ConnectPage clickConnectLink() {
		selenium.click("css=a:contains(Connect)");	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ConnectPage(selenium);
	}
	
	/**
	 * Navigates Free user to Club Members Only Page 
	 * @return ClubMembersOnlyPage
	 */	
	public ClubOnlyPage addNewBlogEntryAsFreeUser(){
		selenium.click(ADD_NEW_BLOG_ENTRY);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ClubOnlyPage(selenium);
	}
	
	/**
	 * Navigates Club user to BlogPage 
	 * @return BlogPage
	 */	
	public BlogPage addNewBlogEntryAsClubUser(){
		selenium.click(ADD_NEW_BLOG_ENTRY);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new BlogPage(selenium);
	}
	
	/**
	 * Navigates Free user to Club Members Only Page 
	 * @return ClubMembersOnlyPage
	 */	
	public ClubOnlyPage startYourBlogAsFreeUser(){
		selenium.click(START_YOUR_BLOG);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ClubOnlyPage(selenium);
	}
	
	/**
	 * Navigates Club user to Blog Page 
	 * @return BlogPage
	 */	
	public BlogPage startYourBlogAsClubUser(){
		selenium.click(START_YOUR_BLOG);
	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new BlogPage(selenium);
	}
	
	/**
	 * Navigates user to Edit Profile Page
	 * @return	EditProfilePage
	 */	
	public EditProfilePage clickLRMProfileLink() {
		selenium.click(LRMProfile.LRM_PROFILE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EditProfilePage(selenium);
	}
}
