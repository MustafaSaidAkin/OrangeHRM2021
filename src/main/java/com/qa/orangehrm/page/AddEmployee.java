package com.qa.orangehrm.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AddEmployee {
	// fields, 
	
	WebDriver driver;
	By pimBtn = By.xpath("//b[text()='PIM']");
	By addEmployee = By.xpath("//a[contains(@id,'addEmployee')]");
	By firstName = By.xpath("//input[contains(@id,'firstName')]");
	By lastName = By.xpath("//input[contains(@id,'lastName')]");
	By btnSave = By.xpath("//input[contains(@id,'btnSave')]");
	By employeeList = By.xpath("//a[normalize-space()='Employee List']");
    By employeeName = By.id("empsearch_employee_name_empName");
	By searchEmployee = By.id("searchBtn");
	By checkEmpName = By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]");
	By checkEmpLastName = By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[4]");
	
	
	// constructor
	
	public AddEmployee(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page Actions
	
	public void goToAddEmployee() throws InterruptedException{
		driver.findElement(pimBtn).click();
		Thread.sleep(3000);
		driver.findElement(addEmployee).click();
		
	}
	
	public void addEmployee(String name, String lastname){
		driver.findElement(firstName).sendKeys(name);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(btnSave).click();
	}
	
	public void checkEmployee(String name , String lastname) throws InterruptedException {
		driver.findElement(employeeList).click();
		Thread.sleep(5000);

		driver.findElement(employeeName).sendKeys(name +" "+ lastname);
		

		driver.findElement(searchEmployee).click();
		
	
		
	}
	public String getCheckAddEmployeeName() {
		return  driver.findElement(checkEmpName).getText();
	}
	public String getCheckAddEmployeeLastname() {
		return  driver.findElement(checkEmpLastName).getText();
	}
	
}