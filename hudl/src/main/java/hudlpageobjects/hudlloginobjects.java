package hudlpageobjects;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hudlutilities.configReader;

public class hudlloginobjects {
	configReader conred=new configReader() ;
	WebDriver driver;

	public hudlloginobjects(WebDriver driver)
	{
		this.driver=driver;	
		//element=ResourceBundle.getBundle("Elements");

	}
	public void clickonLoginbutton()
	{
		driver.findElement(By.xpath(conred.readElementLocators("logIn"))).click();
	}
	public void clickOnGoogleButton()
	{
		driver.findElement(By.xpath(conred.readElementLocators("googlebutton"))).click();
	}
	public void enterUserName(String username)
	{
		driver.findElement(By.xpath(conred.readElementLocators("username"))).sendKeys(username);
	}
	public void enterpassword(String password)
	{
		driver.findElement(By.xpath(conred.readElementLocators("password"))).sendKeys(password);
	}
	public void clickonNextbutton()
	{
		driver.findElement(By.xpath(conred.readElementLocators("nextbutton"))).click();
	}
	public void verifLoggedinName(String Name)
	{
		String loggedinName=driver.findElement(By.xpath(conred.readElementLocators("LoggedinName"))).getText();
		Assert.assertEquals("Monika",loggedinName);
	}
	public void verifyError()
	{
		String loggedinName=driver.findElement(By.xpath(conred.readElementLocators("Errorusername"))).getText();
		
	}
	public void verifypasswordError()
	{
		String loggedinName=driver.findElement(By.xpath(conred.readElementLocators("errorpassword"))).getText();
		
	}
	public void waitforelementtoappear() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	//public static void loginhudl() throws InterruptedException
	//{
//
		
//		//driver.findElement(By.xpath(configReader.readElementLocators("logIn"))).click();
//		driver.findElement(By.xpath("logIn=//button[text()='Log In']")).click();
//		driver.findElement(By.xpath(configReader.readElementLocators("googlebutton"))).click();
//		driver.findElement(By.xpath(configReader.readElementLocators("username"))).sendKeys(configReader.readprojectconfiguration("UserName"));
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(configReader.readElementLocators("nextbutton"))).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(configReader.readElementLocators("password"))).sendKeys(configReader.readprojectconfiguration("Password"));
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(configReader.readElementLocators("nextbutton"))).click();
//		Thread.sleep(4000);
//		String loggedinName=driver.findElement(By.xpath(configReader.readElementLocators("LoggedinName"))).getText();
//		Assert.assertEquals("Monika",loggedinName);
	//}
}


