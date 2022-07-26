/**
 * 
 */
package alphaTests;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import alphaPages.BaseClass;
import alphaUtilityClasses.Log;
import alphaUtilityClasses.TestConstant;
import alphaUtilityClasses.TestData;

/**
 * @author delphine.muoka
 *
 */
@Listeners(ListenersTestNG.class)

public class LoginTest extends BaseClass{

	
	
	@Test(priority = 1)
	public void ValidateWrongUsernameAndWrongPassword() {
		
		validateInvalidCredentials(1);
	
	}
	
	@Test(priority = 2)
	public void ValidateWrongUsernameAndValidPassword() {
		
		validateInvalidCredentials(2);
		
	}
	
	@Test(priority = 3)
	public void ValidateValidUsernameAndWrongPassword() {
		
		validateInvalidCredentials(3);
		
	}
	
	@Test(priority = 4)
	public void ValidatewrongUsernameAndEmptyPassword() {
		
		validateInvalidCredentials(4);
		
	}
	
	@Test(priority = 5)
	public void ValidateEmptyUsernameAndWrongPassword() {
		
		validateInvalidCredentials(5);
		
	}
	
	@Test(priority = 6)
	public void ValidateEmptyUsernameAndEmptyPassword() {
		
		validateInvalidCredentials(6);
		
	}
	
	@Test(priority = 7)
	public void validateValidCredentials() {
		
		int irow = 1;
		
		try {
			Log.info("Test Conditions -----------"+TestData.getCellData(irow, 2, TestConstant.Sheet1));
			
			loginpage.UserLogin(TestData.getCellData(irow, 0, TestConstant.Sheet1), TestData.getCellData(irow, 1, TestConstant.Sheet1));
		    
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlToBe("https://alphapay.netlify.app/dashboard/overview"));
			String expectedUrl = "https://alphapay.netlify.app/dashboard/overview";
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl);
				
		} catch (Exception e) {
			
			
			String Exmessage = e.toString();		
		    Log.error(Exmessage);	
		
		
		}}
	
	
	// Reuseable Method for Invalid Credentials
	public void validateInvalidCredentials(int irow) {		
		
	try {
		
		Log.info("Test Conditions -----------"+TestData.getCellData(irow, 2, TestConstant.Sheet2));
		
		 loginpage.UserLogin(TestData.getCellData(irow, 0, TestConstant.Sheet2), TestData.getCellData(irow, 1, TestConstant.Sheet2));
		
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe("https://alphapay.netlify.app/auth/login"));
		
	} catch (Exception e) {
		
		String Exmessage = e.toString();		
		Log.error(Exmessage);

		}
	String expectedUrl = "https://alphapay.netlify.app/auth/login";
	String actualUrl = driver.getCurrentUrl();
	Assert.assertEquals(actualUrl, expectedUrl);
	}
		
	
	
		
		
	}

	


