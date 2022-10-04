package browsersDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {
	public WebDriver chrome;
	public WebDriver firefox;
	public WebDriver edge;
	
  public void chrome_initialize() {
	 chrome = new ChromeDriver();
  }
  
  public void fireFox_initialize() {
	  firefox = new FirefoxDriver();
  }
  
  public void edge_initialize() {
	  edge = new EdgeDriver();
  }
  
  


	public static void main(String[] args) {
		Browsers  browser = new Browsers();
		//chrome
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		browser.chrome_initialize();
		browser.chrome.get("https://www.youtube.com/watch?v=GwvBwGOo-nQ");
		//forefox
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		browser.fireFox_initialize();
		browser.firefox.get("https://www.youtube.com/watch?v=GwvBwGOo-nQ");
		//edge
		System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
		browser.edge_initialize();
		browser.edge.get("https://www.youtube.com/watch?v=GwvBwGOo-nQ");
	}

}


