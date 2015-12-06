package com.tbb.pages.profile;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Profile page and exposes the functionality available on that page 
 * @author Jaya
 */
public abstract class ProfilePage implements LRMProfile{

	protected LoggingSelenium selenium;

	/**
	 * Navigates user to Edit Profile Page
	 * @return	EditProfilePage
	 */	
	public EditProfilePage clickLRMProfileLink() {
		selenium.click(LRMProfile.LRM_PROFILE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EditProfilePage(selenium);
	}

	/**
	 * Navigates user to Basic Information Page
	 * @return	BasicInformationPage
	 */	
	public BasicInformationPage clickLRMBasicInformationLink(){
		selenium.click(LRM_BASIC_INFORMATION);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new BasicInformationPage(selenium);
	}

	/**
	 * Navigates user to Progress and Goals Page
	 * @return	ProgressAndGoalsPage
	 */	
	public ProgressAndGoalsPage clickLRMProgressAndGoalsLink(){
		selenium.click(LRM_PROGRESS_AND_GOALS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProgressAndGoalsPage(selenium);
	}

	/**
	 * Navigates user to Programs Page
	 * @return	ProgramsPage
	 */	
	public ProgramsPage clickLRMProgramsLink(){
		selenium.click(LRM_PROGRAMS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProgramsPage(selenium);
	}

	/**
	 * Navigates user to Photos Page
	 * @return	PhotosPage
	 *//*	
	public PhotosPage clickLRMPhotosLink(){
		selenium.click(LRM_PHOTOS);
 	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new PhotosPage(selenium);
	}

	  *//**
	  * Navigates user to Buddies Page
	  * @return	BuddiesPage
	  *//*	
	public BuddiesPage clickLRMBuddiesLink(){
		selenium.click(LRM_BUDDIES);
 	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new BuddiesPage(selenium);
	}*/

	/**
	 * Navigates user to Groups Page
	 * @return	GroupsPage
	 */	
	public GroupsPage clickLRMGroupsLink(){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selenium.click(LRMProfile.LRM_GROUPS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new GroupsPage(selenium);
	}

	/**
	 * Navigates Club user to Blog Page
	 * @return	BlogPage
	 *//*	
	public BlogPage clickLRMBlogLinkAsClubMemberUser(){
		selenium.click(LRM_BLOGS);
 	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new BlogPage(selenium);
	}

	  *//**
	  * Navigates Free user to blog Page Warning: Club Members Only Page
	  * @return	ClubMembersOnlyPage
	  *//*	
	public ClubMembersOnlyPage clickLRMBlogLinkAsFreeUser(){
		selenium.click(LRM_BLOGS);
 	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ClubMembersOnlyPage(selenium);
	}

	   *//**
	   * Navigates Club user to Privacy Page
	   * @return	PrivacyPage
	   *//*	
	public PrivacyPage clickLRMPrivacyLink(){
		selenium.click(LRM_PRIVACY);
 	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new PrivacyPage(selenium);
	}*/
}
