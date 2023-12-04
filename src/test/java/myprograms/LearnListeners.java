package myprograms;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LearnListeners implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		System.out.println("I am starting");
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success");
	}


	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
	}
	
}
