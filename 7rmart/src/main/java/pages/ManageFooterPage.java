package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='nav-link']") WebElement footer_moreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']") WebElement footer_actionbutton;
	@FindBy(xpath = "//textarea[@id='content']") WebElement address;
	@FindBy(xpath = "//input[@id='email']") WebElement email;
	@FindBy(xpath = "//input[@id='phone']") WebElement phone;
	@FindBy(xpath = "//button[@name='Update']") WebElement update_footerbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	
	public WebDriver driver;
	public ManageFooterPage(WebDriver driver) {
	     this.driver = driver;
	     PageFactory.initElements( driver,this);
	}

	public void clickTheFooterMoreinfo() {
//		footer_moreinfo.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", footer_moreinfo);
	}
	
	public void clickTheFooterActionButton() {
		footer_actionbutton.click();
	}
	
	public void clearTheAddress() {
		address.clear();
	}
	
	public void updateTheAddress(String address2) {
		address.sendKeys(address2);
	}
	
	public void clearTheEmail() {
		email.clear();
	}
	
	public void updateTheEmail(String email2) {
		email.sendKeys(email2);
	}
	
	public void clearThePhoneNumber() {
		phone.clear();
	}

	public void updateThePhoneNumber(String phonenumber) {
	    phone.sendKeys(phonenumber);
		
	}
	
	public void updateTheFooterButton() {
		update_footerbutton.click();
	}
	
	public boolean isAlertShown() {
		return alert.isDisplayed();
		
	}

}


