package testScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ObjectRepoTest 
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
	  WebElement uName =driver.findElement(By.id(readObjPath("username")));
	  uName.sendKeys(struser);
	  
	  
	  WebElement pwd= driver.findElement(By.id(readObjPath("password")));
	  pwd.sendKeys(strpwd);
	  WebElement btnLogin=driver.findElement(By.id(readObjPath("loginBtn")));
	  
	  btnLogin.click();
	  
	  WebElement Header=driver.findElement(By.xpath(readObjPath("headerMsg")));
	  Assert.assertTrue(Header.isDisplayed());
	  
	  
	   }
  
  //touseexcelas obj repo
  
  public String readObjPath (String objName) {
	  
	  String objPath="";
	  String path =System.getProperty("user.dir")+ "//src//test//resources//testData//loginrREPO.xlsx";
	  FileInputStream fin;
	  XSSFWorkbook workbook=null;
	  
	  try
	  {
		  fin=new FileInputStream(path);
		  workbook=new XSSFWorkbook(fin);
		  
	  }
	  
	  catch(FileNotFoundException e ) {
		  
		  e.printStackTrace();
		  
	  }
	  
	  catch(IOException e) {
		  e.printStackTrace();
	  }
	  
	  
	  
	  
	  XSSFSheet loginSheet =workbook.getSheet("loginPage");
	  int numRows =loginSheet.getLastRowNum();
	  for (int i=1;i<=numRows;i++) {
		  XSSFRow row= loginSheet.getRow(i);
		  if (row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
			  
			  objPath=row.getCell(1).getStringCellValue();
		  }
	  }
	  
	  
		return objPath; 
			  
	  
	  
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