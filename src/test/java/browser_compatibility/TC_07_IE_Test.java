package browser_compatibility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_07_IE_Test {
	
static WebDriver driver;
	
	@Test
	public void Login_Test() throws Exception
	{
		
	WebDriverManager.iedriver().setup();
	driver =new InternetExplorerDriver();
	driver.manage().window().maximize();
	driver.get("http://gmail.com");
	  
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
