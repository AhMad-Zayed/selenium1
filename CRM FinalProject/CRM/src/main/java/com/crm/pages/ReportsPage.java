package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.core.TestBase;

public class ReportsPage extends TestBase {public ReportsPage() throws IOException {super();}

	WebElement clickOnReportsPage,newReportsPageStatus;

	
	
	public void goToReportsPage() {
		switchToFrame();
		clickOnReportsPage = driver.findElement(By.xpath("//a[text()='Reports']"));
		clickOnReportsPage.click();
	}
	
	public boolean reportsPagestatus() {
		
		newReportsPageStatus = driver.findElement(By.xpath("//legend[text()='Reports']"));
		
		return newReportsPageStatus.isDisplayed();
	}
			
			
		}

