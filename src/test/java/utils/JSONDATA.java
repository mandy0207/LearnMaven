package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class JSONDATA {
	@Test
    public void RunTest() throws InterruptedException {
        

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the web page
        driver.get("https://www.thewildest-stg.com/");
        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("//*[@id='mainnavigation']/li[1]/ul/li[1]/a"));
        String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);

        // Print or use the text as needed
        
  System.out.println(text);
	}}
