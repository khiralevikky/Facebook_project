package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.LoginPage;
import utility.Parametrization;

public class LoginExcelTest {

WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		 driver=LaunchBrowser.chrome("https://www.facebook.com/");
	}
	
	@Test
	public void loginWithExcel() throws EncryptedDocumentException, IOException {
	     LoginPage loginpage=new LoginPage(driver);
	     String id=Parametrization.getExcelData(0,0,"login");
	     String pass=Parametrization.getExcelData(1,0,"login");
	     loginpage.enterEmailId(id);
	     loginpage.enterPassword(pass);
	     loginpage.clickOnLogin();
	}

}
