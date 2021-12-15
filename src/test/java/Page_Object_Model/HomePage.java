package Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {

WebDriver driver;
	
	public void HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void Logout() throws Exception
	 {
		        Thread.sleep(2000);
				findElement(By.id("welcome")).click();
				Thread.sleep(2000);
				findElement(By.linkText("Logout")).click();
				Thread.sleep(2000);
	 }
	
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	
	
}









