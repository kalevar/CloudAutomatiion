package CloudAutomation.Cyfuture;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.j2objc.annotations.AutoreleasePool;

public class Updateprofile extends BaseClass
{
	ChengePassword cp;	
	EditProfile ediP;
	Login Login1 ;
   	
   @BeforeClass
	public void openBrowser1() throws IOException, InterruptedException
	{
	 driver=browserOpen();
	driver=getLoginUrl();
	Login1=new Login(driver);
	ediP=new EditProfile(driver);
	cp=new ChengePassword(driver);
	Login1=new Login(driver);
	
	
	}
   @Test(priority=2)
   public void UploadPhoto() throws InterruptedException
   {
	   driver.findElement(By.xpath("//a[@class='edit-profile-pic']")).click();
	 
	   WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file']"));
	   chooseFile.sendKeys("C:\\Users\\Varshatai.chopade\\Desktop\\image downloade upper 2 mb - Google Search.html");
	   Thread.sleep(1000);
	   
	   driver.findElement(By.xpath("(//button[text()='Upload'])[1]")).click();
	   String s=driver.findElement(By.xpath("//form[@id='edit-profile-pic-form']")).getText();
	   
	   
	   System.out.println(s);
   }
 
   @Test(dependsOnMethods="UpdateProfile")
	public void UpdateProfilewithwrongdata() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
	 {
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Edit Profile"))));
	   driver.findElement(By.linkText("Edit Profile")).click();
	 
	  Thread.sleep(2000);
	 
	  ediP.updateName(Utility.EditProfile(0, 0));
	  ediP.updateAddress(Utility.EditProfile(0, 1));
	  ediP.updateCity(Utility.EditProfile(0, 2));
	  ediP.updateState(Utility.EditProfile(0, 3));
   // ediP.updateCustom(Utility.EditProfile(0, 4));
	  ediP.updatepostcode(Utility.EditProfile(0, 5));
	  ediP.updateCompanyName(Utility.EditProfile(0, 6));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
   	  js.executeScript("window.scrollBy(0,550)",""); 
	  ediP.updateTaxId(Utility.EditProfile(0, 7));
      Thread.sleep(2000); 
	  ediP.updateManagerName(Utility.EditProfile(0, 8));	  
	  ediP.Updatebtn();
	  Thread.sleep(5000);
	  String  expectedMsg="Something went wrong, try again later!";
	  String actualMsg=driver.switchTo().alert().getText();
	  //System.out.println(actualMsg);
		
		if(expectedMsg.equals(actualMsg))
			{
			driver.switchTo().alert().accept();
			
			AssertJUnit.assertTrue(true);
			}
			else
			{
				driver.switchTo().alert().accept();
				AssertJUnit.assertTrue(false);
			}
	  
	 }
   @Test(dependsOnMethods="EditProfile")
	public void UpdateProfile() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
	 {
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Edit Profile"))));
	   driver.findElement(By.linkText("Edit Profile")).click();
	  
	 
	  ediP.updateName(Utility.EditProfile(1, 0));
	  ediP.updateAddress(Utility.EditProfile(1, 1));
	  ediP.updateCity(Utility.EditProfile(1, 2));
	  ediP.updateState(Utility.EditProfile(1, 3));
  // ediP.updateCustom(Utility.EditProfile(0, 4));
	  ediP.updatepostcode(Utility.EditProfile(1, 5));
	  ediP.updateCompanyName(Utility.EditProfile(1, 6));
	  ediP.updateTaxId(Utility.EditProfile(1, 7));
     Thread.sleep(2000);
     JavascriptExecutor js=(JavascriptExecutor)driver;
  	  js.executeScript("window.scrollBy(0,550)","");  
	  ediP.updateManagerName(Utility.EditProfile(1, 8));	  
	  ediP.Updatebtn();
	  Thread.sleep(5000);
	  String  expectedMsg= "Your details has been updated successfully!";
	  String actualMsg=driver.switchTo().alert().getText();
	  System.out.println(actualMsg);
		
		if(expectedMsg.equals(actualMsg))
			{
			driver.switchTo().alert().accept();
			
			AssertJUnit.assertTrue(true);
			}
			else
			{
				driver.switchTo().alert().accept();
				AssertJUnit.assertTrue(false);
			}
	  
	 }
   @Test(priority=0)
  	public void EditProfile() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
    {
  		Login1.LoginEmail(Utility.getTestData(7, 0));
  		Login1.LoginPass(Utility.getTestData(7, 1));
  		 
  		Thread.sleep(4000);
  		Login1.LoginBtn();
  		Thread.sleep(4000);
  		String expectedURL="https://cyfuture.cloud/vm/create-vm";
  		String actualURL = driver.getCurrentUrl();
  		if(expectedURL.equals(actualURL))
  			{
  			driver.findElement(By.xpath("//li[@class='profile-dropdon']")).click();
  			driver.findElement(By.xpath("//span[text()='Settings']")).click();
  			AssertJUnit.assertTrue(true);
  			}
  			else
  			{
  				AssertJUnit.assertTrue(false);
  			}
    }
  	 @Test(priority=3)
  	  	public void Chengepassword() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
  	    {
  			driver.findElement(By.xpath("//*[@id=\"tab1\"]/div/ul/li[2]/a")).click();
  	  		cp.OldPass(Utility.getTestData(7, 1));
  	     	cp.Newpass(Utility.getTestData(7, 4));
  	     	cp.RePass(Utility.getTestData(7, 4));
  	     	cp.Updatebtn();
  	  		String expectedURL="https://cyfuture.cloud/login";
  	  		String actualURL = driver.getCurrentUrl();
  	  		if(expectedURL.equals(actualURL))
  	  			{
  	  			AssertJUnit.assertTrue(true);
  	  			}
  	  			else
  	  			{
  	  				AssertJUnit.assertTrue(false);
  	  			}
     }
    
  		@AfterTest
  		 public void teardown()
  		 {
  			 driver.quit();
  		 }
}
