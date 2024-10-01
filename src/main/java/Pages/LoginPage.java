package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import CommonUtilities.Constants;
import CommonUtilities.ResuableElement;

public class LoginPage {
	
	//Private Driver
	private WebDriver driver;
	private ResuableElement element;
	
	// Page Constructor that has driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		element = new ResuableElement(driver);
	} 
	
	//Page Locators
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value=\"Login\"]");
	private By forgotpassword = By.linkText("Forgotten Password");
	private By registerUser = By.linkText("Register");
	private By loginErrorMsg = By.xpath("//div[contains(@class,\"alert-danger\")]");
			
	
	//Page Methods or Actions
	/**
	 * This method is used to get title of the page	 
	 * @return Title of page
	 */
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean forgotpasswordLinkExists() {
		return element.getElementIsDisplayed(forgotpassword,Constants.SHORT_TIMEOUT);		
	}
	
	/**
	 * This method is used to login into application
	 * @param username pwd
	 * @return Page
	 */
	public AccountPage loginCredentials(String username, String pwd) {
		element.doSendKeys(email, Constants.SHORT_TIMEOUT, username);
		element.doSendKeys(password, pwd);
		element.doclick(loginButton);	
		return new AccountPage(driver);
	}
	
	/**
	 * This method is used to check unsuccessful login attempt 
	 * @param sUsername sPwd
	 * @return true,false depends on error message is displayed
	 */
	//wrong Credential Check
	public boolean invalidCredentials(String sUsername, String sPwd) {
		element.doSendKeys(email, Constants.SHORT_TIMEOUT, sUsername);
		element.doSendKeys(password, sPwd);
		element.doclick(loginButton);
		if (element.getElementIsDisplayed(loginErrorMsg, Constants.SHORT_TIMEOUT)) {		
			return false;
		}else {
				return true;
		}	
	}
	
	/**
	 * This method is used to check the error message after unsuccessful login attempt
	 * @param 
	 * @return true,false 
	 */
	public boolean loginErrorMessage() {		
		if (element.getTextFromElement(loginErrorMsg).equals(Constants.LOGIN_ERROR_MESSAGE)) {			
			return true;
		}else {
				System.out.println("Error message is  :" + element.getTextFromElement(loginErrorMsg));
				return false;
		}
		
	}
	
	
}
