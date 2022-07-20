/**
 * 
 */
package alphaTests;

import org.testng.Assert;
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
			
			Thread.sleep(2000);
			String expectedUrl = "https://alphapay.netlify.app/auth/login";
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl);
			
}catch(Exception e) {
	
	
}
		
	}

}
