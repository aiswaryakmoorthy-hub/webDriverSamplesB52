package testScripts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework1Test {
	WebDriver driver=new ChromeDriver();
	Actions action = new Actions(driver);
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(18));
	
	@Test(priority=1)
	
	public void LoginTest() {
		
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com/");
		driver.findElement(By.id("login2")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername"))).sendKeys("TestAis");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword"))).sendKeys("Tester123");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
		WebElement Loggedinuser=driver.findElement(By.id("nameofuser"));
		Assert.assertEquals(Loggedinuser.getText(), "Welcome TestAis");
		System.out.println(Loggedinuser.getText());
		System.out.println("Login success");
	}
	
	
	@Test(priority=2)
	
	public void AddToCartTest() {
		
		action.scrollToElement(driver.findElement(By.xpath("//div/a[@class='list-group-item' and contains(text(),'Phones')]"))).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='hrefch' and text()='Samsung galaxy s6']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-success btn-lg' and text()='Add to cart']"))).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		driver.findElement(By.id("cartur")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='success']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='success']")).isDisplayed());
		System.out.println("Products added to cart");
		
	}
	
	@Test(priority=3)
	
	
	public void PurchaseTest()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("name");
		driver.findElement(By.id("card")).sendKeys("123");
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Purchase')]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")));
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).isDisplayed());
		
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		
		System.out.println("Products purchased");
		
		
		
	}
	
	
	
	
	
}