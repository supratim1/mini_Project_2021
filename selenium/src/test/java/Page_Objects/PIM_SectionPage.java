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

public class PIM_SectionPage {

    WebDriver driver;
    public static Logger logger = LogManager.getLogger(PIM_SectionPage.class);
    
	public void PIM_SectionPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Check_Locations() throws Exception
	{
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Thread.sleep(1000);
	    findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
	    logger.warn("Clicked on PIM Tab ");
	    Thread.sleep(1000);
	    
	    findElement(By.id("menu_admin_Organization")).click();
	    logger.warn("Switched to Organization page");
	    Thread.sleep(1000);
	    findElement(By.id("menu_admin_viewLocations")).click();
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_name")).click();
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_name")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_name")).sendKeys("Texas R&D");
	    logger.warn("Loaction selected from dropdow list");
	    
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_city")).click();
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_city")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_city")).sendKeys("Texas");
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_country")).click();
	    Thread.sleep(1000);
	    new Select(findElement(By.id("searchLocation_country"))).selectByVisibleText("United States");
	    Thread.sleep(1000);
	    findElement(By.id("btnSearch")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnReset")).click();
	    Thread.sleep(1000);
	    logger.info("Reset button clicked to clear data");
	    
	    findElement(By.id("searchLocation_city")).click();
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_city")).clear();
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_city")).sendKeys("Ottawa");
	    Thread.sleep(1000);
	    logger.info("Searched organization location by city name");
	    
	    findElement(By.id("btnSearch")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnReset")).click();
	    Thread.sleep(1000);
	    findElement(By.id("searchLocation_country")).click();
	    Thread.sleep(1000);
	    new Select(findElement(By.id("searchLocation_country"))).selectByVisibleText("United States");
	    Thread.sleep(1000);
	    
	    logger.info("Searched organization location by country name");
	    findElement(By.id("btnSearch")).click();
	    Thread.sleep(1000);
	    findElement(By.id("btnReset")).click();
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
