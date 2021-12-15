package project_1.project_1;

import org.openqa.selenium.By;	

import org.openqa.selenium.WebDriver;			
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class TC_24_Delete_file {
 
	static WebDriver driver;
	 
	public String DestinationFile;
	
	//public  int iRow;
	
	// Draws a red border around the found element. Does not set it back anyhow.
	public WebElement findElement(By by)throws Exception {
	    WebElement elem = driver.findElement(by);
	 
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	    } 
	    Thread.sleep(10);
	    
	    return elem;
	    
	    
	 }
 	
    @Test
	public void File_Delete()throws Exception
	  {
		
		//SendKeys
    	     System.out.println("Start test");
	         System.setProperty("webdriver.chrome.driver", "C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize() ;	
			 driver.get("https://opensource-demo.orangehrmlive.com/");
			 
			 Thread.sleep(2000);
			 findElement(By.id("txtUsername")).sendKeys("Admin");
			 Thread.sleep(2000);
			 findElement(By.id("txtPassword")).sendKeys("admin123");
			 Thread.sleep(2000);
			 findElement(By.id("btnLogin")).click();
			 
			 Thread.sleep(2000);
		 	 findElement(By.linkText("PIM")).click();
		 	 Thread.sleep(2000);
		 	 findElement(By.id("menu_pim_viewEmployeeList")).click();
		 	 Thread.sleep(2000);
		 	 findElement(By.linkText("John")).click();
		 	 
		 	 Thread.sleep(2000);
		 	 findElement(By.name("chkattdel[]")).click();
		 	 Thread.sleep(2000);
			 findElement(By.id("btnDeleteAttachment")).click();
			   

			
			Thread.sleep(3000);
			driver.quit();
				
		}	 	 
		 	 
}
