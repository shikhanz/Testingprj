package core2;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BrowserFunctions {
	protected static WebDriver driver;
 
    @Parameters({"browser","baseURL"})  
	@BeforeClass
     public void openBrowser(String browser, String baseURL) {
    	if(browser.equalsIgnoreCase("firefox")){
    		driver=new FirefoxDriver();
    	}
    	
    	else if(browser.equalsIgnoreCase("chrome")){
    		
    		   System.out.print("browser"+ browser);
    			System.setProperty("webdriver.chrome.driver","d:\\jar\\chromedriver.exe");
    			 
    			     driver = new ChromeDriver();
    			
    	}
    	
    	else if(browser.equalsIgnoreCase("ie")){
    		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\driver\\IEDriverServer.exe");
    		DesiredCapabilities caps=DesiredCapabilities.internetExplorer();
    		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
    		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

    		driver=new InternetExplorerDriver(caps);
    	}
    	
    	else{
    		System.out.println("Browser not supported or incoorect browser name, running your tests in firefox");
    		driver=new FirefoxDriver();
    	}
    	// Step 1 Goto http://live.guru99.com/
	  driver.manage().window().maximize();
	  driver.get(baseURL);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

}
