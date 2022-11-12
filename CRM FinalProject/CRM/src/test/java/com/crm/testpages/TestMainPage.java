package com.crm.testpages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.core.TakeSnapShot;
import com.crm.pages.MainPage;




public class TestMainPage extends MainPage {
	public TestMainPage() throws IOException {
		super();

	}

	@Test()
	public void titleTest(Method method) {
		freeCRMtitle();
		assertEquals(acualTitle, expectedTitle);
		
		
	}

	@Test()
	public void urlTest(Method method){
		assertEquals(freeCRMgetURL(), prop.getProperty("URL"));
		
	
	}

	@Test()
	public void logoTest(Method method){
		assertTrue(displayedLogo());
		
		
	}
	
	@Test()
	public void enabledLoginButtonTest(Method method){
		assertTrue(freeCRMenabledLoginButton());
	
		
	
		
	}

	@BeforeClass
	public void beforeClass() {
		init(prop.getProperty("URL"));
	}
	
	@AfterMethod
	public void tearDown(Method method) throws IOException {
		TakeSnapShot.screenShot(method.getName());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}