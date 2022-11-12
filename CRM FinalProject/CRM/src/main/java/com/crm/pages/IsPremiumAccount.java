package com.crm.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.crm.core.TestBase;

public class IsPremiumAccount extends TestBase {public IsPremiumAccount() throws IOException {super();}
	WebElement clickable,clickOnNewEmailCampaign,isPremiumAccountStatusPrintPage,isPremiumAccountStatusMailPage;
	
	public void moveToMallPage() {
		switchToFrame();
		clickable = driver.findElement(By.xpath("//a[@title='Email']"));
		action.moveToElement(clickable).perform();
	}
	
	
	public void goToNewEmailCampaign(){
		
		clickOnNewEmailCampaign = driver.findElement(By.xpath("//a[text()='New Email Campaign']"));
		clickOnNewEmailCampaign.click();
	}
	
	public boolean isPremiumAccountStatusFromEmailCampaign() {
		
		isPremiumAccountStatusMailPage = driver.findElement(By.xpath(
			"//div[1][text()='This feature is not available for Free account. Please upgrade to pro account.']"));
		
		return isPremiumAccountStatusMailPage.isDisplayed();
	}
	
	public void moveToPrintPage() {
		switchToFrame();
		clickable = driver.findElement(By.xpath("//a[text()='Print']"));
		action.moveToElement(clickable).perform();
		}

	public void goToNewPrintPage() {
		clickOnNewEmailCampaign = driver.findElement(By.xpath("//a[text()='New Print Campaign']"));
		clickOnNewEmailCampaign.click();
	}
	
	public boolean isPremiumAccountStatusFromPrintPage() {
		isPremiumAccountStatusPrintPage = driver.findElement(By.xpath(
			"//div[1][text()='This feature is not available for Free account. Please upgrade to pro account.']"));
		
		return isPremiumAccountStatusPrintPage.isDisplayed();
	
	}
}
