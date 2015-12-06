package com.tbb.pages.coach;

//import static com.tbb.framework.BaseTest.assertTrue;

import java.util.ArrayList;

import com.tbb.constants.UIRepository.CoachFAQ;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Coach FAQ Page.
 * @author Gaurav
 */

public class CoachFAQPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Coach FAQs Page.
	 * @param	selenium
	 */
	public CoachFAQPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Coach FAQs Page");
		this.selenium = selenium;
		assertTrue("This is not Coach FAQs Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Coach: FAQ"), selenium);
	}
	
	/**
	 * Verifies UI of page
	 */
	public void verifyUI(){
		assertTrue("Beachbody Coach FAQ heading not shown", selenium.isElementPresent(CoachFAQ.COACH_FAQ_HEADING), selenium);
		assertTrue("Number of FAQs shown on page is not correct", getFAQsCount()==13, selenium);
		assertTrue("Number of Back to Top links is not correct", getBackToTopLinksCount()==12, selenium);
		assertTrue("Coach sign up link not shown under last FAQ", selenium.isElementPresent(CoachFAQ.CLICK_HERE_LINK), selenium);
	

	}
	
	/**
	 * Returns number of FAQs
	 */
	public int getFAQsCount() {
		return selenium.getXpathCount(CoachFAQ.COACH_FAQ_ITEM).intValue();
	}
	
	/**
	 * Returns number of 'Back to Top' links count
	 */
	public int getBackToTopLinksCount() {
		return selenium.getXpathCount(CoachFAQ.BACK_TO_TOP_LINK).intValue();
	}	
	
	/**
	 * Returns count of RRMs
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(CoachFAQ.RRM_SECTION).intValue();
	}
	
	/** 
	 * Returns title of RRMs
	 */
	public ArrayList<String> getRRMsTitles() {
		ArrayList<String> rRMsTitles = new ArrayList<String>();
		int rRMsTitlesCount = getRRMsCount();
		for(int i=2; i<=rRMsTitlesCount; i++) {
			rRMsTitles.add(selenium.getText(CoachFAQ.RRM_SECTION + "[" + i + "]" + CoachFAQ.RRM_TITLE));
			if(i==3) i++;
		}
		return rRMsTitles;
	}
	
	/**
	 * Navigates to Coach Destinations Page
	 */
	public CoachDestinationsPage clickCoachDestinationsLink(){
		selenium.click(CoachFAQ.COACH_DESTINATIONS_LINK);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//selenium.focus(arg0);
		selenium.selectWindow("title=Home - Coach Destinations");
/*		selenium.open("http://www.coachdestinations.com/en");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);*/
		return new CoachDestinationsPage(selenium);
	}	
}
