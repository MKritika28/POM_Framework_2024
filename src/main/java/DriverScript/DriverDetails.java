package DriverScript;

import java.time.Duration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.aspectj.util.FileUtil;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverDetails {

	public WebDriver driver;
	public Properties prop;
	
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	//Function to initialize driver from properties in config file
	
	public WebDriver DriverInitialize(Properties prop ) {
		String browserName = prop.getProperty("browser") ;
		System.out.println("The execution will work on "+ browserName + " browser");
		
		switch(browserName.toLowerCase().trim()){
		
			case "chrome":
				//driver = new ChromeDriver();
				tldriver.set(new ChromeDriver());
				break;
			
			case "firefox":
				//driver = new FirefoxDriver();
				tldriver.set(new FirefoxDriver());
				break;
				
			case "edge":
				//driver = new EdgeDriver();
				tldriver.set(new EdgeDriver());
				break;	
			
			default:
				System.out.println("Selected browser is not configured ....");
				throw new FrameworkException("NO BROWSER FOUND EXCEPTION....");
				
		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();				
		return getDriver();			
	}
	
	/****************************/
	public synchronized static WebDriver getDriver() {
		return tldriver.get();
	}
	/****************************/
	
	
	public Properties initializeProp(){
		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream("./resources/config/config.properties");
			try {
				prop.load(fp);
			} catch (IOException e) {				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} 
		return prop;
		
	}
	
	/**
	 * take screenshot
	 */

	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtil.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	
}
