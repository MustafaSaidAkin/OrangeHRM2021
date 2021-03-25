package com.qa.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	// Fields
	//WebDriver driver;
	Properties properties;

	// initialize_driver
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static synchronized WebDriver getDriver(){
		return driver.get();
	}

	public WebDriver initialize_driver(String browser){
		
		properties = initialize_properties();
		
		String baseURL = properties.getProperty("url");
		System.out.println(browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Driver not found");
		}
		
		// Driver options here
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().get(baseURL);
		return getDriver();
	}
			
			// initialize_properties
			
			public Properties initialize_properties(){
				properties = new Properties();
				try {
					FileInputStream inputStream = new FileInputStream("/Users/mustafasaidakin/"
							+ "eclipse-workspace/OrangeHRM2021/"
							+ "src/main/java/com/qa/orangehrm/config/config.properties");
					properties.load(inputStream);
				} catch (FileNotFoundException e) {
					System.out.println("File Not Found");
				}
				catch (IOException e) {
					System.out.println("File Not Found");
				}
				return properties;
			}

		
		

}
