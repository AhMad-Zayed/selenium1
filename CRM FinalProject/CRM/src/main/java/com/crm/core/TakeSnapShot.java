package com.crm.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeSnapShot extends TestBase {

	public TakeSnapShot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void screenShot(String picName) throws IOException {
		//TakesScreenshot scrShot =((TakesScreenshot)this.driver);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,new File("C:\\Users\\User\\eclipse-workspace\\CRM\\ScreenShot\\"+picName+".png"));
	}
}
