package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.core.TestBase;

public class LoginPage extends TestBase {	public LoginPage() throws IOException {super();}

    MainPage main = new MainPage();
	static WebElement userTextField;
	static WebElement passwordTextField;
	static WebElement loginButton;
	WebElement  loginLogoStatus;
	
	public static void login(String username,String passowrd) {
		
		userTextField = driver.findElement(By.name("username"));
	    userTextField.sendKeys(username);
		
		passwordTextField = driver.findElement(By.name("password"));
		passwordTextField.sendKeys(passowrd);
		
		loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		loginButton.click();
	
	}
	
	//Test Cases
	public boolean loginStatus() {
		
		switchToFrame(); //from 
		loginLogoStatus = driver.findElement(By.xpath("//td[text()='CRMPRO']"));
		return loginLogoStatus.isDisplayed();
		
	} 
	
	public boolean loginFalseStatus() {
		return main.displayedLogo();
	}
	

}
