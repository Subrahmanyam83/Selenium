package com.tbb.pages.about;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.AboutCommunity;
import com.tbb.constants.UIRepository.AboutJoinUpgrade;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.connect.MemberGalleryPage;
import com.tbb.pages.connect.MemberGallerySearchResultsPage;
import com.tbb.pages.connect.MessageBoardsPage;
import com.tbb.pages.connect.MessageCenterPage;
import com.tbb.pages.getfit.WorkoutGroupsPage;
import com.tbb.pages.getfit.WowySuperGymPage;
import com.tbb.pages.profile.BlogPage;
//import static com.tbb.framework.BaseTest.assertTrue;
/**
 * 
 * Page Object encapsulates the Community Page.
 * @author Jaya
 */

public class CommunityPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Community Page.
	 * @param	selenium
	 */
	public CommunityPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Community Page.");
		this.selenium = selenium;
		assertTrue("This is not Community Page of logged in user, current page" + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - About: Community"), selenium);
	}
	
	/**
	 * Clicks on Next arrow on the web page. 
	 */
	public void clickNextArrow() {
		selenium.click(AboutCommunity.ENABLED_NEXT_ARROW);
	}

	/**
	 * Returns the number of images between the previous and next arrows displayed on the page. 
	 * @return int
	 */
	public int getAllImagesBetweenArrowsCount() {
		return selenium.getXpathCount(AboutCommunity.ALL_IMAGES_BETWEEN_ARROWS).intValue();
	}

	/**
	 * Returns the number of images in Total Fitness solution section of the page. 
	 * @return int
	 */
	public int getAllFitnessSolutionImagesCount() {
		return selenium.getXpathCount(AboutCommunity.ALL_TOTAL_FITNESS_SOLUTION_IMAGES).intValue();
	}

	/**
	 * Returns the number of headers in Total Fitness solution section of the page.  
	 * @return int
	 */
	public int getAllFitnessSolutionHeaderCount() {
		return selenium.getXpathCount(AboutCommunity.ALL_TOTAL_FITNESS_SOLUTION_HEADERS).intValue();
	}

	/**
	 * Returns the number of text paragraphs in Total Fitness solution section of the page. 
	 * @return int
	 */
	public int getAllFitnessSolutionTextCount() {
		return selenium.getXpathCount(AboutCommunity.ALL_TOTAL_FITNESS_SOLUTION_TEXT).intValue();
	}

	/**
	 * Returns the number of links in Total Fitness solution section of the page. 
	 * @return int
	 */
	public int getAllFitnessSolutionLinksCount() {
		return selenium.getXpathCount(AboutCommunity.ALL_TOTAL_FITNESS_SOLUTION_LINKS).intValue();
	}

	/**
	 * Clicks on 'See Entire Member Gallery' link. 
	 * @return Member Gallery Search Results Page
	 */
	public MemberGallerySearchResultsPage clickSeeEntireGalleryLink() {
		selenium.click(AboutCommunity.SEE_ENTIRE_MEMBER_GALLERY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MemberGallerySearchResultsPage(selenium);
	}

	/**
	 * Clicks on 'Find Buddies Now' link. Navigates user to Member Gallery Page. 
	 * @return Member Gallery Page
	 */
	public MemberGalleryPage clickFindBuddiesNowLink() {
		selenium.click(AboutCommunity.FIND_BUDDIES_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MemberGalleryPage(selenium);
	}

	/**
	 * Clicks on 'Find Workout Groups' link. Navigates user to Workout Groups Page. 
	 * @return Workout Groups Page
	 */
	public WorkoutGroupsPage clickFindWorkoutGroupsLink() {
		selenium.click(AboutCommunity.FIND_WORKOUT_GROUPS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutGroupsPage(selenium);
	}

	/**
	 * Clicks on 'Visit Message Boards' link. Navigates user to Message Boards Page. 
	 * @return Message Boards Page
	 */
	public MessageBoardsPage clickVisitMessageBoardsLink() {
		selenium.click(AboutCommunity.VISIT_MESSAGE_BOARDS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MessageBoardsPage(selenium);
	}

	/**
	 * Clicks on 'Visit Blogs' link. Navigates user to Blogs Page. 
	 * @return Blog Page
	 */
	public BlogPage clickVisitBlogsLink() {
		selenium.click(AboutCommunity.VISIT_BLOGS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new BlogPage(selenium);
	}

	/**
	 * Clicks on 'Visit The Message Center' link. Navigates user to Message Center Page. 
	 * @return Message Center Page
	 */
	public MessageCenterPage clickVisitTheMessageCenterLink() {
		selenium.click(AboutCommunity.VISIT_THE_MESSAGE_CENTER_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new MessageCenterPage(selenium);
	}

	/**
	 * Clicks on 'Visit Wowy SuperGym' link. Navigates user to Wowy Super Gym Page. 
	 * @return Wowy Super Gym Page
	 */
	public WowySuperGymPage clickVisitWowySupergymLink() {
		selenium.click(AboutCommunity.VISIT_WOWY_SUPERGYM_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WowySuperGymPage(selenium);
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
}