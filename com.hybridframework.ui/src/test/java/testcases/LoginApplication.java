package testcases;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.chaintest.plugins.ChainTestListener;
import base.BaseClass;
import dataprovider.DataProviders;
import helper.ExcelUtility;
import pages.DashboardPage;
import pages.LoginPage;	
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class LoginApplication extends BaseClass{
	LoginPage loginPage ;
	DashboardPage dashboardPage;
	@Test(priority=1,dataProvider = "loginDetails",dataProviderClass = DataProviders.class)
	public void loginWithValidCredentials(String username , String password)
	{
		loginPage = new LoginPage(driver);
		dashboardPage=loginPage.loginToApplication(username,password);
		Assert.assertTrue(dashboardPage.getwelcomeMessage().contains("Wel1come"),"Login Failed");

	}
	
	@Test(dependsOnMethods = "loginWithValidCredentials",priority=2)
	public void logoutFromApplication()
	{
		dashboardPage.logoutFromApplication();
		Assert.assertTrue(loginPage.signInDisplayed(),"Logout Failed");
		ChainTestListener.log("LOG:INFO -Sign in is displayed");

	}


}
