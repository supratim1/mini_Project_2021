package project_1.project_1;

import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.openqa.selenium.support.ui.*;

public class TC_11_Dropdown_List_Box {

	//Test1 will be executed driver
		static WebDriver driver;
		
		@Test
		public void Test1() throws Exception {
		
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;	
			String TestURL = "https://opensource-demo.orangehrmlive.com/";
			driver.get(TestURL);
			
			Thread.sleep(2000);
			findElement(By.name("txtUsername")).sendKeys("Admin");
			//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			Thread.sleep(2000);
			findElement(By.id("txtPassword")).sendKeys("admin123");
			Thread.sleep(2000);
			findElement(By.id("btnLogin")).click();	
			
			Thread.sleep(2000);
			findElement(By.linkText("Admin")).click();
			Thread.sleep(2000);
			findElement(By.linkText("Organization")).click();
			Thread.sleep(2000);
			findElement(By.linkText("Locations")).click();
			
			Thread.sleep(2000);
			findElement(By.id("btnAdd")).click();
			
			
			Thread.sleep(2000);
		    Select dropdown1 = new Select(findElement(By.id("location_country")));
			
		    Thread.sleep(2000);
		    dropdown1.selectByValue("IN");
			//dropdown1.selectByVisibleText("India");
			//dropdown1.selectByIndex(0);
			
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
