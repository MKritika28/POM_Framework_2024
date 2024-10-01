package BaseTest;

import static org.testng.Assert.assertEquals;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtilities.Constants;
import CommonUtilities.Excelutils;
import Pages.*;

public class SearchProductPageTest extends BaseTest {
	
	@BeforeTest
	public void Login() {
		accountPage = loginPage.loginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		searchProductPage = accountPage.searchProduct(prop.getProperty("productName")); 		
	}
	
	
	@Test(priority = 1)
	public void verifyButtons() {		
		Assert.assertEquals(searchProductPage.getButtonsCount(), searchProductPage.getProductsCount());
		System.out.println("Each Product listed has buttons");		
	}
	
	@DataProvider
	public String[][] productName(){
		return new String[][] {{"MacBook"}};
	}
	@Test(priority = 2, dataProvider = "productName")
	public void selectProduct(String sProduct) {
		productDetailsPage = searchProductPage.selectProduct(sProduct);			
		Assert.assertTrue((productDetailsPage.getProductPageTitle()).contains(sProduct));
	}
	
	
	@DataProvider
	public Object[][] productDetailName() {
		Object[][] sData =  Excelutils.getTestData(Constants.PRODUCT_PAGE);
		return sData;
	}
	@Test(priority = 3, dataProvider = "productDetailName")
	public void selectProduct(String sProduct,String sDetail, String sValue) {
		productDetailsPage = searchProductPage.selectProduct(sProduct);	
		String actValue = productDetailsPage.getProductDetails(sDetail);		
		Assert.assertEquals(actValue, sValue);		
	}

}
