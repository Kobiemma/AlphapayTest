/**
 * 
 */
package alphaPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author delphine.muoka
 *
 */
public class LogOutPage extends BaseClass{
	
	
	
	@FindBy(linkText = "Log Out") WebElement LogoutLink;
	
	
	public LogOutPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public LoginPage LogOut() {
		
		
	
		
		LogoutLink.click();
		
	
		return new LoginPage();
	}

}



