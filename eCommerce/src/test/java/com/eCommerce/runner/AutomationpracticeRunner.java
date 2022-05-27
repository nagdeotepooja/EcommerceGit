package com.eCommerce.runner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions
       (
    		   
    	features="E://Users//Welcome//BDDAutomation//eCommerce//src//test//java//com//eCommerce//feature//Automationpractice.feature",
    	glue="com.eCommerce.stepdef",
    	dryRun=false,
    	monochrome =true,
    	plugin= {"pretty","html:target/cucumber/report.html"}
    		   
       )
@Test
public class AutomationpracticeRunner extends AbstractTestNGCucumberTests {

}
