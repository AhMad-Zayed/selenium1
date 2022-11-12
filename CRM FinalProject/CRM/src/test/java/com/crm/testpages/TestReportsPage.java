package com.crm.testpages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.core.TakeSnapShot;
import com.crm.pages.LoginPage;
import com.crm.pages.ReportsPage;

public class TestReportsPage extends ReportsPage {public TestReportsPage() throws IOException {super();}
  
	@BeforeMethod
	public void beforeMethod() {
		init(prop.getProperty("URL"));
		LoginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@Test
	public void newCallStatusTest(Method method) {
		goToReportsPage();
		assertTrue(reportsPagestatus(), "Error: you are not in the ReportsPage");
	}
	
//	@Test(dataProvider = "getData")
//	public void newcallDataTest(String date, String reminderTime, String noteValue, String contactName,
//			String companyName, String flagVal, String noteBox) {
//		moveCallPage();
//		goToCallPage();
//		addNewCall(date, reminderTime, noteValue, contactName, companyName, flagVal, noteBox);
//	
//	}
	
	@AfterMethod
	public void afterMethod(Method method) throws IOException {
		TakeSnapShot.screenShot(method.getName());
		driver.quit();
	}

}
