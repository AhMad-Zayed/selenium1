package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.core.TestBase;

public class ContactsPage extends TestBase {public ContactsPage() throws IOException {super();}

	
		WebElement clickable;
		WebElement clickOnNewContacts;
		WebElement newContactsStatus;
		WebElement clickOnCombinedForm;
		WebElement title ;
		Select titleValue  ;
		Select suffixValue;
		WebElement firstName;
		WebElement middleName;
		WebElement lastName;
		WebElement suffix;
		WebElement nickName,company,position,phone,submit ;
		
		public void moiveToContacts() {
			switchToFrame();
			clickable = driver.findElement(By.xpath("//a[text()='Contacts']"));
			action.moveToElement(clickable).perform();
		}
		
		public void goToNewContacts() {
			
			clickOnNewContacts = driver.findElement(By.xpath("//a[text()='New Contact']"));
			clickOnNewContacts.click();
			
		}
		public boolean newContacts() {
			newContactsStatus = driver.findElement(By.xpath("//legend[text()='Contact Information']"));
			
			return newContactsStatus.isDisplayed();
		}
		
		public void addContact(String titleV,String fName,String mName,String lName,String suffixV,String nName,String cName,String pType,String pNumber) {
			moiveToContacts();
			goToNewContacts();
			title = driver.findElement(By.xpath("//select[@name='title']"));
			titleValue = new Select(title);
			firstName = driver.findElement(By.id("first_name"));
			middleName = driver.findElement(By.id("middle_initial"));
			lastName = driver.findElement(By.id("surname"));
			suffix = driver.findElement(By.xpath("//select[@name='suffix']"));
			suffixValue= new Select(suffix);
			nickName = driver.findElement(By.name("nickname"));
			company = driver.findElement(By.name("client_lookup"));
			position = driver.findElement(By.id("company_position"));
			phone = driver.findElement(By.id("phone"));
			submit = driver.findElement(By.xpath("//input[2][@value='Save']"));
			
			titleValue.selectByIndex(Integer.parseInt(titleV));
			firstName.sendKeys(fName);
			middleName.sendKeys(mName);
			lastName.sendKeys(lName);
			suffixValue.selectByIndex(Integer.parseInt(suffixV));
			nickName .sendKeys(nName);
			company.sendKeys(cName);
			position.sendKeys(pType);
			phone.sendKeys(pType);
			submit.click();
			
			
		     
		}
		
		
					
		
	

}
