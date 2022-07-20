/**
 * 
 */
package alphaUtilityClasses;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author delphine.muoka
 *
 */
public class ListenersTestNG implements ITestListener{
	
	public void onStart(ITestContext context) {	
		Log.startTestCase("onStart method started");
	}

	public void onFinish(ITestContext context) {
		Log.startTestCase("onFinish method started");
	}
	
		public void onTestStart(ITestResult result) {
			Log.startTestCase("New Test Started" +result.getName());
		}
		
		public void onTestSuccess(ITestResult result) {
			Log.info("onTestSuccess Method" +result.getName());
		}

		public void onTestFailure(ITestResult result) {
			Log.info("onTestFailure Method" +result.getName());
		}

		public void onTestSkipped(ITestResult result) {
			Log.info("onTestSkipped Method" +result.getName());
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			Log.info("onTestFailedButWithinSuccessPercentage" +result.getName());
		}
}


