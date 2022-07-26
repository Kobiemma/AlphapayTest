/**
 * 
 */
package alphaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author delphine.muoka
 *
 */
public class HomePage extends BaseClass{
	
	
	@FindBy(xpath = "//body[1]/div[1]/section[1]/div[1]/div[1]/div[3]/a[1]/img[1]") WebElement ProfileLink;
	
	
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public UpdateProfilePage ClickprofileLink() {
		
      
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", ProfileLink);
		
		return new UpdateProfilePage();
		
	}

}
