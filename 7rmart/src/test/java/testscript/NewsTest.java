package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtilities;

public class NewsTest extends Base{
	
	
	@Test
	public void verifyTheUserIsAbleToCreateTheNews() throws IOException {

		String username = ExcelUtilities.getStringDate(1, 0, "login_page");
		String password = ExcelUtilities.getStringDate(1, 1, "login_page");
		String news_message = ExcelUtilities.getStringDate(1, 0, "news_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignin();
		
		NewsPage newspage = new NewsPage(driver);
		newspage.newsMoreInfo();
		newspage.createNews();
		newspage.enterNews(news_message);
		newspage.saveNews();
	    boolean alertmessage = newspage.alertshown();
	    Assert.assertTrue(alertmessage);
		
	}
	

}
