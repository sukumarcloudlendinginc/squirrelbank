package com.stepDefinitions.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesforce.cloudlendingsolutions.squirrelBank.BasePageObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*	
 * 
 * @Author: Sukumar.Kutagulla
 * 
 */
public class SortingTermWise extends BasePageObject {

	BasePageObject basePageObject = PageFactory.initElements(driver,
			BasePageObject.class);

	@Given("^user clicks on sorting dropdown$")
	public void user_clicks_on_sorting_dropdown() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(dataConfig.getProperty("click_DropDown"))));
	}

	@When("^user selects duration of the term from low to high$")
	public void user_selects_duration_of_the_term_from_low_to_high()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(dataConfig.getProperty("click_DropDown"))));
		
	}

	@Then("^user should see the cards displayed as per the duration of the term in ascending order$")
	public void user_should_see_the_cards_displayed_as_per_the_duration_of_the_term_in_ascending_order()
			throws Throwable {
		WebElement dropDown = driver.findElement(By.xpath(dataConfig
				.getProperty("click_DropDown")));
		Select select = new Select(dropDown);
		select.selectByValue(dataConfig.getProperty("termAscending"));
		List<Integer> activeCardTerms = new ArrayList<Integer>();
		List<WebElement> activeCardTerm = driver.findElements(By.cssSelector(dataConfig
				.getProperty("activeTerm")));
		for(WebElement durationOfTerm: activeCardTerm){
			String duration = durationOfTerm.getText();
			activeCardTerms.add(Integer.parseInt(duration));
			}
		Integer[] actualArray = (Integer[]) activeCardTerms.toArray(new Integer[activeCardTerms.size()]);
		Integer[] expectedArray = new Integer[actualArray.length];
		System.arraycopy(actualArray, 0, expectedArray, 0, actualArray.length);
		Arrays.sort(expectedArray);
		Assert.assertArrayEquals(expectedArray, actualArray);
		
		List<Integer> inActiveCardTerms = new ArrayList<Integer>();
		List<WebElement> inActiveCardTerm = driver.findElements(By.cssSelector(dataConfig
				.getProperty("inActiveTerm")));
		for(WebElement durationOfTerm: inActiveCardTerm){
			String duration = durationOfTerm.getText();
			inActiveCardTerms.add(Integer.parseInt(duration));
			}
		Integer[] inactiveCardActualArray = (Integer[]) inActiveCardTerms.toArray(new Integer[inActiveCardTerms.size()]);
		Integer[] inactiveCardExpectedArray = new Integer[inactiveCardActualArray.length];
		System.arraycopy(inactiveCardActualArray, 0, inactiveCardExpectedArray, 0, inactiveCardActualArray.length);
		Arrays.sort(inactiveCardExpectedArray, Collections.reverseOrder());
		Assert.assertArrayEquals(inactiveCardExpectedArray, inactiveCardActualArray);
	}

	@When("^user selects duration of the term from high to low$")
	public void user_selects_duration_of_the_term_from_high_to_low()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(dataConfig.getProperty("click_DropDown"))));

	}

	@Then("^user should see the cards displayed as per the duration of the term in descending order$")
	public void user_should_see_the_cards_displayed_as_per_the_duration_of_the_term_in_descending_order()
			throws Throwable {
		WebElement dropDown = driver.findElement(By.xpath(dataConfig
				.getProperty("click_DropDown")));
		Select select = new Select(dropDown);
		select.selectByValue(dataConfig.getProperty("termDescending"));
		List<Integer> activeCardTerms = new ArrayList<Integer>();
		List<WebElement> activeCardTerm = driver.findElements(By.cssSelector(dataConfig
				.getProperty("activeTerm")));
		for(WebElement durationOfTerm: activeCardTerm){
			String duration = durationOfTerm.getText();
			activeCardTerms.add(Integer.parseInt(duration));
			}
		Integer[] actualArray = (Integer[]) activeCardTerms.toArray(new Integer[activeCardTerms.size()]);
		Integer[] expectedArray = new Integer[actualArray.length];
		System.arraycopy(actualArray, 0, expectedArray, 0, actualArray.length);
		Arrays.sort(expectedArray, Collections.reverseOrder());
		Assert.assertArrayEquals(expectedArray, actualArray);
		
		List<Integer> inActiveCardTerms = new ArrayList<Integer>();
		List<WebElement> inActiveCardTerm = driver.findElements(By.cssSelector(dataConfig
				.getProperty("inActiveTerm")));
		for(WebElement durationOfTerm: inActiveCardTerm){
			String duration = durationOfTerm.getText();
			inActiveCardTerms.add(Integer.parseInt(duration));
			}
		Integer[] inactiveCardActualArray = (Integer[]) inActiveCardTerms.toArray(new Integer[inActiveCardTerms.size()]);
		Integer[] inactiveCardExpectedArray = new Integer[inactiveCardActualArray.length];
		System.arraycopy(inactiveCardActualArray, 0, inactiveCardExpectedArray, 0, inactiveCardActualArray.length);
		Arrays.sort(inactiveCardExpectedArray, Collections.reverseOrder());
		Assert.assertArrayEquals(inactiveCardExpectedArray, inactiveCardActualArray);
	}
}
