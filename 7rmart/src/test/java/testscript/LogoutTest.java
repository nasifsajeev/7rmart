package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;

public class LogoutTest extends Base{
	
	
	@Test
	public void verifyTheUserIsAbleToLogoutTheHomePage() throws IOException {
		
//		String username = "admin";
//		String password = "admin";
		String username = ExcelUtilities.getStringDate(1, 0, "login_page");
		String password = ExcelUtilities.getStringDate(1, 1, "login_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickTheAdminPanel();
		logoutpage.clikcTheLogoutButton();
		boolean signinpage = logoutpage.isSignPageLoaded();
		Assert.assertTrue(signinpage);
	}

}
