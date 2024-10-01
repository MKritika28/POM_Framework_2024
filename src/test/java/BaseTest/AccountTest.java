package BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtilities.Constants;
import Pages.*;

public class AccountTest extends BaseTest{
	
	@BeforeTest
	public void Login() {
		accountPage = loginPage.loginCredentials(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=0)
	public void verifyAllHeaders() {
		Assert.assertEquals(accountPage.accountPageHeadersList(), Constants.getExpectedAccountPageHeaderLinks());			
	}
	
	@DataProvider
	public Object[][] productName(){
		return new Object[][] {{"Macbook"},{"MAC"}};
	}
	@Test(priority=2, dataProvider = "productName")
	public void productMMP(String productName) {
		searchProductPage = accountPage.searchProduct(productName);
		Assert.assertTrue(searchProductPage.getProductsCount() > 0);
		System.out.println("Product is available......");
	}

}
