package com.stepDefinitions.Classes;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
@SuppressWarnings("deprecation")
public class PlaceBidInvalidFeature extends BasePageObject {
	BasePageObject basePageObject = PageFactory.initElements(driver,
			BasePageObject.class);

	@Given("^user should be in investor home page$")
	public void user_should_be_in_investor_home_page() throws Throwable {
		String investorPage = driver.getCurrentUrl();
		Assert.assertTrue(
				"Unable to find the investor in URL after successful login",
				investorPage.contains("investor"));
	}

	@When("^user click volgende in bid page$")
	public void user_click_volgende_in_bid_page() throws Throwable {
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By
//				.cssSelector(dataConfig.getProperty("click_Bid_Volgende"))));
//		driver.findElement(By.cssSelector(dataConfig.getProperty("inputBid")))
//				.clear();
//		driver.findElement(
//				By.cssSelector(dataConfig.getProperty("click_Bid_Volgende")))
//				.click();
	}

	@Then("^user should validate error message$")
	public void user_should_validate_error_message() throws Throwable {
		// WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By
		// .cssSelector(dataConfig
		// .getProperty("input_bid_invalid_error_message"))));
//		WebElement error_message = driver.findElement(By.cssSelector(dataConfig
//				.getProperty("input_bid_invalid_error_message")));
//		Assert.assertEquals(error_message.getText(),
//				dataConfig.getProperty("error_message"));
	}

	@When("^user enter below invalid bid amounts$")
	public void user_enter_below_invalid_bid_amounts(DataTable table)
			throws Throwable {
		List<List<String>> data = table.raw();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("inputBid"))));
		driver.findElement(By.cssSelector(dataConfig.getProperty("inputBid")))
				.sendKeys(data.get(1).get(0).toString());

	}

	@When("^user click volgende again in bid page$")
	public void user_click_volgende_again_in_bid_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(dataConfig.getProperty("click_Bid_Volgende"))));
		driver.findElement(
				By.cssSelector(dataConfig.getProperty("click_Bid_Volgende")))
				.click();
	}

	@Then("^user should validate error message after invalid input$")
	public void user_should_validate_error_message_after_invalid_input()
			throws Throwable {

		WebElement error_message = driver.findElement(By.cssSelector(dataConfig
				.getProperty("input_bid_invalid_error_message")));
		Assert.assertEquals(error_message.getText(),
				dataConfig.getProperty("errorMessage_afterinvalid_input"));
	}
}
