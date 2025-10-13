package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void selectByIndex(WebElement element, int indexvalue) {
		Select select = new Select(element);
		select.selectByIndex(indexvalue);
	}
	
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void dragAndDrop(WebElement drag , WebElement drop, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).perform();
		
	}
	
	public void rightClick(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		
	}
	
	public void doubleclick(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
		
	}
	
	public void mouseOver(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		
	}

}
