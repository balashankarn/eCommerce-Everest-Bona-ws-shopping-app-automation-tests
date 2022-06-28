package parallel;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.utilities.JvmReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/Features"},
		glue= {"parallel"},
		dryRun=false,
		tags= "@signin",
		plugin= {"pretty", "json:target/ResultsMobile/cucumber.json"},
		monochrome = true)
public class RunCucumberTest {
	
	@AfterClass         
	   public static void afterClass() throws IOException {                 
		   JvmReport.generateReport(System.getProperty("user.dir")+"/target/ResultsMobile/cucumber.json");     
		   
		   } 
}