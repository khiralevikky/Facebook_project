package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.LaunchBrowser;
import pom.LoginPage;

public class Assertions {
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		 driver=LaunchBrowser.chrome("https://www.facebook.com/");
	}
	//1. Hard Assertion
	@Test
	public void loginWithValidCredentials() {
	     LoginPage loginpage=new LoginPage(driver);
	     loginpage.enterEmailId("vikky@gmail.com");
	     loginpage.enterPassword("12345");
	     loginpage.clickOnLogin();
	     String currentTitle = driver.getTitle();
	     
	      //1. Hard Assertion
	     
	     //Assert.assertEquals(currentTitle, "Home");  //It gives Fail

//	     Assert.assertEquals(currentTitle, "Facebook – log in or sign up");
//	     Assert.assertTrue(true);
//	     Assert.assertNull(currentTitle);
//	    	     
//	     System.out.println("post assertion");	    
	     	   	     	 	     
	}
	
	//2. Soft Assertion
	public void loginWithValidCredentials2() {
	     LoginPage loginpage=new LoginPage(driver);
	     
	     SoftAssert softAssert=new SoftAssert(); //Create object of SoftAssert class
	     
	     loginpage.enterEmailId("vikky@gmail.com");
	     loginpage.enterPassword("12345");
	     loginpage.clickOnLogin();
	     String currentTitle = driver.getTitle();
	     
	     softAssert.assertEquals(currentTitle, "Home");  //It gives Fail
	     softAssert.assertEquals(currentTitle,"Facebook – log in or sign up");
	     softAssert.assertTrue(true);
	     softAssert.assertNull(currentTitle);
	    	     
	     System.out.println("post assertion");	  	     
	     softAssert.assertAll();
	}
}
