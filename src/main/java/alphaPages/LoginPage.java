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
public class LoginPage extends BaseClass {
	
	@FindBy(linkText ="Register")
	WebElement SignUpLink;
	
	@FindBy(linkText ="LOG IN") WebElement LoginLink;
	
	@FindBy(name ="email") WebElement Email;
	
	@FindBy(name ="password") WebElement Password;
	
	@FindBy(xpath ="//button[@class='button btn_colored'][contains(text(),'Sign In')]")
	WebElement LoginBtn;

		
	
	public LoginPage() {
		
	
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public SignupPage navigateToSignup() {
		  
		SignUpLink.click();
		
		return new SignupPage();
		
	}
		
	
	
	public HomePage UserLogin(String email, String password) {
	  
	    Email.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Email.sendKeys(email);
		
		
		Password.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Password.sendKeys(password);
		
		LoginBtn.click();
		
		return new HomePage();
		
	}

	
	
	
	

}
