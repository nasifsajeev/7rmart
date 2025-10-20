package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminTest extends Base{
	
	
	@Test(retryAnalyzer =retry.Retry.class,groups = "regression")
	public void verifyTheUserIsAbleToCreateNewUsers() throws IOException {

		String username = ExcelUtilities.getStringDate(1, 0, "login_page");
		String password = ExcelUtilities.getStringDate(1, 1, "login_page");
		
		FakerUtility fakerutility = new FakerUtility();
		String newuser = fakerutility.creatARandomFirstName();
		String newpassword = fakerutility.creatARandomLastName();
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		
		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickUserMoreInfo();
		adminpage.clickCreateUserButton();
		adminpage.enterTheUserName(newuser);
		adminpage.enterThePassword(newpassword);
		adminpage.selectTheUserType();
		adminpage.clickTheCreateButton();
		boolean alertmessage = adminpage.isAlertShown();
		Assert.assertTrue(alertmessage,Constant.ADDADMIN_USER);
	}

}
