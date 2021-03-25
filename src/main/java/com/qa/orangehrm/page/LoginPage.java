package com.qa.orangehrm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	// Fields, Webdriver, properties, locators
	WebDriver driver;
	By usernameInput = By.id("txtUsername");
	By passwordInput = By.id("txtPassword");
	By loginButton = By.id("btnLogin");
	
	
	
	// Constructor(Webdriver driver)
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page Actions
	/*
	 * 1) Login with valid Credentials
	 * 2) Login with invalid credentials
	 * 3) Get the url
	 * 4) Get the page header
	 * 5) Click on forgetUserName Link
	 * .......
	 */
	
	public HomePage doLogin(String username, String password){
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();
		return new HomePage(driver);
		
	}
	
	
}
