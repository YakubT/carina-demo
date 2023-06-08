package com.qaprosoft.carina.demo.mytests.newweb;


import io.cucumber.testng.CucumberOptions;

import com.zebrunner.carina.cucumber.CucumberBaseTest;

@CucumberOptions(features = "src/test/resources/features/GSMArenaNews.feature",
        glue = "com.qaprosoft.carina.demo.cucumber.steps",
        plugin = {"pretty",
        "html:target/cucumber-core-test-report",
        "pretty:target/cucumber-core-test-report.txt",
        "json:target/cucumber-core-test-report.json",
        "junit:target/cucumber-core-test-report.xml"}
        )
public class CucumberWebSampleTest extends CucumberBaseTest {}