package Pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import CommonUtilities.Constants;
import CommonUtilities.ResuableElement;

public class AccountPage {
	private WebDriver driver;
	private ResuableElement element; 
		
	private By header = By.xpath("//div[@id='content']/h2");
	private By searchBar = By.name("search");
	private By searchButton = By.cssSelector("button.btn-default");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		element = new ResuableElement(driver);		
	}
	
	/**
	 * This method is used to get title of the page	 
	 * @return Title of page
	 */
	public String getAccountPageTitle() {
		return driver.getTitle();
	}	
	
	/**
	 * This method is used to get all the headers 	 
	 * @return the list of headers
	 */	
	public List<String> accountPageHeadersList(){		
		return element.getTextFromElements(header, Constants.SHORT_TIMEOUT);
	}
	
	/**
	 * This method is used to search for a product
	 * @parameters productName is the product to search 	 
	 * @return the product page after searching product
	 */	
	public SearchProductPage searchProduct(String productName) {		
		element.doSendKeys(searchBar, Constants.SHORT_TIMEOUT,productName);
		element.doclick(searchButton);
		return new SearchProductPage(driver);
	}
	
}
