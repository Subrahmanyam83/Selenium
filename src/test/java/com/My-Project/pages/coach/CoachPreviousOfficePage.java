package com.tbb.pages.coach;

import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Coach Previous Office Page.
 * @author Gaurav
 */
public class CoachPreviousOfficePage  extends BaseTest  {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Coach Previous Office Page.
	 * @param	selenium
	 */
	public CoachPreviousOfficePage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Coach Previous Office Page");
		this.selenium = selenium;
		assertTrue("This is not Coach Previous Office Page, current page" + selenium.getLocation(), selenium.getTitle().equals("My Extranet"), selenium);
	}
	
}
