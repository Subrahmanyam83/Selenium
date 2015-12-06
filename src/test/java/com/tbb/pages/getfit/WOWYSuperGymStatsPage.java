package com.tbb.pages.getfit;

import com.tbb.constants.UIRepository.WOWYSuperGymStats;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object encapsulates the WOWY SuperGym Stats page
 * @author Gaurav
 *
 */
public class WOWYSuperGymStatsPage  extends BaseTest {

	private LoggingSelenium selenium;

	/**
	 * Constructor for WowySuperGymPage. Verifies whether we are on Wowy SuperGym Page
	 * 
	 * @param selenium
	 */
	public WOWYSuperGymStatsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'WOWY SuperGym™ Stats' Page Class");
		assertTrue(
				"This is not 'WOWY SuperGym™ Stats' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - WOWY SuperGym™ Stats"), selenium);
	}	
	
	/**
	 * Returns number of 'Recent Top SuperGym Users'
	 */
	public int getRecentTopSuperGymUsersCount() {
		return selenium.getXpathCount(WOWYSuperGymStats.RECENT_TOP_SUPERGYM_USER).intValue();
	}
	
	/**
	 * Returns number of 'Top Workout Groups'
	 */
	public int getTopWorkoutGroupsCount() {
		return selenium.getXpathCount(WOWYSuperGymStats.TOP_WORKOUT_GROUP).intValue();
	}
	
	
	/**
	 * Returns number of 'Team Beachbody Programs'
	 */
	public int getTeamBeachbodyProgramsCount() {
		return selenium.getXpathCount(WOWYSuperGymStats.TEAM_BEACHBODY_PROGRAM).intValue();
	}
}
