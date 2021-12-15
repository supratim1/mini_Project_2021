package browser_compatibility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_08_Firefox_Test {
	
static WebDriver driver;
	
	@Test
	public void Login_Test() throws Exception
	{
		
	WebDriverManager.firefoxdriver().setup();
	  driver = new FirefoxDriver();
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
