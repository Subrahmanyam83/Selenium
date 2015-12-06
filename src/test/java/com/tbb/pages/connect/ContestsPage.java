package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Contests;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Contests Page
 * @author Jaya
 */
public class ContestsPage  extends BaseTest  {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Contests Page.
	 * @param	selenium
	 */
	public ContestsPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Contests Page");
		this.selenium = selenium;
		assertTrue("This is not Contests Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Contests"), selenium);
	}
	
	/**
	 * Clicks on 'Connect' link in the top menu
	 * @return ConnectPage
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ConnectPage(selenium);
	}
	
	/**
	 * Clicks on the Daily Sweepstakes link in the left hand side menu. Navigates user to Daily Sweepstakes Page.
	 * @return DailySweepstakesPage
	 */
	public DailySweepstakesPage goToDailySweepstakesPage() {
		selenium.click(Contests.LEFT_MENU_DAILY_SWEEPSTAKES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new DailySweepstakesPage(selenium);
	}

	/**
	 * Clicks on Previous Arrow.
	 */
	public void clickPrevArrow() {
		selenium.click(Contests.PREV_ARROW);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * Clicks on Next Arrow.
	 */
	public void clickNextArrow() {
		selenium.click(Contests.NEXT_ARROW);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	/**
	 * Clicks on 'The Beachbody Challenge' link in the left hand side menu. Navigates user to The Beachbody Challenge page. 
	 * @return TheBeachbodyChallengePage
	 */
	public TheBeachbodyChallengePage goToTheBeachbodyChallengePage() {
		selenium.click(Contests.LEFT_MENU_THE_BEACHBODY_CHALLENGE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TheBeachbodyChallengePage(selenium);
	}

	/**
	 * Clicks on 'Contest FAQ' link in the left hand side menu. Navigates user to Contest FAQ page. 
	 * @return ContestFAQPage
	 */
	public ContestFAQPage goToContestFAQPage() {
		selenium.click(Contests.LEFT_MENU_CONTEST_FAQ_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ContestFAQPage(selenium);		
	}
}