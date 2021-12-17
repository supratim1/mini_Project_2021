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

 public class Buzz_SectionPage {

	WebDriver driver;
    public static Logger logger = LogManager.getLogger(Buzz_SectionPage.class);
	
	public void Buzz_SectionPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Check_Users() throws Exception
		{
			//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			Thread.sleep(1000);
		    findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		    Thread.sleep(1000);
		    logger.warn("Navigated to Admin section");
		    
		    findElement(By.id("menu_admin_UserManagement")).click();
		    Thread.sleep(1000);
		    findElement(By.id("menu_admin_viewSystemUsers")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_userName")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_userName")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_userName")).sendKeys("Aravind");
		    logger.warn("User name entered");
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_userType")).click();
		    Thread.sleep(1000);
		    new Select(findElement(By.id("searchSystemUser_userType"))).selectByVisibleText("ESS");
		    logger.warn("Job role selected");
		    
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_employeeName_empName")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_employeeName_empName")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("Dominic Chase");
		    Thread.sleep(1000);
		   // findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hide Options'])[1]/following::li[1]")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_status")).click();
		    Thread.sleep(1000);
		    new Select(findElement(By.id("searchSystemUser_status"))).selectByVisibleText("Enabled");
		    Thread.sleep(1000);
		    findElement(By.id("searchBtn")).click();
		    logger.warn("Search action initiated");
		    
		   // WebElement Element1 = findElement(By.linkText("UserName"));
		    WebElement Element1 = findElement(By.linkText("Aravind"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element1);
			logger.warn("scrollview action performed");
			
		    Thread.sleep(1000);
		    findElement(By.id("resetBtn")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_userName")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_userName")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_userName")).sendKeys("adash");
		    Thread.sleep(1000);
		    findElement(By.id("searchBtn")).click();
		    
		    WebElement Element2 = findElement(By.linkText("adash"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();", Element2);
		   
			Thread.sleep(1000);
		    findElement(By.id("resetBtn")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_employeeName_empName")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_employeeName_empName")).clear();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("Cassidy Hope");
		    Thread.sleep(1000);
		   // findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OrangeHRM, Inc'])[1]/following::li[1]")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchBtn")).click();
		    
		    WebElement Element3 = findElement(By.linkText("Cassidy.Hope"));
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].scrollIntoView();", Element3);
			
		    Thread.sleep(4000);
		    findElement(By.id("resetBtn")).click();
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_userType")).click();
		    Thread.sleep(1000);
		    new Select(findElement(By.id("searchSystemUser_userType"))).selectByVisibleText("ESS");
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_status")).click();
		    Thread.sleep(1000);
		    new Select(findElement(By.id("searchSystemUser_status"))).selectByVisibleText("Enabled");
		    Thread.sleep(1000);
		    findElement(By.id("searchBtn")).click();
		    Thread.sleep(1000);
		    findElement(By.id("resetBtn")).click();
		    logger.warn("rest action successful");
		    
		    Thread.sleep(1000);
		    findElement(By.id("searchSystemUser_userType")).click();
		    Thread.sleep(1000);
		    new Select(findElement(By.id("searchSystemUser_userType"))).selectByVisibleText("Admin");
		    Thread.sleep(1000);
		    findElement(By.id("searchBtn")).click();
		    
		    logger.warn("Clicked on search button");
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
