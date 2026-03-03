package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class RdbtnChbxDrpDwnTest {
	WebDriver driver ;
	
	@Parameters("browser")
	
	@BeforeTest 
	
	
	public void setup(String strBrowser){
	
	if(strBrowser.equalsIgnoreCase("edge"))
		 
	 {
	
	driver=new EdgeDriver();
	 }
	 
	
	  
	 driver.manage().window().maximize();

	 driver.navigate().to("https://testautomationpractice.blogspot.com/");
	
	
	}
	
  @Test 
  public void rdbtnTest() {
	  
		

	  WebElement gender= driver.findElement(By.id("male"));
	  if (!gender .isSelected())
	  {
		  gender.click();
	  }
	  Assert.assertTrue(gender.isSelected());
	  
  }
  
  @Test(alwaysRun=true, dependsOnMethods="rdbtnTest")
  
  public void chkbxTst()
  {
//WebDriver driver=new ChromeDriver();
	  
	 // driver.manage().window().maximize();

	  //driver.navigate().to("https://testautomationpractice.blogspot.com/");
	  WebElement sunday= driver.findElement(By.id("sunday"));
	  WebElement monday= driver.findElement(By.id("monday"));
	  sunday.click();
	  System.out.println("Value of sunday.." +sunday.getDomAttribute("value"));
	  System.out.println("Value of a property.." +sunday.getDomProperty("tagName"));
	  monday.click();
	  
	  if (sunday .isSelected())
	  {
		  sunday.click();
	  }
	  
	  
  }
  
  
  @Test
public void dropDwnTest()
  {
	  Select singSel=new Select(driver.findElement(By.id("country")));
	  singSel.selectByVisibleText("United Kingdom");
	  
	  Select mulSel= new Select(driver.findElement(By.id("animals")));
	  mulSel.selectByIndex(1);
	  mulSel.selectByValue("deer");
	  mulSel.selectByVisibleText("Rabbit");
	  
  }
  
}
