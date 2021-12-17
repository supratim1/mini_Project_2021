package Screenshots_and_Extent_Reports;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

//step1
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Screenshots_and_Extent_Reports.ExtentReport;

public class Add_Nationalities_Report {

WebDriver driver;
	
	//step2
	 ExtentTest logger;
	 ExtentReports extent;
	 String screenShotPath;
	 public static String TestScriptName = "TC02_Add_Nationalities_Test";
	 public static String TestName;
	 
	 @Test
		public void Report_TC_02_Test() throws Exception {
			
			System.out.println("Start test");
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize() ;	
			
			// step3 start here - ExtendsHtmlReport starts
			 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
			 Date now = new Date();
			 String strDate = sdfDate.format(now);
			 
			 TestName=TestScriptName+"_"+strDate+".html";
			 TestScriptName=TestScriptName+"_"+strDate;
			 String TestHtmlName="C:\\Users\\sayantan_bose\\Desktop\\Project\\Screenshots_Extent_Reports\\"+ TestScriptName +"/"+TestName;
			  
			 //String TestHtmlName=TestName;
			 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
			 
			 System.out.println("Html Report path is : "+TestHtmlName);
			 
			 extent=new ExtentReports();
			 extent.attachReporter(reporter);
			 logger=extent.createTest(TestName);
			//step3 ends here ExtendsHtmlReport ends
			 
			 //screenShotPath = ExtentReport.capture(driver,TestScriptName);
			//logger.pass("Login Page - Entered user Name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			String TestURL = "https://opensource-demo.orangehrmlive.com/";
			driver.get(TestURL);
			
			Thread.sleep(1000);
			findElement(By.name("txtUsername")).sendKeys("Admin");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Login Page - Entered user Name",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			Thread.sleep(1000);
			findElement(By.name("txtPassword")).sendKeys("admin123");	
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Login Page - Entered Password",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			Thread.sleep(1000);
			findElement(By.id("btnLogin")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Login Page - Clicked on Login",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			Thread.sleep(1000);
			findElement(By.id("menu_admin_viewAdminModule")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Home Page - Clicked on Admin Tab",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			Thread.sleep(1000);
			findElement(By.id("menu_admin_nationality")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Admin Page - On navigating to Admin page Nationalities button clicked ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			Thread.sleep(1000);
			findElement(By.id("btnAdd")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Admin Page - Add Nationalities button clicked ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			
			Thread.sleep(1000);
			findElement(By.id("nationality_name")).sendKeys("Mexican82");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Admin Page -  Nationality of user Entered ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			Thread.sleep(1000);
			findElement(By.id("btnSave")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Home Page - Data saved succesfully and back to Home Page ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			Thread.sleep(1000);
			//Step4
			extent.flush();
			Thread.sleep(1000);
			driver.close();
			
      }
	 
	// Draws a red border around the found element. Does not set it back anyhow.
		public  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			// draw a border around the found element
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}
	 
}
