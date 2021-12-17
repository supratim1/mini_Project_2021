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

public class VacancyPage {

    WebDriver driver;
    public static Logger logger = LogManager.getLogger(VacancyPage.class);
    
	public void VacancyPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void AddVacancy() throws Exception
	{
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	   findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']/b")).click();
	   logger.info("Clicked on View  vacancy menu");
	   
	   findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	   logger.info("Vacancy menu dispalyed");
	   
	   findElement(By.id("vacancySearch_jobTitle")).click();
	   logger.info("Job search by job title done");
	   
	    new Select(findElement(By.id("vacancySearch_jobTitle"))).selectByVisibleText("IT Manager");
	    logger.info("Job title selected from dropdown list");
	    
	   findElement(By.id("btnAdd")).click();
	   findElement(By.id("addJobVacancy_jobTitle")).click();
	   logger.info("Clicked on add job vacancy menu");
	   
	    new Select(findElement(By.id("addJobVacancy_jobTitle"))).selectByVisibleText("Content Specialist");
	    logger.info("Value selected from drop down list box");
	   findElement(By.id("addJobVacancy_name")).click();
	   findElement(By.id("addJobVacancy_name")).clear();
	   findElement(By.id("addJobVacancy_name")).sendKeys("Eva");
	   logger.info("Employee name sent");
	   
	   findElement(By.id("addJobVacancy_hiringManager")).click();
	   findElement(By.id("addJobVacancy_hiringManager")).clear();
	   findElement(By.id("addJobVacancy_hiringManager")).sendKeys("D");
	   logger.info("Hiring manager name selected");
	   
	   findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='d'])[6]/following::strong[1]")).click();
	   findElement(By.id("btnSave")).click();
	   logger.info("Data saved successfully ");
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
