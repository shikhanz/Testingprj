/* This is Ecommerce live project
 * Day1-Guru99
 * Author-shikha
 * 
 * Test case1=Verify mobile List Page can be sorted by Name
 * Test Steps
   Step 1. Goto http://live.guru99.com/
   Step 2. Verify Title of the page
   Step 3. Click on ‘MOBILE’ menu
   Step 4. Verify Title of the page
   Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
   Step 6. Verify all products are sorted by name
 * 
 */

package Ecommerce;

import org.testng.annotations.Test;

import core2.BrowserFunctions;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Day1 extends BrowserFunctions {
	  
	@Test(priority=0 ,description="Test step for verifying heading This is demo site")
   public void f() {
	//	Step 2. Verify Title of the page
		String str=driver.findElement(By.tagName("h2")).getText();
		System.out.print(str);
		Assert.assertEquals("THIS IS DEMO SITE FOR   ",str);
	  
      }
	
	@Test(priority=1,description="Test step for verifying Mobile page Title")
	public void f2()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Step 3. Click on ‘MOBILE’ menu
		driver.findElement(By.xpath(".//*[@id='nav']/ol/li[1]/a")).click();
		// Step 4.Verify Title of the page
		Assert.assertEquals("Mobile", driver.getTitle());
	}
	
	@Test(priority=2,description=" Test step for verifying ordering of mobiles by name using screen shot")
	public void f3() throws IOException
	{
	//	Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
	Select listbox=new Select(driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		listbox.selectByVisibleText("Name");
		//   Step 6. Verify all products are sorted by name using screenshots
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String png = ("d://ss//screenshot1"+ ".png");
		FileUtils.copyFile(scrFile, new File(png));
		
	}
  
 }
