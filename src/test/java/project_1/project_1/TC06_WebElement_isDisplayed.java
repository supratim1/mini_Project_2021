package project_1.project_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.JavascriptExecutor;

import CommonUtil.OR;

public class TC06_WebElement_isDisplayed {
	
	WebDriver driver;	
	
	@Test	
	public void login_test() throws Exception
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;	
			
			//OpenUrl
			driver.get("https://opensource-demo.orangehrmlive.com/");
			Thread.sleep(3000);
			Boolean str = findElement(By.id("btnLogin")).isDisplayed();
			
			Thread.sleep(3000);
			if(str==true)
			System.out.println("Button displayed on WebPage");
			else
			System.out.println("Button is not displayed on WebPage");
			
			
			Assert.assertSame(str, true);
			

		
		}
		catch(Exception e)
		{
			System.out.println("Java Error Message :" +e.getMessage());
		}
		
		catch (AssertionError e) {
			
			System.out.println(" Assert Error Message :" +e.getMessage());
		}
		
		finally
		{
			Thread.sleep(3000);
			driver.quit();
		}
		
		

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
