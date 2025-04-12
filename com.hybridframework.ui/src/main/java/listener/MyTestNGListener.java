package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

import factory.BrowserFactory;
import helper.ConfigUtility;
import helper.Utility;


public class MyTestNGListener implements ITestListener {
	public void onTestSuccess(ITestResult result) {
		ChainTestListener.log("LOG:PASS -Test Passed "+result.getMethod().getMethodName());
		if(ConfigUtility.readConfilFile("screenshotOnPass").equalsIgnoreCase("true"))
		{

			  String screenshot = Utility.captureScreenShort(BrowserFactory.getDriver());
			ChainTestListener.embed(screenshot, "img/png");
		}
	  }

	  
	  public void onTestFailure(ITestResult result) {
		  ChainTestListener.log("LOG:FAIL -Test Failed "+result.getMethod().getMethodName()+" "+ result.getThrowable().getMessage());
		  if(ConfigUtility.readConfilFile("screenshotOnFailure").equalsIgnoreCase("true"))
			{

				  String screenshot = Utility.captureScreenShort(BrowserFactory.getDriver());
				ChainTestListener.embed(screenshot, "img/png");
			}
		  }

	  

	 
	  public  void onTestSkipped(ITestResult result) {
		  ChainTestListener.log("LOG:SKIP -Test Skip "+result.getMethod().getMethodName());
		  if(ConfigUtility.readConfilFile("screenshotOnSkip").equalsIgnoreCase("true"))
			{

				  String screenshot = Utility.captureScreenShort(BrowserFactory.getDriver());
				ChainTestListener.embed(screenshot, "img/png");
			}
		  }
	  

}
