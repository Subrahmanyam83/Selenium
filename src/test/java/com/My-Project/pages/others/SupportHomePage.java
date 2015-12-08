package com.tbb.pages.others;
import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.HelpFAQ;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Support Home page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class SupportHomePage  extends BaseTest {
	
	private LoggingSelenium selenium;

	/**
	 * Constructor for Support Home Page. Verified whether we are on Support Home Page
	 * @param selenium
	 */
	public SupportHomePage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Support Home' Page Class");
		assertTrue(
				"This is not 'Support Home' Page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Support Home Page"), selenium);
	}
	
	
	/**
	 * Verifies UI of page
	 */
	public void verifyUI() {
		assertTrue("Quick Answers not displayed", selenium.isTextPresent("Quick Answers"), selenium);
		assertTrue("Find Answers not displayed", selenium.isTextPresent("Find Answers"), selenium);
		assertTrue("Ask a question not displayed", selenium.isTextPresent("Ask a Question"), selenium);
		assertTrue("Message Board portlet not displayed", selenium.isElementPresent("css=div#right_col > div.callout_title > h2:contains(Message Boards)"), selenium);
		assertTrue("Find Buddies portlet not displayed", selenium.isElementPresent("css=div#right_col > div.callout_title > h2:contains(Find Buddies)"), selenium);
		
	}

	/**
	 * Navigates to Club User Guide Page
	 * @return
	 */
	public ClubUserGuidePage clickClubUserGuideLink() {
		selenium.click(HelpFAQ.CLUB_USER_GUIDE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ClubUserGuidePage(selenium);
	}

	

}
