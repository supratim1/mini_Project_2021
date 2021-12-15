package project_1.project_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_05_Driver_Get_Commands {

	WebDriver driver;	
	
	@Test
	public void login_test() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	String actualTitle=driver.getTitle();
	System.out.println("Title is "+actualTitle);
	
	 if (actualTitle.contentEquals("OrangeHRM")){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
	
	
	
	System.out.println("**************2nd Starts*********");
	
	String CurrentUrl=driver.getCurrentUrl();
	System.out.println("Title is "+CurrentUrl);
	
	System.out.println("**************3rd Starts*********");
	
	String logInPanelHeading1=driver.findElement(By.id("logInPanelHeading")).getText();
	System.out.println("Panel Heading is "+logInPanelHeading1);
	
	System.out.println("**************4th Starts*********");
	
	System.out.println("Page Source"+driver.getPageSource());
	
	


	}


}
