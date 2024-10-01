package BaseTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CommonUtilities.Constants;

public class LoginTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginPageTitleCheck() {
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println("Login Page of Title is : " + actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);			
	}
	
	@Test(priority = 2)
	public void forgetPasswordLinkTest() {
		Assert.assertTrue(loginPage.forgotpasswordLinkExists());
		System.out.println("Forget Password Link is Present");
	}
	
		
	@Test(priority = 4)	
	public void loginSuccessfull(){
		accountPage = loginPage.loginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login with username: " + prop.getProperty("username"));
		String actualTitle = accountPage.getAccountPageTitle();		
		Assert.assertEquals(actualTitle, Constants.HOME_PAGE_TITLE);
		System.out.println("Login is successfull");
	}
	
	
	@DataProvider
	public String[][] InvalidCredentials(){
		return new String[][] {{"kritikamaheshwari810@gmail.com","Kritika11*"}, {"l"," "}};
	}
	@Test(priority = 3, dataProvider = "InvalidCredentials")
	public void loginCredentialsNegativeTest(String usr, String pwd) {
		System.out.println("Login with invalid Credentials");
		Assert.assertFalse(loginPage.invalidCredentials(usr, pwd));
		System.out.println("Unable to Login");
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(loginPage.loginErrorMessage());
		
	}
	

}
