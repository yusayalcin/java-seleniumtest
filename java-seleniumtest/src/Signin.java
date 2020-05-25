import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Signin {
	public static WebDriver driver;
	public static String baseUrl = "http://localhost:3000/sign-in";

	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"/home/yusayalcin/eclipse-workspace/FrontEndTest/lib/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test // Login to user and direct to user profile
	public void login() throws InterruptedException {
		driver();
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("burak.kara@ozu.edu.tr");
		password.sendKeys("111111");
		login.click();
		String actualUrl = "http://localhost:3000/profile";
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		String expectedUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println(expectedUrl);
	}

	@Test // Can't login
	public void loginWithWrongEmail() {
		driver();
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("burak@ozu.edu.tr");
		password.sendKeys("111111");
		login.click();
		String actualUrl = "http://localhost:3000";

		String expectedUrl = driver.getCurrentUrl();
		assertThat(expectedUrl, not(actualUrl));
	}

	@Test // Can't login
	public void loginWithWrongPassword() {
		driver();
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("burak.kara@ozu.edu.tr");
		password.sendKeys("11111");
		login.click();
		String actualUrl = "http://localhost:3000";

		String expectedUrl = driver.getCurrentUrl();
		assertThat(expectedUrl, not(actualUrl));
	}

	@Test // Can't login
	public void loginWithWrongPasswordAndEmail() {
		driver();
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("burak@ozu.edu.tr");
		password.sendKeys("1111");
		login.click();
		String actualUrl = "http://localhost:3000";

		String expectedUrl = driver.getCurrentUrl();
		assertThat(expectedUrl, not(actualUrl));
	}
}
