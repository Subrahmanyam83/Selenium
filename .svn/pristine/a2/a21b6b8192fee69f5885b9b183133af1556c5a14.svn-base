package com.tbb.framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class creates a custom listener having overridden two methods viz. onStart and onFinish that provide us functionality to do something before TestNG starts executing setup
 * methods and after TestNG has finished executing tearDown methods.
 * @author Xebia
 *
 */
public class MyListener implements ITestListener {

	/**
	 * This method runs after TestNG has executed tearDown methods applicable to a test suite.
	 * @param arg0
	 */
	public void onFinish(ITestContext arg0) {
		MailHelper.createResultsRarFile();
		MailHelper.sendMail();
		BaseTest.sleep(30000);
		
		
	}

	/**
	 * This method runs before TestNG starts executing setUp methods applicable to a test suite.
	 * @param arg0
	 */
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("All got started");
	}

	/**
	 * 
	 * @param arg0
	 */	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param arg0
	 */	
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param arg0
	 */	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param arg0
	 */	
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param arg0
	 */
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
