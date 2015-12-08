package com.tbb.pages.coach;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Coach;
import com.tbb.constants.UIRepository.Home;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;

/**
 * 
 * Page Object encapsulates the Coach Page.
 * @author Gaurav
 */

public class CoachPage  extends BaseTest {
	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Coach Page.
	 * @param	selenium
	 */
	public CoachPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Coach Page");
		this.selenium = selenium;
		assertTrue("This is not Coach Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Coach"), selenium);
	}	
	
	/**
	 * Verified UI of page
	 */
	public void verifyUI(){
	assertTrue("Coach Sign Up button not displayed", selenium.isElementPresent(Coach.COACH_SIGN_UP), selenium);
	assertTrue("Coach FAQ Link not displayed", selenium.isElementPresent(Coach.COACH_FAQ), selenium);
	assertTrue("Coach Sign In Link not displayed", selenium.isElementPresent(Coach.COACH_SIGN_IN), selenium);
	assertTrue("Ticker not displayed", selenium.isElementPresent(Coach.TBB_TICKER), selenium);
	assertTrue("Founder's message is not shown/completly/correctly shown", selenium.isTextPresent(Coach.FOUNDER_MESSAGE), selenium);
	assertTrue("Founder's image not displayed", selenium.isElementPresent(Coach.FOUNDER_IMAGE), selenium);
	assertTrue("Link of Coach docment related to policies and procedures not displayed", selenium.isElementPresent(Coach.PDF_COACH_POLICIES), selenium);
	assertTrue("Link of Coach docment related to Statement of Independent Coach Earnings not displayed", selenium.isElementPresent(Coach.PDF_COACH_STATEMENT_OF_INDEPENDENT_COACH), selenium);
	assertTrue("Email Collector button for people who live in non-US countries but want to become coach not displayed", selenium.isElementPresent(Coach.EMAIL_COLLECTOR_NOT_US_COACH_REQUEST), selenium);
	}	
	
	/**
	 * Returns count of clips
	 */
	public int getCoachClipCount() {
		return selenium.getXpathCount(Coach.COACH_CLIP_ITEM).intValue();
	}	
	
	/**
	 * Returns titles of clips
	 */
	public ArrayList<String> getCoachClipTitles(){
		ArrayList<String> coachClipTitles = new ArrayList<String>();
		int rrmsCount = getCoachClipCount();
		for (int i =1; i<=rrmsCount; i++) {
			coachClipTitles.add(selenium.getText(Coach.COACH_CLIP_ITEM + "[" + i + "]"));
		}
		return coachClipTitles;
	}
	
	/**
	 * Returns count of clips
	 */
	public int getBrandCount() {
		return selenium.getXpathCount(Coach.TBB_BRAND_ITEM).intValue();
	}
		
	/**
	 * Returns titles of clips
	 */
	public ArrayList<String> getBrandTitles(){
		ArrayList<String> brandTitles = new ArrayList<String>();
		int rrmsCount = getBrandCount();
		for (int i =1; i<=rrmsCount; i++) {
			brandTitles.add(selenium.getAttribute(Coach.TBB_BRAND_ITEM + "[" + i + "]" + "/a/img@alt"));
		}
		return brandTitles;
	}
	
	/**
	 * Navigates to Coach FAQ Page
	 */
	public CoachFAQPage clickCoachFAQLink(){
		selenium.click(Coach.COACH_FAQ);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CoachFAQPage(selenium);
	}
	
	/**
	 * Navigates to Coach Online Office Page
	 */
	public CoachOnlineOfficePage clickCoachOnlineOfficeLink() {
		selenium.click(Coach.COACH_ONLINE_OFFICE_LINK);
		if(ConfigFileReader.getConfigItemValue("browser").equalsIgnoreCase("*iexploreproxy")) {
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		}
	
		
		return new CoachOnlineOfficePage(selenium);
	}
	
	/**
	 * Navigates to Coach Previous Office Page
	 */
	public CoachPreviousOfficePage clickCoachPreviousOfficeLink() {
		selenium.click(Coach.COACH_PRVIOUS_OFFICE_VIEW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CoachPreviousOfficePage(selenium);
	}

	/**
	 * Clicks on TBB Logo and navigates to TBB Home page
	 * @return
	 */
	public HomePage clickTBBLogo() {
		selenium.click(Home.TBB_LOGO);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HomePage(selenium);
	}
	
}
