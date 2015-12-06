package com.tbb.testscripts.coach;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.pages.coach.CoachDestinationsPage;
import com.tbb.pages.coach.HowToQualifyPage;
import com.tbb.pages.coach.RewardsPage;
import com.tbb.pages.coach.TestimonialsPage;
import com.tbb.pages.coach.TravelInfoPage;

/**
 * 
 * This test script contains test method(s) for Coach Destinations page under Coach module
 * @author Gaurav
 */

public class TestCoachDestinations extends BaseTest {

	@BeforeClass
	public void setUp() {
		startSeleniumServer();
	}
	
	@BeforeMethod
	public void setUp(Method method) {
		ConfigFileReader.setConfigItemValue("app_ip", "www.coachdestinations.com");
		createSeleniumInstance(method);		
	}

	
	@AfterMethod
	public void stopSelenium() {
		stopSeleniumInstance();
		ConfigFileReader.setConfigItemValue("app_ip", "www.tbbbeta.com/?u=tbbbeta&p=prodstaging");
	}
	
	@AfterClass
	public void tearDown() {		
		stopSeleniumServer();
	}
	
	/**
	 * This test verifies UI of Coach Destinations page.
	 */
	@Test
	public void TestCoachDestinations() { 
		
		try {
			selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
			Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
			
			
			selenium.logComment("################## Scope of this test method ######################");
			selenium.logComment("Navigating to Coach Destinations Page");
			selenium.logComment("Verifying UI of page");
			selenium.logComment("Executing assertEmpty method");
			selenium.logComment("################## Scope of this test method ######################");
			
			
			
			selenium.logComment("Navigating to Coach Destinations Page");
			CoachDestinationsPage coachDestinationsPage = new CoachDestinationsPage(selenium);
			
			selenium.logComment("Verifying UI of page");
			coachDestinationsPage.verifyUI();
						
			selenium.logComment("Executing assertEmpty method");
			emptyMessageBuilder();	
			
		}catch(Exception e) {
			selenium.logComment(e.getMessage());
		}
		
	
		
		
		
	}
	
	/**
	 * This test verifies navigation among different pages of Coach Destinations module like 'How to Qualify', 'Rewards', 'Testimonials' and 'Travel Info'.
	 */
	@Test
	public void testCoachDestinationsNavigation() {
		selenium.logComment("Creating link for 'Detailed Report' in TestNG/ReportNG Logs");
		Reporter.log("<a href=" + "file://" + resultHtmlFileName	+ ">Detailed Report</a>");
		
		
		selenium.logComment("################## Scope of this test method ######################");
		selenium.logComment("Navigating to Coach Destinations Page");
		selenium.logComment("Clicking on 'How to Qualify' Link");
		selenium.logComment("Going back to 'Home Page'");
		selenium.logComment("Clicking on 'Rewards' Link");
		selenium.logComment("Going back to 'Home Page'");
		selenium.logComment("Clicking on 'Testimonials' Link");
		selenium.logComment("Going back to 'Home Page'");
		selenium.logComment("Clicking on 'Travel Info' Link");
		selenium.logComment("Going back to 'Home Page'");
		selenium.logComment("Executing assertEmpty method");
		selenium.logComment("################## Scope of this test method ######################");
		
		
		
		selenium.logComment("Navigating to Coach Destinations Page");
		CoachDestinationsPage coachDestinationsPage = new CoachDestinationsPage(selenium);
		
		selenium.logComment("Clicking on 'How to Qualify' Link");
		HowToQualifyPage howToQualifyPage = coachDestinationsPage.clickHowToQualifyLink();
		
		selenium.logComment("Going back to 'Home Page'");
		coachDestinationsPage = howToQualifyPage.clickHomeLink();
		
		selenium.logComment("Clicking on 'Rewards' Link");
		RewardsPage rewardsPage = coachDestinationsPage.clickRewardsLink();
		
		selenium.logComment("Going back to 'Home Page'");
		coachDestinationsPage = rewardsPage.clickHomeLink();
		
		
		selenium.logComment("Clicking on 'Testimonials' Link");
		TestimonialsPage testimonialsPage = coachDestinationsPage.clickTestimonialsLink();
		
		selenium.logComment("Going back to 'Home Page'");
		coachDestinationsPage = testimonialsPage.clickHomeLink();
		
		selenium.logComment("Clicking on 'Travel Info' Link");
		TravelInfoPage travelInfoPage = coachDestinationsPage.clickTravelInfoLink();
		
		selenium.logComment("Going back to 'Home Page'");
		coachDestinationsPage = travelInfoPage.clickHomeLink();
		
				
		selenium.logComment("Executing assertEmpty method");
		emptyMessageBuilder();	
		
	}
	
}
