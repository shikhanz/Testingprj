package Ecommerce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import core2.BrowserFunctions;

public class Day10 extends BrowserFunctions{
	
  @Test
  public void f() throws AWTException, InterruptedException, BiffException, IOException {
	  
	   
	  driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("user01");
	  driver.findElement(By.xpath(".//*[@id='login']")).sendKeys("guru99com");
	
	  //click at Login Button --Robot class can be used for window popups
	  Robot r1=new Robot();
	  try {
		  r1.keyPress(KeyEvent.VK_ENTER);
	  }catch(Exception e) {
	  System.out.println("error");
	  } 
	  Thread.sleep(13000);
	  
	  for(String child:driver.getWindowHandles())
		  driver.switchTo().window(child);
	 //click at message window popup close
	  driver.findElement(By.xpath(".//*[@id='message-popup-window']/div[1]/a/span")).click();
	  
	 //click at Sales  
	  driver.findElement(By.xpath(".//*[@id='nav']/li[1]/a/span")).click();
	  //click at Orders
	  driver.findElement(By.xpath(".//*[@id='nav']/li[1]/ul/li[1]/a/span")).click();
	  //click at Export list
	  WebElement s1=driver.findElement(By.xpath(".//*[@id='sales_order_grid_export']"));
	  s1.click();
	  List<WebElement> list=s1.findElements(By.tagName("options"));
	  for(WebElement c1:list)
	  {
		 // if(c1.getText().equalsIgnoreCase("CSV"))
		  //{
			  System.out.println(c1.getText());
		  	//		  c1.click();
	        //}
	  }
	
	  //click at Export	    
	  driver.findElement(By.xpath("//*[contains(text(), 'Export')]")).click();
	  Thread.sleep(30000);
	
	  //Reading of excel downloaded file
     	File fs = new File("C://Users//hp//Downloads//orders.xls");
		Workbook wb=Workbook.getWorkbook(fs);
        Sheet sh=wb.getSheet(0);
	    int cols=sh.getColumns();
		int rows=sh.getRows();
		for (int i= 1 ; i <rows; i++) {

			for (int j=0; j <cols; j++) {
				System.out.print(sh.getCell(j, i).getContents()+"  ");
			}
			System.out.println("");

		}
        
	  
  }
  }

