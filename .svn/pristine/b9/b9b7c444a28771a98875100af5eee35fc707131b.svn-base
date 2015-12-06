package com.tbb.pages.profile;



import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.BlogTab;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.about.AboutPage;
/**
 * 
 * Page Object encapsulates the Blog Page
 * @author xebia
 */
public class BlogPage  extends BaseTest implements BlogTab{

	/**
	 * This is constructor for this class. It validates that the user is on Blog Page.
	 * @param	selenium
	 * @throws  IllegalStateException if the user is on a different page than Blog Page.
	 */
	public BlogPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Blog Page Class");
		assertTrue("This is not Team Beachbody - Edit Profile: Blog of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Edit Profile: Blog"), selenium);
	}	
	
	/**
	 * Clicks on Add Blog Entry button. 
	 */
	public void addBlogEntry(){
		selenium.click("css=input[value='Add Blog Entry']");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
	
	/**
	 * Clicks on Delete image for deleting a blog. 
	 */
	public void deleteBlogEntry(){
		selenium.click("css=img[alt='Delete']");
	}
	
	/**
	 * Clicks 'Cancel' button on the confirmation pop up displayed after performing next command. 
	 */
	public void clickCancelOnNextConfirmation(){
		selenium.chooseCancelOnNextConfirmation();
	}
	
	/**
	 * Clicks on 'Ok' button on the confirmation pop up displayed after performing next command. 
	 */
	public void clickOkOnNextConfirmation(){
		selenium.chooseOkOnNextConfirmation();
	}

	/**
	 * Types the blog title in the title textbox. 
	 * @param blogTitle
	 */
	public void typeBlogTitle(String blogTitle) {
		selenium.type(TITLE_TEXTBOX, blogTitle);		
	}

	/**
	 * Selects publish date for blog. 
	 * @param month
	 * @param day
	 * @param year
	 * @param hour
	 * @param min
	 * @param ampm
	 */
	public void selectPublishDate(String month, String day, String year,
			String hour, String min, String ampm) {
		selenium.select(PUBLISH_DATE_MONTH, month);
		selenium.select(PUBLISH_DATE_DAY, day);
		selenium.select(PUBLISH_DATE_YEAR, year);
		selenium.select(PUBLISH_DATE_HOUR, hour);
		selenium.select(PUBLISH_DATE_MINUTES, min);
		selenium.select(PUBLISH_DATE_AMPM, ampm);	
	}

	/**
	 * Types text in Blog text area.
	 * @param blogText
	 */
	public void typeBlogContent(String blogText) {
		selenium.selectFrame(BLOG_TEXTAREA);
		selenium.type("//body",blogText);
		selenium.selectWindow("null");		
	}

	/**
	 * Types tags in tags text box.
	 * @param blogTag
	 */
	public void typeTagsContent(String blogTag) {
		selenium.type(TABS_TEXTBOX, blogTag);		
	}

	/**
	 * Selects the privacy level. 
	 * @param privacyLevel
	 */
	public void selectPrivacyLevel(String privacyLevel) {
		if (privacyLevel=="public")
			selenium.click(PUBLIC_RADIO_BUTTON);
		else if(privacyLevel=="buddies")
			selenium.click(BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(PRIVATE_RADIO_BUTTON);		
	}

	/**
	 * Clicks on Publish Button.
	 */
	public void publishBlog() {
		selenium.click(PUBLISH_BUTTON);		
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Edit Blog Icon.
	 */
	public void clickEditBlogIcon() {
		selenium.click(EDIT_BLOG_ICON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on About Link on top menu bar. Navigates user to About Page. 
	 * @return About Page
	 */
	public AboutPage clickAboutLink() {
		selenium.click("css=li a>span:contains(About)");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}	
	
	/**
	 * Navigates user to Edit Profile Page
	 * @return	EditProfilePage
	 */	
	public EditProfilePage clickLRMProfileLink() {
		selenium.click(LRMProfile.LRM_PROFILE_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EditProfilePage(selenium);
	}
}