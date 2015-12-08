package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.ContestFAQ;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
//import static com.tbb.framework.BaseTest.assertTrue;
/**
 * 
 * Page Object encapsulates the Contest FAQ Page
 * @author Jaya
 */
public class ContestFAQPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Contest FAQ Page.
	 * @param	selenium
	 */
	public ContestFAQPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Contest FAQ Page");
		this.selenium = selenium;
		assertTrue("This is not Contest FAQ Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Contest FAQ"), selenium);
	}
	
	/**
	 * Click on Connect link in the top menu bar. Navigates user to Connect page. 
	 * @return Connect Page
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ConnectPage(selenium);
	}
	
	/**
	 * Returns the number of FAQ Links displayed on the page. 
	 * @return int
	 */
	public int getFAQLinksCount() {
		return selenium.getXpathCount(ContestFAQ.ALL_FAQ_LINKS).intValue();
	}
	
	/**
	 * Returns the number of Back To Top Links displayed on the page. 
	 * @return int
	 */
	public int getBackToTopLinksCount() {
		return selenium.getXpathCount(ContestFAQ.ALL_BACK_TO_TOP_LINKS).intValue();
	}

	/**
	 * Returns the number of FAQ question Headers displayed on the page. 
	 * @return int
	 */
	public int getFAQHeadersCount() {
		return selenium.getXpathCount(ContestFAQ.ALL_FAQ_HEADERS).intValue();
	}
}