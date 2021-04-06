package com.k12;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/com.k12"},
        glue = "com.k12.decoratorbase",
        publish = true,
        tags = "@test1",
        monochrome = true,
        plugin = { "html:target/cucumber-html-report.html",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json" }
)
public class CucumberTest extends AbstractTestNGCucumberTests {

}
