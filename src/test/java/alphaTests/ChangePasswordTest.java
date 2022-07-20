/**
 * 
 */
package alphaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import alphaPages.BaseClass;
import alphaPages.ChangePasswordPage;
import alphaPages.HomePage;
import alphaPages.UpdateProfilePage;
import alphaUtilityClasses.Log;
import alphaUtilityClasses.TestConstant;
import alphaUtilityClasses.TestData;

/**
 * @author delphine.muoka
 *
 */

public class ChangePasswordTest extends BaseClass {
     
	UpdateProfilePage updateprofilePage;
	HomePage homepage;
	ChangePasswordPage changepasswordpage;


	@BeforeTest
	public void navigateTosecuritypage() throws Exception {

		homepage = loginpage.UserLogin(TestData.getCellData(1, 0, TestConstant.Sheet1), TestData.getCellData(1, 1, TestConstant.Sheet1));


		updateprofilePage = homepage.ClickprofileLink();

		changepasswordpage = updateprofilePage.ClickonSecurityLink();
		
	}


	@Test	(priority = 1)
	public void CheckforThePasswordTextFieldThatIslessThan9characters() {

		ValidateChangePasswordInvalidInputsTrue(5);



	}
	
	@Test(priority =2 )
	public void CheckforThePasswordTextFieldThatHasAmissingNumber() {

		ValidateChangePasswordInvalidInputsTrue(3);


		boolean flag = changepasswordpage.messageGuide();

		Assert.assertTrue(flag);
		

	}
	
	@Test	(priority = 3)
	public void CheckforThePasswordTextFieldThatHasAmissingSpecialCharacter(){

		ValidateChangePasswordInvalidInputsTrue(4);




	}
	
	@Test	(priority = 4)
	public void CheckforThePasswordTextFieldThatHasAmissingLowercase() {

		ValidateChangePasswordInvalidInputsTrue(6);



	}

	@Test	(priority = 5)
	public void CheckforThePasswordTextFieldThatHasAmissingUppercase() {

		ValidateChangePasswordInvalidInputsTrue(7);

	}

	@Test(priority = 6)
	public void ValidateChangePasswordUsinginvalidPasswordInOldPasswordField() {

		ValidateChangePasswordInvalidInputs(1);

		String expectedMessage = "Invalid credentials";
		String actualMessage = changepasswordpage.MessageDisplay();

		Assert.assertEquals(actualMessage, expectedMessage);


	}

	
	
	@Test(priority = 7)
	public void ValidateChangePasswordUsingOldPasswordinNewPasswordField() {
		
		ValidateChangePasswordInvalidInputs(2);

		String expectedMessage = "This is an old password, please change it";
		String actualMessage = changepasswordpage.MessageDisplay();

		Assert.assertEquals(actualMessage, expectedMessage);


	}



	
	
	@Test	(priority = 8)
	public void ValidateChangePasswordUsingValidOldAndNewPasssword() {

		
		try {
			
			Log.info("Test Conditions -----------"+TestData.getCellData(1, 2, TestConstant.Sheet7));

			driver.navigate().to(driver.getCurrentUrl());
			
			changepasswordpage.ChangePassword(TestData.getCellData(1, 0, TestConstant.Sheet7), TestData.getCellData(1, 1, TestConstant.Sheet7));

			Thread.sleep(2000);

		} catch (Exception e) {

			String Exmessage = e.toString();		
			Log.error(Exmessage);

		}
			
		String actualMessage = changepasswordpage.MessageDisplay();
		String expectedMessage = "Password updated successfully";
		Assert.assertEquals(actualMessage, expectedMessage);

	}  

	// Reuseable invalid credential
	public void ValidateChangePasswordInvalidInputs(int irow) {

		try {	   Log.info("Test Conditions -----------"+TestData.getCellData(irow, 2, TestConstant.Sheet8));

		driver.navigate().to(driver.getCurrentUrl());
		
		changepasswordpage.ChangePassword(TestData.getCellData(irow, 0, TestConstant.Sheet8), TestData.getCellData(irow, 1, TestConstant.Sheet8));
		
		Thread.sleep(2000);
		
		} catch (Exception e) {

			String Exmessage = e.toString();		
			Log.error(Exmessage);

		}


	}

	//Reuseable for invalid Format
	public void ValidateChangePasswordInvalidInputsTrue(int irow) {

		try {	   Log.info("Test Conditions -----------"+TestData.getCellData(irow, 2, TestConstant.Sheet8));

		
		
		changepasswordpage.ChangePassword(TestData.getCellData(irow, 0, TestConstant.Sheet8), TestData.getCellData(irow, 1, TestConstant.Sheet8));
		
		Thread.sleep(2000);

		
		} catch (Exception e) {

			String Exmessage = e.toString();		
			Log.error(Exmessage);

		}


		boolean flag = changepasswordpage.messageGuide();

		Assert.assertTrue(flag);
	}
}


