package com.tbb.pages.eatsmart;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.EatSmart;
import com.tbb.constants.UIRepository.HealthyWeightTab;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Healthy Weight Page
 * @author Jaya
 */
public class HealthyWeightPage  extends BaseTest  implements HealthyWeightTab {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Healthy Weight Page.
	 * @param	selenium
	 */
	public HealthyWeightPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Healthy Weight Page");
		this.selenium = selenium;
		assertTrue("This is not Healthy Weight Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Eat Smart: Nutrition Tools: Healthy Weight"), selenium);
	}
	
	/**
	 * Navigates user to Nutrition Tools Page
	 * @return NutritionToolsPage
	 */
	public NutritionToolsPage goToNutritionToolsPage() {
		selenium.click(EatSmart.NAV_MENU_NUTRITION_TOOLS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new NutritionToolsPage(selenium);
	}
	
	/**
	 * Types height in height in Feet text box. 
	 * @param heightFt
	 */
	public void enterHeightFt(String heightFt) {
		selenium.type(YOUR_HEIGHT_FT_TEXTBOX, heightFt);		
	}
	
	/**
	 * Types height in inches in Inches Text box. 
	 * @param heightIn
	 */
	public void enterHeightIn(String heightIn) {
		selenium.type(YOUR_HEIGHT_IN_TEXTBOX, heightIn);		
	}
	
	/**
	 * Types weight in weight text box.
	 * @param weight
	 */
	public void enterWeight(String weight) {
		selenium.type(YOUR_WEIGHT_LBS_TEXTBOX, weight);		
	}
	
	/**
	 * Clicks on Calculate your BMI button. 
	 */
	public void clickCalculateYourBMI() {
		selenium.click(CALCULATE_YOUR_BMI_BUTTON);		
	}
}