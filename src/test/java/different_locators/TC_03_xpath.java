package different_locators;

import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class TC_03_xpath {
 
static WebDriver driver;
	
	//*[@id='txtUsername']
	//*[@id='txtPassword']
	//*[@id='btnLogin']
	
	static String  UserName="//*[@id='txtUsername']";
	static String  Password="//*[@id='txtPassword']";
	static String  Loginbutton="//*[@id='btnLogin']";
	static String  Admin="//*[@id='menu_admin_viewAdminModule']/b";
	static String  Nationality="//*[@id='menu_admin_nationality']";

	@Test
	public void Test2() throws Exception {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		Thread.sleep(2000);
		findElement(By.xpath(UserName)).sendKeys("Admin");
		Thread.sleep(2000);
		findElement(By.xpath(Password)).sendKeys("admin123");
		Thread.sleep(2000);
		findElement(By.xpath(Loginbutton)).click();
		
		Thread.sleep(2000);
		findElement(By.xpath(Admin)).click();
		Thread.sleep(2000);
		findElement(By.xpath(Nationality)).click();
		
		Thread.sleep(2000);
		driver.quit();
		

	}
	
	
	public  WebElement findElement(By by) throws Exception 
{

	WebElement elem = driver.findElement(by);  
	
	if (driver instanceof JavascriptExecutor) 
	{
	 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
 
	}
	return elem;
}

}
