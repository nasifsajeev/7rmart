package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement news_moreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newsbutton;
	@FindBy(xpath = "//textarea[@id='news']") WebElement create_news;
	@FindBy(xpath = "//button[@type='submit']") WebElement save_button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alert_message;
	
	
	public WebDriver driver;
	public NewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}

	public void newsMoreInfo() {
		news_moreinfo.click();
	}
	
	public void createNews() {
		newsbutton.click();
		
	}
	
	public void enterNews(String news_message) {
		create_news.sendKeys(news_message);
	}
	
	public void saveNews() {
		save_button.click();
	}
	
	public boolean alertshown() {
		return alert_message.isDisplayed();
		
	}

}
