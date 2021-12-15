package project_1.project_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

public class TC_14_Single_user_action {
   
static WebDriver driver;
	
	@Test
	public void Login_Test() throws Exception
	{
		
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize() ;	
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	Thread.sleep(2000);
	findElement(By.name("txtUsername")).sendKeys("Admin");
	Thread.sleep(2000);
	findElement(By.name("txtPassword")).sendKeys("admin123");
	//findElement(By.id("btnLogin")).click();
	
	Thread.sleep(2000);
	WebElement Login_Button = findElement(By.id("btnLogin"));
	
	Actions builder = new Actions(driver);
    builder.moveToElement(Login_Button).click().build().perform();

    Thread.sleep(3000);
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
