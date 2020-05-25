import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProfileSettings {
	public static WebDriver driver;
	public static String baseUrl = "http://localhost:3000/sign-in";

	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"/home/yusayalcin/git/java-seleniumtest/java-seleniumtest/lib/chromedriver");
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
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(10000);

		WebElement settings = driver.findElement(By.xpath("//button[text()='Profili Düzenle']"));
		settings.click();
		Thread.sleep(5000);
		WebElement name = driver.findElement(By.name("name"));
		
		Thread.sleep(5000);
		name.clear();
		Thread.sleep(5000);

		name.sendKeys("burak");
		Thread.sleep(5000);

		WebElement save = driver.findElement(By.xpath("//button[text()='Kaydet']"));
		save.click();
		Thread.sleep(5000);

		//WebElement actualName = driver.findElement(By.name("name-surname"));
		//WebElement actualName = driver.findElement(By.xpath("//span[contains(@className, 'row font-18 font-weight-bold') and text()='burak Kara']"));

		//WebElement actualName = driver.findElement(By.xpath(".//span[contains(text(), 'burak Kara']"));
		//By actualName = By.xpath("//span[.='burak Kara']");
		String actualName = driver.findElement(By.xpath(
                "//*[@classname='row font-18 font-weight-bold']/.//span[contains(@name,'name-surname')]"))
           .getAttribute("innerHTML");
		System.out.println(actualName);
		String expectedName = "burak Kara";

		Thread.sleep(5000);

		System.out.println(actualName);
		Assert.assertEquals(expectedName, actualName);

	}
}