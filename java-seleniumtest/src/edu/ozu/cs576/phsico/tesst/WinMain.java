package edu.ozu.cs576.phsico.tesst;

public class WinMain {

	public static void main(String arg[]) {
		System.out.println("Test Otomasyon calismaya basladi.");
		TestCaseExecutor executor = new TestCaseExecutor();

			executor.run();

		System.out.println("Test Otomasyon calismasi tamamlandi..");

	}
}
