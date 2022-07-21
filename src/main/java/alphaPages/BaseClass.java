/**
 * 
 */
package alphaPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import alphaUtilityClasses.Log;
import alphaUtilityClasses.TestConstant;



/**
 * @author delphine.muoka
 *
 */
/**
 * @author delphine.muoka
 * This is a base class that will always run before suite and after suite
 */
public class BaseClass {

	public static WebDriver driver; 
	
	public SignupPage signuppage;
	public LoginPage loginpage;
	 
	@BeforeTest
	public void Setup() {
		
    String projectPath = System.getProperty("user.dir");
	
	Log.info("Starting up browser and opening the web Url");
	
	// Chrome driver path
     System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/Chromedriver/chromedriver.exe");
     
     driver = new ChromeDriver();
     driver.get(TestConstant.baseURL);
  
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
     driver.manage().window().maximize();
     
   //Creating object of Login page
     loginpage = new LoginPage(); 
     
     // Click on Login Link
     loginpage.LoginLink.click();
 
} 
	// Close browser after ever method
	@AfterTest
	public void Teardown() {
		
		driver.close();
		driver.quit();
	}
}
