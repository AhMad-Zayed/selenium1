package com.crm.testpages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.core.TakeSnapShot;
import com.crm.pages.LoginPage;

public class TestLoginPage extends LoginPage {
  public TestLoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@BeforeMethod
public void openBrowser() {
	init(prop.getProperty("URL"));
}
@Test
  public void loginTest(Method method) {
	login(prop.getProperty("userName"),prop.getProperty("password"));
	assertTrue(loginStatus(), "Error: you cant login");
  }

@Test
public void loginTest2(Method method) {

	login(prop.getProperty("test1USR"),prop.getProperty("test1Pass"));
	assertTrue(loginFalseStatus(), "Error: you should not login");
}

@Test
public void loginTest3(Method method)  {
	
	login(prop.getProperty("test2USR"),prop.getProperty("test2Pass"));
	assertTrue(loginFalseStatus(), "Error: you should not login");
}


@Test
public void loginTest4(Method method) {

	login(prop.getProperty("test3USR"),prop.getProperty("test3Pass"));
	assertTrue(loginFalseStatus(), "Error: you should not login");
}


@AfterMethod
public void tearDown(Method method) throws IOException {
	TakeSnapShot.screenShot(method.getName());
	driver.quit();
}





}


