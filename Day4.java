/*
 * Test case=Verify that you are able to compare two product
   Day4
   
   test steps
   "1. Goto http://live.guru99.com
    2.click on 'Mobile ' Menu
    3.In mobile product list click on 'add to comapre' for two mobiles
    4.Click on Compare
    5.Verify the popup window and check that the products are reflected in it.
    6.close the popup"
 */
package Ecommerce;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import core2.BrowserFunctions;

public class Day4 extends BrowserFunctions{
	String parentWin;
@Test
//@Parameters({"phone1","phone2"})

public void f() throws InterruptedException
{
	String compitems[];
	String str;
	WebElement A1;
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Step 3. Click on ‘MOBILE’ menu
	driver.findElement(By.xpath(".//*[@id='nav']/ol/li[1]/a")).click();
	// Step 4.Verify Title of the page
	Assert.assertEquals("Mobile", driver.getTitle());
	//Click on Add to comapre for sony Xperia phone
	A1=driver.findElement(By.linkText("Add to Compare"));
	Actions actions = new Actions(driver);
	
	//window should be scroll down to click at Add IPhone to Compare
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
	actions.moveToElement(A1).click().build().perform();
	Thread.sleep(3000);
	A1=driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/ul/li/ul/li/span"));
	actions.moveToElement(A1);
	System.out.println(A1.getText());
	//check for added product list
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
     A1=driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a"));
     actions.moveToElement(A1).click().build().perform();
     WebElement cmpitem=driver.findElement(By.xpath(".//*[@id='compare-items']"));
     List<WebElement> lst = cmpitem.findElements(By.tagName("p"));
     compitems=new String[lst.size()];
		for(int i=0;i<lst.size();i++)
		{
			WebElement E=lst.get(i);
			compitems[i]=E.getText();
			System.out.println(E.getText());
			assert compitems[i].equalsIgnoreCase(E.getText()):"product should be added";
		}
		
		//Click at compare the products and switch to child window
		parentWin=driver.getWindowHandle();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-150)", "");
		A1=driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[3]/div[1]/div[2]/div/button"));
		System.out.println(A1.getText());
		actions.moveToElement(A1).click().build().perform();
		Thread.sleep(3000);
		Set<String> allWin = driver.getWindowHandles();
		
		//swtiching to child window
		for(String child:allWin){
			if(!parentWin.equals(child)){
				
				driver.switchTo().window(child);
				driver.manage().window().maximize();
				 assert driver.getTitle().equalsIgnoreCase("Products Comparison List - Magento Commerce"):"Failed to Switch to child window";
				
				 //check for prodcuts added
				 
				 WebElement Addprod=driver.findElement(By.xpath(".//*[@id='product_comparison']/tbody[1]/tr[1]"));
				 List<WebElement> addprod=Addprod.findElements(By.tagName("td"));
				 for(int i=0;i<addprod.size();i++)
				 {
					 WebElement E1=addprod.get(i).findElement(By.xpath(".//h2[@class='product-name']/a"));
					 System.out.println("child window product"+E1.getText());;
					 assert compitems[i].equalsIgnoreCase(E1.getText()):"Products are not matching";
				 }
				 
				 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
				 
				//click at close window of child window
				A1=driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div[2]/button"));
				System.out.println(A1.getText());
				actions.moveToElement(A1).click().build().perform();
			                            }
			
		                       }
		
		//switch to parent window
		
		driver.switchTo().window(parentWin);
		
  
}
}
