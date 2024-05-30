//package StepDefinations;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.picocontainer.DefaultPicoContainer;
//import org.picocontainer.MutablePicoContainer;
//import org.picocontainer.behaviors.Caching;
//
//import hudlpageobjects.hudlloginobjects;
//import hudlutilities.SharedState;
//import hudlutilities.WebDriverManager;
//import hudlutilities.configReader;
//import hudlpageobjects.basetesthudl;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class hudlstepdef {
//
//	hudlloginobjects hudlloginsobj;
//	public basetesthudl basetesthudl; 
//
//
//	  private MutablePicoContainer picoContainer;
//
//	    @Before
//	    public void setUp() {
//	        picoContainer = new DefaultPicoContainer(new Caching());
//	        picoContainer.addComponent(WebDriverManager.class);
//	    }
//
//	    @After
//	    public void tearDown() {
//	        WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
//	        webDriverManager.quitDriver();
//	    }
//		@Given("User hits hudl url")
//		public void user_hits_hudl_url() throws InterruptedException {
//		    WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
//	        WebDriver driver = webDriverManager.getDriver();
//	        
//			basetesthudl instance=new basetesthudl(driver);
//			driver=instance.startDriverInstance();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//
//		}
//
//		@When("user selects valid credentials")
//		public void user_selects_valid_credentials() throws InterruptedException {
//			WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
//	        WebDriver driver = webDriverManager.getDriver();
//			hudlloginobjects hudlloginsobj=new hudlloginobjects(driver);
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
//			hudlloginsobj.clickonLoginbutton();
//			
//			hudlloginsobj.clickOnGoogleButton();
//			hudlloginsobj.enterUserName(configReader.readprojectconfiguration("UserName"));
//			hudlloginsobj.clickonNextbutton();
//			hudlloginsobj.enterpassword(configReader.readprojectconfiguration("Password"));
//			hudlloginsobj.clickonNextbutton();
//
//
//		}
//
//		@Then("user should be logged in to hudl application")
//		public void user_should_be_logged_in_to_hudl_application() throws InterruptedException {
//			WebDriverManager webDriverManager = picoContainer.getComponent(WebDriverManager.class);
//	        WebDriver driver = webDriverManager.getDriver();
//			hudlloginobjects hudlloginsobj1=new hudlloginobjects(driver);
//			hudlloginsobj1.waitforelementtoappear();
//			hudlloginsobj1.verifLoggedinName("Monika");
//			driver.close();
//		}
//	}
