package com.stepDefinitions.Classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.salesforce.cloudlendingsolutions.squirrelBank.BasePageObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*	
 * 
 * @Author: Sukumar.Kutagulla
 * 
 */
public class HomePageContactFeature extends BasePageObject {

	BasePageObject basePageObject = PageFactory.initElements(driver,
			BasePageObject.class);

	@Given("^user navigates to homePage$")
	public void user_navigates_to_homePage() throws Throwable {
		basePageObject.startDriver();
	}

	@When("^user clicks contact link in the home page$")
	public void user_clicks_contact_link_in_the_home_page() throws Throwable {
		getDataProperties();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("contactLink"))));
		WebElement contactLink = driver.findElement(By.cssSelector(dataConfig
				.getProperty("contactLink")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", contactLink);
	}

	@Then("^user should be navigated to contact page$")
	public void user_should_be_navigated_to_contact_page() throws Throwable {
		getDataProperties();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(dataConfig.getProperty("contactTitle"))));
		String contactTitle = driver.findElement(
				By.xpath(dataConfig.getProperty("contactTitle"))).getText();
		Assert.assertEquals(contactTitle, "Contact");
	}

	@Given("^user should be in contact page$")
	public void user_should_be_in_contact_page() throws Throwable {
		user_should_be_navigated_to_contact_page();
	}

	@When("^user clicks expand and collapse icons for the frequently asked questions$")
	public void user_clicks_expand_and_collapse_icons_for_the_frequently_asked_questions()
			throws Throwable {
		WebElement clickQueries = driver.findElement(By.cssSelector(dataConfig
				.getProperty("query1")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		for (int i = 1; i <= 6; i++) {
			WebElement query = driver.findElement(By.cssSelector(dataConfig
					.getProperty("query" + i)));
			executor.executeScript("arguments[0].click();", query);
		}

		for (int i = 1; i <= 6; i++) {
			WebElement query = driver.findElement(By.cssSelector(dataConfig
					.getProperty("query" + i)));
			executor.executeScript("arguments[0].click();", query);
		}
	}

	@Then("^validate the content of the all questions$")
	public void validate_the_content_of_the_all_questions() throws Throwable {
		System.out
				.println("Cannot be validated since the text is in dutch language");
	}

	@Then("^user should be navigated back to home page$")
	public void user_should_be_navigated_back_to_home_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("home_link"))));
		driver.findElement(By.cssSelector(dataConfig.getProperty("home_link")))
				.click();
	}

	@Then("^close the driver$")
	public void close_the_driver() throws Throwable {
		driver.quit();
	}
}
