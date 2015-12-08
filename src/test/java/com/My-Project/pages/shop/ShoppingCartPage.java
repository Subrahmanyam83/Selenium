package com.tbb.pages.shop;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Shop;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;

/**
 * 
 * Page Object encapsulates the Shopping Cart Page
 * @author Xebia
 */
public class ShoppingCartPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Shopping Cart Page.
	 * @param	selenium
	 */
	public ShoppingCartPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Shopping Cart Page");
		this.selenium = selenium;
		/**
		 * The following assertion for title of the page had to be commented as the title of the page is different for UK Club user and Free User. 
		 */
		//assertTrue("This is not Shopping Cart Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Shopping Cart"), selenium);
	}

	/**
	 * This function clicks on the Home link and navigates user to the Home page from Shopping Cart Page. 
	 * @return Home Page
	 */
	public HomePage clickHomeLink() {
		selenium.click("css=a[name='mM1']:contains(Home)");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HomePage(selenium);
	}


	public void addToCart(String productName) {
		if (productName.equals("Shakeology"))
			selenium.click("css=td#154118_AddToCardTD  a[title='Click here to add this product to your cart.']>span[class='AddToCart AddToCartButton']");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Fitness Program link in the left menu and navigates user to Fitness Programs Link. 
	 */
	public void goToFitnessProgramsPage() {
		selenium.click(Shop.FITNESS_PROGRAM);
		selenium.click(Shop.FITNESS_PROGRAM);
		selenium.waitForPageToLoad("180000");	
	}

	/**
	 * Clicks on 10 Minute Trainer link in the left menu and navigates user to shop 10 Minute Trainer products page. 
	 */
	public void goToTenMinuteTrainer() {
		selenium.click(Shop.TEN_MINUTE_TRAINER);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Asylum link in the left menu and navigates user to shop Asylum products page. 
	 */
	public void goToAsylum() {
		selenium.click(Shop.ASYLUM);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Fitness Program Best Sellers link in the left menu and navigates user to shop Fitness Program Best Sellers products page. 
	 */
	public void goToFitnessProgramBestSellers() {
		selenium.click(Shop.FITNESS_PROGRAM_BEST_SELLERS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Body Gospel link in the left menu and navigates user to shop Body Gospel products page. 
	 */
	public void goToBodyGospel() {
		selenium.click(Shop.BODY_GOSPEL);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Brazil Butt Lift link in the left menu and navigates user to shop Brazil Butt Lift products page. 
	 */
	public void goToBrazilButtLift() {
		selenium.click(Shop.BRAZIL_BUTT_LIFT);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Chalean Extreme link in the left menu and navigates user to shop Chalean Extreme products page. 
	 */
	public void goToChaleanExtreme() {
		selenium.click(Shop.CHALEAN_EXTREME);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Hip Hop Abs link in the left menu and navigates user to shop Hip Hip Abs products page. 
	 */
	public void goToHipHopAbs() {
		selenium.click(Shop.HIP_HOP_ABS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Insanity link in the left menu and navigates user to shop Insanity products page. 
	 */
	public void goToInsanity() {
		selenium.click(Shop.INSANITY);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on KSPY T2 link in the left menu and navigates user to shop KSPY T2 products page. 
	 */
	public void goToKSPYT2() {
		selenium.click(Shop.KSPY_T2);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on More Programs link in the left menu and navigates user to shop More Programs products page. 
	 */
	public void goToMorePrograms() {
		selenium.click(Shop.MORE_PROGRAMS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on New Products link in the left menu and navigates user to shop New Products page. 
	 */
	public void goToNewProducts() {
		selenium.click(Shop.NEW_PRODUCTS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on P90X link in the left menu and navigates user to shop P90X products page. 
	 */
	public void goToP90X() {
		selenium.click(Shop.P90X);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on P90XOneOnOne link in the left menu and navigates user to shop P90XOneOnOne products page. 
	 */
	public void goToP90XOneOnOne() {
		selenium.click(Shop.P90X_ONE_ON_ONE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Power90 link in the left menu and navigates user to shop Power90 products page. 
	 */
	public void goToPower90() {
		selenium.click(Shop.POWER_90);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on RevAbs link in the left menu and navigates user to shop RevAbs products page. 
	 */
	public void goToRevAbs() {
		selenium.click(Shop.REVABS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Rockin Body link in the left menu and navigates user to shop Rockin Body products page. 
	 */
	public void goToRockinBody() {
		selenium.click(Shop.ROCKING_BODY);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Slim In 6 link in the left menu and navigates user to shop Slim In 6 products page. 
	 */
	public void goToSlimIn6() {
		selenium.click(Shop.SLIM_IN_6);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Total Body Solution link in the left menu and navigates user to shop Total Body Solution products page. 
	 */
	public void goToTotalBodySolution() {
		selenium.click(Shop.TOTAL_BODY_SOLUTION);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Turbo Jam link in the left menu and navigates user to shop Turbo Jam products page. 
	 */
	public void goToTurboJam() {
		selenium.click(Shop.TURBO_JAM);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Turbo Fire link in the left menu and navigates user to shop Turbo Fire products page. 
	 */
	public void goToTurboFire() {
		selenium.click(Shop.TURBO_FIRE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Yoga Booty Ballet link in the left menu and navigates user to shop Yoga Booty Ballet products page. 
	 */
	public void goToYogaBootyBallet() {
		selenium.click(Shop.YOGA_BOOTY_BALLET);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Returns the number of Add to Cart Buttons are displayed on the Supplements Page.
	 * @return int
	 */
	public int getAddToCartBtnCount() {
		return selenium.getXpathCount(Shop.ADD_TO_CART_BTN).intValue();
	}

	/**
	 * Clicks on Trainer link in the left menu and navigates user to shop Trainer products page. 
	 */
	public void goToTrainerPage() {
		selenium.click(Shop.TRAINER);
		//selenium.click(Shop.TRAINER);
		selenium.waitForPageToLoad("180000");		
	}

	/**
	 * Clicks on Brett Hoebel link in the left menu and navigates user to shop Brett Hoebel products page. 
	 */
	public void goToBrettHoebel() {
		selenium.click(Shop.BRETT_HOEBEL);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Chalene Johnson link in the left menu and navigates user to shop Chalene Johnson products page. 
	 */
	public void goToChaleneJohnson() {
		selenium.click(Shop.CHALENE_JOHNSON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Debbie Siebers link in the left menu and navigates user to shop Debbie Siebers products page. 
	 */
	public void goToDebbieSiebers() {
		selenium.click(Shop.DEBBIE_SIEBERS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Donna Richardson Joyner link in the left menu and navigates user to shop Donna Richardson Joyner products page. 
	 */
	public void goToDonnaRichardsonJoyner() {
		selenium.click(Shop.DONNA_RICHARDSON_JOYNER);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Gillian And Teigh link in the left menu and navigates user to shop Gillian And Teigh products page. 
	 */
	public void goToGillianAndTeigh() {
		selenium.click(Shop.GILLIAN_AND_TEIGH);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Kathy Smith link in the left menu and navigates user to shop Kathy Smith products page. 
	 */
	public void goToKathySmith() {
		selenium.click(Shop.KATHY_SMITH);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Leandro Carvalho link in the left menu and navigates user to shop Leandro Carvalho products page. 
	 */
	public void goToLeandroCarvalho() {
		selenium.click(Shop.LEANDRO_CARVALHO);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on SHAUN T link in the left menu and navigates user to shop SHAUN T products page. 
	 */
	public void goToSHAUNT() {
		selenium.click(Shop.SHAUN_T);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on SHAUN T spanish link in the left menu and navigates user to shop SHAUN T products page in Spanish. 
	 */
	public void goToSHAUNTEnEspanol() {
		selenium.click(Shop.SHAUN_T_EN_ESPANOL);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Tony Horton link in the left menu and navigates user to shop Tony Horton products page. 
	 */
	public void goToTonyHorton() {
		selenium.click(Shop.TONY_HORTON);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Tony Horton link in Spanish the left menu and navigates user to shop Tony Horton products page in Spanish. 
	 */
	public void goToTonyHortonEnEspanol() {
		selenium.click(Shop.TONY_HORTON_EN_ESPNOL);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Nutrition And Supplements link in the left menu and navigates user to shop Nutrition And Supplements products page. 
	 */
	public void goToNutritionAndSupplements() {
		selenium.click(Shop.NUTRITION_AND_SUPPLEMENTS);
		selenium.click(Shop.NUTRITION_AND_SUPPLEMENTS);
		selenium.waitForPageToLoad("180000");		
	}

	/**
	 * Clicks on Nutrition And Supplements Best Sellers link in the left menu and navigates user to shop Nutrition And Supplements Best Sellers products page. 
	 */
	public void goToNutritionAndSupplementsBestSellers() {
		selenium.click(Shop.NUTRITION_BEST_SELLERS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);				
	}

	/**
	 * Clicks on Health And Wellness link in the left menu and navigates user to shop Health And Wellness products page. 
	 */
	public void goToHealthAndWellness() {
		selenium.click(Shop.HEALTH_AND_WELLNESS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on Nutrition Packs link in the left menu and navigates user to shop Nutrition Packs products page. 
	 */
	public void goToNutritionPacks() {
		selenium.click(Shop.NUTRITION_PACKS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
	}

	/**
	 * Clicks on P90X Nutrition link in the left menu and navigates user to shop P90X Nutrition products page. 
	 */
	public void goToP90XNutrition() {
		selenium.click(Shop.P90X_NUTRITION);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Shakeology link in the left menu and navigates user to shop Shakeology products page. 
	 */
	public void goToShakeology() {
		selenium.click(Shop.SHAKEOLOGY);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Sports Performance link in the left menu and navigates user to shop Sports Performance products page. 
	 */
	public void goToSportsPerformance() {
		selenium.click(Shop.SPORTS_PERFORMANCE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Weight Management link in the left menu and navigates user to shop Weight Management products page. 
	 */
	public void goToWeightManagement() {
		selenium.click(Shop.WEIGHT_MANAGEMENT);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);		
	}

	/**
	 * Clicks on Equipment And Gear link in the left menu and navigates user to shop Equipment And Gear products page. 
	 */
	public void goToEquipmentAndGear() {
		selenium.click(Shop.EQUIPMENT_AND_GEAR);
		selenium.click(Shop.EQUIPMENT_AND_GEAR);
		selenium.waitForPageToLoad("180000");			
	}

	/**
	 * Clicks on Apparel link in the left menu and navigates user to shop Apparel products page. 
	 */
	public void goToApparel() {
		selenium.click(Shop.APPAREL);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);			
	}

	/**
	 * Clicks on Asylum Equipment link in the left menu and navigates user to shop Asylum Equipment products page. 
	 */
	public void goToAsylumEquipment() {
		selenium.click(Shop.ASYLUM_EQUIPMENT);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);			
	}

	/**
	 * Clicks on Bands And Balls link in the left menu and navigates user to shop Bands And Balls products page. 
	 */
	public void goToBandsAndBalls() {
		selenium.click(Shop.BANDS_AND_BALLS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on Chin Up And Push Up link in the left menu and navigates user to shop Chin Up And Push Up products page. 
	 */
	public void goToChinUpAndPushUp() {
		selenium.click(Shop.CHINUP_AND_PUSH_UP);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on Health Monitors link in the left menu and navigates user to shop Health Monitors products page. 
	 */
	public void goToHealthMonitors() {
		selenium.click(Shop.HEALTH_MONITORS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on P90X Equipment link in the left menu and navigates user to shop P90X Equipment products page. 
	 */
	public void goToP90XEquipment() {
		selenium.click(Shop.P90X_EQUIPMENT);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on Sculpting And Toning link in the left menu and navigates user to shop Sculpting And Toning products page. 
	 */
	public void goToSculptingAndToning() {
		selenium.click(Shop.SCULPTING_AND_TONING);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on Yoga link in the left menu and navigates user to shop Yoga products page. 
	 */
	public void goToYoga() {
		selenium.click(Shop.YOGA);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on Coach Products And Tools link in the left menu and navigates user to shop Coach Products And Tools page. 
	 */
	public void goToCoachProductsAndTools() {
		selenium.click(Shop.COACH_PRODUCTS_AND_TOOLS);
		selenium.click(Shop.COACH_PRODUCTS_AND_TOOLS);
		selenium.waitForPageToLoad("180000");			
	}

	/**
	 * Clicks on Beachbody Sharing Tools link in the left menu and navigates user to shop Beachbody Sharing Tools page. 
	 */
	public void goToBeachbodySharingTools() {
		selenium.click(Shop.BEACHBODY_SHARING_TOOLS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);			
	}

	/**
	 * Clicks on Coach Packs link in the left menu and navigates user to shop Coach Packs page. 
	 */
	public void goToCoachPacks() {
		selenium.click(Shop.COACH_PACKS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on Promotional Items link in the left menu and navigates user to shop Promotional Items page. 
	 */
	public void goToPromotionalItems() {
		selenium.click(Shop.PROMOTIONAL_ITEMS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on Shakeology Items link in the left menu and navigates user to shop Shakeology Items page. 
	 */
	public void goToShakeologyItems() {
		selenium.click(Shop.SHAKEOLOGY_ITEMS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}

	/**
	 * Clicks on Training Tools link in the left menu and navigates user to shop Training Tools page. 
	 */
	public void goToTrainingTools() {
		selenium.click(Shop.TRAINING_TOOLS);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);	
	}
}