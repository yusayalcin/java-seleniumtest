package edu.ozu.cs576.phsico.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProfileSettings implements ITest {
	private static final String PROFILE_BUTTON = "//button[text()='Profili Düzenle']";
	private static final String KAYDET_BUTTON = "//button[text()='Kaydet']";
	public static WebDriver driver;
	public static String baseUrl = "http://localhost:3000/sign-in";

	public void driver() {
		if (this.driver != null)
			return;
		System.setProperty("webdriver.chrome.driver",
				"/home/yusayalcin/git/java-seleniumtest/java-seleniumtest/lib/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	public void changeNameSurnameOfPatient() throws InterruptedException {
		driver();
		patientLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(10000);

		WebElement settings = driver.findElement(By.xpath(PROFILE_BUTTON));
		settings.click();
		Thread.sleep(5000);
		WebElement name = driver.findElement(By.name("name"));
		WebElement surname = driver.findElement(By.name("surname"));

		Thread.sleep(5000);
		name.clear();
		Thread.sleep(5000);
		name.sendKeys("burak");

		Thread.sleep(5000);
		surname.clear();
		Thread.sleep(5000);
		surname.sendKeys("kara");

		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath(KAYDET_BUTTON));
		save.click();
		Thread.sleep(5000);

		WebElement WebElement = driver.findElement(By.xpath("//div[@class='row font-18 font-weight-bold']"));
		String actualName = WebElement.getText();
		String expectedName = "burak kara";

		Thread.sleep(5000);
		Assert.assertEquals(expectedName, actualName);
	}

	@Test
	public void changeDescriptionOfPatient() throws InterruptedException {
		driver();
		patientLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(10000);

		WebElement settings = driver.findElement(By.xpath("//button[text()='Profili Düzenle']"));
		settings.click();
		Thread.sleep(5000);
		WebElement description = driver.findElement(By.id("description"));

		Thread.sleep(5000);
		description.clear();
		Thread.sleep(5000);

		description.sendKeys("test123");
		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath("//button[text()='Kaydet']"));
		save.click();
		Thread.sleep(5000);

		WebElement WebElement = driver.findElement(By.xpath("//div[@class='row mt-2 h-auto']"));
		String actualDescription = WebElement.getText();
		String expectedDescription = "test123";

		Thread.sleep(5000);
		Assert.assertEquals(expectedDescription, actualDescription);
	}

	public void changeLocationOfPatient() throws InterruptedException {
		driver();
		patientLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(10000);

		WebElement settings = driver.findElement(By.xpath("//button[text()='Profili Düzenle']"));
		settings.click();
		Thread.sleep(5000);
		WebElement location = driver.findElement(By.id("location"));

		Thread.sleep(5000);
		location.clear();
		Thread.sleep(5000);

		location.sendKeys("Ankara");
		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath("//button[text()='Kaydet']"));
		save.click();
		Thread.sleep(5000);

		WebElement WebElement = driver
				.findElement(By.xpath("//div[@class='row text-capitalize']/div/span[@class='align-middle ml-1']"));
		String actualLocation = WebElement.getText();
		String expectedLocation = "Ankara";

		Thread.sleep(5000);
		Assert.assertEquals(expectedLocation, actualLocation);
	}

	public void changeBirthdayOfPatient() throws InterruptedException {
		driver();
		patientLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(10000);

		WebElement settings = driver.findElement(By.xpath("//button[text()='Profili Düzenle']"));
		settings.click();
		Thread.sleep(5000);
		WebElement birthday = driver.findElement(By.id("birthday"));

		Thread.sleep(5000);
		birthday.clear();
		Thread.sleep(5000);

		birthday.sendKeys("01/01/1990");
		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath("//button[text()='Kaydet']"));
		save.click();
		Thread.sleep(5000);

		WebElement WebElement = driver.findElement(
				By.xpath("//div[@class='row']/div[@class='col-12 no-padding']/span[@class='align-middle ml-1']"));
		String actualBirthday = WebElement.getText();
		String expectedBirthday = "01.01.1990";

		Thread.sleep(5000);
		Assert.assertEquals(expectedBirthday, actualBirthday);
	}

	public void changeNameSurnameOfDoctor() throws InterruptedException {
		driver();
		doctorLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(10000);

		WebElement settings = driver.findElement(By.xpath("//button[text()='Profili Düzenle']"));
		settings.click();
		Thread.sleep(5000);
		WebElement name = driver.findElement(By.name("name"));
		WebElement surname = driver.findElement(By.name("surname"));

		Thread.sleep(5000);
		name.clear();
		Thread.sleep(5000);
		name.sendKeys("doctor");

		Thread.sleep(5000);
		surname.clear();
		Thread.sleep(5000);
		surname.sendKeys("strange");

		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath("//button[text()='Kaydet']"));
		save.click();
		Thread.sleep(5000);

		WebElement WebElement = driver.findElement(By.xpath("//div[@class='row font-18 font-weight-bold']"));
		String actualName = WebElement.getText();
		String expectedName = "doctor strange";

		Thread.sleep(5000);
		Assert.assertEquals(expectedName, actualName);
	}

	public void changeDescriptionOfDoctor() throws InterruptedException {
		driver();
		doctorLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(10000);

		WebElement settings = driver.findElement(By.xpath("//button[text()='Profili Düzenle']"));
		settings.click();
		Thread.sleep(5000);
		WebElement description = driver.findElement(By.id("description"));

		Thread.sleep(5000);
		description.clear();
		Thread.sleep(5000);

		description.sendKeys(
				"I have worked in mental health and been practicing CBT since 2005, helping both adults and children suffering from depression, anxiety, and symptoms of trauma.");
		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath("//button[text()='Kaydet']"));
		save.click();
		Thread.sleep(5000);

		WebElement WebElement = driver.findElement(By.xpath("//div[@class='row mt-2 h-auto']"));
		String actualDescription = WebElement.getText();
		String expectedDescription = "I have worked in mental health and been practicing CBT since 2005, helping both adults and children suffering from depression, anxiety, and symptoms of trauma.";

		Thread.sleep(5000);
		Assert.assertEquals(expectedDescription, actualDescription);
	}

	public void changeLocationOfDoctor() throws InterruptedException {
		driver();
		doctorLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(10000);

		WebElement settings = driver.findElement(By.xpath("//button[text()='Profili Düzenle']"));
		settings.click();
		Thread.sleep(5000);
		WebElement location = driver.findElement(By.id("location"));

		Thread.sleep(5000);
		location.clear();
		Thread.sleep(5000);

		location.sendKeys("Ankara");
		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath("//button[text()='Kaydet']"));
		save.click();
		Thread.sleep(5000);

		WebElement WebElement = driver
				.findElement(By.xpath("//div[@class='row text-capitalize']/div/span[@class='align-middle ml-1']"));
		String actualLocation = WebElement.getText();
		String expectedLocation = "Ankara";

		Thread.sleep(5000);
		Assert.assertEquals(expectedLocation, actualLocation);
	}

	public void changeBirhdayOfDoctor() throws InterruptedException {
		driver();
		doctorLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(10000);

		WebElement settings = driver.findElement(By.xpath("//button[text()='Profili Düzenle']"));
		settings.click();
		Thread.sleep(5000);
		WebElement birthday = driver.findElement(By.id("birthday"));

		Thread.sleep(5000);
		birthday.clear();
		Thread.sleep(5000);

		birthday.sendKeys("01/01/1990");
		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath("//button[text()='Kaydet']"));
		save.click();
		Thread.sleep(5000);

		WebElement WebElement = driver.findElement(
				By.xpath("//div[@class='row']/div[@class='col-12 no-padding']/span[@class='align-middle ml-1']"));
		String actualBirthday = WebElement.getText();
		String expectedBirthday = "01.01.1990";

		Thread.sleep(5000);
		Assert.assertEquals(expectedBirthday, actualBirthday);
	}

	private void patientLogin() {
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("burak.kara@ozu.edu.tr");
		password.sendKeys("111111");
		login.click();
	}

	private void doctorLogin() {
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("bk.kaara@gmail.com");
		password.sendKeys("111111");
		login.click();
	}

	@Override
	public void run(WebDriver _driver) {
		this.driver = _driver;

	}

	public void signout() {
		System.out.println("Signout processing ");
	try {
		driver.findElement(By.id("signout")).click();
	} catch (Exception e) {
		
	}
		sleep();
	}

	//FIXMe baska class a tasi
	private void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}