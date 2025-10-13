package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int counter = 0;
	int retry_limit = 2;
	
	public boolean retry(ITestResult result) {
		if(counter < retry_limit) {
			counter++;
			return true;
		}
		return false;
		
	}

}
