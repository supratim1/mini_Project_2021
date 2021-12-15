package Page_factory_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Nationalities {

WebDriver driver;
	
	public void Nationalities(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu_admin_viewAdminModule")
    WebElement Admin;  

    @FindBy(id="menu_admin_nationality")
    WebElement Nationality;  
	
    @FindBy(id="btnAdd")
    WebElement AddButton;  
    
    @FindBy(id="nationality_name")
    WebElement Nationality_name;  
    
    @FindBy(id="btnSave")
    WebElement Save_button;  
	
	public  void AddNationality() throws Exception
	{
		/*findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys("Mexican89");
		findElement(By.id("btnSave")).click();*/
		
		Thread.sleep(2000);
		Admin.click();
		Thread.sleep(2000);
		Nationality.click();
		Thread.sleep(2000);
		AddButton.click();
		Thread.sleep(2000);
		Nationality_name.sendKeys("Mexican991");
		Thread.sleep(2000);
		Save_button.click();
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














