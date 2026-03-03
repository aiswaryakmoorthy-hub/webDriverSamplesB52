package testScripts;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class ElementDisplayTest {
  /**
 * @param driver
 * @throws IOException 
 */
@Test
  public void verifydisplayText() throws IOException {
	
	 WebDriver driver=new ChromeDriver();
	  
	  driver.manage().window().maximize();

	  driver.navigate().to("https://automationbookstore.dev");
	  
	  driver.findElement(By.id("searchBar")).sendKeys("Tst");
	  TakesScreenshot scr= (TakesScreenshot)driver ;
	 File scrFile = scr.getScreenshotAs(OutputType.FILE);
	 String path=System.getProperty("user.dir")+ "/screenshots/" + System.currentTimeMillis()+ ".png"; 
	
	 FileUtils.copyFile(scrFile, new File (path)) ;
	 
	  
	  WebElement closeIcon=driver.findElement(By.cssSelector("a[title='Clear text']"));
	  System.out.println(closeIcon.isDisplayed());
	  if(closeIcon.isDisplayed())
	  {
		  closeIcon.click();
	  }
	  
	  //fail
	 // WebElement bookIcon=driver.findElement(By.id("pid1_thumb"));
	  WebElement bookIcon=driver.findElement(By.xpath("//img[@id='pid1_thumb' and @class='ui-li-thumb']"));
	  
		 File scrFile1 = bookIcon.getScreenshotAs(OutputType.FILE);
		 String path1=System.getProperty("user.dir")+ "/screenshots/" + System.currentTimeMillis()+ ".png";
		 FileUtils.copyFile(scrFile1, new File (path1)) ;
}

}
