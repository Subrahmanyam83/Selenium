package com.tbb.testscripts.clubukuser;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.constants.UIRepository.WatchVideos;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.DashboardPage;
import com.tbb.pages.HomePage;
import com.tbb.pages.SignInPage;
import com.tbb.pages.watchvideos.CelebrityTrainersPage;
import com.tbb.pages.watchvideos.CoachesPage;
import com.tbb.pages.watchvideos.ContestsPage;
import com.tbb.pages.watchvideos.EatingHealthyPage;
import com.tbb.pages.watchvideos.HealthNewsPage;
import com.tbb.pages.watchvideos.ProductsPage;
import com.tbb.pages.watchvideos.SuccessStoriesPage;
import com.tbb.pages.watchvideos.TeamBeachbodyPage;
import com.tbb.pages.watchvideos.VIPFitnessTipsPage;
import com.tbb.pages.watchvideos.VIPRecipesPage;
import com.tbb.pages.watchvideos.VIPWorkoutsPage;
import com.tbb.pages.watchvideos.WatchVideosPage;
import com.tbb.pages.watchvideos.WorkoutTipsPage;

/**
 * 
 * This test script contains test method(s) for alerts shown on Watch Video page for UK Club user.
 * @author Jaya
 */
public class TestWatchVideoAlert extends BaseTest{

	@BeforeClass
	public void setUp() {
		startSeleniumServer();		
	}

	@BeforeMethod
	public void setUp(Method method) {
		createSeleniumInstance(method);		
	}

	@AfterMethod
	public void stopSelenium() {
		stopSeleniumInstance();
	}	

	@AfterClass
	public void tearDown() {		
		stopSeleniumServer();
	}

	/**
	 * Test script for verifying that the Club UK User alert is displayed on Watch Video Page 
	 * on logging in as Club UK User.
	 */ 
	@Test
	public void testWatchVideoAlertAsClubUKuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Watch Video Page.");
		selenium.logComment("Verifying alert is available on Watch Video page.");
		selenium.logComment("Navigate to Success Stories Page.");
		selenium.logComment("Verifying alert is available on Success Stories page and other sub pages.");
		selenium.logComment("Navigate to Products Page.");
		selenium.logComment("Verifying alert is available on Products page.");
		selenium.logComment("Navigate to Eating Healthy Page.");
		selenium.logComment("Verifying alert is available on Eating Healthy page.");
		selenium.logComment("Navigate to Workout Tips Page.");
		selenium.logComment("Verifying alert is available on Workout Tips page.");
		selenium.logComment("Navigate to Contests Page.");
		selenium.logComment("Verifying alert is available on Contests page.");
		selenium.logComment("Navigate to Celebrity Trainers Page.");
		selenium.logComment("Verifying alert is available on Celebrity Trainers Page and other sub pages.");
		selenium.logComment("Navigate to Coaches Page.");
		selenium.logComment("Verifying alert is available on Coaches Page and other Sub pages.");
		selenium.logComment("Navigate to Health News Page.");
		selenium.logComment("Verifying alert is available on Health News page.");
		selenium.logComment("Navigate to Team Beachbody Page.");
		selenium.logComment("Verifying alert is available on Team Beachbody page and other sub pages.");
		selenium.logComment("Navigate to VIP Workouts Page.");
		selenium.logComment("Verifying alert is available on VIP Workouts page and other sub pages.");
		selenium.logComment("Navigate to VIP Fitness Tips Page.");
		selenium.logComment("Verifying alert is available on VIP Fitness Tips and other sub page.");
		selenium.logComment("Navigate to VIP Recipes Page.");
		selenium.logComment("Verifying alert is available on VIP Recipes and other sub pages.");
		selenium.logComment("Navigate to VIP Style Tips Page.");
		selenium.logComment("Verifying alert is available on VIP Style Tips page.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.clubuk.username"), ConfigFileReader.getConfigItemValue("tbb.clubuk.userpassword"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.clubuk.username"), ConfigFileReader.getConfigItemValue("tbb.clubuk.userpassword"));
		}
		
		selenium.logComment("Navigate to Watch Video Page.");	
		WatchVideosPage watchVideoPage = dashboardPage.clickWatchVideosLink();
		
		selenium.logComment("Verifying alert is available on Watch Video page.");		
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigate to Success Stories Page.");	
		SuccessStoriesPage successStoriesPage = watchVideoPage.goToSuccessStoriesPage();
		
		selenium.logComment("Verifying alert is available on Success Stories page and other sub pages.");		
		assertTrue("Club UK User Alert is missing from Success Stories page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Success Stories Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToCoachBusinessSuccess();
		assertTrue("Club UK User Alert is missing from Coach Business Success page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Coach Business Success Page.", (selenium.isTextPresent("The Beachbody Coach business opportunity is currently available only to U.S. residents. Questions? Call 0800 183 0166.")), selenium);
		successStoriesPage.goToShakeologySuccess();
		assertTrue("Club UK User Alert is missing from Shakeology Success page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Shakeology Success Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		successStoriesPage.goToP90X();
		assertTrue("Club UK User Alert is missing from P90X page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from P90X Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToINSANITY();
		assertTrue("Club UK User Alert is missing from INSANITY page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from INSANITY Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToBrazilButtLift();
		assertTrue("Club UK User Alert is missing from Brazil Butt Lift page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Brazil Butt Lift Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToTurboFire();
		assertTrue("Club UK User Alert is missing from Turbo Fire page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Turbo Fire Page.", !(selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToSlimIn6();
		assertTrue("Club UK User Alert is missing from Slim In 6 page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Slim In 6 Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToPower90();
		assertTrue("Club UK User Alert is missing from Power 90 page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Power90 Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToTurboJam();
		assertTrue("Club UK User Alert is missing from Turbo Jam page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Turbo Jam Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goTo10MinuteTrainer();
		assertTrue("Club UK User Alert is missing from 10-Minute Trainer page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from 10-Minute Trainer Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToHipHopAbs();
		assertTrue("Club UK User Alert is missing from Hip Hop Abs page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Hip Hop Abs Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToChaLEANExtreme();
		assertTrue("Club UK User Alert is missing from ChaLEAN Extreme page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from ChaLEAN Extreme Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToYogaBootyBallet();
		assertTrue("Club UK User Alert is missing from Yoga Booty Ballet page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Yoga Booty Ballet Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToKSPY2();
		assertTrue("Club UK User Alert is missing from KSPY2 page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from KSPY2 Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToShaunTsFitKidsClub();
		assertTrue("Club UK User Alert is missing from Shaun T's Fit Kis Club page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Shaun T's Fit Kis Club Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		successStoriesPage.goToRockinBody();
		assertTrue("Club UK User Alert is missing from Rockin' Body page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Rockin' Body Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
			
		selenium.logComment("Navigate to Products Page.");	
		watchVideoPage = successStoriesPage.clickWatchVideosLink();
		ProductsPage productsPage = watchVideoPage.goToProductsPage();
		
		selenium.logComment("Verifying alert is available on Products page.");		
		assertTrue("Club UK User Alert is missing from Products page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Products Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToShakeology();
		assertTrue("Club UK User Alert is missing from Shakeology page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Shakeology Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		productsPage.goToP90X();
		assertTrue("Club UK User Alert is missing from P90X page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from P90X Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToINSANITY();
		assertTrue("Club UK User Alert is missing from INSANITY page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from INSANITY Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToBrazilButtLift();
		assertTrue("Club UK User Alert is missing from Brazil Butt Lift page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Brazil Butt Lift Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToTurboFire();
		assertTrue("Club UK User Alert is missing from Turbo Fire page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Turbo Fire Page.", !(selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToBodyGospel();
		assertTrue("Club UK User Alert is missing from Body Gospel page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Body Gospel Page.", !(selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToSlimIn6();
		assertTrue("Club UK User Alert is missing from Slim in 6 page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Slim in 6 Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToPower90();
		assertTrue("Club UK User Alert is missing from Power 90 page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Power 90 Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToTurboJam();
		assertTrue("Club UK User Alert is missing from Turbo Jam page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Turbo Jam Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goTo10MinuteTrainer();
		assertTrue("Club UK User Alert is missing from 10-Minute Trainer page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from 10-Minute Trainer Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToP90XONEonONE();
		assertTrue("Club UK User Alert is missing from P90X ONE on ONE page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from P90X ONE on ONE Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToRevAbs();
		assertTrue("Club UK User Alert is missing from RevAbs page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from RevAbs Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToHipHopAbs();
		assertTrue("Club UK User Alert is missing from Hip Hop Abs page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Hip Hop Abs Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToChaLEANExtreme();
		assertTrue("Club UK User Alert is missing from ChaLEAN Extreme page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from ChaLEAN Extreme Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToRockinBody();
		assertTrue("Club UK User Alert is missing from Rockin' Body page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Rockin' Body Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToKSPY2();
		assertTrue("Club UK User Alert is missing from KSPY2 page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from KSPY2 Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToTotalBodySolution();
		assertTrue("Club UK User Alert is missing from Total Body Solution page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Total Body Solution Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		productsPage.goToYogaBootyBallet();
		assertTrue("Club UK User Alert is missing from Yoga Booty Ballet page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Yoga Booty Ballet Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigate to Eating Healthy Page.");	
		watchVideoPage = productsPage.clickWatchVideosLink();
		EatingHealthyPage eatingHealthyPage = watchVideoPage.goToEatingHealthyPage();
		
		selenium.logComment("Verifying alert is available on Eating Healthy page.");		
		assertTrue("Club UK User Alert is missing from Eating Healthy page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Eating Healthy Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to Workout Tips Page.");	
		watchVideoPage = eatingHealthyPage.clickWatchVideosLink();
		WorkoutTipsPage workoutTipsPage = watchVideoPage.goToWorkoutTipsPage();
		
		selenium.logComment("Verifying alert is available on Workout Tips page.");		
		assertTrue("Club UK User Alert is missing from Workout Tips page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Workout Tips Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to Contests Page.");	
		watchVideoPage = workoutTipsPage.clickWatchVideosLink();
		ContestsPage contestsPage = watchVideoPage.goToContestsPage();
		
		selenium.logComment("Verifying alert is available on Contests page.");		
		assertTrue("Club UK User Alert is missing from Contests page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Contests Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to Celebrity Trainers Page.");	
		watchVideoPage = contestsPage.clickWatchVideosLink();
		CelebrityTrainersPage celebrityTrainersPage = watchVideoPage.goToCelebrityTrainersPage();
		
		selenium.logComment("Verifying alert is available on Celebrity Trainers Page and other sub pages.");		
		assertTrue("Club UK User Alert is missing from Celebrity Trainers page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Celebrity Trainers Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		celebrityTrainersPage.goToTonyHorton();
		assertTrue("Club UK User Alert is missing from Tony Horton page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Tony Horton Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		celebrityTrainersPage.goToChaleneJohnson();
		assertTrue("Club UK User Alert is missing from Chalene Johnson page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Chalene Johnson Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		celebrityTrainersPage.goToShaunT();
		assertTrue("Club UK User Alert is missing from Shaun T page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Shaun T Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		celebrityTrainersPage.goToDebbieSiebers();
		assertTrue("Club UK User Alert is missing from Debbie Siebers page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Debbie Siebers Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to Coaches Page.");	
		watchVideoPage = celebrityTrainersPage.clickWatchVideosLink();
		CoachesPage myCoachPage = watchVideoPage.goToCoachesPage();
		
		selenium.logComment("Verifying alert is available on Coaches Page and other Sub pages.");		
		assertTrue("Club UK User Alert is missing from Coaches page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Coaches Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		myCoachPage.goToEvents();
		assertTrue("Club UK User Alert is missing from Events page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Events Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		myCoachPage.goToPersonalStories();
		assertTrue("Club UK User Alert is missing from Personal Stories page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Personal Stories  Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		myCoachPage.goToGivingBack();
		assertTrue("Club UK User Alert is missing from Giving Back page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Giving Back Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to Health News Page.");
		watchVideoPage = myCoachPage.clickWatchVideosLink();
		HealthNewsPage healthNewsPage = watchVideoPage.goToHealthNewsPage();
		
		selenium.logComment("Verifying alert is available on Health News page.");		
		assertTrue("Club UK User Alert is missing from Health News page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Health News Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to Team Beachbody Page.");	
		watchVideoPage = healthNewsPage.clickWatchVideosLink();
		TeamBeachbodyPage teambeachbodyPage = watchVideoPage.goToTeamBeachbodyPage();
		
		selenium.logComment("Verifying alert is available on Team Beachbody page and other sub pages.");		
		assertTrue("Club UK User Alert is missing from Team Beachbody page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Team Beachbody Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		teambeachbodyPage.goToNews();
		assertTrue("Club UK User Alert is missing from News page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from News Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		teambeachbodyPage.goToGivingBack();
		assertTrue("Club UK User Alert is missing from Giving Back page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Giving Back Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		teambeachbodyPage.goToInsideTBB();
		assertTrue("Club UK User Alert is missing from Inside TBB page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Inside TBB Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to VIP Workouts Page.");
		watchVideoPage = teambeachbodyPage.clickWatchVideosLink();
		VIPWorkoutsPage vipWorkoutsPage = watchVideoPage.goToVIPWorkoutsPage();
		
		selenium.logComment("Verifying alert is available on VIP Workouts page and other sub pages.");		
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipWorkoutsPage.goToTonyHorton();
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipWorkoutsPage.goToChaleneJohnson();
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipWorkoutsPage.goToShaunT();
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipWorkoutsPage.goToDebbieSiebers();
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipWorkoutsPage.goToGillianAndTeigh();
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipWorkoutsPage.goToLeandroCarvalho();
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipWorkoutsPage.goToBrettHoebel();
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipWorkoutsPage.goToSuperWorkouts();
		assertTrue("Club UK User Alert is missing from Watch Video page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to VIP Fitness Tips Page.");	
		watchVideoPage = vipWorkoutsPage.clickWatchVideosLink();
		VIPFitnessTipsPage vipFitnessTipsPage = watchVideoPage.goToVIPFitnessTipsPage();
		
		selenium.logComment("Verifying alert is available on VIP Fitness Tips and other sub page.");		
		assertTrue("Club UK User Alert is missing from VIP Fitness Tips page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from VIP Fitness Tips Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipFitnessTipsPage.goToTonyHorton();
		assertTrue("Club UK User Alert is missing from Tony Horton page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Tony Horton Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipFitnessTipsPage.goToChaleneJohnson();
		assertTrue("Club UK User Alert is missing from Chalene Johnson page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Chalene Johnson Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipFitnessTipsPage.goToShaunT();
		assertTrue("Club UK User Alert is missing from Shaun T page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Shaun T Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipFitnessTipsPage.goToDebbieSiebers();
		assertTrue("Club UK User Alert is missing from Debbie Siebers page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Debbie Siebers Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipFitnessTipsPage.goToGillianAndTeigh();
		assertTrue("Club UK User Alert is missing from Gillian & Teigh page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Gillian & Teigh Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipFitnessTipsPage.goToLeandroCarvalho();
		assertTrue("Club UK User Alert is missing from Leandro Carvalho page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Leandro Carvalho Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipFitnessTipsPage.goToBrettHoebel();
		assertTrue("Club UK User Alert is missing from Brett Hoebel page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Brett Hoebel Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipFitnessTipsPage.goToSuperWorkouts();
		assertTrue("Club UK User Alert is missing from Super Workouts page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Super Workouts Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to VIP Recipes Page.");	
		watchVideoPage = vipFitnessTipsPage.clickWatchVideosLink();
		VIPRecipesPage vipRecipesPage = watchVideoPage.goToVIPRecipesPage();
		
		selenium.logComment("Verifying alert is available on VIP Recipes and other sub pages.");		
		assertTrue("Club UK User Alert is missing from VIP Recipes page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from VIP Recipes Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		vipRecipesPage.goToVIPHealthyEatingTips();
		assertTrue("Club UK User Alert is missing from VIP Healthy Eating Tips page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from VIP Healthy Eating Tips Page.", (selenium.isTextPresent("Shakeology is not available for sale in the UK at this time.")), selenium);
		
		selenium.logComment("Navigate to VIP Style Tips Page.");	
		watchVideoPage = vipRecipesPage.clickWatchVideosLink();
		watchVideoPage.goToVIPStyleTipsPage();
		
		selenium.logComment("Verifying alert is available on VIP Style Tips page.");		
		assertTrue("Club UK User Alert is missing from VIP Style Tips page.", (selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from VIP Style Tips Page.", (selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
	
	/**
	 * Test script for verifying that the Club UK User alert is not displayed on Watch Video Pages 
	 * on logging in as Free User.
	 */ 
	@Test
	public void testWatchVideoAlertAsClubUSuser(){
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Sign In' Link");
		selenium.logComment("Entering valid username and password");
		selenium.logComment("Navigate to Watch Video Page.");
		selenium.logComment("Verifying alert is available on Watch Video page.");
		selenium.logComment("Navigate to Success Stories Page.");
		selenium.logComment("Verifying alert is available on Success Stories page and other sub pages.");
		selenium.logComment("Navigate to Products Page.");
		selenium.logComment("Verifying alert is available on Products page.");
		selenium.logComment("Navigate to Eating Healthy Page.");
		selenium.logComment("Verifying alert is available on Eating Healthy page.");
		selenium.logComment("Navigate to Workout Tips Page.");
		selenium.logComment("Verifying alert is available on Workout Tips page.");
		selenium.logComment("Navigate to Contests Page.");
		selenium.logComment("Verifying alert is available on Contests page.");
		selenium.logComment("Navigate to Celebrity Trainers Page.");
		selenium.logComment("Verifying alert is available on Celebrity Trainers Page and other sub pages.");
		selenium.logComment("Navigate to Coaches Page.");
		selenium.logComment("Verifying alert is available on Coaches Page and other Sub pages.");
		selenium.logComment("Navigate to Health News Page.");
		selenium.logComment("Verifying alert is available on Health News page.");
		selenium.logComment("Navigate to Team Beachbody Page.");
		selenium.logComment("Verifying alert is available on Team Beachbody page and other sub pages.");
		selenium.logComment("Navigate to VIP Workouts Page.");
		selenium.logComment("Verifying alert is available on VIP Workouts page and other sub pages.");
		selenium.logComment("Navigate to VIP Fitness Tips Page.");
		selenium.logComment("Verifying alert is available on VIP Fitness Tips and other sub page.");
		selenium.logComment("Navigate to VIP Recipes Page.");
		selenium.logComment("Verifying alert is available on VIP Recipes and other sub pages.");
		selenium.logComment("Verifying alert is available on VIP Recipes and other sub pages.");
		selenium.logComment("Verifying alert is available on VIP Recipes and other sub pages.");
		selenium.logComment("Verifying alert is available on VIP Recipes and other sub pages.");
		selenium.logComment("Verifying alert is available on VIP Recipes and other sub pages.");
		selenium.logComment("Navigate to VIP Style Tips Page.");
		selenium.logComment("Verifying alert is available on VIP Style Tips page.");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		

		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);

		selenium.logComment("Clicking on 'Sign In' Link");
		DashboardPage dashboardPage;
		if(ConfigFileReader.getConfigItemValue("selenium.browser").equals("*iexploreproxy") || ConfigFileReader.getConfigItemValue("selenium.browser").equals("*safariproxy")) {
			dashboardPage = homePage.clickSignInSpecial(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		} else {
			SignInPage signInPage = homePage.clickSignIn();

			selenium.logComment("Entering valid username and password");
			dashboardPage = signInPage.loginValidUser(ConfigFileReader.getConfigItemValue("tbb.username1"), ConfigFileReader.getConfigItemValue("tbb.password1"));
		}
		
		selenium.logComment("Navigate to Watch Video Page.");	
		WatchVideosPage watchVideoPage = dashboardPage.clickWatchVideosLink();
		
		selenium.logComment("Verifying alert is available on Watch Video page.");		
		assertTrue("Club UK User Alert is missing from Watch Video page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		assertTrue("Club UK User Alert text is missing from Watch Video Page.", !(selenium.isTextPresent("Contests and Coaching Opportunity only available to U.S. residents at this time. Your results may vary.")), selenium);
		
		selenium.logComment("Navigate to Success Stories Page.");	
		SuccessStoriesPage successStoriesPage = watchVideoPage.goToSuccessStoriesPage();
		
		selenium.logComment("Verifying alert is available on Success Stories page and other sub pages.");		
		assertTrue("Club UK User Alert is missing from Success Stories page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToCoachBusinessSuccess();
		assertTrue("Club UK User Alert is missing from Coach Business Success page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToShakeologySuccess();
		assertTrue("Club UK User Alert is missing from Shakeology Success page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToP90X();
		assertTrue("Club UK User Alert is missing from P90X page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToINSANITY();
		assertTrue("Club UK User Alert is missing from INSANITY page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToBrazilButtLift();
		assertTrue("Club UK User Alert is missing from Brazil Butt Lift page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToTurboFire();
		assertTrue("Club UK User Alert is missing from Turbo Fire page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToSlimIn6();
		assertTrue("Club UK User Alert is missing from Slim In 6 page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToPower90();
		assertTrue("Club UK User Alert is missing from Power 90 page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToTurboJam();
		assertTrue("Club UK User Alert is missing from Turbo Jam page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goTo10MinuteTrainer();
		assertTrue("Club UK User Alert is missing from 10-Minute Trainer page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToHipHopAbs();
		assertTrue("Club UK User Alert is missing from Hip Hop Abs page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToChaLEANExtreme();
		assertTrue("Club UK User Alert is missing from ChaLEAN Extreme page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToYogaBootyBallet();
		assertTrue("Club UK User Alert is missing from Yoga Booty Ballet page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToKSPY2();
		assertTrue("Club UK User Alert is missing from KSPY2 page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToShaunTsFitKidsClub();
		assertTrue("Club UK User Alert is missing from Shaun T's Fit Kis Club page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		successStoriesPage.goToRockinBody();
		assertTrue("Club UK User Alert is missing from Rockin' Body page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
			
		selenium.logComment("Navigate to Products Page.");	
		watchVideoPage = successStoriesPage.clickWatchVideosLink();
		ProductsPage productsPage = watchVideoPage.goToProductsPage();
		
		selenium.logComment("Verifying alert is available on Products page.");		
		assertTrue("Club UK User Alert is missing from Products page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToShakeology();
		assertTrue("Club UK User Alert is missing from Shakeology page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToP90X();
		assertTrue("Club UK User Alert is missing from P90X page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToINSANITY();
		assertTrue("Club UK User Alert is missing from INSANITY page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToBrazilButtLift();
		assertTrue("Club UK User Alert is missing from Brazil Butt Lift page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToTurboFire();
		assertTrue("Club UK User Alert is missing from Turbo Fire page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToBodyGospel();
		assertTrue("Club UK User Alert is missing from Body Gospel page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToSlimIn6();
		assertTrue("Club UK User Alert is missing from Slim in 6 page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToPower90();
		assertTrue("Club UK User Alert is missing from Power 90 page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToTurboJam();
		assertTrue("Club UK User Alert is missing from Turbo Jam page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goTo10MinuteTrainer();
		assertTrue("Club UK User Alert is missing from 10-Minute Trainer page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToP90XONEonONE();
		assertTrue("Club UK User Alert is missing from P90X ONE on ONE page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToRevAbs();
		assertTrue("Club UK User Alert is missing from RevAbs page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToHipHopAbs();
		assertTrue("Club UK User Alert is missing from Hip Hop Abs page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToChaLEANExtreme();
		assertTrue("Club UK User Alert is missing from ChaLEAN Extreme page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToRockinBody();
		assertTrue("Club UK User Alert is missing from Rockin' Body page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToKSPY2();
		assertTrue("Club UK User Alert is missing from KSPY2 page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToTotalBodySolution();
		assertTrue("Club UK User Alert is missing from Total Body Solution page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		productsPage.goToYogaBootyBallet();
		assertTrue("Club UK User Alert is missing from Yoga Booty Ballet page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to Eating Healthy Page.");	
		watchVideoPage = productsPage.clickWatchVideosLink();
		EatingHealthyPage eatingHealthyPage = watchVideoPage.goToEatingHealthyPage();
		
		selenium.logComment("Verifying alert is available on Eating Healthy page.");		
		assertTrue("Club UK User Alert is missing from Eating Healthy page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to Workout Tips Page.");	
		watchVideoPage = eatingHealthyPage.clickWatchVideosLink();
		WorkoutTipsPage workoutTipsPage = watchVideoPage.goToWorkoutTipsPage();
		
		selenium.logComment("Verifying alert is available on Workout Tips page.");		
		assertTrue("Club UK User Alert is missing from Workout Tips page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to Contests Page.");	
		watchVideoPage = workoutTipsPage.clickWatchVideosLink();
		ContestsPage contestsPage = watchVideoPage.goToContestsPage();
		
		selenium.logComment("Verifying alert is available on Contests page.");		
		assertTrue("Club UK User Alert is missing from Contests page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to Celebrity Trainers Page.");	
		watchVideoPage = contestsPage.clickWatchVideosLink();
		CelebrityTrainersPage celebrityTrainersPage = watchVideoPage.goToCelebrityTrainersPage();
		
		selenium.logComment("Verifying alert is available on Celebrity Trainers Page and other sub pages.");		
		assertTrue("Club UK User Alert is missing from Celebrity Trainers page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		celebrityTrainersPage.goToTonyHorton();
		assertTrue("Club UK User Alert is missing from Tony Horton page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		celebrityTrainersPage.goToChaleneJohnson();
		assertTrue("Club UK User Alert is missing from Chalene Johnson page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		celebrityTrainersPage.goToShaunT();
		assertTrue("Club UK User Alert is missing from Shaun T page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		celebrityTrainersPage.goToDebbieSiebers();
		assertTrue("Club UK User Alert is missing from Debbie Siebers page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to Coaches Page.");	
		watchVideoPage = celebrityTrainersPage.clickWatchVideosLink();
		CoachesPage myCoachPage = watchVideoPage.goToCoachesPage();
		
		selenium.logComment("Verifying alert is available on Coaches Page and other Sub pages.");		
		assertTrue("Club UK User Alert is missing from Coaches page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		myCoachPage.goToEvents();
		assertTrue("Club UK User Alert is missing from Events page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		myCoachPage.goToPersonalStories();
		assertTrue("Club UK User Alert is missing from Personal Stories page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		myCoachPage.goToGivingBack();
		assertTrue("Club UK User Alert is missing from Giving Back page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to Health News Page.");
		watchVideoPage = myCoachPage.clickWatchVideosLink();
		HealthNewsPage healthNewsPage = watchVideoPage.goToHealthNewsPage();
		
		selenium.logComment("Verifying alert is available on Health News page.");		
		assertTrue("Club UK User Alert is missing from Health News page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to Team Beachbody Page.");	
		watchVideoPage = healthNewsPage.clickWatchVideosLink();
		TeamBeachbodyPage teambeachbodyPage = watchVideoPage.goToTeamBeachbodyPage();
		
		selenium.logComment("Verifying alert is available on Team Beachbody page and other sub pages.");		
		assertTrue("Club UK User Alert is missing from Team Beachbody page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		teambeachbodyPage.goToNews();
		assertTrue("Club UK User Alert is missing from News page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		teambeachbodyPage.goToGivingBack();
		assertTrue("Club UK User Alert is missing from Giving Back page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		teambeachbodyPage.goToInsideTBB();
		assertTrue("Club UK User Alert is missing from Inside TBB page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to VIP Workouts Page.");
		watchVideoPage = teambeachbodyPage.clickWatchVideosLink();
		VIPWorkoutsPage vipWorkoutsPage = watchVideoPage.goToVIPWorkoutsPage();
		
		selenium.logComment("Verifying alert is available on VIP Workouts page and other sub pages.");		
		assertTrue("Club UK User Alert is displayed on VIP Workouts page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipWorkoutsPage.goToTonyHorton();
		assertTrue("Club UK User Alert is displayed on Tony Horton Page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipWorkoutsPage.goToChaleneJohnson();
		assertTrue("Club UK User Alert is displayed on Chalene Johnson Page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipWorkoutsPage.goToShaunT();
		assertTrue("Club UK User Alert is displayed on Shaun T Page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipWorkoutsPage.goToDebbieSiebers();
		assertTrue("Club UK User Alert is displayed on Debbie Siebers Page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipWorkoutsPage.goToGillianAndTeigh();
		assertTrue("Club UK User Alert is displayed on Gillian & Teigh Page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipWorkoutsPage.goToLeandroCarvalho();
		assertTrue("Club UK User Alert is displayed on Leandro Carvalho Page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipWorkoutsPage.goToBrettHoebel();
		assertTrue("Club UK User Alert is displayed on Brett Hoebel page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipWorkoutsPage.goToSuperWorkouts();
		assertTrue("Club UK User Alert is displayed on Super Workouts Page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to VIP Fitness Tips Page.");	
		watchVideoPage = vipWorkoutsPage.clickWatchVideosLink();
		VIPFitnessTipsPage vipFitnessTipsPage = watchVideoPage.goToVIPFitnessTipsPage();
		
		selenium.logComment("Verifying alert is available on VIP Fitness Tips and other sub page.");		
		assertTrue("Club UK User Alert is missing from VIP Fitness Tips page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);

		vipFitnessTipsPage.goToTonyHorton();
		assertTrue("Club UK User Alert is missing from Tony Horton page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipFitnessTipsPage.goToChaleneJohnson();
		assertTrue("Club UK User Alert is missing from Chalene Johnson page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipFitnessTipsPage.goToShaunT();
		assertTrue("Club UK User Alert is missing from Shaun T page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipFitnessTipsPage.goToDebbieSiebers();
		assertTrue("Club UK User Alert is missing from Debbie Siebers page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipFitnessTipsPage.goToGillianAndTeigh();
		assertTrue("Club UK User Alert is missing from Gillian & Teigh page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipFitnessTipsPage.goToLeandroCarvalho();
		assertTrue("Club UK User Alert is missing from Leandro Carvalho page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipFitnessTipsPage.goToBrettHoebel();
		assertTrue("Club UK User Alert is missing from Brett Hoebel page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipFitnessTipsPage.goToSuperWorkouts();
		assertTrue("Club UK User Alert is missing from Super Workouts page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to VIP Recipes Page.");	
		watchVideoPage = vipFitnessTipsPage.clickWatchVideosLink();
		VIPRecipesPage vipRecipesPage = watchVideoPage.goToVIPRecipesPage();
		
		selenium.logComment("Verifying alert is available on VIP Recipes and other sub pages.");		
		assertTrue("Club UK User Alert is missing from VIP Recipes page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		vipRecipesPage.goToVIPHealthyEatingTips();
		assertTrue("Club UK User Alert is missing from VIP Healthy Eating Tips page.", !(selenium.isVisible(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Navigate to VIP Style Tips Page.");	
		watchVideoPage = vipRecipesPage.clickWatchVideosLink();
		watchVideoPage.goToVIPStyleTipsPage();
		
		selenium.logComment("Verifying alert is available on VIP Style Tips page.");		
		assertTrue("Club UK User Alert is displayed on VIP Style Tips page.", !(selenium.isElementPresent(WatchVideos.CLUB_UK_USER_ALERT)), selenium);
		
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();
	}
}