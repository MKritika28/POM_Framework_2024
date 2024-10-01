package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonUtilities.Constants;
import CommonUtilities.ResuableElement;

public class SearchProductPage {
	private WebDriver driver;
	private ResuableElement element;
	
	public SearchProductPage(WebDriver driver) {
		this.driver = driver;
		element = new ResuableElement(driver);
	}
	
	private By sProduct = By.xpath("//h4/a");
	private By sButton = By.xpath("//div[@class='button-group']");
	
	
	public int getProductsCount() {
		return element.getElementsCount(sProduct, Constants.SHORT_TIMEOUT);
	}
	
	public int getButtonsCount() {
		return element.getElementsCount(sButton, Constants.SHORT_TIMEOUT);
	}
	
	/**
	 * This method is used select the Product to go to single product page
	 * @param searchProductName the product to be selected
	 * @return Page 
	 */
	public ProductDetailsPage selectProduct(String searchProductName) {
		List<WebElement> productList = element.getElements(sProduct);
		for (WebElement ele : productList) {
			if (ele.getText().equalsIgnoreCase(searchProductName))
			ele.click();
			break;
		}
		return new ProductDetailsPage(driver);
	}

}
