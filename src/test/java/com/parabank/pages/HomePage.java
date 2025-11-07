package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	By registerLink = By.linkText("Register");
	By logoutLink = By.xpath("//li/a[text()='Log Out']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickRegister() {
		driver.findElement(registerLink).click();
	}
	
	public void logout() {
		driver.findElement(logoutLink).click();
	}

}
