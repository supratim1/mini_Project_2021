package project_1.project_1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List.*;

public class TC_Login {
	
	WebDriver driver;	
	@Test
	public void login_test() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	Thread.sleep(3000);
	
	findElement(By.name("txtUsername")).sendKeys("Admin");
	Thread.sleep(3000);
	//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	findElement(By.id("txtPassword")).sendKeys("admin123");
	Thread.sleep(3000);
	findElement(By.id("btnLogin")).click();	
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
