package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.core.TestBase;

public class MainPage extends TestBase {

	public MainPage() throws IOException {super();}
		
	WebElement logo ;
	WebElement loginButton;
	public  String expectedTitle;
	public  String acualTitle ;
	public void freeCRMtitle() {
		 acualTitle =driver.getTitle();
		 expectedTitle=prop.getProperty("expectedTitle");
	}
	public boolean displayedLogo() {
		logo = driver.findElement(By.xpath
				("//img[@src='https://classic.freecrm.com/img/logo.png']"));
		return logo.isDisplayed();
		 
	
		
	}
	
	public String freeCRMgetURL() {
		return driver.getCurrentUrl();
	}
	 public boolean  freeCRMenabledLoginButton() {
loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
return loginButton.isEnabled();
	}
	
	
	
	

}
