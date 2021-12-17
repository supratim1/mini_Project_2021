package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage {

    WebDriver driver;
    public static Logger logger = LogManager.getLogger(HomePage.class);
	
	public void HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void Logout() throws Exception
	 {
		        Thread.sleep(2000);
				findElement(By.id("welcome")).click();
				Thread.sleep(2000);
				logger.info("Navigated to Home Page");
				
				findElement(By.linkText("Logout")).click();
				Thread.sleep(2000);
				logger.info("User logged out successfully");
	 }
	
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	
}
