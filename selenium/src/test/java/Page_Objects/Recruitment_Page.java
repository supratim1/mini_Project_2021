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

public class Recruitment_Page {
   
	WebDriver driver;
	
    public static Logger logger = LogManager.getLogger(Recruitment_Page.class);
	public void Recruitment_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void AddRecruitment() throws Exception
	{
		
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	    findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']/b")).click();
	    logger.info("Navigated to recruitment section");
	    
	    findElement(By.id("candidateSearch_jobTitle")).click();
	    logger.trace("Job title vacancy searched");
	    
	    new Select(findElement(By.id("candidateSearch_jobTitle"))).selectByVisibleText("Chief Executive Officer");
	    logger.warn("Job title selsected");
	    
	    findElement(By.id("btnSrch")).click();
	    findElement(By.id("btnAdd")).click();
	    logger.info("Add button clicked");
	    
	    findElement(By.xpath("//form[@id='frmAddCandidate']/fieldset/ol/li/ol/li")).click();
	    logger.info("Candidate navigated to job application section");
	    
	    findElement(By.id("addCandidate_firstName")).click();
	    findElement(By.id("addCandidate_firstName")).clear();
	    findElement(By.id("addCandidate_firstName")).sendKeys("Sunil");
	    logger.fatal("firstname entered");
	    
	    findElement(By.id("addCandidate_lastName")).click();
	    findElement(By.id("addCandidate_lastName")).clear();
	    findElement(By.id("addCandidate_lastName")).sendKeys("Gupta");
	    logger.info("lastname entered");
	    
	    findElement(By.id("addCandidate_email")).click();
	    findElement(By.id("addCandidate_email")).clear();
	    findElement(By.id("addCandidate_email")).sendKeys("abc78@gmail.com");
	    logger.info("User e-mail entered");
	    
	    findElement(By.id("btnSave")).click();
	    logger.info("Job application submitted successfully");
	    
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
