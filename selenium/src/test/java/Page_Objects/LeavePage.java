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

public class LeavePage {

	WebDriver driver;
    public static Logger logger = LogManager.getLogger(LeavePage.class);
	
	public void LeavePage(WebDriver driver)
	{
		this.driver = driver;
	}
	 
	public  void Leave() throws Exception
	{
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	    driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']/b")).click();
	    logger.info("Clicked on Leave Tab ");
	    
	    
	    driver.findElement(By.id("menu_leave_viewLeaveList")).click();
	    logger.trace("Navigated to Leave list");
	    
	    driver.findElement(By.xpath("//form[@id='frmFilterLeave']/fieldset/ol/li/img")).click();
	    driver.findElement(By.linkText("8")).click();
	    driver.findElement(By.xpath("//form[@id='frmFilterLeave']/fieldset/ol/li[2]/img")).click();
	    driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]")).click();
	    driver.findElement(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck")).click();
	    logger.info("Checkbox selected");
	    
	    driver.findElement(By.id("leaveList_txtEmployee_empName")).click();
	    logger.info("Clicked on Employee name text area");
	    driver.findElement(By.id("leaveList_txtEmployee_empName")).click();
	    driver.findElement(By.id("leaveList_txtEmployee_empName")).clear();
	    driver.findElement(By.id("leaveList_txtEmployee_empName")).sendKeys("Nina Patel");
	    logger.info("Employee name entered");
	    
	    driver.findElement(By.id("leaveList_cmbSubunit")).click();
	    logger.info("Sub unit selected ");
	    driver.findElement(By.id("btnSearch")).click();
	    logger.info("Clicked on search button and data displayed successfully");
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

