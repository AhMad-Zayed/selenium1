package com.crm.testpages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.core.TakeSnapShot;
import com.crm.pages.CompaniesPage;
import com.crm.pages.LoginPage;

public class TestCompaniesPage extends CompaniesPage {public TestCompaniesPage() throws IOException {super();}
	  
	
	@BeforeMethod
	public void beforeMethod() {
		init(prop.getProperty("URL"));
		LoginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	  }
	
	@Test(priority = 1)
	public void newCompanyTest(Method method) {
	 
		moiveToCompanies();
		assertTrue(newCompany(),"Error you are not in new Company page");
	}
	
	@Test(priority = 2)
	public void combinedFormTest(Method method) {
		 moiveToCompanies();
		 assertTrue(combinedForm(), "Error you are not in combined Form page");
		  
	}
	
	@Test(priority = 3)
	public void fullSearchFormTest(Method method) {
		  moiveToCompanies(); 
		  assertTrue(fullSearchForm(), "Error you are not in full Search Form page");
		}


  


@AfterMethod
public void afterMethod(Method method) throws IOException {
  TakeSnapShot.screenShot(method.getName());
	driver.quit();
}

}
