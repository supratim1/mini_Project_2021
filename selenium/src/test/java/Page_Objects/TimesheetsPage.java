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

public class TimesheetsPage {

	WebDriver driver;
    public static Logger logger = LogManager.getLogger(TimesheetsPage.class);
	
	public void TimesheetsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void Add_Timesheet() throws Exception
	{
		//ERROR: Caught exception [unknown command []]
	    driver.findElement(By.xpath("//a[@id='menu_time_viewTimeModule']/b")).click();
	    logger.fatal("Clicked on Time tab");
	    
	    driver.findElement(By.id("menu_time_Timesheets")).click();
	    logger.info("Clicked on Timesheets tab");
	    
	    driver.findElement(By.id("menu_time_viewEmployeeTimesheet")).click();
	    logger.info("Navigated to View employee section");
	    
	    driver.findElement(By.xpath("//form[@id='viewTimesheetForm']/table/tbody/tr[2]/td[3]/a")).click();
	    logger.info("Employee selected from the Table ");
	    
	    driver.findElement(By.id("btnEdit")).click();
	    logger.info("Clicked on Edit button");
	    
	    driver.findElement(By.id("submitSave")).click();
	    logger.info("Timesheet updated successfully ");
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
