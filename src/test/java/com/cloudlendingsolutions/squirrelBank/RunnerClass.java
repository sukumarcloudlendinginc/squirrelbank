package com.cloudlendingsolutions.squirrelBank;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*	
 * 
 * @Author: Sukumar.Kutagulla
 * 
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin ={"pretty","html:reports/test-report"}
,glue = { "com.stepDefinitions.Classes" }, tags = {"@dev, @wip"},
features = "C:\\Users\\HAPPIEST MINDS\\Desktop\\Saleforce\\mvpdemo\\src\\test\\resources\\com\\featureFiles")
public class RunnerClass {

//	@BeforeClass
//	public static void setUp() {
//		// Initiates the extent report and generates the output
//		ExtentCucumberFormatter.initiateExtentCucumberFormatter();
//
//		ExtentCucumberFormatter
//				.loadConfig(new File(
//						"C:/Users/HAPPIEST MINDS/Desktop/Saleforce/mvpdemo/Reports/Auutomation_report.html)"));
//	}
}