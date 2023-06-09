package com.qaprosoft.carina.demo.mytests.newweb;

import io.cucumber.testng.CucumberOptions;

import com.zebrunner.carina.cucumber.CucumberBaseTest;

@CucumberOptions(features = "src/test/resources/features/GSMArenaNews.feature",
        glue = "com.qaprosoft.carina.demo.cucumber.steps",
        plugin = {"pretty"}
        )
public class CucumberWebSampleTest extends CucumberBaseTest {}