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

public class Alternate_LoginPage {

    WebDriver driver;
    public static Logger logger = LogManager.getLogger(Alternate_LoginPage.class);
	
	public void Alternate_LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void Login() throws Exception {
		
		Thread.sleep(2000);
		findElement(By.name("txtUsername")).sendKeys("Admin");
		logger.info("Username entered");
		
		Thread.sleep(2000);
		findElement(By.name("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		logger.info("Password entered");
		
		findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		logger.info("User logged in successfully");
	}
	
	
	
	public WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	
}
