package com.tbb.pages.profile;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.GroupsTab;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
import com.tbb.pages.WorkoutGroupsPage;
/**
 * 
 * Page Object encapsulates the Groups Page
 * @author Jaya
 */
public class GroupsPage  extends BaseTest  implements GroupsTab {

	/**
	 * Validates the user is on Groups Page.
	 * @param 	selenium
	 */
	public GroupsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Groups Page Class");
		assertTrue("This is not Edit Profile: Groups Page, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Edit Profile: Groups"), selenium);
	}

	/**
	 * The method viewWorkoutGroupsLink() allows user to navigate to Workout Groups Page 
	 * @return WorkoutGroupsPage
	 */	
	public WorkoutGroupsPage viewWorkoutGroupsLink(){
		selenium.click(WORKOUT_GROUPS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutGroupsPage(selenium);
	}

	/**
	 * The method leaveSelectedGroups() allows user to remove the selected groups from his profile.  
	 */	
	public void leaveSelectedGroups() {
		selenium.click(LEAVE_SELECTED_GROUPS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * The method resetSelectedGroups() allows user to reset the page check boxes. 
	 */	
	public void resetSelectedGroups() {
		selenium.click(RESET);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	/**
	 * Signs out the user from the web site.   
	 */
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);
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