package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.core.TestBase;

public class DealsPage extends TestBase {public DealsPage() throws IOException {super();}
	WebElement clickable,clickOnNewDeal,newDealStatus ;
	
		public void moveToDeal() {
			switchToFrame();
			clickable = driver.findElement(By.xpath("//a[text()='Deals']"));
			action.moveToElement(clickable).perform();
		}
		
		public void goToDeal() {
			clickOnNewDeal = driver.findElement(By.xpath("//a[text()='New Deal']"));
			clickOnNewDeal.click();
		}
		
		public boolean newDeal() {
			
			newDealStatus = driver.findElement(By.xpath("//legend[text()='Deal']"));
			
			return newDealStatus.isDisplayed();
		}
	

}
