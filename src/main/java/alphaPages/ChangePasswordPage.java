/**
 * 
 */
package alphaPages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author delphine.muoka
 *
 */

//Page objects(locators)
public class ChangePasswordPage extends BaseClass {
	@FindBy(linkText = "Security") WebElement SecurityLink;

	@FindBy(name = "password") WebElement OldPassword;

	@FindBy(name = "new_password") WebElement NewPassword;

	@FindBy(xpath = "//button[@class='button btn_colored'][contains(text(),'Change Password')]") WebElement ChangePasswordBtn;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]") WebElement ChangePasswordMessage;

	@FindAll({@FindBy(xpath = "//div[contains(text(),'Must Contain 8 Characters, One Uppercase, One Lowe')]"),
		@FindBy(xpath = "//div[contains(text(),'Password must be 9 characters or longer')]"),
		@FindBy(xpath = "//div[contains(text(),'Provide a password please')]")
	}) WebElement ChangePasswordguideMessage;

	public ChangePasswordPage() {


		PageFactory.initElements(driver, this);

		SecurityLink.click();
	}


	public void ChangePassword(String oldpassword, String newpassword) {

		// To clear textfield, it can be replaced with .clear()
		OldPassword.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		//sending the keys to oldpassword text field
		OldPassword.sendKeys(oldpassword);

		NewPassword.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		NewPassword.sendKeys(newpassword);
        
		//Click on the change password button 
		ChangePasswordBtn.click();



	}

	// Method for message used for assertion in Test class	
	public String MessageDisplay() {

		WebDriverWait wait=new WebDriverWait(driver, 10);

		ChangePasswordMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]")));		


		String msg = ChangePasswordMessage.getText();


		return msg;


	}
	// Method for message used for assertion in Test class
	public boolean messageGuide() {

		try {

			ChangePasswordguideMessage.isDisplayed();

			return true;


		}catch(Exception e) {


		}
		return false;
	};

}



