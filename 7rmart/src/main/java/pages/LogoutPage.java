package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LogoutPage {
	
	@FindBy(xpath = "//li[@class='nav-item dropdown']") WebElement admin_link;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']") WebElement logout_button;
	@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement signin_page;
	
	public WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}

	public void clickTheAdminPanel() {
		admin_link.click();
	}
	
	public void clikcTheLogoutButton() {
		logout_button.click();
	}
	
	public boolean isSignPageLoaded() {
		return signin_page.isDisplayed();
		
	}
	
	

}
