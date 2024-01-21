package CloudAutomation.Cyfuture;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyCloudServers extends BaseClass
{
	Login Login1;

	
   @BeforeClass
	public void openBrowser1() throws IOException, InterruptedException
	{
	driver=browserOpen();
	driver=getLoginUrl();
	Login1=new Login(driver);
	
	}
	WebDriver driver;
	 @Test(priority=0)
	 public void LoginWitLaunchCloud() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
	 {
	   Login1.LoginEmail(Utility.getTestData(7, 0));
	   Login1.LoginPass(Utility.getTestData(7, 1));
	   Thread.sleep(4000);
	   Login1.LoginBtn();
       Thread.sleep(4000);
	  String expectedUrl="https://cyfuture.cloud/vm/create-vm";
	  String actualUrl = driver.getCurrentUrl();
	  if(expectedUrl.equals(actualUrl))
	  {
	  	driver.findElement(By.xpath("((//li[@class='machin-btn'])/a)[1]")).click();
	  	AssertJUnit.assertTrue(true);
	  }
	  else
	  {
	 	AssertJUnit.assertTrue(false);
	  }
 }
	 
	 @Test(priority=1)
	 public void CreatedCloud() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
	 {
	   
	  	driver.findElement(By.xpath("//div[@class='vmlist-grid']")).click();
	  	driver.findElement(By.xpath("//a[normalize-space()='Destroy']")).click();
	  	driver.findElement(By.xpath("//button[@class='rdbtn']")).click();
	  	 Alert alert = driver.switchTo().alert();		
 		 String alertMessage= driver.switchTo().alert().getText();		
	    System.out.println(alertMessage);	
	        Thread.sleep(5000);	
	        alert.accept();		
	       
	  

	  	
	
	  	
	 
     }
	 
	 
	

}
