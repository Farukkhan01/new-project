package com.smarttech.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrangePage {
	
	public OrangePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy (how =How.XPATH, using ="//*[@name='txtUsername']")
	private static WebElement username;
	
	@FindBy (how =How.XPATH, using ="//*[@id='txtPassword']")
	private static WebElement password;
	
	@FindBy (how =How.XPATH, using ="//*[@value='LOGIN']")
	private static WebElement loginBtn;
	
	@FindBy (how =How.XPATH, using ="//*[@id='welcome']")
	private static WebElement welcomeWord;
	
	@FindBy (how =How.XPATH, using ="//*[contains(text(),'Logout')]")
	private static WebElement logoutBtn;
	

	public void enterUsernameAndPassword() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		
	}

	public void clickOnLoginButton() {
		loginBtn.click();
		
	}

	public void verifyWelcomeWord() {
		String expected = "Welcome";
		String actual = welcomeWord.getText().trim();
		Assert.assertTrue("Word does not match", actual.contains(expected));
		
	}

	public void verifyUserName() {
		String expected = "Paul";
		String actual = welcomeWord.getText().trim();
		Assert.assertTrue("Word does not match", actual.contains(expected));
		
	}
	
	public void logOut() {
		welcomeWord.click();
		logoutBtn.click();
		
	}

}
