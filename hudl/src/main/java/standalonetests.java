import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class standalonetests {
	static WebDriver driver;
	public static void main(String [] args) throws InterruptedException
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
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btn-google-login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("durgmonika");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("CG@monika");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		String loggedinName=driver.findElement(By.xpath("//span[contains(text(),'Monika')]")).getText();
		Assert.assertEquals("Monika", loggedinName);
		driver.close();
		}
}
