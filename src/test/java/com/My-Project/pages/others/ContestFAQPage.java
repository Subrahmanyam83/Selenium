package com.tbb.pages.others;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * This page object represents Contest FAQ page and exposes the functionality available on that page 
 * @author Gaurav
 */
public class ContestFAQPage  extends BaseTest {

	private LoggingSelenium selenium;

	/**
	 * Constructor for Contest FAQ Page. Verified whether we are on Contest FAQ Page
	 * @param selenium
	 */
	public ContestFAQPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Contest FAQ Page' Class");
		assertTrue(
				"This is not 'Contest FAQ' Page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Contest FAQ"), selenium);
	}
	
	
	/**
	 * Verifies UI of page
	 */
	public void verifyUI() {
		assertTrue("'THE BEACHBODY CHALLENGE™ FAQ' not displayed", selenium.isTextPresent("THE BEACHBODY CHALLENGE™ FAQ"), selenium);
		assertTrue("Number of FAQs not correct", getFAQsCount() == 24, selenium);
		
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
	
}
