package com.parabank.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.base.BaseTest;
import com.parabank.pages.HomePage;
import com.parabank.pages.LoginPage;
import com.parabank.pages.RegistrationPage;
import com.parabank.utils.FileUtils;
import com.parabank.utils.RandomUtils;

public class UserRegistrationAndLoginTest extends BaseTest {
	
	@Test
	public void registerAndLoginTest() {
		Map<String,String> userData = RandomUtils.generateRandomUserData();
		
		HomePage homePg = new HomePage(driver);
		homePg.clickRegister();
		
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.registerUser(userData);
		
		Assert.assertTrue(regPage.isRegistrationSuccess(), "Registration Failed!");		
		
		FileUtils.saveUserData(userData);
		
	    homePg.logout();
		
		LoginPage loginPg = new LoginPage(driver);
		loginPg.login(userData.get("username"), userData.get("password"));
		
		String expectedTitle = "ParaBank | Accounts Overview";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Login Failed - Title Mismatch");
				System.out.println("Login Successful");
		
		
	}
	

}
