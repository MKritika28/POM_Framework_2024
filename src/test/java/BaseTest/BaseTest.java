package BaseTest;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import DriverScript.DriverDetails;
import Pages.AccountPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.SearchProductPage;

public class BaseTest {
	DriverDetails d;
	Properties prop;
	WebDriver driver; //multiple ref same name
	LoginPage loginPage;
	AccountPage accountPage;
	SearchProductPage searchProductPage;
	ProductDetailsPage productDetailsPage;
	
	@BeforeTest
	public void setUp() {
		  d = new DriverDetails();
		  prop = d.initializeProp();
		  driver = d.DriverInitialize(prop);
		  loginPage = new LoginPage(driver);		  
	 }
	
	
	@AfterTest
    public void tearDown() {
		 driver.quit();
	  }

	

}
