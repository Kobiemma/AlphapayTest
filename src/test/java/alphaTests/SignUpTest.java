/**
 * 
 */
package alphaTests;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import alphaPages.BaseClass;

import alphaPages.SignupPage;

import alphaUtilityClasses.Log;
import alphaUtilityClasses.TestConstant;
import alphaUtilityClasses.TestData;

/**
 * @author delphine.muoka
 * each @Test represents test cases and priority is the order they should run
 */
@Listeners(ListenersTestNG.class)

public class SignUpTest extends BaseClass {

	SignupPage signuppage;

	//Run before the any test in this class will run
	@BeforeTest
	public void navigateToRegisterPage() {

		signuppage = loginpage.navigateToSignup();
		
	}


	@Test(priority = 1)
	public void ValidateEmailField1() {
		resuableMethodForInvalidInputs(1);
	}
	@Test(priority = 2)
	public void ValidateEmailField2() {
		resuableMethodForInvalidInputs(2);
	}
	@Test(priority = 3)
	public void ValidateEmailField3() {
		resuableMethodForInvalidInputs(3);
	}
	@Test(priority = 4)
	public void ValidateEmailField4() {
		resuableMethodForInvalidInputs(4);
	}

	@Test(priority = 5)
	public void ValidateEmailField5() {
		resuableMethodForInvalidInputs(5);
	}
	@Test(priority = 6)
	public void ValidateEmailField6() {
		resuableMethodForInvalidInputs(6);
	}

	@Test(priority = 7)
	public void ValidateEmailField7() {
		resuableMethodForInvalidInputs(7);
	}
	@Test(priority = 8)
	public void ValidatePhonenumberField1() {


		resuableMethodForInvalidInputs(8);
	}

	@Test(priority = 9)
	public void ValidatePhonenumberField2() {


		resuableMethodForInvalidInputs(9);
	}

	@Test(priority = 10)
	public void ValidatePhonenumberField3() {


		resuableMethodForInvalidInputs(10);
	}


	@Test(priority = 11)
	public void ValidatePasswordField1() {

		resuableMethodForInvalidInputs(11);
	}

	@Test(priority = 12)
	public void ValidatePasswordField2() {

		resuableMethodForInvalidInputs(12);
	}

	@Test(priority = 13)
	public void ValidatePasswordField3() {

		resuableMethodForInvalidInputs(13);
	}

	@Test(priority = 14)
	public void ValidatePasswordField4() {

		resuableMethodForInvalidInputs(14);
	}

	@Test(priority = 15)
	public void ValidatePasswordField5() {

		resuableMethodForInvalidInputs(15);
	}


	@Test(priority = 16)
	public void ValidateConfirmpasswordField() {

		resuableMethodForInvalidInputs(16);
	}
	
	
	@Test(priority = 17)

	public void ValidateDuplicateUsercreation() {

		resuableMethodForInvalidInputs(17);

		
		String currentUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://alphapay.netlify.app/auth/signup";
		Assert.assertEquals(currentUrl,ExpectedUrl );

	}

	@Test(priority = 18)
	public void ValidateRequiredFields() {

		resuableMethodForInvalidInputs(18);

	}
	

	@Test(priority = 19)

	public void ValidateValidInputsWithValidDataFormat() {

		
		try {
			Log.info("Test Conditions -----------"+TestData.getCellData(1, 6, TestConstant.Sheet3));

			signuppage.CreateUser(TestData.getCellData(1, 0, TestConstant.Sheet3), TestData.getCellData(1, 1, TestConstant.Sheet3), 
					TestData.getCellData(1, 2, TestConstant.Sheet3), TestData.getCellData(1, 3, TestConstant.Sheet3), 
					TestData.getCellData(1, 4, TestConstant.Sheet3), TestData.getCellData(1, 5, TestConstant.Sheet3));
			
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlToBe("https://alphapay.netlify.app/dashboard/overview"));
			
		} catch (Exception e) {
			String Exmessage = e.toString();		
			Log.error(Exmessage);
		}			

		
		
		String currentUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://alphapay.netlify.app/dashboard/overview";
		Assert.assertEquals(currentUrl,ExpectedUrl );

	}


	// Reuseable method for invalid inputs
	public void resuableMethodForInvalidInputs(int irow) {



		try {
			Log.info("Test Conditions -----------"+TestData.getCellData(irow,6, TestConstant.Sheet4));


			signuppage.CreateUser(TestData.getCellData(irow, 0, TestConstant.Sheet4), TestData.getCellData(irow, 1, TestConstant.Sheet4), 
					TestData.getCellData(irow, 2, TestConstant.Sheet4), TestData.getCellData(irow, 3, TestConstant.Sheet4), 
					TestData.getCellData(irow, 4, TestConstant.Sheet4), TestData.getCellData(irow, 5, TestConstant.Sheet4));

			WebDriverWait wait=new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.urlToBe("https://alphapay.netlify.app/auth/signup"));
			
		} catch (Exception e) {
			String Exmessage = e.toString();		
			Log.error(Exmessage);
		}		
		
		String currentUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://alphapay.netlify.app/auth/signup";
		Assert.assertEquals(currentUrl,ExpectedUrl );

	}


}





