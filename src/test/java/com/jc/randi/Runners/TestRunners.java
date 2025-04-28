package com.jc.randi.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.jc.randi.stepdefinitions", "com.jc.randi.Utils.Hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class TestRunners {
}
