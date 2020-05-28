package edu.ozu.cs576.phsico.test;

import org.openqa.selenium.WebDriver;

public class Reservation extends  Main implements ITest {
	WebDriver driver;
	
	public void goToReservation() throws InterruptedException {
	
		Thread.sleep(5000);

		driver.navigate().to(Configuration.URL_RESERVATION);
		Thread.sleep(10000);
	}

	@Override
	public void run(WebDriver _driver) {
		// TODO Auto-generated method stub
		this.driver = _driver;
	}

}
