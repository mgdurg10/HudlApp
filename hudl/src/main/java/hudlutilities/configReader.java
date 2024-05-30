package hudlutilities;

import java.io.FileReader;
import java.util.Properties;
import java.io.File;
public class configReader {
public static String readprojectconfiguration(String keyName)
{
	String value=null;
	
	try {
		FileReader file=new FileReader(new File("D:\\Automationhudl\\hudl\\configFiles\\project.properties"));
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(keyName).trim();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//throws(new RuntimeException("***Error:- key with name"+ keyName +" "does not exist"));
	}
	return value;
	
}
public static String readElementLocators(String keyName)
{
	String value=null;
	
	try {
		FileReader file=new FileReader(new File("D:\\Automationhudl\\hudl\\configFiles\\locators.properties"));
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(keyName).trim();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//throws(new RuntimeException("***Error:- key with name"+ keyName +" "does not exist"));
	}
	return value;
	
}
}
