package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtilities;

public class Base {
	
	Properties properties;
	FileInputStream fileinputstream;
	WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void browserInitialization(String browser) throws Exception {
		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		else {
			throw new Exception ("invalid");
		}
		
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.IMPLICITWAIT));
		driver.manage().window().maximize();
	}
	
//	@AfterMethod
//	public void quitAndClose() {
//		driver.close();
//		driver.quit();
//	}
	 @AfterMethod
	 public void browserQuit(ITestResult iTestResult) throws IOException { 
	 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
	 			ScreenshotUtility scrshot = new ScreenshotUtility(); // creating obj 
	 			scrshot.getScreenShot(driver, iTestResult.getName()); 
	 		}
//	 		driver.quit();

	 }
}
