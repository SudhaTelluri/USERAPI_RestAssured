package user.runner;
	
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
		@CucumberOptions(
				monochrome = false,  //console output formatting
				tags = "", //tags from feature file
				features = {"src/test/resources/features"}, //location of feature files
				glue= {"user.stepDefinitions"}, //location of step definition files
				plugin = {"pretty", //For the Detailed output and generating reports.
							"html:target/Cucumber-Reports/Team3_UserAPI.html" ,
							"json:target/Cucumber-Reports/Team3_UserAPI.json" , 
							"junit:target/Cucumber-Reports/Team3_UserAPI.xml",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
						}
				) 

		public class TestRunner extends AbstractTestNGCucumberTests{
			

		}
