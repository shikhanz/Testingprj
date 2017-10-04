package Ecommerce;

import org.testng.annotations.Test;

import core2.BrowserFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Day2 extends BrowserFunctions{
	String cost; 
  
		
	@Test(priority=1)
	public void f2()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='nav']/ol/li[1]/a")).click();
		Assert.assertEquals("Mobile", driver.getTitle());
	}
	@Test(priority=2)
	public void f3()
	{
    cost=driver.findElement(By.id("product-price-1")).getText();
    System.out.println("cost of xperia"+cost);
    driver.findElement(By.xpath(".//*[@id='product-collection-image-1']")).click();
    System.out.println("cost on product page"+driver.findElement(By.xpath(".//*[@id='product-price-1']/span")).getText());
	Assert.assertEquals(cost,driver.findElement(By.xpath(".//*[@id='product-price-1']/span")).getText());	
	}
  
  
   
  

}
