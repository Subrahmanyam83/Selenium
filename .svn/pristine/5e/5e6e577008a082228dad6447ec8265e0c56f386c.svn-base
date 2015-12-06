package com.tbb.pages.profile;

import java.util.HashMap;
import java.util.Map;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.LRMProfile;
import com.tbb.constants.UIRepository.ProgramsTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
/**
 * 
 * Page Object encapsulates the Programs Page
 * @author Xebia
 */   
public class ProgramsPage  extends BaseTest  implements ProgramsTab, Home {

	/**
	 * Constructor to initialise Programs Page Object
	 * @param LoggingSelenium
	 * @throws  IllegalStateException if the user is on a different page than Programs Page.
	 */    
	public ProgramsPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of ProgramsPage Class");
		assertTrue("This is not Programs Page, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Edit Profile: Programs"), selenium);
	}
	
	/**
	 * Expands all the sections on Programs Page.  
	 * @return ProgramsPage
	 */
	public ProgramsPage clickExpandAll(){
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProgramsPage(selenium);
	}
	
	/**
	 * Minimizes all the sections on Programs Page.  
	 * @return ProgramsPage
	 */
	public ProgramsPage clickCloseAll(){
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProgramsPage(selenium);
	}
	
	/**
	 * Saves the modifications of the form on Programs Page.  
	 */
	public void savePrograms(){
		selenium.click(SAVE_BUTTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}
	
	/**
	 * Resets the modifications of the form on Programs Page.  
	 * @return ProgramsPage
	 */
	public ProgramsPage resetPrograms(){
		selenium.click(RESET_BUTTON);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ProgramsPage(selenium);
	}
	
	/**
	 * Checks all the check boxes of Fitness Programs section on Programs Page.  
	 */
	public void selectAllFitnessPrograms() {
        selenium.check(FITNESS_PROGRAMS_10_MINUTE_TRAINER_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_BODY_GOSPEL_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_BRAZIL_BUTT_LIFT_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_CHALEAN_EXTREME_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_FAST_100_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_GET_REAL_WITH_SHAUN_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_GREAT_BODY_GUARANTEED_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_HIP_HOP_ABS_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_HO_ALA_KE_KINO_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_INSANITY_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_INSANITY_THE_ASYLUM_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_KATHY_SMITH_FITNESS_PROGRAMS_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_KATHY_SMITHS_PROJECT_YOU_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_KEEP_IT_UP_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_P90X_ONE_ON_ONE_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_POWER90X_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_POWER_90_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_POWER_HALF_HOUR_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_REVABS_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_ROCKIN_BODY_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_SHAKEOLOGY_THE_WORKOUTS_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_SLIM_IN_6_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_SLIM_SERIES_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_TONY_AND_THE_FOLKS_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_TONY_AND_THE_KIDS_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_TOTAL_BODY_SOLUTION_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_TURBO_JAM_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_TURBO_FIRE_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_BABY_ON_THE_WAY_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_PURE_AND_SIMPLE_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_CHECKBOX);
        selenium.check(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_AB_AND_BUTT_MAKEOVER_CHECKBOX);		
	}
	
	/**
	 * Checks all the check boxes of Activities section on Programs Page.  
	 */
	public void selectAllActivities(){
		selenium.check(ACTIVITIES_BIKING_CHECKBOX);
		selenium.check(ACTIVITIES_CARDIO_AEROBICS_CHECKBOX);
		selenium.check(ACTIVITIES_RUNNING_WALKING_CHECKBOX);
		selenium.check(ACTIVITIES_SWIMMING_CHECKBOX);
		selenium.check(ACTIVITIES_WEIGHTLIFTING_CHECKBOX);
		selenium.check(ACTIVITIES_YOGA_PILATES_CHECKBOX);
	}
	
	/**
	 * Checks all the check boxes of Gear/Accessories section on Programs Page.  
	 */
	public void selectAllGearAccessories(){
		selenium.check(GEAR_P90X_CHIN_UP_BAR_CHECKBOX);
		selenium.check(GEAR_HEART_RATE_MONITOR_CHECKBOX);
		selenium.check(GEAR_PUSH_UP_STANDS_CHECKBOX);
		selenium.check(GEAR_RESISTANCE_BANDS_CHECKBOX);
		selenium.check(GEAR_POWER_STANDS_CHECKBOX);
		selenium.check(GEAR_WEIGHTED_GLOVES_CHECKBOX);
	}
	
	/**
	 * Checks all the check boxes of Supplements section on Programs Page.  
	 */
	public void selectAllSupplements(){
		selenium.check(SUPPLEMENTS_SHAKEOLOGY_CHECKBOX);
		selenium.check(SUPPLEMENTS_ACTIVIT_MULTI_VITAMINS_CHECKBOX);
		selenium.check(SUPPLEMENTS_MEAL_REPLACEMENT_SHAKE_CHECKBOX);
		selenium.check(SUPPLEMENTS_WHEY_PROTEIN_POWDER_CHECKBOX);
		selenium.check(SUPPLEMENTS_JOINT_SUPPORT_SUPER_FORMULA_CHECKBOX);
		selenium.check(SUPPLEMENTS_PURE_CREATINE_CHECKBOX);
		selenium.check(SUPPLEMENTS_P90X_PEAK_HEALTH_FORMULA_CHECKBOX);
		selenium.check(SUPPLEMENTS_P90X_PEAK_RESULTS_AND_RECOVERY_FORMULA_CHECKBOX);
		selenium.check(SUPPLEMENTS_2_DAY_FAST_FORMULA_CHECKBOX);
		selenium.check(SUPPLEMENTS_TOTAL_HEALTH_WOMENS_FORMULA_CHECKBOX);
		selenium.check(SUPPLEMENTS_STRENGTH_AND_MUSCLE_MENS_FORMULA_CHECKBOX);
		selenium.check(SUPPLEMENTS_SLIMMING_FORMULA_CHECKBOX);
		selenium.check(SUPPLEMENTS_PERFORMANCE_FORMULA_CHECKBOX);
		selenium.check(SUPPLEMENTS_CHITOSAN_PLUS_CHECKBOX);
	}
	
	/**
	 * This function returns all the existing values shown on the Programs Page.  
	 * @return map
	 */	
	public Map<String, String> getExistingFormDataForFreeUser() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put(FITNESS_PROGRAMS_10_MINUTE_TRAINER_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_10_MINUTE_TRAINER_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_BODY_GOSPEL_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_BODY_GOSPEL_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_BRAZIL_BUTT_LIFT_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_BRAZIL_BUTT_LIFT_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_CHALEAN_EXTREME_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_CHALEAN_EXTREME_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_FAST_100_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_FAST_100_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_GET_REAL_WITH_SHAUN_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_GET_REAL_WITH_SHAUN_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_GREAT_BODY_GUARANTEED_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_GREAT_BODY_GUARANTEED_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_HIP_HOP_ABS_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_HIP_HOP_ABS_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_HO_ALA_KE_KINO_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_HO_ALA_KE_KINO_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_INSANITY_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_INSANITY_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_INSANITY_THE_ASYLUM_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_INSANITY_THE_ASYLUM_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_KATHY_SMITH_FITNESS_PROGRAMS_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_KATHY_SMITH_FITNESS_PROGRAMS_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_KATHY_SMITHS_PROJECT_YOU_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_KATHY_SMITHS_PROJECT_YOU_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_KEEP_IT_UP_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_KEEP_IT_UP_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_P90X_ONE_ON_ONE_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_P90X_ONE_ON_ONE_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_POWER90X_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_POWER90X_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_POWER_90_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_POWER_90_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_POWER_HALF_HOUR_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_POWER_HALF_HOUR_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_REVABS_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_REVABS_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_ROCKIN_BODY_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_ROCKIN_BODY_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_SHAKEOLOGY_THE_WORKOUTS_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_SHAKEOLOGY_THE_WORKOUTS_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_SLIM_IN_6_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_SLIM_IN_6_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_SLIM_SERIES_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_SLIM_SERIES_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_TONY_AND_THE_FOLKS_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TONY_AND_THE_FOLKS_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_TONY_AND_THE_KIDS_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TONY_AND_THE_KIDS_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_TOTAL_BODY_SOLUTION_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TOTAL_BODY_SOLUTION_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_TURBO_JAM_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TURBO_JAM_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_TURBO_FIRE_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TURBO_FIRE_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_BABY_ON_THE_WAY_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_BABY_ON_THE_WAY_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_PURE_AND_SIMPLE_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_PURE_AND_SIMPLE_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_CHECKBOX)).toString());
		map.put(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_AB_AND_BUTT_MAKEOVER_CHECKBOX, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_AB_AND_BUTT_MAKEOVER_CHECKBOX)).toString());
		
		map.put(FITNESS_PROGRAMS_I_DONT_HAVE_A_PRIMARY_PROGRAM, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_I_DONT_HAVE_A_PRIMARY_PROGRAM)).toString());
		map.put(FITNESS_PROGRAMS_10_MINUTE_TRAINER_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_10_MINUTE_TRAINER_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_BODY_GOSPEL_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_BODY_GOSPEL_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_BRAZIL_BUTT_LIFT_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_BRAZIL_BUTT_LIFT_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_CHALEAN_EXTREME_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_CHALEAN_EXTREME_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_FAST_100_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_FAST_100_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_GET_REAL_WITH_SHAUN_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_GET_REAL_WITH_SHAUN_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_GREAT_BODY_GUARANTEED_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_GREAT_BODY_GUARANTEED_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_HIP_HOP_ABS_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_HIP_HOP_ABS_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_HO_ALA_KE_KINO_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_HO_ALA_KE_KINO_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_INSANITY_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_INSANITY_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_INSANITY_THE_ASYLUM_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_INSANITY_THE_ASYLUM_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_KATHY_SMITH_FITNESS_PROGRAMS_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_KATHY_SMITH_FITNESS_PROGRAMS_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_KATHY_SMITHS_PROJECT_YOU_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_KATHY_SMITHS_PROJECT_YOU_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_KEEP_IT_UP_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_KEEP_IT_UP_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_P90X_ONE_ON_ONE_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_P90X_ONE_ON_ONE_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_POWER90_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_POWER90_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_POWER_HALF_HOUR_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_POWER_HALF_HOUR_RADIO_BUTTON)).toString());	
		map.put(FITNESS_PROGRAMS_REVABS_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_REVABS_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_ROCKIN_BODY_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_ROCKIN_BODY_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_SHAKEOLOGY_THE_WORKOUTS_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_SHAKEOLOGY_THE_WORKOUTS_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_SLIM_IN_6_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_SLIM_IN_6_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_SLIM_SERIES_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_SLIM_SERIES_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_TONY_AND_THE_FOLKS_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TONY_AND_THE_FOLKS_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_TONY_AND_THE_KIDS_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TONY_AND_THE_KIDS_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_TOTAL_BODY_SOLUTION_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TOTAL_BODY_SOLUTION_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_TURBO_JAM_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TURBO_JAM_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_TURBO_FIRE_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_TURBO_FIRE_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_BABY_ON_THE_WAY_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_BABY_ON_THE_WAY_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_PURE_AND_SIMPLE_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_PURE_AND_SIMPLE_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_RADIO_BUTTON)).toString());
		map.put(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_AB_AND_BUTT_MAKEOVER_RADIO_BUTTON, new Boolean(selenium.isChecked(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_AB_AND_BUTT_MAKEOVER_RADIO_BUTTON)).toString());
		
		map.put(ACTIVITIES_BIKING_CHECKBOX, new Boolean(selenium.isChecked(ACTIVITIES_BIKING_CHECKBOX)).toString());
		map.put(ACTIVITIES_CARDIO_AEROBICS_CHECKBOX, new Boolean(selenium.isChecked(ACTIVITIES_CARDIO_AEROBICS_CHECKBOX)).toString());
		map.put(ACTIVITIES_RUNNING_WALKING_CHECKBOX, new Boolean(selenium.isChecked(ACTIVITIES_RUNNING_WALKING_CHECKBOX)).toString());
		map.put(ACTIVITIES_SWIMMING_CHECKBOX, new Boolean(selenium.isChecked(ACTIVITIES_SWIMMING_CHECKBOX)).toString());
		map.put(ACTIVITIES_WEIGHTLIFTING_CHECKBOX, new Boolean(selenium.isChecked(ACTIVITIES_WEIGHTLIFTING_CHECKBOX)).toString());
		map.put(ACTIVITIES_YOGA_PILATES_CHECKBOX, new Boolean(selenium.isChecked(ACTIVITIES_YOGA_PILATES_CHECKBOX)).toString());
		
		map.put(GEAR_P90X_CHIN_UP_BAR_CHECKBOX, new Boolean(selenium.isChecked(GEAR_P90X_CHIN_UP_BAR_CHECKBOX)).toString());
		map.put(GEAR_HEART_RATE_MONITOR_CHECKBOX, new Boolean(selenium.isChecked(GEAR_HEART_RATE_MONITOR_CHECKBOX)).toString());
		map.put(GEAR_PUSH_UP_STANDS_CHECKBOX, new Boolean(selenium.isChecked(GEAR_PUSH_UP_STANDS_CHECKBOX)).toString());
		map.put(GEAR_RESISTANCE_BANDS_CHECKBOX, new Boolean(selenium.isChecked(GEAR_RESISTANCE_BANDS_CHECKBOX)).toString());
		map.put(GEAR_POWER_STANDS_CHECKBOX, new Boolean(selenium.isChecked(GEAR_POWER_STANDS_CHECKBOX)).toString());
		map.put(GEAR_WEIGHTED_GLOVES_CHECKBOX, new Boolean(selenium.isChecked(GEAR_WEIGHTED_GLOVES_CHECKBOX)).toString());
		
		map.put(SUPPLEMENTS_SHAKEOLOGY_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_SHAKEOLOGY_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_ACTIVIT_MULTI_VITAMINS_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_ACTIVIT_MULTI_VITAMINS_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_MEAL_REPLACEMENT_SHAKE_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_MEAL_REPLACEMENT_SHAKE_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_WHEY_PROTEIN_POWDER_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_WHEY_PROTEIN_POWDER_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_JOINT_SUPPORT_SUPER_FORMULA_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_JOINT_SUPPORT_SUPER_FORMULA_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_PURE_CREATINE_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_PURE_CREATINE_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_P90X_PEAK_HEALTH_FORMULA_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_P90X_PEAK_HEALTH_FORMULA_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_P90X_PEAK_RESULTS_AND_RECOVERY_FORMULA_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_P90X_PEAK_RESULTS_AND_RECOVERY_FORMULA_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_2_DAY_FAST_FORMULA_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_2_DAY_FAST_FORMULA_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_TOTAL_HEALTH_WOMENS_FORMULA_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_TOTAL_HEALTH_WOMENS_FORMULA_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_STRENGTH_AND_MUSCLE_MENS_FORMULA_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_STRENGTH_AND_MUSCLE_MENS_FORMULA_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_SLIMMING_FORMULA_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_SLIMMING_FORMULA_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_PERFORMANCE_FORMULA_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_PERFORMANCE_FORMULA_CHECKBOX)).toString());
		map.put(SUPPLEMENTS_CHITOSAN_PLUS_CHECKBOX, new Boolean(selenium.isChecked(SUPPLEMENTS_CHITOSAN_PLUS_CHECKBOX)).toString());
		
		return map;
	}

	/**
	 * Signs out the user from the website.   
	 */
	public HomePage signOut() {
		selenium.click(SIGNOUT_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		selenium.waitForElementPresent("css=a:contains(Sign In)");
		return new HomePage(selenium);
	}

	/**
	 * Unchecks all the check boxes of Fitness Programs section on Programs Page.  
	 */
	public void deselectAllFitnessPrograms() {
		 selenium.uncheck(FITNESS_PROGRAMS_10_MINUTE_TRAINER_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_BODY_GOSPEL_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_BRAZIL_BUTT_LIFT_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_CHALEAN_EXTREME_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_FAST_100_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_GET_REAL_WITH_SHAUN_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_GREAT_BODY_GUARANTEED_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_HIP_HOP_ABS_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_HO_ALA_KE_KINO_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_INSANITY_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_INSANITY_THE_ASYLUM_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_KATHY_SMITH_FITNESS_PROGRAMS_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_KATHY_SMITHS_PROJECT_YOU_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_KEEP_IT_UP_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_P90X_ONE_ON_ONE_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_POWER90X_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_POWER_90_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_POWER_HALF_HOUR_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_REVABS_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_ROCKIN_BODY_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_SHAKEOLOGY_THE_WORKOUTS_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_SLIM_IN_6_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_SLIM_SERIES_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_TONY_AND_THE_FOLKS_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_TONY_AND_THE_KIDS_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_TOTAL_BODY_SOLUTION_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_TURBO_JAM_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_TURBO_FIRE_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_BABY_ON_THE_WAY_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_PURE_AND_SIMPLE_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_CHECKBOX);
	        selenium.uncheck(FITNESS_PROGRAMS_YOGA_BOOTY_BALLET_AB_AND_BUTT_MAKEOVER_CHECKBOX);		
		}

	/**
	 * Unchecks all the check boxes of Activities section on Programs Page.  
	 */
	public void deselectAllActivities() {
		selenium.uncheck(ACTIVITIES_BIKING_CHECKBOX);
		selenium.uncheck(ACTIVITIES_CARDIO_AEROBICS_CHECKBOX);
		selenium.uncheck(ACTIVITIES_RUNNING_WALKING_CHECKBOX);
		selenium.uncheck(ACTIVITIES_SWIMMING_CHECKBOX);
		selenium.uncheck(ACTIVITIES_WEIGHTLIFTING_CHECKBOX);
		selenium.uncheck(ACTIVITIES_YOGA_PILATES_CHECKBOX);
	}

	/**
	 * Unchecks all the check boxes of Gear section on Programs Page.  
	 */
	public void deselectAllGearAccessories() {
		selenium.uncheck(GEAR_P90X_CHIN_UP_BAR_CHECKBOX);
		selenium.uncheck(GEAR_HEART_RATE_MONITOR_CHECKBOX);
		selenium.uncheck(GEAR_PUSH_UP_STANDS_CHECKBOX);
		selenium.uncheck(GEAR_RESISTANCE_BANDS_CHECKBOX);
		selenium.uncheck(GEAR_POWER_STANDS_CHECKBOX);
		selenium.uncheck(GEAR_WEIGHTED_GLOVES_CHECKBOX);		
	}

	/**
	 * Unchecks all the check boxes of Supplements section on Programs Page.  
	 */
	public void deselectAllSupplements() {
		selenium.uncheck(SUPPLEMENTS_SHAKEOLOGY_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_ACTIVIT_MULTI_VITAMINS_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_MEAL_REPLACEMENT_SHAKE_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_WHEY_PROTEIN_POWDER_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_JOINT_SUPPORT_SUPER_FORMULA_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_PURE_CREATINE_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_P90X_PEAK_HEALTH_FORMULA_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_P90X_PEAK_RESULTS_AND_RECOVERY_FORMULA_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_2_DAY_FAST_FORMULA_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_TOTAL_HEALTH_WOMENS_FORMULA_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_STRENGTH_AND_MUSCLE_MENS_FORMULA_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_SLIMMING_FORMULA_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_PERFORMANCE_FORMULA_CHECKBOX);
		selenium.uncheck(SUPPLEMENTS_CHITOSAN_PLUS_CHECKBOX);		
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
