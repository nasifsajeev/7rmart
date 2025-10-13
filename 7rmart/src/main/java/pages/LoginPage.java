package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//input[@name='username']") WebElement username;
	@FindBy(xpath = "//input[@name='password']") WebElement password;
	@FindBy(xpath = "//button[@type='submit']") WebElement sign_in;
	@FindBy(xpath = "//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alert;
	
    public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterTheUserName(String username2) {
		username.sendKeys(username2);
		
	}
	
	public void enterThePassword(String password2) {
		password.sendKeys(password2);
		
	}
	
	public void clickTheSignin() {
		sign_in.click();
		
	}
	
	public boolean isHomePageLoaded() {
		return dashboard.isDisplayed();	
		
	}
	
	public boolean isAlertShown() {
		return alert.isDisplayed();
		
	}

}
