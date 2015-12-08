package com.tbb.pages.profile;

import java.util.HashMap;
import java.util.Map;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.constants.UIRepository.PrivacyTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
/**
 * 
 * Page Object encapsulates the Privacy Page
 * @author Jaya
 */
public class PrivacyPage  extends BaseTest  implements PrivacyTab{

	/**
	 * Validates the user is on Privacy Page.
	 * @param 	selenium
	 * @throws  IllegalStateException if the user is on a different page than Privacy Page.
	 */
	public PrivacyPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of Privacy Page Class");
		assertTrue("This is not Edit Profile: Privacy Page, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Edit Profile: Privacy"), selenium);
	}
	/**
	 * Selects Profile Visibility settings 
	 * @param privacyLevel
	 */	
	public void selectProfileVisibility(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Basic Information - Location. 
	 * @param privacyLevel
	 */	
	public void selectLocationPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(LOCATION_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(LOCATION_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(LOCATION_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Basic Information - Personal Bio.  
	 * @param privacyLevel
	 */	
	public void selectPersonalBioPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(PERSONAL_BIO_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(PERSONAL_BIO_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(PERSONAL_BIO_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Basic Information - Blog.  
	 * @param privacyLevel
	 */	
	public void selectBlogPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(BLOG_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(BLOG_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(BLOG_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Basic Information - Overall Goal.  
	 * @param privacyLevel
	 */	
	public void selectOverallGoalPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(OVERALL_GOAL_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(OVERALL_GOAL_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(OVERALL_GOAL_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Progress and Goals - Transformation Story.  
	 * @param privacyLevel
	 */	
	public void selectTransformationStoryPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(TRANSFORMATION_STORY_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(TRANSFORMATION_STORY_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(TRANSFORMATION_STORY_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Team Beach Body Programs - Meal Plans.  
	 * @param privacyLevel
	 */	
	public void selectMealPlanPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(MEAL_PLANS_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(MEAL_PLANS_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(MEAL_PLANS_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Team Beach Body Programs - Fitness Program(s).  
	 * @param privacyLevel
	 */	
	public void selectFitnessProgramsPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(FITNESS_PROGRAMS_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(FITNESS_PROGRAMS_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(FITNESS_PROGRAMS_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Team Beach Body Programs - Gear.  
	 * @param privacyLevel
	 */	
	public void selectGearPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(GEAR_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(GEAR_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(GEAR_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Team Beach Body Programs - Supplements.  
	 * @param privacyLevel
	 */	
	public void selectSupplementsPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(SUPPLEMENTS_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(SUPPLEMENTS_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(SUPPLEMENTS_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Team Beach Body Photos - Before And After Photos.  
	 * @param privacyLevel
	 */	
	public void selectBeforeAndAfterPhotosPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(BEFORE_AND_AFTER_PHOTOS_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(BEFORE_AND_AFTER_PHOTOS_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(BEFORE_AND_AFTER_PHOTOS_PRIVATE_RADIO_BUTTON);
	}	
	/**
	 * Selects Privacy settings for Team Beach Body Photos - Photo Gallery.  
	 * @param privacyLevel
	 */	
	public void selectPhotoGalleryPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(PHOTO_GALLERY_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(PHOTO_GALLERY_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(PHOTO_GALLERY_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Team Beach Body Buddies and Groups - Workout Buddies.  
	 * @param privacyLevel
	 */	
	public void selectWorkoutBuddiesPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(WORKOUT_BUDDIES_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(WORKOUT_BUDDIES_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(WORKOUT_BUDDIES_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Team Beach Body Buddies and Groups - Workout Groups.  
	 * @param privacyLevel
	 */	
	public void selectWorkoutGroupsPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(WORKOUT_GROUPS_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(WORKOUT_GROUPS_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(WORKOUT_GROUPS_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Team Beach Body Work out Information - Next Work out.  
	 * @param privacyLevel
	 */	
	public void selectNextWorkoutPrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(NEXT_WORKOUT_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(NEXT_WORKOUT_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(NEXT_WORKOUT_PRIVATE_RADIO_BUTTON);
	}
	/**
	 * Selects Privacy settings for Team Beach Body Work out Information - Work out Schedule.  
	 * @param privacyLevel
	 */	
	public void selectWorkoutSchedulePrivacy(String privacyLevel){
		if(privacyLevel.equals("Public"))
			selenium.click(WORKOUT_SCHEDULE_PUBLIC_RADIO_BUTTON);
		else if(privacyLevel.equals("Buddies"))
			selenium.click(WORKOUT_SCHEDULE_BUDDIES_RADIO_BUTTON);
		else 
			selenium.click(WORKOUT_SCHEDULE_PRIVATE_RADIO_BUTTON);
	}

	/**
	 * This method clicks on save button to save the privacy settings.   
	 * @return PrivacyPage
	 */	
	public PrivacyPage savePrivacy(){
		selenium.click(SAVE_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new PrivacyPage(selenium);
	}

	/**
	 * This method clicks on Reset button to reset the privacy settings.   
	 * @return PrivacyPage
	 */	
	public PrivacyPage resetPrivacy(){
		selenium.click(RESET_BUTTON);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PrivacyPage(selenium);
	}

	/**
	 * This function returns all the existing values shown on the Privacy Page.  
	 * @return map
	 */	
	public Map<String, String> getExistingPrivacySettings() {

		Map<String, String> map = new HashMap<String, String>();

		map.put(PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(PUBLIC_RADIO_BUTTON)).toString());
		map.put(BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(BUDDIES_RADIO_BUTTON)).toString());
		map.put(PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(PRIVATE_RADIO_BUTTON)).toString());

		map.put(LOCATION_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(LOCATION_PUBLIC_RADIO_BUTTON)).toString());
		map.put(LOCATION_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(LOCATION_BUDDIES_RADIO_BUTTON)).toString());
		map.put(LOCATION_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(LOCATION_PRIVATE_RADIO_BUTTON)).toString());

		map.put(PERSONAL_BIO_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(PERSONAL_BIO_PUBLIC_RADIO_BUTTON)).toString());
		map.put(PERSONAL_BIO_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(PERSONAL_BIO_BUDDIES_RADIO_BUTTON)).toString());
		map.put(PERSONAL_BIO_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(PERSONAL_BIO_PRIVATE_RADIO_BUTTON)).toString());

		map.put(BLOG_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(BLOG_PUBLIC_RADIO_BUTTON)).toString());
		map.put(BLOG_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(BLOG_BUDDIES_RADIO_BUTTON)).toString());
		map.put(BLOG_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(BLOG_PRIVATE_RADIO_BUTTON)).toString());

		map.put(OVERALL_GOAL_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(OVERALL_GOAL_PUBLIC_RADIO_BUTTON)).toString());
		map.put(OVERALL_GOAL_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(OVERALL_GOAL_BUDDIES_RADIO_BUTTON)).toString());
		map.put(OVERALL_GOAL_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(OVERALL_GOAL_PRIVATE_RADIO_BUTTON)).toString());

		map.put(TRANSFORMATION_STORY_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(TRANSFORMATION_STORY_PUBLIC_RADIO_BUTTON)).toString());
		map.put(TRANSFORMATION_STORY_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(TRANSFORMATION_STORY_BUDDIES_RADIO_BUTTON)).toString());
		map.put(TRANSFORMATION_STORY_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(TRANSFORMATION_STORY_PRIVATE_RADIO_BUTTON)).toString());

		map.put(MEAL_PLANS_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(MEAL_PLANS_PUBLIC_RADIO_BUTTON)).toString());
		map.put(MEAL_PLANS_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(MEAL_PLANS_BUDDIES_RADIO_BUTTON)).toString());
		map.put(MEAL_PLANS_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(MEAL_PLANS_PRIVATE_RADIO_BUTTON)).toString());

		map.put(FITNESS_PROGRAMS_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_PUBLIC_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_BUDDIES_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_PRIVATE_RADIO_BUTTON)).toString());

		map.put(GEAR_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(GEAR_PUBLIC_RADIO_BUTTON)).toString());
		map.put(GEAR_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(GEAR_BUDDIES_RADIO_BUTTON)).toString());
		map.put(GEAR_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(GEAR_PRIVATE_RADIO_BUTTON)).toString());

		map.put(SUPPLEMENTS_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(SUPPLEMENTS_PUBLIC_RADIO_BUTTON)).toString());
		map.put(SUPPLEMENTS_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(SUPPLEMENTS_BUDDIES_RADIO_BUTTON)).toString());
		map.put(SUPPLEMENTS_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(SUPPLEMENTS_PRIVATE_RADIO_BUTTON)).toString());

		map.put(BEFORE_AND_AFTER_PHOTOS_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(BEFORE_AND_AFTER_PHOTOS_PUBLIC_RADIO_BUTTON)).toString());
		map.put(BEFORE_AND_AFTER_PHOTOS_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(BEFORE_AND_AFTER_PHOTOS_BUDDIES_RADIO_BUTTON)).toString());
		map.put(BEFORE_AND_AFTER_PHOTOS_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(BEFORE_AND_AFTER_PHOTOS_PRIVATE_RADIO_BUTTON)).toString());

		map.put(PHOTO_GALLERY_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(PHOTO_GALLERY_PUBLIC_RADIO_BUTTON)).toString());
		map.put(PHOTO_GALLERY_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(PHOTO_GALLERY_BUDDIES_RADIO_BUTTON)).toString());
		map.put(PHOTO_GALLERY_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(PHOTO_GALLERY_PRIVATE_RADIO_BUTTON)).toString());

		map.put(WORKOUT_BUDDIES_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(WORKOUT_BUDDIES_PUBLIC_RADIO_BUTTON)).toString());
		map.put(WORKOUT_BUDDIES_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(WORKOUT_BUDDIES_BUDDIES_RADIO_BUTTON)).toString());
		map.put(WORKOUT_BUDDIES_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(WORKOUT_BUDDIES_PRIVATE_RADIO_BUTTON)).toString());

		map.put(WORKOUT_GROUPS_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(WORKOUT_GROUPS_PUBLIC_RADIO_BUTTON)).toString());
		map.put(WORKOUT_GROUPS_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(WORKOUT_GROUPS_BUDDIES_RADIO_BUTTON)).toString());
		map.put(WORKOUT_GROUPS_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(WORKOUT_GROUPS_PRIVATE_RADIO_BUTTON)).toString());

		map.put(NEXT_WORKOUT_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(NEXT_WORKOUT_PUBLIC_RADIO_BUTTON)).toString());
		map.put(NEXT_WORKOUT_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(NEXT_WORKOUT_BUDDIES_RADIO_BUTTON)).toString());
		map.put(NEXT_WORKOUT_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(NEXT_WORKOUT_PRIVATE_RADIO_BUTTON)).toString());

		map.put(WORKOUT_SCHEDULE_PUBLIC_RADIO_BUTTON, new Boolean(selenium.isChecked(WORKOUT_SCHEDULE_PUBLIC_RADIO_BUTTON)).toString());
		map.put(WORKOUT_SCHEDULE_BUDDIES_RADIO_BUTTON, new Boolean(selenium.isChecked(WORKOUT_SCHEDULE_BUDDIES_RADIO_BUTTON)).toString());
		map.put(WORKOUT_SCHEDULE_PRIVATE_RADIO_BUTTON, new Boolean(selenium.isChecked(WORKOUT_SCHEDULE_PRIVATE_RADIO_BUTTON)).toString());

		return map;
	}	
	
	/**
	 * Signs out the user from the web site.   
	 */
	public HomePage signOut() {
		selenium.click(Home.SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent(Home.SIGN_IN_LINK);
		return new HomePage(selenium);
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
