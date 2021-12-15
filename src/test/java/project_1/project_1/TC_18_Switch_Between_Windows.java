package project_1.project_1;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_18_Switch_Between_Windows {

WebDriver driver;
	
	@Test
	public void Login_Test_1() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;
	driver.get("https://opensource-demo.orangehrmlive.com/");

	//below line opens new tab
	Thread.sleep(2000);
	((JavascriptExecutor)driver).executeScript("window.open()");
	Thread.sleep(2000);
	((JavascriptExecutor)driver).executeScript("window.open()");

	
	//strore all the open windows in ArrayList string
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	
	//Switch to New tab
	Thread.sleep(2000);
	driver.switchTo().window(tabs.get(1));
	driver.get("http://google.com");	
	

	Thread.sleep(2000);
	driver.switchTo().window(tabs.get(0));
	//back to MainWindow
	Thread.sleep(2000);
	findElement(By.name("txtUsername")).sendKeys("Admin");
	Thread.sleep(2000);
	findElement(By.name("txtPassword")).sendKeys("admin123");
	Thread.sleep(2000);
	
	driver.switchTo().window(tabs.get(2));
	driver.get("https://facebook.com");
	Thread.sleep(2000);
	
	//driver.quit();
	driver.close();
	
		
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
