package Page_Factory_Model;

import org.testng.annotations.Test;
//import CommonUtil.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Nationalities1_test {

WebDriver driver;
	
	
	@BeforeTest 
	public void  TestSetup()throws Exception {
		
		System.out.println("Start test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	}
	
	@Test
	public void TC_12_Nationalities() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Login_Page_1 L1 = new Login_Page_1();
		L1.Login_Page_1(driver);
		L1.Login();
		
		Nationalities_1 N1= new Nationalities_1();
		N1.Nationalities_1(driver);
		N1.AddNationality();
		
		Home_Page_1 H1= new Home_Page_1();
		H1.Home_Page_1(driver);
		H1.Logout();
		
	}
	
	@AfterTest 
	public void  TestCloser()throws Exception {
		
		Thread.sleep(1000);
		driver.quit();
	}
	
}
