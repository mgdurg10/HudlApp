package hudl.RunnerFiles;

import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\features",
monochrome=true,
dryRun=true,
glue="StepDefinations",
plugin= {"html:target/cucumber-report/",
		"json:target/cucumber-json",
		"pretty:target/cucumber-pretty.txt",
	
})
public class TestRunner extends AbstractTestNGCucumberTests {
	
	


}