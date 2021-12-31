package com.Analizer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.TestBase.TestBase;

public class ReTryAnalyzer extends TestBase implements IRetryAnalyzer {

	int counter = 0;
	int retryLimit = 1;
	
	@Override
	public boolean retry(ITestResult result) {
	
		if(counter<retryLimit) {
			counter++; 
			return true;
		}
		
		return false;
	}
	
	

	
}
