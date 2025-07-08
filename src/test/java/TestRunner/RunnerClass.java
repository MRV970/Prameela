package TestRunner;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = "src/test/java/FeatureFiles",       // path to your .feature file
    glue = {"stepdefinitions"},                    // package for your step definitions
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",       // basic HTML report
        "json:target/cucumber.json",               // JSON report for Allure or other tools
        "junit:target/cucumber.xml"                // JUnit XML report
    },
    monochrome = true,                             // clean readable console output
    dryRun = false,                                // set true to check mappings only (no execution)
    tags = "@Fulfillmentvalidation"                           // optional: tag to filter scenarios
)

public class RunnerClass {

}
