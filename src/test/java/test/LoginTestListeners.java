package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.LoginPage;
import utility.Reports;

@Listeners(test.Listeners.class)  
   public class LoginTestListeners extends BaseClass {
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		 extent=Reports.createReports();	
	}
	
	@BeforeMethod
	public void openBrowser() {
		 driver=LaunchBrowser.chrome("https://www.facebook.com/");
	}
	
	@Test 
	public void loginWithValidCredentials() {
		 test = extent.createTest("loginWithValidCredentials");
	     LoginPage loginpage=new LoginPage(driver);
	     loginpage.enterEmailId("vikky@gmail.com");
	     loginpage.enterPassword("12345");
	     loginpage.clickOnLogin();
	     String currentTitle = driver.getTitle();
	     
	     Assert.assertNull(currentTitle);
	}
	
	@Test
	public void loginWithValidUserNameAndInvalidPassword() {	
		 test= extent.createTest("loginWithValidUserNameAndInvalidPassword");
	     LoginPage loginpage=new LoginPage(driver);
	     loginpage.enterEmailId("v@gmail.com");
	     loginpage.enterPassword("12vikky");
	     loginpage.clickOnLogin();
	}
	
	@Test
	public void loginwithInvalidUserNameAndPassword() {
		test = extent.createTest("loginwithInvalidUserNameAndPassword");
	     LoginPage loginpage=new LoginPage(driver);
	     loginpage.enterEmailId("xyz@gmail.com");
	     loginpage.enterPassword("222222");
	     loginpage.clickOnLogin();
	}
	
	//@Test(dependsOnMethods ="loginWithValidCredentials()")
	
	@Test
	public void createNewAccount() {
		test = extent.createTest("createNewAccount");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickOnCreateAccount();
		loginpage.enterfirstname("virat", driver);
		
	}
	
	@AfterMethod
	public void captureResult(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
		
		driver.close();
	  }
	
	@AfterTest
	public void publish() {
		extent.flush();
	}
	
	
	
//	@AfterMethod
//	public void closeBrowser() {
//		driver.close();
//	}
}	