package testngBooking;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import readFile.ReadWriteExcelFile;

public class BookingTest {
	WebDriver driver;
	JavascriptExecutor js;

	@BeforeClass
	public void openbrowser() {
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxOptions option = new FirefoxOptions();
        option.setProfile(profile);
        option.setHeadless(true);
		driver = new FirefoxDriver(option);
		js = (JavascriptExecutor) driver;
		driver.get("https://www.hotels.com/");
		//driver.manage().window().maximize();
		
	}

	@Test(dataProvider = "testData")
	public void setWhereToGo(String city, String checkIn, String checkOut) throws IOException {

		WebElement stratDate, endDate;
		String hotelName, reviewNum, reviewText, review;
		
		driver.findElement(By.xpath("//button[@aria-label='Going to']")).click();
		driver.findElement(By.id("destination_form_field")).sendKeys(city);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(
				"//button[@class='uitk-button uitk-button-medium uitk-button-fullWidth uitk-button-typeahead uitk-type-left has-subtext']"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 stratDate = driver.findElement(By.name("EGDSDateRangePicker-StartDate-date_form_field"));
		 endDate = driver.findElement(By.name("EGDSDateRangePicker-EndDate-date_form_field"));
		js.executeScript("arguments[0].setAttribute('value','" + checkIn + "');", stratDate);
		js.executeScript("arguments[0].setAttribute('value','" + checkOut + "');", endDate);

		driver.findElement(By.id("submit_button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Allure.addAttachment("Hotel Name", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
		 hotelName = driver.findElement(By.xpath("//h2[@Class='uitk-heading uitk-heading-5 overflow-wrap']")).getText();
		reviewNum = driver
				.findElement(
						By.xpath("//span[@class='uitk-text uitk-type-300 uitk-type-bold uitk-text-default-theme']"))
				.getText();
		 reviewText = driver.findElement(By.xpath("//span[2][@Class='uitk-spacing uitk-spacing-padding-inlineend-one']"))
				.getText();
		 review = reviewNum + " " + reviewText;
		Allure.addAttachment("Hotel Page", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

		ReadWriteExcelFile.writeFile(city, checkIn, checkOut, hotelName, review);

	}
	
	@BeforeMethod
	void before() {

		driver.get("https://hotels.com");
	}
	@AfterClass
	void quitdriver() throws IOException {
		driver.quit();

	}

	

	@DataProvider
	Object[][] testData() throws IOException {
		Object data[][] = ReadWriteExcelFile.readExceFile(".//Input-Output-Data//input-output-BookingTest.xlsx",
				"input");
		return data;
	}
}
