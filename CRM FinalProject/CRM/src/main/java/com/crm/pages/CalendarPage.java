package com.crm.pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.crm.core.TestBase;

public class CalendarPage extends TestBase {public CalendarPage() throws IOException {super();}
    
	WebElement clickOnNewEvent;
	WebElement newEventStatus;
	WebElement clickable;
	WebElement clickOnViewToday;
	WebElement viewTodayStatus;
	WebElement clickOnWeekView;
	WebElement weekViewStatus;
	WebElement clickOnMonthView;
	WebElement monthViewStatus;
	
	public void moveToCalenar() {
		switchToFrame();
		clickable = driver.findElement(By.xpath("//a[text()='Calendar']"));
		action.moveToElement(clickable).perform();
	}
	
	public boolean newEvent() {
		
		clickOnNewEvent = driver.findElement(By.xpath("//a[text()='New Event']"));
		clickOnNewEvent.click();
		newEventStatus = driver.findElement(By.xpath("//legend[text()='Event Information ']"));
		
		return newEventStatus.isDisplayed();
	}
	
	public boolean viewToday() {
		 clickOnViewToday = driver.findElement(By.xpath("//a[text()='View Today']"));
		 clickOnViewToday.click();
		 viewTodayStatus = driver.findElement(By.xpath("//input[@value='Week View']"));
		 
		 return viewTodayStatus.isEnabled();
	}
		
	public boolean weekView() {
		clickOnWeekView = driver.findElement(By.xpath("//a[text()='Week View']"));
		clickOnWeekView .click();
		weekViewStatus = driver.findElement(By.xpath("//td[text()='Week: 46']"));
		
		return weekViewStatus.isDisplayed();
	}
	
	public boolean monthView() {
		clickOnMonthView = driver.findElement(By.xpath("//a[text()='Month View']"));
		clickOnMonthView.click();
		monthViewStatus = driver.findElement(
				By.xpath("//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[8]/a"));
		return monthViewStatus.isDisplayed();
	}	
	

}
