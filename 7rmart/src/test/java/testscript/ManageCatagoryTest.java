package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCatagoryPage;
import utilities.ExcelUtilities;

public class ManageCatagoryTest extends Base{
	
	
	@Test
	public void verifyTheUserIsAbleToAddNewCatagoryDetails() throws IOException {
		
		
		String username = ExcelUtilities.getStringDate(1, 0, "login_page");
		String password = ExcelUtilities.getStringDate(1, 1, "login_page");

		String catagory_name = ExcelUtilities.getStringDate(1, 0, "product_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		
		ManageCatagoryPage managecatogorypage = new ManageCatagoryPage(driver);
		managecatogorypage.clickTheManageCatagoryMoreInfo();
		managecatogorypage.clickTheAddCatagoryButton();
		managecatogorypage.enterTheCatagory(catagory_name);
		managecatogorypage.imageUpload();
	}

}
