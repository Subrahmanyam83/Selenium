package com.tbb.pages;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.WorkoutGroupsSearch;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Workout Groups Page
 * @author Jaya
 */   
public class WorkoutGroupsSearchPage  extends BaseTest {
	protected LoggingSelenium selenium;
	/**
	 * Constructor to initialise Workout Groups Page
	 * @param LoggingSelenium
	 */    
	public WorkoutGroupsSearchPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of WorkoutGroupsPage Class");
		assertTrue("This is not WorkoutGroups Page, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Search for Workout Groups"), selenium);
	}
	
	/**
	 * Clicks on Workout group named Power house.
	 * @return WorkoutGroupDetailPage
	 */
	public WorkoutGroupDetailPage viewPowerhouseGroup() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click(WorkoutGroupsSearch.POWERHOUSE_MORE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutGroupDetailPage(selenium);
	}
	
	/**
	 * Clicks on Workout Group named Brazil Butts.
	 * @return WorkoutGroupDetailPage
	 */
	public WorkoutGroupDetailPage viewBrazilButtsGroup() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click(WorkoutGroupsSearch.BRAZIL_BUTTS_MORE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutGroupDetailPage(selenium);
	}
}