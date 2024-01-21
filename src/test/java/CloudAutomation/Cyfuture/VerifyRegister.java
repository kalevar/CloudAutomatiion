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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyRegister extends BaseClass
{
	String actualErrormsg=null;
 public static Logger log=LogManager.getLogger(BaseClass.class.getName());
      Registration R;
	//LogOut logout;

	 @BeforeClass
	 public void openBrowser() throws IOException, InterruptedException
	 {
		 driver=browserOpen();
		 driver=GetRegister();
		R=new Registration(driver);
	 }
		
	@Test
	 public void AlreadyRegistertoCloud() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		 R.SignName(Utility.getRegisterData(1, 0));
		 R.SignEmail(Utility.getRegisterData(1, 1));
		 R.SignPass(Utility.getRegisterData(1, 2));
		 R.SignCPass(Utility.getRegisterData(1, 3));
		 R.SignCountry(Utility.getRegisterData(1, 4));
		 R.SignPhone(Utility.getRegisterData(1, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			String errorMessageText = driver.findElement(By.xpath("//div[@class='invalid-feedback']")).getText();
			System.out.println(errorMessageText);
			AssertJUnit.assertEquals(errorMessageText,"The email has already been taken.");
			//driver.quit();
			log.info("Already register Email");

	 }

	 @Test
	 public void RegistertoCloudBlankNameField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 { 
		 R.SignName(Utility.getRegisterData(2, 0));
        
		 R.SignEmail(Utility.getRegisterData(2, 1));
		 R.SignPass(Utility.getRegisterData(2, 2));
		 R.SignCPass(Utility.getRegisterData(2, 3));
		 R.SignCountry(Utility.getRegisterData(2, 4));
		 R.SignPhone(Utility.getRegisterData(2, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			String errorMessageText = driver.findElement(By.xpath("//label[@id='name-error']")).getText();
			System.out.println(errorMessageText);
			AssertJUnit.assertEquals(errorMessageText,"The username field is required.");
			log.info("Test with blank Name field");
			//driver.quit();
	 }
	 @Test
	 public void RegistertoCloudNumericNameField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 { 
		 R.SignName(Utility.getRegisterData(3, 0));
        
		 R.SignEmail(Utility.getRegisterData(3, 1));
		 R.SignPass(Utility.getRegisterData(3, 2));
		 R.SignCPass(Utility.getRegisterData(3, 3));
		 R.SignCountry(Utility.getRegisterData(3, 4));
		 R.SignPhone(Utility.getRegisterData(3, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			String errorMessageText = driver.findElement(By.xpath("//label[@id='name-error']")).getText();
			System.out.println(errorMessageText);
			AssertJUnit.assertEquals(errorMessageText,"The username field is required.");
			log.info("Test with numeric and special character Name field");
	 }
	 @Test
	 public void RegistertoCloudBlankEmailField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {  
		 R.SignName(Utility.getRegisterData(4, 0));
		 R.SignEmail(Utility.getRegisterData(4, 1));
		 R.SignPass(Utility.getRegisterData(4, 2));
		 R.SignCPass(Utility.getRegisterData(4, 3));
		 R.SignCountry(Utility.getRegisterData(4, 4));
		 R.SignPhone(Utility.getRegisterData(4, 5));
		 Thread.sleep(10000);
	     R.SignBtn();
	     String errorMessageText = driver.findElement(By.xpath("//label[@id='email-error']")).getText();
			System.out.println(errorMessageText);
			AssertJUnit.assertEquals(errorMessageText,"The email field is required.");
			log.info("Test with blank Email field");
	 }
	 @Test
	 public void RegisterInvalidEmailDataCloud() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		 R.SignName(Utility.getRegisterData(5, 0));
		 R.SignEmail(Utility.getRegisterData(5, 1));
		 R.SignPass(Utility.getRegisterData(5, 2));
		 R.SignCPass(Utility.getRegisterData(5, 3));
		 R.SignCountry(Utility.getRegisterData(5, 4));
		 R.SignPhone(Utility.getRegisterData(5, 5));
		 Thread.sleep(10000);
		 R.SignBtn();	
		 String errorMessageText = driver.findElement(By.xpath("//label[@id='password_confirmation-error']")).getText();
		   System.out.println(errorMessageText);
			AssertJUnit.assertEquals(errorMessageText,"Please enter a valid email address.");
	       log.info("Invalid Email");
	 }
	
	 @Test
	 public void RegistertoCloudBlankPasswordField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		
		 R.SignName(Utility.getRegisterData(6, 0));
		 R.SignEmail(Utility.getRegisterData(6, 1));
		 R.SignPass(Utility.getRegisterData(6, 2));
		 R.SignCPass(Utility.getRegisterData(6, 3));
		 R.SignCountry(Utility.getRegisterData(6, 4));
		 R.SignPhone(Utility.getRegisterData(6, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			String errorMessageText = driver.findElement(By.xpath("//label[@id='password-error']")).getText();
			System.out.println(errorMessageText);
			AssertJUnit.assertEquals(errorMessageText,"The password field is required.");
			 log.info("Blank Password Field");
	 }
	 @Test
	 public void RegisterwithlessthanlimitPassword() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		
		 R.SignName(Utility.getRegisterData(7, 0));
		 R.SignEmail(Utility.getRegisterData(7, 1));
		 R.SignPass(Utility.getRegisterData(7, 2));
		 R.SignCPass(Utility.getRegisterData(7, 3));
		 R.SignCountry(Utility.getRegisterData(7, 4));
		 R.SignPhone(Utility.getRegisterData(7, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			String errorMessageText = driver.findElement(By.xpath("//label[@id='password_confirmation-error']")).getText();
			System.out.println(errorMessageText);
			AssertJUnit.assertEquals(errorMessageText,"Your password must be more than 8 characters long");
			 log.info("Password must be more than 8 caharcter");
	 }
	 @Test
	 public void RegistertoCloudBlankConfirmpasswodField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		 R.SignName(Utility.getRegisterData(8, 0));
		 R.SignEmail(Utility.getRegisterData(8, 1));
		 R.SignPass(Utility.getRegisterData(8, 2));
		 R.SignCPass(Utility.getRegisterData(8, 3));
		 R.SignCountry(Utility.getRegisterData(8, 4));
		 R.SignPhone(Utility.getRegisterData(8, 5));
		 Thread.sleep(10000);
		 R.SignBtn();
		 String errorMessageText = driver.findElement(By.xpath("//label[@id='password_confirmation-error']")).getText();
		   System.out.println(errorMessageText);
			AssertJUnit.assertEquals(errorMessageText,"The confirm password field is required.");
			log.info("Test With Blank confirm password");
	 }
	 
	 @Test
	 public void RegistertoBlankcountryField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		 R.SignName(Utility.getRegisterData(9, 0));
		 R.SignEmail(Utility.getRegisterData(9, 1));
		 R.SignPass(Utility.getRegisterData(9, 2));
		 R.SignCPass(Utility.getRegisterData(9, 3));
		 R.SignCountry(Utility.getRegisterData(9, 4));
		 R.SignPhone(Utility.getRegisterData(9, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			String errorMessageText = driver.findElement(By.xpath("//label[@id='country_id-error']")).getText();
			System.out.println(errorMessageText);
				AssertJUnit.assertEquals(errorMessageText,"The select field is required.");
				log.info("Test with blank Country");	
	 }
     @Test
	 public void RegistertoCloudBlankPhoneField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		 R.SignName(Utility.getRegisterData(10, 0));
		 R.SignEmail(Utility.getRegisterData(10, 1));
		 R.SignPass(Utility.getRegisterData(10, 2));
		 R.SignCPass(Utility.getRegisterData(10, 3));
		 R.SignCountry(Utility.getRegisterData(10, 4));
		 R.SignPhone(Utility.getRegisterData(10, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			 String errorMessageText = driver.findElement(By.xpath("//label[@id='phone-error']")).getText();
			   System.out.println(errorMessageText);
				AssertJUnit.assertEquals(errorMessageText,"The phone field is required.");
				log.info("Test with blank Phone Field");
	 }
     @Test
     public void RegistertoChacterPhoneField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		 R.SignName(Utility.getRegisterData(11, 0));
		 R.SignEmail(Utility.getRegisterData(11, 1));
		 R.SignPass(Utility.getRegisterData(11, 2));
		 R.SignCPass(Utility.getRegisterData(11, 3));
		 R.SignCountry(Utility.getRegisterData(11, 4));
		 R.SignPhone(Utility.getRegisterData(11, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			 String errorMessageText = driver.findElement(By.xpath("//label[@id='phone-error']")).getText();
			   System.out.println(errorMessageText);
				AssertJUnit.assertEquals(errorMessageText,"Please enter numeric digit");
				log.info("Test with Chacter and Special chaarcter phone field");			
	 }
     @Test
     public void RegistertomorethanlimitPhoneField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		 R.SignName(Utility.getRegisterData(12, 0));
		 R.SignEmail(Utility.getRegisterData(12, 1));
		 R.SignPass(Utility.getRegisterData(12, 2));
		 R.SignCPass(Utility.getRegisterData(12, 3));
		 R.SignCountry(Utility.getRegisterData(12, 4));
		 R.SignPhone(Utility.getRegisterData(12, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			 String ExpectedUrl ="https://cyfuture.cloud/register";
			 String actualURL = driver.getCurrentUrl();
			 AssertJUnit.assertEquals(ExpectedUrl, actualURL);
			 log.info("Test with maximum mobile number.");				
	 }
     @Test
     public void RegistertoLessthanlimitPhoneField() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		 R.SignName(Utility.getRegisterData(13, 0));
		 R.SignEmail(Utility.getRegisterData(13, 1));
		 R.SignPass(Utility.getRegisterData(13, 2));
		 R.SignCPass(Utility.getRegisterData(13, 3));
		 R.SignCountry(Utility.getRegisterData(13, 4));
		 R.SignPhone(Utility.getRegisterData(13, 5));
		 Thread.sleep(10000);
			R.SignBtn();
			 String ExpectedUrl ="https://cyfuture.cloud/register";
			 String actualURL = driver.getCurrentUrl();
			 AssertJUnit.assertEquals(ExpectedUrl, actualURL);
			 log.info("Test with minimum mobile number.");				
	 }
	 
	 @Test
	 public void RegistersamepasswordDataCloud() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		 R.SignName(Utility.getRegisterData(14, 0));
		 R.SignEmail(Utility.getRegisterData(14, 1));
		 R.SignPass(Utility.getRegisterData(14, 2));
		 R.SignCPass(Utility.getRegisterData(14, 3));
		 R.SignCountry(Utility.getRegisterData(14, 4));
		 R.SignPhone(Utility.getRegisterData(14, 5));
		 Thread.sleep(10000);
		 R.SignBtn();	
		 String errorMessageText = driver.findElement(By.xpath("//label[@id='password_confirmation-error']")).getText();
		   System.out.println(errorMessageText);
			AssertJUnit.assertEquals(errorMessageText,"Please enter the same password as above");
	   log.info("same password data");
          
	 }
	 @Test
	 public void RegistertocorrectDataCloud() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	 {
		 R.SignName(Utility.getRegisterData(15, 0));
		 R.SignEmail(Utility.getRegisterData(15, 1));
		 R.SignPass(Utility.getRegisterData(15, 2));
		 R.SignCPass(Utility.getRegisterData(15, 3));
		 R.SignCountry(Utility.getRegisterData(15, 4));
		 R.SignPhone(Utility.getRegisterData(15, 5));
		 Thread.sleep(10000);
		 R.SignBtn();	
		 String ExpectedUrl ="https://cyfuture.cloud/authenticate-mobile";
		 String actualURL = driver.getCurrentUrl();
		 AssertJUnit.assertEquals(ExpectedUrl, actualURL);
	   log.info("Correct data");
          
	 }
	 @Test
	 public void RegisterThroughGoogleCloud() 
	 {
		
		WebElement Google=driver.findElement(By.xpath("//span[text()='Sign in with Google']"));
		Google.click();
	
		 //String ExpectedUrl ="https://accounts.google.com/o/oauth2/auth/identifier?client_id=1078693728359-sr2rmq06jgsh1js323vklpt5kvkq90vk.apps.googleusercontent.com&redirect_uri=https%3A%2F%2Fcyfuture.cloud%2Fcallback%2Fgoogle&scope=openid%20profile%20email&response_type=code&state=f3SMoUOu7ONbJCgP7X6iaLR3rj9SkevdrwSaRlF7&flowName=GeneralOAuthFlow";
		// String actualURL = driver.getCurrentUrl();
		 //Assert.assertEquals(actualURL,ExpectedUrl);
	     log.info("");
	   
	 }
	//span[text()='Sign in with Google']
	
	 @AfterTest
	 public void teardown()
	 {
		 driver.close();
	 }

}
