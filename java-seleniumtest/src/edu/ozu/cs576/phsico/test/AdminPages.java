package edu.ozu.cs576.phsico.test;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminPages extends Main implements ITest {
	public static WebDriver driver;
	public static String baseUrl = "http://localhost:3000/sign-in";
	public static String Url = "http://localhost:3000/sign-up";


	public void driverSignin() {
		System.setProperty("webdriver.chrome.driver", "../java-seleniumtest/lib/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}
	public void driverSignup() {
		System.setProperty("webdriver.chrome.driver", "../Selenium/lib/chromedriver");
		driver = new ChromeDriver();
		driver.get(Url);
	}
	@Test
	public void checkDoctorList() throws InterruptedException {
		driverSignin();
		adminLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/all-doctors");
		Thread.sleep(5000);

		WebElement WebElement = driver.findElement(By.xpath("//*[contains(text(), 'arzu tarimci')]"));
		String actualDoctor = WebElement.getText();
		String expectedDoctor = "arzu tarimci";

		Assert.assertEquals(expectedDoctor, actualDoctor);
	}

	@Test
	public void checkPatientList() throws InterruptedException {
		driverSignin();
		adminLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/all-patients");
		Thread.sleep(5000);

		WebElement WebElement = driver.findElement(By.xpath("//*[contains(text(), 'behiye Tarimci')]"));
		String actualDoctor = WebElement.getText();
		String expectedDoctor = "behiye Tarimci";

		Assert.assertEquals(expectedDoctor, actualDoctor);
	}

	@Test // in each execution new mail should be entered
	public void createNewPatientAndDeleteFromAdmin() throws InterruptedException {
		driverSignup();
		WebElement name = driver.findElement(By.name("name"));
		WebElement surname = driver.findElement(By.name("surname"));
		WebElement username = driver.findElement(By.name("username"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement passwordOne = driver.findElement(By.name("passwordOne"));
		WebElement passwordTwo = driver.findElement(By.name("passwordTwo"));
		WebElement birthday = driver.findElement(By.name("birthday"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign Up']"));

		name.sendKeys("yuşa");
		surname.sendKeys("yalçın");
		username.sendKeys("yusayalcin");
		phone.sendKeys("56459");
		email.sendKeys("yusdfsafaaadaaadssddffaaadsa@ozu.edu.tr");
		passwordOne.sendKeys("Bk*1234.");
		passwordTwo.sendKeys("Bk*1234.");
		birthday.sendKeys("1990-01-01");
		Thread.sleep(5000);
		login.click();
		Thread.sleep(5000);

		driver.navigate().to(baseUrl);
		adminLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/all-patients");
		Thread.sleep(5000);

		
		WebElement myElement = driver.findElement(By.xpath("//*[contains(text(), 'yuşa yalçın')]"));
		WebElement parent = myElement.findElement(By.xpath("./../following-sibling::div[@class='col-3 ban']/button[text()='Delete User']"));
		parent.click();
		Thread.sleep(5000);

		WebElement delete = driver.findElement(By.id("delete"));
		//WebElement delete = driver.findElement(By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing']/button[text()='Delete "));

		delete.click();
		Thread.sleep(5000);

		boolean admin = (boolean) (driver.findElements(By.xpath("//*[contains(text(), 'yuşa yalçın')]")).size() != 0);

		
		assertFalse("false", admin);
		
	}

	private void adminLogin() {
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("bk260597@gmail.com");
		password.sendKeys("Bk*1234.");
		login.click();
	}
	@Override
	public void run(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
}