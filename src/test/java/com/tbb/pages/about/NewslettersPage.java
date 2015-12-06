package com.tbb.pages.about;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.AboutJoinUpgrade;
import com.tbb.constants.UIRepository.AboutNewsletters;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Newsletters Page.
 * @author Jaya
 */

public class NewslettersPage {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Newsletters Page.
	 * @param	selenium
	 */
	public NewslettersPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Newsletters Page.");
		this.selenium = selenium;
		if (!selenium.getTitle().equals("Team Beachbody - Newsletters")) {
			throw new IllegalStateException("This is not Newsletters Page of logged in user, current page" +
					"is: " +selenium.getLocation());
		}
	}
	
	/**
	 * Clicks on About link in the top menu bar. Navigates to About Page. 
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click(AboutJoinUpgrade.MENU_BAR_ABOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}

	/**
	 * Clicks on Featured issue title. Navigates user to the detailed view of Featured issue. 
	 */
	public void viewFeaturedIssue() {
		selenium.click(AboutNewsletters.FEATURED_ISSUE_TITLE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Retrieves the title of the Featured issue. 
	 * @return String
	 */
	public String getFeaturedIssueTitle() {
		return selenium.getText(AboutNewsletters.FEATURED_ISSUE_TITLE);
	}

	/**
	 * Clicks on the specified year tab to view the newsletter corresponding to that year. 
	 * @param year
	 */
	public void selectYear(int year) {
		selenium.click("css=div.newsletter-year:contains("+year+")");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Selects the month from the month drop down to filter the results. 
	 * @param month
	 */
	public void filterByMonth(String month) {
		selenium.select(AboutNewsletters.FILTER_BY_MONTH_DROPDOWN, month);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}