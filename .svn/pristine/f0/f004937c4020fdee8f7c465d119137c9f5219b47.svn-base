package com.tbb.pages.coach;

import java.util.ArrayList;

import com.tbb.constants.UIRepository.CoachOnlineOffice;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Coach Online Office Page.
 * @author Gaurav
 */
public class CoachOnlineOfficePage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Coach Online Office Page.
	 * @param	selenium
	 */
	public CoachOnlineOfficePage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Coach Online Office Page");
		this.selenium = selenium;
		assertTrue("This is not Coach Online Office Page, current page" + selenium.getLocation(), selenium.getTitle().equals("Main Page"), selenium);
	}

	
	/**
	 * Verified UI of page
	 */
	public void verifyUI() {
		assertTrue("Main Logo not displayed", selenium.isElementPresent(CoachOnlineOffice.BEACHBODY_MAIN_LOGO), selenium);
		assertTrue("Return to Team Beachbody button not displayed", selenium.isElementPresent(CoachOnlineOffice.RETURN_TO_TEAM_BEACHBODY_BUTTON), selenium);
		assertTrue("Logout button not displayed", selenium.isElementPresent(CoachOnlineOffice.LOGOUT_BUTTON), selenium);
		assertTrue("Current Date not displayed", selenium.isElementPresent(CoachOnlineOffice.CURRENT_DATE), selenium);
		assertTrue("Link 'Home' not displayed", selenium.isElementPresent(CoachOnlineOffice.HEADER_HOME_LINK), selenium);
		assertTrue("Link 'GETTING_STARTED' not displayed", selenium.isElementPresent(CoachOnlineOffice.HEADER_GETTING_STARTED_LINK), selenium);
		assertTrue("Link 'MY_WEBSITES' not displayed", selenium.isElementPresent(CoachOnlineOffice.HEADER_MY_WEBSITES_LINK), selenium);
		assertTrue("Link 'SALES_MARKETING' not displayed", selenium.isElementPresent(CoachOnlineOffice.HEADER_SALES_MARKETING_LINK), selenium);
		assertTrue("Link 'MY_BUSINESS' not displayed", selenium.isElementPresent(CoachOnlineOffice.HEADER_MY_BUSINESS), selenium);
		assertTrue("Link 'MY_DESK' not displayed", selenium.isElementPresent(CoachOnlineOffice.HEADER_MY_DESK), selenium);
		assertTrue("Link 'NEWS_TRAINING' not displayed", selenium.isElementPresent(CoachOnlineOffice.HEADER_NEWS_TRAINING), selenium);
		assertTrue("Link 'VIDEO_LIBRARY' not displayed", selenium.isElementPresent(CoachOnlineOffice.HEADER_VIDEO_LIBRARY), selenium);
		assertTrue("VOLUME_DETAILS_BUTTON not displayed", selenium.isElementPresent(CoachOnlineOffice.VOLUME_DETAILS_BUTTON), selenium);
		
		assertTrue("ALL_EVENTS_BUTTON not displayed", selenium.isElementPresent(CoachOnlineOffice.ALL_EVENTS_BUTTON), selenium);
		assertTrue("VOLUME_GRAPH not displayed", selenium.isElementPresent(CoachOnlineOffice.VOLUME_GRAPH), selenium);
		assertTrue("ACADEMY_WIDGET not displayed", selenium.isElementPresent(CoachOnlineOffice.ACADEMY_WIDGET), selenium);
		//assertTrue("NEW_COACH_WELCOME_LINK not displayed", selenium.isElementPresent(CoachOnlineOffice.NEW_COACH_WELCOME_LINK), selenium);
		
		assertTrue("COACH_ACADEMY_LINK not displayed", selenium.isElementPresent(CoachOnlineOffice.COACH_ACADEMY_LINK), selenium);
	
	}

	/**
	 * Retrieves personal information of a coach and returns an array list of the information.
	 * @return Array List of Coach Personal Information
	 */
	public ArrayList<String> getCoachPersonalInfo() {
		ArrayList<String> coachPersonalInfo = new ArrayList<String>();
		coachPersonalInfo.add(selenium.getText(CoachOnlineOffice.PERSONAL_INFO_CURRENT_RANK));
		coachPersonalInfo.add(selenium.getText(CoachOnlineOffice.PERSONAL_INFO_QUALIFICATION_STATUS));
		coachPersonalInfo.add(selenium.getText(CoachOnlineOffice.PERSONAL_INFO_STATUS));
		coachPersonalInfo.add(selenium.getText(CoachOnlineOffice.PERSONAL_INFO_UPLINE_SPONSER));
		coachPersonalInfo.add(selenium.getText(CoachOnlineOffice.PERSONAL_INFO_UPLINE_DIAMOND_COACH));
		coachPersonalInfo.add(selenium.getText(CoachOnlineOffice.PERSONAL_INFO_UPLINE_STAR_DIAMOND_COACH));
	 
		return coachPersonalInfo;
	}
	
	/**
	 * Retrieves the details of volume of coach online office team amount.
	 * @return Array list of volume of Coach online office team amount
	 */
	public ArrayList<String> getCoachVolumeDetails() {
		ArrayList<String> coachVolumeDetails = new ArrayList<String>();
		coachVolumeDetails.add(selenium.getText(CoachOnlineOffice.VOLUME_TEAM_AMOUNT));
		coachVolumeDetails.add(selenium.getText(CoachOnlineOffice.VOLUME_LEFT_LEG_TEAM_AMOUNT));
		coachVolumeDetails.add(selenium.getText(CoachOnlineOffice.VOLUME_RIGHT_LEG_TEAM_AMOUNT));
		
		return coachVolumeDetails;
	}
	
	/**
	 * Returns the number of Coach Alerts displayed on Coach online office page. 
	 * @return Number of Alerts 
	 */
	public int getCoachAlertsCount() {
		return selenium.getXpathCount(CoachOnlineOffice.COACH_ALERT).intValue();
	}
	
	/**
	 * Returns the Coach Alerts displayed on Coach Online Office. 
	 * @return Coach Alerts
	 */
	public ArrayList<String> getCoachAlerts() {
		ArrayList<String> coachAlerts = new ArrayList<String>();
		int alertsCount = getCoachAlertsCount();
		for (int i =1; i<=alertsCount; i++) {
			coachAlerts.add(selenium.getText(CoachOnlineOffice.COACH_ALERT + "[" + i + "]"));
		}
		return coachAlerts;
	}
	
	/**
	 * Returns the number of event tasks displayed on Coach Onliine Office Page. 
	 * @return Number of Events or Tasks
	 */
	public int getCoachEventsTasksCount() {
		return selenium.getXpathCount(CoachOnlineOffice.EVENT_TASK).intValue();
	}
	
	/**
	 * Returns the Coach Event Tasks displayed on Coach Online Office.
	 * @return Coach Event Tasks
	 */
	public ArrayList<String> getCoachEventsTasks() {
		ArrayList<String> coachEventsTasks = new ArrayList<String>();
		int eventsTasksCount = getCoachEventsTasksCount();
		for (int i =1; i<=eventsTasksCount; i++) {
			coachEventsTasks.add(selenium.getText(CoachOnlineOffice.EVENT_TASK + "[" + i + "]"));
		}
		return coachEventsTasks;
	}

	/**
	 * Returns the number of breaking news displayed on Coach Online Office Page. 
	 * @return Number of Breaking News
	 */
	public int getBreakingNewsCount() {
		return selenium.getXpathCount(CoachOnlineOffice.BREAKING_COACH_NEWS).intValue();
	}		
}
