package different_locators;

import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class TC_08_tagName {

	static WebDriver driver;

	@Test
	public void Test2() throws Exception {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		Thread.sleep(2000);
		findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(2000);
		findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		
		List<WebElement> links=  driver.findElements(By.tagName("a"));	
		int links_count= links.size();
		System.out.println("Number of hyperlinks "+links_count);
	
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
public  WebElement findElement(By by) throws Exception 
{

	WebElement elem = driver.findElement(by);  
	
	if (driver instanceof JavascriptExecutor) 
	{
	 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
 
	}
	return elem;
}

	
}
