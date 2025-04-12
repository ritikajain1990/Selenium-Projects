package dataprovider;

import org.testng.annotations.DataProvider;

import helper.ExcelUtility;

public class DataProviders {
	@DataProvider(name="loginDetails")
	public static Object[][] getData()
	{
		return ExcelUtility.getData("LoginDetails");


	}
}
