package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	static WebDriver driver;
	public static WebDriver startBrowser(String browser, String applicationURL) {
		System.out.println("LOG:INFO Running Test On "+browser);

		if (browser.equalsIgnoreCase("Chrome") || browser.contains("Google Chrome") || browser.contains("GC")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox") || browser.equalsIgnoreCase("Mozila")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("LOG:INFO Sorry Currently " + browser + " is not supported -- Starting Chrome Default");
			driver = new ChromeDriver();
		}

		driver.get(applicationURL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("LOG:INFO Session is ready Test will be running on " + browser + " ***********");

		return driver;

	}
public static WebDriver getDriver()
{
	return driver;
}
	public static WebDriver startBrowser(String browser, String applicationURL, boolean headless) {
		System.out.println("*********** Running Test On " + browser + " ***********");

		WebDriver driver;

		if (browser.equalsIgnoreCase("Chrome") || browser.contains("Google Chrome") || browser.contains("GC")) {
			ChromeOptions opt = new ChromeOptions();

			if (headless) {
				System.out.println("*********** Test will be running in headless mode ***********");

				opt.addArguments("--headless=new");
			}

			driver = new ChromeDriver(opt);
		} else if (browser.equalsIgnoreCase("Firefox") || browser.equalsIgnoreCase("Mozila")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Sorry Currently " + browser + " is not supported -- Starting Chrome Default");
			driver = new ChromeDriver();
		}

		driver.get(applicationURL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("*********** Session is ready Test will be running on " + browser + " ***********");

		return driver;

	}
}
