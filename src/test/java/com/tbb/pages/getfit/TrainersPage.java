
package com.tbb.pages.getfit;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Trainers;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.ClubOnlyPage;

/**
 * This page object represents Trainers page and exposes the functionality available on that page 
 * @author Jaya
 */
public class TrainersPage  extends BaseTest implements Trainers{

	private LoggingSelenium selenium;

	/**
	 * Constructor for 'Trainers' page. Verifies whether we are on 'Trainers' page.
	 * 
	 * @param selenium
	 */
	public TrainersPage(LoggingSelenium selenium) {
		this.selenium = selenium;
		selenium.logComment("Executing constructor of 'Trainer' Page Class");
		assertTrue(
				"This is not 'Trainer' page, current page is: "
						+ selenium.getLocation(),
				selenium.getTitle().equals("Team Beachbody - Get Fit: Trainers"), selenium);
	}
	
	/**
	 * Navigate to Get Fit Link
	 */
	public GetFitPage clickGetFitLink() {
        selenium.click("css=a:contains(Get Fit)");	         
        selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
        return new GetFitPage(selenium);
	}

	/**
	 * Returns the count of the number of trainers pics displayed on Trainers page. 
	 * @return int
	 */
	public int getPhotosCount() {
		return selenium.getXpathCount(ALL_TRAINERS_PICS).intValue();
	}

	/**
	 * Returns the count of the number of trainers names displayed on Trainers page. 
	 * @return int
	 */
	public int getTrainerNamesCount() {
		return selenium.getXpathCount(ALL_TRAINERS_NAMES).intValue();
	}

	/**
	 * Returns the count of the number of trainers introductions displayed on Trainers page. 
	 * @return int
	 */
	public int getTrainerIntroCount() {
		return selenium.getXpathCount(ALL_TRAINERS_INTRODUCTION).intValue();
	}

	/**
	 * Clicks on the specified trainer name. 
	 * @param trainerName
	 * @return ClubOnlyPage
	 */
	public ClubOnlyPage clickTrainerNameAsFreeUser(String trainerName) {
		selenium.click("css=img[alt='"+trainerName+"']");
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ClubOnlyPage(selenium);
	}
	
	/**
	 * Clicks on Tony Horton's name to view his page. 
	 * @return TrainerTonyPage
	 */
	public TrainerTonyPage clickTony() {
		selenium.click(TONY_HORTON_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerTonyPage(selenium);
	}	

	/**
	 * Clicks on Chalene's name to view trainer page. 
	 * @return TrainerChalenePage
	 */
	public TrainerChalenePage clickChalene() {
		selenium.click(CHALENE_JOHNSON_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerChalenePage(selenium);
	}	
	
	/**
	 * Clicks on Debbie Sieber's name to view her trainer page. 
	 * @return TrainerDebbiePage
	 */
	public TrainerDebbiePage clickDebbie() {
		selenium.click(DEBBIE_SIEBERS_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerDebbiePage(selenium);
	}	
	
	/**
	 * Clicks on Shaun T's name to view his trainer page. 
	 * @return TrainerShaunPage
	 */
	public TrainerShaunPage clickShaun() {
		selenium.click(SHAUN_T_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerShaunPage(selenium);
	}
	
	/**
	 * Clicks on Donna Richardson's name to view her trainer page. 
	 * @return TrainerDonnaPage
	 */
	public TrainerDonnaPage clickDonna() {
		selenium.click(DONNA_RICHARDSON_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerDonnaPage(selenium);
	}
	
	/**
	 * Clicks on Leandro Carvalho's name to view his trainer page. 
	 * @return TrainerLeandroPage
	 */
	public TrainerLeandroPage clickLeandro() {
		selenium.click(LEANDRO_CARVALHO_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerLeandroPage(selenium);
	}
	
	/**
	 * Clicks on Kathy Smith's name to view her trainer page. 
	 * @return TrainerKathyPage
	 */
	public TrainerKathyPage clickKathy() {
		selenium.click(KATHY_SMITH_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerKathyPage(selenium);
	}
	
	/**
	 * Clicks on Gillian & Teigh's name to view their trainer page. 
	 * @return TrainerGillianPage
	 */
	public TrainerGillianPage clickGillianAndTeigh() {
		selenium.click(GILLIAN_TEIGH_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerGillianPage(selenium);
	}
	
	/**
	 * Clicks on Brett Hoebel's name to view his trainer page. 
	 * @return TrainerBrettPage
	 */
	public TrainerBrettPage clickBrett() {
		selenium.click(BRETT_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerBrettPage(selenium);
	}
	
	/**
	 * Clicks on Steve Edward's name to view his trainer page. 
	 * @return TrainerStevePage
	 */
	public TrainerStevePage clickSteve() {
		selenium.click(STEVE_EDWARDS_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerStevePage(selenium);
	}
	
	/**
	 * Clicks on More Experts to view other expert's trainer page. 
	 * @return TrainerMoreExpertsPage
	 */
	public TrainerMoreExpertsPage clickMoreExperts() {
		selenium.click(MORE_EXPERTS_IMAGE);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TrainerMoreExpertsPage(selenium);
	}
}
