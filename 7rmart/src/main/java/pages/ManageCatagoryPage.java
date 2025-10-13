package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtilities;

public class ManageCatagoryPage {
	 @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement catagory_moreinfo;
	 @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']") WebElement addcatogory_button;
	 @FindBy(xpath = "//input[@id='category']") WebElement catagory_field;
	 @FindBy(xpath = "//input[@id='main_img']") WebElement image_field;
	 
	 public WebDriver driver;
	 public ManageCatagoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver ,this);
	}

	 public void clickTheManageCatagoryMoreInfo() {
		 catagory_moreinfo.click();
	 }
	 
	 public void clickTheAddCatagoryButton() {
		 addcatogory_button.click();
	 }
	 
	 public void enterTheCatagory(String catagory_name) {
		 catagory_field.sendKeys(catagory_name);
	 }
	 
	 public void imageUpload() {
		 FileUploadUtilities fileuploadutilities = new FileUploadUtilities();
		 fileuploadutilities.fileUploadUsingSendkeys(image_field, Constant.TESTIMAGE );

}
}
