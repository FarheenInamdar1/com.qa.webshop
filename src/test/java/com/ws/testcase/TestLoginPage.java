package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;

public class TestLoginPage extends DriverScript{
	
	@Test (priority = 1)
	public void testHomePageTitle() {
		initApplication();             // To initiate app
		HomePage homePage = new HomePage();
		String title = homePage.getHomepageTitle();
		System.out.println("Home page title is : " +title);
		Assert.assertTrue(title.contains("Demo Web Shop"));			// validation
		quitDriver();
	}
	
	@Test(priority = 2)
	public void testLoginFunction() {
		initApplication();
		HomePage homePage = new HomePage();
		homePage.clickLogin();
		LoginPage loginPage = new LoginPage();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));		// validation
		loginPage.enterEmail("selauto1@test.com");			
		loginPage.enterPassword("Pass@123");
		loginPage.clickLoginButton();
		String title = homePage.getHomepageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));			// validation
		homePage.clickLogout();
		quitDriver();
	}
}
