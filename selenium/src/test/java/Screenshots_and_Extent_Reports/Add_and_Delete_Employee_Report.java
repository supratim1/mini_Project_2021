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
import com.aventstack.extentreports.reporter.configuration.Theme;

import Screenshots_and_Extent_Reports.ExtentReport;

public class Add_and_Delete_Employee_Report {

WebDriver driver;
	
	//step2
	 ExtentTest logger;
	 ExtentReports extent;
	 String screenShotPath;
	 public static String TestScriptName = "TC03_Add_and_Delete_Employee_Test";
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
			 
			 reporter.config().setDocumentTitle("Automation Report"); // Tile of report
			 reporter.config().setReportName("Selenium Testing Report"); // name of the report
			//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
			 reporter.config().setTheme(Theme.DARK);
			 
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
	        findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();
	        screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Home Page - Clicked on PIM Tab ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	       
			Thread.sleep(1000);
			findElement(By.id("menu_pim_addEmployee")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("PIM Page -  Navigated to Employee section on clicking Add Employee button",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());    
			
			Thread.sleep(1000);
			findElement(By.id("firstName")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Clicked on firstname Text area",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
			findElement(By.id("firstName")).clear();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Any value if present previously is cleared",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			   
			Thread.sleep(1000);
			findElement(By.id("firstName")).sendKeys("Sayantan");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Firstname entered",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			Thread.sleep(1000);
			findElement(By.id("lastName")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Clicked on lastname Text area ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
			findElement(By.id("lastName")).clear();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Any value if present previously is cleared ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build()); 
			
			Thread.sleep(1000);
		    findElement(By.id("lastName")).sendKeys("Das");
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Lastname entered",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		    
		    Thread.sleep(1000);
			findElement(By.id("employeeId")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Clicked on ID button ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			Thread.sleep(1000);
			findElement(By.id("employeeId")).clear();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Any value if present previously is cleared ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build()); 
			
			Thread.sleep(1000);
			findElement(By.id("employeeId")).sendKeys("1799");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - ID value entered ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());  
			
			Thread.sleep(1000);
		    findElement(By.id("chkLogin")).click();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Login credentials checkbox selected ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		    
			Thread.sleep(1000);
			findElement(By.id("user_name")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Clicked on username Text area ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
			findElement(By.id("user_name")).clear();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Text area cleared",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			Thread.sleep(1000);
			findElement(By.id("user_name")).sendKeys("Sayan_1");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - User name entered ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
			findElement(By.id("user_password")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Clicked on add password button ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
			findElement(By.id("user_password")).clear();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Text area for password cleared ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
		
			Thread.sleep(1000);
		    findElement(By.id("user_password")).sendKeys("Sayapasis_cr7@171998");
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Password for new employee entered ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
		    
			Thread.sleep(1000);
			findElement(By.id("re_password")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Clicked on re-enter password Text area ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
		    findElement(By.id("re_password")).clear();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Re-enter password text area cleared.",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		    
		    Thread.sleep(1000);
		    findElement(By.id("re_password")).sendKeys("Sayapasis");
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Password re-entered ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
		  
			Thread.sleep(1000);
		    findElement(By.id("btnSave")).click();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.fail("Employee Page - Clicked on save button, as both the password and re-enter password do not match ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());    
		   
			Thread.sleep(1000);
		    findElement(By.id("re_password")).click();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Again prompted to re-enter the password ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());    
		   
			Thread.sleep(1000);
			findElement(By.id("re_password")).clear();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Text area cleared ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
		    findElement(By.id("re_password")).sendKeys("Sayapasis_cr7@171998");
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Password again re-entered ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
		    
			Thread.sleep(1000);
			findElement(By.id("btnSave")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee Page - Clicked on Save button and this time data saved successfully ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
		    findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("PIM Page - Again clicked on PIM Tab ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());    
		    
			Thread.sleep(1000);
		    findElement(By.id("menu_pim_viewEmployeeList")).click();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("PIM Page - Navigated to Employee search list Tab ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
		   
			Thread.sleep(1000);
			findElement(By.id("empsearch_id")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Clicked on search by ID Text area ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
		    findElement(By.id("empsearch_id")).clear();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Any previous value if there in the Text area is cleared ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		   
			Thread.sleep(1000);
			findElement(By.id("empsearch_id")).sendKeys("1799");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass(" Employee_List Page - Employee ID entered ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());  
			
			Thread.sleep(1000);
			findElement(By.id("empsearch_employee_status")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Employment status checked and updated ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			
			Thread.sleep(1000);
		    findElement(By.id("searchBtn")).click();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Clicked on Search button to view Employee Details ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		    
			Thread.sleep(1000);
		    findElement(By.id("resetBtn")).click();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Clicked on Reset button to clear previous results ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		    
			Thread.sleep(1000);
		    findElement(By.id("empsearch_employee_name_empName")).click();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Clicked on Search by employee name or username",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
		    
			Thread.sleep(1000);
			findElement(By.id("empsearch_employee_name_empName")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Clicked on Search by username",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
			findElement(By.id("empsearch_employee_name_empName")).clear();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Username Text area cleared",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());  
			
			Thread.sleep(1000);
			findElement(By.id("empsearch_employee_name_empName")).sendKeys("Lisa Andrews");
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List - Username entered",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
			findElement(By.id("searchBtn")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Search button clicked",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
		    findElement(By.id("resetBtn")).click();
		    screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Reset button clicked ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			    
		    Thread.sleep(1000);
			findElement(By.id("ohrmList_chkSelectRecord_37")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Employee name selected from the list ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
			findElement(By.id("btnDelete")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Clicked on Delete Employee button ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
			Thread.sleep(1000);
			findElement(By.id("dialogDeleteBtn")).click();
			screenShotPath = ExtentReport.capture(driver,TestScriptName);
			logger.pass("Employee_List Page - Dialog box appeared to confirm Delete action,it was checked and employee data deleted successfully ",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());   
			
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
