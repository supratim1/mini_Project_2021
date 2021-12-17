package Page_Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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

public class ReportsPage {

    WebDriver driver;
    public static Logger logger = LogManager.getLogger(ReportsPage.class);
	
	public void ReportsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void Add_Employee_Reports() throws Exception
	{
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	    Thread.sleep(1000);
		findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();
		logger.info("Clicked on PIM tab/button");
		
		Thread.sleep(1000);
	    findElement(By.id("menu_core_viewDefinedPredefinedReports")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAdd")).click();
	    Thread.sleep(1000);
	    findElement(By.id("report_report_name")).click();
	    Thread.sleep(1000);
	    findElement(By.id("report_report_name")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("report_report_name")).sendKeys("Emp_rep_3");
	    logger.info("Report name entered");
	    
	    Thread.sleep(1000);
	    findElement(By.id("report_criteria_list")).click();
	    Thread.sleep(1000);
	    new Select(findElement(By.id("report_criteria_list"))).selectByVisibleText("Pay Grade");
	    Thread.sleep(1000);
	    logger.info("Pay grade selected from dropdown list");
	    
	    findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::select[1]")).click();
	    Thread.sleep(1000);
	    new Select(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::select[1]"))).selectByVisibleText("Current and Past Employees");
	    Thread.sleep(1000);
	    findElement(By.id("report_display_groups")).click();
	    
	    logger.info("report displayed");
	    Thread.sleep(1000);
	    new Select(findElement(By.id("report_display_groups"))).selectByVisibleText("Languages");
	    Thread.sleep(1000);
	    findElement(By.id("report_display_field_list")).click();
	    new Select(findElement(By.id("report_display_field_list"))).selectByVisibleText("Competency");
	    findElement(By.id("btnSave")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAddDisplayField")).click();
	    Thread.sleep(1000);
	    findElement(By.id("display_group_13")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnSave")).click();
	    Thread.sleep(1000);
	    findElement(By.id("search_search")).click();
	    Thread.sleep(1000);
	    findElement(By.id("search_search")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("search_search")).sendKeys("PiM Sample Report");
	    logger.info("Value sent with search action");
	    
	    Thread.sleep(1000);
	    findElement(By.name("_search")).click();
	    Thread.sleep(1000);
	    findElement(By.name("_reset")).click();
	    Thread.sleep(1000);
	    findElement(By.id("ohrmList_chkSelectRecord_11")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnDelete")).click();
	    Thread.sleep(1000);
	    findElement(By.id("dialogDeleteBtn")).click();
	    logger.info("Data deleted successfully ");
	    Thread.sleep(1000);
	    findElement(By.id("ohrmList_chkSelectRecord_7")).click();
	    Thread.sleep(1000);
	    findElement(By.linkText("Run")).click();
	    
	    logger.info("Run action working perfectly ");
	    
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
