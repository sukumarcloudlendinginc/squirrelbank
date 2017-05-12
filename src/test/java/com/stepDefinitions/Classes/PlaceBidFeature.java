package com.stepDefinitions.Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class PlaceBidFeature extends BasePageObject {

	BasePageObject basePageObject = PageFactory.initElements(driver,
			BasePageObject.class);

	@Given("^user should be in investor page$")
	public void user_should_be_in_investor_page() throws Throwable {
		String investorPage = driver.getCurrentUrl();
		Assert.assertTrue(investorPage.contains("investor"),
				"Unable to find the investor in URL after successful login");
	}

	@When("^user clicks on first card$")
	public void user_clicks_on_first_card() throws Throwable {
		getDataProperties();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(dataConfig.getProperty("clickBid"))));
		driver.findElement(By.xpath(dataConfig.getProperty("clickBid")))
				.click();
	}

	@Then("^user should navigate to detailed card view$")
	public void user_should_navigate_to_detailed_card_view() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("detailedCardView"))));
		String detailedView = driver.findElement(
				By.cssSelector(dataConfig.getProperty("detailedCardView")))
				.getText();
		Assert.assertEquals(detailedView, "Investment proposal");
	}

	@Then("^Then user should click on volgende$")
	public void then_user_should_click_on_volgende() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("click_Volgende"))));
		driver.findElement(
				By.cssSelector(dataConfig.getProperty("click_Volgende")))
				.click();
	}

	@Then("^Then user should place bid in the text field$")
	public void then_user_should_place_bid_in_the_text_field() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("inputBid"))));
		driver.findElement(By.cssSelector(dataConfig.getProperty("inputBid")))
				.sendKeys("100000");
	}

	@Then("^Then user should click volgende$")
	public void then_user_should_click_volgende() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("click_Bid_Volgende"))));
		driver.findElement(
				By.cssSelector(dataConfig.getProperty("click_Bid_Volgende")))
				.click();
	}

	@Then("^Then user should click checkbox for confirmation$")
	public void then_user_should_click_checkbox_for_confirmation()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("click_Verzenden"))));
		boolean verzenden = driver.findElement(
				By.cssSelector(dataConfig.getProperty("click_Verzenden")))
				.isEnabled();
		if (verzenden == false) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.cssSelector(dataConfig.getProperty("click_checkbox"))));
			WebElement click_Checkbox=driver.findElement(
					By.cssSelector(dataConfig.getProperty("click_checkbox")));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", click_Checkbox);
		}
	}

	@Then("^Then user should click verzenden$")
	public void then_user_should_click_verzenden() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("click_Verzenden"))));
		boolean verzendenEnabled = driver.findElement(
				By.cssSelector(dataConfig.getProperty("click_Verzenden")))
				.isEnabled();
		if (verzendenEnabled == true) {
			WebElement click_Verzenden=driver.findElement(
					By.cssSelector(dataConfig.getProperty("click_Verzenden")));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", click_Verzenden);
		}
	}

	@Then("^Then user should redirect back to investor page$")
	public void then_user_should_redirect_back_to_investor_page()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("back_to_MySquirrel"))));
		driver.findElement(
				By.cssSelector(dataConfig.getProperty("back_to_MySquirrel"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("new_Bid_Created"))));
		String bidProgress = driver.findElement(
				By.cssSelector(dataConfig.getProperty("new_Bid_Created"))).getText();
//		System.out.println(submissions);
		Assert.assertEquals(bidProgress, "In behandeling");
	}
}
