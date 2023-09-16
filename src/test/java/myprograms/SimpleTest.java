package myprograms;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import modals.Person;
import utils.ExcelUitility;

public class SimpleTest {

	@Test
	public void Test1() throws IOException, InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		ArrayList<Person> list = ExcelUitility.ReadDataFromExcel();
		
		System.out.println(list);
		for(Person person :list) {
			driver.findElement(By.xpath("//input[@id='validationCustom01']")).sendKeys(person.fisrtName);
     		driver.findElement(By.xpath("//input[@id='validationCustom02']")).sendKeys(person.lastName);
     		driver.findElement(By.xpath("//input[@id='validationCustomUsername']")).sendKeys(person.userName);
     		driver.findElement(By.xpath("//input[@id='validationCustom03']")).sendKeys(person.city);
    		driver.findElement(By.xpath("//input[@id='validationCustom04']")).sendKeys(person.state);
    		driver.findElement(By.xpath("//input[@id='validationCustom05']")).sendKeys(Integer.toString(person.zip));
    		driver.findElement(By.xpath("//input[@id='invalidCheck']")).click();
    		driver.findElement(By.xpath("//button[@type='submit']")).click();
    		Thread.sleep(2000);
    		driver.navigate().refresh();
		}
		
//		driver.findElement(By.xpath("//input[@id='validationCustom01']")).sendKeys();
//		driver.findElement(By.xpath("//input[@id='validationCustom02']")).sendKeys();
//     	driver.findElement(By.xpath("//input[@id='validationCustomUsername']")).sendKeys();
//    	driver.findElement(By.xpath("//input[@id='validationCustom03']")).sendKeys("city");
//		driver.findElement(By.xpath("//input[@id='validationCustom04']")).sendKeys("state");
//		driver.findElement(By.xpath("//input[@id='validationCustom05']")).sendKeys("zip");

		
		
	}
}
