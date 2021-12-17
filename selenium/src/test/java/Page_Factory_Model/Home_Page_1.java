package Page_Factory_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Home_Page_1 {

WebDriver driver;
public static Logger logger = LogManager.getLogger(Home_Page_1.class);

	public void Home_Page_1(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="welcome")
    WebElement welcome1;  

    @FindBy(linkText="Logout")
    WebElement Logout1;  
    

	public void Logout() throws Exception
	 {
		        Thread.sleep(2000);
				welcome1.click();
				logger.fatal("Navigated to Home Page");
				
				Thread.sleep(2000);
				Logout1.click();
				logger.info("User logged out successfully");
				
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
