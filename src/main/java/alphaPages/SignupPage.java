/**
 * 
 */
package alphaPages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author delphine.muoka
 *
 */
public class SignupPage extends BaseClass{
	
	
	@FindBy(name ="full_name")
	WebElement Fullname;
	
	@FindBy(name ="username")
	WebElement Username;
	
	@FindBy(name ="phone_number")
	WebElement Phonenumber;
	
	@FindBy(name ="email")
	WebElement Email;
	
	@FindBy(name ="password")
	WebElement Password;
	
	@FindBy(name ="confirmPassword")
	WebElement Confirmpassword;
	
	@FindBy(xpath ="//button[@class='button btn_colored'][contains(text(),'Create Account')]")
	WebElement CreateUserBtn;



public SignupPage(){
	PageFactory.initElements(driver, this);

}


public void CreateUser(String fullname, String username, String phonenumber, String email, String password, String confirmpassword) {
	

	// clear any data inside Fullname text field
	Fullname.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	// input data inside Fullname text field
	Fullname.sendKeys(fullname);
	
	Username.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	Username.sendKeys(username);
	
	Phonenumber.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	Phonenumber.sendKeys(phonenumber);
	
	Email.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	Email.sendKeys(email);
	
	Password.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	Password.sendKeys(password);
	
	Confirmpassword.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	Confirmpassword.sendKeys(confirmpassword);
	
	CreateUserBtn.click();
	
	
	
}


	
}
