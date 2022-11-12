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
import com.crm.pages.CallPage;
import com.crm.pages.LoginPage;

public class TestCallPage extends CallPage {
	public TestCallPage() throws IOException {
		super();
	}

	@BeforeMethod
	public void beforeMethod() {
		init(prop.getProperty("URL"));
		LoginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}

	@Test
	public void newCallStatusTest(Method method) {
		moveCallPage();
		goToCallPage();
		assertTrue(newCall(), "Error: you are not in newCall page");
	}

	@Test(dataProvider = "getData")
	public void newcallDataTest(String date, String reminderTime, String noteValue, String contactName,
			String companyName, String flagVal, String noteBox) {
		moveCallPage();
		goToCallPage();
		addNewCall(date, reminderTime, noteValue, contactName, companyName, flagVal, noteBox);

	}

	@AfterMethod
	public void afterMethod(Method method) throws IOException {
		TakeSnapShot.screenShot(method.getName());
		driver.quit();
	}

	@DataProvider
	public static Object[][] getData() throws Exception {

		List<String[]> lines = ReadCsvFile.readCsvFile("C:\\Users\\User\\Desktop\\CRMnewCallForm.csv");
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for (String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}
}
