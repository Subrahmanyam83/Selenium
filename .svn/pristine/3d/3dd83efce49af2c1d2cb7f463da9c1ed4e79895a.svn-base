/*
 * Copyright 2007 united internet (unitedinternet.com) Robert Zimmermann
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.tbb.logging;

import com.tbb.constants.TestConsts;
import com.tbb.framework.BaseTest;
import com.thoughtworks.selenium.CommandProcessor;
import com.thoughtworks.selenium.DefaultSelenium;

/**
 * Adds ability to log comments to DefaultSelenium.
 *
 * @author Robert Zimmermann
 *
 * $Id: LoggingDefaultSelenium.java 111 2008-04-18 15:21:02Z ralf2511 $
 */
public class LoggingDefaultSelenium extends DefaultSelenium implements LoggingSelenium {

    /**
     * Default Constructor.
     *
     * @param commandProcessor this CommandProcessor will be used to handle the real remote-control communication
     */
    public LoggingDefaultSelenium(final CommandProcessor commandProcessor) {
        super(commandProcessor);
    }

    /**
     * {@inheritDoc}
     */
    public void logComment(final String comment) {
        commandProcessor.doCommand(SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_COMMENT.getName(), new String[] {comment});
    }

    /**
     * {@inheritDoc}
     */
    public void logAutomaticScreenshot(final String baseName) {
        commandProcessor.doCommand(SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_AUTO_SCREENSHOT.getName(),
                new String[] {baseName});
    }

    /**
     * {@inheritDoc}
     */
    public void logAssertion(final String assertionName, final String assertionMessage, final String assertionCondition) {
        commandProcessor.doCommand(SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_ASSERTION.getName(), new String[] {
                assertionName, assertionMessage, assertionCondition});
    }

    /**
     * {@inheritDoc}
     */
    public void logResource(final String file, final String description) {
        commandProcessor.doCommand(SeleniumCommandExtensions.COMMAND_EXTENSION_LOG_RESOURCE.getName(), new String[] {
            file, description});
    }
    
    /////////////////////////////Overriden Methods////////////////////////
    
	 public void click(String locator) {
		 if(waitForElementPresent(locator)) {
			 if (BaseTest.highlightingEnabled.equalsIgnoreCase("true")) highlight(locator);
			 commandProcessor.doCommand("click", new String[] {locator} );
		 }
		 else {
			 new BaseTest().assertTrue(locator + " not found", commandProcessor.getBoolean("isElementPresent", new String[] {locator} ), this);
		 }
		 
	 }
	 
	 public void type(String locator) {
		 if(waitForElementPresent(locator)) {
			 if (BaseTest.highlightingEnabled.equalsIgnoreCase("true")) highlight(locator);
			 commandProcessor.doCommand("type", new String[] {locator} );
		 }
		 else {
			 new BaseTest().assertTrue(locator + " not found", commandProcessor.getBoolean("isElementPresent", new String[] {locator} ), this);
		 }
		 
	 }
	 public void highlight(String locator) {
		 commandProcessor.doCommand("highlight", new String[] {locator} );
	 }
	 
	public boolean waitForElementPresent(String locator) {
			for (int second = 0;; second++) {
				if (second >= TestConsts.TIMEOUT)
					return false;
				try {
					Thread.sleep(1000);
					if (commandProcessor.getBoolean("isElementPresent", new String[] {locator} ))
						return true;
				} catch (Exception e) {	}
			}
		}
	
	public boolean isElementPresent(String locator) {
		
			try {
				if (commandProcessor.getBoolean("isElementPresent", new String[] {locator} ))
					return true;
			} catch (Exception e) {
				return false;
			}
			return false;
		
	}
	
	public boolean waitForTextPresent(String text) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				 
				if (commandProcessor.getBoolean("isTextPresent", new String[] {text} ))
					return true;
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean waitForTextNotPresent(String text) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				 
				if (!commandProcessor.getBoolean("isTextPresent", new String[] {text} ))
					return true;
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean waitForEitherTextPresent(String text1, String text2) {
		for (int second = 0;; second++) {
			if (second >= TestConsts.TIMEOUT)
				return false;
			try {
				 
				if (commandProcessor.getBoolean("isTextPresent", new String[] {text1}) || commandProcessor.getBoolean("isTextPresent", new String[] {text2}))
					return true;
			} catch (Exception e) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
