package edu.ozu.cs576.phsico.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainWebDriver {
	
	public MainWebDriver() {
		
	}
	
	public static WebDriver driver;

	public static String baseUrl = Configuration.URL_BASE;

	public WebDriver driver() {
		System.setProperty("webdriver.chrome.driver", Configuration.CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		return driver;

	}
}
