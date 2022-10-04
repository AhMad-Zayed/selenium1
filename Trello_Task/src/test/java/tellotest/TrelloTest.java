package tellotest;

import org.testng.annotations.Test;

import browsersDefinitions.Browsers;
import net.bytebuddy.asm.Advice.Enter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

public class TrelloTest {
	  Browsers  browser = new Browsers();
	 
  @Test(priority = 1)
  public void loginAccount() throws InterruptedException {
	
	  browser.chrome.findElement(By.linkText("Log in")).click();
	  browser.chrome.findElement(By.xpath("//input[@id='user']")).sendKeys("tcc.teach@gmail.com");
	  browser.chrome.findElement(By.xpath("//input[@value='Continue']")).click();
	  Thread.sleep(5000);
	  browser.chrome.findElement(By.xpath("//input[@name='password']")).sendKeys("ahmad123");
	  browser.chrome.findElement(By.id("login-submit")).click();
	  Thread.sleep(5000);
	
  }
  
//  @Test(priority = 2)
//  public void creat_new_board() throws InterruptedException {
//	  browser.chrome.findElement(By.xpath("//div[@class='board-tile mod-add']")).click();
//	  Thread.sleep(5000);
//	 WebElement board=  browser.chrome.findElement(By.xpath("//input[@data-test-id='create-board-title-input']"));
//	 board.sendKeys("Selenium");
//	 board.sendKeys(Keys.ENTER);
//  }
//  
  @Test(priority = 3)
  public void boardEnterAndCreateList() throws InterruptedException {
	  browser.chrome.findElement(By.xpath("//div[@title='Selenium']")).click();
	  Thread.sleep(5000);
	  browser.chrome.findElement(By.xpath("//*[@id=\"board\"]/div[1]/div/div[3]/a[@Class='open-card-composer js-open-card-composer']")).click();
	 WebElement card=  browser.chrome.findElement(By.xpath("//textarea[@Class='list-card-composer-textarea js-card-title']"));
	 card.sendKeys("Upload File");
	 card.sendKeys(Keys.INSERT);
	 browser.chrome.findElement(By.id("trello-root")).click();
	 Thread.sleep(5000);
	
  }
  
  @Test(priority = 4)
  public void uploadFile() throws InterruptedException {
	  browser.chrome.findElement(By.xpath("//span[@Class='list-card-title js-card-name']")).click();
	  Thread.sleep(5000);
	  browser.chrome.findElement(By.xpath("//a[@title=\"Attachment\"]")).click();
	  Thread.sleep(5000);
	  browser.chrome.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\User\\Desktop\\New Text Document.txt");

  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	  browser.chrome_initialize();
	  browser.chrome.get("https://trello.com/");
	  browser.chrome.manage().window().maximize();
//	  browser.fireFox_initialize();
//	  browser.firefox.get("https://trello.com/");
//	  browser.firefox.manage().window().maximize();
  }
}