package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.chaintest.plugins.ChainTestListener;

import helper.Utility;

public class LoginPage {
WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
}
By username = By.xpath("//input[@id='email1']");
By password = By.xpath("//input[@id='password1']");
By signIn=By.xpath("//button[text()='Sign in']");
public DashboardPage loginToApplication(String usernameValue , String passwordValue)
{
	Utility.typeOnElement(driver, username, usernameValue);
	Utility.typeOnElement(driver, password, passwordValue);
	Utility.clickElement(driver, signIn);
	ChainTestListener.log("LOG:INFO -Sign in is completed");
	System.out.println("LOG:INFO -Sign in is completed");
	DashboardPage dashboard = new DashboardPage(driver);
	return dashboard;
}
public Boolean signInDisplayed()
{

	return Utility.checkElement(driver, signIn).isDisplayed();
}

}
