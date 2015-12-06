package com.tbb.testscripts.general;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Gaurav {
public static void main (String args[]) throws IOException {
	
		File src1 = null, src2 = null, dest= null, srcFile1 = null,  srcFile2 = null,  srcFile3 = null,  srcFile4 = null;
	
		// Test Script
		dest =  new File("Archive\\timestamp1");
		src1 = new File("test-output\\results");
		src2 = new File("test-output\\Default suite");
		srcFile1  = new File("test-output\\index.html");
		srcFile2  = new File("test-output\\testng.css");
		srcFile3  = new File("test-output\\testng-failed.xml");
		srcFile4  = new File("test-output\\testng-results.xml");
		

		// Maven
		// src = new File("target\\surefire-reports\\html");
		// dest =  new File("Archive\\timestamp");
		

		
		
		
		FileUtils.copyDirectoryToDirectory(src1, dest);
		FileUtils.copyDirectoryToDirectory(src2, dest);
		FileUtils.copyFileToDirectory(srcFile1, dest);
		FileUtils.copyFileToDirectory(srcFile2, dest);
		FileUtils.copyFileToDirectory(srcFile3, dest);
		FileUtils.copyFileToDirectory(srcFile4, dest);
		FileUtils.forceDelete(src1);

}
}
