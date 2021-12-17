package Customizable_Emailable_Report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import Customizable_Emailable_Report.Reporter_1; //step1

public class Add_Nationalities_Report {

	static WebDriver driver;
	Reporter_1 R1;  //step2
	
	@Test
	public void TC01_Report() throws Exception {
		
		System.out.println("Start test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize() ;	
		
		String str= "TC02_Add_Nationalities";  //step3
		R1 = new Reporter_1(driver,str);	//step3
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		
		driver.get(TestURL);
		Thread.sleep(1000);
		R1.TakeScreenShotAuto(driver,"Opened Orange HRM","Pass"); //step4
		 
		Thread.sleep(1000);
		findElement(By.id("txtUsername")).sendKeys("Admin");
		R1.TakeScreenShotAuto(driver,"Username Entered","Pass");
		
		Thread.sleep(1000);
		findElement(By.id("txtPassword")).sendKeys("admin123");	
		R1.TakeScreenShotAuto(driver,"Password Entered","Pass");
		
		Thread.sleep(1000);
		findElement(By.name("Submit")).click();
		R1.TakeScreenShotAuto(driver,"Clicked on Signin","Fail");
		
		Thread.sleep(1000);
		findElement(By.id("menu_admin_viewAdminModule")).click();
		R1.TakeScreenShotAuto(driver,"Clicked on Admin Tab","Pass");
		
		Thread.sleep(1000);
		findElement(By.id("menu_admin_nationality")).click();
		R1.TakeScreenShotAuto(driver,"On navigating to Admin page Nationalities button clicked ","Pass");
		
		Thread.sleep(1000);
		findElement(By.id("btnAdd")).click();
		R1.TakeScreenShotAuto(driver,"Add Nationalities button clicked","Pass");
		
		Thread.sleep(1000);
		findElement(By.id("nationality_name")).sendKeys("Mexican84");
		R1.TakeScreenShotAuto(driver,"Nationality of user Entered","Pass");
		
		Thread.sleep(1000);
		findElement(By.id("btnSave")).click();
		R1.TakeScreenShotAuto(driver,"Data saved succesfully and back to Home Page ","Pass");
		
		Thread.sleep(2000);
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
