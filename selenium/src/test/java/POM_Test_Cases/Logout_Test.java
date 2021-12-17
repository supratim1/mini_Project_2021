package POM_Test_Cases;

import Page_Objects.*;
import common.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Logout_Test {

WebDriver driver;
	
	@BeforeTest 
	public void TestSetup()throws Exception {
		
		System.out.println("Start test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
	
	
	@Test
	public void TC_16a() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Alternate_LoginPage  L1 = new Alternate_LoginPage();
		L1.Alternate_LoginPage (driver);
		L1.Login();
		
		HomePage H1 = new HomePage();
		H1.HomePage(driver);
		H1.Logout();
		
	}
	
	@AfterTest 
	public void TestCloser()throws Exception {
		
		Thread.sleep(1000);
		driver.quit();
	}
	
}
