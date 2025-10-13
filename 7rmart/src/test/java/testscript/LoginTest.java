package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base{
	
	@Test(description = "User is able to login with valid credentials")
	public void verifyTheUserIsAbleToLoginWithValidCredentials() throws IOException {
//		String username = "admin";
//		String password = "admin";
		String username = ExcelUtilities.getStringDate(1, 0, "login_page");
		String password = ExcelUtilities.getStringDate(1, 1, "login_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		boolean homepage = loginpage.isHomePageLoaded();
		Assert.assertTrue(homepage,Constant.valid_credentials);
	}
	
	@Test
	public void verifyTheUserIsNotAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
//		String username = "admin";
//		String password = "sdfkjdshfk";
		String username = ExcelUtilities.getStringDate(2, 0, "login_page");
		String password = ExcelUtilities.getStringDate(2, 1, "login_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		boolean alertmessage = loginpage.isAlertShown();
		Assert.assertTrue(alertmessage);
	}
	
	@Test
	public void verifyTheUserIsNotAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
//		String username = "skjdfkjsh";
//		String password = "admin";
		String username = ExcelUtilities.getStringDate(3, 0, "login_page");
		String password = ExcelUtilities.getStringDate(3, 1, "login_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		boolean alertmessage = loginpage.isAlertShown();
		Assert.assertTrue(alertmessage);
	}
	
	@Test(dataProvider = "LoginProvider")
	public void verifyTheUserIsNotAbleToLoginWithInvalidUsernameAndInvalidPassword(String username , String password) throws IOException {
//		String username = "skjdfkjsh";
//		String password = "adkjfkjd";
//		String username = ExcelUtilities.getStringDate(4, 0, "login_page");
//		String password = ExcelUtilities.getStringDate(4, 1, "login_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		boolean alertmessage = loginpage.isAlertShown();
		Assert.assertTrue(alertmessage);
	}
	@DataProvider(name="LoginProvider") 
 	public Object[][] getDataFromTestData() throws IOException{ 
 		return new Object[][] {{ExcelUtilities.getStringDate(4, 0,"login_page"),ExcelUtilities.getStringDate(4,1,"login_page")}}; 
 		 
 	 
 	 
 	}

}
