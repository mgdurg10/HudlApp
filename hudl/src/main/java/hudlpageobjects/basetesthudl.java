package hudlpageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hudlutilities.configReader;

public class basetesthudl {
	 static WebDriver driver;
	
	public basetesthudl(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	public static WebDriver startDriverInstance()
	{
		//System.out.print(configReader.readprojectconfiguration("browserName"));
		if(configReader.readprojectconfiguration("browserName").equalsIgnoreCase("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\Monika Durgude\\Downloads\\SeleniumFrameworkDesign\\SeleniumFrameworkDesign\\chromedriver.exe");
			options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
			options.setExperimentalOption("excludeSwitches", "disable-notifications");
			driver = new ChromeDriver();
		}
		else if(configReader.readprojectconfiguration("browserName").equalsIgnoreCase("firefox"))
		{
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\Monika Durgude\\Downloads\\SeleniumFrameworkDesign\\SeleniumFrameworkDesign\\geckodriver.exe");
			//driver = new GeckoDriver();
		}
		driver.get(configReader.readprojectconfiguration("ApplicationURL"));
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		return driver;
	}
	//Returning driver instance 
	public WebDriver getDriverInstance()
	{
		if(driver!=null)
		{
			return driver;
		}
		else
		{
			basetesthudl.startDriverInstance();
			return driver;
		}
	}

	// setting driver instance to null
	public static void setDriverinstancetonull()
	{
		driver=null;
	}
	public void closedriver(WebDriver driver)
	{
		driver.quit();	
	}
	public static void initializedriver() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		//WebDriverManager.chromedriver().setup();
		//options.setExperimentalOption("excludeswitches", Arrays.asList("--disable-popup-blocking","enable-automation","--disable-notifications"));
		options.setBinary("C:\\Users\\Monika Durgude\\Downloads\\SeleniumFrameworkDesign\\SeleniumFrameworkDesign\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://fan.hudl.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
}