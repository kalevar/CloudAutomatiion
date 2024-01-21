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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ForgotpasswordTest extends BaseClass
{
	public static Logger Log=LogManager.getLogger(BaseClass.class.getName());
	Login Login1 ;
		
	ForgotPassword forgot;

 @BeforeClass
 public void openBrowser() throws IOException, InterruptedException
 {
	 driver=browserOpen();
	driver=getLoginUrl();
	Login1=new Login(driver);
	forgot=new ForgotPassword(driver);
	driver.findElement(By.xpath("//a[text()=' Forgot password ']")).click();
 }
 
 @Test(priority=0)
 public void RegisterEmail() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {  
	 forgot.forgotEmail(Utility.forgotpasswordTestData(0, 0));
	
	 forgot.Forgotsubmit();
	 
	
	String expectedErrorMsg ="Reset pass link has been send to your registered email address";
	 
	WebElement Validationmsg=driver.findElement(By.xpath("//div[@role='alert']"));
	 String actualErrorMsg = Validationmsg.getText();
	 		
	 AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
	 Log.info("Login With Invalid Password");
 }
 @Test(priority=1)
 public void UnRegisterEmail() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {  
	 forgot.forgotEmail(Utility.forgotpasswordTestData(1, 0));
	
	 forgot.Forgotsubmit();
	String expectedErrorMsg ="We can't find a user with that e-mail address.";
	 
	WebElement Validationmsg=driver.findElement(By.xpath("(//span[@role='alert'])//strong"));
	 String actualErrorMsg = Validationmsg.getText();
	 		
	 AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
	 Log.info("Login With Invalid Password");
 }
 @Test(priority=2)
 public void InvalidEmail() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {  
	 forgot.forgotEmail(Utility.forgotpasswordTestData(2, 0));
	
	 forgot.Forgotsubmit();
	String expectedErrorMsg ="Please enter a valid email address.";
	 
	WebElement Validationmsg=driver.findElement(By.xpath("//label[text()='Please enter a valid email address.']"));
	 String actualErrorMsg = Validationmsg.getText();
	 		
	 AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
	 Log.info("Login With Invalid Password");
 }
 @Test(priority=3)
 public void InvalidEmail1() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {  
	 forgot.forgotEmail(Utility.forgotpasswordTestData(3, 0));
	
	 forgot.Forgotsubmit();
	String expectedErrorMsg ="Please enter a valid email address.";
	 
	WebElement Validationmsg=driver.findElement(By.xpath("//label[text()='Please enter a valid email address.']"));
	 String actualErrorMsg = Validationmsg.getText();
	 		
	 AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
	 Log.info("Login With Invalid Password");
 }
 @Test(priority=4)
 public void InvalidEmail2() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {  
	 forgot.forgotEmail(Utility.forgotpasswordTestData(4, 0));
	
	 forgot.Forgotsubmit();
	String expectedErrorMsg ="Please enter a valid email address.";
	 
	WebElement Validationmsg=driver.findElement(By.xpath("//label[text()='Please enter a valid email address.']"));
	 String actualErrorMsg = Validationmsg.getText();
	 		
	 AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
	 Log.info("Login With Invalid Password");
 }
 @Test(priority=5)
 public void blankEmail() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
 {  
	 forgot.forgotEmail(Utility.forgotpasswordTestData(5, 0));
	
	 forgot.Forgotsubmit();
	String expectedErrorMsg ="The email field is required.";
	 
	WebElement Validationmsg=driver.findElement(By.xpath("//label[text()='The email field is required.']"));
	 String actualErrorMsg = Validationmsg.getText();
	 		
	 AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
	 Log.info("forget With blank Email");
 }
 
 
 
 @AfterTest
 public void teardown()
 {
	 driver.quit();
 }
}
