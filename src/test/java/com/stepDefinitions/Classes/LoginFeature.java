package com.stepDefinitions.Classes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.salesforce.cloudlendingsolutions.squirrelBank.BasePageObject;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*	
 * 
 * @Author: Sukumar.Kutagulla
 * 
 */
public class LoginFeature extends BasePageObject {

	BasePageObject basePageObject = PageFactory.initElements(driver,
			BasePageObject.class);

	@Given("^user navigates to squirrel bank$")
	public void user_navigates_to_squirrel_bank() throws Throwable {
		basePageObject.startDriver();
	}

	@When("^user clicks the login link$")
	public void user_clicks_the_login_link() throws Throwable {
		getDataProperties();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("login"))));
		WebElement login = driver.findElement(By.cssSelector(dataConfig
				.getProperty("login")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", login);
	}

	@Then("^user should navigate to login page$")
	public void user_should_navigate_to_login_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.tagName(("iframe"))));
		int size = driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().frame(0);
	}

	@Given("^user should be on login page$")
	public void user_should_be_on_login_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("loginTitle"))));
		WebElement loginTitle = driver.findElement(By.cssSelector(dataConfig
				.getProperty("loginTitle")));
		Assert.assertEquals(loginTitle.getText(), "Inloggen Mijn Rabo&Co");
	}

	@When("^user enter below valid login details$")
	public void user_enter_below_valid_login_details(DataTable table)
			throws Throwable {
		List<List<String>> data = table.raw();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("emailTextBox"))));
		driver.findElement(
				By.cssSelector(dataConfig.getProperty("emailTextBox")))
				.sendKeys(data.get(1).get(0).toString());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("passwordTextBox"))));
		driver.findElement(
				By.cssSelector(dataConfig.getProperty("passwordTextBox")))
				.sendKeys(data.get(1).get(1).toString());
	}

	@When("^user should click Login button$")
	public void user_should_click_Login_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("submit"))));
		WebElement submit = driver.findElement(By.cssSelector(dataConfig
				.getProperty("submit")));
			submit.click();
	}

	@Then("^user should successfully login$")
	public void user_should_successfully_login() throws Throwable {
		String investorPage = driver.getCurrentUrl();
		Assert.assertTrue(investorPage.contains("investor"),
				"Unable to find the investor in URL after successful login");

	}
}
