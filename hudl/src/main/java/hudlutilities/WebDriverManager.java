package hudlutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
	    private WebDriver driver;

	    public WebDriver getDriver() {
	        if (driver == null) {
	    ChromeOptions options= new ChromeOptions();
	    options.setBinary("C:\\Users\\Monika Durgude\\Downloads\\SeleniumFrameworkDesign\\SeleniumFrameworkDesign\\chromedriver.exe");
	            driver = new ChromeDriver();
	            
	        }
	        return driver;
	    }

	    public void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	}

