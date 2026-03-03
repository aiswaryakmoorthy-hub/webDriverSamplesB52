package Parallelscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleTestOne2 {
	
	WebDriver driver;
  @Test
  public void TestOne() {
	  
	  driver=new EdgeDriver();
	  long id =Thread.currentThread().getId();
	  System.out.println("Test21 in sampletwo..."+id);
	  
	 
}
  
  @Test
  public void Testtwo() {
	  
	  driver=new EdgeDriver();
	  long id =Thread.currentThread().getId();
	  System.out.println("Test22 in sampletwo..."+id);
	  
	 
}
  
  @Test
  public void TestThree() {
	  
	  driver=new EdgeDriver();
	  long id =Thread.currentThread().getId();
	  System.out.println("Test32 in sampletwo..."+id);
	  
	 
}
  
  @Test
  
public void TestFour() {
	  
	  driver=new EdgeDriver();
	  long id =Thread.currentThread().getId();
	  System.out.println("Test42 in sampletwo..."+id);
	  
  
}
  
}
