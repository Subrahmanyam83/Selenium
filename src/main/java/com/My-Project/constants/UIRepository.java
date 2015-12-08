package com.tbb.constants;

/**
 * UI Repository defines constants for locators of various web elements displayed on the web pages of TBB Web site.
 * Instead of hard coding locators in test scripts, these locators are defined here using variables.
 * It helps to save the maintenance effort of from making changes to hundreds of test scripts using a locator of a
 * web page in case any of that locator gets changed. 
 * 
 * @author Jaya
 */
public interface UIRepository {

	public interface EditProfile{
		final String EDIT_PROFILE_HEADER = "css=div.banner-bg>h3";
		final String YOUR_PROFILE_PROGRESS_IMAGE_HEADER = "css=div.header-right-side";
		final String EDIT_BASIC_INFORMATION_LINK = "css=a[title='Edit Basic Information']";
		final String EDIT_PROGRESS_AND_GOALS_LINK = "css=a[title='Edit Progress and Goals']";
		final String EDIT_FITNESS_PROGRAMS_LINK = "css=a[title='Edit Fitness Programs']";
		final String EDIT_PHOTOS = "css=a[title='Edit Photos']";
		final String EDIT_BUDDIES = "css=span:contains(Buddies)";
		final String EDIT_GROUPS = "css=a[title='Edit Groups']";
		final String EDIT_PRIVACY = "css=a[title='Edit Privacy']";
		final String EDIT_BLOG = "css=a[title='Edit Blog']";
		final String ICON_XPATH = "//div[@class='icon']";
	}

	/**
	 * LRM Profile contains locators for web elements displayed on Profile Page. 
	 * @author Jaya
	 */
	public interface LRMProfile{
		final String LRM_PROFILE_LINK = "css=div.nav-menu.nav-menu-style- > h2 > a[href$='edit-profile']";
		final String LRM_BASIC_INFORMATION = "css=ul.layouts.level-1 > li > a[href$='basicinfo']";
		final String LRM_PROGRESS_AND_GOALS = "css=ul.layouts.level-1 > li > a[href$='progressandgoals']";
		final String LRM_PROGRAMS = "css=ul.layouts.level-1 > li > a[href$='programs']";
		final String LRM_PHOTOS = "css=ul.layouts.level-1 > li > a[href$='photos']";
		final String LRM_BUDDIES = "css=ul.layouts.level-1 > li > a[href$='buddies']";
		final String LRM_GROUPS = "css=ul.layouts.level-1 > li > a[href$='groups']";
		final String LRM_BLOGS = "css=ul.layouts.level-1 > li > a[href$='blog']";
		final String LRM_PRIVACY = "css=ul.layouts.level-1 > li > a[href$='privacy']";
	}

	/**
	 * MyProfile interface contains locators for web elements displayed on My Profile Page. 
	 * @author Jaya
	 */
	public interface MyProfile{
		final String PROFILE_PHOTO = "css=div.photo-large";
		final String EDIT_PHOTOS = "css=a.member-profile-small-link[href='/edit-profile/photos']";
		final String EDIT_PRIVACY_SETTINGS = "css=a.member-profile-small-link[href='/edit-profile/privacy']";
		final String VIEW_NOTIFICATIONS = "css=a.member-profile-small-link[href='/connect/message-center/notifications']";

		final String PROGRESS_BAR = "css=div[class='progress_status progress_status_null']";
		final String EDIT_PROFILE = "css=a[href='/edit-profile']";

		final String MY_PHOTOS_HEADER = "css=div.member-profile-photos-my-photos>div.member-profile-photo-title";
		final String PROFILE_INFO = "css=div[class='member profile info']";
		final String ADD_PHOTOS_NOW = "css=a[title='Add Photos Now']";

		final String MY_BUDDIES_HEADER = "css=div#p_p_id_MEMBER_PROFILE_BUDDIES_WAR_tbbsocialportlet_ div.member-profile-photo-title";
		final String EDIT_BUDDIES = "css=a.member-profile-small-link[href='/edit-profile/buddies']";

		final String SCREEN_NAME_HEADER = "css=div.column.member-profile-title";
		final String MEMBER_PROFILE_INTRO_TEXT = "css=div.member-profile-basic-info div.member-profile-intro-text";
		final String MEMBER_PROFILE_INFO = "css=div.member-profile-basic-info div[class='member profile info'] p";		
		final String EDIT_BASIC_INFORMATION = "css=a.member-profile-link[href='/edit-profile/basicinfo']";
		final String START_PERSONAL_BIO = "css=a[title='Start my personal bio']";

		final String MY_PROGRESS_LABEL = "css=div.portlet-boundary.portlet-boundary_MEMBER_PROFILE_PROGRESS_WAR_userprofileportlet_.portlet-tbb-member_profile_progress > div>div.member-profile-sub-title";
		final String MY_FITNESS_GOAL_LABEL = "css=div.portlet-boundary.portlet-boundary_MEMBER_PROFILE_PROGRESS_WAR_userprofileportlet_.portlet-tbb-member_profile_progress div div.member-profile-my-goal";
		final String EDIT_PROGRESS_AND_GOALS = "css=a.member-profile-link[href='/edit-profile/progressandgoals']";
		final String MY_PROGRESS_INTRO_TEXT = "css=div.portlet-boundary.portlet-boundary_MEMBER_PROFILE_PROGRESS_WAR_userprofileportlet_.portlet-tbb-member_profile_progress div div.member-profile-intro-text";

		final String PROGRAMS_LABEL = "css=div.portlet-boundary.portlet-boundary_MEMBER_PROFILE_PROGRAMS_WAR_userprofileportlet_.portlet-tbb-member_profile_programs div.member-profile-programs>div>div.member-profile-sub-title";
		final String EDIT_PROGRAMS = "css=a.member-profile-link[href='/edit-profile/programs']";
		final String MEAL_PLAN_LABEL = "css=div.portlet-boundary.portlet-boundary_MEMBER_PROFILE_PROGRAMS_WAR_userprofileportlet_.portlet-tbb-member_profile_programs div.member-profile-programs  div.inline-block>div>div.member-profile-category:contains(Meal plan:)";
		final String WORKOUT_PROGRAMS_LABEL = "css=div.portlet-boundary.portlet-boundary_MEMBER_PROFILE_PROGRAMS_WAR_userprofileportlet_.portlet-tbb-member_profile_programs div.member-profile-programs   div.inline-block>div>div.member-profile-category:contains(Workout programs:)";
		final String GEAR_LABEL = "css=div.portlet-boundary.portlet-boundary_MEMBER_PROFILE_PROGRAMS_WAR_userprofileportlet_.portlet-tbb-member_profile_programs div.member-profile-programs  div.inline-block>div>div.member-profile-category:contains(Gear:)";
		final String SUPPLEMENTS_LABEL = "css=div.portlet-boundary.portlet-boundary_MEMBER_PROFILE_PROGRAMS_WAR_userprofileportlet_.portlet-tbb-member_profile_programs div.member-profile-programs   div.inline-block>div>div.member-profile-category:contains(Supplements:)";

		final String ADD_NEW_BLOG_ENTRY = "css=a.member-profile-small-link[href='/edit-profile/blog']";
		final String START_YOUR_BLOG = "css=a[title='Start your blog']";
	}

	/**
	 * BasicInformationTab interface contains locators for web elements displayed on Basic Information Page. 
	 * @author Jaya
	 */
	public interface BasicInformationTab {
		final String PAGE_HEADER = "css=h3.title";
		final String PAGE_IMAGE = "css=img[alt='Basic Information']";
		final String SCREEN_NAME_LABEL = "css=span#_USER_PROFILE_BASIC_INFO_WAR_userprofileportlet_screenNameLabel";
		final String SCREEN_NAME_HELP_ICON = "css=a.help-icon[onclick='Liferay.CornerPop.helpDialog(this, 'one-click-prefs-help-dialog-wrapperedit-profile-basic-info-screen-name')']";
		final String SCREEN_NAME_HELP_WINDOW = "css=div[id='one-click-prefs-help-dialog-wrapperedit-profile-basic-info-screen-name']";
		final String SCREEN_NAME_HELP_WINDOW_CLOSE = "css=input[value='Close']";
		final String SCREEN_NAME_TEXTBOX = "css=input#_USER_PROFILE_BASIC_INFO_WAR_userprofileportlet_screenName";
		final String SCREEN_NAME_HELP = "css=a[onClick='Liferay.CornerPop.helpDialog(this, 'one-click-prefs-help-dialog-wrapperedit-profile-basic-info-screen-name')']";
		final String CHECK_AVAILABILITY_BUTTON = "css=input[value='Check Availability']";
		final String AVAILABILITY_LABEL = "css=span#_USER_PROFILE_BASIC_INFO_WAR_userprofileportlet_availability";
		final String BIRTHDAY_HELP = "css=a[onclick='Liferay.CornerPop.helpDialog(this, 'one-click-prefs-help-dialog-wrapperedit-profile-basic-info-birthday')']";
		final String BIRTHDAY_HELP_WINDOW = "css=div[class='message clearfix']";
		final String BIRTHDAY_HELP_WINDOW_CLOSE = "css=input[value='Close']";
		final String BIRTHDAY_MONTH = "css=select#_USER_PROFILE_BASIC_INFO_WAR_userprofileportlet_birthdayMonth";
		final String BIRTHDAY_DAY = "css=select#_USER_PROFILE_BASIC_INFO_WAR_userprofileportlet_birthdayDay";
		final String BIRTHDAY_YEAR = "css=select#_USER_PROFILE_BASIC_INFO_WAR_userprofileportlet_birthdayYear";
		final String CALENDAR_ICON = "css=div.form-section img.ui-datepicker-trigger";
		final String CALENDAR = "selenium.isElementPresent('css=div[id='ui-datepicker-div']')";
		final String CALENDAR_YEAR_DROPDOWN = "css=select[class='ui-datepicker-new-year']";
		final String CALENDAR_MONTH_DROPDOWN = "css=select[class='ui-datepicker-new-month']";
		final String CALENDAR_DAYS = "link";
		final String FEMALE_RADIO_BUTTON = "css=input[id='_USER_PROFILE_BASIC_INFO_WAR_userprofileportlet_female']";
		final String MALE_RADIO_BUTTON = "css=input[id='_USER_PROFILE_BASIC_INFO_WAR_userprofileportlet_male']";
		final String TIMEZONE = "css=select#_USER_PROFILE_BASIC_INFO_WAR_userprofileportlet_timeZoneId";
		final String BIO = "css=textarea[name='bio']";
		final String SAVE_BUTTON = "css=input[value='Save']";
		final String RESET_BUTTON = "css=input[value='Reset']";
		final String SUCCESS_MESSAGE = "css=div.portlet-msg-success";
		final String MY_ACCOUNT_LINK = "css=span[class='right-rail-link']";
	}

	/**
	 * BlogTab interface contains locators for web elements displayed on Blog Page. 
	 * @author Jaya
	 */
	public interface BlogTab{
		final String BLOG_HEADER = "css=h2.title:contains(Blog)";
		final String SEARCH_RESULTS_LABEL = "css=div.search-results";
		final String ADD_BLOG_ENTRY_BUTTON = "css=input[value='Add Blog Entry']";
		final String ENTRIES_LINK = "css=a:contains(Entries)";
		final String TITLE_LABEL = "css=td.lfr-label:contains(Title)";
		final String TITLE_TEXTBOX = "css=input#_33_title";
		final String PUBLISH_DATE_LABEL = "css=td.lfr-label:contains(Publish Date)";
		final String PUBLISH_DATE_MONTH = "css=select#_33_displayDateMonth";
		final String PUBLISH_DATE_DAY = "css=select#_33_displayDateDay";
		final String PUBLISH_DATE_YEAR = "css=select#_33_displayDateYear";
		final String PUBLISH_DATE_PICKER_ICON = "css=img.ui-datepicker-trigger";
		final String PUBLISH_DATE_HOUR = "css=select[name='_33_displayDateHour']";
		final String PUBLISH_DATE_MINUTES = "css=select[name='_33_displayDateMinute']";
		final String PUBLISH_DATE_AMPM = "css=select[name='_33_displayDateAmPm']";
		final String BLOG_TEXTAREA = "id=textArea_ifr";
		final String TAGS_LABEL = "css=td.lfr-label:contains(Tags)";
		final String TABS_TEXTBOX = "css=input[class='ui-tags-input ui-autocomplete-input']";
		final String ADD_TAGS_BUTTON = "css=span.btn-white>input[value='Add Tags']";
		final String SELECT_TAGS_BUTTON = "css=span.btn-white>input[value='Select Tags']";
		final String SUGGESTIONS_BUTTON = "css=span.btn-white>input[value='Suggestions']";
		final String PUBLIC_RADIO_BUTTON = "css=input[value='public']";
		final String BUDDIES_RADIO_BUTTON = "css=input[value='buddy']";
		final String PRIVATE_RADIO_BUTTON = "css=input[value='private']";
		final String PUBLISH_BUTTON = "css=input#_33_saveButton";
		final String CANCEL_BUTTON = "css=input#_33_cancelButton";	

		final String SUCCESS_MESSAGE = "css=div.portlet-msg-success";
		final String SEARCH_TEXTBOX = "css=div[class='portlet-toolbar search-form']>input#_33_keywords";
		final String SEARCH_BUTTON = "css=span.btn-white>input[value='Search']";
		final String TITLE_PLACEHOLDER = "css=div.entry-title";
		final String ENTRY_DATE_HOLDER = "css=div.entry-date";
		final String EDIT_BLOG_ICON = "css=img.icon[alt='Edit']";
		final String DELETE_BLOG_ICON = "css=img.icon[alt='Delete']";
		final String AUTHOR_NAME = "css=div.entry-author";
		final String COMMENTS_LINK = "css=span.comments";
		final String BOOKMARKS_LINK = "css=a.show-bookmarks";
		final String AVERAGE_VOTES_LABEL = "css=table[class='taglib-ratings stars']>tbody>tr>td>div:contains(Average)";
		final String REPORT_POST_FLAG = "css=img[alt='Report Post']";
		final String REPORT_POST_LINK = "css=a:contains(Report Post)";
		final String SEARCH_RESULTS_COUNT = "css=div.search-results";
	}

	/**
	 * ProgressAndGoalsTab interface contains locators for web elements displayed on Progress and Goals Page. 
	 * @author Jaya
	 */
	public interface ProgressAndGoalsTab {
		final String EDIT_LINK = "css=a.align-right";
		final String OVERALL_GOAL = "css=select[name='_USER_PROFILE_OVERALL_GOALS_WAR_userprofileportlet_goal']";
		final String STORY_SECTION = "css=div.story-section";
		final String WORKOUT_START_MONTH_DROPDOWN = "css=select#_USER_PROFILE_OVERALL_GOALS_WAR_userprofileportlet_workoutStartDateMonth";
		final String WORKOUT_START_DAY_DROPDOWN = "css=select#_USER_PROFILE_OVERALL_GOALS_WAR_userprofileportlet_workoutStartDateDay";
		final String WORKOUT_START_YEAR_DROPDOWN = "css=select#_USER_PROFILE_OVERALL_GOALS_WAR_userprofileportlet_workoutStartDateYear";
		final String WORKOUT_START_DATE_CALENDER = "css=img.ui-datepicker-trigger";
		final String MEASUREMENT_UNIT_DROPDOWN = "css=select[name='_USER_PROFILE_OVERALL_GOALS_WAR_userprofileportlet_metric']"; 
		final String STORY_TEXTAREA = "css=textarea[name='_USER_PROFILE_OVERALL_GOALS_WAR_userprofileportlet_transformationStory']";
		final String SAVE_BUTTON = "css=input[value='Save']";
		final String RESET_BUTTON = "css=input[value='Reset']";		
		final String SUCCESS_MESSAGE = "css=div.portlet-msg-success";

		final String STARTING_WEIGHT = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_weight']";
		final String STARTING_WAIST = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_waist']";
		final String STARTING_HIPS = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_hips']";
		final String STARTING_CHEST = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_chest']";
		final String STARTING_RIGHT_ARM = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_right-arm']";
		final String STARTING_LEFT_ARM = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_left-arm']";
		final String STARTING_RIGHT_THIGH = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_right-thigh']";
		final String STARTING_LEFT_THIGH = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_left-thigh']";
		final String STARTING_BODY_FAT_PERCENT = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_body-fat']";
		final String STARTING_CHOLESTEROL_HDL ="css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_cholesterol-hdl']";
		final String STARTING_CHOLESTEROL_LDL ="css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_cholesterol-ldl']";
		final String STARTING_BLOOD_PRESSURE_SYS = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_blood-pressure-sys']";
		final String STARTING_BLOOD_PRESSURE_DIA = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_blood-pressure-dys']";

		final String PROJECTED_WEIGHT = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_weightGoal']";
		final String PROJECTED_WAIST = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_waistGoal']";
		final String PROJECTED_HIPS = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_hipsGoal']";
		final String PROJECTED_CHEST = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_chestGoal']";
		final String PROJECTED_RIGHT_ARM = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_right-armGoal']";
		final String PROJECTED_LEFT_ARM = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_left-armGoal']";
		final String PROJECTED_RIGHT_THIGH = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_right-thighGoal']";
		final String PROJECTED_LEFT_THIGH = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_left-thighGoal']";
		final String PROJECTED_BODY_FAT_PERCENT = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_body-fatGoal']";
		final String PROJECTED_CHOLESTEROL_HDL = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_cholesterol-hdlGoal']";
		final String PROJECTED_CHOLESTEROL_LDL = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_cholesterol-ldlGoal']"; 
		final String PROJECTED_BLOOD_PRESSURE_SYS = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_blood-pressure-sysGoal']";
		final String PROJECTED_BLOOD_PRESSURE_DIA = "css=input[name='_USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_blood-pressure-dysGoal']";

		final String SUBMIT_BODY_MEASUREMENT = "css=div.portlet-content._USER_PROFILE_BODY_MEASUREMENTS_WAR_userprofileportlet_tbb-portlet-content input[type=submit]";

		final String STARTING_MORNING_RESTING_HEART_RATE = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_resting-heart-rate']";
		final String STARTING_PULL_UPS = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_pull-ups']";
		final String STARTING_VERTICAL_LEAP = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_vertical-leap']";
		final String STARTING_PUSH_UPS_FROM_TOES = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_push-ups-from-toes']";
		final String STARTING_INCHES_FROM_TOES = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_inches-from-toes']";
		final String STARTING_INS_AND_OUTS_TO_FAILURE = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_ins-and-outs-to-failure']";
		final String STARTING_SEATED_WALL_SQUAT_MIN = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_seated-wall-squat-min']";
		final String STARTING_SEATED_WALL_SQUAT_SEC = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_seated-wall-squat-sec']";
		final String STARTING_ARM_CURLS_TO_FAILURE_HASH = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_arm-curls-to-failure']";
		final String STARTING_ARM_CURLS_TO_FAILURE_BY = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_arm-curls-weight']";
		final String STARTING_HEART_RATE_MAXIMIZER_1ST = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_hr-maximizer-0-min']";
		final String STARTING_HEART_RATE_MAXIMIZER_3RD = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_hr-maximizer-2-min']";

		final String PROJECTED_MORNING_RESTING_HEART_RATE = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_resting-heart-rateGoal']";
		final String PROJECTED_PULL_UPS = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_pull-upsGoal']";
		final String PROJECTED_VERTICAL_LEAP = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_vertical-leapGoal']";
		final String PROJECTED_PUSH_UPS_FROM_TOES = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_push-ups-from-toesGoal']";
		final String PROJECTED_INCHES_FROM_TOES = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_inches-from-toesGoal']";
		final String PROJECTED_INS_AND_OUTS_TO_FAILURE = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_ins-and-outs-to-failureGoal']";
		final String PROJECTED_SEATED_WALL_SQUAT_MIN = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_seated-wall-squat-minGoal']";
		final String PROJECTED_SEATED_WALL_SQUAT_SEC = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_seated-wall-squat-secGoal']";
		final String PROJECTED_ARM_CURLS_TO_FAILURE_HASH = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_arm-curls-to-failureGoal']";
		final String PROJECTED_ARM_CURLS_TO_FAILURE_BY = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_arm-curls-weightGoal']";
		final String PROJECTED_HEART_RATE_MAXIMIZER_1ST = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_hr-maximizer-0-minGoal']";
		final String PROJECTED_HEART_RATE_MAXIMIZER_3RD = "css=input[name='_USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_hr-maximizer-2-minGoal']";
		final String SUBMIT_FITNESS_STATS = "css=div.portlet-content._USER_PROFILE_FITNESS_PROGRESSES_WAR_userprofileportlet_tbb-portlet-content > div.entry-measurements > div.clearfix > span.btn-white > input[type=submit]";
	}

	/**
	 * ProgramsTab interface contains locators for web elements displayed on Programs Page. 
	 * @author Jaya
	 */
	public interface ProgramsTab {
		final String EXPAND_ALL = "css=a.control[href='javascript:expandAll();']";
		final String CLOSE_ALL = "css=a.control[href='javascript:collapseAll();']";
		final String UPGRADE_MEMBERSHIP = "css=a[href='/signup']";

		final String FITNESS_PROGRAMS_10_MINUTE_TRAINER_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb300";
		final String FITNESS_PROGRAMS_BODY_GOSPEL_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb25001";
		final String FITNESS_PROGRAMS_BRAZIL_BUTT_LIFT_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb2800";
		final String FITNESS_PROGRAMS_CHALEAN_EXTREME_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb200";
		final String FITNESS_PROGRAMS_FAST_100_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb2200";
		final String FITNESS_PROGRAMS_GET_REAL_WITH_SHAUN_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb25101";
		final String FITNESS_PROGRAMS_GREAT_BODY_GUARANTEED_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1600";
		final String FITNESS_PROGRAMS_HIP_HOP_ABS_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb800";
		final String FITNESS_PROGRAMS_HO_ALA_KE_KINO_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1700";
		final String FITNESS_PROGRAMS_INSANITY_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb2500";
		final String FITNESS_PROGRAMS_INSANITY_THE_ASYLUM_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb25201";
		final String FITNESS_PROGRAMS_KATHY_SMITH_FITNESS_PROGRAMS_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb2100";
		final String FITNESS_PROGRAMS_KATHY_SMITHS_PROJECT_YOU_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1200";
		final String FITNESS_PROGRAMS_KEEP_IT_UP_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1800";
		final String FITNESS_PROGRAMS_P90X_ONE_ON_ONE_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb400";
		final String FITNESS_PROGRAMS_POWER90X_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb100";
		final String FITNESS_PROGRAMS_POWER_90_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb700";
		final String FITNESS_PROGRAMS_POWER_HALF_HOUR_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1400";
		final String FITNESS_PROGRAMS_REVABS_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb2700";
		final String FITNESS_PROGRAMS_ROCKIN_BODY_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb500";
		final String FITNESS_PROGRAMS_SHAKEOLOGY_THE_WORKOUTS_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb2600";
		final String FITNESS_PROGRAMS_SLIM_IN_6_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb600";
		final String FITNESS_PROGRAMS_SLIM_SERIES_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1500";
		final String FITNESS_PROGRAMS_TONY_AND_THE_FOLKS_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb2000";
		final String FITNESS_PROGRAMS_TONY_AND_THE_KIDS_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1900";
		final String FITNESS_PROGRAMS_TOTAL_BODY_SOLUTION_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1300";
		final String FITNESS_PROGRAMS_TURBO_JAM_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb900";
		final String FITNESS_PROGRAMS_TURBO_FIRE_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb25102";
		final String FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_BABY_ON_THE_WAY_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb2400";
		final String FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_PURE_AND_SIMPLE_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb2300";
		final String FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1000";
		final String FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_AB_AND_BUTT_MAKEOVER_CHECKBOX = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_cb1100";

		final String FITNESS_PROGRAMS_I_DONT_HAVE_A_PRIMARY_PROGRAM = "css=input[value='0']";
		final String FITNESS_PROGRAMS_10_MINUTE_TRAINER_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r300";
		final String FITNESS_PROGRAMS_BODY_GOSPEL_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r25001";
		final String FITNESS_PROGRAMS_BRAZIL_BUTT_LIFT_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r2800";
		final String FITNESS_PROGRAMS_CHALEAN_EXTREME_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r200";
		final String FITNESS_PROGRAMS_FAST_100_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r2200";
		final String FITNESS_PROGRAMS_GET_REAL_WITH_SHAUN_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r25101";
		final String FITNESS_PROGRAMS_GREAT_BODY_GUARANTEED_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1600";
		final String FITNESS_PROGRAMS_HIP_HOP_ABS_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r800";
		final String FITNESS_PROGRAMS_HO_ALA_KE_KINO_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1700";
		final String FITNESS_PROGRAMS_INSANITY_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r2500";
		final String FITNESS_PROGRAMS_INSANITY_THE_ASYLUM_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r25201";
		final String FITNESS_PROGRAMS_KATHY_SMITH_FITNESS_PROGRAMS_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r2100";
		final String FITNESS_PROGRAMS_KATHY_SMITHS_PROJECT_YOU_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1200";
		final String FITNESS_PROGRAMS_KEEP_IT_UP_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1800"; 
		final String FITNESS_PROGRAMS_P90X_ONE_ON_ONE_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r400";
		final String FITNESS_PROGRAMS_P90X_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r100";
		final String FITNESS_PROGRAMS_POWER90_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r700";
		final String FITNESS_PROGRAMS_POWER_HALF_HOUR_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1400";
		final String FITNESS_PROGRAMS_REVABS_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r2700";
		final String FITNESS_PROGRAMS_ROCKIN_BODY_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r500";
		final String FITNESS_PROGRAMS_SHAKEOLOGY_THE_WORKOUTS_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r2600";
		final String FITNESS_PROGRAMS_SLIM_IN_6_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r600";
		final String FITNESS_PROGRAMS_SLIM_SERIES_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1500";
		final String FITNESS_PROGRAMS_TONY_AND_THE_FOLKS_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r2000";
		final String FITNESS_PROGRAMS_TONY_AND_THE_KIDS_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1900";
		final String FITNESS_PROGRAMS_TOTAL_BODY_SOLUTION_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1300";
		final String FITNESS_PROGRAMS_TURBO_JAM_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r900";
		final String FITNESS_PROGRAMS_TURBO_FIRE_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r25102";
		final String FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_BABY_ON_THE_WAY_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r2400";
		final String FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_PURE_AND_SIMPLE_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r2300";
		final String FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1000";
		final String FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_AB_AND_BUTT_MAKEOVER_RADIO_BUTTON = "css=input#_USER_PROFILE_PROGRAMS_WAR_userprofileportlet_r1100";

		final String ACTIVITIES_BIKING_CHECKBOX = "css=input[value='10400']";
		final String ACTIVITIES_CARDIO_AEROBICS_CHECKBOX = "css=input[value='10100']";
		final String ACTIVITIES_RUNNING_WALKING_CHECKBOX = "css=input[value='10000']";
		final String ACTIVITIES_SWIMMING_CHECKBOX = "css=input[value='10500']";
		final String ACTIVITIES_WEIGHTLIFTING_CHECKBOX = "css=input[value='10300']";
		final String ACTIVITIES_YOGA_PILATES_CHECKBOX = "css=input[value='10200']";

		final String GEAR_P90X_CHIN_UP_BAR_CHECKBOX = "css=input[value='G100']";
		final String GEAR_HEART_RATE_MONITOR_CHECKBOX = "css=input[value='G300']";
		final String GEAR_PUSH_UP_STANDS_CHECKBOX = "css=input[value='G400']";
		final String GEAR_RESISTANCE_BANDS_CHECKBOX = "css=input[value='G500']";
		final String GEAR_POWER_STANDS_CHECKBOX = "css=input[value='G600']"; 
		final String GEAR_WEIGHTED_GLOVES_CHECKBOX = "css=input[value='G700']";

		final String SUPPLEMENTS_SHAKEOLOGY_CHECKBOX = "css=input[value='S100']";
		final String SUPPLEMENTS_ACTIVIT_MULTI_VITAMINS_CHECKBOX = "css=input[value='S1000']";
		final String SUPPLEMENTS_MEAL_REPLACEMENT_SHAKE_CHECKBOX = "css=input[value='S1100']";
		final String SUPPLEMENTS_WHEY_PROTEIN_POWDER_CHECKBOX = "css=input[value='S1200']";
		final String SUPPLEMENTS_JOINT_SUPPORT_SUPER_FORMULA_CHECKBOX = "css=input[value='S1300']";
		final String SUPPLEMENTS_PURE_CREATINE_CHECKBOX = "css=input[value='S1400']";
		final String SUPPLEMENTS_P90X_PEAK_HEALTH_FORMULA_CHECKBOX = "css=input[value='S200']";
		final String SUPPLEMENTS_P90X_PEAK_RESULTS_AND_RECOVERY_FORMULA_CHECKBOX = "css=input[value='S300']";
		final String SUPPLEMENTS_2_DAY_FAST_FORMULA_CHECKBOX = "css=input[value='S400']";
		final String SUPPLEMENTS_TOTAL_HEALTH_WOMENS_FORMULA_CHECKBOX = "css=input[value='S500']";
		final String SUPPLEMENTS_STRENGTH_AND_MUSCLE_MENS_FORMULA_CHECKBOX = "css=input[value='S600']";
		final String SUPPLEMENTS_SLIMMING_FORMULA_CHECKBOX = "css=input[value='S700']";
		final String SUPPLEMENTS_PERFORMANCE_FORMULA_CHECKBOX = "css=input[value='S800']";
		final String SUPPLEMENTS_CHITOSAN_PLUS_CHECKBOX = "css=input[value='S900']";

		final String SAVE_BUTTON = "css=input[value='Save']";
		final String RESET_BUTTON = "css=input[value='Reset']";
	}

	/**
	 * GroupsTab interface contains locators for web elements displayed on Groups Page. 
	 * @author Jaya
	 */
	public interface GroupsTab{
		final String WORKOUT_GROUPS_LINK = "css=a[href='/get-fit/supergym/workout-groups']";
		final String LEAVE_SELECTED_GROUPS = "css=input[value='Leave selected Groups']";
		final String RESET = "css=input[value='Reset']";
		final String POWERHOUSE_CHECKBOX = "css=input#_USER_PROFILE_MY_WORKOUT_GROUPS_WAR_userprofileportlet_groups[value='10828616']";
		final String BRAZIL_BUTT_CHECKBOX = "css=input#_USER_PROFILE_MY_WORKOUT_GROUPS_WAR_userprofileportlet_groups[value='60479216']";
	}

	/**
	 * PrivacyTab interface contains locators for web elements displayed on Privacy Page. 
	 * @author Jaya
	 */
	public interface PrivacyTab {
		final String SUCCESS_MESSAGE = "css=div.portlet-msg-success";

		final String PUBLIC_RADIO_BUTTON = "css=input[value='public'][name='VIEW_PROFILE']";
		final String BUDDIES_RADIO_BUTTON = "css=input[value='buddy'][name='VIEW_PROFILE']";
		final String PRIVATE_RADIO_BUTTON = "css=input[value='private'][name='VIEW_PROFILE']";

		final String EXPAND_ALL_LINK = "css=a.control[href='javascript:expandAll();']";
		final String CLOSE_ALL_LINK = "css=a.control[href='javascript:collapseAll();']";

		final String LOCATION_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_BASIC_LOCATION']";
		final String LOCATION_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_BASIC_LOCATION']";
		final String LOCATION_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_BASIC_LOCATION']";

		final String PERSONAL_BIO_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_BASIC_BIO']";
		final String PERSONAL_BIO_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_BASIC_BIO']";
		final String PERSONAL_BIO_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_BASIC_BIO']";

		final String BLOG_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_BLOG']";
		final String BLOG_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_BLOG']";
		final String BLOG_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_BLOG']";

		final String OVERALL_GOAL_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRESS_OVERALL_GOAL']";
		final String OVERALL_GOAL_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRESS_OVERALL_GOAL']";
		final String OVERALL_GOAL_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRESS_OVERALL_GOAL']";

		final String TRANSFORMATION_STORY_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRESS_TRANSFORMATION_STORY']";
		final String TRANSFORMATION_STORY_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRESS_TRANSFORMATION_STORY']";
		final String TRANSFORMATION_STORY_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRESS_TRANSFORMATION_STORY']";

		final String MEAL_PLANS_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_MEAL_PLAN']"; 
		final String MEAL_PLANS_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_MEAL_PLAN']";
		final String MEAL_PLANS_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_MEAL_PLAN']";

		final String FITNESS_PROGRAMS_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_FITNESS']";
		final String FITNESS_PROGRAMS_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_FITNESS']";
		final String FITNESS_PROGRAMS_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_FITNESS']";

		final String GEAR_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_GEAR']";
		final String GEAR_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_GEAR']";
		final String GEAR_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_GEAR']";

		final String SUPPLEMENTS_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_SUPPLEMENT']";
		final String SUPPLEMENTS_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_SUPPLEMENT']";
		final String SUPPLEMENTS_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PROGRAM_SUPPLEMENT']";

		final String BEFORE_AND_AFTER_PHOTOS_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PHOTO_BEFORE_AFTER']";
		final String BEFORE_AND_AFTER_PHOTOS_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PHOTO_BEFORE_AFTER']";
		final String BEFORE_AND_AFTER_PHOTOS_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PHOTO_BEFORE_AFTER']";

		final String PHOTO_GALLERY_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PHOTO_GALLERY']";
		final String PHOTO_GALLERY_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PHOTO_GALLERY']";
		final String PHOTO_GALLERY_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_PHOTO_GALLERY']";

		final String WORKOUT_BUDDIES_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_SOCIAL_BUDDY']";
		final String WORKOUT_BUDDIES_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_SOCIAL_BUDDY']";
		final String WORKOUT_BUDDIES_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_SOCIAL_BUDDY']";

		final String WORKOUT_GROUPS_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_SOCIAL_GROUP']";
		final String WORKOUT_GROUPS_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_SOCIAL_GROUP']";
		final String WORKOUT_GROUPS_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_SOCIAL_GROUP']";

		final String NEXT_WORKOUT_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_NEXT_WORKOUT']";
		final String NEXT_WORKOUT_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_NEXT_WORKOUT']";
		final String NEXT_WORKOUT_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_NEXT_WORKOUT']";

		final String WORKOUT_SCHEDULE_PUBLIC_RADIO_BUTTON = "css=input.public[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_WORKOUT_SCHEDULE']";
		final String WORKOUT_SCHEDULE_BUDDIES_RADIO_BUTTON = "css=input.buddy[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_WORKOUT_SCHEDULE']";
		final String WORKOUT_SCHEDULE_PRIVATE_RADIO_BUTTON = "css=input.private[name='_USER_PROFILE_PRIVACY_WAR_userprofileportlet_VIEW_WORKOUT_SCHEDULE']";

		final String SAVE_BUTTON = "css=input[value='Save']";
		final String RESET_BUTTON = "css=input[value='Reset']";
	}

	/**
	 * Home interface contains locators for web elements displayed on web site Home Page. 
	 * @author Gaurav
	 */
	public interface Home {
		final String SIGN_IN_LINK = "css=a:contains(Sign In)";
		final String PROFILE_LINK = "css=a.profile";
		final String SIGNOUT_LINK = "css=a[href='/c/portal/logout']";
		final String MY_DASHBOARD_DOCK_TITLE = "css=div#userdock-area-1 > div > table > tbody > tr > td.cc > div > div.userdock-info";
		final String INBOX_DOCK_TITLE= "css=div#userdock-area-2 > div > table > tbody > tr > td.cc > div.userdock-title";
		final String BUDDIES_DOCK_TITLE = "css=div#userdock-area-3 > div > table > tbody > tr > td.cc > div.userdock-title";
		final String WORKOUTS_DOCK_TITLE = "css=div#userdock-area-4 > div > table > tbody > tr > td.cc > div.userdock-title";
		final String USER_MESSAGE_DOCK_TITLE = "css=div#userdock-area-5 > div > table > tbody > tr > td.cc > div.userdock-message-title";
		final String GOAL_TRACKER_DOCK_TITLE  = "css=div#userdock-area-6 > div > table > tbody > tr > td.cc > div > div.userdock-title";
		final String SITE_DESCRIPTION = "css=div.site-desc-home";
		final String CURRENT_DATE = "css=div.current-time-text";
		final String TIKCER = "css=div#ticker-wrapper";
		final String NEWSLETTER_PORTLETS_SECTION = "css=div.journal-content-article > div#hp_option_sect";
		final String NEWSLETTER_SHOP_PORTLET = "css=div#shop > div.corners_side > div > h2";
		final String NEWSLETTER_EAT_PORTLET = "css=div#eat > div.corners_side > div > h2";
		final String NEWSLETTER_FIT_PORTLET = "css=div#fit > div.corners_side > div > h2";
		final String VIDEO_PORTLET_SECTION = "css=div.portlet-boundary.portlet-boundary_BRIGHTCOVE_DYNAMIC_WAR_cmsbasedportlet_";
		final String WHATSNEW_PORTLET_SECTION = "css=div.journal-content-article > div#hp_whatsnew_sect";
		final String HOT_TOPICS_PORTLET_SECTION = "css=div.discussion-board";
		final String DAILY_WINNER_PORTLET = "css=div#portlet-wrapper-CONTEST_DAILY_LATEST_WAR_contestportlet";
		final String SHAKEOLOGY_PORTLET = "css=div#left_rail_recipes";
		final String COACH_CLUB_UPSELL_LRM_PORTLET = "css=div#p_p_id_56_INSTANCE_N7i2_";
		final String FEATURED_PRODUCTS_PORTLET = "css=div#p_p_id_56_INSTANCE_y47Y_";
		final String SUCCESS_STORIES_PORTLET = "css=div#p_p_id_56_INSTANCE_c7D7_";
		final String COACH_CLUB_UPSELL_RRM_PORTLET = "css=div#p_p_id_56_INSTANCE_g5DE_";
		final String INBOX_DOCK_LINK = "css=div#userdock-area-2 td.cc > div.userdock-title";
		final String INBOX_MESSAGE_CENTER_LINK = "css=div#userdock-area-2 td.cc > div.clear.hidden > p";
		//final String INBOX_GO_TO_INBOX_LINK = "css=div#userdock-area-2 td.cc > div.clear.hidden > div > a";
		final String INBOX_GO_TO_INBOX_LINK = "css=div.userdock-info > a:contains(Go to Inbox)";
		final String BUDDIES_DOCK_LINK = "css=div#userdock-area-3 td.cc > div.userdock-title";
		final String BUDDIES_FIND_NEW_BUDDIES_LINK = "css=div#userdock-area-3 td.cc > div.clear.hidden > p > a";
		final String BUDDIES_VIEW_MY_BUDDY_INVITATIONS_LINK = "css=div#userdock-area-3 td.cc > div.clear.hidden > p > a ~ a";
		final String BUDDIES_VIEW_MY_BUDDIES_LINK = "css=div#userdock-area-3 td.cc > div.clear.hidden  > div";
		final String WORKOUT_DOCK_LINK = "css=div#userdock-area-4 td.cc > div.userdock-title";
		final String WORKOUT_SCHEDULE_A_WORKOUT_LINK = "css=div#userdock-area-4 td.cc > div.clear.hidden > p > a";
		final String WORKOUT_GO_TO_SUPERGYM_LINK = "css=div#userdock-area-4 td.cc > div.clear.hidden  > div";
		final String GOAL_TRACKER_DOCK_LINK = "css=div#userdock-area-6 td.cc div.userdock-title";
		final String GOAL_TRACKER_GO_TO_GOALS_LINK = "css=div#userdock-area-6 td.cc > div.hidden  div.userdock-info";
		
		final String TBB_LOGO = "css=div#banner > h1.logo > a";
		final String HELP_FAQ_LINK = "css=a:contains(Help/FAQs)";
		
		final String SIGN_UP_LINK = "css=a[href=/signup]";
	}

	/**
	 * Dashboard interface contains locators for web elements displayed on web site Dashboard Page. 
	 * @author Gaurav
	 */
	public interface Dashboard {
		final String START_UP_WIZARD = "css=a:contains(Start Up Wizard)";
		final String MY_ACCOUNT_LINK = "css=li.my-account>a";
		final String HOME_LINK = "css=a:contains(Home)";
		final String PROFILE_LINK = "css=a.profile";
		final String LINK_ACCOUNT = "css=a.fb-link-account";
		
		final String HIGHLIGHTED_DATE_TAB = "css=div.supergym-mywo-calendar-tab-active";
		final String SCHEDULED_WORKOUTS_TEXT = "css=div#supergym-mywo-calendar-workout-lists a";
		final String PROGRAMS_SELECT = "css=select#supergym-mywo-calendar-one-click-program";
		final String ROUTINES_SELECT = "css=select#supergym-mywo-calendar-one-click-routine";
		final String BUDDIES_IMAGE = "//div[@class='buddies-carousel']//div[@class='photo-small']";
		final String BUDDY_NAME = "xpath=//div[@class=\"column photo-item\"]";
		final String RECENT_MESSAGE = "//div[@class='discussion-board']//p";

		final String WORKOUT_BUTTON = "css=a#supergym-mywo-calendar-start-now-btn";
		final String BECOME_A_CLUB_MEMBER_LINK = "css=a[href=/signup]:contains(Become a Club Member)";
		final String GO_TO_MY_MEAL_PLANNER = "css=input[value='Go to My Meal Planner']";
		final String CHANGE_MY_MEAL_PLAN_LINK = "css=a:contains(Change my meal plan)";
		final String GO_TO_MESSAGE_BOARD_LINK = "css=a[href=/connect/message-boards]:contains(Go to the Message Boards)";

		final String RIGHT_RAIL_MODULE = "//div[@id='layout-column_column-5']/div";
		final String RIGHT_RAIL_MODULE_1_TITLE = "css=div#layout-column_column-5 > div:nth(0) div.title > span";
		final String RIGHT_RAIL_MODULE_1_TEXT = "css=div#layout-column_column-5 > div:nth(0) div.rp_coach > div > p";
		final String RIGHT_RAIL_MODULE_2_TITLE = "css=div#layout-column_column-5 > div:nth(1) div.title > span";
		final String RIGHT_RAIL_MODULE_2_TEXT = "css=div#layout-column_column-5 > div:nth(1) div.right-rail-content";
		final String RIGHT_RAIL_MODULE_3_TITLE = "css=div#layout-column_column-5 > div:nth(2) div.title > span";
		final String RIGHT_RAIL_MODULE_3_TEXT = "css=div#layout-column_column-5 > div:nth(2) div.right-rail-content";

		final String COACH_LINK = "//div[@id='navigation']/ul/li[7]/a/span";
		final String COACH_COACH_FAQ_LINK = "//div[@id='navigation']/ul/li[7]/ul[@class='child-menu']/li";
		final String CLUB_UK_USER_ALERT = "css=span.portlet-msg-error";		
		
		final String GET_FIT_LINK = "css=a:contains(Get Fit)";
		final String EAT_SMART_MENU_LINK = "css=a>span:contains(Eat Smart)";		
		final String CONNECT_MENU_LINK = "css=a>span:contains(Connect)";
		final String WATCH_VIDEOS_MENU_LINK = "css=a:contains(Watch Videos)";
		final String ABOUT_MENU_LINK = "css=a>span:contains(About)";
		final String COACH_MENU_LINK = "css=a>span:contains(Coach)";
		final String SHOP_MENU_LINK = "css=a>span:contains(Shop)";
		
		final String MY_MEAL_PLANNER_MENU_LINK = "css=a:contains(My Meal Planner)";
		final String RECIPES_MENU_LINK = "css=a:contains(Recipes)";		
		
		final String DASHBOARD_PROGRAM_RRM_SECTION = "//div[@id='layout-column_column-5']/div";
		final String DASHBOARD_PROGRAM_RRM_TITLE = "//div[@class='title']//span";		
	}

	/**
	 * SignIn interface contains locators for web elements displayed on Sign In Page.  
	 * @author Jaya
	 */
	public interface SignIn{
		final String USERNAME_TEXTBOX = "css=input[name='_58_login']";
		final String PASSWORD_TEXTBOX = "css=input[id='_58_password']";
		final String SIGN_IN_BUTTON = "css=input[value='Sign In']";
	}
	
	/**
	 * Inbox interface contains locators for web elements displayed on Inbox Page. 
	 * @author Gaurav
	 */
	public interface Inbox {
		final String INBOX_LINK = "css=span + a:contains(Inbox)";
		final String DRAFTS_LINK = "css=a:contains(Drafts)";
		final String SENT_MESSAGES_LINK = "css=a:contains(Sent Messages)";
		final String TRASH_LINK = "css=a:contains(Trash)";
		final String COMPOSE_MESSAGE_LINK = "css=div.compose-message:contains(Compose Message)";
		final String COMPOSE_MESSAGE_DISCARD_BUTTON = "css=input[value=Discard]";

		final String SELECT_ALL = "css=a.select-all";
		final String SELECT_NONE = "css=a.select-none";
		final String SELECT_READ = "css=a.select-read";
		final String SELECT_UNREAD = "css=a.select-unread";

		final String MESSAGE_ROW = "//table[@id='_1_WAR_mailportlet_message-list']/tbody/tr";
		final String READ_MESSAGE_ROW = "//tr[@class='message results-row alt read']";
		final String UNREAD_MESSAGE_ROW = "//tr[@class='message results-row unread']";

		final String COMPOSE_MESSAGE_SEND_TO_TEXTAREA = "css=textarea#_1_WAR_mailportlet_sendTo"; 
		final String COMPOSE_MESSAGE_SEND_SUBJECT_TEXTBOX = "css=input#_1_WAR_mailportlet_sendSubject";
		final String COMPOSE_MESSAGE_SEND_BUTTON = "css=input.send";
	}

	/**
	 * GetFit interface contains locators for web elements displayed on Get Fit Page. 
	 * @author Gaurav
	 */
	public interface GetFit {
		final String NAV_MENU_GET_FIT_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Get Fit)";
		final String NAV_MENU_WOWY_SUPERGYM_LINK = "css=div.nav-menu.nav-menu-style- a:contains(WOWY SuperGym™)";
		final String NAV_MENU_FITNESS_TOOLS_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Fitness Tools)";
		final String NAV_MENU_FITNESS_PROGRAMS = "css=div.nav-menu.nav-menu-style- a:contains(Fitness Programs)";
		final String NAV_MENU_FITNESS_TIPS = "css=div.nav-menu.nav-menu-style- a:contains(Fitness Tips)";
		final String NAV_MENU_TRAINERS = "css=div.nav-menu.nav-menu-style- a:contains(Trainers)";
		final String NAV_MENU_WORKOUT_SHEETS = "css=div.nav-menu.nav-menu-style- a:contains(Workout Sheets)";
		final String NAV_MENU_WORKOUT_GROUPS = "css=div.nav-menu.nav-menu-style- a:contains(Workout Groups)";

		final String NAV_MENU_ITEMS = "//div[@class='nav-menu nav-menu-style-']//ul[@class='layouts level-1']//li";
		final String NAV_MENU_ITEMS_TEXT_XPATH = "xpath=//div[@class=\"nav-menu nav-menu-style-\"]//ul[@class=\"layouts level-1\"]/li";

		final String WOWY_SUPERGYM_CONTENT_LEARN_MORE_LINK = "css=div#cont_sub_content h2:contains(WOWY SuperGym™) ~ p > a:contains(Learn more)";
		final String FITNESS_TOOLS_CONTENT_LEARN_MORE_LINK = "css=div#cont_sub_content h2:contains(Fitness Tools) ~ p > a:contains(Learn more)";
		final String FITNESS_PROGRAMS_CONTENT_LEARN_MORE_LINK = "css=div#cont_sub_content h2:contains(Fitness Programs) ~ p > a:contains(Learn more)";
		final String FITNESS_TIPS_CONTENT_LEARN_MORE_LINK = "css=div#cont_sub_content h2:contains(Fitness Tips) ~ p > a:contains(Learn more)";
		final String TRAINERS_CONTENT_LEARN_MORE_LINK = "css=div#cont_sub_content h2:contains(Trainers) ~ p > a:contains(Learn more)";

		final String CONTENT_LINK_ITEMS = "//div[@id='cont_sub_content']/ul/li";
		final String CONTENT_HEADER = "css=div#cont_sub_hdr";
		final String CONTENT_HEADER_HEADING = "css=div#cont_sub_hdr > h1";
		final String CONTENT_HEADER_USER_QUOTE = "css=p.hdr_quote";
		final String CONTENT_HEADER_USER_STAT = "css=div#cont_sub_hdr p.hdr_quote span.user_stats";

		final String CONTENT_HEADER_FEARURED_LINKS = "//div[@id='cont_sub_hdr']//ul//li";
		final String GETFIT_PROGRAM_RRM_SECTION = "//div[@id='layout-column_column-6']/div";
		final String GETFIT_PROGRAM_RRM_TITLE = "//div[@class='title']//span";	
	}
	
	/**
	 * WorkoutGroupDetail interface contains locators for web elements displayed on Workout Group Detail Page. 
	 * @author Jaya
	 */
	public interface WorkoutGroupDetail{
		final String JOIN_THIS_GROUP = "css=input#supergym-group-detail-join-group-btn";
		final String CLOSE = "css=#supergym-group-details-success-close-btn > span";
		final String PROFILE_LINK = "css=a.profile";
	}	

	/**
	 * WorkoutGroups interface contains locators for web elements displayed on Workout Groups Page. 
	 * @author Jaya
	 */
	public interface WorkoutGroups{
		final String SEE_ALL_GROUPS_LINK = "css=span#supergym-most-active-groups-see-all-link";
	}

	/**
	 * WorkoutGroupsSearch interface contains locators for web elements displayed on Workout Groups Search Page. 
	 * @author Jaya
	 */
	public interface WorkoutGroupsSearch{
		final String POWERHOUSE_MORE_LINK = "css=a[href='/get-fit/supergym/workoutgroup/detail?group=10828616']:contains(More)";
		final String BRAZIL_BUTTS_MORE_LINK = "css=a[href='/get-fit/supergym/workoutgroup/detail?group=60479216']:contains(More)";
	}

	/**
	 * Buddies interface contains locators for web elements displayed on Buddies Page. 
	 * @author Jaya
	 */
	public interface Buddies{
		final String SEARCH_MY_BUDDIES_TEXTBOX = "css=input.text[name='_2_WAR_tbbsocialportlet_keywords']";
		final String SEARCH_MY_BUDDIES_BUTTON = "css=input[value='Search my Buddies']";
		final String REMOVE_SELECTED_BUDDIES_BUTTON = "css=input[value='Remove selected Buddies']";
		final String YES_BUTTON = "css=input.button[value='Yes']";
		final String SEARCH_MEMBERS_TEXTBOX = "css=input.text#_membergallerysearch_WAR_membergalleryportlet_keywords";
		final String SEARCH_BUTTON = "css=input[type='submit'][value='Search']";
		final String BUDDY_PHOTO = "css=div.friend";
		final String SELECT_BUDDY_CHECKBOX = "css=div.column>input[name='deletes']";
	}

	/**
	 * Workout interface contains locators for web elements displayed on Workout Page. 
	 * @author Gaurav
	 */
	public interface Workout {

		final String NEXT_WORKOUT_MESSAGE = "You currently do not have a workout scheduled for today";
		final String NEXT_WORKOUT_WELCOME_MESSAGE = "css=div#no-workouts-content-wrapper div#supergym-mywo-date-wrapper div ~ div"; 
		final String NEXT_WORKOUT_SCHEDULE_A_WORKOUT_BUTTON = "css=div#supergym-my-workouts-action-buttons-wrapper > a#schedule-workout-btn";
		final String NEXT_WORKOUT_ADD_A_FULL_PROGRAM_SCHEDULE_BUTTON = "css=div#supergym-my-workouts-action-buttons-wrapper > a#preset-schedule-workout-btn";

		final String NEXT_WORKOUT_DETAIL = "css=div#workout-name";
		final String NEXT_WORKOUT_TIME = "css=div.supergym-mywo-time-buddies-wrapper > span#workout-time";
		final String NEXT_WORKOUT_DATE = "css=div.supergym-mywo-time-buddies-wrapper > span#workout-date";
		final String NEXT_WORKOUT_NAVIGATION_NEXT =  "css=div.navigation#next-image";
		final String NEXT_WORKOUT_NAVIGATION_PREVIOUS =  "css=div.navigation#previous-image";
		final String NEXT_WORKOUT_SCHEDULED_WORKOUTS_COUNT_FOR_SELECTED_DATE = "css=div#number-of-wo-scheduled-container";

		final String MY_WORKOUT_CALENDER_WOWY_SUPERGYM_TIME = "css=span#supergym-server-clock";
		final String MY_WORKOUT_CALENDER_LOCAL_TIME = "css=span#supergym-local-clock";
		final String MY_WORKOUT_CALENDAR_PROGRAM_SELECT = "css=select#supergym-mywo-dropdowns-selected-program";
		final String MY_WORKOUT_CALENDAR_ROUTINE_SELECT = "css=select#supergym-mywo-dropdowns-selected-routine";
		final String MY_WORKOUT_CALENDAR_START_NOW_BUTTON = "css=div#supergym-mywo-start-btn-wrapper  span:contains(Start now)";
		final String MY_WORKOUT_CALENDAR_EDIT_WORKOUT_PREFERNCES_LINK = "css=a#edit-wo-preferences-link";

		final String MY_WORKOUT_CALENDAR_SCHEDULE_A_WORKOUT_LINK = "css=a:contains(Schedule a workout)";
		final String MY_WORKOUT_CALENDAR_ADD_A_NEW_AUTO_SCHEDULE_LINK = "css=a:contains(Add a new auto-schedule)";
		final String MY_WORKOUT_CALENDAR_ADD_A_COMPLETED_WORKOUT_LINK = "css=a:contains(Add a completed workout)";
		final String MY_WORKOUT_CALENDAR_WORK_OUT_NOW_LINK  = "css=a:contains(Work out now)";

		final String MY_WORKOUT_CALENDAR_SCHEDULED_WORKOUTS = "css=span#supergym-calendar-scheduled-num";
		final String MY_WORKOUT_CALENDAR_SUPERGYM_WORKOUTS_COMPLETED = "css=span#supergym-calendar-completed-num";
		final String MY_WORKOUT_CALENDAR_OTHER_WORKOUTS_COMPLETED  = "css=span#supergym-calendar-non-recorded-num";

		final String MY_WORKOUT_CALENDAR_WEEKDAY_SELECTED_DATE = "css=td.weekday.supergym-calendar-today > div > a";
		final String MY_WORKOUT_CALENDAR_WEEKEND_SELECTED_DATE = "css=td.weekend.supergym-calendar-today > div > a";

		final String STAT_TOTAL_WORKOUTS_COMPLETED_TODAY = "//div[@id='odo-workouts-completed']";
		final String STAT_TODAY_PEAK = "//div[@id='odo-peak-today']";
		final String STAT_PEOPLE_COUNT_WORKING_OUT_NOW = "//div[@id='odo-people-working-out-now']";
		/*	final String STAT_TOTAL_WORKOUTS_COMPLETED_TODAY = "css=table.supergym-stats-dash-dotted-line-bottom tr:nth(1) td div";
		final String STAT_TODAY_PEAK = "css=table.supergym-stats-dash-dotted-line-bottom tr:nth(2) td div";
		final String STAT_PEOPLE_COUNT_WORKING_OUT_NOW = "css=table.supergym-stats-dash-dotted-line-bottom tr:nth(3) td div";*/
		final String STAT_MORE_STATISTICS_LINK = "css=a:contains(More statistics)";

	}

	/**
	 * WhosWorkingOut interface contains locators for web elements displayed on Who's Working out Page. 
	 * @author Gaurav
	 */
	public interface WhosWorkingOut {
		final String BUDDIES_COUNT = "css=div.supergym-wo-progress-time-info" ;
		final String SELECTED_PROGRAM_ROUTINE = "css=div#supergym-wo-progress-routines-info > div";
		final String WOWY_SUPERGYM_LINK = "css=a:contains(WOWY SuperGym™)";	
		final String FINISHED_BUTTON = "css=input[value=Finished]";
	}

	/**
	 * WOWYSuperGymStats interface contains locators for web elements displayed on WOWY Super Gym Stats Page.
	 * @author Gaurav
	 */
	public interface WOWYSuperGymStats{
		final String RECENT_TOP_SUPERGYM_USER = "//div[@id='supergym-stats-top-users-inner-wrapper']/div";
		final String GO_TO_MEMBER_GALLERY_LINK = "css=a:contains(Go to Member Gallery)";
		final String TOP_WORKOUT_GROUP = "//td[@class='supergym-top-groups-image-cell']";
		final String FIND_MORE_GROUPS_LINK = "css=a:contains(Find more groups)";

		final String TEAM_BEACHBODY_PROGRAM = "//div[@id='supergym-top-programs']/div[@class='program-container']/div";
		final String SEE_ALL_PROGRAMS_LINK = "css=a:contains(See all programs)";

		final String NAV_MENU_WOWY_SUPERGYM_LINK = "css=a:contains(WOWY SuperGym™)";
		final String NAV_MENU_SCHEDULE_WORKOUT_LINK = "css=a:contains(Schedule Workout)";
		final String NAV_MENU_WHOS_WORKING_OUT_LINK = "css=a:contains(Who's Working Out)";
		final String NAV_MENU_AUTO_SCHEDULE_LINK = "css=a:contains(Auto-Schedule)";

		final String STAT_TOTAL_WORKOUTS_COMPLETED_TODAY = "css=table.supergym-stats-dash-dotted-line-bottom tr:nth(1) td div";
		final String STAT_TODAY_PEAK = "css=table.supergym-stats-dash-dotted-line-bottom tr:nth(2) td div";
		final String STAT_PEOPLE_COUNT_WORKING_OUT_NOW = "css=table.supergym-stats-dash-dotted-line-bottom tr:nth(3) td div";

		final String RECENT_FIRST_TOP_USER = "css=div#supergym-stats-top-users-inner-wrapper > div div";
		final String RECENT_TOP_USER_PROFILE_POP_UP_ADD_AS_A_BUDDY_BUTTON = "css=div.profile-table.popup div.main-profile-info span:contains(Add as a Buddy)";
		final String RECENT_TOP_USER_PROFILE_POP_UP_NO_BUTTON = "css=div form a.btn-white span:contains(No)";
	}

	/**
	 * ScheduleWorkout interface contains locators for web elements displayed on Schedule Workout Page.
	 * @author Gaurav
	 */
	public interface ScheduleWorkout {
		final String STEP1_PROGRAM_SELECT = "css=select#supergym-wo-schedule-routines-programs";
		final String STEP1_ROUTINE_SELECT = "css=select#supergym-wo-schedule-routines-select"; 
		final String STEP1_ADD_TO_SESSION_BUTTON = "css=input#supergym-wo-schedule-routines-add"; 
		final String STEP1_DELETE_LINK =  "css=a:contains(Delete)";
		final String STEP1_CANCEL_BUTTON =  "css=input#supergym-wo-schedule-routines-cancel-btn";
		final String STEP1_CONTINUE_BUTTON =  "css=input#supergym-wo-schedule-routines-continue-btn";

		final String STEP2_START_DATE_YEAR = "css=select.ui-datepicker-new-year";
		final String STEP2_START_DATE_MONTH = "css=select.ui-datepicker-new-month";
		//final String STEP2_START_DATE_DAY =  "css=a:contains(date)";
		final String STEP2_START_TIME_SELECT = "css=select#supergym-wo-buddies-time-start"; 
		final String STEP2_REPEAT_SELECT =  "css=select#supergym-wo-buddies-time-repeats";
		final String STEP2_WORKOUT_BUDDY_CHECK_BOX = "css=table#supergym-wo-buddies-time-results tr:contains(Buddy_Name) input "; 
		final String STEP2_WORKOUT_INVITATION_MESSAGE =  "css=textarea#supergym-wo-buddies-invite-message-input";
		final String STEP2_REVIEW_AND_CONFIRM_BUTTON =  "css=input#supergym-wo-buddies-time-continue-btn";
		final String STEP2_CANCEL_BUTTON =  "css=input#supergym-wo-buddies-time-cancel-btn";
		final String STEP2_BACK_TO_ROUTINES_BUTTON = "css=input#supergym-wo-buddies-time-back-btn";

		final String STEP3_EDIT_LINK = "css=a:contains(Edit)";
		final String STEP3_WORKOUT = "css=table#supergym-wo-conf-programs-routines-list tbody tr td:nth(0)";
		final String STEP3_ROUTINE = "css=table#supergym-wo-conf-programs-routines-list tbody tr td:nth(1)";
		final String STEP3_START_DATE = "css=table#supergym-wo-conf-outer-table tbody tr:nth(1) td:nth(1)";
		final String STEP3_START_TIME = "css=table#supergym-wo-conf-outer-table tbody tr:nth(2) td:nth(1)";
		final String STEP3_DURATION = "css=table#supergym-wo-conf-outer-table tbody tr:nth(3) td:nth(1)";
		final String STEP3_REPEAT = "css=table#supergym-wo-conf-outer-table tbody tr:nth(4) td:nth(1)";
		final String STEP3_BUDDIES = "css=table#supergym-wo-conf-outer-table tbody tr:nth(5) td:nth(1) a";
		final String STEP3_WORKOUT_INVITATION = "css=table#supergym-wo-conf-outer-table tbody tr:nth(7) td:nth(1)";
		final String STEP3_CANCEL_BUTTON = "css=input#supergym-wo-conf-cancel-input-btn";
		final String STEP3_CONFIRM_BUTTON = "css=input#supergym-wo-conf-save-input-btn";

		final String SUCCESS_POP_UP_CLOSE_LINK = "css=div.ui-dialog-container div.supergym-dialog-close a:contains(Close)";
		final String SUCCESS_POP_UP_I_AM_DONE_BUTTON = "css=div#supergym-wo-conf-success-buttons a#supergym-wo-conf-success-done";
		final String SUCCESS_POP_UP_SCHEDULE_ANOTHER_WORKOUT_BUTTON = "css=div.supergym-dialog-close input#supergym-wo-conf-success-another-wo";
	}

	/**
	 * PhotosTab interface contains locators for web elements displayed on Photos Page.
	 * @author Jaya
	 */
	public interface PhotosTab{
		final String HEADER = "css=h3.title";
		final String PHOTOS_PARAGRAPH = "//div[@class='header-text']//p[1]";
		final String WATCH_TUTORIAL_VIDEO = "css=a:contains(Watch Tutorial Video)";
		final String TERMS_OF_USE_CHECKBOX = "css=input#_USER_PROFILE_PHOTOS_WAR_userprofileportlet_photosRightToDistribute";
		final String TERMS_OF_USE_LINK = "css=a[href='javascript:_USER_PROFILE_PHOTOS_WAR_userprofileportlet_showTermsOfUse();']";
		final String PROFILE_PHOTO = "css=span.label:contains(Profile Photo)";
		final String PROGRESS_PHOTO_BEFORE = "css=span.label:contains(Progress Photo: Before)";
		final String PROGRESS_PHOTO_CURRENT = "css=span.label:contains(Progress Photo: Current)";
		final String CONTENT_LINK_ITEMS = "css=div#main-panel";
		final String PHOTOS = "//div[@class='photo-small']";
		final String BROWSE = "//input[@id='_USER_PROFILE_PHOTOS_WAR_userprofileportlet_file']";
		final String UPDATE_PHOTOS = "//span[@class='btn-white']/input[@value='Update photo']";
		final String MONTH_DROPDOWN = "//select[@id='_USER_PROFILE_PHOTOS_WAR_userprofileportlet_dateTakenMonth']";
		final String DAY_DROPDOWN = "//select[@id='_USER_PROFILE_PHOTOS_WAR_userprofileportlet_dateTakenDay']";
		final String YEAR_DROPDOWN = "//select[@id='_USER_PROFILE_PHOTOS_WAR_userprofileportlet_dateTakenYear']";
		final String CALENDAR_ICON = "//img[@class='ui-datepicker-trigger']";
		final String PHOTO_GALLERY_HEADER = "css=div.form-section>div";
		final String TITLE_TEXTBOX = "css=input#_USER_PROFILE_PHOTOS_WAR_userprofileportlet_title";
		final String MAX_CHARACTERS_GREY = "css=td.grey-text";
		final String ADD_PHOTO_BUTTON = "css=span.btn-white>input[value='Add photo']";
	}

	/**
	 * EatSmart interface contains locators for web elements displayed on Eat Smart Page.
	 * @author Jaya
	 */
	public interface EatSmart{
		final String DASHBOARD_LINK = "css=a[href='/dashboard']";
		final String NAV_MENU_ITEMS = "//div[@class='nav-menu nav-menu-style-']//ul[@class='layouts level-1']//li";
		final String CONTENT_LINK_ITEMS = "//div[@id='cont_sub_content']/ul/li";
		final String NAV_MENU_ITEMS_TEXT_XPATH = "xpath=//div[@class=\"nav-menu nav-menu-style-\"]//ul[@class=\"layouts level-1\"]/li";

		final String NAV_MENU_MY_MEAL_PLANNER_LINK = "css=div.nav-menu.nav-menu-style- a:contains(My Meal Planner)";
		final String NAV_MENU_RECIPES_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Recipes)";
		final String NAV_MENU_SHAKEOLOGY_RECIPES_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Shakeology Recipes)";
		final String NAV_MENU_NUTRITION_TOOLS_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Nutrition Tools)";
		final String NAV_MENU_NUTRITION_TIPS_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Nutrition Tips)";
		final String NAV_MENU_SHAKEOLOGY_AND_SUPPLEMENTS_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Shakeology & Supplements)";
		final String NAV_MENU_MICHI_LADDER_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Michi's Ladder)";

		final String EAT_SMART_PAGE_HEADER = "css=div.header-text div.hdr_eatsmart>h1:contains(Eat Smart)";
		final String CONTENT_HEADER_FEARURED_LINKS = "//div[@id='cont_sub_hdr']//ul//li";
		final String USER_STATS = "css=span.user_stats";

		final String MY_MEAL_PLANNER_IMAGE = "css=a[href='/eat-smart/meal-plans']>img[width='179']";
		final String MY_MEAL_PLANNER_HEADER = "css=div#cont_sub_content>ul>li>h2:contains(My Meal Planner)";
		final String MY_MEAL_PLANNER_LEARN_MORE_LINK = "css=a.catlinks[href='/eat-smart/meal-plans']";

		final String RECIPES_IMAGE = "css=a[href='/eat-smart/recipes']>img";
		final String RECIPES_HEADER = "css=div#cont_sub_content>ul>li>h2:contains(Recipes)";
		final String RECIPES_LEARN_MORE_LINK = "css=a.catlinks[href='/eat-smart/recipes']";

		final String SHAKEOLOGY_IMAGE = "css=a[href='/eat-smart/shakeology-recipes/']>img";
		final String SHAKEOLOGY_HEADER = "css=div#cont_sub_content>ul>li>h2:contains(Shakeology)";
		final String SHAKEOLOGY_LEARN_MORE_LINK = "css=a.catlinks[href='/eat-smart/shakeology-recipes/']";

		final String NUTRITION_TOOLS_IMAGE = "css=a[href='/eat-smart/nutrition-tools']>img";
		final String NUTRITION_TOOLS_HEADER = "css=div#cont_sub_content>ul li>h2:contains(Nutrition Tools)";
		final String NUTRITION_TOOLS_LEARN_MORE_LINK = "css=a.catlinks[href='/eat-smart/nutrition-tools']";

		final String NUTRITION_TIPS_IMAGE = "css=a[href='/eat-smart/nutrition-tips']>img";
		final String NUTRITION_TIPS_HEADER = "css=div#cont_sub_content>ul li>h2:contains(Nutrition Tips)";
		final String NUTRITION_TIPS_LEARN_MORE_LINK = "css=a.catlinks[href='/eat-smart/nutrition-tips']";

		final String SUPPLEMENTS_IMAGE = "css=a[href='/eat-smart/supplements']>img";
		final String SUPPLEMENTS_HEADER = "css=div#cont_sub_content>ul li>h2:contains(Supplements)";
		final String SUPPLEMENTS_LEARN_MORE_LINK = "css=a.catlinks[href='/eat-smart/supplements']";

		final String MICHIS_LADDER_IMAGE = "css=a[href='/eat-smart/michis-ladder']>img";
		final String MICHIS_LADDER_HEADER = "css=div#cont_sub_content>ul li>h2:contains(Michi)";
		final String MICHIS_LADDER_LEARN_MORE_LINK = "css=a.catlinks[href='/eat-smart/michis-ladder']"; 
		
		final String EATSMART_PROGRAM_RRM_SECTION = "//div[@id='layout-column_column-6']/div";
		final String EATSMART_PROGRAM_RRM_TITLE = "//div[@class='title']//span";	
	}

	/**
	 * MyMealPlannerTab interface contains locators for web elements displayed on My Meal Planner Page.
	 * @author Jaya
	 */
	public interface MyMealPlannerTab{
		final String MY_MEAL_PLANNER_HEADER = "css=h3.title:contains(My Meal Planner)";
		final String GO_TO_MY_MEAL_PLANNER_BUTTON = "css=span.btn-blue>input[value='Go to My Meal Planner']"; 
		final String CHANGE_MY_MEAL_PLAN_LINK = "css=a#personalized-change-plan"; 
		final String MY_PERSONALIZED_MEAL_PLAN_LABEL = "css=div.sub-title";
		final String MY_PERSONALIZED_MEAL_PLAN_TEXT = "css=div.corners_side p";
		final String CHOOSE_YOUR_NEW_MEAL_PLAN_LABEL = "css=div#top_cont>h2";
		final String CHOOSE_YOUR_NEW_MEAL_PLAN_PARAGRAPH = "css=div#top_cont p";
		final String MEAL_PLAN_WIZARD_IMAGE = "css=div.cont_img";
		final String MEAL_PLAN_WIZARD_LABEL = "css=div#bottom_cont_02>h3";
		final String USE_THE_MEAL_PLAN_WIZARD_BUTTON = "css=a.btn-orange";
		final String SELF_SELECT_YOUR_MEAL_PLAN_LABEL = "css=div#self_select_section>h3";
		final String SELF_SELECT_YOUR_MEAL_PLAN_TEXT = "css=div#self_select_section p";

		final String BALANCED_SLIM_DOWN_PLAN_LEARN_MORE = "css=div#square01 div p a";
		final String BALANCED_SLIM_DOWN_PLAN_POPUP_TITLE = "css=div[class='message clearfix'] div.sub-title:contains(Balanced Slim Down Plan)";
		final String BALANCED_SLIM_DOWN_PLAN_CLOSE = "link=Close [x]";

		final String LOW_CARB_EXPRESS_PLAN_LEARN_MORE = "css=div#square02 div p a";
		final String LOW_CARB_EXPRESS_PLAN_POPUP_TITLE = "css=div[class='message clearfix'] div.sub-title:contains(Low-Carb Express Plan)";
		final String LOW_CARB_EXPRESS_PLAN_CLOSE = "link=Close [x]";

		final String POWER_VEGETARIAN_PLAN_LEARN_MORE = "css=div#square03 div p a";
		final String POWER_VEGETARIAN_PLAN_POPUP_TITLE = "css=div[class='message clearfix'] div.sub-title:contains(Power Vegetarian Plan)";
		final String POWER_VEGETARIAN_PLAN_CLOSE = "link=Close [x]";

		final String ACTIVE_LIFESTYLE_PLAN_LEARN_MORE = "css=div#square04 div p a";
		final String ACTIVE_LIFESTYLE_PLAN_POPUP_TITLE = "css=div[class='message clearfix'] div.sub-title:contains(Active Lifestyle Plan)"; 
		final String ACTIVE_LIFESTYLE_PLAN_CLOSE = "link=Close [x]";

		final String CHOOSE_PLAN_DROP_DOWN = "css=select[name='_choosemealplans_WAR_mealplansportlet_mealPlanType']";
		final String SELECT_AND_CUSTOMIZE_THIS_PLAN_BUTTON = "css=span.btn-orange>input[value='Select and customize this plan']";

		final String CLUB_UK_USER_ALERT = "css=span.portlet-msg-error";
	}

	/**
	 * RecipesTab interface contains locators for web elements displayed on Recipes Page.
	 * @author Jaya
	 */
	public interface RecipesTab{
		final String RECIPES_HEADER = "css=span.title:contains(Recipes)";
		final String MEAL_DROP_DOWN = "css=select#_RECIPES_WAR_cmsbasedportlet_meal";
		final String SEARCH_TEXT_BOX = "css=input#_RECIPES_WAR_cmsbasedportlet_keywords";
		final String SEARCH_ICON = "css=input[title='Search']"; 
	}

	/**
	 * ShakeologyRecipesTab interface contains locators for web elements displayed on Shakeology Recipes Page.
	 * @author Jaya
	 */
	public interface ShakeologyRecipesTab{
		final String CLUB_UK_USER_ALERT = "css=span.portlet-msg-error";
		final String EAT_SMART_MENU_LINK = "css=a:contains(Eat Smart)";

		final String NAV_MENU_SHAKEOLOGY_RECIPES_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Shakeology Recipes)";
		final String NAV_MENU_GREENBERRY_RECIPES_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Greenberry)";
		final String NAV_MENU_CHOCOLATE_RECIPES_LINK = "css=div.nav-menu.nav-menu-style- a:contains(Chocolate)";

		final String SHAKEOLOGY_RECIPES_HEADER = "css=p.title";
		final String SHAKEOLOGY_RECIPES_IMAGE = "css=div#shake-recipe>img";
		final String CHOOSE_A_DELICIOUS_RECIPE_BELOW_LABEL = "css=h2.title-alt";
		final String GREENBERRY_LABEL = "css=h3.sub-title:contains(Greenberry)";
		final String GREENBERRY_RECIPES_BUTTON = "css=a.btn>span:contains(Greenberry Recipes)";
		final String CHOCOLATE_LABEL = "css=h3.sub-title:contains(Chocolate)";
		final String CHOCOLATE_RECIPES_BUTTON = "css=a.btn>span:contains(Chocolate Recipes)"; 
		final String FDA_STATEMENT = "css=p.fda_copy";
	}

	/**
	 * Greenberry interface contains locators for web elements displayed on Shakeology Recipes - Greenberry Page.
	 * @author Jaya
	 */
	public interface Greenberry{
		final String GREENBERRY_PAGE_HEADER = "css=h2.title";
		final String GREENBERRY_PAGE_IMAGE = "css=div.journal-content-article p>img";
		final String CALORIE_LINKS = "//table[@class='calorie_nav']//tbody//tr//td//a";
		final String SHAKEOLOGY_TABLE_ROWS = "//tr[@class='rec_item']";
	}

	/**
	 * Chocolate interface contains locators for web elements displayed on Shakeology Recipes - Chocolate Page.
	 * @author Jaya
	 */
	public interface Chocolate{
		final String CHOCOLATE_PAGE_HEADER = "css=h2.title";
		final String CHOCOLATE_PAGE_IMAGE = "css=p>img";
		final String CALORIE_LINKS = "//table[@class='calorie_nav']//tbody//tr//td//a";
		final String CHOCOLATE_TABLE_ROWS = "//tr[@class='rec_item']";
	}

	/**
	 * NutritionToolsTab interface contains locators for web elements displayed on Nutrition Tools Page.
	 * @author Jaya
	 */
	public interface NutritionToolsTab{
		final String NUTRITION_TOOLS_HEADER = "css=span.title";
		final String BODY_FAT_TOOL_IMAGE = "css=img[alt='Body Fat']";
		final String BODY_FAT_BUTTON = "css=a.btn-blue:contains(Body Fat)";
		final String HEALTHY_WEIGHT_TOOL_IMAGE = "css=img[alt='Healthy Weight']";
		final String HEALTHY_WEIGHT_BUTTON = "css=a.btn-blue:contains(Healthy Weight)";
		final String CALORIC_NEEDS_TOOL_IMAGE = "css=img[alt='Caloric Needs']";
		final String CALORIC_NEEDS_BUTTON = "css=a.btn-blue:contains(Caloric Needs)";
	}

	/**
	 * BodyFatCalculatorTab interface contains locators for web elements displayed on Body Fat Calculator Page.
	 * @author Jaya
	 */
	public interface BodyFatCalculatorTab{
		final String BODY_FAT_CALCULATOR_HEADER = "css=div.header-text>h3:contains(Body Fat Calculator)";
		final String BODY_FAT_CALCULATOR_IMAGE = "css=img[alt='Body Fat Calculator'][align='right']";
		//final String BODY_FAT_TESTER_HERE_LINK = "css=a[href='http://teambeachbody.com/shop/-/shopping/MDACCBODFATK2']";
		final String BODY_FAT_TESTER_HERE_LINK = "css=a[href$='shop/-/shopping/MDACCBODFATK2']";
		final String BODY_FAT_PORTLET_TITLE = "css=span.portlet-title:contains(Body Fat Calculator)";
		final String LEARN_MORE_ABOUT_BODY_FAT_LINK = "css=a.learn-more-bf";
		final String YOUR_WAIST_TEXTBOX = "css=input[name='waist']";
		final String YOUR_WEIGHT_TEXTBOX = "css=input[name='weight']"; 
		final String YOUR_GENDER_DROPDOWN = "css=select[name='gender']";
		final String YOUR_AGE_TEXTBOX = "css=input[name='age']";
		final String BODY_FAT_TESTER_READING_LINK = "css=a.diet";
		final String BODY_FAT_TESTER_DROPDOWN = "css=select[name='calipers']";
		final String CALCULATE_BODY_FAT_BUTTON = "css=input[value='Calculate body fat']";

		final String ESTIMATED_BODY_FAT_TEXTBOX = "css=input[name='bf']";
		final String FAT_WEIGHT_TEXTBOX = "css=input[name='fat']";
		final String LEAN_WEIGHT_TEXTBOX = "css=input[name='lean']";
		final String LEAN_TEXTBOX = "css=input[name='lean2']";
		final String IDEAL_FROM_PERCENT_TEXTBOX = "css=input[name='lean3']";
		final String IDEAL_TO_PERCENT_TEXTBOX = "css=input[name='ideal']";
		final String AVERAGE_FROM_PERCENT_TEXTBOX = "css=input[name='ideal2']";
		final String AVERAGE_TO_PERCENT_TEXTBOX = "css=input[name='average']";
		final String OVERFAT_TEXTBOX = "css=input[name='average2']";
	}

	/**
	 * HealthyWeightTab interface contains locators for web elements displayed on Healthy Weight Page.
	 * @author Jaya
	 */
	public interface HealthyWeightTab{
		final String HEALTHY_WEIGHT_HEADER = "css=div.header-text>h3:contains(Healthy Weight (BMI) Calculator)";
		final String HEALTHY_WEIGHT_IMAGE = "css=img[alt='Healthy Weight']"; 
		final String HEALTHY_WEIGHT_CALCULATOR_PORTLET_TITLE = "css=span.portlet-title:contains(Healthy Weight Calculator)";
		final String LEARN_MORE_ABOUT_BMI_LINK = "css=a.learn-more-link-bmi";
		final String YOUR_HEIGHT_FT_TEXTBOX = "css=input[name='feet']";
		final String YOUR_HEIGHT_IN_TEXTBOX = "css=input[name='inches']";
		final String YOUR_WEIGHT_LBS_TEXTBOX = "css=input[name='pounds']";
		final String CALCULATE_YOUR_BMI_BUTTON = "css=span.btn-grey>input[value='Calculate your BMI:']";
		final String YOUR_BMI_IS_TEXTBOX = "css=input[name='calcval']"; 
	}

	/**
	 * CaloricNeedsTab interface contains locators for web elements displayed on Caloric Needs Page.
	 * @author Jaya
	 */
	public interface CaloricNeedsTab{
		final String CALORIC_NEEDS_HEADER = "css=div.header-text>h3:contains(Caloric Needs Calculator)";
		final String CALORIC_NEEDS_IMAGE = "css=img[alt='Caloric Needs']";
		final String CALORIC_NEEDS_CALCULATOR_PORTLET_TITLE = "css=span.portlet-title:contains(Caloric Needs Calculator)";
		final String BEACHBODY_RECENTLY_COMPLETED_PROGRAM_DROPDOWN = "css=div.meal-plan-wizard-answer>select#_dietwizard_WAR_mealplansportlet_DWQ1";
		final String BEACHBODY_RECENTLY_COMPLETED_PROGRAM_HELP_ICON = "css=div.meal-plan-wizard-question a.help-icon[onclick='Liferay.CornerPop.helpDialog(this, 'one-click-prefs-help-dialog-wrappermeal-plan-wizard-question-1')']";
		final String GOAL_HELP_ICON = "css=div.meal-plan-wizard-question a.help-icon[onclick='Liferay.CornerPop.helpDialog(this, 'one-click-prefs-help-dialog-wrappermeal-plan-wizard-question-2')']";
		final String GOAL_DROPDOWN = "css=div.meal-plan-wizard-answer>select[name='_dietwizard_WAR_mealplansportlet_DWQ2']";
		final String ONCE_A_DAY_RADIO_BUTTON = "css=div.meal-plan-wizard-answer>input#DWQ30";
		final String ONCE_A_DAY_LABEL = "css=label[for='DWQ30']:contains(Once a day)";
		final String MORE_THAN_ONCE_A_DAY_RADIO_BUTTON = "css=div.meal-plan-wizard-answer>input#DWQ31";
		final String MORE_THAN_ONCE_A_DAY_LABEL = "css=label[for='DWQ31']:contains(More than once a day)";
		final String PRIMARY_PROGRAM_LABEL = "css=div#_dietwizard_WAR_mealplansportlet_q3b1>div:contains(My primary program is or will be:)";
		final String PRIMARY_PROGRAM_DROPDOWN = "css=select[name='_dietwizard_WAR_mealplansportlet_DWQ3B_1']";
		final String SECONDARY_PROGRAM_LABEL = "css=div#_dietwizard_WAR_mealplansportlet_q3b2>div:contains(My secondary program is or will be:)";
		final String SECONDARY_PROGRAM_DROPDOWN = "css=select[name='_dietwizard_WAR_mealplansportlet_DWQ3B_2']";
		final String RATE_YOUR_ACTIVITY_QUESTION = "css=div#_dietwizard_WAR_mealplansportlet_DWQ4B";
		final String RATE_YOUR_ACTIVITY_HELP_ICON = "css=div#_dietwizard_WAR_mealplansportlet_DWQ4B a.help-icon";
		final String ACTIVITY_LEVEL_DROPDOWN = "css=div.meal-plan-wizard-answer>select[name='_dietwizard_WAR_mealplansportlet_DWQ4']";
		final String GENDER_QUESTION = "css=div.meal-plan-wizard-question:contains(I am:)";
		final String GENDER_HELP_ICON = "css=div.meal-plan-wizard-question A.help-icon[onclick='Liferay.CornerPop.helpDialog(this, 'one-click-prefs-help-dialog-wrappermeal-plan-wizard-question-5')'']";
		final String FEMALE_RADIO_BUTTON = "css=div.meal-plan-wizard-answer>input#DWQ50";
		final String FEMALE_LABEL = "css=label[for='DWQ50']";
		final String MALE_RADIO_BUTTON = "css=div.meal-plan-wizard-answer>input#DWQ51";
		final String MALE_LABEL = "css=label[for='DWQ51']"; 
		final String YEARS_OLD_TEXTBOX = "css=div.meal-plan-wizard-answer>input#DWQ52";
		final String CM_TEXTBOX = "css=input#DWQ53";
		final String FT_TEXTBOX = "css=input[name='_dietwizard_WAR_mealplansportlet_DWQ5_FT']";
		final String KG_TEXTBOX ="css=input[name='_dietwizard_WAR_mealplansportlet_DWQ5_KG']";
		final String IN_TEXTBOX = "css=input[name='_dietwizard_WAR_mealplansportlet_DWQ5_IN']";
		final String LBS_TEXTBOX = "css=div.meal-plan-wizard-answer>input#DWQ57";
		final String SUBMIT_BUTTON = "css=span.btn-blue>input[value='Submit']";
	}

	/**
	 * NutritionTipsTab interface contains locators for web elements displayed on Nutrition Tips Page.
	 * @author Jaya
	 */
	public interface NutritionTipsTab{
		final String NUTRITION_TIPS_HEADER = "css=span.title:contains(Nutrition Tips)"; 
		final String TIP_SEARCH_TEXTBOX = "css=input#_NUTRITION_TIPS_WAR_cmsbasedportlet_keywords";
		final String TIP_SEARCH_ICON = "css=input[title='Search']"; 
	}
	
	/**
	 * SupplementsTab interface contains locators for web elements displayed on Shakeology & Supplements Page.
	 * @author Jaya
	 */
	public interface SupplementsTab{
		final String CLUB_UK_USER_ALERT = "css=span.portlet-msg-error";
		final String SUPPLEMENTS_HEADER = "css=h3.title:contains(Supplements)";
		final String SHAKEOLOGY_LEARN_MORE = "css=a[href='/nutrition-shake/shakeology']:contains(Learn More)";
		final String SUPPLEMENT_CHOICE_BOXES = "//div[@id='cont_fitness_program']//div[@class='clear-corner-r5 gray']";
		final String LEARN_MORE_LINKS = "//a[@class='btn-blue']";
		final String SUPPLEMENT_TITLES = "css=div#cont_fitness_program div[class='clear-corner-r5 gray'] div#product_description";
		final String SLIMMING_FORMULA_LEARN_MORE = "css=a[href='/shop/-/shopping/SLIMFORMULA']:contains(Learn More)";
		final String P90X_PEAK_PERFORMANCE_PROTEIN_BARS_LEARN_MORE = "css=a[href='/shop/-/shopping/PROTEINBARS']:contains(Learn More)";
		final String STAR_IMAGE_XPATH = "//div[@class='bazaarvoice-star-rating-container']//a//img";
		final String REVIEW_XPATH = "//div[@class='BVRRReviewDisplayStyle5']";
	}

	/**
	 * MichisLadderTab interface contains locators for web elements displayed on Michi's Ladder Page.
	 * @author Jaya
	 */
	public interface MichisLadderTab{
		final String CLIMB_MICHIS_LADDER_HEADER = "css=div.journal-content-article > table > tbody div.title";
		final String CARB_FAT_PROTEIN_IMAGE = "css=img[alt='Carb Fat Protein']";
		final String BACK_TO_TOP_LINKS = "//a[@class='backtotop']";
		final String TIER_TITLES = "//img[@width='520'][@height='44']";
		final String TIERS_CONTENT_HOLDER = "//td[@valign='top'][@align='left']";
	}

	/**
	 * MealPlanWizard interface contains locators for web elements displayed on Meal Plan Wizard Page.
	 * @author Jaya
	 */
	public interface MealPlanWizard{
		final String NO_THIS_IS_MY_FIRST_PROGRAM_RADIO_BUTTON = "css=input#DWQ10";
		final String YES_I_RECENTLY_COMPLETED_P90X_RADIO_BUTTON = "css=input#DWQ11";
		final String YES_I_RECENTLY_COMPLETED_A_BEACHBODY_PROGRAM_OTHER_THAN_P90X_RADIO_BUTTON = "css=input#DWQ12";

		final String LOSE_A_LOT_OF_WEIGHT_RADIO_BUTTON = "css=input#DWQ20";
		final String LOSE_SOME_WEIGHT_RADIO_BUTTON = "css=input#DWQ21";
		final String LOSE_THE_LAST_FEW_POUNDS_RADIO_BUTTON ="css=input#DWQ22";
		final String SAME_WEIGHT_BUT_TONE_UP_OR_CHANGE_MY_BODY_SHAPE_RADIO_BUTTON = "css=input#DWQ23"; 
		final String GAIN_WEIGHT_AND_MUSCLE_RADIO_BUTTON = "css=input#DWQ24";

		final String ONCE_A_DAY_RADIO_BUTTON = "css=input#DWQ30";
		final String MORE_THAN_ONCE_A_DAY = "css=input#DWQ31";
		final String PRIMARY_PROGRAM_DROP_DOWN = "css=select[name='_dietwizard_WAR_mealplansportlet_DWQ3B_1']";
		final String SECONDARY_PROGRAM_DROP_DOWN = "css=select[name='_dietwizard_WAR_mealplansportlet_DWQ3B_2']";

		final String VERY_ACTIVE_OR_ATHLETIC_RADIO_BUTTON = "css=input#DWQ40";
		final String ACTIVE_RADIO_BUTTON = "css=input#DWQ41";
		final String MODERATELY_ACTIVE_RADIO_BUTTON = "css=input#DWQ42";
		final String OCCASIONALLY_ACTIVE_RADIO_BUTTON = "css=input#DWQ43";
		final String SEDENTARY_RADIO_BUTTON = "css=input#DWQ44";

		final String VEGDIET_YES_RADIO_BUTTON = "css=input#DWQV0";
		final String VEGDIET_NO_RADIO_BUTTON = "css=input#DWQV1";

		final String FEMALE_RADIO_BUTTON = "css=input#DWQ50";
		final String MALE_RADIO_BUTTON = "css=input#DWQ51";
		final String AGE_TEXTBOX = "css=input#DWQ52";
		final String HEIGHT_FT_TEXTBOX = "css=input#DWQ55";
		final String HEIGHT_IN_TEXTBOX = "css=input#DWQ56";
		final String WEIGHT_TEXTBOX = "css=input#DWQ57";

		final String SUBMIT_BUTTON = "css=input[value='Submit']";
		final String MY_MEAL_PLANNER_MENU_LINK = "css=a[href$='eat-smart/meal-plans']";
	}

	/**
	 * PersonalizedMealPlan interface contains locators for web elements displayed on Personalized Meal Plan Page.
	 * @author Jaya
	 */
	public interface PersonalizedMealPlan{
		final String PLAN_DROP_DOWN = "css=select#_dietwizard_WAR_mealplansportlet_mealPlanType";
		final String DAILY_CALORIES_DROP_DOWN = "css=select#_dietwizard_WAR_mealplansportlet_calories";
		final String MEAL_PLAN_PORTLET_CALORIES = "css=select#_dietwizard_WAR_mealplansportlet_calories";
		final String MEAL_PLAN_SUBMIT = "css=input#meal-planner-submit";
	}

	/**
	 * FitnessTipsTab interface contains locators for web elements displayed on Fitness Tips Page.
	 * @author Gaurav
	 */
	public interface FitnessTipsTab{
		final String FITNESS_TIPS_HEADER = "css=span.title:contains(Fitness Tips)";
		final String TIP_SEARCH_TEXTBOX = "css=input#_FITNESS_TIPS_WAR_cmsbasedportlet_keywords";
		final String TIP_SEARCH_ICON = "css=input[title='Search']";
	}

	/**
	 * FitnessPrograms interface contains locators for web elements displayed on Fitness Programs Page.
	 * @author Gaurav
	 */
	public interface FitnessPrograms {
		final String FITNESS_PROGRAM_HEADING = "css=div#cont_fitness_program h3";
		final String FITNESS_PROGRAM_COMPARISON_CHART_LINK = "css=div#cont_fitness_program a:contains(Check out our Comparison Chart)";
		final String FITNESS_PROGRAM_SECTION = "//div[@class='clear-corner-r5 gray']";
		final String FITNESS_PROGRAM_LEARN_MORE_LINK = "//div[@id='product_description']//p//a//span[contains(text(), 'Learn More')]";
		final String FITNESS_PROGRAM_BUY_NOW_LINK = "//div[@id='product_description']//p//a//span[contains(text(), 'Buy Now')]";
		final String FITNESS_PROGRAM_TITLE = "//div[@id='product_description']//h3";
		final String FITNESS_PROGRAM_RRM_SECTION = "//div[@id='layout-column_column-5']/div";
		final String FITNESS_PROGRAM_RRM_TITLE = "//div[@class='title']//span";		

		final String P90X_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/span";
		final String INSANITY_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/span";
		final String TONY_HORTON_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[5]/div[2]/div/div/div/div/div/span";
		final String CHALEAN_EXTREME_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[6]/div[2]/div/div/div/div/div/span";
		final String BRAZIL_BUTT_LIFT_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[7]/div[2]/div/div/div/div/div/span";
		final String TURBO_FIRE_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[9]/div[2]/div/div/div/div/div/span";
		final String BODY_GOSPEL_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[9]/div[2]/div/div/div/div/div/span";
		final String DEBBIE_SIEBERS_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[10]/div[2]/div/div/div/div/div/span";
		final String POWER90_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[11]/div[2]/div/div/div/div/div/span[2]/a";
		final String P90X_ONE_ON_ONE_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[13]/div[2]/div/div/div/div/div/span";
		final String REV_ABS_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[14]/div[2]/div/div/div/div/div/span";
		final String HIP_HOP_ABS_RATING = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[15]/div[2]/div/div/div/div/div/span";

		final String P90X_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div/div/span[2]/a";
		final String INSANITY_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[3]/div[2]/div/div/div/div/div/span[2]/a";
		final String TONY_HORTON_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[5]/div[2]/div/div/div/div/div/span[2]/a";
		final String CHALEAN_EXTREME_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[6]/div[2]/div/div/div/div/div/span[2]/a";
		final String BRAZIL_BUTT_LIFT_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[7]/div[2]/div/div/div/div/div/span[2]/a";
		final String TURBO_FIRE_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[8]/div[2]/div/div/div/div/div/span[2]/a";
		final String BODY_GOSPEL_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[9]/div[2]/div/div/div/div/div/span[2]/a";
		final String DEBBIE_SIEBERS_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[10]/div[2]/div/div/div/div/div/span[2]/a";
		final String POWER_90_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[11]/div[2]/div/div/div/div/div/span[2]/a";
		final String P90X_ONE_ON_ONE_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[13]/div[2]/div/div/div/div/div/span[2]/a";
		final String REV_ABS_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[14]/div[2]/div/div/div/div/div/span[2]/a";
		final String HIP_HOP_ABS_REVIEW_LINK = "xpath=/html/body/div/div[2]/table/tbody/tr/td/div/div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div[15]/div[2]/div/div/div/div/div/span[2]/a";
		final String REVIEW_XPATH = "//div[@class='BVRRReviewDisplayStyle5']";
	}

	/**
	 * Trainers interface contains locators for web elements displayed on Trainers Page.
	 * @author Jaya
	 */
	public interface Trainers{
		final String TRAINER_HEADING = "css=span.title";
		final String INTRO_TEXT = "css=p.intro-text";
		final String ALL_TRAINERS_PICS = "//div[@class='frame_large']/a";
		final String ALL_TRAINERS_NAMES = "//div[@class='link']";
		final String ALL_TRAINERS_INTRODUCTION = "//div[@class='text']";
		
		final String TONY_HORTON_IMAGE= "css=img[alt='Tony Horton']";
		final String CHALENE_JOHNSON_IMAGE = "css=img[alt='Chalene Johnson']";
		final String DEBBIE_SIEBERS_IMAGE ="css=img[alt='Debbie Siebers']";
		final String SHAUN_T_IMAGE = "css=img[alt='Shaun T']";
		final String DONNA_RICHARDSON_IMAGE = "css=img[alt='Body Gospel by Donna Richardson Joyner']";
		final String LEANDRO_CARVALHO_IMAGE = "css=img[alt='Leandro Carvalho']";
		final String KATHY_SMITH_IMAGE = "css=img[alt='Kathy Smith']";
		final String GILLIAN_TEIGH_IMAGE = "css=img[alt='Gillian & Teigh']";
		final String BRETT_IMAGE = "css=img[alt='Brett Hoebel']";
		final String STEVE_EDWARDS_IMAGE = "css=img[alt='Steve Edwards']";
		final String MORE_EXPERTS_IMAGE = "css=img[alt='More Experts']";
		
		final String TRAINERS_LINK = "css=a.open:contains(Trainers)";
		final String PRODUCTS = "css=div.section-name:contains(Products)";
		final String BAZAAR_VOICE = "css=div.bazaarvoice-star-rating-container";
	}
	
	/**
	 * FitnessTools interface contains locators for web elements displayed on Fitness Tools Page.
	 * @author Gaurav
	 */
	public interface FitnessTools {
		final String FITNESS_TOOLS_HEADING = "css=div#p_p_id_56_INSTANCE_tfH7_ div.header-text p";
		final String FITNESS_TOOLS_ITEM = "//div[@id='cont_fitness_tools']/ul[@id='list']/li";
		final String FITNESS_TOOLS_TITLE = "css=div#cont_fitness_tools ul > li > a";
		final String FITNESS_TOOLS_IMAGE = "//div/a/img";

		final String BODY_FAT_CALCULATOR_LINK = "css=a:contains(Body Fat Calculator)";
		final String HEALTHY_WEIGHT_CALCULATOR_LINK = "css=a:contains(Healthy Weight Calculator)";
		final String CALORIC_NEEDS_CALCULATOR_LINK = "css=a:contains(Caloric Needs Calculator)";

		final String RRM_ITEM = "//div[@id='layout-column_column-5']/div";
		final String RRM_TILE = "//div[@class='title']/span";

		final String TARGET_HEART_RATE_LINK = "css=div#cont_fitness_tools ul > li:nth(0) > a";
		final String FITNESS_TRACKER = "css=div#cont_fitness_tools ul > li:nth(1) > a";
		final String WORKOUT_SHEETS_LINK = "css=div#cont_fitness_tools ul > li:nth(2) > a";
	}

	/**
	 * TargetHeartRateCalcultor interface contains locators for web elements displayed 
	 * on Target Heart Rate Calculator Tools Page.
	 * @author Gaurav
	 */
	public interface TargetHeartRateCalcultor {
		final String AGE_TEXTBOX = "css=input[name=age]";
		final String GENDER_SELECT = "css=select[name=gender]";
		final String CALCULATE_HEART_RATE_ZONES_BUTTON = "css=input[value='Calculate Heart Rate Zones']";
		final String HEART_RATE_ZONES_TABLE_ROW = "//table[@class='basic_style']//tbody//tr//td//table[@class='basic_style']//tbody//tr//td//table[@class='basic_style']/tbody/tr";
		final String RECOVERY_ZONE_NAME = "/td[1]";
		final String RECOVERY_ZONE_LOW = "/td[2]/input[1]";
		final String RECOVERY_ZONE_HIGH = "/td[2]/input[2]";
		final String TARGET_HEART_RATE_CALCULATOR_HEADER = "css=div.header-text>h3.title";
		final String TARGET_HEART_RATE_CALCULATOR_IMAGE = "css=div.header-text>p>img[alt='Target Heart Rate']";

		final String RRM_ITEM = "//div[@id='layout-column_column-5']/div";
		final String RRM_TILE = "//div[@class='title']/span";
	}

	/**
	 * WorkoutSheets interface contains locators for web elements displayed on Workout Sheets Page.
	 * @author Gaurav
	 */
	public interface WorkoutSheets {
		final String HEADING = "css=div#p_p_id_56_INSTANCE_tfH7_ div.header-text h3.title";
		final String PDF_SHEET = "//div[@id='cont_workout']/div[@id='body_cont']/div";
		final String PDF_SHEET_IMAGE = "//div[@id='img']";
		final String PDF_SHEET_TITLE = "/div/p";
		final String PDF_SHEET_DOWNLOAD_BUTTON = "//div[@id='button']";

		final String RRM_ITEM = "css=div#layout-column_column-5 > div";
		final String RRM_TILE = "div.title > span";

		final String MS_EXCEL_P90_XCEL_SPREADSHEET = "css=a:contains(P90Xcel (Microsoft Excel 2003 and 2007))";
		final String MS_EXCEL_P90_XCEL_PLUS_SPREADSHEET = "css=a:contains(P90XcelPlus (Microsoft Excel 2003 and 2007))";
	}

	/**
	 * Connect interface contains locators for web elements displayed on Connect Page.
	 * @author Gaurav
	 */
	public interface Connect{
		final String NAV_MENU_ITEMS_TEXT_XPATH = "xpath=//div[@class=\"nav-menu nav-menu-style-\"]//ul[@class=\"layouts level-1\"]/li";
		final String NAV_MENU_ITEMS_XPATH = "//div[@class='nav-menu nav-menu-style-']//ul[@class='layouts level-1']//li";
		final String NAV_MENU_CONTESTS_LINK = "css=ul[class='layouts level-1'] li a:contains(Contests)";
		final String NAV_MENU_SUCCESS_STORIES_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Success Stories)";
		final String NAV_MENU_MESSAGE_BOARDS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Message Boards)";
		final String NAV_MENU_MEMBER_GALLERY_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Member Gallery)";
		final String NAV_MENU_CHAT_ROOMS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Chat Rooms)";
		final String NAV_MENU_MY_COACH_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(My Coach)";
		final String NAV_MENU_MESSAGE_CENTER_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Message Center)";
		final String NAV_MENU_MY_PROFILE_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(My Profile)";
		
		final String CONTENT_LINKS_XPATH = "//div[@id='cont_sub_content']/ul/li";
		final String CONTENT_LINKS_TEXT_XPATH = "//div[@id='cont_sub_content']/ul/li";
		final String IMAGE_LINKS_XPATH = "//div[@id='cont_sub_content']/ul/li//img";
		
		final String LEARN_MORE_LINKS_XPATH = "//div[@id='cont_sub_content']/ul/li//a[contains(text(), 'Learn more')]";
		final String LEARN_MORE_CONTESTS_LINK = "css=a.catlinks[href='/connect/contests']";
		final String LEARN_MORE_SUCCESS_STORIES_LINK = "css=a.catlinks[href='/connect/success-stories']";
		final String LEARN_MORE_MESSAGE_BOARDS_LINK = "css=a.catlinks[href='/connect/message-boards']";
		final String LEARN_MORE_MEMBER_GALLERY_LINK = "css=a.catlinks[href='/connect/member-gallery']";
		final String LEARN_MORE_CHAT_ROOMS_LINK = "css=a.catlinks[href='/connect/chat-rooms']";
		final String LEARN_MORE_COACH_LINK = "css=a.catlinks[href='/connect/coach']";
		final String LEARN_MORE_MESSAGE_CENTER_LINK = "css=a.catlinks[href='/connect/message-center']";
		final String LEARN_MORE_MY_PROFILE_LINK = "css=a.catlinks[href='/my-profile']";
		
		final String CONNECT_PROGRAM_RRM_SECTION = "//div[@id='layout-column_column-6']/div";
		final String CONNECT_PROGRAM_RRM_TITLE = "//div[@class='title']//span";	
	}

	/**
	 * MemberGallery interface contains locators for web elements displayed on Member Gallery Page.
	 * @author Gaurav
	 */
	public interface MemberGallery {
		final String SEARCH_MEMBERS_TEXTBOX = "css=input.text#_membergallerysearch_WAR_membergalleryportlet_keywords";
		final String SEARCH_BUTTON = "css=input[type='submit'][value='Search']";
		final String SEE_ENTIRE_GALLERY_LINK = "css=a:contains(See entire gallery)";
		final String RESET_TO_ALL_LINK = "css=a:contains(Reset to all)";
		final String MEMBER_GALLERY_IMAGE = "css=img[alt='Member Gallery']";
		final String MEMBER_PROFILE_AREA = "//div[@id='p_p_id_membergallery_WAR_membergalleryportlet_INSTANCE_c1Ly_']/div[@class='portlet-borderless-container']/div/div[@user]";
		final String MEMBER_PROFILE_PHOTO = "css=div.photo-medium>div";
		final String ADD_AS_A_BUDDY = "css=span:contains(Add as a Buddy)";
		final String YES_BUTTON = "css=span:contains(Yes)";
		final String VIEW_PROFILE = "css=div.btn-blue>span";
		final String SUCCESS_MESSAGE = "css=div.portlet-msg-success";
		final String CLOSE_PROFILE_AREA = "css=div.profile-area-close";
	}
	
	/**
	 * MemberGallerySearch interface contains locators for web elements displayed on Member Gallery Search Results Page.
	 * @author Jaya 
	 */
	public interface MemberGallerySearch{
		final String ABOUT_LINK = "css=li a>span:contains(About)";
		final String ADD_AS_A_BUDDY = "css=span:contains(Add as a Buddy)";
		final String YES_BUTTON = "css=span:contains(Yes)";
	}

	/**
	 * MemberProfile interface contains locators for web elements displayed on Member Profile Page.
	 * @author Gaurav
	 */
	public interface MemberProfile {
		final String DASHBOARD_LINK = "css=div.breadcrumb a:contains(Dashboard)";
		final String REMOVE_BUDDY = "css=input[value='Remove Buddy']";
	}

	/**
	 * ChatRooms interface contains locators for web elements displayed on Chat Rooms Page.
	 * @author Gaurav
	 */
	public interface ChatRooms {
		final String CHAT_ROOM_IMAGE = "css=div.header-text > p > img[alt=Chat Room]";
		final String VIP_CHAT_ROOM_TITLE = "css=div.sub-title:contains(VIP Chat Room)";
		final String PUBLIC_CHAT_ROOM_TITLE = "css=div.sub-title:contains(Public Chat Room)";
		final String VIP_CHAT_ROOM_COUNT = "//div[@class='sub-title'][contains(text(), 'VIP Chat Room')]/following-sibling::div";
		final String PUBLIC_CHAT_ROOM_COUNT = "//div[@class='sub-title'][contains(text(), 'Public Chat Room')]/following-sibling::div";
		final String GYM_RAT_CHAT_TITLE = "css=span.list-title:contains(Gym Rat Chat)";
		final String CHAT_NOW_BUTTON = "css=a.btn-white > span:contains(Chat Now!)";

		/*	final String FITNESS_PROGRAM_RRM_SECTION = "css=div#layout-column_column-5 > div";
			final String FITNESS_PROGRAM_RRM_TITLE = "div.title span";*/

		final String FITNESS_PROGRAM_RRM_SECTION = "//div[@id='layout-column_column-5']/div";
		final String FITNESS_PROGRAM_RRM_TITLE = "//div[@class='title']//span";
		
		final String NAV_MENU_PUBLIC_CHAT_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] a:contains(Public)";
		final String NAV_MENU_VIP_CHAT_LINK = "css=div.nav-menu.nav-menu-style- ul.layouts.level-1 li a:contains(VIP)";
		final String CLOSE_LINK = "css=a:contains(Close)";
	}

	/**
	 * SuccessStories interface contains locators for web elements displayed on Success Stories Page.
	 * @author Jaya
	 */
	public interface SuccessStories{
		final String SUCCESS_STORY_HEADER = "css=div.portlet-borderless-container>div>div.title";
		final String GENDER_AGE_LABEL = "css=span.label";
		final String GENDER_AGE_DROPDOWN = "css=select[name='_SUCCESS_STORIES_WAR_contestportlet_genderAgeFilter']";
		final String TOP_RESULTS_LABEL = "css=div.taglib-search-iterator-page-iterator-top div[class='search-results']";
		final String TOP_ITEMS_PER_PAGE_LABEL = "css=div.taglib-search-iterator-page-iterator-top div.delta-selector";
		final String TOP_ITEMS_PER_PAGE_DROPDOWN = "css=div.taglib-search-iterator-page-iterator-top > div.taglib-page-iterator > div.search-pages > div.delta-selector > select";
		final String TOP_PAGE_LABEL = "css=div.taglib-search-iterator-page-iterator-top div.page-selector";
		final String ENABLED_TOP_FIRST_ARROW = "css=div.taglib-search-iterator-page-iterator-top div.page-links a.first";
		final String DISABLED_TOP_FIRST_ARROW = "css=div.taglib-search-iterator-page-iterator-top div.page-links>span.first";
		final String ENABLED_TOP_PREVIOUS_ARROW = "css=div.taglib-search-iterator-page-iterator-top div.page-links a.previous";
		final String DISABLED_TOP_PREVIOUS_ARROW = "css=div.taglib-search-iterator-page-iterator-top div.page-links span.previous";
		final String ENABLED_TOP_NEXT_ARROW = "css=div.taglib-search-iterator-page-iterator-top div.page-links a.next";
		final String DISABLED_TOP_NEXT_ARROW = "css=div.taglib-search-iterator-page-iterator-top div.page-links span.next";
		final String ENABLED_TOP_LAST_ARROW = "css=div.taglib-search-iterator-page-iterator-top div.page-links a.last";
		final String DISABLED_TOP_LAST_ARROW = "css=div.taglib-search-iterator-page-iterator-top div.page-links span.last";
		final String BOTTOM_RESULTS_LABEL = "css=div.taglib-search-iterator-page-iterator-bottom div.taglib-page-iterator div.search-results";
		final String BOTTOM_ITEMS_PER_PAGE_LABEL = "css=div.taglib-search-iterator-page-iterator-bottom div.taglib-page-iterator div.delta-selector";
		final String BOTTOM_PAGE_LABEL = "css=div.taglib-search-iterator-page-iterator-bottom div.page-selector";
		final String BOTTOM_FIRST_ARROW = "css=div.taglib-search-iterator-page-iterator-bottom span.first";
		final String BOTTOM_PREVIOUS_ARROW = "css=div.taglib-search-iterator-page-iterator-bottom span.previous";
		final String BOTTOM_NEXT_ARROW = "css=div.taglib-search-iterator-page-iterator-bottom a.next";
		final String BOTTOM_LAST_ARROW = "css=div.taglib-search-iterator-page-iterator-bottom a.last";		
		final String TABLE_HEADER = "css=tr[class='portlet-section-header results-header']";
		final String TABLE_ROWS = "//tr[@class='portlet-section-body results-row']";
	}

	/**
	 * MemberBoards interface contains locators for web elements displayed on Message Boards Page.
	 * @author Jaya
	 */
	public interface MessageBoards{
		final String MESSAGE_BOARDS_IMAGE = "css=div.header-text img";
		final String MESSAGE_BOARDS_HEADER = "css=h3.title";
		final String HOW_TO_POST_LABEL = "css=div.corners_side>div>p";
		final String HOW_TO_POST_SHOW_LINK = "css=div.read-more>a";
		final String HOW_TO_POST_HIDE_LINK = "css=a.less";
		final String HOW_TO_POST_TEXT = "css=div.long-answer";

		final String CATEGORIES_TAB = "css=li.current.first>a";
		final String SEARCH_LABEL = "css=label[for='_19_keywords1']";
		final String SEARCH_TEXTBOX = "css=input#_19_keywords1";
		final String SEARCH_BUTTON = "css=span.btn>input[value='Search']";
		final String SEARCH_CHECKBOX = "css=input#_19_category-only";
		final String SEARCH_IN_THE_CATEGORIES_BELOW_ONLY_LABEL = "css=label[for='_19_category-only']";
		final String ADVANCED_SEARCH_LINK = "css=span.mb-advanced-search-btn";
		final String ANY_OF_THESE_WORDS_OPTION_BUTTON = "css=input#_19_any-words";
		final String ALL_OF_THESE_WORDS_OPTION_BUTTON = "css=input#_19_all-words";
		final String EXACT_WORDING_OR_PHRASE_OPTION_BUTTON = "css=input#_19_exact-words";
		final String SEARCH_SUBJECT_AND_BODY_OPTION_BUTTON = "css=input#_19_title-and-body";
		final String SEARCH_SUBJECT_ONLY_OPTION_BUTTON = "css=input#_19_title-only";
		final String SEARCH_BODY_ONLY_OPTION_BUTTON = "css=input#_19_body-only";
		final String DATE_OF_POSTS_LABEL = "css=div.mb-advanced-search p:contains(Date of posts:)";
		final String DATE_OF_POSTS_FROM_TEXTBOX = "css=div.mb-advanced-search p>input#mb-search-from-date";
		final String DATE_OF_POSTS_TO_TEXTBOX = "css=div.mb-advanced-search p>input#mb-search-to-date";
		final String SCREEN_NAME_OF_MEMBER_LABEL = "css=div.mb-advanced-search p:contains(Screen name of member:)";
		final String SCREEN_NAME_OF_MEMBER_TEXTBOX = "css=div.mb-advanced-search p>input[name='_19_screenName']";
		final String EXACT_MATCH_CHECKBOX = "css=div.mb-advanced-search p>input#_19_exact-match";
		final String EXACT_MATCH_LABEL = "css=div.mb-advanced-search p>label[for='_19_exact-match']";
		final String RESULTS_TABLE_HEADER = "css=div.search-results";
		final String ALL_CATEGORIES_RESULTS_ROWS = "css=tr[class='portlet-section-body results-row']";

		final String MY_POSTS_TAB = "css=li#_19_tabs1my_postsTabsId>a";
		final String MY_SUBSCRIPTIONS_TAB = "css=li#_19_tabs1my_subscriptionsTabsId";
		final String RECENT_POSTS_TAB = "css=li#_19_tabs1recent_postsTabsId>a";
		final String RECENT_POSTS_TABLE_HEADER = "css=tr[class='portlet-section-header results-header']";
		final String ALL_RECENT_POSTS_ODD_ROWS = "//tr[@class='portlet-section-body results-row']";
		final String ALL_RECENT_POSTS_EVEN_ROWS = "//tr[@class='portlet-section-alternate results-row alt']";

		final String STATISTICS_TAB = "css=li.last>a";
		final String GENERAL_TAB = "css=li[class='current first']>a";
		final String TOP_POSTERS_TAB = "css=li.last[id='_19_tabs2top-postersTabsId']>a";
		final String ALL_TOP_POSTERS_RESULTS = "//div[@class='taglib-user-display']";

		final String BANNED_USRS_TAB = "css=li#_19_tabs1banned_usersTabsId";
		final String BANNED_USERS_RESULTS_COUNT = "css=div.search-results";
		final String BANNED_USERS_TABLE_HEADER_ROW = "css=table.taglib-search-iterator>tbody>tr[class='portlet-section-header results-header']";

		final String CLUB_UK_USER_ALERT = "css=div.margin-top>p>span.portlet-msg-error";
	}

	/**
	 * Contests interface contains locators for web elements displayed on Contests Page.
	 * @author Jaya
	 */
	public interface Contests{
		final String LEFT_MENU_DAILY_SWEEPSTAKES_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] ul[class='layouts level-2'] a:contains(Daily Sweepstakes)";
		final String LEFT_MENU_THE_BEACHBODY_CHALLENGE_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] ul[class='layouts level-2'] a:contains(The Beachbody Challenge)";
		final String LEFT_MENU_CONTEST_FAQ_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] ul[class='layouts level-2'] a:contains(Contest FAQ)";

		final String CONTESTS_HEADER = "css=h2.title";
		final String CONTESTS_INTRO_TEXT = "css=span.orange";
		final String WORKOUT_NOW_BUTTON = "css=a.btn-orange";
		final String ENTER_THE_BEACHBODY_CHALLENGE_BUTTON = "css=a.btn-blue";
		final String CONTESTS_IMAGE = "css=div#dsc-right>img";
		final String DISABLED_PREV_ARROW = "css=div[class='carousel-prev column disabled']>div";
		final String ENABLED_PREV_ARROW = "css=div[class='carousel-prev column']>div";
		final String ENABLED_NEXT_ARROW = "css=div[class='carousel-next column']>div";
		final String DISABLED_NEXT_ARROW = "css=div[class='carousel-next column disabled']>div";
		final String RULES = "css=p.small_footer";
		final String CLUB_UK_USER_ALERT = "css=span.portlet-msg-error";
		final String PREV_ARROW = "css=div.carousel-prev.column>div";
		final String NEXT_ARROW = "css=div.carousel-next.column>div";
	}

	/**
	 * DailySweepstakes interface contains locators for web elements displayed on Daily Sweepstakes Page.
	 * @author Jaya
	 */
	public interface DailySweepstakes{
		final String DAILY_SWEEPSTAKES_DATE = "css=div.contest-dates";
		final String DAILY_SWEEPSTAKES_TOP_IMAGE = "css=div#daily-sweepstakes-container>img";
		final String DAILY_SWEEPSTAKES_HEADER = "css=h2.title";
		final String DAILY_SWEEPSTAKES_IMAGE_SMALL = "css=div#dsc-right";
		final String WORK_OUT_NOW_BUTTON = "css=a.btn-orange>span:contains(Work Out Now)";
		final String ENTER_THE_BEACHBODY_CHALLENGE_BUTTON = "css=a.btn-blue";
		final String RULES = "css=p.small_footer";
		final String PREVIOUS_WINNERS_HEADER = "css=div.portlet-borderless-container>div>div.title:contains(Previous Daily Sweepstakes Winners)";
		final String ALL_WINNERS_HEADER ="css=h5.sub-title";
		final String TOP_RESULTS_SUMMARY = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.taglib-page-iterator>div.search-results";
		final String TOP_ITEMS_PER_PAGE_LABEL = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.search-pages>div.delta-selector";
		final String TOP_PAGE_LABEL = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.search-pages div.page-selector";
		final String TOP_DISABLED_FIRST_ARROW = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.page-links span.first";
		final String TOP_ENABLED_FIRST_ARROW = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.page-links a.first";
		final String TOP_DISABLED_PREV_ARROW = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.page-links span.previous";
		final String TOP_ENABLED_PREV_ARROW = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.page-links a.previous";
		final String TOP_DISABLED_NEXT_ARROW = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.page-links span.next";
		final String TOP_ENABLED_NEXT_ARROW = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.page-links a.next";
		final String TOP_DISABLED_LAST_ARROW = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.page-links span.last";
		final String TOP_ENABLED_LAST_ARROW = "css=div[class='taglib-search-iterator-page-iterator-top clearfix'] div.page-links a.last";
		final String BOTTOM_RESULTS_SUMMARY = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.taglib-page-iterator>div.search-results";
		final String BOTTOM_ITEMS_PER_PAGE_LABEL = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.taglib-page-iterator>div.search-pages>div.delta-selector";
		final String BOTTOM_PAGE_LABEL = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.taglib-page-iterator>div.search-pages>div.page-selector";
		final String BOTTOM_DISABLED_FIRST_ARROW = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.page-links span.first";
		final String BOTTOM_ENABLED_FIRST_ARROW = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.page-links a.first";
		final String BOTTOM_DISABLED_PREV_ARROW = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.page-links span.previous";
		final String BOTTOM_ENABLED_PREV_ARROW = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.page-links a.previous";
		final String BOTTOM_DISABLED_NEXT_ARROW = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.page-links span.next";
		final String BOTTOM_ENABLED_NEXT_ARROW = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.page-links a.next";
		final String BOTTOM_DISABLED_LAST_ARROW = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.page-links span.last";
		final String BOTTOM_ENABLED_LAST_ARROW = "css=div[class='taglib-search-iterator-page-iterator-bottom'] div.page-links a.last";
		final String DAILY_SWEEPSTAKES_RULES_HEADER = "css=div.sub-title";		
		final String NAV_MENU_THE_BEACHBODY_CHALLENGE_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] ul[class='layouts level-2'] a:contains(The Beachbody Challenge)";
	}

	/**
	 * TheBeachbodyChallenge interface contains locators for web elements displayed on The Beachbody Challenge Page.
	 * @author Jaya
	 */
	public interface TheBeachbodyChallenge{
		final String TOP_ORANGE_BAR = "css=div#orange_bkg";
		final String BEACHBODY_CHALLENGE_VIDEO = "css=object#myExperience1084751769001";			 
		final String TOP_COMMIT_TO_GET_FIT_BUTTON = "css=div#video p>a.btn-orange>span";
		final String TOP_SUBMIT_YOUR_RESULTS = "css=div#video p>a.btn-blue>span";
		final String CHALLENGE_ICON = "css=div#bb_challenge_icon>img";
		final String CHALLENGE_HEADLINE = "css=h1#headline";
		final String CHALLENGE_QUOTE = "css=p#ceo_quote";
		final String SEE_BELOW_FOR_DETAILS = "css=p#details";
		final String WHATS_THE_BEACHBODY_CHALLENGE = "css=div#bb_challenge_bottom_content>h2:contains(What's The Beachbody Challenge™?)";
		final String YOU_CAN_WIN_UPTO_HEADER = "css=a.lightbox_link";
		final String PLUS_YOU_WILL_HAVE_A_CHANCE_TO_WIN_TEXT = "css=ul.bullets";
		final String BOTTOM_COMMIT_TO_GET_FIT_BUTTON = "css=div#bb_challenge_bottom_content a.btn-orange";
		final String BOTTOM_SUBMIT_YOUR_RESULTS = "css=div#bb_challenge_bottom_content a.btn-blue";
		final String MONTHLY_CONTEST_RULES_LINK = "css=p a:contains(Monthly Contest Rules)";
		final String QUARTERLY_CONTEST_RULES_LINK = "css=p a:contains(Quarterly Contest Rules)";
		final String GRAND_PRIZE_CONTEST_RULES_LINK = "css=p a:contains(Grand Prize Contest Rules)";
		final String FAQ_LINK = "css=p a:contains(FAQ)";
		final String PREVIOUS_GRAND_PRIZE_WINNERS = "css=div#results_wrap";
	}

	/**
	 * ContestFAQ interface contains locators for web elements displayed on Contest FAQ Page.
	 * @author Jaya
	 */
	public interface ContestFAQ{	 
		final String CONTEST_FAQ_HEADER = "css=h3.title";
		final String ALL_FAQ_LINKS = "//ul[@class='list-no-style']/li";
		final String ALL_BACK_TO_TOP_LINKS = "//p[@class='align-right']";
		final String ALL_FAQ_HEADERS = "//div[@class='text']//div[@class='text']//div[@class='text']//h3";
	}		 

	/**
	 * MyCoach interface contains locators for web elements displayed on My Coach Page.
	 * @author Gaurav
	 */
	public interface MyCoach {
		final String COACH_WHISTLE_IMAGE = "css=div.photo-large > div > img";
		final String COACH_IMAGE = "css=div.photo-large";
		final String COACH_TAG_IMAGE = "css=div.member-profile-basic-info > div > div.float-left-padding > img";
		final String FACEBOOK_LIKE_LINK = "css=a.connect_widget_like_button.clearfix.like_button_no_like > span:contains(Like)";

		final String ADD_AS_A_BUDDY_BUTTON = "css=input[type=submit][value='Add as a Buddy']";
		final String REPORT_THIS_PAGE_LINK = "css=a:contains(Report This Page)";

		final String COACH_BEFORE_IMAGE = "css=div.member-profile-photos-before-after > table > tbody > tr:nth(1) > td:nth(0) div.photo-medium";
		final String COACH_AFTER_IMAGE = "css=div.member-profile-photos-before-after > table > tbody > tr:nth(1) > td:nth(1) div.photo-medium";
		final String COACH_BUDDIES_COUNT = "css=div.member-profile-photos-my-buddies > div.member-profile-photo-title";

		final String COACH_FITNESS_GOAL = "css=div.member-profile-my-goal";
		final String COACH_INTRODUCTION_TEXT = "css=div.member-profile-intro-text:nth(1)";
		final String COACH_MEAL_PLAN = "css=div.member-profile-programs > div:nth(1) div:contains(Meal plan:) + div";
		final String COACH_WORKOUT_PROGRAMS = "//div[@class='member-profile-programs']/div[3]//div[contains(text(), 'Workout programs:')]/following-sibling::div";
		final String COACH_WORKOUT_PROGRAMS_BLOCK = "//div[@class='member-profile-programs']/div[3]//div[contains(text(), 'Workout programs:')]/following-sibling::div[@id='_MEMBER_PROFILE_PROGRAMS_WAR_userprofileportlet_userPrograms']";
		final String COACH_GEAR_ACCESSORIES = "//div[@class='member-profile-programs']/div[4]//div[contains(text(), 'Gear:')]/following-sibling::div";
		final String COACH_SUPPLEMENTS = "//div[@class='member-profile-programs']/div[5]//div[contains(text(), 'Supplements:')]/following-sibling::div";

		final String COACH_NEXT_WORKOUTS = "css=div:contains(WOWY SuperGym™) + div > span";
		final String VIEW_MY_WORKOUT_CALNDER_LINK = "css=a:contains(View My Workout Calendar)";
		final String COACH_WORKOUT_GROUPS = "//div[@id='p_p_id_supergymprofile_WAR_supergymportlet_']/div/div/div[5]";

		final String STATS_TOTAL_WORKOUTS_COMPLETED_TODAY = "css=table.supergym-stats-dash-dotted-line-bottom > tbody > tr:nth(1) > td > div";
		final String STATS_TODAY_PEAK = "css=table.supergym-stats-dash-dotted-line-bottom > tbody > tr:nth(2) > td > div";
		final String STATS_PEOPLE_WORKING_OUT_NOW = "css=table.supergym-stats-dash-dotted-line-bottom > tbody > tr:nth(3) > td > div";

		final String CLUB_UK_USER_ALERT = "css=span.portlet-msg-error";
	}

	/**
	 * EatingHealthy interface contains locators for web elements displayed on Eating Healthy Page.
	 * @author Gaurav
	 */
	public interface EatingHealthy {
		final String RRM_SECTION = "//div[@id='layout-column_column-5']/div";
		final String RRM_TITLE = "//div[@class='title']//span";		
	}

	/**
	 * About interface contains locators for web elements displayed on About Page.
	 * @author Jaya
	 */
	public interface About{
		final String NAV_MENU_ITEMS_TEXT_XPATH = "xpath=//div[@class=\"nav-menu nav-menu-style-\"]//ul[@class=\"layouts level-1\"]/li";
		final String MENU_LINKS_XPATH = "//div[@class='nav-menu nav-menu-style-']//ul[@class='layouts level-1']//li";
		final String CONTENT_LINKS_XPATH = "//div[@id='cont_sub_content']/ul/li";
		final String IMAGE_LINKS_XPATH = "//div[@id='cont_sub_content']/ul/li//img";
		final String CONTENT_LINKS_TEXT_XPATH = "//div[@id='cont_sub_content']/ul/li";
		final String LEARN_MORE_LINKS_XPATH = "//div[@id='cont_sub_content']/ul/li//a[contains(text(), 'more')]";
		
		final String NAV_MENU_DAILY_SWEEPSTAKES = "css=div.nav-menu.nav-menu-style- a:contains(Daily Sweepstakes)";
		final String NAV_MENU_PRODUCTS = "css=div.nav-menu.nav-menu-style- a:contains(Products)";
		final String NAV_MENU_COACHES = "css=div.nav-menu.nav-menu-style- a:contains(Coaches)";
		final String NAV_MENU_COMMUNITY = "css=div.nav-menu.nav-menu-style- a:contains(Community)";
		final String NAV_MENU_JOIN = "css=div.nav-menu.nav-menu-style- a:contains(Join)";
		final String NAV_MENU_NEWSLETTERS = "css=div.nav-menu.nav-menu-style- a:contains(Newsletters)";
		
		final String HEADER = "css=div.hdr_about>h1";
		final String INTRO_TEXT = "//div[@class='hdr_about']/p[1]";
		final String HEADER_QUOTE = "//div[@class='hdr_about']/p[2]";
		final String JOIN_UPGRADE_LEARN_MORE = "css=a.catlinks[href='/signup']";
		final String PRODUCTS_LEARN_MORE = "css=a.catlinks[href='/about/products']";
		final String COMMUNITY_LEARN_MORE = "css=a.catlinks[href='/about/community']";
		final String COACHES_LEARN_MORE = "css=a.catlinks[href='/about/coaches']";
		final String DAILY_SWEEPSTAKES_LEARN_MORE = "css=a.catlinks[href='/about/tbb-game']";
		final String NEWSLETTERS_LEARN_MORE = "css=a.catlinks[href='/about/newsletters']";
		
		final String ABOUT_PROGRAM_RRM_SECTION = "//div[@id='layout-column_column-6']/div";
		final String ABOUT_PROGRAM_RRM_TITLE = "//div[@class='title']//span";	
	}

	/**
	 * AboutJoinUpgrade interface contains locators for web elements displayed on About - Join Upgrade Page.
	 * @author Jaya
	 */
	public interface AboutJoinUpgrade{
		final String MENU_BAR_ABOUT_LINK = "css=a:contains(About)";
		final String SIGNUP_HEADER = "css=div#signup_header";
		final String SIGNUP_HEADER_IMAGE_TEXT = "css=div#signup_header>p#image_text";
		final String JOIN_UPGRADE_PREHEADER = "css=div#signup_header p#pre_header_text";
		final String JOIN_UPGRADE_HEADER = "css=div#signup_header h2";
		final String JOIN_UPGRADE_POSTHEADER = "css=div#signup_header>p#post_header_text";
		final String INTRO_TEXT = "//div[@id='signup_header']/p[4]";
		final String YES_SIGN_ME_UP_FOR_CLUB_MEMBERSHIP = "css=div#signup_header>p>a[href='/signup/-/signup/club/']>img";
		final String SIGN_ME_UP_FOR_FREE_MEMBERSHIP = "css=div#signup_header>p>a[href='/signup/-/signup/free/']>img";
		final String WORKING_OUT_IS_JUST_ONE_PIECE_SUB_HEADER = "css=p.sub_header";
		final String SUB_HEADER_INTRO_TEXT = "css=p.bold";
		final String SIGNUP_GRID_HEADER = "css=div#signup_grid>h3";
		final String SIGNUP_GRID = "css=div#signup_grid";
		final String ALL_TBB_MEMBERSHIP_BENEFITS = "//div[@id='signup_grid']//p";
		final String ALL_CLUB_CHECKMARK = "//div[@id='signup_grid']//img[@alt='Club checkmark']";
		final String ALL_FREE_UNCHECKED = "//div[@id='signup_grid']//img[@alt='Free unchecked']";
		final String ALL_FREE_CHECKMARK = "//div[@id='signup_grid']//img[@alt='Free checkmark']";
		final String SECONDARY_TEXT_JOIN_TEAMBEACHBODY_TODAY = "css=div#secondary_text>h3";
		final String SECONDARY_IMAGE = "css=img#secondary_image";
		final String ALL_SECONDARY_TEXT_PARAGRAPHS = "//div[@id='secondary_text']//p";
		final String CLUB_SIGN_UP_BUTTON_AT_THE_BOTTOM = "css=p#club_signup_btn>a"; 
		final String FREE_SIGN_UP_BUTTON_AT_THE_BOTTOM = "css=p#free_signup_btn>a";
	}

	/**
	 * AboutCommunity interface contains locators for web elements displayed on About - Community Page.
	 * @author Jaya
	 */
	public interface AboutCommunity{
		final String COMMUNITY_HEADER = "css=h1.title";
		final String COMMUNITY_INTRO_TEXT = "css=div.journal-content-article>p:contains(community)";
		final String COMMUNITY_IMAGE = "css=div.journal-content-article>p>img";
		final String JUST_A_FEW_OF_OUR_ACTIVE_MEMBERS_TEXT = "css=h4.sub-title div";
		final String SEE_ENTIRE_MEMBER_GALLERY_LINK = "css=h4.sub-title a";
		final String DISABLED_PREVIOUS_ARROW = "css=div[class='carousel-prev column disabled']>div";
		final String ENABLED_PREVIOUS_ARROW = "css=div[class='carousel-prev column']>div";
		final String DISABLED_NEXT_ARROW = "css=div[class='carousel-next column disabled']>div";
		final String ENABLED_NEXT_ARROW = "css=div[class='carousel-next column']>div";
		final String ALL_IMAGES_BETWEEN_ARROWS = "//div[@class='photo-small']/div";
		final String TEAM_BEACHBODY_IS_YOUR_TOTAL_FITNESS_SOLUTION_TEXT = "css=p>span:contains(Team Beachbody is your total fitness solution.)";
		final String TOTAL_FITNESS_SOLUTION_INTRO_TEXT = "css=div.journal-content-article p:contains(With so many ways to make friends and stay connected, you're never alone at Team Beachbody!)";
		final String ALL_TOTAL_FITNESS_SOLUTION_IMAGES = "//div[@class='frame_small']/a/img";
		final String ALL_TOTAL_FITNESS_SOLUTION_HEADERS = "//div[@class='text_area']/p/strong";
		final String ALL_TOTAL_FITNESS_SOLUTION_TEXT = "//div[@class='text_area']/p[2]";
		final String ALL_TOTAL_FITNESS_SOLUTION_LINKS = "//div[@class='text_area']/p/a";
		final String FIND_BUDDIES_NOW_LINK = "css=div.text_area>p>a:contains(Find Buddies now)";
		final String FIND_WORKOUT_GROUPS_LINK = "css=div.text_area>p>a:contains(Find Workout Groups)";
		final String VISIT_MESSAGE_BOARDS_LINK = "css=div.text_area>p>a:contains(Visit Message Boards)";
		final String VISIT_BLOGS_LINK = "css=div.text_area>p>a:contains(Visit Blogs)";
		final String VISIT_THE_MESSAGE_CENTER_LINK = "css=div.text_area>p>a:contains(Visit the Message Center)";
		final String VISIT_WOWY_SUPERGYM_LINK = "css=div.text_area>p>a:contains(Visit WOWY)";
	}

	/**
	 * About Coaches interface contains locators for web elements displayed on About - Coaches Page.
	 * @author Jaya
	 */
	public interface AboutCoaches{
		final String COACHES_HEADER = "css=div.header-text>h3.title";
		final String COACHES_INTRO_TEXT = "css=div.header-text>p:contains(Coaches)";
		final String COACHES_IMAGE = "css=div.header-text>p>img";
		final String MEET_A_FEW_OF_OUR_INSPIRINT_COACHES_TEXT = "css=h4.sub-title";
		final String SEE_ENTIRE_GALLERY_LINK = "css=a.sub-title-note";
		final String ALL_INSPIRING_COACHES_PHOTOS = "//div[@class='photo-small']";
		final String WHAT_ARE_TEAM_BEACHBODY_COACHES_HEADER = "css=div.journal-content-article>h3";
		final String ALL_WHAT_ARE_TBB_COACHES_PHOTOS = "//span[@class='frame_small']";
		final String ALL_WHAT_ARE_TBB_COACHES_TEXT = "//div[@id='cont_coach_pages']//ul//li//p";
	}

	/**
	 * AboutDailySweepstakes interface contains locators for web elements displayed on About - Daily Sweepstakes Page.
	 * @author Jaya
	 */
	public interface AboutDailySweepstakes{
		final String DAILY_SWEEPSTAKES_TOP_IMAGE = "css=div#daily-sweepstakes-container>img";
		final String DAILY_SWEEPSTAKES_HEADER = "css=div#dsc-left>h2.title";
		final String DAILY_SWEEPSTAKES_SMALL_IMAGE = "css=div#dsc-right>img";
		final String ALL_DAILY_SWEEPSTAKES_INTRO_TEXT = "css=div#dsc-left p";
		final String WORKOUT_NOW_BUTTON = "css=a.btn-orange>span";
		final String ENTER_THE_BEACHBODY_CHALLENGE_BUTTON = "css=a.btn-blue>span";
		final String DAILY_SWEEPSTAKES_FOOTER = "css=p.small_footer";
		final String WOWY_SUPERGYM_DAILY_SWEEPSTAKES_RULES_LINK = "css=p.small_footer>a";
	}

	/**
	 * AboutProducts interface contains locators for web elements displayed on About - Products Page.
	 * @author Jaya
	 */
	public interface AboutProducts{
		final String PRODUCTS_HEADER = "css=h3.title";
		final String PRODUCTS_INTRO_TEXT = "css=p#top_text";
		final String ALL_PRODUCTS = "//div[@id='cont_fitness_program']//ul//li";
		final String FITNESS_PROGRAMS_HEADER = "css=div#product_description h3:contains(FITNESS PROGRAMS)";
		final String FITNESS_PROGRAMS_IMAGE = "css=a[title='Click here to view more detailed information about our fitness programs.']>img";
		final String FITNESS_PROGRAMS_TEXT = "css=div#product_description p:contains(fitness goals)";
		final String FIND_YOUR_IDEAL_FITNESS_PROGRAM_NOW_LINK = "css=a.text_link[href='/get-fit/fitness-programs']";
		final String NUTRITION_AND_SUPPLEMENTS_HEADER = "css=div#cont_fitness_program ul li div#product_description>h3:contains(NUTRITION)";
		final String NUTRITION_AND_SUPPLEMENTS_IMAGE = "css=a[title='Click here to view more detailed information about our supplements.']>img";
		final String NUTRITION_AND_SUPPLEMENTS_TEXT = "css=ul li div#product_description p:contains(nutrition)";
		final String FIND_A_SUPPLEMENT_NOW_LINK = "css=a.text_link[href='/eat-smart/supplements']";			 
	}

	/**
	 * AboutNewsletters interface contains locators for web elements displayed on About - Newsletters Page.
	 * @author Jaya
	 */
	public interface AboutNewsletters{
		final String NEWSLETTERS_HEADER = "css=h3.title";
		final String NEWSLETTERS_INTRO_TEXT = "css=div.newsletter-topper>p";
		final String NEWSLETTERS_IMAGE = "css=div.newsletter-image";
		final String FEATURED_ISSUE_IMAGE = "css=table.featured-issue>tbody>tr>td>a>img";
		final String FEATURED_ISSUE_TAG = "css=div.featured-issue-tag";
		final String FEATURED_ISSUE_TITLE = "css=div.featured-issue-title";
		final String ALL_FEATURED_ISSUE_TEXT_ROWS = "css=table.featured-issue>tbody>tr>td>ul>li";
		final String ALL_YEAR_TABS = "css=div.newsletter-year ";
		final String FILTER_BY_MONTH_DROPDOWN = "css=select#selectMonthView";
		final String ALL_NEWSLETTER_MONTH_HEADER_ROWS = "css=div.newsletter-month div.newsletter-header";
		final String ALL_CONTENT_ROWS = "css=div.content-row";
		final String EMAIL_UNSUBSCRIBE_LINK = "css=p[class='float-right-padding clearfix']>a";
	}

	/**
	 * WatchVideos interface contains locators for web elements displayed on Watch Videos Page.
	 * @author Jaya
	 */
	public interface WatchVideos{
		final String NAV_MENU_ITEMS_XPATH = "//div[@class='nav-menu nav-menu-style-']//ul[@class='layouts level-1']//li";
		final String NAV_MENU_ITEMS_TEXT_XPATH = "xpath=//div[@class=\"nav-menu nav-menu-style-\"]//ul[@class=\"layouts level-1\"]/li";
		final String NAV_MENU_SUCCESS_STORIES_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Success Stories)";
		final String NAV_MENU_PRODUCTS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Products)";
		final String NAV_MENU_EATING_HEALTHY_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Eating Healthy)";
		final String NAV_MENU_WORKOUT_TIPS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Workout Tips)";
		final String NAV_MENU_CONTESTS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Contests)";
		final String NAV_MENU_CELEBRITY_TRAINERS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Celebrity Trainers)";
		final String NAV_MENU_COACHES_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Coaches)";
		final String NAV_MENU_HEALTH_NEWS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Health News)";
		final String NAV_MENU_TEAM_BEACHBODY_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Team Beachbody)";
		final String NAV_MENU_VIP_WORKOUTS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(VIP Workouts)";
		final String NAV_MENU_VIP_FITNESS_TIPS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(VIP Fitness Tips)";
		final String NAV_MENU_VIP_RECIPES_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(VIP Recipes)";
		final String NAV_MENU_VIP_STYLE_TIPS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(VIP Style Tips)";
		
		final String CLUB_UK_USER_ALERT = "css=span.portlet-msg-error";
		final String WATCH_VIDEOS_HEADER = "css=div.hdr_pad>h1";
		final String WATCH_VIDEOS_INTRO_TEXT = "css=div.hdr_pad>p";
		final String WATCH_VIDEOS_VIDEO = "css=div.hdr_pad object#myExperience";
		final String ALL_IMAGES = "//div[@id='cont_sub_content']/ul/li//img";
		final String ALL_TEXT = "//div[@id='cont_sub_content']/ul/li//p[1]";
		final String CONTENT_BOXES_XPATH = "//div[@id='cont_sub_content']/ul/li";
		final String ALL_WATCH_NOW_LINK = "//div[@id='cont_sub_content']/ul/li//p[2]";
		final String SUCCESS_STORIES_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/success-stories']";
		final String PRODUCTS_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/products']";
		final String EATING_HEALTHY_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/eating-healthy']";
		final String WORKOUT_TIPS_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/workout-tips']";
		final String CONTESTS_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/contests']";
		final String CELEBRITY_TRAINERS_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/celebrity-trainers']";
		final String COACHES_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/coaches']";
		final String HEALTH_NEWS_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/health-news']";
		final String TEAM_BEACHBODY_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/team-beachbody']";
		final String VIP_WORKOUTS_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/vip-workouts']";
		final String VIP_FITNESS_TIPS_LINK = "css=a.catlinks[href='/watch/vip-fitness-tips']";
		final String VIP_RECIPES_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/vip-recipes']";
		final String VIP_STYLE_TIPS_WATCH_NOW_LINK = "css=a.catlinks[href='/watch/vip-style-tips']";	
		
		final String WATCH_VIDEOS_PROGRAM_RRM_SECTION = "//div[@id='layout-column_column-6']/div";
		final String WATCH_VIDEOS_PROGRAM_RRM_TITLE = "//div[@class='title']//span";	
	}	

	/**
	 * WatchVideosSuccessStories interface contains locators for web elements displayed
	 * on Watch Videos - Success Stories Page.
	 * @author Gaurav
	 */
	public interface WatchVideosSuccessStories{
		final String WATCH_VIDEOS_MENU_LINK = "css=a:contains(Watch Videos)";
		final String COACH_BUSINESS_SUCCESS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Coach Business Success)";
		final String SHAKEOLOGY_SUCCESS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Shakeology)";
		final String P90X_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(P90X)";
		final String INSANITY_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(INSANITY)";
		final String BRAZIL_BUTT_LIFT_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Brazil Butt Lift)";
		final String TURBO_FIRE_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(TurboFire)";
		final String SLIM_IN_6_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Slim in 6)";
		final String POWER_90_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Power 90)";
		final String TURBO_JAM_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Turbo Jam)";
		final String TEN_MINUTE_TRAINER_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(10-Minute Trainer)";
		final String HIP_HOP_ABS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Hip Hop Abs)";
		final String CHALEAN_EXTREME_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(ChaLEAN Extreme)";
		final String YOGA_BOOTY_BALLET_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Yoga Booty Ballet)";
		final String KSPY2_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(KSPY2)";
		final String SHAUN_T_FIT_KIDS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Shaun T)";
		final String ROCKIN_BODY_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Rockin' Body)";
		
		final String WATCHVIDEOS_SUCCESS_STORIES_PROGRAM_RRM_SECTION = "//div[@id='layout-column_column-5']/div";
		final String WATCHVIDEOS_SUCCESS_STORIES_PROGRAM_RRM_TITLE = "//div[@class='title']//span";	
	}

	/**
	 * WatchVideosProducts interface contains locators for web elements displayed on Watch Videos - Products Page.
	 * @author Jaya
	 */
	public interface WatchVideosProducts{
		final String SHAKEOLOGY_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Shakeology)";
		final String P90X_LINK ="css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(P90X)";
		final String INSANITY_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(INSANITY)";
		final String BRAZIL_BUTT_LIFT_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Brazil Butt Lift)";
		final String TURBO_FIRE_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(TurboFire)";
		final String BODY_GOSPEL_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Body Gospel)";
		final String SLIM_IN_6_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Slim in 6)";
		final String POWER_90_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Power 90)";
		final String TURBO_JAM_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Turbo Jam)";
		final String TEN_MINUTE_TRAINER_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(10-Minute Trainer)";
		final String P90X_ONE_ON_ONE_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(P90X ONE on ONE)";
		final String REVABS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(RevAbs)";
		final String HIP_HOP_ABS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Hip Hop Abs)";
		final String CHALEAN_EXTREME_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(ChaLEAN Extreme)";
		final String ROCKIN_BODY_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Rockin' Body)";
		final String KSPY2_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(KSPY2)";
		final String TOTAL_BODY_SOLUTION_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Total Body Solution)";
		final String YOGA_BOOTY_BALLET_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Yoga Booty Ballet)";		
	}

	/**
	 * WatchVideosCelebrityTrainers interface contains locators for web elements displayed 
	 * on Watch Videos - Celebrity Trainers Page.
	 * @author Gaurav
	 */
	public interface WatchVideosCelebrityTrainers{
		final String TONY_HORTON_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Tony Horton)";
		final String CHALENE_JOHNSON_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Chalene Johnson)";
		final String SHAUN_T_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Shaun)";
		final String DEBBIE_SIEBERS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Debbie Siebers)";
	}

	/**
	 * WatchVideosCoaches interface contains locators for web elements displayed 
	 * on Watch Videos - Coaches Page.
	 * @author Jaya
	 */
	public interface WatchVideosCoaches{
		final String EVENTS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Events)";
		final String PERSONAL_STORIES_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Personal Stories)";
		final String GIVING_BACK_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Giving Back)";
	}

	/**
	 * WatchVideosTeamBeachbody interface contains locators for web elements displayed 
	 * on Watch Videos - Team Beachbody Page.
	 * @author Gaurav
	 */
	public interface WatchVideosTeamBeachbody{
		final String NEWS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-2'] li a:contains(News)";
		final String GIVING_BACK_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Giving Back)";
		final String INSIDE_TBB_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Inside TBB)";
	}

	/**
	 * WatchVideosVIPWorkouts interface contains locators for web elements displayed 
	 * on Watch Videos - VIP Workouts Page.
	 * @author Jaya
	 */
	public interface WatchVideosVIPWorkouts{
		final String TONY_HORTON_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Tony Horton)";
		final String CHALENE_JOHNSON_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Chalene Johnson)";
		final String SHAUN_T_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Shaun T)";
		final String DEBBIE_SIEBERS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Debbie Siebers)";
		final String GILLIAN_AND_TEIGH_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Gillian)";
		final String LEANDRO_CARVALHO_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Leandro Carvalho)";
		final String BRETT_HOEBEL_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Brett Hoebel)";
		final String SUPER_WORKOUTS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Super Workouts)";
	}

	/**
	 * WatchVideosVIPFitnessTips interface contains locators for web elements displayed 
	 * on Watch Videos - VIP Fitness Tips Page.
	 * @author Gaurav
	 */
	public interface WatchVideosVIPFitnessTips{
		final String TONY_HORTON_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Tony Horton)";
		final String CHALENE_JOHNSON_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Chalene Johnson)";
		final String SHAUN_T_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Shaun)";
		final String DEBBIE_SIEBERS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Debbie Siebers)";
		final String GILLIAN_AND_TEIGH_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Gillian)";
		final String LEANDRO_CARVALHO_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Leandro Carvalho)";
		final String BRETT_HOEBEL_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Brett Hoebel)";
		final String SUPER_WORKOUTS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(Super Workouts)";
	}

	/**
	 * WatchVideosVIPRecipes interface contains locators for web elements displayed 
	 * on Watch Videos - VIP Recipes Page.
	 * @author Jaya
	 */
	public interface WatchVideosVIPRecipes{
		final String VIP_HEALTHY_EATING_TIPS_LINK = "css=div[class='nav-menu nav-menu-style-'] ul[class='layouts level-1'] li a:contains(VIP Healthy Eating Tips)";
	}

	/**
	 * Shop interface contains locators for web elements displayed on Shop Page.
	 * @author Jaya
	 */
	public interface Shop{
		final String CLUB_UK_USER_ALERT = "css=span.portlet-msg-error";
		final String FITNESS_PROGRAM = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li>a[href='ShoppingCart.asp?Cat=Fitness Program|ALL']";
		final String TRAINER = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li>a:contains(Trainer)";
		final String NUTRITION_AND_SUPPLEMENTS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li>a:contains(Nutrition and Supplements)";
		final String EQUIPMENT_AND_GEAR = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li>a:contains(Equipment and Gear)";
		final String COACH_PRODUCTS_AND_TOOLS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li>a:contains(Coach Products and Tools)";

		final String TEN_MINUTE_TRAINER = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(10-Minute Trainer)";
		final String ASYLUM = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Asylum)";
		final String FITNESS_PROGRAM_BEST_SELLERS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Best Sellers)";
		final String BODY_GOSPEL = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Body Gospel)";
		final String BRAZIL_BUTT_LIFT = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Brazil Butt Lift)";
		final String CHALEAN_EXTREME = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(ChaLEAN Extreme)";
		final String HIP_HOP_ABS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Hip Hop Abs)";
		final String INSANITY = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(INSANITY)";
		final String KSPY_T2 = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(KSPY)";
		final String MORE_PROGRAMS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(More Programs)";
		final String NEW_PRODUCTS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(New Products)";
		final String P90X = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(P90X)";
		final String P90X_ONE_ON_ONE = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(P90X One on One)";
		final String POWER_90 = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Power 90)";
		final String REVABS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(RevAbs)";
		final String ROCKING_BODY = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Rockin Body)";
		final String SLIM_IN_6 = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Slim in 6)";
		final String TOTAL_BODY_SOLUTION = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Total Body Solution)";
		final String TURBO_JAM = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Turbo Jam)";
		final String TURBO_FIRE = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(TurboFire)";
		final String YOGA_BOOTY_BALLET = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Yoga Booty Ballet)";

		final String TEN_MINUTE_TRAINER_HEADER = "css=span.CategoryText:contains(10-Minute Trainer)";
		final String ASYLUM_HEADER = "css=span.CategoryText:contains(Asylum)";
		final String BEST_SELLERS_HEADER = "css=span.CategoryText:contains(Best Sellers)";
		final String BODY_GOSPEL_HEADER = "css=span.CategoryText:contains(Body Gospel)";
		final String BRAZIL_BUTT_LIFT_HEADER = "css=span.CategoryText:contains(Brazil Butt Lift)";
		final String CHALEAN_EXTREME_HEADER = "css=span.CategoryText:contains(ChaLEAN Extreme)";
		final String HIP_HOP_ABS_HEADER = "css=span.CategoryText:contains(Hip Hop Abs)";
		final String INSANITY_HEADER = "css=span.CategoryText:contains(INSANITY)";
		final String KSPY_T2_HEADER = "css=span.CategoryText:contains(KSPY T2)";
		final String MORE_PROGRAMS_HEADER = "css=span.CategoryText:contains(More Programs)";
		final String NEW_PRODUCTS_HEADER = "css=span.CategoryText:contains(New Products)";
		final String P90X_HEADER = "css=span.CategoryText:contains(P90X)";
		final String P90X_ONE_ON_ONE_HEADER = "css=span.CategoryText:contains(P90X One on One)";
		final String POWER_90_HEADER = "css=span.CategoryText:contains(Power 90)";
		final String REVABS_HEADER = "css=span.CategoryText:contains(RevAbs)";
		final String ROCKING_BODY_HEADER = "css=span.CategoryText:contains(Rockin Body)";
		final String SLIM_IN_6_HEADER = "css=span.CategoryText:contains(Slim in 6)";
		final String TOTAL_BODY_SOLUTION_HEADER = "css=span.CategoryText:contains(Total Body Solution)";
		final String TURBO_JAM_HEADER = "css=span.CategoryText:contains(Turbo Jam)";
		final String TURBO_FIRE_HEADER = "css=span.CategoryText:contains(TurboFire)";
		final String YOGA_BOOTY_BALLET_HEADER = "css=span.CategoryText:contains(Yoga Booty Ballet)";			 

		final String ADD_TO_CART_BTN = "//span[@class='AddToCart AddToCartButton']";

		final String BRETT_HOEBEL = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Brett Hoebel)";
		final String CHALENE_JOHNSON = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Chalene Johnson)";
		final String DEBBIE_SIEBERS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Debbie Siebers)";
		final String DONNA_RICHARDSON_JOYNER = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Donna Richardson Joyner)";
		final String GILLIAN_AND_TEIGH = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Gillian and Teigh)";
		final String KATHY_SMITH = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Kathy Smith)";
		final String LEANDRO_CARVALHO = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Leandro Carvalho)";
		final String SHAUN_T = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(SHAUN T)";
		final String SHAUN_T_EN_ESPANOL = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(SHAUN T en Espanol)";
		final String TONY_HORTON = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Tony Horton)";
		final String TONY_HORTON_EN_ESPNOL = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Tony Horton en Espanol)";

		final String BRETT_HOEBEL_HEADER = "css=span.CategoryText:contains(Brett Hoebel)";
		final String CHALENE_JOHNSON_HEADER = "css=span.CategoryText:contains(Chalene Johnson)";
		final String DEBBIE_SIEBERS_HEADER = "css=span.CategoryText:contains(Debbie Siebers)";
		final String DONNA_RICHARDSON_JOYNER_HEADER = "css=span.CategoryText:contains(Donna Richardson)";
		final String GILLIAN_AND_TEIGH_HEADER = "css=span.CategoryText:contains(Gillian and Teigh)";
		final String KATHY_SMITH_HEADER = "css=span.CategoryText:contains(Kathy Smith)";
		final String LEANDRO_CARVALHO_HEADER = "css=span.CategoryText:contains(Leandro Carvalho)";
		final String SHAUN_T_HEADER = "css=span.CategoryText:contains(SHAUN T)";
		final String SHAUN_T_EN_ESPANOL_HEADER = "css=span.CategoryText:contains(SHAUN T en Espanol)";
		final String TONY_HORTON_HEADER = "css=span.CategoryText:contains(Tony Horton)";
		final String TONY_HORTON_EN_ESPNOL_HEADER = "css=span.CategoryText:contains(Tony Horton en Espanol)";

		final String NUTRITION_BEST_SELLERS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Best Sellers)";
		final String HEALTH_AND_WELLNESS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Health and Wellness)";
		final String NUTRITION_PACKS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Nutrition Packs)";
		final String P90X_NUTRITION = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(P90X  Nutrition)";
		final String SHAKEOLOGY = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Shakeology)";
		final String SPORTS_PERFORMANCE = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Sports Performance)";
		final String WEIGHT_MANAGEMENT = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Weight Management)";

		final String NUTRITION_BEST_SELLERS_HEADER = "css=span.CategoryText:contains(Best Sellers)";
		final String HEALTH_AND_WELLNESS_HEADER = "css=span.CategoryText:contains(Health and Wellness)";
		final String NUTRITION_PACKS_HEADER = "css=span.CategoryText:contains(Nutrition Packs)";
		final String P90X_NUTRITION_HEADER = "css=span.CategoryText:contains(P90X  Nutrition)";
		final String SHAKEOLOGY_HEADER = "css=span.CategoryText:contains(Shakeology)";
		final String SPORTS_PERFORMANCE_HEADER = "css=span.CategoryText:contains(Sports Performance)";
		final String WEIGHT_MANAGEMENT_HEADER = "css=span.CategoryText:contains(Weight Management)";

		final String APPAREL = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Apparel)";
		final String ASYLUM_EQUIPMENT = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Asylum Equipment)";
		final String BANDS_AND_BALLS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Bands and Balls)";
		final String CHINUP_AND_PUSH_UP = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Chin up and Push up)";
		final String HEALTH_MONITORS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Health Monitors)";
		final String P90X_EQUIPMENT = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(P90X Equipment)";
		final String SCULPTING_AND_TONING = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Sculpting and Toning)";
		final String YOGA = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Yoga)";

		final String APPAREL_HEADER = "css=span.CategoryText:contains(Apparel)";
		final String ASYLUM_EQUIPMENT_HEADER = "css=span.CategoryText:contains(Asylum Equipment)";
		final String BANDS_AND_BALLS_HEADER = "css=span.CategoryText:contains(Bands and Balls)";
		final String CHINUP_AND_PUSH_UP_HEADER = "css=span.CategoryText:contains(Chin up and Push up)";
		final String HEALTH_MONITORS_HEADER = "css=span.CategoryText:contains(Health Monitors)";
		final String P90X_EQUIPMENT_HEADER = "css=span.CategoryText:contains(P90X Equipment)";
		final String SCULPTING_AND_TONING_HEADER = "css=span.CategoryText:contains(Sculpting and Toning)";
		final String YOGA_HEADER = "css=span.CategoryText:contains(Yoga)";

		final String BEACHBODY_SHARING_TOOLS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Beachbody Sharing Tools)";
		final String COACH_PACKS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Coach Packs)";
		final String PROMOTIONAL_ITEMS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Promotional Items)";
		final String SHAKEOLOGY_ITEMS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Shakeology Items)";
		final String TRAINING_TOOLS = "css=div#LeftMenuCategory>ul#csShoppingMenuCategory li.selected ul li a:contains(Training Tools)";

		final String BEACHBODY_SHARING_TOOLS_HEADER = "css=span.CategoryText:contains(Beachbody Sharing Tools)";
		final String COACH_PACKS_HEADER = "css=span.CategoryText:contains(Coach Packs)";
		final String PROMOTIONAL_ITEMS_HEADER = "css=span.CategoryText:contains(Promotional Items)";
		final String SHAKEOLOGY_ITEMS_HEADER = "css=span.CategoryText:contains(Shakeology Items)";
		final String TRAINING_TOOLS_HEADER = "css=span.CategoryText:contains(Training Tools)";	
	}

	/**
	 * Coach interface contains locators for web elements displayed on Coach Page.
	 * @author Gaurav
	 */
	public interface Coach {
		final String COACH_CLIP_ITEM = "//div[@class='jcarousel-container jcarousel-container-horizontal']//ul[@id='coach_video_carousel']/li";
		final String PDF_COACH_POLICIES = "//div[@id='pdfs']/p/a[1]";
		final String PDF_COACH_STATEMENT_OF_INDEPENDENT_COACH = "//div[@id='pdfs']/p/a[2]";
		final String EMAIL_COLLECTOR_NOT_US_COACH_REQUEST = "css=div#email_collector a>img[alt='Click here']";
		final String TBB_BRAND_ITEM = "//div[@class='jcarousel-clip jcarousel-clip-horizontal']//ul[@id='coach_product_carousel']/li";
		final String FOUNDER_MESSAGE = "Together, we're working to end the trend of obesity, helping others on their journey toward improved fitness and financial independence. This happens with hard work, people helping each other, and a commitment to NEVER give up. This is the solution! But we need your help to reach our goals. I mean—we need YOU!";
		final String FOUNDER_IMAGE = "css=div#box_2>img[alt='Carl Daikeler, Beachbody® CEO']";
		final String TBB_TICKER = "css=div#p_p_id_TBB_TICKER_WAR_generalportlet_";
		final String COACH_SIGN_UP = "css=a.coach_btn > img[alt='YES! I want to be a Team Beachbody Coach']";
		final String COACH_FAQ = "css=div.coach_landing_page > div > ul > li >a";
		final String COACH_SIGN_IN = "css=a:contains(Coach Sign In)";

		final String COACH_ONLINE_OFFICE_LINK = "css=a:contains(Coach Online Office)";
		final String COACH_PRVIOUS_OFFICE_VIEW_LINK = "css=a:contains(Previous Office View)";

	}

	/**
	 * CoachFAQ interface contains locators for web elements displayed on Coach FAQ Page.
	 * @author Gaurav
	 */
	public interface CoachFAQ {
		final String COACH_FAQ_HEADING = "css=div#p_p_id_56_INSTANCE_zjF1_ > div.portlet-borderless-container h3.title";
		final String COACH_FAQ_ITEM = "//div[@id='p_p_id_56_INSTANCE_zjF1_']/div[@class='portlet-borderless-container']//ul[@class='list-no-style']/li";
		final String COACH_FAQ_SECTION = "//div[@id='p_p_id_56_INSTANCE_zjF1_']/div[@class='portlet-borderless-container']//ul[@class='list-no-style']";
		final String BACK_TO_TOP_LINK = "//div[@id='p_p_id_56_INSTANCE_zjF1_']/div[@class='portlet-borderless-container']/div/div/div/p/a[contains(text(),'Back to top')]";
		final String CLICK_HERE_LINK = "css=a:contains(click here!)";
		final String RRM_SECTION = "//div[@id='layout-column_column-5']/div";
		final String RRM_TITLE = "//div[@class='title']//span";	

		final String COACH_DESTINATIONS_LINK = "css=a:contains(Coach Destinations)";
	}

	/**
	 * CoachDestinations interface contains locators for web elements displayed on Coach Destinations Page.
	 * @author Gaurav
	 */
	public interface CoachDestinations {
		public String HEADER_CONTACT_US_LINK = "css=div#header-navigation > ul > li > a > span:contains(Contact Us)";
		public String HEADER_NOT_A_COACH_LINK = "css=div#header-navigation > ul > li > a > span:contains(Not a Coach?)";
		public String HEADER_SPANISH_LANGUAGE_LINK = "css=div#header-navigation > ul > li > a:contains(En español)";
		public String BANNER_HEADING = "css=div#banner > h1.logo > a";
		public String HOME_LINK = "css=div#banner > div#navigation > ul > li > a > span:contains(Home)";
		public String HOW_TO_QUALIFY_LINK = "css=div#banner > div#navigation > ul > li > a > span:contains(How To Qualify)";
		public String REWARDS_LINK = "css=div#banner > div#navigation > ul > li > a > span:contains(Rewards)";
		public String TESTIMONIALS_LINK = "css=div#banner > div#navigation > ul > li > a > span:contains(Testimonials)";
		public String TRAVEL_INFO_LINK = "css=div#banner > div#navigation > ul > li > a > span:contains(Travel Info)";
		public String FACEBOOK_LIKE_LINK = "css=div.connect_button_container > a.connect_widget_like_button.clearfix.like_button_no_like > span:contains(Like)";
		public String PHOTO_GALLERY = "css=div#microPhotoGallery";
		public String PHOTO_GALLERY_LAST_PHOTO_LINK = "css=div#microPhotoGallery > ul.navigation-container > li > a:contains(Last Photo)";
		public String PHOTO_GALLERY_NEXT_PHOTO_LINK = "css=div#microPhotoGallery > ul.navigation-container > li > a:contains(Next Photo)";
		public String COACH_DESTINATION_2012 = "//div[@class='home_indent']";
		public String COACH_DESTINATION_2012_ATLANTIS = "css=div.home_indent > p > strong:contains(2012 Success Club Trip | Atlantis, the Bahamas)";
		public String DESTINATION_ATLANTIS_HOW_TO_QUALIFY_LINK = "css=div.home_indent > p > a:contains(How to Qualify)";
		public String DESTINATION_ATLANTIS_DISCOVER_ATLANTIS_LINK = "css=div.home_indent > p > a:contains(Discover Atlantis)";
		public String FEATURE_1_VIDEO  = "css=div#featBox_1 > div#featVideo";
		public String FEATURE_2_TRIP_QUALIFIERS = "css=div#featBox_2 > div.tab-container > h3:contains(2011 Trip Qualifiers:)";
		public String FEATURE_2_TRIP_QUALIFIERS_SUCCESS_CLUB_CRUISE_MEMBER = "//div[@class='tab-container-body tab-container-body-club-members']/ul/li/strong";
		public String FEATURE_2_TRIP_QUALIFIERS_CHAIRMAN_CLUB_ADVENTURE_MEMBER = "//div[@class='tab-container-body tab-container-body-top-coach']/ul/li/strong";
		public String FEATURE_3_WHATS_NEW = "css=div#featBox_3 > h3:contains(What's New)";
		public String FOOTER_LOGO = "css=div#footer-navigation > p.logo > a:contains(Home - Team Beachbody)";
		public String FOOTER_HOME_LINK = "css=div#footer-navigation-clear > ul > li > a > span:contains(Home)";
		public String FOOTER_HOW_TO_QUALIFY_LINK = "css=div#footer-navigation-clear > ul > li > a > span:contains(How To Qualify)";
		public String FOOTER_REWARDS_LINK = "css=div#footer-navigation-clear > ul > li > a > span:contains(Rewards)";
		public String FOOTER_TESTIMONIALS_LINK = "css=div#footer-navigation-clear > ul > li > a > span:contains(Testimonials)";
		public String FOOTER_TRAVEL_INFO_LINK = "css=div#footer-navigation-clear > ul > li > a > span:contains(Travel Info)";
	}

	/**
	 * My Account interface contains locators for web elements displayed on My Account Page.
	 * @author Jaya
	 */
	public interface MyAccount{
		final String EMAIL_TEXTBOX = "css=div.right>input[name='_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_emailAddress']";
		final String FIRST_NAME_TEXTBOX = "css=div.right>input[name='_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_firstName']";
		final String LAST_NAME_TEXTBOX = "css=div.right>input[name='_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_lastName']";
		final String COUNTRY_DROPDOWN = "css=select#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressCountryId0";
		final String ADDRESS_TEXTBOX = "css=input#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressStreet10";
		final String APT_SUITE_ETC_TEXTBOX = "css=input#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressStreet20";
		final String CITY_TEXTBOX = "css=input#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressCity0";
		final String STATE_DROPDOWN = "css=select#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressRegionId0";
		final String ZIP_TEXTBOX = "css=input#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressZip0";
		final String PHONE_TEXTBOX = "css=input#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_phoneNumber0";
		final String SAVE_BUTTON = "css=span.btn-blue>input[value='Save']";		
		final String RESET_BUTTON = "css=span.btn-white>input[value='Reset']";
		final String SUCCESS_MESSAGE = "css=div.portlet-msg-success";
		
		final String BILLING_COUNTRY = "css=div.right>select#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressCountryId1";
		final String BILLING_ADDRESS = "css=div.right>input#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressStreet11";
		final String BILLING_APT_SUITE_ETC = "css=div.right>input#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressStreet21";
		final String BILLING_CITY = "css=div.right>input#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressCity1";
		final String BILLING_STATE = "css=div.right>select#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressRegionId1";
		final String BILLING_ZIP = "css=div.right>input#_MYACCOUNT_PERSONAL_INFO_WAR_myaccountportlet_addressZip1";
		final String UNLINK = "css=a[class='fb_button fb_button_medium']>span.fb_button_text:contains(Unlink)";
	}

	/**
	 * CoachOnlineOffice interface contains locators for web elements displayed on Coach Online Office Page.
	 * @author Gaurav
	 */
	public interface CoachOnlineOffice {
		public String BEACHBODY_MAIN_LOGO = "css=div#logoMain";
		public String RETURN_TO_TEAM_BEACHBODY_BUTTON = "css=div#headerRight > button > div > div > span:contains(Return to Team Beachbody)";
		public String LOGOUT_BUTTON = "css=div#headerRight > button > div > div > span:contains(Logout)";
		public String CURRENT_DATE = "css=div#headerRight > h3";

		public String HEADER_HOME_LINK = "css=ul#sfNavigation.sf-menu.sf-js-enabled > li > a:contains(Home)";
		public String HEADER_GETTING_STARTED_LINK = "css=ul#sfNavigation.sf-menu.sf-js-enabled > li > a:contains(Getting Started)";
		public String HEADER_MY_WEBSITES_LINK = "css=ul#sfNavigation.sf-menu.sf-js-enabled > li > a:contains(My Websites)";
		public String HEADER_SALES_MARKETING_LINK = "css=ul#sfNavigation.sf-menu.sf-js-enabled > li > a:contains(Sales & Marketing)";
		public String HEADER_MY_BUSINESS = "css=ul#sfNavigation.sf-menu.sf-js-enabled > li > a:contains(My Business)";
		public String HEADER_MY_DESK = "css=ul#sfNavigation.sf-menu.sf-js-enabled > li > a:contains(My Desk)";
		public String HEADER_NEWS_TRAINING = "css=ul#sfNavigation.sf-menu.sf-js-enabled > li > a:contains(Training)";
		public String HEADER_VIDEO_LIBRARY = "css=ul#sfNavigation.sf-menu.sf-js-enabled > li > a:contains(Video Library)";

		public String PERSONAL_INFO_CURRENT_RANK = "css=div#rank > div";
		public String PERSONAL_INFO_QUALIFICATION_STATUS = "css=div#qual_status > div";
		public String PERSONAL_INFO_STATUS = "css=div#status > div";
		public String PERSONAL_INFO_UPLINE_SPONSER = "css=div#sponsor > div";
		public String PERSONAL_INFO_UPLINE_DIAMOND_COACH = "css=div#uplineDiamond > div";
		public String PERSONAL_INFO_UPLINE_STAR_DIAMOND_COACH = "css=div#uplineStarDiamond > div";

		public String VOLUME_TEAM_AMOUNT = "//ul[@id='volumeDetails']/li[3]/span";
		public String VOLUME_LEFT_LEG_TEAM_AMOUNT = "//ul[@id='volumeDetails']/li[4]/span";
		public String VOLUME_RIGHT_LEG_TEAM_AMOUNT = "//ul[@id='volumeDetails']/li[5]/span";
		public String VOLUME_DETAILS_BUTTON = "css=button[type=button]>div>div>span:contains(Volume Details)";
		public String COACH_ALERT = "//div[@id='alerts']/ul/li";

		public String EVENT_TASK = "//ul[@id='appointmentsAndTasks']/li";
		public String ALL_EVENTS_BUTTON = "css=div#calendar.portalInfo > div.buttons";

		public String VOLUME_GRAPH = "css=div#volumeGraph";
		public String ACADEMY_WIDGET = "css=div#trainingHome";
		public String BREAKING_COACH_NEWS = "//ul[@class='bcna']/li";

		public String NEW_COACH_WELCOME_LINK = "css=a#bcn_h:contains(>>> NEW COACHES START HERE <<<)";
		public String COACH_ACADEMY_LINK = "css=div.m > div#trainingHome > a";
	}

	/**
	 * CoachPreviousOffice interface contains locators for web elements displayed on Coach Previous Office Page.
	 * @author Gaurav
	 */
	public interface CoachPreviousOffice {
		public String HEADER_LINK_WELCOME = "css=a:contains(Welcome)";
		public String HEADER_LINK_PROFILE = "css=a:contains(Profile)";
		public String LINK_VIEW_FULL_PROFILE = "css=a:contains(View Full Profile)";
		public String LINK_EDIT_BONUS_ACCOUNT_INFO = "css=a:contains(Edit Bonus Account Info )";
		public String HEADER_LINK_MY_ORDERS = "css=a:contains(My Orders)";
		public String LINK_MY_ORDER_SUMMARY = "css=a:contains(My Order Summary)";
		public String LINK_MY_ORDERS = "css=a:contains(My Orders)";
		public String LINK_MY_CUSTOMER_ORDERS = "css=a:contains(My Customer Orders)";
		public String HEADER_LINK_CUSTOMERS = "css=a:contains(Customers)";
		public String HEADER_LINK_GENEALOGY = "css=a:contains(Genealogy)";
		public String LINK_GENEALOGY_REPORT = "css=a:contains(Genealogy Report)";
		public String LINK_GENEALOGY_SEARCH = "css=a:contains(Genealogy Search )";
		public String LINK_GRAPHICAL_GENEALOGY = "css=a:contains(Graphical Genealogy )";
		public String LINK_TREE_VIEW_GENEALOGY = "css=a:contains(Tree View Genealogy)";
		public String LINK_PERSONALLY_SPONSORED_REPORT = "css=a:contains(Personally Sponsored Report )";
		public String LINK_PERSONALLY_SPONSORED_BY_LEG = "css=a:contains(Personally Sponsored By Leg)";
		public String LINK_VOLUME_TOTALS = "css=a:contains(Volume Totals )";
		public String LINK_PREFERRED_PLACEMENT = "css=a:contains(Preferred Placement)";
		public String LINK_SUCCESS_LINK = "css=a:contains(Success Links)";
		public String LINK_LEAD_ELIGIBILITY = "css=a:contains(Lead Eligibility)";
		public String LINK_FAST_START_BONUS_PROGRAM = "css=a:contains(Fast Start Bonus Program)";

		public String HEADER_LINK_COMMISSIONS = "css=a:contains(Commissions)";
		public String LINK_MY_COMMISSIONS = "css=a:contains(My Commissions)";
		public String LINK_MY_EARNINGS = "css=a:contains(My Earnings)";
		public String LINK_CARRYOVER_VOLUME = "css=a:contains(Carryover Volume)";
		public String HEADER_LINK_LOGOUT = "css=a:contains(Logout)";

		//public String BUTTON_BACK_TO_DASHBOARD = "css=a[href=http://www.teambeachbody.com/dashboard] > img";
		public String BUTTON_BACK_TO_DASHBOARD = "css=a[href$='dashboard'] > img";
	}
	
	/**
	 * Notifications interface contains locators for web elements displayed on Buddy Notifications Page. 
	 * @author Jaya
	 */
	public interface Notifications{
		public String ACCEPT_BUTTON = "css=a.message-title:contains(Accept)";
		public String NAV_MENU_MY_PROFILE_LINK = "css=ul[class='layouts level-1'] li a:contains(My Profile)";
	}
		 
		 public interface StartUpWizard {
			 public String CONTINUE_BUTTON = "css=div#gsw-welcome-back > div > a > span > input[value=continue]";
			 public String NEXT_BUTTON = "css=div#gsw-control-container > a> span > input[value=next]";
			 public String SUBMIT_BUTTON = "css=div>a#gsw-back-button>span.btn-white>input[value=submit]";
			 public String FINISH_BUTTON = "css=div>a>span.btn-white>input[value=finish]";
			 public String ABOUT_ME_DIV = "css=div.about-me-active";
			 public String GET_FIT_DIV= "css=div.get-fit-active";
			 public String EAT_SMART_DIV = "css=div.eat-smart-active";
			 public String CONNECT_DIV = "css=div.connect-active";
			 public String SHOP_DIV = "css=div.shop-active";
			 public String FEEDBACK_TEXTAREA= "css=textarea#gsw-feedback";
			 public String UPGRADE_MY_ACCOUNT_OPTION = "css=div#gsw-control-container > div >a > span > span:contains(upgrade my account now!)";
			 public String CLOSE_BUTTON = "css=div#gsw-before-you-go > a > span.btn-white > input[value='close window']";
			 public String FINISH_LATER_BUTTON = "css=div#gsw-finish-later-button";
			
			 
		 }
		 
		 
	/**
	 * HelpFAQ interface contains locators for web elements displayed on Help and FAQ pages.
	 * 
	 */
	public interface HelpFAQ {
		public String CLUB_USER_GUIDE_LINK = "css=a:contains(Guide)";
		public String SUPER_GYM_TUTORIAL_LINK = "css=a:contains(SuperGym Tutorial)";
		public String SUPER_GYM_FAQ_LINK = "css=a:contains(SuperGym FAQ)";
		public String CONTEST_FAQ_LINK = "css=a:contains(Contest FAQ)";		
	}
	
	
	/**
	 * FreeSignUp interface contains locators for web elements displayed on Free Sign Up page
	 * 
	 */
	public interface FreeSignUp {
		
		public String PRIVACY_POLICY_LINK = "css=a[href=/tbb/privacy]";
		public String CLUB_MEMBER_SIGN_UP_LINK = "css=a[href=/signup/-/signup/club]";
		public String FIRST_NAME = "css=input#_SIGNUP_WAR_signupportlet_firstName";
		public String LAST_NAME = "css=input#_SIGNUP_WAR_signupportlet_lastName";
		public String EMAIL = "css=input#_SIGNUP_WAR_signupportlet_emailAddress1";
		public String CONFIRM_EMAIL = "css=input#_SIGNUP_WAR_signupportlet_emailAddress2";
		public String PASSWORD = "css=input#_SIGNUP_WAR_signupportlet_password1";
		public String CONFIRM_PASSWORD = "css=input#_SIGNUP_WAR_signupportlet_password2";
		public String SCREEN_NAME = "css=input#_SIGNUP_WAR_signupportlet_screenName";
		public String CHECK_AVAILABILITY = "css=a.btn-white";
		public String CHECK_AVAILABILITY_BUTTON = "//table[@class='padded-form']/tbody/tr[4]/td[3]/a";
		public String DATE_OF_BRITH_MONTH = "css=select#_SIGNUP_WAR_signupportlet_birthdayMonth";
		public String DATE_OF_BRITH_DAY = "css=select#_SIGNUP_WAR_signupportlet_birthdayDay";
		public String DATE_OF_BRITH_YEAR = "css=select#_SIGNUP_WAR_signupportlet_birthdayYear";
		public String PHONE = "css=input#_SIGNUP_WAR_signupportlet_phone1";
		public String GENDER_MALE = "css=input#_SIGNUP_WAR_signupportlet_male";
		public String GENDER_FEMALE = "css=input#_SIGNUP_WAR_signupportlet_female";
		
		public String ADDRESS1 = "css=input#_SIGNUP_WAR_signupportlet_addressStreet1shippingAddress";
		public String ADDRESS2 = "css=input#_SIGNUP_WAR_signupportlet_addressStreet2shippingAddress";
		public String CITY = "css=input#_SIGNUP_WAR_signupportlet_addressCityshippingAddress";
		public String STATE_PROVINCE = "css=select#_SIGNUP_WAR_signupportlet_addressRegionIdshippingAddress";
		public String ZIP_POSTAL = "css=input#_SIGNUP_WAR_signupportlet_addressZipshippingAddress";
		public String COUNTRY = "css=select#_SIGNUP_WAR_signupportlet_addressCountryIdshippingAddress";
		
		public String NOT_REFERRED_BY_COACH = "css=input#_SIGNUP_WAR_signupportlet_defaultCoachInput";
		public String REFERRING_COACH_ATRRIBUTE = "css=select#signup-search-by-select-free";
		public String REFERRING_COACH_ATRRIBUTE_VALUE = "css=td.coach-search-fields > div > input";
		
		public String T_N_C_DAILY_SWEEPTAKES_RULES = "css=input#_SIGNUP_WAR_signupportlet_sweepstakesAgreeCheckbox";
		public String T_N_C_TBB = "css=input#_SIGNUP_WAR_signupportlet_termsConditionsAgreeCheckbox";
		public String CAPTCHA_TEXT = "css=input[name=_SIGNUP_WAR_signupportlet_captchaText]";
		public String SUBMIT_BUTTON = "css=input[type=button][value=Submit]";
		
		public String UPGRADE_TO_VIP_PORTLET = "css=div#signup-benefits-free";
		public String PORTLET_UPGRADE_TO_CLUB_MEMBERSHIP_BUTTON = "css=li.upgrade_btn > a[href=/signup/-/signup/club]";
		
				
	}
}