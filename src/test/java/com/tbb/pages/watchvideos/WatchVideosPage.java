package com.tbb.pages.watchvideos;

import java.util.ArrayList;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.Dashboard;
import com.tbb.constants.UIRepository.Home;
import com.tbb.constants.UIRepository.WatchVideos;
import com.tbb.framework.BaseTest;
import com.tbb.logging.LoggingSelenium;
import com.tbb.pages.HomePage;
import com.tbb.pages.about.AboutPage;
/**
 * 
 * Page Object encapsulates the Watch Videos Page.
 * @author Jaya
 */
public class WatchVideosPage  extends BaseTest {

	protected LoggingSelenium selenium;
	/**
	 * This is constructor for this class. It validates that the user is on Watch Videos Page.
	 * @param	selenium
	 */
	public WatchVideosPage(LoggingSelenium selenium) {
		selenium.logComment("Executing constructor of Watch Videos Page.");
		this.selenium = selenium;
		assertTrue("This is not Watch Videos Page of logged in user, current page " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Watch Videos"), selenium);
	}
	
	/**
	 * Clicks on 'Success Stories' link in left hand menu and navigates user to Success Stories Page
	 * @return Success Stories Page
	 */
	public SuccessStoriesPage goToSuccessStoriesPage() {
		selenium.click(WatchVideos.NAV_MENU_SUCCESS_STORIES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new SuccessStoriesPage(selenium);
	}
	
	/**
	 * Clicks on 'Products' link in left hand menu and navigates user to Products Page
	 * @return Products Page
	 */
	public ProductsPage goToProductsPage() {
		selenium.click(WatchVideos.NAV_MENU_PRODUCTS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProductsPage(selenium);
	}
	
	/**
	 * Clicks on 'Eating Healthy' link in left hand menu and navigates user to Eating Healthy Page
	 * @return Eating Healthy Page
	 */
	public EatingHealthyPage goToEatingHealthyPage() {
		selenium.click(WatchVideos.NAV_MENU_EATING_HEALTHY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EatingHealthyPage(selenium);
	}
	
	/**
	 * Clicks on 'Workout Tips' link in left hand menu and navigates user to Workout Tips Page
	 * @return Workout Tips Page
	 */
	public WorkoutTipsPage goToWorkoutTipsPage() {
		selenium.click(WatchVideos.NAV_MENU_WORKOUT_TIPS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutTipsPage(selenium);
	}
	
	/**
	 * Clicks on 'Contests' link in left hand menu and navigates user to Contests Page
	 * @return Contests Page
	 */
	public ContestsPage goToContestsPage() {
		selenium.click(WatchVideos.NAV_MENU_CONTESTS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ContestsPage(selenium);
	}
	
	/**
	 * Clicks on 'Celebrity Trainers' link in left hand menu and navigates user to Celebrity Trainers Page
	 * @return Celebrity Trainers Page
	 */
	public CelebrityTrainersPage goToCelebrityTrainersPage() {
		selenium.click(WatchVideos.NAV_MENU_CELEBRITY_TRAINERS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CelebrityTrainersPage(selenium);
	}
	
	/**
	 * Clicks on 'Coaches' link in left hand menu and navigates user to Coaches Page
	 * @return Coaches Page
	 */
	public CoachesPage goToCoachesPage() {
		selenium.click(WatchVideos.NAV_MENU_COACHES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CoachesPage(selenium);
	}
	
	/**
	 * Clicks on 'Health News' link in left hand menu and navigates user to Health News Page
	 * @return Health News Page
	 */
	public HealthNewsPage goToHealthNewsPage() {
		selenium.click(WatchVideos.NAV_MENU_HEALTH_NEWS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HealthNewsPage(selenium);
	}
	
	/**
	 * Clicks on 'Team Beachbody' link in left hand menu and navigates user to Team Beachbody Page
	 * @return Team Beachbody Page
	 */
	public TeamBeachbodyPage goToTeamBeachbodyPage() {
		selenium.click(WatchVideos.NAV_MENU_TEAM_BEACHBODY_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TeamBeachbodyPage(selenium);
	}
	
	/**
	 * Clicks on 'VIP Workouts' link in left hand menu and navigates user to VIP Workouts Page
	 * @return VIP Workouts Page
	 */
	public VIPWorkoutsPage goToVIPWorkoutsPage() {
		selenium.click(WatchVideos.NAV_MENU_VIP_WORKOUTS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new VIPWorkoutsPage(selenium);
	}
	
	/**
	 * Clicks on 'VIP Fitness Tips' link in left hand menu and navigates user to VIP Fitness Tips Page
	 * @return VIP Fitness Tips Page
	 */
	public VIPFitnessTipsPage goToVIPFitnessTipsPage() {
		selenium.click(WatchVideos.NAV_MENU_VIP_FITNESS_TIPS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new VIPFitnessTipsPage(selenium);
	}
	
	/**
	 * Clicks on 'VIP Recipes' link in left hand menu and navigates user to VIP Recipes Page
	 * @return VIP Recipes Page
	 */
	public VIPRecipesPage goToVIPRecipesPage() {
		selenium.click(WatchVideos.NAV_MENU_VIP_RECIPES_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new VIPRecipesPage(selenium);
	}
	
	/**
	 * Clicks on 'VIP Style Tips' link in left hand menu and navigates user to VIP Style Tips Page
	 * @return VIP Style Tips Page
	 */
	public VIPStyleTipsPage goToVIPStyleTipsPage() {
		selenium.click(WatchVideos.NAV_MENU_VIP_STYLE_TIPS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new VIPStyleTipsPage(selenium);
	}

	/**
	 * Returns the number of links on the left hand side menu.
	 * @return int
	 */
	public int getMenuLinksCount() {
		return selenium.getXpathCount(WatchVideos.NAV_MENU_ITEMS_XPATH).intValue();		
	}
	
	/**
	 * Returns the text of links on the left hand side menu.
	 * @return String array
	 */
	public String[] getMenuLinksText() {
		int menuItemsCount = getMenuLinksCount();
		String[] menuLinksNames = null;
		if (menuItemsCount > 0) {
			menuLinksNames = new String[menuItemsCount];
			for (int i = 1; i <= menuItemsCount; i++) {
				menuLinksNames[i - 1] = selenium
						.getText(WatchVideos.NAV_MENU_ITEMS_TEXT_XPATH + "[" + i + "]/a");
			}
		}
		return menuLinksNames;
	}

	/**
	 * Clicks on 'Watch Now' link of Success Stories section. 
	 * @return Success Stories Page
	 */
	public SuccessStoriesPage clickSuccessStoriesWatchNow() {
		selenium.click(WatchVideos.SUCCESS_STORIES_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new SuccessStoriesPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of Products section. 
	 * @return Products Page
	 */
	public ProductsPage clickProductsWatchNow() {
		selenium.click(WatchVideos.PRODUCTS_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ProductsPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of Eating Healthy section. 
	 * @return Eating Healthy Page
	 */
	public EatingHealthyPage clickEatingHealthyWatchNow() {
		selenium.click(WatchVideos.EATING_HEALTHY_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new EatingHealthyPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of Workout Tips section. 
	 * @return Workout Tips Page
	 */
	public WorkoutTipsPage clickWorkoutTipsWatchNow() {
		selenium.click(WatchVideos.WORKOUT_TIPS_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WorkoutTipsPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of Contests section. 
	 * @return Contests Page
	 */
	public ContestsPage clickContestsWatchNow() {
		selenium.click(WatchVideos.CONTESTS_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new ContestsPage(selenium);
	}
	
	/**
	 * Clicks on 'Watch Now' link of Celebrity Trainers section. 
	 * @return Celebrity Trainers Page
	 */
	public CelebrityTrainersPage clickCelebrityTrainersWatchNow() {
		selenium.click(WatchVideos.CELEBRITY_TRAINERS_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CelebrityTrainersPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of Coaches section. 
	 * @return Coaches Page
	 */
	public CoachesPage clickCoachesWatchNow() {
		selenium.click(WatchVideos.COACHES_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new CoachesPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of Health News section. 
	 * @return Health News Page
	 */
	public HealthNewsPage clickHealthNewsWatchNow() {
		selenium.click(WatchVideos.HEALTH_NEWS_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HealthNewsPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of Team Beachbody section. 
	 * @return Team Beachbody Page
	 */
	public TeamBeachbodyPage clickTeamBeachbodyWatchNow() {
		selenium.click(WatchVideos.TEAM_BEACHBODY_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new TeamBeachbodyPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of VIP Workouts section. 
	 * @return VIP Workouts Page
	 */
	public VIPWorkoutsPage clickVIPWorkoutsWatchNow() {
		selenium.click(WatchVideos.VIP_WORKOUTS_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new VIPWorkoutsPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of VIP Fitness Tips section. 
	 * @return VIP Fitness Tips Page
	 */
	public VIPFitnessTipsPage clickVIPFitnessTipsWatchNow() {
		selenium.click(WatchVideos.VIP_FITNESS_TIPS_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new VIPFitnessTipsPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of VIP Recipes section. 
	 * @return VIP Recipes Page
	 */
	public VIPRecipesPage clickVIPRecipesWatchNow() {
		selenium.click(WatchVideos.VIP_RECIPES_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new VIPRecipesPage(selenium);
	}

	/**
	 * Clicks on 'Watch Now' link of VIP Style Tips section. 
	 * @return VIP Style Tips Page
	 */
	public VIPStyleTipsPage clickVIPStyleTipsWatchNow() {
		selenium.click(WatchVideos.VIP_STYLE_TIPS_WATCH_NOW_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new VIPStyleTipsPage(selenium);
	}

	/**
	 * Returns the number of boxes/sections on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getContentBoxesCount() {
		return selenium.getXpathCount(WatchVideos.CONTENT_BOXES_XPATH).intValue();
	}

	/**
	 * Returns the number of images on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getImageLinksCount() {
		return selenium.getXpathCount(WatchVideos.ALL_IMAGES).intValue();
	}

	/**
	 * Returns the text of the links on the content displayed in the center of the page. 
	 * @return String array
	 */
	public String[] getContentLinksText() {
		int contentItemsCount = getContentBoxesCount();
		String[] contentLinksNames = null;
		if (contentItemsCount > 0) {
			contentLinksNames = new String[contentItemsCount];
			for (int i = 1; i <= contentItemsCount; i++) {
				contentLinksNames[i-1] = selenium
						.getText("//div[@id='cont_sub_content']/ul/li" + "[" + i + "]/h2");
			}
		}
		return contentLinksNames;
	}

	/**
	 * Returns the number of texts on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getAllTextCount() {
		return selenium.getXpathCount(WatchVideos.ALL_TEXT).intValue();
	}

	/**
	 * Returns the number of Watch Now Links on the content displayed in the center of the page. 
	 * @return int
	 */
	public int getWatchNowLinksCount() {
		return selenium.getXpathCount(WatchVideos.ALL_WATCH_NOW_LINK).intValue();
	}

	/**
	 * Clicks on Watch Videos link at the top menu bar. Navigates user to Watch Videos Page. 
	 * @return Watch Videos Page
	 */
	public WatchVideosPage clickWatchVideosLink() {
		selenium.click(Dashboard.WATCH_VIDEOS_MENU_LINK);	         
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new WatchVideosPage(selenium);
	}

	/**
	 * Clicks on TBB Logo and navigates to TBB Home page
	 * @return
	 */
	public HomePage clickTBBLogo() {
		selenium.click(Home.TBB_LOGO);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new HomePage(selenium);
	}

	/**
	 * Returns title of RRMs
	 */
	public ArrayList getRRMsTitles() {
		ArrayList<String> rrmTitles = new ArrayList();
		int rrmsCount = getRRMsCount();
		for (int i =1; i<=rrmsCount; i++) {
			rrmTitles.add(selenium.getText(WatchVideos.WATCH_VIDEOS_PROGRAM_RRM_SECTION + "[" + i + "]" + WatchVideos.WATCH_VIDEOS_PROGRAM_RRM_TITLE));
		}
		return rrmTitles;
	}
	
	/**
	 * Returns number of RRMs
	 * @return int
	 */
	public int getRRMsCount() {
		return selenium.getXpathCount(WatchVideos.WATCH_VIDEOS_PROGRAM_RRM_SECTION).intValue();
	}

	/**
	 * Navigate to About Page. 
	 * @return AboutPage
	 */
	public AboutPage clickAboutLink() {
		selenium.click(Dashboard.ABOUT_MENU_LINK);
		selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);
		return new AboutPage(selenium);
	}
}