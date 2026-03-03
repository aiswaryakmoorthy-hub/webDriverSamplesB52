package testScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DataDrivenTest 
{
	
	WebDriver driver ;
	
	@BeforeMethod
	
	
	public void setup() {
		Map<String, Object> prefs = new HashMap ();
		  
		  //Disable save password pop up 
		  
		  prefs.put("credentials_enable_service", false);
		  prefs.put("profile.password_manager_enabled",false);
		  
		  //Disable change pwd pop up related to data breach
		  prefs.put("profile.password_manager_leak_detection",false);
		  
		  //Create Chromeoptions object 
		  ChromeOptions options =new ChromeOptions();
		  options.setExperimentalOption("prefs",prefs);
		  
		   driver=new ChromeDriver(options);
		
	}
	
	
  @Test(dataProvider="loginData")
  

  public void LoginTest(String struser,String strpwd) {
	  
 
	  
	  driver.manage().window().maximize();
	  
	  
	  driver.get("https://www.saucedemo.com/");
	  driver.findElement(By.id("user-name")).sendKeys(struser);
	  driver.findElement(By.id("password")).sendKeys(strpwd);
	  driver.findElement(By.id("login-button")).click();
	  WebElement Header=driver.findElement(By.xpath("//span[@class='title']"));
	  Assert.assertTrue(Header.isDisplayed());
	  
	  
	 }
  
  @DataProvider(name="loginData")
  public Object[][] getData() throws CsvValidationException,IOException{
	  
	  String path=System.getProperty("user.dir")+ "//src//test//resources//testData//loginData.csv";
	  CSVReader reader =new CSVReader(new FileReader(path));
	  String cols[];
	  ArrayList<Object> dataList=new ArrayList<Object>();
	  while((cols=reader.readNext())!=null){
	  Object record[]= {cols[0],cols[1]};
	  dataList.add(record);
	  
  }
  
  reader.close();
  return dataList.toArray(new Object[dataList.size()][]);
  
  
  
	  
	  
	  
  }
  
  
  
  
}
