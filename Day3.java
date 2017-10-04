/*Project-Ecoomerce live project-guru99
 * Author-Shikha
 * Test case-Day3
 * Verify that you cannot add more product in cart than the product available in store
 * 
 * Test Steps
 * 1. Goto http://live.guru99.com
   2.click on 'Mobile ' Menu
   3.In the list of all mobile,click on 'Add to Cart' for Sony Xperia mobile
   4.Change the 'Qty' value to 1000 and click 'Update' button
   5.Verify the message
   6.Then click on 'Empty the Cart' link in the footer of list of all mobiles.
    7.Verify cart is empty
 * 
 */
package Ecommerce;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import core2.BrowserFunctions;

public class Day3 extends BrowserFunctions {
	
  @Test(priority=0, description="Verify that you cannot add more product in cart than the product available in store")
  @Parameters({"qty"})
  public void f(String qty) {
	  //click on Mobile Menu
	  driver.findElement(By.partialLinkText("MOBILE")).click();
	  //click at Add to cart of Xperia Sony
	  driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();

	  driver.findElement(By.xpath(".//input[@class='input-text qty']")).clear();
	  //change the qty value to 1000
	  
	  driver.findElement(By.xpath(".//input[@class='input-text qty']")).sendKeys(qty);
	  //click at update button
	  
	  driver.findElement(By.xpath(".//button[@class='button btn-update']")).click();
	  //verifying the message
	  
	  String str;
	  str=driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/div/ul/li/ul/li")).getText();
	 // Assert.assertEquals("Some of the products cannot be ordered in requested quantity.",str);
	  
	  assert str.equalsIgnoreCase("Some of the products cannot be ordered in requested quantity."):"qty order should be less than In stock";
	  
	  //click on empty cart link
	  
	  driver.findElement(By.xpath(".//button[@id='empty_cart_button']")).click();
	  //verify the error message
	  str="Shopping Cart is Empty";
	  assert str.equalsIgnoreCase(driver.findElement(By.cssSelector("h1")).getText()):"Shopping cart should be empty";
	  
  }
}
