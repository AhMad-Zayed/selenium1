package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.core.TestBase;

public class CallPage extends TestBase {public CallPage() throws IOException {super();}

WebElement clickable,clickOnNewCall,newCalllStatus ;
WebElement picDate,reminder,note,contact,company,flag,freeNoteBox,submitButton;
Select reminderValue,flagValue;

	public void moveCallPage() {
		switchToFrame();
		clickable = driver.findElement(By.xpath("//a[text()='Call']"));
		action.moveToElement(clickable).perform();
	}
	
	public void goToCallPage() {
		clickOnNewCall = driver.findElement(By.xpath("//a[text()='New Call']"));
		clickOnNewCall.click();
	}
	
	public boolean newCall() {
		
		newCalllStatus = driver.findElement(By.xpath("//legend[text()='Call Information']"));
		
		return newCalllStatus.isDisplayed();
	}
	
	public void addNewCall(String date, String reminderTime,String noteValue,
			String contactName,String companyName,String flagVal,String noteBox) {
		
		picDate = driver.findElement(By.id("fieldId_schedule"));
		reminder = driver.findElement(By.name("reminder_minutes"));
		reminderValue = new Select(reminder);
		note = driver.findElement(By.name("reminder_note"));
		contact =driver.findElement(By.name("contact_lookup"));
		company = driver.findElement(By.name("client_lookup"));
		flag = driver.findElement(By.xpath("//tr[8]/td[2]/select[@name='flag']"));
		flagValue= new Select(flag);
		freeNoteBox = driver.findElement(By.xpath("//textarea[@name='notes']"));
		submitButton = driver.findElement(By.xpath("//tr[1]/td/input[1][@value='Save']"));
		
		picDate.sendKeys(date);
		reminderValue.selectByIndex(Integer.parseInt(reminderTime));
		note.sendKeys(noteValue);
		contact.sendKeys(contactName);
		company.sendKeys(companyName);
		flagValue.selectByIndex(Integer.parseInt(flagVal));
		freeNoteBox.sendKeys(noteBox);
		submitButton.click();
	}
		
	


}
