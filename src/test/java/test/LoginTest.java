package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.LoginPage;


public class LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		 driver=LaunchBrowser.chrome("https://www.facebook.com/");
	}
	
	@Test
	public void loginWithValidCredentials() {
	     LoginPage loginpage=new LoginPage(driver);
	     loginpage.enterEmailId("vikky@gmail.com");
	     loginpage.enterPassword("12345");
	     loginpage.clickOnLogin();
	}
	
	@Test
	public void loginWithValidUserNameAndInvalidPassword() {			
	     LoginPage loginpage=new LoginPage(driver);
	     loginpage.enterEmailId("v@gmail.com");
	     loginpage.enterPassword("12vikky");
	     loginpage.clickOnLogin();
	}
	
	@Test
	public void loginwithInvalidUserNameAndPassword() {
	     LoginPage loginpage=new LoginPage(driver);
	     loginpage.enterEmailId("xyz@gmail.com");
	     loginpage.enterPassword("222222");
	     loginpage.clickOnLogin();
	}
	
	@Test
	public void createNewAccount() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickOnCreateAccount();
		loginpage.enterfirstname("virat", driver);
		
	}
	
//	@AfterMethod
//	public void closeBrowser() {
//		driver.close();
//	}
}
