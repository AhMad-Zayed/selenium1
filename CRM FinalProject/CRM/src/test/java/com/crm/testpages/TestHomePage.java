package com.crm.testpages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.core.TakeSnapShot;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class TestHomePage extends HomePage{public TestHomePage() throws IOException {super();}
	
	@BeforeMethod
	public void initAndLogin() {
	 init(prop.getProperty("URL"));
	 LoginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void youAreInHomePageTest1(Method method) {
		assertTrue(youAreInHomePage(), "Error: you are not in home page");
	}
	
	@Test(priority = 2)
	public void youAreInHomePageTest2(Method method) {
		assertTrue(youAreInHomePage1(), "Error: you are not in home page");
	}
	@AfterMethod
	public void tearDown(Method method) throws IOException {
		TakeSnapShot.screenShot(method.getName());
		driver.quit();
	}	
}
