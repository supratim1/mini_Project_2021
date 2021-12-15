package Page_factory_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage {

WebDriver driver;
	
	public void LoginPage(WebDriver driver)
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
		Thread.sleep(2000);
		Password1.sendKeys("admin123");
		Thread.sleep(2000);
		SignInButton1.click();
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

















