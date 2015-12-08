package com.tbb.testscripts.others;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.framework.BaseTest;
import com.tbb.pages.HomePage;
import com.tbb.pages.others.ClubUserGuidePage;
import com.tbb.pages.others.ContestFAQPage;
import com.tbb.pages.others.SuperGymFAQPage;
import com.tbb.pages.others.SuperGymTutorialPage;
import com.tbb.pages.others.SupportHomePage;

/**
 *
 * This test script contains test method for verifying TBB Help/FAQ section shows required 
 * info. It also verifies navigation among different available help and faq links.
 *  @author Gaurav
 */
public class TestHelpAndFaq extends BaseTest {

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
	 * This test verifies Help and FAQ pages. It verifies navigation to available pages.
	 */
	@Test
	public void testHelpAndFAQ() {
		
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Verifying whether are on Home page");
		selenium.logComment("Clicking on 'Help/FAQ' link");
		selenium.logComment("Navigating to 'Team Beachbody Club User Guide' link");
		selenium.logComment("Navigating to 'SuperGym Tutorial' link");
		selenium.logComment("Navigating to 'SuperGym FAQ' link");
		selenium.logComment("Navigating to 'Contest FAQ' link");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		selenium.logComment("Verifying whether are on Home page");
		HomePage homePage  = new HomePage(selenium);
		
		selenium.logComment("Clicking on 'Help/FAQ' link");
		SupportHomePage supportHomePage = homePage.clickHelpFAQLink();
		supportHomePage.verifyUI();
		
		selenium.logComment("Navigating to 'Team Beachbody Club User Guide' link");
		ClubUserGuidePage clubUserGuidePage = supportHomePage.clickClubUserGuideLink();
		clubUserGuidePage.verifyUI();		
		
		selenium.logComment("Navigating to 'SuperGym Tutorial' link");
		SuperGymTutorialPage superGymTutorialPage = clubUserGuidePage.clickSuperGymTutorialLink();
		superGymTutorialPage.verifyUI();		
		
		selenium.logComment("Navigating to 'SuperGym FAQ' link");
		SuperGymFAQPage superGymFAQPage = superGymTutorialPage.clickSuperGymFAQLink();
		superGymFAQPage.verifyUI();		
		
		selenium.logComment("Navigating to 'Contest FAQ' link");
		ContestFAQPage contestFAQPage = superGymFAQPage.clickContestFAQLink();
		contestFAQPage.verifyUI();		
	}
}
