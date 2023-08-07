package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy (xpath ="//input[@id='email']")private WebElement email;
	@FindBy (xpath ="//input[@id='pass']")private WebElement pass;
	@FindBy (xpath ="//button[@name='login']")private WebElement login;
	@FindBy (xpath ="//a[text()='Forgotten password?']")private WebElement forgotpass;
	@FindBy (xpath ="//a[text()='Create new account']")private WebElement createAccount;
	@FindBy (xpath = "//a[text()='Create a Page']")private WebElement createPage;
	@FindBy (xpath = "//input[@name='firstname']")private WebElement firstname;
	
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailId(String id) {
		email.sendKeys(id);
	}
	public void enterPassword(String password) {
		pass.sendKeys(password);
	}
	public void clickOnLogin() {
		login.click();
	}
	public void clickOnForgotPassword() {
		forgotpass.click();
	}
	public void clickOnCreateAccount() {
		createAccount.click();
	}
	public void clickOnCreatePage() {
		createPage.click();
	}
    
	//Waits
	public void enterfirstname(String name, WebDriver driver) {
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
//		WebDriverWait wait=new WebDriverWait(driver , Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOf(firstname));
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(firstname));
		firstname.sendKeys(name);
	}
	
	
	
}
