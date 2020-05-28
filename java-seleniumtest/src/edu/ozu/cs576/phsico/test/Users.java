package edu.ozu.cs576.phsico.test;

import org.openqa.selenium.WebDriver;

/**
 * purpose : bu class 1 kullanicinin yapabilecegi tum islemleri test eder. login
 * , rezervasyon ekrani goruntuleme, meeting, makale gosterimi, profile ekrani
 * ve logout
 */
public class Users implements ITest {

	/**
	 * purpose : bu class 1 kullanicinin yapabilecegi tum islemleri test eder. login
	 * , rezervasyon ekrani goruntuleme, , profile ekrani
	 */
	private Signin login = new Signin();
	private ProfileSettings ps = new ProfileSettings();

	@Override
	public void run(WebDriver _driver) {
		System.out.println("User Test Cases are started.");
		// ogin.run(_driver);
		ps.run(_driver);
		try {
			ps.changeNameSurnameOfPatient();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Reservation reservation = new Reservation();
		reservation.run(_driver);
		try {
			reservation.goToReservation();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// ps.signout();

		System.out.println("User Test Cases are completed.");

	}
}