import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forum {
	public static WebDriver driver;
	public static String baseUrl = "http://localhost:3000/sign-in";

	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"/home/yusayalcin/git/java-seleniumtest/java-seleniumtest/lib/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	private void patientLogin() {
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("burak.kara@ozu.edu.tr");
		password.sendKeys("111111");
		login.click();
	}

	@Test // Doctor list should be visible for patients
	public void checkPatientDoctorList() throws InterruptedException {
		driver();
		patientLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/forum/create");
		Thread.sleep(5000);

		WebElement title = driver.findElement(By.xpath("//div[@class='panel-body']/input"));
		WebElement text = driver.findElement(By.xpath("//div[@class='panel-body']/textarea"));

		Thread.sleep(5000);
		title.sendKeys("title");

		Thread.sleep(5000);
		text.sendKeys("text");

		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath("//button[text()='Post']"));
		save.click();
		Thread.sleep(5000);

		WebElement list = driver.findElement(By.xpath("//button[text()='List Posts']"));
		list.click();
		Thread.sleep(5000);

		WebElement titlePosted = driver.findElement(By.xpath("//div[@class='post-title']"));
		String actualTitle = titlePosted.getText();
		Thread.sleep(5000);

		WebElement textPosted = driver.findElement(By.xpath("//div[@class='post-body']"));
		String actualText = textPosted.getText();
		Thread.sleep(5000);

		String expectedTitle = "title";
		String expectedText = "text";

		Thread.sleep(5000);
		Assert.assertEquals(expectedTitle, actualTitle);
		Assert.assertEquals(expectedText, actualText);

	}
}
