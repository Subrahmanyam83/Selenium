package com.tbb.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class AFUtils {
	
	public Object[][] xmlDataConnector(String testNodeName) {
		
		FileReader fr = new FileReader(testNodeName);
		fr.processNextTestStep();
		Object[][] testData = fr.getVerticalValues();
		return testData;
	}
	
	public String[][] xlsDataConnector(String xlFilePath, String sheetName, String tableName) throws Exception{
		String[][] tabArray=null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName); 
		int startRow,startCol, endRow, endCol,ci,cj;
		Cell tableStart=sheet.findCell(tableName);
		startRow=tableStart.getRow();
		startCol=tableStart.getColumn();

		Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

		endRow=tableEnd.getRow();
		endCol=tableEnd.getColumn();
		System.out.println("startRow="+startRow+", endRow="+endRow+", " +
				"startCol="+startCol+", endCol="+endCol);
		tabArray=new String[endRow-startRow-1][endCol-startCol-1];
		ci=0;

		for (int i=startRow+1;i<endRow;i++,ci++){
			cj=0;
			for (int j=startCol+1;j<endCol;j++,cj++){
				tabArray[ci][cj]=sheet.getCell(j,i).getContents();
			}
		}
		return(tabArray);
	}
	
	public String[][] txtDataConnector(String textFilePath) throws Exception {
	
				String[][] tabArray=null;
				String line = null;
				int columnCount=0;
				BufferedReader in = null;
				InputStreamReader inputStream = null;
				try{    
					inputStream = new InputStreamReader(new FileInputStream(textFilePath));
					in = new BufferedReader(inputStream);
					//Code to count the number of rows in a text file
					int rowCount = 0;
					
					while((line = in.readLine()) != null) {
						rowCount++;
						String[] columns = line.split("\\|");
						columnCount= columnCount < columns.length ? columns.length : columnCount;
					}
					
						
					//Read and store content in an array
					inputStream = new InputStreamReader(new FileInputStream(textFilePath));
					in = new BufferedReader(inputStream);

					tabArray=new String[rowCount][columnCount];

					int ci=0,cj=0;
					/*
					#
					  IMPORTANT : Some special characters need to be escaped while providing them as
					#
					  delimiters like "." and "|".
					#
					 */
					while((line = in.readLine()) != null){
						String delimiter = "\\|";
						String[] data = line.split(delimiter);
						/*for(String i:data){
							System.out.println(i);
						}*/
						for(int j=0; j<data.length;j++){
							tabArray[ci][cj]=data[j];
							cj++;
						}
						ci++;
						cj=0;
					}			
				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					try{
						if(in != null)
							in.close();

						if(inputStream != null)
							inputStream.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
				return tabArray;
			}
		


	
/*	public Object[][] sqlDataConnector(String SqlQuery) {
				Connection conn = null;
			Object [][]objArray = null;
			try
			{
				String userName = "root";
				String password = "xebia123";
				String url = "jdbc:mysql://localhost/mydb";
				Class.forName ("com.mysql.jdbc.Driver").newInstance ();
				conn = DriverManager.getConnection (url, userName, password);
				System.out.println ("Database connection established");

				//Issuing queries to database

				Statement s = conn.createStatement ();
				s.executeQuery (SqlQuery);
				ResultSet rs = s.getResultSet ();

				ResultSetSimplifier rsArray=new ResultSetSimplifier(rs);

				System.out.println("Rows: " +rsArray.getRowCount());
				System.out.println("Columns: " +rsArray.getColCount());

				int rowCount = rsArray.getRowCount();
				int columnCount = rsArray.getColCount();
				objArray = new Object[rowCount][columnCount];

				//Code to print the values stored in 2D array 
				int i,j;
				for(i=0;i<rowCount;i++){
					for(j=0;j<columnCount;j++){
						objArray[i][j]=rsArray.getElement(i,j);
						//System.out.println("Value at row " + i + " and column " + j + " is " + objArray[i][j]);
					}
				}
				rs.close ();
				s.close ();
			}
			catch (Exception e)
			{
				System.err.println ("Cannot connect to database server");
				e.printStackTrace();
			}
			finally
			{
				if (conn != null)
				{
					try
					{
						conn.close ();
						System.out.println ("Database connection terminated");
					}
					catch (Exception e) {   ignore close errors    }

				}
			}
			return objArray;
		}*/

	
	
	public static ArrayList[] getData(String testNode) {
		FileReader fr = new FileReader(testNode);
		fr.processNextTestStep();
		ArrayList[] dataSet = fr.getLabelAndMultipleValuesFromMultipleTestActions();
		return dataSet;
	}

	/**
	 * This method converts an arraylist into an array and removes label from it so that it contains
	 * only values.
	 * @param alData
	 * @return 
	 */
	public static String[] getValuesOnly(ArrayList<String> alData) {
		String[] labelValues = alData.toArray(new String[alData.size()]);
		String[] onlyValues = new String[labelValues.length - 1];
		for(int i=0; i<onlyValues.length; i++) {
			onlyValues[i] = labelValues[i+1];
		}
		return onlyValues;
	}

	}