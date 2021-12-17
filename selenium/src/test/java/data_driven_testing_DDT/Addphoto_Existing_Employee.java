package data_driven_testing_DDT;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.*;
import org.apache.poi.ss.usermodel.CellType;

import utilities.ExcelApiTest4;
import org.testng.annotations.*;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Addphoto_Existing_Employee {

	public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
    
    public FileOutputStream fout=null;
    public FileInputStream fis = null;
    
    String EMPID,UserName,Password,PhotoPath;
    WebDriver driver;
    
    @Test
    public void hello()throws Exception
    {
    	
    	Addphoto_Existing_Employee eat = new Addphoto_Existing_Employee();
    	 
    
    	 UserName=eat.getCellData("C:\\Users\\sayantan_bose\\Desktop\\TC02_Photo_add.xlsx","Sheet1",1,0);
		 Password=eat.getCellData("C:\\Users\\sayantan_bose\\Desktop\\TC02_Photo_add.xlsx","Sheet1",1,1);
		 EMPID = eat.getCellData("C:\\Users\\sayantan_bose\\Desktop\\TC02_Photo_add.xlsx","Sheet1",1,2);
	     PhotoPath = eat.getCellData("C:\\Users\\sayantan_bose\\Desktop\\TC02_Photo_add.xlsx","Sheet1",1,3);
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
	     driver = new ChromeDriver();
		 driver.manage().window().maximize() ;	
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		 
		 Thread.sleep(2000);
		 findElement(By.name("txtUsername")).sendKeys(UserName);
		 Thread.sleep(2000);
		 findElement(By.name("txtPassword")).sendKeys(Password);
		 Thread.sleep(2000);
		 findElement(By.id("btnLogin")).click();
		 
		 Thread.sleep(2000);
		 findElement(By.linkText("PIM")).click();
		 Thread.sleep(2000);
		 findElement(By.linkText("Employee List")).click();
		 Thread.sleep(2000);
		 findElement(By.id("empsearch_id")).sendKeys(EMPID);
		 Thread.sleep(2000);
		 findElement(By.id("searchBtn")).click();
		 Thread.sleep(2000);
		 findElement(By.linkText(EMPID)).click();
		 Thread.sleep(2000);
		 findElement(By.id("empPic")).click();
		 Thread.sleep(2000);
		 
		 //*[@id="photofile"]
		 findElement(By.xpath("//*[@id='photofile']")).click();
		 
		// Specify the file location with extension
		// StringSelection sel = new StringSelection("C:\Users\sayantan_bose\Desktop\Mahesh.jpg");
			 
		     Thread.sleep(2000);
			 StringSelection sel = new StringSelection(PhotoPath);
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
			 //System.out.println("selection" +sel);
			
			 // Creating object of Robot class
			 Robot robot = new Robot();
			 Thread.sleep(2000);
			 
			  // Press CTRL+V
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(2000);
			 
			// Release CTRL+V
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyRelease(KeyEvent.VK_V);
			 Thread.sleep(2000);
			        
			 // Press Enter 
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(5000);
		
			 findElement(By.id("btnSave")).click();
			 Thread.sleep(4000);
			 driver.quit();
		 
		 
}
    
    public String getCellData(String xlFilePath, String sheetName,int rowNum,int column) throws Exception
    {
    	fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(column);
       
        if(cell.getCellTypeEnum() == CellType.STRING)
        {	
        	String str6=cell.getStringCellValue();
        	workbook.close();
        	fis.close();
            return str6;
        }
        
        else if(cell.getCellTypeEnum() == CellType.NUMERIC)
        {	
        	
        	int i = (int)cell.getNumericCellValue(); 
        	String str6 = String.valueOf(i); 
        	workbook.close();
        	fis.close();
            return str6;
        }
        else 
        {
        	String str6=cell.getStringCellValue();
        	workbook.close();
        	fis.close();
            return str6;
        }
        
    } 
    
      
    
    public  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}

}
