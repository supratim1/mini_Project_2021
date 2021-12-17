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

public class Login_function {

	 public XSSFWorkbook workbook = null;
	    public XSSFSheet sheet = null;
	    public XSSFRow row = null;
	    public XSSFCell cell = null;
	    
	    public FileOutputStream fout=null;
	    public FileInputStream fis = null;
	    
	    String TestURL,UserName,Password;
	    WebDriver driver;

	    @Test
	    public void hello()throws Exception
	    {
	    	
	    	Login_function eat = new Login_function();
	    	 
	    	 TestURL=eat.getCellData("C:\\Users\\sayantan_bose\\Desktop\\TC01_Nationality1.xlsx","Sheet1",1,0);
	    	 UserName=eat.getCellData("C:\\Users\\sayantan_bose\\Desktop\\TC01_Nationality1.xlsx","Sheet1",1,1);
			 Password=eat.getCellData("C:\\Users\\sayantan_bose\\Desktop\\TC01_Nationality1.xlsx","Sheet1",1,2);
			
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\sayantan_bose\\Downloads\\chromedriver_win32\\chromedriver.exe");
		     driver =new ChromeDriver();
			 driver.manage().window().maximize() ;	
			 driver.get(TestURL);
			 		
			 Thread.sleep(2000);
			 findElement(By.name("txtUsername")).sendKeys(UserName);
			 Thread.sleep(2000);
			 findElement(By.name("txtPassword")).sendKeys(Password);
			 Thread.sleep(2000);
			 findElement(By.id("btnLogin")).click();
			 
			 Thread.sleep(2000);
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
