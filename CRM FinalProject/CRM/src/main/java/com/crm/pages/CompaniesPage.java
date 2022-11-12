package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.core.TestBase;

public class CompaniesPage extends TestBase {public CompaniesPage() throws IOException {super();}
	WebElement clickable;
	WebElement clickOnNewCompany;
	WebElement newCompanyStatus;
	WebElement clickOnCombinedForm;
	WebElement combinedFormStatus;
	WebElement clickOnFullSearchForm;
	WebElement fullSearchFormStatus;
	
	public void moiveToCompanies() {
		switchToFrame();
		clickable = driver.findElement(By.xpath("//a[text()='Companies']"));
		action.moveToElement(clickable).perform();
	}
	
	public boolean newCompany() {
		
		clickOnNewCompany = driver.findElement(By.xpath("//a[text()='New Company']"));
		clickOnNewCompany.click();
		newCompanyStatus = driver.findElement(By.xpath("//legend[text()='Create New  Company']"));
		
		return newCompanyStatus.isDisplayed();
	}
	
	public boolean combinedForm() {
		
		clickOnCombinedForm = driver.findElement(By.xpath("//a[text()='Combined Form']"));
		clickOnCombinedForm.click();
		combinedFormStatus = driver.findElement(By.xpath("//legend[text()='Combined Contact and Company Form']"));
		
		return combinedFormStatus.isDisplayed();
	}
		
	public boolean fullSearchForm() {
		
		clickOnFullSearchForm = driver.findElement(By.xpath("//a[text()='Full Search Form']"));
		clickOnFullSearchForm.click();
		fullSearchFormStatus = driver.findElement(By.xpath("//legend[text()='Search for Companies']"));
		
		return fullSearchFormStatus.isDisplayed();
	}
		
	
	
}
