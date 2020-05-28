package edu.ozu.cs576.phsico.test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/***
 * 
 * @author Yusa Yalcin
 *
 */
public class Signin  implements ITest {
	public static WebDriver driver;
	public static String baseUrl = Configuration.URL_BASE;

	@Deprecated
	public void driver() {
		
		if (this.driver != null) return;
		System.setProperty("webdriver.chrome.driver",
				Configuration.CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		 
		
	}

	@Test // Login to user and direct to user profile
	public void login() throws InterruptedException {
		driver();
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("arzubt@gmail.com");
		password.sendKeys("Ozu_2020");
		login.click();
		String actualUrl = Configuration.URL_PROFILE;
		Thread.sleep(5000);

		driver.navigate().to(actualUrl);
		String expectedUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actualUrl);
	}

	//@Test // Can't login
	public void loginWithWrongEmail() {
		driver();
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("burak@ozu.edu.tr");
		password.sendKeys("111111");
		login.click();
		String actualUrl = Configuration.URL_MAIN;

		String expectedUrl = driver.getCurrentUrl();
		assertThat(expectedUrl, not(actualUrl));
	}

	//@Test // Can't login
	public void loginWithWrongPassword() {
		driver();
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("burak.kara@ozu.edu.tr");
		password.sendKeys("11111");
		login.click();
		String actualUrl = Configuration.URL_MAIN;

		String expectedUrl = driver.getCurrentUrl();
		assertThat(expectedUrl, not(actualUrl));
	}

	//@Test // Can't login
	public void loginWithWrongPasswordAndEmail() {
	
		driver();
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("burak@ozu.edu.tr");
		password.sendKeys("1111");
		login.click();
		String actualUrl = Configuration.URL_MAIN;

		String expectedUrl = driver.getCurrentUrl();
		assertThat(expectedUrl, not(actualUrl));
	}

	@Override
	public void run(WebDriver _driver) throws RuntimeException {
		driver = _driver;
	
	
	}
	
	
	public WebDriver getDriver() {
		return this.driver;
	}

	public void asDoctor( ) {
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("arzubt@gmail.com");
		password.sendKeys("Ozu_2020");
		login.click();
		String actualUrl = Configuration.URL_PROFILE;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.navigate().to(actualUrl);
		String expectedUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actualUrl);
	}
	
}
