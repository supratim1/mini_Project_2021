package Page_factory_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {

WebDriver driver;
	
	public void HomePage(WebDriver driver)
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
				Thread.sleep(2000);
				Logout1.click();
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

















