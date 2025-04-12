package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.chaintest.plugins.ChainTestListener;

import helper.Utility;

public class DashboardPage {
	WebDriver driver;
By welcomeMsg= By.xpath("//h4[@class='welcomeMessage']");
By menu=By.xpath("//img[@alt='menu']");
By signOut =By.xpath("//button[text()='Sign out']");
public DashboardPage(WebDriver driver)
{
	this.driver=driver;
}
public String getwelcomeMessage()
{
	ChainTestListener.log("LOG:INFO Actual Value of Welcome message is :"+Utility.checkElement(driver, welcomeMsg).getText() );
	return Utility.checkElement(driver, welcomeMsg).getText();
	
}
public void logoutFromApplication()
{
	Utility.clickElement(driver, menu);
	Utility.clickElement(driver, signOut);
	System.out.println("LOG:INFO -Logging out the Dashboard Page");
	ChainTestListener.log("LOG:INFO -Logging out the Dashboard Page");
	
}
}
