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

public class PerformancePage {

	WebDriver driver;
    public static Logger logger = LogManager.getLogger(PerformancePage.class);
	
	public void PerformancePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void AddEmployee_Review() throws Exception
	{
		 //driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		    Thread.sleep(1000);
		    findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();
		    Thread.sleep(1000);
		    logger.info("Clicked on PIM tab");
		    
		    findElement(By.id("menu_pim_addEmployee")).click();
		    Thread.sleep(1000);
		    findElement(By.id("firstName")).click();
		    Thread.sleep(1000);
		    findElement(By.id("firstName")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("firstName")).sendKeys("Sayantan");
		    Thread.sleep(1000);
		    logger.info("Firstname entered");
		    
		    findElement(By.id("lastName")).click();
		    Thread.sleep(1000);
		    findElement(By.id("lastName")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("lastName")).sendKeys("Das");
		    logger.info("Lastname entered");
		    
		    Thread.sleep(1000);
		    findElement(By.id("employeeId")).click();
		    Thread.sleep(1000);
		    findElement(By.id("employeeId")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("employeeId")).sendKeys("1799");
		    Thread.sleep(1000);
		    logger.info("Employee ID provided");
		    findElement(By.id("chkLogin")).click();
		    Thread.sleep(1000);
		    findElement(By.id("user_name")).click();
		    Thread.sleep(1000);
		    findElement(By.id("user_name")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("user_name")).sendKeys("Sayan_1");
		    logger.info("Username provided");
		    
		    Thread.sleep(1000);
		    findElement(By.id("user_password")).click();
		    Thread.sleep(1000);
		    findElement(By.id("user_password")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("user_password")).sendKeys("Sayapasis_cr7@171998");
		    Thread.sleep(1000);
		    logger.info("password entered");
		    
		    findElement(By.id("re_password")).click();
		    Thread.sleep(1000);
		    findElement(By.id("re_password")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("re_password")).sendKeys("Sayapasis");
		    Thread.sleep(1000);
		    findElement(By.id("btnSave")).click();
		    Thread.sleep(1000);
		    logger.warn("Password and re-enter password do not match");
		    
		    findElement(By.id("re_password")).click();
		    Thread.sleep(1000);
		    findElement(By.id("re_password")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("re_password")).sendKeys("Sayapasis_cr7@171998");
		    Thread.sleep(1000);
		    logger.warn("Password and re-enter password do not match");
		    
		    findElement(By.id("btnSave")).click();
		    Thread.sleep(1000);
		    logger.warn("Data saved successfully");
		    
		    findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();
		    Thread.sleep(1000);
		    findElement(By.id("menu_pim_viewEmployeeList")).click();
		    Thread.sleep(1000);
		    findElement(By.id("empsearch_id")).click();
		    Thread.sleep(1000);
		    findElement(By.id("empsearch_id")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("empsearch_id")).sendKeys("1799");
		    Thread.sleep(1000);
		    logger.warn("Employee searched by ID");
		    
		    findElement(By.id("empsearch_employee_status")).click();
		    Thread.sleep(1000);
		    logger.warn("Employee status selected");
		    
		    findElement(By.id("searchBtn")).click();
		    Thread.sleep(1000);
		    findElement(By.id("resetBtn")).click();
		    Thread.sleep(1000);
		    logger.warn("Reset action working fine");
		    
		    findElement(By.id("empsearch_employee_name_empName")).click();
		    Thread.sleep(1000);
		    findElement(By.id("empsearch_employee_name_empName")).click();
		    Thread.sleep(1000);
		    findElement(By.id("empsearch_employee_name_empName")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("empsearch_employee_name_empName")).sendKeys("Lisa Andrews");
		    Thread.sleep(1000);
		    logger.warn("Employee searched by Username");
		    
		    findElement(By.id("searchBtn")).click();
		    Thread.sleep(1000);
		    findElement(By.id("resetBtn")).click();
		    Thread.sleep(1000);
		    findElement(By.id("ohrmList_chkSelectRecord_37")).click();
		    Thread.sleep(1000);
		    logger.warn("Employee selected from list");
		    
		    findElement(By.id("btnDelete")).click();
		    Thread.sleep(1000);
		    findElement(By.id("dialogDeleteBtn")).click();
		    logger.warn("Delete dialogue box appears to choose and data deleted successfully");
		    Thread.sleep(1000);
		    
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
