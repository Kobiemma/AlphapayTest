/**
 * 
 */
package alphaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import alphaPages.BaseClass;
import alphaPages.HomePage;
import alphaPages.UpdateProfilePage;
import alphaUtilityClasses.Log;
import alphaUtilityClasses.TestConstant;
import alphaUtilityClasses.TestData;

/**
 * @author delphine.muoka
 *
 */
@Listeners(ListenersTestNG.class)

public class UpdateProfileTest extends BaseClass{

	UpdateProfilePage updateprofilepage;
	HomePage homepage;


	@BeforeTest	
	public void navigateToprofilepage() throws Exception {


		homepage = loginpage.UserLogin(TestData.getCellData(1, 0, TestConstant.Sheet1), TestData.getCellData(1, 1, TestConstant.Sheet1));

		updateprofilepage = homepage.ClickprofileLink();

	}

	@Test(priority = 1)
	public void ValidateinvalidUpdateProfile1() {



		ValidateUpdateWithInvalidData(1);


	}
	@Test(priority = 2)
	public void ValidateinvalidUpdateProfile2() {



		ValidateUpdateWithInvalidData(2);


	}
	@Test(priority = 3)
	public void ValidateinvalidUpdateProfile3() {



		ValidateUpdateWithInvalidData(3);


	}


	@Test(priority = 4)
	public void ValidateUpdateProfile() {

		int irow = 1;
		try {
			Log.info("Test Conditions -----------"+TestData.getCellData(irow, 2, TestConstant.Sheet5));
			updateprofilepage.Updateprofile(TestData.getCellData(irow, 0, TestConstant.Sheet5), TestData.getCellData(irow, 1, TestConstant.Sheet5));

			Thread.sleep(2000);
			String expectedMessage = "Update Successful";
			String actualMessage = updateprofilepage.MessageDisplayed();
			Assert.assertEquals(actualMessage, expectedMessage);

		} catch (Exception e) {


			String Exmessage = e.toString();		
			Log.error(Exmessage);
		}

	}
	// Reuseable Method
	public void ValidateUpdateWithInvalidData(int irow) {



		try {
			Log.info("Test Conditions -----------"+TestData.getCellData(irow, 2, TestConstant.Sheet6));

			updateprofilepage.Updateprofile(TestData.getCellData(irow, 0, TestConstant.Sheet6), TestData.getCellData(irow, 1, TestConstant.Sheet6));


			Thread.sleep(2000);
			String expectedMessage = "Invalid Request Data";
			String actualMessage = updateprofilepage.MessageDisplayed();
			Assert.assertEquals(actualMessage, expectedMessage);


		} catch (Exception e) {


			String Exmessage = e.toString();		
			Log.error(Exmessage);
		}}

}