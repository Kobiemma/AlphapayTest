/**
 * 
 */
package alphaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author delphine.muoka
 *
 */
public class UpdateProfilePage extends BaseClass {

	
	
	
	
	@FindBy(name = "full_name") WebElement UpFullname;
	
	@FindBy(name = "username") WebElement UpUsername;
	
	@FindBy(xpath = "//button[@class='button btn_colored'][contains(text(),'Update Details')]") WebElement UpdateBtn;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]") WebElement UpdateProfileMessage;
	
	@FindBy(linkText = "Security") WebElement SecurityLink;
	
	@FindBy(linkText = "Log Out") WebElement LogoutLink;
	
	public UpdateProfilePage(){
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void Updateprofile(String fullname, String username) {
		
		UpFullname.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		UpFullname.sendKeys(fullname);
		
		UpUsername.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		UpUsername.sendKeys(username);
		
		
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", UpdateBtn);
		
		
		
		
	}
	
	public String MessageDisplayed() {
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		
		UpdateProfileMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]")));
		
		String msg = UpdateProfileMessage.getText();
		
		return msg;
	}
	
	public ChangePasswordPage ClickonSecurityLink() {
		
		SecurityLink.click();
		
		return new ChangePasswordPage();
		
	}
	
	public LogOutPage LogoutLink() {
		
		LogoutLink.click();
		
		return new LogOutPage();
		
	}
	
}




