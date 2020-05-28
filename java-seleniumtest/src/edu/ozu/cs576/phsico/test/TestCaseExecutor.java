package edu.ozu.cs576.phsico.test;

import java.util.List;

public class TestCaseExecutor {
	static MainWebDriver maindriver;

	public void run() {
		TestCase tc = new TestCase();
		List<ITest> liste = tc.getTestcases();

		for (ITest t : liste) {
			MainWebDriver maindriver = new MainWebDriver();
			t.run(maindriver.driver());
		}

		maindriver.driver().close();
		maindriver.driver().quit();
		
		
	}

}
