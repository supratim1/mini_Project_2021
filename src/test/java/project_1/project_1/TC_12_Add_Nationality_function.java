package project_1.project_1;

import CommonUtil.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TC_12_Add_Nationality_function {
 
  static WebDriver driver;
	
	//if u want to execute u r test with multiple input test data , we can user Data Provider
	
	//step1
	 @DataProvider(name = "Orange1")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Indians127_ab" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Indians128_cd" }
	        	};
	  }
	 
	 
	
  @Test(dataProvider = "Orange1") //step2 u r test will be connected to dataProvider 
  public void Test1(String TestURL,String UserName,String Password,String Nationality) throws Exception {   
	//step3 ensure number of parameters
		
		
		//OpenChromeBrowser
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();

		//OpenUrl
		driver.get(TestURL);
		

		//SendKeys
	     Thread.sleep(2000);
		 findElement(By.id("txtUsername")).sendKeys(UserName);
		 Thread.sleep(2000);
		 findElement(By.id("txtPassword")).sendKeys(Password);
		 Thread.sleep(2000);
		 findElement(By.id("btnLogin")).click();
		
		 Thread.sleep(2000);	  
		 findElement(By.linkText("Admin")).click();
		 Thread.sleep(2000);
		 findElement(By.linkText("Nationalities")).click();
		 Thread.sleep(2000);
		 findElement(By.name("btnAdd")).click();
		 Thread.sleep(2000);
		 findElement(By.id("nationality_name")).sendKeys(Nationality);
		 Thread.sleep(2000);
		 findElement(By.id("btnSave")).click();	
		 Thread.sleep(2000);
		
		 WebElement Element1 = findElement(By.linkText(Nationality));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", Element1);
			
		 Thread.sleep(2000);	  
		 driver.quit();	 
		 

	}
	

// Draws a red border around the found element. Does not set it back anyhow.
		public  WebElement findElement(By by) throws Exception {
			
		    WebElement elem = driver.findElement(by);
		    	    
		    // draw a border around the found element
		    if (driver instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		        
		  //  TH3.HTMLScreenShot("Screen Shot","Click Here","Pass", HtmlOutputFileName,driver);
		        
		    }
		    return elem;
		}
		
}
