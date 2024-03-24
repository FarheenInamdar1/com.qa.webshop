package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

/*
 * Title : LoginPage
 * Description : LoginPage class which contains elements and it's methods
 * Developed By : Farheen
 * Email Id : Farheen@gmail.com
 * Developed Date : 03/22/2024
 * Reviewed By : 
 * Approved By :  
 */

public class LoginPage extends DriverScript {
//************************ Login Page  Elements Locating **************************//
	@FindBy (id = "Email") WebElement emailTextBox ;
	@FindBy (name = "Password") WebElement passwordTextBox ;
	@FindBy (xpath = "//input[@class='button-1 login-button']") WebElement loginButton ;
	@FindBy (linkText = "Forgot password?") WebElement forgotPasswordLink ;
	@FindBy (id = "RememberMe") WebElement rememberMeCheckBox ;
	
//**************************** Page Initialization ********************************//
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
//************************ Login Page  Actions/Methods ****************************//
	// for each element create separate method
	
	public void enterEmail(String email) {                   //parameterize with variable
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	public boolean isForgotPasswordLinkPresent() {
		return forgotPasswordLink.isDisplayed();
	}

	public String getLoginPageTitle() {
		 return	driver.getTitle();
	}
	public void clickRememberMe() {
		rememberMeCheckBox.click();
	}
}
