package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.BodyFatCalculatorTab;
import com.tbb.constants.UIRepository.EatSmart;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Body Fat Calculator Page
 * @author Jaya
 */
public class BodyFatCalculatorPage  extends BaseTest implements BodyFatCalculatorTab {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Body Fat Calculator Page.
	 * @param	selenium
	 */
	public BodyFatCalculatorPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Body Fat Calculator Page");
		this.selenium = selenium;
		assertTrue("This is not Body Fat Calculator Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart: Nutrition Tools: Body Fat"), selenium);
	}
	/**
	 * It types the values in the Body Fat Calculator Form.
	 * @param waist
	 * @param weight
	 * @param gender Male or Female 
	 * @param age 
	 * @param bodyFatReading
	 */
	public void fillBodyFatCalculatorForm(String waist, String weight, String gender, String age, String bodyFatReading){
		selenium.type(YOUR_WAIST_TEXTBOX, waist);
		selenium.type(YOUR_WEIGHT_TEXTBOX, weight);
		selenium.select(YOUR_GENDER_DROPDOWN, gender);
		selenium.type(YOUR_AGE_TEXTBOX, age);
		selenium.select(BODY_FAT_TESTER_DROPDOWN, bodyFatReading);
	}
	
	/**
	 * Navigates user to Nutrition Tools Page. 
	 * @return NutritionToolsPage
	 */
	public NutritionToolsPage goToNutritionToolsPage() {
		selenium.click(EatSmart.NAV_MENU_NUTRITION_TOOLS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new NutritionToolsPage(selenium);
	}
	
	/**
	 * Types the waist size in textbox.
	 * @param waist
	 */
	public void enterWaist(String waist) {
		selenium.type(YOUR_WAIST_TEXTBOX, waist);		
	}
	
	/**
	 * Types the weight in textbox. 
	 * @param weight
	 */
	public void enterWeight(String weight) {
		selenium.type(YOUR_WEIGHT_TEXTBOX, weight);		
	}
	
	/**
	 * Selects the gender in gender dropdown. 
	 * @param gender
	 */
	public void selectGender(String gender) {
		selenium.select(YOUR_GENDER_DROPDOWN, gender);		
	}
	
	/**
	 * Types the age in textbox. 
	 * @param age
	 */
	public void enterAge(String age) {
		selenium.type(YOUR_AGE_TEXTBOX, age);		
	}
	
	/**
	 * Selects the Body Fat Tester Reading. 
	 * @param reading
	 */
	public void selectBodyFatTesterReading(String reading) {
		selenium.select(BODY_FAT_TESTER_DROPDOWN, reading);		
	}
	
	/**
	 * Clicks on Calculate Body Fat Button. 
	 */
	public void clickCalculateBodyFat() {
		selenium.click(CALCULATE_BODY_FAT_BUTTON);		
	}
}