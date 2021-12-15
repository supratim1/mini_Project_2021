package project_1.project_1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class TC_13_Date_Time_Picker {

	static WebDriver driver;

	@Test
	public void Test2() throws Exception {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		
		Thread.sleep(2000);
		findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(2000);
		findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		findElement(By.id("btnLogin")).click();
		
		Thread.sleep(2000);
		findElement(By.linkText("Leave")).click();
		Thread.sleep(2000);
		findElement(By.linkText("Leave List")).click();
		
		Thread.sleep(2000);
		findElement(By.xpath("//*[@id='frmFilterLeave']/fieldset/ol/li[1]/img")).click();
		
		
		Thread.sleep(2000);
		Select listbox5 =new Select(findElement(By.className("ui-datepicker-month")));
	 	 listbox5.selectByVisibleText("Mar");
	 	
	 	Thread.sleep(2000);
	 	Select listbox6 =new Select(findElement(By.className("ui-datepicker-year")));
	 	 listbox6.selectByVisibleText("2019");
	 	 
	 	Thread.sleep(2000);
		String str2="//*[contains(@href,'#') and text()='" + 23 +"']";
	 	Actions act1 = new Actions(driver);
	 	WebElement date2=findElement(By.xpath(str2));
	 	act1.moveToElement(date2).click().build().perform();
	 	
	 	Thread.sleep(5000);
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
