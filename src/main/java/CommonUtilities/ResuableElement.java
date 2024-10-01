package CommonUtilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ResuableElement {
	
	private WebDriver driver;
	
	public ResuableElement(WebDriver driver) {
		this.driver = driver;
	}	
	
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public void doclick(By locator) {
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String sValue) {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(sValue);
	}	
	
	public String getTextFromElement(By locator) {
		return getElement(locator).getText();
	}
	
	public List<String> getTextFromElements(By locator, int timeOut){
		List<WebElement> eleList = waitForElementsToVisible(locator, timeOut);
		List<String> sHeader = new ArrayList<String>();
		for(WebElement ele: eleList) {
			sHeader.add(ele.getText());
		}
		return sHeader;		
	}
	
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public int getElementsCount(By locator, int timeOut) {
		return waitForElementsToVisible(locator, timeOut).size();
	}
		
	public boolean getElementIsDisplayed(By locator) {
		return  getElement(locator).isDisplayed();
	}
	
	public WebElement getElement(By locator, int timeOut) {
		return waitForElementPresence(locator, timeOut);
	}
	
	public List<WebElement> getElements(By locator) {		
		return  driver.findElements(locator);
	}
	
	public List<WebElement> getElements(By locator, int timeout) {		
		return  waitForElementsToVisible(locator, timeout);
	}
	
	public void doSendKeys(By locator, int timeOut, String sValue) {
		WebElement ele = waitForElementPresence(locator, timeOut);
		ele.clear();
		ele.sendKeys(sValue);
	}
		
	public void doclick(By locator, int timeOut) {
		waitForElementPresence(locator, timeOut).click();
	}
	
	public boolean getElementIsDisplayed(By locator, int timeOut) {
		return  waitForElementPresence(locator, timeOut).isDisplayed();
	}
	
	//wait functions
	
	public List<WebElement> waitForElementsToVisible(By Locator, int timeout){	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));
	}
	
	public WebElement waitforElementVisible(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}	
	
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	

	
	
	

}
