package POM_Test_Cases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Objects.Login_Page;
import common.*;

public class Login_Test extends BaseClass {

	@Test
	public void loginTest() throws IOException 
	{
		
		logger.info("URL is opened");
		
		Login_Page lp = new Login_Page(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("OrangeHRM"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
}
