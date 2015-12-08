package com.tbb.pages.watchvideos;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.EatingHealthy;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Watch Videos - Eating Healthy Page.
 * @author Jaya
 */
public class EatingHealthyPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos - Eating Healthy Page.
	 * @param	selenium
	 */
	public EatingHealthyPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos - Eating Healthy Page.");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos - Eating Healthy Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eating Healthy"), selenium);
	}
	
	/**
	 * Clicks on Watch Videos link at the top menu bar. Navigates user to Watch Videos Page. 
	 * @return Watch Videos Page
	 */
	public WatchVideosPage clickWatchVideosLink() {
		selenium.click(Dashboard.WATCH_VIDEOS_MENU_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WatchVideosPage(selenium);
	}
	
	/**
	 * Returns video's title
	 */
	public String getVideoTitle() {
		return null;
	}	
	
	/**
	 * Returns number of RRMs
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(EatingHealthy.RRM_SECTION).intValue();
	}
		
	/**
	 * Returns title of RRMs
	 */
	public ArrayList<String> getRRMsTitles() {
		ArrayList<String> rrmTitles = new ArrayList();
		int rrmsCount = getRRMsCount();
		for (int i=1; i<=rrmsCount; i++) {
			rrmTitles.add(selenium.getText(EatingHealthy.RRM_SECTION + "[" + i + "]" + EatingHealthy.RRM_TITLE));
		}
		return rrmTitles;		
	}
}