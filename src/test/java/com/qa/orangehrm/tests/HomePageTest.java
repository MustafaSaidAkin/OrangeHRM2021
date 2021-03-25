package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.page.HomePage;
import com.qa.orangehrm.page.LoginPage;


public class HomePageTest {
	// Fields : Webdriver, BasePage, Properties, LoginPage
	
		WebDriver driver;
		BasePage basePage;
		Properties properties;
		LoginPage loginPage;
		HomePage homepage;
		
		@BeforeMethod
		@Parameters(value = {"browser"})
		public void setUp(String browser){
			basePage = new BasePage();
			properties = basePage.initialize_properties();
			driver = basePage.initialize_driver(browser);
			loginPage = new LoginPage(driver);
			homepage = loginPage.doLogin(properties.getProperty("username"),
					properties.getProperty("password"));
		}
		
		@Test(description = "This method checks if admin link directing to the correct page")
		public void checkAdminLink(){
			// Preconditions : User needs to be in homepage
			// Steps : click on admin link
			// Expected condition : User need to be in admin page
			homepage.clickAdminLink();
			homepage.clickAdminLink();
			String actualURL = driver.getCurrentUrl();
			String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
			Assert.assertEquals(actualURL, expectedURL);
			
			
		}
		
}




