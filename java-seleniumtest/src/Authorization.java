import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authorization {
	public static WebDriver driver;
	public static String baseUrl = "http://localhost:3000/sign-in";

	public void driver() {
		System.setProperty("webdriver.chrome.driver",
				"/home/yusayalcin/eclipse-workspace/FrontEndTest/lib/chromedriver");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test // Doctor list should be visible for patients
	public void checkPatientDoctorList() throws InterruptedException {
		driver();
		patientLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/doctors");
		Thread.sleep(5000);

		boolean doctor = (boolean) (driver.findElements(By.className("doctor-list")).size() != 0);
		System.out.println(doctor);
		assertTrue("true", doctor);
	}

	@Test // Doctor list should not be visible for doctors
	public void checkDoctorDoctorList() throws InterruptedException {
		driver();
		doctorLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/doctors");
		Thread.sleep(5000);

		boolean doctor = (boolean) (driver.findElements(By.className("doctor-list")).size() != 0);
		assertFalse("false", doctor);
	}

	@Test // Doctor list should not be visible for admin
	public void checkAdminDoctorList() throws InterruptedException {
		driver();
		adminLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/doctors");
		Thread.sleep(5000);

		boolean doctor = (boolean) (driver.findElements(By.className("doctor-list")).size() != 0);
		assertFalse("false", doctor);
	}

	@Test // Meeting should not be visible for admin
	public void checkAdminMeeting() throws InterruptedException {
		driver();
		adminLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/meeting");
		Thread.sleep(5000);

		boolean meeting = (boolean) (driver.findElements(By.className("meeting-container")).size() != 0);
		assertFalse("false", meeting);
	}

	@Test // Admin page should not be visible for patients
	public void checkAdminPageWithPatient() throws InterruptedException {
		driver();
		patientLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/admin");
		Thread.sleep(5000);

		boolean admin = (boolean) (driver.findElements(By.id("admin-page")).size() != 0);
		assertFalse("false", admin);
	}

	@Test // Admin page should not be visible for doctors
	public void checkAdminPageWithDoctor() throws InterruptedException {
		driver();
		doctorLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/admin");
		Thread.sleep(5000);

		boolean admin = (boolean) (driver.findElements(By.id("admin-page")).size() != 0);
		assertFalse("false", admin);
	}

	@Test // Password policy page should not be visible for patients
	public void checkPasswordPolicyPageWithPatient() throws InterruptedException {
		driver();
		patientLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/password-policy");
		Thread.sleep(5000);

		boolean admin = (boolean) (driver.findElements(By.id("admin-page")).size() != 0);
		assertFalse("false", admin);
	}

	@Test // Password policy page should not be visible for doctors
	public void checkPasswordPolicyPageWithDoctor() throws InterruptedException {
		driver();
		doctorLogin();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/password-policy");
		Thread.sleep(5000);

		boolean admin = (boolean) (driver.findElements(By.id("admin-page")).size() != 0);
		assertFalse("false", admin);
	}

	@Test // Meeting should not be visible for Unauthorized
	public void checkUnauthorizedMeeting() throws InterruptedException {
		driver();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/meeting");
		Thread.sleep(5000);

		boolean meeting = (boolean) (driver.findElements(By.className("meeting-container")).size() != 0);
		assertFalse("false", meeting);
	}

	@Test // Meeting should not be visible for Unauthorized
	public void checkUnauthorizedProfile() throws InterruptedException {
		driver();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/profile");
		Thread.sleep(5000);

		boolean profile = (boolean) (driver.findElements(By.className("meeting-container")).size() != 0);
		assertFalse("false", profile);
	}

	@Test // profile should not be visible for Unauthorized
	public void checkUnauthorizedForum() throws InterruptedException {
		driver();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/forum");
		Thread.sleep(5000);

		boolean forum = (boolean) (driver.findElements(By.className("meeting-container")).size() != 0);
		assertFalse("false", forum);
	}

	@Test // Reservation should not be visible for Unauthorized
	public void checkUnauthorizedReservation() throws InterruptedException {
		driver();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/reservations");
		Thread.sleep(5000);

		boolean reservations = (boolean) (driver.findElements(By.className("meeting-container")).size() != 0);
		assertFalse("false", reservations);
	}

	@Test // doctors should not be visible for Unauthorized
	public void checkUnauthorizedDoctors() throws InterruptedException {
		driver();
		Thread.sleep(5000);

		driver.navigate().to("http://localhost:3000/doctors");
		Thread.sleep(5000);

		boolean doctors = (boolean) (driver.findElements(By.className("meeting-container")).size() != 0);
		assertFalse("false", doctors);
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

	private void adminLogin() {
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Submit']"));
		username.sendKeys("bk260597@gmail.com");
		password.sendKeys("Bk1234.");
		login.click();
	}
}