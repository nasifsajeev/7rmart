package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtilities {
	
	public void fileUploadUsingSendkeys(WebElement element , String filepath) {
		element.sendKeys(filepath);
	}
	
	public void fileUploadUsingRobotClass(WebElement element , String filepath) throws AWTException {
		StringSelection stringselection = new StringSelection(filepath);  //create stringselction class
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);   //copy the link 
	    Robot robot = new Robot();          //create robot class
	    robot.delay(2000);
	    robot.keyPress(KeyEvent.VK_CONTROL);   //key controls
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
