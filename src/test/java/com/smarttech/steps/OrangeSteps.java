package com.smarttech.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.smarttech.pages.OrangePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class OrangeSteps {
	WebDriver driver;
	OrangePage dashPage;

	@Given("^user go to Orang HRM home page$")
	public void user_go_to_Orang_HRM_home_page() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\drive\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	@When("^user enter valid username and password$")
	public void user_enter_valid_username_and_password() throws Throwable {

		dashPage = new OrangePage(driver);
		dashPage.enterUsernameAndPassword();

	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {

		dashPage.clickOnLoginButton();

	}

	@Then("^uesr Navigate to welcome page$")
	public void uesr_Navigate_to_welcome_page() throws Throwable {
		dashPage.verifyWelcomeWord();

	}

	@Then("^user verify the page title as \"([^\"]*)\"$")
	public void user_verify_the_page_title_as(String title) throws Throwable {

		String expected = title;
		String actual = driver.getTitle();
		Assert.assertTrue("Title does not match", actual.contains(expected));

	}

	@Then("^user verify user name is displayes at top right$")
	public void user_verify_user_name_is_displayes_at_top_right() throws Throwable {

		dashPage.verifyUserName();
	}

	@Then("^User log out$")
	public void user_log_out() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dashPage.logOut();
	}

	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
		
		driver.close();
		driver.quit();
		}
}
