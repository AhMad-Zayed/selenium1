package com.crm.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestBase {
public static WebDriver driver;
public Actions action;
public  Properties prop ;

	public TestBase() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\CRM\\src\\main\\java\\com\\crm\\config\\config. properties"); 
        prop = new Properties();
        prop.load(fis);
	}
	public void init(String URL) {
	       // driver = new FirefoxDriver ();
		driver = new ChromeDriver ();
	       // System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			action = new Actions(driver);
	}
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	

}
