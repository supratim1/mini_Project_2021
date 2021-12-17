package Page_Factory_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login_Page_1 {

WebDriver driver;
public static Logger logger = LogManager.getLogger(Login_Page_1.class);	

	public void Login_Page_1(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 
 	@FindBy(name="txtUsername")
    WebElement UserName1;  


    @FindBy(name="txtPassword")
    WebElement Password1;  
    
    @FindBy(id="btnLogin")
    WebElement SignInButton1; 

	
	public void Login() throws Exception {
		
		Thread.sleep(2000);
		UserName1.sendKeys("Admin");
		logger.info("Username entered ");
		
		Thread.sleep(2000);
		Password1.sendKeys("admin123");
		logger.info("password entered ");
		
		
		Thread.sleep(2000);
		SignInButton1.click();
		logger.info("User logged in ");
		
		Thread.sleep(2000);
	}
	
	
	
	public WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	
}
