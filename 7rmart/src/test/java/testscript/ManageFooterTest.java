package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtilities;

public class ManageFooterTest extends Base{

	@Test
	public void verifyTheUserIsAbleToManageTheFooterText() throws IOException {
		
		String username = ExcelUtilities.getStringDate(1, 0, "login_page");
		String password = ExcelUtilities.getStringDate(1, 1, "login_page");
		
		String address = ExcelUtilities.getStringDate(1, 1, "footer_page");
		String email = ExcelUtilities.getStringDate(2, 1, "footer_page");
		String phonenumber = ExcelUtilities.getIntegerData(3, 1, "footer_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		
		ManageFooterPage managefooterpage = new ManageFooterPage(driver);
		managefooterpage.clickTheFooterMoreinfo();
		managefooterpage.clickTheFooterActionButton();
		managefooterpage.clearTheAddress();
		managefooterpage.updateTheAddress(address);
		managefooterpage.clearTheEmail();
		managefooterpage.updateTheEmail(email);
		managefooterpage.clearThePhoneNumber();
		managefooterpage.updateThePhoneNumber(phonenumber);
		managefooterpage.updateTheFooterButton();
		
		boolean alertmessage = managefooterpage.isAlertShown();
		Assert.assertTrue(alertmessage);
	}
}
