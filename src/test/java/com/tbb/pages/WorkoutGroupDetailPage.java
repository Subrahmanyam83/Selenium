package com.tbb.pages;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.WorkoutGroupDetail;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.profile.MyProfilePage;
/**
 * 
 * Page Object encapsulates the Workout Groups Page
 * @author Jaya
 */   
public class WorkoutGroupDetailPage  extends BaseTest implements WorkoutGroupDetail{
	protected LoggingSelenium selenium;
	/**
	 * Constructor to initialise Workout Groups Page
	 * @param LoggingSelenium
	 */    
	public WorkoutGroupDetailPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of WorkoutGroupsDetailsPage Class");
		assertTrue("This is not WorkoutGroupsDetailsPage, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Get Fit: Supergym: Workout Group Detail"), selenium);
	}

	/**
	 * Clicks on Join this group to join a workout group
	 */
	public void joinThisGroup(){
		//selenium.waitForElementPresent(JOIN_THIS_GROUP);
		selenium.click(JOIN_THIS_GROUP);
/*		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//selenium.waitForElementPresent(CLOSE);
		selenium.click(CLOSE);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Navigates user to Profile Page.  
	 * @return My Profile Page 
	 */
	public MyProfilePage clickProfile() {
		selenium.click(PROFILE_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MyProfilePage(selenium);
	}
	
	/**
	 * Signs out the user from the web site.  
	 * @return Home Page 
	 */
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);
	}
}