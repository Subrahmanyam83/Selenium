package com.tbb.pages;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.WorkoutGroups;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Workout Groups Page
 * @author Jaya
 */   
public class WorkoutGroupsPage  extends BaseTest {
	protected LoggingSelenium selenium;
	/**
	 * Constructor to initialise Workout Groups Page
	 * @param LoggingSelenium
	 */    
	public WorkoutGroupsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of WorkoutGroupsPage Class");
		assertTrue("This is not WorkoutGroups Page, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Get Fit: Supergym: Workout Groups"), selenium);
	}

	/**
	 * Clicks on See all groups link to view all workout groups available on web site. 
	 * @return WorkoutGroupsSearchPage
	 */
	public WorkoutGroupsSearchPage clickSeeAllGroupsLink(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selenium.click(WorkoutGroups.SEE_ALL_GROUPS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutGroupsSearchPage(selenium);
	}
}