package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ws.base.DriverScript;

/*
 * Title: HomePage
 * Description : HomePage class which contains elements and it's methods
 * Developed By: Farheen
 * Email Id : Farheen@gmail.com 
 * Developed Date : 03/22/2024
 * Reviewed By :
 * Approved/Verified By: 
 */
public class HomePage extends DriverScript {
	
//**************************Locate Page Element ***********************************//

	@FindBy(linkText = "Log in") WebElement loginLink ;
	@FindBy(linkText = "Log out") WebElement logoutlink;
	
//**************************Page Initialization ***********************************//
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
//**************************Page Actions/Methods ***********************************//	
		
	public void clickLogin() {
		loginLink.click();	
	}
	
	public String getHomepageTitle() {
		return driver.getTitle();
	}
	
	public void clickLogout() {
		logoutlink.click();
	}
	
}
