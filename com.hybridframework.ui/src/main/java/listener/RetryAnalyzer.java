package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import helper.ConfigUtility;

public class RetryAnalyzer implements IRetryAnalyzer {
	 private int retryCount=0;
	 private int maxRetryCount= Integer.parseInt(ConfigUtility.readConfilFile("retry"));
	
    
	public boolean retry(ITestResult result) {
	if(retryCount<maxRetryCount)
	{
		retryCount++;
		return true;
	}
	return false;
	}

	
}
