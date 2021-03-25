package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.page.LoginPage;
import com.qa.orangehrm.util.Credentials;

@Listeners(com.qa.orangehrm.listeners.ExtentReportListener.class)
public class LoginPageTest {

	// Fields : Webdriver, BasePage, Properties, LoginPage
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	Credentials cred;
	
	
	// @beforemethod Setup, @aftermethod tearDown, @test doLoginTest()....
	
	// Preconditions on @beforeMethod
	
	
	@BeforeMethod ()
	@Parameters(value = {"browser"})
	public void setUp(String browser){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(browser);
		loginPage = new LoginPage(driver);
		cred = new Credentials(properties.getProperty("username"),
				properties.getProperty("password"));
	}
	
	@Test(description = "This method checks if i can login to website with "
			+ "correct credentials")
	public void loginTest(){
		loginPage.doLogin(cred.getUsername(),
				cred.getPassword());
		// Test Case : After put credentials, we need to be in HomePage
		// And URL Should be :https://opensource-demo.orangehrmlive.com/index.php/dashboard
		String homePageURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertEquals(homePageURL, actualURL);
	}
	
	@Test(description = "This method checks if i can login to website with "
			+ "incorrect credentials")
	public void loginTest2(){
		loginPage.doLogin(properties.getProperty("incorrectUsername"),
				properties.getProperty("incorrectPassword"));
		
		// Test Case : After put wrong credentials, we need to be in LoginPage
		// And forgot password link message should be displayed
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='forgotPasswordLink']")).isDisplayed());
		
	}
	
	
	@AfterMethod()
	public void tearDown(){
		driver.quit();
	}
	
	
}



