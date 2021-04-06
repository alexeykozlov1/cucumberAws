package com.k12;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/com.k12", glue = "com.k12.decoratorbase", publish = true, tags = "@test" )
public class CucumberTest extends AbstractTestNGCucumberTests {

}
