package com.crm.testpages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.core.TakeSnapShot;
import com.crm.pages.IsPremiumAccount;
import com.crm.pages.LoginPage;

public class TestIsPremiumAccount extends IsPremiumAccount {public TestIsPremiumAccount() throws IOException {super();}
  
		
	@BeforeMethod
	public void beforeMethod() {
		init(prop.getProperty("URL"));
		LoginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}
	@Test
	public void newCallStatusTest1(Method method) {
		moveToMallPage();
		goToNewEmailCampaign();
		assertTrue(isPremiumAccountStatusFromEmailCampaign());
		
	}
	
	@Test
	public void newCallStatusTest2(Method method) {
		moveToPrintPage();
		goToNewPrintPage();
		assertTrue(isPremiumAccountStatusFromPrintPage());
	}
	@AfterMethod
	public void afterMethod(Method method) throws IOException {
		TakeSnapShot.screenShot(method.getName());
		driver.quit();
}
}
