package edu.ozu.cs576.phsico.test;

import java.util.ArrayList;
import java.util.List;

public class TestCase {

	public List<ITest> testcaseList = new ArrayList<ITest>();
	public TestCase testcase;

	public TestCase() {

	}

	public List<ITest> getTestcases() {
		testcaseList.add(new Doctors());
		testcaseList.add(new Users());
		testcaseList.add(new Admin());

		return testcaseList;

	}

}
