package com.crm.testpages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.core.ReadCsvFile;
import com.crm.core.TakeSnapShot;
import com.crm.pages.ContactsPage;
import com.crm.pages.LoginPage;





public class TestContactsPage extends ContactsPage{public TestContactsPage() throws IOException {super();}

	@BeforeMethod
	public void beforeMethod() {
		init(prop.getProperty("URL"));
		LoginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
  }
			
	@Test(priority = 1)
	public void newContactsTest(Method method) {
	 
		moiveToContacts();
		goToNewContacts();
		assertTrue(newContacts(),"Error you are not in new Contacts page");
	}
	
	@Test(dataProvider="getData")
	public void addContactTest(Method method,String titleV,String fName,
			String mName,String lName,String suffixV,String
			nName,String cName,String pType,String pNumber) {
		
		addContact(titleV, fName, mName, lName, suffixV,nName, cName, pType, pNumber);
		
	}
	
	@AfterMethod
	public void afterMethod(Method method) throws IOException {
	  TakeSnapShot.screenShot(method.getName());
		driver.quit();
	}
		
@DataProvider
public static Object[][] getData() throws Exception{

	List<String[]> lines = ReadCsvFile.readCsvFile("C:\\Users\\User\\Desktop\\CRMcontactForm.csv");
	lines.remove(0);
	Object[][] data = new Object[lines.size()][lines.get(0).length];
	int index = 0;
	for(String[] line : lines) {
		data[index] = line;
		index++;
	}
	return data;
	
	
	
	
	
}

}
