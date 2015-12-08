package com.tbb.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.tbb.framework.BaseTest;
import com.tbb.xml.TestActionType;
import com.tbb.xml.TestData;
import com.tbb.xml.TestStepType;

public class FileReader extends BaseTest {

	public List<TestStepType> testSteps = new ArrayList<TestStepType>();
	int stepNumber = 0;
	com.tbb.xml.TestStepType teststep;
	com.tbb.xml.TestActionType  testAction;
	int testActionNumber = 0;

	/*
	 * This function reads testdata.xml and unmarshalls that so that complete
	 * test data is available in java objects. This function/constructor will take test node
	 * as an argument and will find a particular test case matching this test
	 * node.
	 * How does it do that? After calculating number of test cases, it executes a loop and
	 * finds the exact test case. After finding the test case, it prints the
	 * different attributes of that test case like its ID, name, Description etc
	 */
	public FileReader(String testNodeName) {
	
		try {
			JAXBContext jc = JAXBContext.newInstance("com.tbb.xml");
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			TestData testData = (TestData) unmarshaller.unmarshal(new File(
					"src/test/java/resources/config/testdata.xml"));

			List<TestData.TestCases> testCases = testData.getTestCases();
			
			for (int i = 0; i < testCases.size(); i++) {
				com.tbb.xml.TestData.TestCases testCase = testCases
						.get(i);

				if (testCase.getTestID().trim().equalsIgnoreCase(testNodeName)) {
					logger.info("Test Data Node Name = "
							+ testCase.getTestID().trim());
					logger.info("Test Case N_ID = " + testCase.getNID());
					logger.info("Test Case Perspective = "
							+ testCase.getPerspective());
					logger.info("Test Case Description = "
							+ testCase.getDescription().trim());

					testSteps = testCase.getTestSteps();
					logger.info("Number of Test Steps = " + testSteps.size());
					System.out.println();

				} 					
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method initialize 'teststep' variable with First test step and then increases the stepNumber variable with 1. This method is mandatory to call before we can
	 * access test actions under a test step. 
	 */
	public void processNextTestStep() {
		// stepNumber is a static variable which is initially set to 0 and every call to this method will increment this variable by 1.
		teststep = testSteps.get(stepNumber);

		int step = stepNumber + 1;
		logger.info("*************  " + "Test Step " + step	+ "  *************");

		stepNumber++;

	}

	/**
	 * This method returns all labels, given a single test action.
	 * @return
	 */
	public List<String> getMultipleLabelsFromSingleTestAction() {
		List<String> mLabels = new ArrayList<String>();
		try {

			List<TestActionType> testActions = teststep.getTestActions();
			testAction = testActions.get(testActionNumber);
			mLabels = testAction.getLabel();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mLabels;

	}

	/**
	 * This method returns all values, given there is a single test action.
	 * @return
	 */
	public List<String> getMultipleValuesFromSingleTestAction() {
		List<String> mValues = new ArrayList<String>();
		try {

			List<TestActionType> testActions = teststep.getTestActions();
				testAction = testActions.get(testActionNumber);
				mValues = testAction.getValue();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mValues;

	}
	
	
	/**
	 * This returns an array of ArrayList instances that have data for multiple test actions. This is to be used when there is one Label and multiple values in a test action but 
	 * there are multiple test actions.
	 * @return
	 */
	public ArrayList[] getLabelAndMultipleValuesFromMultipleTestActions() {
		List<String> data = new ArrayList<String>();
		ArrayList<String>[] labelValues = null;
		try {
			List<TestActionType> testActions = teststep.getTestActions();
				
			labelValues = new ArrayList[testActions.size()];
			for (int g = 0; g < testActions.size(); g++) {
				testAction = testActions.get(g);
				data = testAction.getLabel();
				data.addAll(testAction.getValue());
				labelValues[g] = (ArrayList<String>) data;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return labelValues;
	}
	
	/**
	 * Returns HashMap of Label and Values in form of pairs of key and value. This is to be used when there are equal number of labels and values in a test action.
	 * @return
	 */
	public HashMap<String, String> getMultipleLabelsMultipleValuesFromSingleTestAction() {
	List<String> mLabels = getMultipleLabelsFromSingleTestAction();
	List<String> mValues = getMultipleValuesFromSingleTestAction();
	HashMap<String, String> testData = new HashMap<String, String>();
	if (mLabels.size() == mValues.size()) {
		for (int i = 0; i < mLabels.size(); i++) {
			testData.put(mLabels.get(i), mValues.get(i));
						
		}
	}
	return testData;
}
	
	
	/**
	 * Returns Object[][] of Values in pair. of Username/password pairs.
	 * @return
	 */
	public Object[][] getMultipleValuesInPairFromSingleTestAction() {
	List<String> mLabels = getMultipleLabelsFromSingleTestAction();
	List<String> mValues = getMultipleValuesFromSingleTestAction();
	Object[][] testData = new Object[mValues.size()/2][mValues.size()/2];
	
	logger.info("Size of mLabels = " + mLabels.size());
	logger.info("Size of mValues = " + mValues.size());
	int valueCount = 0;
		for (int i = 0; i < mValues.size()/2 ; i++) {
			for (int j = 0; j < mValues.size()/2; j++) {
				testData[i][j] = mValues.get(valueCount++);
				}
									
		}
	return testData;
}
	
	
	/**
	 * This returns an array of HashMap instances that have data for multiple test actions. This is to be used when there is one Label and multiple values in a test action but 
	 * there are multiple test actions.
	 * @return
	 */
	public HashMap[] getMultipleLabelsAndMultipleValuesFromMultipleTestActions() {
		HashMap<String, String>[] labelsValues = null;
		try {
			List<TestActionType> testActions = teststep.getTestActions();
						
			labelsValues = new HashMap[testActions.size()];
			for (int g = 0; g < testActions.size(); g++) {
				HashMap<String, String> testData = new HashMap<String, String>();
				com.tbb.xml.TestActionType testAction = testActions.get(g);
			/*	List<String> mLabels = getMultipleLabelsFromSingleTestAction();
				List<String> mValues = getMultipleValuesFromSingleTestAction();*/
				List<String> mLabels = testAction.getLabel();
				List<String> mValues = testAction.getValue();
				if (mLabels.size() == mValues.size()) {
					for (int i = 0; i < mLabels.size(); i++) {
						testData.put(mLabels.get(i), mValues.get(i));
						
					}
				}
				
				labelsValues[g] = testData;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return labelsValues;
	}
	
	public Object[][] getVerticalValues() {
		Object[][] testData;
		//List<String> mValues = getValues();
		List<String> mValues = new ArrayList<String>();
		try {

			List<TestActionType> testActions = teststep.getTestActions();
			// int action = 0;
			for (int g = 0; g < testActions.size(); g++) {

				// action = g + 1;
				com.tbb.xml.TestActionType testAction = testActions
						.get(g);
				//mValues.add(testAction.getValue().trim());
				mValues = testAction.getValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<String> iterator = mValues.iterator();
		testData = new Object[mValues.size()][1];
		System.out.println("Size of mValues" + mValues.size());
		int i=0;
		while (iterator.hasNext()) { 
			//System.out.println(iterator.next().toString());
			testData[i][0] = iterator.next();
			i++;
		}  
		return testData;
	}
	
	public Object[][] getHorizontalValues() {
		Object[][] testData ;
		//List<String> mValues = getValues();
		List<String> mValues = new ArrayList<String>();
		Iterator<String> iterator;
		com.tbb.xml.TestActionType testAction;
		

			List<TestActionType> testActions = teststep.getTestActions();
			// int action = 0;
			int rowCount = testActions.size();
			int colCount = testActions.get(0).getValue().size();
			testData = new Object[rowCount][colCount];
			try {
			for (int g = 0; g < testActions.size(); g++) {

				// action = g + 1;
				testAction = testActions.get(g);
				//mValues.add(testAction.getValue().trim());
				mValues = testAction.getValue();
				iterator = mValues.iterator();
				int i=0;
				while (iterator.hasNext()) { 
					//System.out.println(iterator.next().toString());
					testData[g][i] = iterator.next();
					i++;
				}  
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return testData;
	}


	
	public Object[][] returnSet(HashMap map) {
		Iterator iterator = map.keySet().iterator();  
		
		
		int rowCount = map.size();
		int columnCount = 1; //this should be equal to number of test actions in a test step. 
		Object[][] objArray = new Object[rowCount][columnCount];

		//Code to print the values stored in 2D array 
		int i,j;
		for(i=0;i<rowCount;i++){
			for(j=0;j<columnCount;j++){
				//objArray[i][j]=rsArray.getElement(i,j);
				objArray[i][j]= map.get(iterator.next().toString()).toString();  
				//System.out.println("Value at row " + i + " and column " + j + " is " + objArray[i][j]);
			}
		}
		
		return(objArray);
/*		while (iterator.hasNext()) {  
		   String key = iterator.next().toString();  
		   String value = map.get(key).toString();  
		   
		   System.out.println(key + " " + value);  
		}  
*/	}



}
