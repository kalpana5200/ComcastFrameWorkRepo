package com.comcast.crm.listenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer {
int c=0;
int limitcount=5;
	@Override
	public boolean retry(ITestResult result) {
		if(c<limitcount) {
			c++;
			return true;
			
		}
		return false;
	}

}
