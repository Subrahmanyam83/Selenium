package com.tbb.pages.profile;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.EditProfile;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Edit Profile Page
 * @author Jaya
 */
public class EditProfilePage  extends BaseTest  implements EditProfile{

	/**
	 * This is constructor for this class. It validates that the user is on Edit Profile Page.
	 * @param	selenium
	 */
	public EditProfilePage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Edit Profile Page");
		this.selenium = selenium;
		assertTrue("This is not Edit Profile Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Profile Overview"), selenium);
	}

	/**
	 * The method clickBasicInformation() allows user navigate to Basic Information Page 
	 * @return BasicInformationPage
	 */	
	public BasicInformationPage clickBasicInformation(){
		selenium.click(EDIT_BASIC_INFORMATION_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new BasicInformationPage(selenium);
	}

	/**
	 * The method clickProgressAndGoals() navigates user to Progress and Goals Page.
	 * @return ProgressAndGoalsPage
	 */	
	public ProgressAndGoalsPage clickProgressAndGoals(){
		selenium.click(EDIT_PROGRESS_AND_GOALS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProgressAndGoalsPage(selenium);
	}

	/**
	 * The method clickFitnessPrograms() navigates user to Programs Page.
	 * @return ProgramsPage
	 */	
	public ProgramsPage clickFitnessPrograms(){
		selenium.click(EDIT_FITNESS_PROGRAMS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProgramsPage(selenium);
	}

		/**
	 * Navigates user to Photos Page 
	 * @return PhotosPage
	 */	
  	public PhotosPage clickPhotos(){
  		selenium.click(EDIT_PHOTOS);
  	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new PhotosPage(selenium);
  	}

	  /**
	  * Navigates user to Buddies Page 
	  * @return BuddiesPage
	  */	
  	public BuddiesPage clickBuddies(){
  		selenium.click(EDIT_BUDDIES);
  	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new BuddiesPage(selenium);
  	}

	/**
	 * The method clickGroups() navigates user to Groups Page 
	 * @return GroupsPage
	 */	
	public GroupsPage clickGroups(){
		selenium.click(EDIT_GROUPS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new GroupsPage(selenium);
	}

	  	/**
	 * Navigates user to Blog Page 
	 * @return BlogPage
	 */	
  	public BlogPage clickBlog(){
  		selenium.click(EDIT_BLOG);
  	    selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new BlogPage(selenium);
  	}

	/**
	 * The method clickPrivacy() navigates user to Privacy Page 
	 * @return PrivacyPage
	 */	
	public PrivacyPage clickPrivacy(){
		selenium.click(EDIT_PRIVACY);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new PrivacyPage(selenium);
	}

	/**
	 * Returns the number of icons displayed on the page before every edit profile topic. 
	 * @return int
	 */
	public int getIconCount() {
		return selenium.getXpathCount(ICON_XPATH).intValue();
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
