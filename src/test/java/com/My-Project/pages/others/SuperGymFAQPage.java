package com.tbb.pages.others;
import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.HelpFAQ;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * This page object represents Super Gym FAQ page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class SuperGymFAQPage  extends BaseTest {

	private LoggingSelenium selenium;

	/**
	 * Constructor for SuperGym FAQ Page. Verified whether we are on SuperGym FAQ Page
	 * @param selenium
	 */
	public SuperGymFAQPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'SuperGym FAQ Page' Class");
		assertTrue(
				"This is not 'SuperGym FAQ' Page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - SuperGym FAQ"), selenium);
	}
	
	
	/**
	 * Verifies UI of page
	 */
	public void verifyUI() {
		assertTrue("'WOWY SuperGym FAQ' not displayed", selenium.isTextPresent("WOWY SuperGym FAQ"), selenium);
		assertTrue("Number of FAQs not correct", getFAQsCount() == 26, selenium);
		
		assertTrue("'Compare Products' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div > div.title > span:contains(Compare Products)"), selenium);
		assertTrue("'Contests' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div > div > div.title > span:contains(Contests)"), selenium);
		assertTrue("'Latest Daily Winner' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div >  div > div.title > span:contains(Latest Daily Winner)"), selenium);
		assertTrue("'Find Buddies' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div >  div >  div.title > span:contains(Find Buddies)"), selenium);
		assertTrue("'Message Boards' portlet not displayed", selenium.isElementPresent("css=div#layout-column_column-5 > div > div > div > div >  div > div.title > span:contains(Message Boards)"), selenium);
	
	}

	/**
	 * Returns number of FAQs displayed on page
	 * @return
	 */
	private int getFAQsCount() {
		return selenium.getXpathCount("//div[@class='text']/ul[@class='list-no-style']/li").intValue();
	}


	/**
	 * Navigates to Contest FAQ Page
	 * @return
	 */
	public ContestFAQPage clickContestFAQLink() {
		selenium.click(HelpFAQ.CONTEST_FAQ_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ContestFAQPage(selenium);
	}
	
}
