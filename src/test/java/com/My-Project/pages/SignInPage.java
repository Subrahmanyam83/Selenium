package com.tbb.pages;

import com.tbb.constants.TestConsts;
import com.tbb.constants.UIRepository.SignIn;
import com.tbb.framework.BaseTest;
import com.tbb.framework.ConfigFileReader;
import com.tbb.logging.LoggingSelenium;

/**
 * 
 * Page Object encapsulates the Sign-in page.
 * @author Gaurav
 */
public class SignInPage extends BaseTest{

        private LoggingSelenium selenium;
        /**
    	 * This is constructor for this class. It validates that the user is on Sign In Page.
    	 * @param	selenium
    	 */
        public SignInPage(LoggingSelenium selenium) {
                this.selenium = selenium;
                selenium.logComment("Executing constructor of Sign In Class");
				assertTrue("This is not sign in page, current page is:  " + selenium.getLocation(), selenium.getTitle().equals("Team Beachbody - Home"), selenium);
				
        }

        /**
         * Login as valid user
         *
         * @param userName
         * @param password
         * @return Dashboard Page
         */
        public DashboardPage loginValidUser(String userName, String password) {
        	
        	String userType = (userName.equalsIgnoreCase("mgupta@beachbody.com")) ? "club" : "free";
        	ConfigFileReader.setConfigItemValue("tbb.user.type", userType);
        	
                selenium.type(SignIn.USERNAME_TEXTBOX, userName);
                selenium.type(SignIn.PASSWORD_TEXTBOX, password);
                selenium.click(SignIn.SIGN_IN_BUTTON);
                selenium.waitForPageToLoad(TestConsts.PAGE_LOAD_TIMEOUT);

                return new DashboardPage(selenium);
        }
}
