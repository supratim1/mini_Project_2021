package data_driven_testing_DDT;


import org.openqa.selenium.JavascriptExecutor;
import utilities.ExcelApiTest4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Add_Nationality_Admin {

WebDriver driver;
	
	@DataProvider(name = "TC01_Add_Nationality")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C:\\Users\\sayantan_bose\\Desktop\\TC01_Nationality1.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
	
	@Test(dataProvider = "TC01_Add_Nationality")
	public void Test1(String TestURL,String UserName,String Password,String Nationality) throws Exception {
		
		//OpenChromeBrowser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		//OpenUrl
		driver.get(TestURL);
		Thread.sleep(2000);
		

		//SendKeys
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
		
		
		//JavascriptExecutor js1= (JavascriptExecutor) driver;
		//js1.executeScript("arguments[0].scrollIntoView();", findElement(By.linkText(Nationality)));
		
			
		
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
