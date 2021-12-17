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

public class MaintenancePage {

	 WebDriver driver;
	 public static Logger logger = LogManager.getLogger(MaintenancePage.class);
		
		public void MaintenancePage (WebDriver driver)
		{
			this.driver = driver;
		}
		
		public void AddMaintenance() throws Exception
		{
			//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		    findElement(By.xpath("//a[@id='menu_maintenance_purgeEmployee']/b")).click();
		    logger.info("Clicked on Purge Employees button");
		    
		    findElement(By.id("confirm_password")).click();
		    logger.warn("Prompt for confirm password appears.");
		    
		    findElement(By.id("confirm_password")).clear();
		    findElement(By.id("confirm_password")).sendKeys("admin123");
		    logger.trace("password provided");
		    
		    findElement(By.xpath("//input[@value='Verify']")).click();
		    findElement(By.id("employee_empName")).click();
		    findElement(By.id("employee_empName")).clear();
		    findElement(By.id("employee_empName")).sendKeys("user123");
		    logger.info("Employee name entered");
		    
		    findElement(By.xpath("//input[@value='Search']")).click();
		    findElement(By.xpath("//input[@value='Search']")).click();
		    logger.info("Search action initiated");
		    
		    findElement(By.id("employee_empName")).click();
		    findElement(By.id("employee_empName")).clear();
		    findElement(By.id("employee_empName")).sendKeys("admin");
		    logger.info("Again employee name entered");
		    
		    findElement(By.xpath("//input[@value='Search']")).click();
		    logger.info("Maintenance records available successfully.");
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
