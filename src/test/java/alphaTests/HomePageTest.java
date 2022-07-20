/**
 * 
 */
package alphaTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import alphaPages.BaseClass;
import alphaPages.HomePage;
import alphaUtilityClasses.Log;
import alphaUtilityClasses.TestConstant;
import alphaUtilityClasses.TestData;


/**
 * @author delphine.muoka
 *
 */


public class HomePageTest extends BaseClass {
	

	
	
	HomePage homepage;
	@Test
	public void ClickOnProfile() throws InterruptedException {
		
		
		int irow = 1;
		
		try {
			
			homepage = loginpage.UserLogin(TestData.getCellData(irow, 0, TestConstant.Sheet1), TestData.getCellData(irow, 1, TestConstant.Sheet1));
			
			
			homepage.ClickprofileLink();
			
		
				
		} catch (Exception e) {
			
			
			String Exmessage = e.toString();		
		    Log.error(Exmessage);	
		
		
		}
		
		Thread.sleep(3000);
		
		String expectedUrl = "https://alphapay.netlify.app/dashboard/settings/profile";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
				
		
		
		
	}


}
