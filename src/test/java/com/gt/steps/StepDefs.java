package com.gt.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	WebDriver driver = null;
	WebElement ele;

	@Given("I am in the Purchase Foreign Currency page")
	public void i_am_in_the_purchase_foreign_currency_page() {

		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("ignore-certificate-errors");
			chromeOptions.addArguments("--test-type");

			driver = new ChromeDriver(chromeOptions);

			driver.manage().window().maximize();
			driver.get("http://zero.webappsecurity.com/login.html");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.id("user_password")).submit();
			driver.findElement(By.linkText("Pay Bills")).click();
			driver.findElement(By.linkText("Purchase Foreign Currency")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Given("I select the currency type as {string}")
	public void i_select_the_currency_type_as(String string) {
		
		try {
			ele = driver.findElement(By.id("pc_currency"));
			highlight(driver, ele);
			
			Select currencies = new Select(driver.findElement(By.id("pc_currency")));
			currencies.selectByValue(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("I try to calculate the conversion cost for {string} USD")
	public void i_try_to_calculate_the_conversion_cost_for(String string) {
		
		try {			
			ele = driver.findElement(By.id("pc_amount"));
			highlight(driver, ele);
			
			driver.findElement(By.id("pc_amount")).sendKeys(string);
			driver.findElement(By.id("pc_inDollars_true")).click();
			driver.findElement(By.id("pc_calculate_costs")).click();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("I should be displayed with the conversion amount with {string}")
	public void i_should_be_displayed_with_the_conversion_amount_with(String string) {

		try {
			String conversionText = driver.findElement(By.id("pc_conversion_amount")).getText();
			assertTrue(conversionText.contains(string));
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("the current selling rate for the {string} equvialent to USD should be displayed")
	public void the_current_selling_rate_for_the_equvialent_to_usd_should_be_displayed(String string) {

		try {
			Thread.sleep(2000);
			String conversionText = driver.findElement(By.id("sp_sell_rate")).getText();
			assertTrue(conversionText.contains(string));
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void highlight(WebDriver driver, WebElement element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		Thread.sleep(1500);
	}

}
