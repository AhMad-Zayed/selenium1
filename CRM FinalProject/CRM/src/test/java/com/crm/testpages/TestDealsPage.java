package com.crm.testpages;

import org.testng.annotations.Test;

import com.crm.core.TakeSnapShot;
import com.crm.pages.DealsPage;
import com.crm.pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;

public class TestDealsPage extends DealsPage {  public TestDealsPage() throws IOException {super();}


@BeforeMethod
  public void beforeMethod() {
	init(prop.getProperty("URL"));
	LoginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	  }

  @Test
  public void newDealStatusTest(Method method) {
	  moveToDeal();
	  goToDeal();
	  assertTrue(newDeal(), "Error: you are not in newDeal page");
  }
 
  @AfterMethod
  public void afterMethod(Method method) throws IOException {
	  TakeSnapShot.screenShot(method.getName());
		driver.quit();
  }
  

}
