package Customizable_Emailable_Report;

import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import Customizable_Emailable_Report.Reporter_1; //step1

public class TC_01_Test_Report {

	static WebDriver driver;
	Reporter_1 R1;  //step2
	
	@Test
	public void TC01_Report() throws Exception {
		
		System.out.println("Start test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize() ;	
		
		String str= "TC01_Login";  //step3
		R1 = new Reporter_1(driver,str);	//step3
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		
		driver.get(TestURL);
		R1.TakeScreenShotAuto(driver,"Opened Orange HRM","Pass"); //step4
		 
	   
		findElement(By.id("txtUsername")).sendKeys("Admin");
		R1.TakeScreenShotAuto(driver,"Username Entered","Pass");
		

		findElement(By.id("txtPassword")).sendKeys("admin123");	
		R1.TakeScreenShotAuto(driver,"Password Entered","Pass");
		
		
		findElement(By.name("Submit")).click();
		R1.TakeScreenShotAuto(driver,"Clicked on Signin","Fail");
		driver.close();
	
	}
	
	
		
	// Draws a red border around the found element. Does not set it back anyhow.
	public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		// draw a border around the found element
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
			
		
}
