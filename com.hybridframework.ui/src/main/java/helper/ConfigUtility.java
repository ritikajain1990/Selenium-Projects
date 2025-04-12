package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
public static String readConfilFile(String propName) 
{
	 Properties prop= new Properties();
	try {
	File file = new File(System.getProperty("user.dir")+"/Configuration/config.properties");
	FileInputStream fis = new FileInputStream(file);

	prop.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("LOG:INFO Could not read the file"+e.getMessage());
	}
	String value=prop.getProperty(propName);
	return value;
	
}
}
