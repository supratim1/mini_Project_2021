package data_driven_testing_DDT;


//import HTMLReport.TestHTMLReporter8;
//import HTMLReport.TestHTMLReporter8;
import utilities.ExcelApiTest3;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.interactions.Actions;

public class Addphoto_New_Employee {

	public  static 	String UserName, Password ;
	public  static String FirstName, MiddleName, LastName, Id, PhotoPath;
	public static int iRow = 0;
    WebDriver driver;
    
	// Draws a red border around the found element. Does not set it back anyhow.
	public  WebElement findElement(By by)throws Exception {
		    WebElement elem = driver.findElement(by);
		 
		    // draw a border around the found element
		    if (driver instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		    } 
		    Thread.sleep(1000);
		    
		    return elem;
		}
		
		@DataProvider (name = "TC01_Add_Employee_Data")
	    public static  Object[][] Authentication1() throws Exception{
			
			ExcelApiTest3 eat= new ExcelApiTest3();
	        Object[][] testObjArray = eat.getTableArray("C:\\Users\\sayantan_bose\\Desktop\\TC01_AddEmp.xls", "Sheet1");
	        System.out.println(testObjArray.length);
	        return (testObjArray); 
		}
		
		
		@Test(dataProvider="TC01_Add_Employee_Data")
		public void AddEmployee_call_allmethods(
				String UserName,String Password,String FirstName,
				String MiddleName,String LastName,String Id,String PhotoPath )throws Exception
		{  
				
			    System.out.println("Start test");
	            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
			    driver = new ChromeDriver();
			    driver.manage().window().maximize() ;	

				openOrangeHRM();
				OrangeHRMlogin(UserName,Password);
			    //addEmpdetails(FirstName, MiddleName,LastName,Id);
				Existing_Employee();
				PhotoUpload(PhotoPath);
				CloseBrowser();
				
		}	
		
  public void openOrangeHRM()throws Exception
		 {

			 driver.get("https://opensource-demo.orangehrmlive.com/");
			
		 }
		 
  public void OrangeHRMlogin(String UserName,String Password)throws Exception
		 {
	         Thread.sleep(2000);
			 findElement(By.name("txtUsername")).sendKeys(UserName);
			 Thread.sleep(2000);
			 findElement(By.name("txtPassword")).sendKeys(Password);
			 Thread.sleep(2000);
			 findElement(By.id("btnLogin")).click();
			 Thread.sleep(2000);
		 }
		 
    public void CloseBrowser() throws Exception 
		 {
			
	        Thread.sleep(2000);
		    driver.quit(); 

		 }
		
		
    public void PhotoUpload(String PhotoPath)throws Exception
		{
			
			 findElement(By.xpath("//*[@id='photofile']")).click();
             Thread.sleep(2000);
			 
			 // Specifying the file location with extension
			 // StringSelection sel = new StringSelection("C:\Users\sayantan_bose\Desktop\Mahesh.jpg");
			 
			 StringSelection sel = new StringSelection(PhotoPath);
			 // Copying to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
			 System.out.println("selection" +sel);
			 
			 // Creating object of Robot class
			 Robot robot = new Robot();
			 Thread.sleep(2000);

			 // Press CTRL+V
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 
			 // Release CTRL+V
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyRelease(KeyEvent.VK_V);
			 Thread.sleep(2000);
			        
			 // Press Enter 
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(4000);
		     findElement(By.id(" ")).click();
			
		     Thread.sleep(4000);
			 
	}
		
   public void addEmpdetails(String FirstName,String MiddleName,String LastName,String Id )throws Exception
		{  
	         Thread.sleep(2000);		
			 Actions actions = new Actions(driver);   
			 WebElement ele = findElement(By.name(" "));
			 actions.moveToElement(ele).click().perform();

			 Thread.sleep(2000);
			 findElement(By.id("menu_pim_addEmployee")).click();
			 Thread.sleep(2000);
	         findElement(By.id("btnAdd")).click();
	         Thread.sleep(2000);
			 findElement(By.id("firstName")).sendKeys(FirstName);
			 Thread.sleep(2000);
			 findElement(By.id("middleName")).sendKeys(MiddleName);
			 Thread.sleep(2000);
		     findElement(By.id("lastName")).sendKeys(LastName);
		     Thread.sleep(2000);
			 findElement(By.id("employeeID")).sendKeys(Id);
			 Thread.sleep(2000);
			 findElement(By.id("btnSave")).click();
	         Thread.sleep(2000);
			 
		}
		
   public void Existing_Employee( )throws Exception
		{  
	         Thread.sleep(2000);
			 findElement(By.linkText("PIM")).click();	
			 Thread.sleep(2000);
			 findElement(By.linkText("Employee List")).click();
			 Thread.sleep(2000);
			 findElement(By.id("empsearch_id")).sendKeys("0002");
			 Thread.sleep(2000);
			 findElement(By.id("searchBtn")).click();
			 Thread.sleep(2000);
			 
			 Thread.sleep(2000);
			 findElement(By.linkText("0002")).click();
			 Thread.sleep(2000);
			 findElement(By.id("empPic")).click();
			 Thread.sleep(2000);
		}
	
}
