package com.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
 
	WebDriver driver;
	
	By userName = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//input[@type='submit']");
    By accountOverview = By.xpath("//h1[normalize-space(text())='Accounts Overview']");
    
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String user, String pass) {
		driver.findElement(userName).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}
	
	public boolean isLoginSuccessful() {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(accountOverview))
                    .isDisplayed();
		}catch(Exception e) {
            return false;
        }
}
}
