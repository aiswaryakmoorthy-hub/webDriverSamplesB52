package Parallelscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestOne {
	
	WebDriver driver;
  @Test
  public void TestOne() {
	  
	  driver=new ChromeDriver();
	  long id =Thread.currentThread().getId();
	  System.out.println("Test11 in sampleone..."+id);
	  
	 
}
  
  @Test
  public void Testtwo() {
	  
	  driver=new ChromeDriver();
	  long id =Thread.currentThread().getId();
	  System.out.println("Test12 in sampleone..."+id);
	  
	 
}
  
  @Test
  public void TestThree() {
	  
	  driver=new ChromeDriver();
	  long id =Thread.currentThread().getId();
	  System.out.println("Test13 in sampleone..."+id);
	  
	 
}
}
