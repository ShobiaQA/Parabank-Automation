package com.parabank.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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
	@AfterMethod
	public void captureScreenshot(ITestResult result) {
        // Only take a screenshot if the test failed
        if (ITestResult.FAILURE == result.getStatus()|| ITestResult.SUCCESS == result.getStatus()) {
            String screenshotDir = System.getProperty("user.dir") + "/screenshots/";

            // Add timestamp to avoid overwriting
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotDir + result.getName() + "_" + timestamp + ".png");

            try {
                // Create folder if not exists
                if (!new File(screenshotDir).exists()) {
                    new File(screenshotDir).mkdirs();
                }

                FileUtils.copyFile(srcFile, destFile);
                System.out.println("✅ Screenshot saved at: " + destFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   @AfterClass
   public void tearDown() {
	   if(driver!=null) {
		   driver.quit();
	   }
	   
   }
   
   
}
