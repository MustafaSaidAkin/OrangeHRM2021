package com.qa.orangehrm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	// Defining the actions in code level
	// Simulating actions as a user on code level with Selenium
	
	// Fields, Webdriver, properties, locators
	WebDriver driver;
	By adminLink = By.id("menu_admin_viewAdminModule");
	By welcomeLink = By.id("welcome");
	
	// Constructor(Webdriver driver)
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page Actions
	/*
	 * Clicking admin link
	 * Clicking any link
	 * 
	 */
	
	public void clickAdminLink(){
		driver.findElement(adminLink).click();
	}
	
	
	

}
