package com.crm.testpages;

import org.testng.annotations.Test;

import com.crm.core.TakeSnapShot;
import com.crm.pages.CalendarPage;
import com.crm.pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;

public class TestCalendarPage extends CalendarPage {public TestCalendarPage() throws IOException {super();}
	
@BeforeMethod
  public void beforeMethod() {
	init(prop.getProperty("URL"));
	LoginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	  }

  @Test(priority = 1)
  public void newEventTest(Method method) {
	 
	  moveToCalenar(); 
	  assertTrue(newEvent(),"Error you are not in new event page");
  }
  
  @Test(priority = 2)
  public void viewTodayTest(Method method) {
	  moveToCalenar(); 
	  assertTrue(viewToday(), "Error you are not in new view today page");
	  
  }
  
  @Test(priority = 3)
  public void weekViewTest(Method method) {
	  moveToCalenar(); 
	  assertTrue(weekView(), "Error you are not in weekView page");
  }
  
  @Test(priority = 4)
  public void monthViewTest(Method method) {
	  moveToCalenar(); 
	  assertTrue(monthView(), "Error you are not in Month view page");
	  
  }
  
  @AfterMethod
  public void afterMethod(Method method) throws IOException {
	  TakeSnapShot.screenShot(method.getName());
		driver.quit();
  }

}
