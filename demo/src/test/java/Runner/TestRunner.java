package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"stepdefinitions", "common",
        "pageobjectmodel" }, plugin = {
                                "pretty",
                                "html:target/cucumber-reports.html",
                                "junit:target/junit-results.xml",
                                "json:target/cucumber.json"
                }, monochrome = true, 
                dryRun = false)
public class TestRunner {

    
} 
    
