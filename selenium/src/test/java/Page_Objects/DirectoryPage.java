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

public class DirectoryPage {

	 WebDriver driver;
	    public static Logger logger = LogManager.getLogger(DirectoryPage.class);
		
		public void DirectoryPage(WebDriver driver)
		{
			this.driver = driver;
		}
		
		public void AddDirectory() throws Exception
		{
			
			//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		    findElement(By.xpath("//a[@id='menu_directory_viewDirectory']/b")).click();
		    logger.info("Directory Tab clicked");
		    
		    findElement(By.id("searchDirectory_emp_name_empName")).click();
		    logger.info("Clicked on search directory");
		    
		    findElement(By.id("searchDirectory_emp_name_empName")).clear();
		    logger.info("Any values if present cleared");
		    
		    findElement(By.id("searchDirectory_emp_name_empName")).sendKeys("Alice Duval");
		    logger.info("Employee name provided");
		    
		    findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='U'])[1]/following::li[1]")).click();
		    findElement(By.id("searchBtn")).click();
		    logger.info("Clicked on Employees directory search button");
		    
		    findElement(By.xpath("//table[@id='resultTable']/tbody/tr[2]/td[2]")).click();
		    logger.info("Employee records updated successfully");
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
