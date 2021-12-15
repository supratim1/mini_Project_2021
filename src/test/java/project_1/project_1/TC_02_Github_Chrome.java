package project_1.project_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_02_Github_Chrome {

	WebDriver driver;	
	
	@Test	
	public void login_test() throws Exception
	{
		
	WebDriverManager.chromedriver().setup();
	driver =new ChromeDriver();
	
	driver.manage().window().maximize() ;	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	

	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.name("Submit")).click();		
	
	
	
	
	}

}
