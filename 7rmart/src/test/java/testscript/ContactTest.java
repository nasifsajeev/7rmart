package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.ContactPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class ContactTest extends Base{
	
	
	@Test
	public void enterTheUserIsAbleToUpdateTheContactDetails() throws IOException {
		

		String username = ExcelUtilities.getStringDate(1, 0, "login_page");
		String password = ExcelUtilities.getStringDate(1, 1, "login_page");
		String phonenumber = ExcelUtilities.getIntegerData(1, 1, "contact_details");
		String emailid = ExcelUtilities.getStringDate(2, 1, "contact_details");
		String address = ExcelUtilities.getStringDate(3, 1, "contact_details");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		
		ContactPage contactpage = new ContactPage(driver);
		contactpage.contactsMoreInfo();
		contactpage.clickContactsActionButton();
		contactpage.clearPhoneNumber();
		contactpage.updatePhoneNumber(phonenumber);
		contactpage.clearEmailid();
		contactpage.updateEmailid(emailid);
		contactpage.clearAddress();
		contactpage.updateAddress(address);
		contactpage.updateContactInformation();
		
		boolean alert = contactpage.isAlertShown();
		Assert.assertTrue(alert,Constant.UPDATECONTACT);
	}
	

}
