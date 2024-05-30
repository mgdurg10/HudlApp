package hudl;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Caching;

import hudlpageobjects.hudlloginobjects;
import hudlutilities.WebDriverManager;
import hudlutilities.configReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CucumberTest {
    private MutablePicoContainer picoContainer;

    @Before
    public void setUp() {
        picoContainer = new DefaultPicoContainer(new Caching());
        picoContainer.addComponent(WebDriverManager.class);
    }

    @After
    public void tearDown() {
        WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
        webDriverManager.quitDriver();
    }

    @Given("user hits url")
    public void aSampleStep() throws InterruptedException {
        WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
        WebDriver driver = webDriverManager.getDriver();
        
      driver.get("https://fan.hudl.com/");
  	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Then("user enters credentials")
    public void anotherSampleStep() throws InterruptedException {
        WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
        WebDriver driver = webDriverManager.getDriver();
        hudlloginobjects hudlloginsobj=new hudlloginobjects(driver);
		Thread.sleep(3000);
		hudlloginsobj.clickonLoginbutton();
		hudlloginsobj.clickOnGoogleButton();
		hudlloginsobj.enterUserName(configReader.readprojectconfiguration("UserName"));
		hudlloginsobj.clickonNextbutton();
		Thread.sleep(4000);
		hudlloginsobj.enterpassword(configReader.readprojectconfiguration("Password"));
	    hudlloginsobj.clickonNextbutton();
		Thread.sleep(3000);
	    

    }
    @Then("validate loggedinName")
    public void validate_loggedin_name() throws InterruptedException {
    	  WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
          WebDriver driver = webDriverManager.getDriver(); 
          hudlloginobjects hudlloginsobj=new hudlloginobjects(driver);
  		Thread.sleep(3000);
  		hudlloginsobj.verifLoggedinName("Monika");
    }
    
    @Given("user hits url again")
    public void user_hits_url_again() throws InterruptedException {
    	 WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
         WebDriver driver = webDriverManager.getDriver();

       driver.get("https://fan.hudl.com/");
   	driver.manage().window().maximize();
 	Thread.sleep(2000);
 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         hudlloginobjects hudlloginsobj=new hudlloginobjects(driver);
         Thread.sleep(3000);
 		hudlloginsobj.clickonLoginbutton();
 		hudlloginsobj.clickOnGoogleButton();
    }

    @Then("user enters invalid username")
    public void user_enters_invalid_credentials() throws InterruptedException {
    	 WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
         WebDriver driver = webDriverManager.getDriver();
         hudlloginobjects hudlloginsobj=new hudlloginobjects(driver);
    	 hudlloginsobj.enterUserName("durggirdj");
 		 hudlloginsobj.clickonNextbutton();
 		 
    }
    

    @Then("validate error")
    public void validate_error() throws InterruptedException {
    	WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
        WebDriver driver = webDriverManager.getDriver();
        hudlloginobjects hudlloginsobj=new hudlloginobjects(driver); 
        Thread.sleep(2000);
        hudlloginsobj.verifyError();
    }

    @Given("user hits url again for password")
    public void user_hits_url_again_for_password() throws InterruptedException {
    	 
    	    	 WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
    	         WebDriver driver = webDriverManager.getDriver();

    	       driver.get("https://fan.hudl.com/");
    	   	driver.manage().window().maximize();
    	 	Thread.sleep(2000);
    	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	         hudlloginobjects hudlloginsobj=new hudlloginobjects(driver);
    	         Thread.sleep(3000);
    	 		hudlloginsobj.clickonLoginbutton();
    	 		hudlloginsobj.clickOnGoogleButton();
    }

    @Then("user enters invalid password")
    public void user_enters_invalid_password() throws InterruptedException {
    	 WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
         WebDriver driver = webDriverManager.getDriver();
         hudlloginobjects hudlloginsobj=new hudlloginobjects(driver);
    	 hudlloginsobj.enterUserName("durgmonika");
 		 hudlloginsobj.clickonNextbutton();
 		 hudlloginsobj.enterpassword("durggirdj");
 		hudlloginsobj.clickonNextbutton(); 
 		Thread.sleep(2000);
    }

    @Then("validate error for password")
    public void validate_error_for_password() throws InterruptedException {
    	WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
        WebDriver driver = webDriverManager.getDriver();
        hudlloginobjects hudlloginsobj=new hudlloginobjects(driver); 
        Thread.sleep(2000);
        hudlloginsobj.verifypasswordError();
    
    }



}