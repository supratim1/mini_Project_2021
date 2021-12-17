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

public class Admin_Page {

    WebDriver driver;
    public static Logger logger = LogManager.getLogger(Alternate_LoginPage.class);
    
	public void Admin_Page (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Check_Job_Tab() throws Exception
	{
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(1000);
	    findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
	    logger.info("Navigate to Admin section");
	    
	    Thread.sleep(1000);
	    findElement(By.id("menu_admin_Job")).click();
	    logger.warn("Navigated to job  section");
	    
	    Thread.sleep(1000);
	    findElement(By.id("menu_admin_viewJobTitleList")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAdd")).click();
	    Thread.sleep(1000);
	    findElement(By.id("jobTitle_jobTitle")).click();
	    Thread.sleep(1000);
	    findElement(By.id("jobTitle_jobTitle")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("jobTitle_jobTitle")).sendKeys("Data Analyst 3.0");
	    logger.warn("Job title provide");
	    
	    Thread.sleep(1000);
	    findElement(By.id("jobTitle_jobDescription")).click();
	    Thread.sleep(1000);
	    findElement(By.id("jobTitle_jobDescription")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("jobTitle_jobDescription")).sendKeys("Requires knowledge in Python, R..");
	    Thread.sleep(1000);
	    findElement(By.id("btnSave")).click();
	    Thread.sleep(1000);
	    logger.warn("Data saved successfully");
	    
	    findElement(By.xpath("//table[@id='resultTable']/tbody/tr[5]/td")).click();
	    Thread.sleep(1000);
	    findElement(By.id("dialogDeleteBtn")).click();
	   // findElement(By.id("")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnDelete")).click();
	    Thread.sleep(1000);
	  //  findElement(By.id("dialogDeleteBtn")).click();
	 //   Thread.sleep(1000);
	    findElement(By.id("menu_admin_Job")).click();
	    Thread.sleep(1000);
	    findElement(By.id("menu_admin_viewPayGrades")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAdd")).click();
	    Thread.sleep(1000);
	    findElement(By.id("payGrade_name")).click();
	    Thread.sleep(1000);
	    findElement(By.id("payGrade_name")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("payGrade_name")).sendKeys("Grade_24");
	    Thread.sleep(1000);
	    findElement(By.id("btnSave")).click();
	    Thread.sleep(1000);
	    findElement(By.id("menu_admin_Job")).click();
	    Thread.sleep(1000);
	    logger.warn("switched to hob tab again");
	    
	    findElement(By.id("menu_admin_employmentStatus")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAdd")).click();
	    Thread.sleep(1000);
	    findElement(By.id("empStatus_name")).click();
	    Thread.sleep(1000);
	    findElement(By.id("empStatus_name")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("empStatus_name")).sendKeys("Software Developer 2");
	    Thread.sleep(1000);
	    findElement(By.id("btnSave")).click();
	    Thread.sleep(1000);
	    findElement(By.id("menu_admin_Job")).click();
	    Thread.sleep(1000);
	    findElement(By.id("menu_admin_jobCategory")).click();
	    Thread.sleep(1000);
	    findElement(By.id("ohrmList_chkSelectRecord_7")).click();
	    Thread.sleep(1000);
	    findElement(By.id("dialogDeleteBtn")).click();
	    logger.warn("Delete dialog box appears");
	    Thread.sleep(1000);
	    findElement(By.id("btnDelete")).click();
	    Thread.sleep(1000);
	    //findElement(By.id("dialogDeleteBtn")).click();
	    Thread.sleep(1000);
	    findElement(By.id("menu_admin_Job")).click();
	    Thread.sleep(1000);
	    findElement(By.id("menu_admin_workShift")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAdd")).click();
	    Thread.sleep(1000);
	    findElement(By.id("workShift_name")).click();
	    Thread.sleep(1000);
	    findElement(By.id("workShift_name")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("workShift_name")).sendKeys("Team_work");
	    Thread.sleep(1000);
	    findElement(By.id("workShift_workHours_from")).click();
	    Thread.sleep(1000);
	    new Select(findElement(By.id("workShift_workHours_from"))).selectByVisibleText("09:30");
	    Thread.sleep(1000);
	    findElement(By.id("workShift_workHours_to")).click();
	    Thread.sleep(1000);
	    findElement(By.xpath("//form[@id='frmWorkShift']/fieldset/ol/li[2]/input")).click();
	    Thread.sleep(1000);
	    new Select(findElement(By.id("workShift_availableEmp"))).selectByVisibleText("Odis Adalwin");
	    Thread.sleep(1000);
	    findElement(By.xpath("//option[@value='2']")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAssignEmployee")).click();
	    Thread.sleep(1000);
	    new Select(findElement(By.id("workShift_availableEmp"))).selectByVisibleText("Peter Mac Anderson");
	    Thread.sleep(1000);
	    findElement(By.xpath("//option[@value='3']")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAssignEmployee")).click();
	    Thread.sleep(1000);
	    new Select(findElement(By.id("workShift_availableEmp"))).selectByVisibleText("Lisa Andrews");
	    Thread.sleep(1000);
	    findElement(By.xpath("//option[@value='28']")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAssignEmployee")).click();
	    Thread.sleep(1000);
	    //ERROR: Caught exception [ERROR: Unsupported command [removeSelection | id=workShift_assignedEmp | label=Odis Adalwin]]
	    //ERROR: Caught exception [ERROR: Unsupported command [removeSelection | id=workShift_assignedEmp | label=Lisa Andrews]]
	    findElement(By.xpath("//option[@value='3']")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnRemoveEmployee")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnSave")).click();
	    Thread.sleep(1000);
	    logger.warn("Data saved successfully");
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
