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

public class FileAttachmentPage {

	WebDriver driver;
    public static Logger logger = LogManager.getLogger(FileAttachmentPage.class);
    
    public void FileAttachmentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Upload_File() throws Exception
	{
	  	
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(1000);
	    findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnAddAttachment")).click();
	    logger.warn("Navigated to file attachment section");
	    Thread.sleep(1000);
	    findElement(By.id("ufile")).click();
	    Thread.sleep(1000);
	    findElement(By.id("ufile")).clear();
	    logger.warn("Prompt to choose file from your system ");
	    
	    Thread.sleep(1000);
	    findElement(By.id("ufile")).sendKeys("C:\\Users\\sayantan_bose\\Desktop\\mini_1.txt");
	    logger.warn("File path provide");
	    Thread.sleep(1000);
	    findElement(By.id("txtAttDesc")).click();
	    Thread.sleep(1000);
	    findElement(By.id("txtAttDesc")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("txtAttDesc")).sendKeys("Hello Everyone....");
	    Thread.sleep(1000);
	    findElement(By.id("btnSaveAttachment")).click();
	    Thread.sleep(1000);
	    logger.warn("Data saved successfully");
	
	}
	
	public void Download_File() throws Exception
	{
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(1000);
	    findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b")).click();
	    Thread.sleep(1000);
	    logger.warn("The file to be downloaded selected");
	    
	    findElement(By.xpath("//table[@id='tblAttachments']/tbody/tr[2]/td[2]/a")).click();
	    Thread.sleep(1000);
	    
	    logger.warn("File downloaded successfully");
	    //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
	    //close();
	    //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
	}
	
	public void Delete_File() throws Exception
	{
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(1000);
	    findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b")).click();
	    Thread.sleep(1000);
	    logger.info("The file to be downloaded selected");
	    findElement(By.xpath("//table[@id='tblAttachments']/tbody/tr[4]/td/input")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnDeleteAttachment")).click();	
	    Thread.sleep(1000);
	    logger.warn("File downloaded successfully");
	    
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
