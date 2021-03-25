package com.qa.orangehrm.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.page.AddEmployee;
import com.qa.orangehrm.page.HomePage;
import com.qa.orangehrm.page.LoginPage;
import com.qa.orangehrm.util.ExcelUtil;

public class AddEmployeeTest {
	
	
	// fields
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	AddEmployee addEmployee;
	
	// setup : We need to go to addemployee page
	
	@BeforeMethod()
	@Parameters(value = {"browser"})
	public void setUp(String browser) throws InterruptedException{
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(browser);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(properties.getProperty("username"),
				properties.getProperty("password"));
		addEmployee = new AddEmployee(driver);
		addEmployee.goToAddEmployee();
		
		
	}
//	
//	@DataProvider//(name = "Employee_List")
//	public Object [][] getEmployees(){
//		Object[][] data = ExcelUtil.getTestData("Sheet1");
//		return data;
//	}
//
//   
//	@Test(dataProvider="getEmployees")
//	public void addEmployee_2(String firstname, String lastName){
//		addEmployee.addEmployee(firstname, lastName);
//	}
//***********************************************************

//	// tests
//	@Test
//	public void testUrl(){
//		System.out.println(driver.getCurrentUrl());
//		
//	}
//	
//	@Test
//	public void addEmployee(){
//		addEmployee.addEmployee("Can", "Turk2");
//	}
//	
//	
//************************************************************	

	@DataProvider//(name = "Employee_List")
	public Object [][] getEmployees2(){
		Object[][] data = ExcelUtil.getTestData("Sheet2");
		return data;
	}

   
	@Test(dataProvider="getEmployees2")
	public void addEmployee_3(String firstname, String lastName){
		addEmployee.addEmployee(firstname, lastName);
	}

	
	@Test(dataProvider = "getEmployees2")
	public void checkEmployeeTest(String firstname,String lastName) throws InterruptedException  {
		addEmployee.checkEmployee(firstname, lastName);
		String expectedfirstname = addEmployee.getCheckAddEmployeeName();
		String expectedlastname = addEmployee.getCheckAddEmployeeLastname();
		String actualfulnameString= expectedfirstname + expectedlastname;
		String expectedfulnameString = firstname + lastName;
		
	 Assert.assertEquals(actualfulnameString, expectedfulnameString);
		
		
	}
	
	
	
	
	
	
	
	// tearDown
	@AfterMethod()
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
}