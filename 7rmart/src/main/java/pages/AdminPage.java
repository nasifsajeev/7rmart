package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;

public class AdminPage {
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'  and @class='small-box-footer']") WebElement user_moreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement createuser_button;
	@FindBy(xpath = "//input[@id='username']") WebElement username;
	@FindBy(xpath = "//input[@id='password']") WebElement password;
	@FindBy(xpath = "//select[@id='user_type']") WebElement usertype;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']") WebElement create_button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	public WebDriver driver;
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver , this);
	}

	public void clickUserMoreInfo() {
		user_moreinfo.click();
	}
	
	public void clickCreateUserButton() {
		createuser_button.click();
	}
	
	public void enterTheUserName(String newuser) {
		username.sendKeys(newuser);
	}
	
	public void enterThePassword(String newpassword) {
		password.sendKeys(newpassword);
	}
	
	public void selectTheUserType() {
//		usertype.click();
//		Select select = new Select(usertype);
//		select.selectByValue("admin");
		PageUtility pageutility = new PageUtility();
		pageutility.selectByValue(usertype, "admin");
	}
	
	public void clickTheCreateButton() {
		create_button.click();
	}
	
	public boolean isAlertShown() {
		return alert.isDisplayed();
		
	}
	
	

}
