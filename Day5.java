/*Day5
 * Test case:Verify you can create account in Ecommerce site and can share wishlist to other people using email
Test Steps:
 * "1.Go to http://live.guru99.com
2.click on my account link
3.Click Create Account link and fill New User information except EmailId
4.Click register
5.Verify registeration is done
6.Go to TV menu
7.Add product in your wishlist
8.click Share Wishlist
9.In next page enter email and a message and click SHARE Wishlist
10.Check wishlist is shared"

 */
package Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import PageObject.registrationpage;
import core2.BrowserFunctions;

public class Day5 extends BrowserFunctions{
	WebElement success;
	String firstname,lastname,middle,str1,str2;
	
  @Test
  public void f() throws InterruptedException {
	  firstname="shikha";
	  lastname="shikha";
	  middle="shikha";
	  
	  registrationpage ob=new registrationpage(driver);
	   driver.findElement(By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]")).click();
	   driver.findElement(By.xpath(".//*[@id='header-account']/div/ul/li[1]/a")).click();
	  driver.findElement(By.xpath(".//*[@id='login-form']/div/div[1]/div[2]/a/span/span")).click();
	 
	  //enter firstname
	  ob.typeFirstname(firstname);
	  //enter middle name
	  ob.typeMiddleame(middle);
	 //enter lastname
	  ob.typeLastname(lastname);
	  //enter email address
	  ob.typeEmail("abc132123@gmail.com");
	  //enter password
	  ob.typePass("shikha");
	  //enter confirmation password
	  ob.typeConfirmation("shikha");
	  //click registration
	 // @SuppressWarnings("unused")
	//Actions actions=new Actions(driver);
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)","");
	   ob.clickRegistration();
	  
	  	  for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	  success=driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[1]/div/p"));
	  str1=("Welcome, "+firstname+" "+middle+" "+lastname+"!");
	  System.out.println(success.getText());
	 	 if(success.isDisplayed())
		  try {
			  assert str1.equalsIgnoreCase(success.getText());
		      } catch (Exception e) {
		    	e.printStackTrace();	    	
		                          }
		     System.out.println("registration done");
		     
		//click at TV
	 	 driver.findElement(By.linkText("TV")).click();
	 	 for(String child:driver.getWindowHandles())
	 		 driver.switchTo().window(child);
	 	 Thread.sleep(3000);
	 	 
	 	 //click at Add to Wishlist
	 	 driver.findElement(By.linkText("Add to Wishlist")).click();
	 	 
	 	 //click at share list
	 	for(String child:driver.getWindowHandles())
	 		 driver.switchTo().window(child);
	 	driver.findElement(By.xpath(".//button[@title='Share Wishlist']")).click();
	 			 Thread.sleep(3000);
	 			 
	 			 //enter valid email address and message
	 		for(String child:driver.getWindowHandles())
	 		 	 driver.switchTo().window(child);
	 		driver.findElement(By.id("email_address")).sendKeys("ss@gmail.com");
	 		driver.findElement(By.id("message")).sendKeys("hello");
	 		  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)","");
	 		driver.findElement(By.xpath(".//button[@title='Share Wishlist']")).click();
	 		Thread.sleep(3000);
	 		//verifying wishlist shared
	 		str2=driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
	 		str1="Your Wishlist has been shared.";
	 		
	 		 try {
				  assert str1.equalsIgnoreCase(str2);
			      } catch (Exception e) {
			    	e.printStackTrace();	
	 			Thread.sleep(30000);
			      }
  }
}
