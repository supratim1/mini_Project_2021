package Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Nationalities {

WebDriver driver;
	
	public void Nationalities(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void AddNationality() throws Exception
	{
		Thread.sleep(2000);
		findElement(By.id("menu_admin_viewAdminModule")).click();
		Thread.sleep(2000);
		findElement(By.id("menu_admin_nationality")).click();
		Thread.sleep(2000);
		findElement(By.id("btnAdd")).click();
		Thread.sleep(2000);
		findElement(By.id("nationality_name")).sendKeys("Mexican89");
		Thread.sleep(2000);
		findElement(By.id("btnSave")).click();
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











