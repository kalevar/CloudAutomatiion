package CloudAutomation.Cyfuture;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class VerifyLogin extends BaseClass
{
	public static Logger Log=LogManager.getLogger(BaseClass.class.getName());
	Login Login1 ;
		//LogOut logout;

 @BeforeClass
 public void openBrowser() throws IOException, InterruptedException
 {
	 driver=browserOpen();
	driver=getLoginUrl();
	Login1=new Login(driver);
 }
 @Test
 public void chatbotpopup()
 {
	 Actions action=new Actions(driver);
	 action.moveToElement(driver.findElement(By.xpath("//button[@aria-label='Minimize window']"))).build().perform();
	 driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/button[2]/*[name()='svg'][1]")).click();
	 
 }
 
 @Test(priority=1)
 public void LogintowithBlankdpassword() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {
	 Login1.LoginEmail(Utility.getTestData(6, 0));
	Login1.LoginPass(Utility.getTestData(6, 1));
	 
	Thread.sleep(4000);
	Login1.LoginBtn();
	Thread.sleep(4000);
	String expectedErrorMsg="The password field is required.";
	 WebElement exp = driver.findElement(By.xpath("//label[text()='The password field is required.']"));
	 String actualErrorMsg = exp.getText();
	
	if(expectedErrorMsg.equals(actualErrorMsg))
		{
		driver.findElement(By.xpath("//li[@class='profile-dropdon']")).click();
		driver.findElement(By.xpath("//span[text()='Logout']")).click();
		AssertJUnit.assertTrue(true);
		}
		else
		{
			AssertJUnit.assertTrue(false);
		}
	 Log.info("Login With Blank Password Password");
 }
 @Test(priority=0)
 public void LogintowithIvalidpassword() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {
	 Login1.LoginEmail(Utility.getTestData(5, 0));
	 Login1.LoginPass(Utility.getTestData(5, 1));
	 
	Thread.sleep(4000);
	Login1.LoginBtn();
	Thread.sleep(4000);
	String expectedErrorMsg ="Email-address or password are wrong.";
	 
	 WebElement exp = driver.findElement(By.xpath("//p[@class='alert alert-danger']"));
	 String actualErrorMsg = exp.getText();
	 		
	 AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
	 Log.info("Login With Invalid Password");
 }
 

 
 @Test(priority=2)
 public void LogintowithBlankEmail() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {
	 Login1.LoginEmail(Utility.getTestData(4, 0));
	 Login1.LoginPass(Utility.getTestData(4, 1));
	 
	Thread.sleep(4000);
	Login1.LoginBtn();
	Thread.sleep(4000);
	String expectedErrorMsg = "The email field is required.";
	 
	 WebElement exp = driver.findElement(By.xpath("//label[@id='email-error']"));
	 String actualErrorMsg = exp.getText();
	 		
	 AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
 }
 
 
 
 @Test(priority=3)
 public void LogintowithinvalidEmail() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {
	 Login1.LoginEmail(Utility.getTestData(2, 0));
	 Login1.LoginPass(Utility.getTestData(2, 1));
	 
	Thread.sleep(4000);
	Login1.LoginBtn();
	Thread.sleep(4000);
	String expectedURL="https://cyfuture.cloud/vm/create-vm";
	String actualURL = driver.getCurrentUrl();
	
	if(expectedURL.equals(actualURL))
		{
			driver.findElement(By.xpath("//li[@class='profile-dropdon']")).click();
			driver.findElement(By.xpath("//span[text()='Logout']")).click();
			AssertJUnit.assertTrue(false);
		}
		else
		{
			AssertJUnit.assertTrue(true);
		}
 }
 @Test(priority=4)
 public void LogintowithmissingDomainName() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {
	 Login1.LoginEmail(Utility.getTestData(3, 0));
	 Login1.LoginPass(Utility.getTestData(3, 1));
	 
	 
	Thread.sleep(4000);
	Login1.LoginBtn();
	Thread.sleep(4000);
	String expectedURL="https://cyfuture.cloud/vm/create-vm";
	String actualURL = driver.getCurrentUrl();
	
	if(expectedURL.equals(actualURL))
		{
			driver.findElement(By.xpath("//li[@class='profile-dropdon']")).click();
			driver.findElement(By.xpath("//span[text()='Logout']")).click();
			AssertJUnit.assertTrue(false);
		}
		else
		{
			AssertJUnit.assertTrue(true);
		}
 }
 
 @Test(priority=5)
 public void LogintoCloudwithinvalidData() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {
	 Login1.LoginEmail(Utility.getTestData(1, 0));
	 Login1.LoginPass(Utility.getTestData(1, 1));
	 
	Thread.sleep(4000);
	Login1.LoginBtn();
	Thread.sleep(4000);
	String expectedURL="https://cyfuture.cloud/vm/create-vm";
	String actualURL = driver.getCurrentUrl();
	
	if(expectedURL.equals(actualURL))
		{
			driver.findElement(By.xpath("//li[@class='profile-dropdon']")).click();
			driver.findElement(By.xpath("//span[text()='Logout']")).click();
			AssertJUnit.assertTrue(false);
		}
		else
		{
			AssertJUnit.assertTrue(true);
		}
 }
 
 @Test(priority=6)
 public void LogintoCloud() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {
	 Login1.LoginEmail(Utility.getTestData(0, 0));
	 Login1.LoginPass(Utility.getTestData(0, 1));
	 driver.findElement(By.xpath("//span[@class='checkmark']")).click();
	 
	Thread.sleep(4000);
	Login1.LoginBtn();
	Thread.sleep(4000);
	
	String expectedURL="https://cyfuture.cloud/vm/create-vm";
	String actualURL = driver.getCurrentUrl();
	
	if(expectedURL.equals(actualURL))
		{
			driver.findElement(By.xpath("//li[@class='profile-dropdon']")).click();
			driver.findElement(By.xpath("//span[text()='Logout']")).click();
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
	 driver.close();
 }

}
