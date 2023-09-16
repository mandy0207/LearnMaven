package myprograms;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearnExtentReports {

	
	public ExtentReports extent;
	public WebDriver driver;
	
	
    @BeforeTest
	public void GenerateReports() {
	 String path = System.getProperty("user.dir")+"//Reports//index.html";
	
	 ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	 reporter.config().setReportName("Obsqura Automation Report");
	 reporter.config().setDocumentTitle("Test Results");
	 
	 extent = new ExtentReports();
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Tester", "Mandy Taak");
	 extent.setSystemInfo("Environment", "QA");
	}
	
    
	@Test
	public void NavigateTOObsqura() {
		extent.createTest("NavigateToObsqura");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.obsqurazone.com/");
		driver.quit();
		extent.flush();
		

	}
	
	@Test
	public void SecondTest() {
		ExtentTest test = extent.createTest("failed Test");
		test.fail("Test Failed");
		extent.flush();
		Assert.fail();
	}
	

}
