package project_1.project_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TC_03_Driver_Navigate_back {

	WebDriver driver;	
	
	@Test
	public void login_test() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	
	Thread.sleep(3000);
	
	driver.navigate().to("https://google.co.in");
	
	Thread.sleep(3000);
	
	driver.navigate().back();
	
	Thread.sleep(3000);

	driver.quit();

	}
}
