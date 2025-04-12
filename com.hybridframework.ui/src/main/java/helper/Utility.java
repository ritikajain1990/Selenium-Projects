package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.chaintest.plugins.ChainTestListener;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Utility {

	/*
	 * 
	 * select values from Dropdown alert frames window waits screenshot custom
	 * dropdown
	 * 
	 */

	public static void highLightElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		waitForSeconds(1);

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	
	public static void typeWithJS(WebDriver driver,By locator,String textToType)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].value=arguments[1]",checkElement(driver,locator),textToType);
	}
	public static void typeOnElement (WebDriver driver,By locator,String textToType)
	{
		Utility.checkElement(driver, locator).sendKeys(textToType);
	}
	public static WebElement checkElement(WebDriver driver,By locator)
	{
		WebElement element =null;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		try {
			
			element =driver.findElement(locator);
			if(ConfigUtility.readConfilFile("highlight").equalsIgnoreCase("yes"))
			{
			highLightElement(driver, element);
			}
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {

			System.out.println("LOG:INFO Element not found");
			ChainTestListener.log("LOG:INFO Element not found");

		}
		return element;
	}

	public static void clickElement(WebDriver driver, By locator) {

		try {
			checkElement(driver,locator).click();

		} catch (Exception e) {

			System.out.println("WebElement Click Failed - Trying With JS Click");

			clickUsingJS(driver, locator);

		}
	}

	public static void clickUsingJS(WebDriver driver, By locator) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", checkElement(driver,locator));

	}

	public static void selectValueFromDropdown(WebElement element, String valueToSelect) {

		Select dropdown = new Select(element);

		dropdown.selectByVisibleText(valueToSelect);

		System.out.println("*********** Selected " + valueToSelect + " From Dropdown");
		ChainTestListener.log("LOG:INFO Selected " + valueToSelect + " From Dropdown\"");

	}

	public static void closeBrowser(WebDriver driver) {
		System.out.println("*********** Closing the browser ***********");
		ChainTestListener.log("LOG:INFO Closing the browser *");

		if (driver != null) {
			driver.quit();
		}

		System.out.println("*********** Application Closed ***********");
		ChainTestListener.log("LOG:INFO Application Closed ");

	}

	public static void waitForSeconds(int seconds) {
		try {
			System.out.println("LOG:INFO Waiting for " + seconds + " Second");
			ChainTestListener.log("LOG:INFO Waiting for " + seconds + " Second");

			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {

		}
	}

	public static WebDriver startBrowser() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://freelance-learn-automation.vercel.app/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}
	public static String takeScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		DateFormat date = new SimpleDateFormat("MMddyyyy");
		Date d = new Date();
		String date1 = date.format(d);
		System.out.println(date1);
		File f = new File("./Screenshots/File"+date1+System.currentTimeMillis()+".png");
		FileHandler.copy(src,f);
		return f.getAbsolutePath();
		
	}
	public static String captureScreenShort(WebDriver driver) 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String screenshot= ts.getScreenshotAs(OutputType.BASE64);
		System.out.println(screenshot);
		return screenshot;
		
		
	}

}
