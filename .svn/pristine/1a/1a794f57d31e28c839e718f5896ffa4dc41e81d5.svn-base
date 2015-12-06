package com.tbb.pages.about;

//import static com.tbb.framework.BaseTest.assertTrue;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.AboutJoinUpgrade;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.FreeSignUpPage;

/**
 *
 * Page Object encapsulates the Join/Upgrade Page.
 *  @author Jaya
 */

public class JoinUpgradePage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Join/Upgrade Page.
	 * @param	selenium
	 */
	public JoinUpgradePage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Join/Upgrade Page.");
		this.selenium = selenium;
		assertTrue(
					"This is not Join/Upgrade Page of logged in user, current page is: "
							+ selenium.getLocation(),
					selenium.getTitle().equals("Team Beachbody - Join/Upgrade"), selenium);
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
	 * Returns the number of rows in the table.
	 * @return int
	 */
	public int getMembershipBenefitRowsCount() {
		return selenium.getXpathCount(AboutJoinUpgrade.ALL_TBB_MEMBERSHIP_BENEFITS).intValue();
	}

	/**
	 * Returns the number of rows which are checked for Club User.
	 * @return int
	 */
	public int getClubCheckedRowsCount() {
		return selenium.getXpathCount(AboutJoinUpgrade.ALL_CLUB_CHECKMARK).intValue();
	}

	/**
	 * Returns the number of rows which are checked for Free User.
	 * @return int
	 */
	public int getFreeCheckedRowsCount() {
		return selenium.getXpathCount(AboutJoinUpgrade.ALL_FREE_CHECKMARK).intValue();
	}

	/**
	 * Returns the number of rows which are unchecked for Free User.
	 * @return int
	 */
	public int getFreeUncheckedRowsCount() {
		return selenium.getXpathCount(AboutJoinUpgrade.ALL_FREE_UNCHECKED).intValue();
	}

	/**
	 * Returns the number of paragraphs in the secondary text section at the bottom of Join/Upgrade page.
	 * @return int
	 */
	public int getSecondaryTextParagraphsCount() {
		return selenium.getXpathCount(AboutJoinUpgrade.ALL_SECONDARY_TEXT_PARAGRAPHS).intValue();
	}
	
	/**
	 * Navigates to Free Sign Up page
	 */
	public FreeSignUpPage clickFreeMembershipButton() {
		selenium.click(AboutJoinUpgrade.SIGN_ME_UP_FOR_FREE_MEMBERSHIP);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new FreeSignUpPage(selenium);
	}
}