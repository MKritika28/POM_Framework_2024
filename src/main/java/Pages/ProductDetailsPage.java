package Pages;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonUtilities.ResuableElement;

public class ProductDetailsPage {
	
	private WebDriver driver;
	private ResuableElement element;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		element = new ResuableElement(driver);
	}
	
	private By productName = By.tagName("h1");
	private By productDetails = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceDetails = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");	
	
	/**
	 * This method is used to get title of the page	 
	 * @return Title of page
	 */
	public String getProductPageTitle() {
		return driver.getTitle();
	}	
	
	/**
	 * This method is returns the product detail value like apple, $604 etc.
	 * @param sDetail (which detail value we need ex: Brand , Price)
	 * @return Object(value of the detail of Product)
	 */
		//	Brand: Apple
		//	Product Code: Product 18
		//	Ex Tax: $500.00
		//	Availability: Out Of Stock
	public String getProductDetails(String sDetail) {
		List<WebElement> eleList = element.getElements(productDetails);
		Hashtable<String,String> hm = new Hashtable<String,String>();
		for(WebElement e: eleList) {
			String svalue = e.getText();			
			if (!(svalue.equalsIgnoreCase(null))){				
				String[] pdetails = svalue.split(":");				
				hm.put(pdetails[0].trim(), pdetails[1].trim());				
			}			
		}
		
		//Price listing is different on website so different list for it		
		List<WebElement> priceList = element.getElements(productPriceDetails);
		hm.put("Price", priceList.get(0).getText().trim());
		hm.put(priceList.get(1).getText().split(":")[0].trim(),priceList.get(1).getText().split(":")[1].trim());
		
		return hm.get(sDetail);
	}
	

}
