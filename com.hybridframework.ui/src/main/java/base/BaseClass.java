package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.chaintest.plugins.ChainTestListener;

import factory.BrowserFactory;
import helper.ConfigUtility;

public class BaseClass {
	public WebDriver driver;
@BeforeClass
public void setup() 
{
	System.out.println("LOG:INFO -Setting up the browser");
	ChainTestListener.log("LOG:INFO -Setting up the browser");
	driver =BrowserFactory.startBrowser("Chrome", ConfigUtility.readConfilFile("QAURL"));

}
@AfterClass
public void tearDown()
{
	System.out.println("LOG:INFO -Closing the browser");
	ChainTestListener.log("LOG:INFO -Closing the browser");
	driver.quit();
}
}
