package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class=' nav-link']") WebElement contact_moreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']") WebElement contact_information;
	@FindBy(xpath = "//input[@id='phone']") WebElement phone_number;
	@FindBy(xpath = "//input[@id='email']") WebElement emailid;
	@FindBy(xpath = "//textarea[@id='content' and @name='address']") WebElement address;
	@FindBy(xpath = "//button[@name='Update' and @type='submit']") WebElement contact_update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement contact_alert;
	
	
	public WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void contactsMoreInfo() {
		contact_moreinfo.click();
		
	}
	
	public void clickContactsActionButton() {
		contact_information.click();
	}
	
	public void clearPhoneNumber() {
		phone_number.clear();
		
	}

	public void updatePhoneNumber(String phonenumber) {
		phone_number.sendKeys(phonenumber);
		
	}
	
	public void clearEmailid() {
		emailid.clear();
		
	}

	public void updateEmailid(String emailid2) {
		emailid.sendKeys(emailid2);
		
	}
	
	public void clearAddress() {
		address.clear();
	}
	
	public void updateAddress(String address2) {
		address.sendKeys(address2);
	}
	
	public void updateContactInformation() {
//		contact_update.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", contact_update);
	}
	
	public boolean isAlertShown() {
		return contact_alert.isDisplayed();
		
	}
	
	

}
