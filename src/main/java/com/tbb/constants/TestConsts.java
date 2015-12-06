package com.tbb.constants;

/**
 * This file will have test level constants like different types of timeouts 
 * (Page Timeout, Element Timeout etc) and other parameters which might not be needed 
 * to change from one setup to another. Items/Parameters that might need to change very frequently
 * will go into .properties file.
 * @author Xebia
 *
 */
public interface TestConsts {
	final int TIMEOUT = 60;
	final String CONFIG_FILE = "selenium";
	final String IE_SIGN_IN = "Sikuli-IDE.exe -r C:\\workspace\\webautomation1\\sikuli-scipts\\IE_Security.sikuli";
	final String SAFARI_SIGN_IN = "Sikuli-IDE.exe -r C:\\workspace\\webautomation1\\sikuli-scipts\\Safari_Security.sikuli";
	final String PAGE_LOAD_TIMEOUT = "180000";
}