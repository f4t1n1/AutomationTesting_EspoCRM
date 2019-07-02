package testNG;

import org.testng.ITestNGListener;

import org.testng.TestNG;

public class Wrapper {

	public static void main(String[] args) {

		ITestNGListener tla = null;

		TestNG testng = new TestNG();

		testng.setTestClasses(new Class[] { Main.class });

		testng.addListener(tla);
		testng.run();

	}

}
