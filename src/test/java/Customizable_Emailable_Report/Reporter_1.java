package Customizable_Emailable_Report;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;
import java.text.SimpleDateFormat;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.*;

public class Reporter_1 {

  WebDriver driver;
	
	public  String OutputFolder,TestName="",TestName1="";
	public int Stepcount=0;
	
	public  String PassIcon  ="C:\\Users\\sayantan_bose\\Desktop\\Project\\passed.ico";
	public  String FailIcon  ="C:\\Users\\sayantan_bose\\Desktop\\Project\\failed.ico";
	

	


	public Reporter_1(WebDriver driver,String TestName)throws Exception {
		
		
		 
    Stepcount=0;
		
	SimpleDateFormat sdfDate5 = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
	Date now5 = new Date();
	String strDate6 = sdfDate5.format(now5);

	String OutputFolder1 ="C:\\Users\\sayantan_bose\\Desktop\\Project\\Screenshots_Emailable_Reports";
	//OutputFolder = OutputFolder1 	+ "\\" + "New_Folder_" +  strDate6;
	OutputFolder = OutputFolder1 	+ "\\" + TestName +"_"+  strDate6; 
	
	TestName1=TestName;
	this.driver=driver;
 }
	
	
	
/*	@Test
	public void Test1() throws Exception {
		
		Stepcount=0;
		
		driver = TestBrowser.OpenChromeBrowser();
		
		String TestURL = "  https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		//Reporter.log("The browser launched1");
		//TakeScreenShotAuto(driver);
		TakeScreenShotAuto(driver,"OpenBrowser","Pass");

		driver.findElement(By.xpath(OR.username_sendkey)).sendKeys("Admin");
		TakeScreenShotAuto(driver,"UserName Entered","Pass");
		//Reporter.log("The browser launched2");
		//TakeScreenShotAuto(driver);
		
		driver.findElement(By.xpath(OR.password_sendkey)).sendKeys("admin123");
		TakeScreenShotAuto(driver,"Password Entered","Pass");
		//Reporter.log("The browser launched3");
		//TakeScreenShotAuto(driver);
		
		driver.findElement(By.xpath(OR.login_click)).click();
		TakeScreenShotAuto(driver,"Sign In  Clicked","Fail");
		//TakeScreenShotAuto(driver);
		//Reporter.log("The browser launched4");
		//Reporter.log("<a href='file:///C:/Users/anbajaj/Desktop/test.xml'>Response</a>"); 


	}
	
	
	@Test
	public void Test2() throws Exception {
		
		Stepcount=0;
		
		driver = TestBrowser.OpenChromeBrowser();
		
		String TestURL = "  https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
		//Reporter.log("The browser launched1");
		//TakeScreenShotAuto(driver);
		TakeScreenShotAuto(driver,"OpenBrowser","Pass");

		driver.findElement(By.xpath(OR.username_sendkey)).sendKeys("Admin");
		TakeScreenShotAuto(driver,"UserName Entered","Pass");
		//Reporter.log("The browser launched2");
		//TakeScreenShotAuto(driver);
		
		driver.findElement(By.xpath(OR.password_sendkey)).sendKeys("admin123");
		TakeScreenShotAuto(driver,"Password Entered","Pass");
		//Reporter.log("The browser launched3");
		//TakeScreenShotAuto(driver);
		
		driver.findElement(By.xpath(OR.login_click)).click();
		TakeScreenShotAuto(driver,"Sign In  Clicked","Pass");
		//TakeScreenShotAuto(driver);
		//Reporter.log("The browser launched4");
		//Reporter.log("<a href='file:///C:/Users/anbajaj/Desktop/test.xml'>Response</a>"); 


	}
	
	*/
	
	


	public void TakeScreenShotAuto(WebDriver driver) throws Exception
	{
		
	
	 //Timestamp  append for .png file
	 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a"); 
	 Date now = new Date();
	 String strDate = sdfDate.format(now);
	 
	 //Takes screenshot
	 TakesScreenshot scrShot =((TakesScreenshot)driver);
	 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	     
	 //Move image file to new destination
	 String fileWithPath= OutputFolder +"\\"+TestName+"_"+strDate +".png";
	 File DestFile=new File(fileWithPath);

	      //Copy file at destination
	      try {
	              FileUtils.copyFile(SrcFile, DestFile);
	          } catch(Exception e ) {}
	              
	    
	     String ScreenShotPath = DestFile.getAbsolutePath();
		 ScreenShotPath = ScreenShotPath.replace("\\", "/");
		 
		 System.out.println("HTML Screen Shot Path : "+ScreenShotPath);
		
		 String str="<a href='file:///"
		 		+ ScreenShotPath
		 		+ "'>ScreenShot</a>";
	
		Reporter.log(str); 

	}
	
	
	
	
	
	public String getScreenShotPath(WebDriver driver) throws Exception
	{
		
	 //Timestamp  append for .png file
	 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a"); 
	 Date now = new Date();
	 String strDate = sdfDate.format(now);
	 
	 //Takes screenshot
	 TakesScreenshot scrShot =((TakesScreenshot)driver);
	 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	     
	 //Move image file to new destination
	 String fileWithPath= OutputFolder +"\\"+TestName+"_"+strDate +".png";
	 File DestFile=new File(fileWithPath);

	      //Copy file at destination
	      try {
	              FileUtils.copyFile(SrcFile, DestFile);
	          } catch(Exception e ) {}
	              
	    
	     String ScreenShotPath = DestFile.getAbsolutePath();
		 ScreenShotPath = ScreenShotPath.replace("\\", "/");
		 
		 System.out.println("HTML Screen Shot Path : "+ScreenShotPath);
		
		 String str="<a href='file:///"
		 		+ ScreenShotPath
		 		+ "'>ScreenShot</a>";
		 
		 String ScreenShot2= "<a href=" + ScreenShotPath + " target=\"popup\" "
		    		+ "onclick=\"window.open('"
		    		+ ScreenShotPath
		    		+ "','popup','width=600,height=600'); return false;\"> " + "ScreenShot" + "</a> ";
	
		//Reporter.log(str); 
		
		//return ScreenShot2;
		 return fileWithPath;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void TakeScreenShotAuto(WebDriver driver,String Textmsg,String PassorFail) throws Exception
	{
		
	
	 //Timestamp  append for .png file
	 SimpleDateFormat sdfDate = new SimpleDateFormat("dd_MMM_yyyy h_mm_ss_SSS a"); 
	 Date now = new Date();
	 String strDate = sdfDate.format(now);
	 
	 //Takes screenshot
	 TakesScreenshot scrShot =((TakesScreenshot)driver);
	 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	     
	 //Move image file to new destination
	 String fileWithPath= OutputFolder +"\\"+TestName+"\\"+strDate +".png";
	 File DestFile=new File(fileWithPath);

	      //Copy file at destination
	      try {
	              FileUtils.copyFile(SrcFile, DestFile);
	          } catch(Exception e ) {}
	              
	    
	     String ScreenShotPath = DestFile.getAbsolutePath();
		 ScreenShotPath = ScreenShotPath.replace("\\", "/");
		 
		 System.out.println("HTML Screen Shot Path : "+ScreenShotPath);
		
		 String ScreenShot1="<a href='file:///"
		 		+ ScreenShotPath
		 		+ "'>ScreenShot</a>";
		 
		 String ScreenShot2= "<a href=" + ScreenShotPath + " target=\"popup\" "
		    		+ "onclick=\"window.open('"
		    		+ ScreenShotPath
		    		+ "','popup','width=600,height=600'); return false;\"> " + "ScreenShot" + "</a> ";
		 
		 
		 String PASS="<img src='file:///"
			 		+ PassIcon
			 		+ "'    +     \"width=\"30\" + height=\"30\"></img>";
		 
		 String FAIL="<img src='file:///"
			 		+ FailIcon
			 		+ "'    +     \"width=\"30\" + height=\"30\"></img>";
		 
		 
			SimpleDateFormat sdfDate5 = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
			Date now5 = new Date();
			String strDate6 = sdfDate5.format(now5);
			
		
		 
		
		 
		 String Textmsg1="<b><font color='black'>   "
		 		+ Textmsg +
				 "</b> </font>";
		 
		 Stepcount = Stepcount+1;
		
		 String Str2= "Step" + "&nbsp;"+ Stepcount 
				 + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				 + Textmsg1 +
				 " " +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
		 + ScreenShot2 + " "  +  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
		 +  strDate6    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"    + PASS + "<br>";
		 
		 
		 
		// String Textmsg3=" <table><tr> <th height=\"40px\" width=\"50px\"  > <th height=\"40px\" width=\"50px\"  > <center>S.No</center></th><th width=\"250px\"> <center>Steps</center> </th> <th width=\"250px\" ><center>Details </center></th> <th width=\"150px\" ><center>Status</center></th>  <th  width=\"150px\"  ><center>Screen Shots</center></th> <th width=\"200px\"  ><center>Date & Time</center></th> 	 </tr>  </table>     ";
			
		
		 
		 String logo = "C:\\Users\\sayantan_bose\\Desktop\\Project\\Logo2.JPEG";
		 
		 String Textmsg3="<table> "
				
				+ "<tr > " 
				
				+ " <img   style=\"border:1px solid black;\"      src=\"C:\\Users\\sayantan_bose\\Desktop\\Project\\Logo2.JPEG\">" 
				
				+"</tr>"
				+ "<tr   ><center><font color=\"red\"  size=\"15\" >" + TestName1 +"</font></center></tr>" 
				+  "<tr bgcolor=\"#9370DB\"> <th width=\"100px\"> <center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Steps" + "</font></center>" + "<font color=\"white\"  size=\"4\" >" 
		 		+ "</font></center> </th> <th width=\"450px\" ><center>" + "<font color=\"white\"  size=\"4\" >" 
		 		+ "Details "
		 		+ "</font> </center></th> <th width=\"100px\" ><center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Status"
		 		+ "</font></center></th>  <th  width=\"250px\"  ><center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Screen Shots"
		 		+ "</font></center></th> <th width=\"250px\"  ><center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Date & Time"
		 		+ "</font></center></th> 	 </tr>       ";
		 
	String Textmsg4=" <tr bgcolor=\"#eee\"> <th width=\"100px\"> <center>"
			 		+ "Step" + "&nbsp;"+ Stepcount 
			 		+ "</center> </th> <th width=\"450px\" ><center>"
			 		+ Textmsg1
			 		+ "</center></th> <th width=\"100px\" ><center>"
			 		+ PASS
			 		+ "</center></th>  <th  width=\"250px\"  ><center>"
			 		+ ScreenShot2
			 		+ "</center></th> <th width=\"250px\"  ><center>"
			 		+ strDate6
			 		+ "</center></th> 	 </tr>      ";
	

	
	String Textmsg5=" <tr bgcolor=\"#ddd\"> <th width=\"100px\"> <center>"
	 		+ "Step" + "&nbsp;"+ Stepcount 
	 		+ "</center> </th> <th width=\"450px\" ><center>"
	 		+ Textmsg1
	 		+ "</center></th> <th width=\"100px\" ><center>"
	 		+ PASS
	 		+ "</center></th>  <th  width=\"250px\"  ><center>"
	 		+ ScreenShot2
	 		+ "</center></th> <th width=\"250px\"  ><center>"
	 		+ strDate6
	 		+ "</center></th> 	 </tr>      ";
	
	
	
	
	
	
	String Textmsg6=" <tr bgcolor=\"#eee\"> <th width=\"100px\"> <center>"
	 		+ "Step" + "&nbsp;"+ Stepcount 
	 		+ "</center> </th> <th width=\"450px\" ><center>"
	 		+ Textmsg1
	 		+ "</center></th> <th width=\"100px\" ><center>"
	 		+ FAIL
	 		+ "</center></th>  <th  width=\"250px\"  ><center>"
	 		+ ScreenShot2
	 		+ "</center></th> <th width=\"250px\"  ><center>"
	 		+ strDate6
	 		+ "</center></th> 	 </tr>      ";



String Textmsg7=" <tr bgcolor=\"#ddd\"> <th width=\"100px\"> <center>"
		+ "Step" + "&nbsp;"+ Stepcount 
		+ "</center> </th> <th width=\"450px\" ><center>"
		+ Textmsg1
		+ "</center></th> <th width=\"100px\" ><center>"
		+ FAIL
		+ "</center></th>  <th  width=\"250px\"  ><center>"
		+ ScreenShot2
		+ "</center></th> <th width=\"250px\"  ><center>"
		+ strDate6
		+ "</center></th> 	 </tr>      ";

	
	
	


String Textmsg8="<table> "

				+ "<tr > " 
				
				+ " <img   style=\"border:1px solid black;\"      src=\"C:\\Users\\sayantan_bose\\Desktop\\Project\\Logo2.JPEG\">" 
				
				+"</tr>"
				+ "<tr   ><center><font color=\"red\"  size=\"15\" >" + TestName1 +"</font></center></tr>" 
				+  "<tr bgcolor=\"#9370DB\"> <th width=\"100px\"> <center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Steps" + "</font></center>" + "<font color=\"white\"  size=\"4\" >" 
		 		+ "</font></center> </th> <th width=\"450px\" ><center>" + "<font color=\"white\"  size=\"4\" >" 
		 		+ "Details "
		 		+ "</font> </center></th> <th width=\"100px\" ><center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Status"
		 		+ "</font></center></th>  <th  width=\"250px\"  ><center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Screen Shots"
		 		+ "</font></center></th> <th width=\"250px\"  ><center>" + "<font color=\"white\"  size=\"4\" >"
		 		+ "Date & Time"
		 		+ "</font></center></th> 	 </tr>       ";
		 
	String Textmsg9=" <tr bgcolor=\"#eee\"> <th width=\"100px\"> <center>"
			 		+ "Step" + "&nbsp;"+ Stepcount 
			 		+ "</center> </th> <th width=\"450px\" ><center>"
			 		+ Textmsg1
			 		+ "</center></th> <th width=\"100px\" ><center>"
			 		+ FAIL
			 		+ "</center></th>  <th  width=\"250px\"  ><center>"
			 		+ ScreenShot2
			 		+ "</center></th> <th width=\"250px\"  ><center>"
			 		+ strDate6
			 		+ "</center></th> 	 </tr>      ";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			 
		 
		 String Str3= "Step" + "&nbsp;"+ Stepcount 
				 + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				 + Textmsg1 +
				 " " +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
		 + ScreenShot2 + " "  +  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
		 +  strDate6    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"    + FAIL + "<br>";
		 
		 
		
		 if(PassorFail.equals("Pass"))
		 {
			 // Reporter.log(Str2); 
			 
			 if (Stepcount==1)
			 {
					 Reporter.log(Textmsg3); 
					 Reporter.log(Textmsg4); 
			 }
			 else
			 {
				 
				 if(Stepcount%2==0) 
				 {
					 
					 Reporter.log(Textmsg5); 
				 }
				 else
				 {
					 Reporter.log(Textmsg4); 
				 }
				 
				 
			 }
				 
		 }
		 else
		 {
		 //Reporter.log(Str3); 
			 if (Stepcount==1)
			 {
					 Reporter.log(Textmsg8); 
					 Reporter.log(Textmsg9); 
			 }
			 else
			 {
				 
				 if(Stepcount%2==0) 
				 {
					 
					 Reporter.log(Textmsg7); 
				 }
				 else
				 {
					 Reporter.log(Textmsg6); 
				 }
				 
				 
			 }
			 
			 
		 }
		
	

		
		
		
	//	String str3="<table>" + "<tr>"  +   "<th height=" + "40px" + "width=" + "50px" + ">" + "<center>S.No</center></th> "
		//	+ 	 "<th width=" + "250px" +">" + "width=" + "50px" + ">" + "<center>S.No</center></th> " + "</table>";
		 
		//Reporter.log(str3); 
		
	/*	<table id=customers>
		 <tr>
		  <th height="40px" width="50px"  ><center>S.No</center></th>  
		  <th width="250px"    ><center>Steps</center> </th>   
		   <th width="250px" ><center>Details </center></th>  
		  <th width="150px" ><center>Status</center></th> 
		  <th  width="150px"  ><center>Screen Shots</center></th>  
		  <th width="200px"  ><center>Date & Time</center></th>  
		 </tr>*/

	}
	
}







