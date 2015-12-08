package com.tbb.pages.others;
import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.HelpFAQ;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Club User Guide page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class ClubUserGuidePage  extends BaseTest {

	private LoggingSelenium selenium;

	/**
	 * Constructor for Club User Guide Page. Verified whether we are on Club User Guide Page
	 * @param selenium
	 */
	public ClubUserGuidePage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Club User Guide' Page Class");
		assertTrue(
				"This is not 'Club User Guide' Page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Team Beachbody Club User's Guide"), selenium);
	}
	
	
	/**
	 * Verifies UI of page
	 */
	public void verifyUI() {
		assertTrue("'Join Team Beachbody' not displayed", selenium.isTextPresent("Join Team Beachbody"), selenium);
		assertTrue("'Create and Edit Your Profile' not displayed", selenium.isTextPresent("Create and Edit Your Profile"), selenium);
		assertTrue("'Get Fit' not displayed", selenium.isTextPresent("Get Fit"), selenium);
		assertTrue("'Eat Right and Lose Weight ' not displayed", selenium.isTextPresent("Eat Right and Lose Weight "), selenium);
		assertTrue("'Get Community Support' not displayed", selenium.isTextPresent("Get Community Support"), selenium);
		assertTrue("'Get Information and Advice' not displayed", selenium.isTextPresent("Get Information and Advice"), selenium);
	
		
		assertTrue("'Compare Products' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div > div.title > span:contains(Compare Products)"), selenium);
		assertTrue("'Contests' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div > div.title > span:contains(Contests)"), selenium);
		assertTrue("'Find Buddies' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div > div.title > span:contains(Find Buddies)"), selenium);
		assertTrue("'Message Boards' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div > div.title > span:contains(Message Boards)"), selenium);
		assertTrue("'Nutrition Tips' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div > div.title > span:contains(Nutrition Tips)"), selenium);

		
	}

	/**
	 * Navigates to Super Gym Tutorial page
	 * @return
	 */
	public SuperGymTutorialPage clickSuperGymTutorialLink() {
		selenium.click(HelpFAQ.SUPER_GYM_TUTORIAL_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new SuperGymTutorialPage(selenium);
	}
}
