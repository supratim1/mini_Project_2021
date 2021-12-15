package project_1.project_1;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_17_Open_New_Tab {

WebDriver driver;
	
	@Test
	public void Login_Test() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;
	driver.get("https://opensource-demo.orangehrmlive.com/");

	Thread.sleep(2000);
	//below line opens new tab
	((JavascriptExecutor)driver).executeScript("window.open()");
	
	//strore all the open windows in ArrayList string
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	
	Thread.sleep(2000);
	//Switch to New tab
	driver.switchTo().window(tabs.get(1));
	driver.get("http://google.com");
	
	Thread.sleep(2000);
	//back to MainWindow
	driver.switchTo().window(tabs.get(0));

	Thread.sleep(2000);
	findElement(By.name("txtUsername")).sendKeys("Admin");
	Thread.sleep(2000);
	findElement(By.name("txtPassword")).sendKeys("admin123");
	Thread.sleep(2000);
	findElement(By.id("btnLogin")).click();	

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