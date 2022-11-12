package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.core.TestBase;

public class HomePage extends TestBase {public HomePage() throws IOException {super();}
		
		WebElement flaged_Records;
		WebElement homePageButton;
		public boolean youAreInHomePage() {
			switchToFrame();
			flaged_Records = driver.findElement(By.id("handle_RECFLAGS"));
			
			return flaged_Records.isDisplayed();
			
		}
		
//		public void loginAccount() {
//			loginpage.login(prop.getProperty("userName"), prop.getProperty("password"));
//		}
		
		public boolean youAreInHomePage1() {
			switchToFrame();
			homePageButton = driver.findElement(By.xpath("//a[text()='Home']"));
			
			return homePageButton.isEnabled(); 
		}

}
