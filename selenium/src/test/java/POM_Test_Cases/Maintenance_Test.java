package POM_Test_Cases;

import Page_Objects.*;
import common.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Maintenance_Test {

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
	public void TC_22_Add_Recruitment() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Alternate_LoginPage L1 = new Alternate_LoginPage();
		L1.Alternate_LoginPage(driver);
		L1.Login();
		
		MaintenancePage N1 = new MaintenancePage();
		N1.MaintenancePage(driver);
		N1.AddMaintenance();
		
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
