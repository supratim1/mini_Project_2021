package Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage {

WebDriver driver;
	
	public void LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void Login() throws Exception {
		
		Thread.sleep(2000);
		findElement(By.name("txtUsername")).sendKeys("Admin");
		Thread.sleep(2000);
		findElement(By.name("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		findElement(By.id("btnLogin")).click();
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















