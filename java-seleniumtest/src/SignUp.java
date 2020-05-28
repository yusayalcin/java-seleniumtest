import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/***
 * 
 * @author Yusa Yalcin
 *
 */
public class SignUp {
	public static WebDriver driver;
	public static String baseUrl = "http://localhost:3000/sign-up";

	public void driver() {

		System.setProperty("webdriver.chrome.driver",
				"/home/yusayalcin/git/java-seleniumtest/java-seleniumtest/lib/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test // Can't signup because of existing email
	public void signUpWithExistingEmail() throws InterruptedException {
		driver();
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
		phone.sendKeys("111111");
		email.sendKeys("burak.kara@ozu.edu.tr");
		passwordOne.sendKeys("123.qQ");
		passwordTwo.sendKeys("123.qQ");
		birthday.sendKeys("1990-01-01");
		Thread.sleep(5000);

		login.click();
		String actualUrl = "http://localhost:3000/";
		Thread.sleep(5000);

		String expectedUrl = driver.getCurrentUrl();

		assertThat(expectedUrl, not(actualUrl));
	}

	@Test // Can't signup because username is missing
	public void signUpWithoutUsername() throws InterruptedException {
		driver();
		WebElement name = driver.findElement(By.name("name"));
		WebElement surname = driver.findElement(By.name("surname"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement passwordOne = driver.findElement(By.name("passwordOne"));
		WebElement passwordTwo = driver.findElement(By.name("passwordTwo"));
		WebElement birthday = driver.findElement(By.name("birthday"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign Up']"));

		name.sendKeys("yuşa");
		surname.sendKeys("yalçın");
		phone.sendKeys("111111");
		email.sendKeys("yusa.yalcin@ozu.edu.tr");
		passwordOne.sendKeys("123.qQ");
		passwordTwo.sendKeys("123.qQ");
		birthday.sendKeys("1990-01-01");
		Thread.sleep(5000);

		login.click();
		String actualUrl = "http://localhost:3000";

		String expectedUrl = driver.getCurrentUrl();

		assertThat(expectedUrl, not(actualUrl));
	}

	@Test // Can't signup because password is missing
	public void signUpWithoutPasswordOne() throws InterruptedException {
		driver();
		WebElement name = driver.findElement(By.name("name"));
		WebElement surname = driver.findElement(By.name("surname"));
		WebElement username = driver.findElement(By.name("username"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement passwordTwo = driver.findElement(By.name("passwordTwo"));
		WebElement birthday = driver.findElement(By.name("birthday"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign Up']"));

		name.sendKeys("yuşa");
		surname.sendKeys("yalçın");
		username.sendKeys("yusayalcin");
		phone.sendKeys("111111");
		email.sendKeys("yusa.yalcin@ozu.edu.tr");
		passwordTwo.sendKeys("123.qQ");
		birthday.sendKeys("1990-01-01");
		Thread.sleep(5000);

		login.click();
		String actualUrl = "http://localhost:3000";

		String expectedUrl = driver.getCurrentUrl();

		assertThat(expectedUrl, not(actualUrl));
	}

	@Test // Can't signup because email is missing
	public void signUpWithoutEmail() throws InterruptedException {
		driver();
		WebElement name = driver.findElement(By.name("name"));
		WebElement surname = driver.findElement(By.name("surname"));
		WebElement username = driver.findElement(By.name("username"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement passwordOne = driver.findElement(By.name("passwordOne"));
		WebElement passwordTwo = driver.findElement(By.name("passwordTwo"));
		WebElement birthday = driver.findElement(By.name("birthday"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign Up']"));

		name.sendKeys("yuşa");
		surname.sendKeys("yalçın");
		username.sendKeys("yusayalcin");
		phone.sendKeys("111111");
		passwordOne.sendKeys("123.qQ");
		passwordTwo.sendKeys("123.qQ");
		birthday.sendKeys("1990-01-01");
		Thread.sleep(5000);

		login.click();
		String actualUrl = "http://localhost:3000";

		String expectedUrl = driver.getCurrentUrl();

		assertThat(expectedUrl, not(actualUrl));
	}

	@Test // Can't signup because birthday is missing
	public void signUpWithoutBirthday() throws InterruptedException {
		driver();
		WebElement name = driver.findElement(By.name("name"));
		WebElement surname = driver.findElement(By.name("surname"));
		WebElement username = driver.findElement(By.name("username"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement passwordOne = driver.findElement(By.name("passwordOne"));
		WebElement passwordTwo = driver.findElement(By.name("passwordTwo"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Sign Up']"));

		name.sendKeys("yuşa");
		surname.sendKeys("yalçın");
		username.sendKeys("yusayalcin");
		phone.sendKeys("111111");
		email.sendKeys("yusargrge.yalcin@ozu.edu.tr");
		passwordOne.sendKeys("123.qQ");
		passwordTwo.sendKeys("123.qQ");
		Thread.sleep(5000);

		login.click();
		String actualUrl = "http://localhost:3000";

		String expectedUrl = driver.getCurrentUrl();

		assertThat(expectedUrl, not(actualUrl));
	}

	@Test // Can't signup because user is younger than 18
	public void signUpYoungerThan18() {
		driver();
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
		phone.sendKeys("111111");
		email.sendKeys("yusa.yalcin@ozu.edu.tr");
		passwordOne.sendKeys("123.qQ");
		passwordTwo.sendKeys("123.qQ");
		birthday.sendKeys("2002-01-01");

		login.click();
		String actualUrl = "http://localhost:3000";

		String expectedUrl = driver.getCurrentUrl();

		assertThat(expectedUrl, not(actualUrl));
	}

	@Test // Can't signup because password and confirm password is not same
	public void signUpWithNotEqualPasswords() {
		driver();
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
		phone.sendKeys("111111");
		email.sendKeys("yusa.yalcin@ozu.edu.tr");
		passwordOne.sendKeys("123.qQ");
		passwordTwo.sendKeys("123");
		birthday.sendKeys("1990-01-01");

		login.click();
		String actualUrl = "http://localhost:3000";

		String expectedUrl = driver.getCurrentUrl();

		assertThat(expectedUrl, not(actualUrl));
	}

	@Test // in each execution new mail should be entered
	public void signUp() throws InterruptedException {
		driver();
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
		email.sendKeys("yusdfsa@ozu.edu.tr");
		passwordOne.sendKeys("123.qQqq");
		passwordTwo.sendKeys("123.qQqq");
		birthday.sendKeys("1990-01-01");
		Thread.sleep(5000);
		login.click();
		String actualUrl = "http://localhost:3000/";
		Thread.sleep(5000);

		String expectedUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actualUrl);
	}
}
