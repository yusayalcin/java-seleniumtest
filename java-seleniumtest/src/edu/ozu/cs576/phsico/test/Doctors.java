package edu.ozu.cs576.phsico.test;

import org.openqa.selenium.WebDriver;

public class Doctors implements ITest {
	/**
	 * purpose : bu class 1 doktorun yapabilecegi tum islemleri test eder. login ,
	 * rezervasyon ekrani goruntuleme, meeting, profile ekrani
	 */
	private Signin login = new Signin();
	private ProfileSettings ps = new ProfileSettings();

	@Override
	public void run(WebDriver _driver) {
		System.out.println("Doctor Test Cases are started.");
		// ogin.run(_driver);
		ps.run(_driver);
		try {
			ps.changeNameSurnameOfDoctor();
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

		System.out.println("Doctor Test Cases are completed.");

	}

}
