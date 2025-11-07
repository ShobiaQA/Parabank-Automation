package com.parabank.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	@BeforeClass
   public void setup() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	   driver.get("https://parabank.parasoft.com/parabank/index.htm");
	   
   }
   @AfterClass
   public void tearDown() {
	   if(driver!=null) {
		   driver.quit();
	   }
   }

}
