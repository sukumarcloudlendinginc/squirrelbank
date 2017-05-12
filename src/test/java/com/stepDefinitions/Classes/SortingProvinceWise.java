package com.stepDefinitions.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
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
public class SortingProvinceWise extends BasePageObject {

	BasePageObject basePageObject = PageFactory.initElements(driver,
			BasePageObject.class);
	@Given("^user should click dropdown$")
	public void user_should_click_dropdown() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(dataConfig.getProperty("click_DropDown"))));
//		driver.findElement(By.xpath(dataConfig.getProperty("click_DropDown")))
//				.click();
	}
	@When("^user selects province A to Z$")
	public void user_selects_province_A_to_Z() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(dataConfig.getProperty("click_DropDown"))));
	}

	@Then("^user should see the cards displayed as per the province in alphabetical ascending order$")
	public void user_should_see_the_cards_displayed_as_per_the_province_in_alphabetical_ascending_order()
			throws Throwable {
		WebElement dropDown = driver.findElement(By.xpath(dataConfig
				.getProperty("click_DropDown")));
		Select select = new Select(dropDown);
		select.selectByValue(dataConfig.getProperty("provinceAscending"));
		List<String> provinceList = new ArrayList<String>();
		List<WebElement> provinces = driver.findElements(By.cssSelector(dataConfig
				.getProperty("activeCardProvince")));
		for(WebElement nameOfProvince: provinces){
			provinceList.add(nameOfProvince.getText());
		}
		String[] activeCardActualArray = (String[]) provinceList.toArray(new String[provinceList.size()]);
		String[] activeExpectedArray = new String[activeCardActualArray.length];
		System.arraycopy(activeCardActualArray, 0, activeExpectedArray, 0, activeCardActualArray.length);
		Arrays.sort(activeExpectedArray);
		Assert.assertArrayEquals(activeExpectedArray, activeCardActualArray);
		
		
		List<String> inactiveCardProvinceList = new ArrayList<String>();
		List<WebElement> inactiveProvinces = driver.findElements(By.cssSelector(dataConfig
				.getProperty("inactiveCardProvince")));
		for(WebElement nameOfProvince: inactiveProvinces){
			inactiveCardProvinceList.add(nameOfProvince.getText());
		}
		String[] inactiveCardActualArray = (String[]) inactiveCardProvinceList.toArray(new String[inactiveCardProvinceList.size()]);
		String[] inactiveCardExpectedArray = new String[inactiveCardActualArray.length];
		System.arraycopy(inactiveCardActualArray, 0, inactiveCardExpectedArray, 0, inactiveCardActualArray.length);
		Arrays.sort(inactiveCardExpectedArray);
		Assert.assertArrayEquals(inactiveCardExpectedArray, inactiveCardActualArray);
	}
	

	@Given("^user clicks on dropdown option$")
	public void user_clicks_on_dropdown_option() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(dataConfig.getProperty("click_DropDown"))));
		driver.findElement(By.xpath(dataConfig.getProperty("click_DropDown")))
				.click();
	}
	@When("^user selects province Z to A$")
	public void user_selects_province_Z_to_A() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(dataConfig.getProperty("click_DropDown"))));
		WebElement dropDown = driver.findElement(By.xpath(dataConfig
				.getProperty("click_DropDown")));
		Select select = new Select(dropDown);
		select.selectByValue(dataConfig.getProperty("provinceDescending"));
	}

	@Then("^user should see the cards displayed as per the province in alphabetical descending order$")
	public void user_should_see_the_cards_displayed_as_per_the_province_in_alphabetical_descending_order()
			throws Throwable {
		WebElement dropDown = driver.findElement(By.xpath(dataConfig
				.getProperty("click_DropDown")));
		Select select = new Select(dropDown);
		select.selectByValue(dataConfig.getProperty("provinceDescending"));
		List<String> provinceList = new ArrayList<String>();
		List<WebElement> provinces = driver.findElements(By.cssSelector(dataConfig
				.getProperty("activeCardProvince")));
		for(WebElement nameOfProvince: provinces){
			provinceList.add(nameOfProvince.getText());
		}
		String[] activeCardActualArray = (String[]) provinceList.toArray(new String[provinceList.size()]);
		String[] activeExpectedArray = new String[activeCardActualArray.length];
		System.arraycopy(activeCardActualArray, 0, activeExpectedArray, 0, activeCardActualArray.length);
		Arrays.sort(activeExpectedArray, Collections.reverseOrder());
		Assert.assertArrayEquals(activeExpectedArray, activeCardActualArray);
		
		List<String> inactiveCardProvinceList = new ArrayList<String>();
		List<WebElement> inactiveProvinces = driver.findElements(By.cssSelector(dataConfig
				.getProperty("inactiveCardProvince")));
		for(WebElement nameOfProvince: inactiveProvinces){
			inactiveCardProvinceList.add(nameOfProvince.getText());
		}
		String[] inactiveCardActualArray = (String[]) inactiveCardProvinceList.toArray(new String[inactiveCardProvinceList.size()]);
		String[] inactiveCardExpectedArray = new String[inactiveCardActualArray.length];
		System.arraycopy(inactiveCardActualArray, 0, inactiveCardExpectedArray, 0, inactiveCardActualArray.length);
		Arrays.sort(inactiveCardExpectedArray, Collections.reverseOrder());
		Assert.assertArrayEquals(inactiveCardExpectedArray, inactiveCardActualArray);
	}
}
