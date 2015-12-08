package com.tbb.pages;

import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
//import static com.tbb.framework.BaseTest.assertTrue;
/**
 * 
 * Page Object encapsulates the Club Only Page
 * @author Jaya
 */
public class ClubOnlyPage extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Club Only Page.
	 * @param	selenium
	 */
	public ClubOnlyPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Club Only Page");
		this.selenium = selenium;
		assertTrue("This is not Club Only Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Club Only"), selenium);
	}
}