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
import alphaPages.HomePage;
import alphaPages.LogOutPage;
import alphaPages.UpdateProfilePage;
import alphaUtilityClasses.Log;
import alphaUtilityClasses.TestConstant;
import alphaUtilityClasses.TestData;

/**
 * @author delphine.muoka
 *
 */

@Listeners(ListenersTestNG.class)

public class LogOutTest extends BaseClass{
	HomePage homepage;
	
	UpdateProfilePage updateprofilepage;
	LogOutPage logoutpage;
	
	
	@Test
	public void Logout() {
	
		
try {
			
			Log.info("Test Conditions Successfully");
			
			homepage = loginpage.UserLogin(TestData.getCellData(1, 0, TestConstant.Sheet1), TestData.getCellData(1, 1, TestConstant.Sheet1));
			
			updateprofilepage = homepage.ClickprofileLink();
			logoutpage = updateprofilepage.LogoutLink();
			
			WebDriverWait wait=new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.urlToBe("https://alphapay.netlify.app/auth/login"));
			
			
}catch(Exception e) {
	
	
}
String expectedUrl = "https://alphapay.netlify.app/auth/login";
String actualUrl = driver.getCurrentUrl();
Assert.assertEquals(actualUrl, expectedUrl);
		
	}

}
