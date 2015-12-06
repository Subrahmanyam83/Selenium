package com.tbb.pages.connect;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.SuccessStories;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
/**
 * 
 * Page Object encapsulates the Success Stories Page
 * @author Jaya
 */
public class SuccessStoriesPage  extends BaseTest implements SuccessStories {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Success Stories Page.
	 * @param	selenium
	 */
	public SuccessStoriesPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Success Stories Page");
		this.selenium = selenium;
		assertTrue("This is not Success Stories Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Connect: Success Stories"), selenium);
	}
	
	/**
	 * Clicks on Connect link at the top menu bar. Navigates user to Connect Page. 
	 * @return Connect Page
	 */
	public ConnectPage clickConnectLink() {
		selenium.click(Dashboard.CONNECT_MENU_LINK);	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new ConnectPage(selenium);
	}
	
	/**
	 * Navigates user to last page of Success Stories results. 
	 */
	public void navigateToLastPage() {
		selenium.click(ENABLED_TOP_LAST_ARROW);	
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
	
	/**
	 * Navigates user to next page of Success Stories results. 
	 */
	public void navigateToNextPage() {
		selenium.click(ENABLED_TOP_NEXT_ARROW);		
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
	
	/**
	 * Navigates user to first page of Success Stories results. 
	 */
	public void navigateToFirstPage() {
		selenium.click(ENABLED_TOP_FIRST_ARROW);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
	
	/**
	 * Navigates user to previous page of Success Stories results. 
	 */
	public void navigateToPrevPage() {
		selenium.click(ENABLED_TOP_PREVIOUS_ARROW);		
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Returns the number of rows of success stories displayed on the page. 
	 * @return int
	 */
	public int getRowsCount() {
		return selenium.getXpathCount(TABLE_ROWS).intValue();
	}

	/**
	 * Selects the specified value from Items per page drop down displayed at the top of the page. 
	 * @param items_per_page_value
	 */
	public void selectItemsPerPage(String items_per_page_value) {
		selenium.select(TOP_ITEMS_PER_PAGE_DROPDOWN, items_per_page_value);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Returns an array of options from Gender Age drop down.
	 * @return String[]
	 */
	public String[] getGenderAgeDropdownValues() {
		return selenium.getSelectOptions(GENDER_AGE_DROPDOWN);
	}

	/**
	 * Return an array of options from Items per page drop down 
	 * @return String[]
	 */
	public String[] getItemsPerPageDropdownValues() {
		return selenium.getSelectOptions(TOP_ITEMS_PER_PAGE_DROPDOWN);
	}

}