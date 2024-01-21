package CloudAutomation.Cyfuture;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Pay extends BaseClass
{
		
	EditProfile ediP;
	Login Login1 ;
	Payment Pay1;
   
	
   @BeforeClass
	public void openBrowser1() throws IOException, InterruptedException
	{
	 driver=browserOpen();
	driver=getLoginUrl();
	Login1=new Login(driver);
	Pay1=new Payment(driver);
	}
  
   
   @Test(priority=1)
   public void LoginWithbilling() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
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
  		driver.findElement(By.xpath("//li[@class='profile-dropdon']")).click();
  		driver.findElement(By.xpath("//span[text()='Billing']")).click();
  		AssertJUnit.assertTrue(true);
  		}
  		else
  		{
  			AssertJUnit.assertTrue(false);
  		}
   }
   @Test(priority=6)
   public void paypalSelecta() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
   {
    	driver.findElement(By.xpath("//a[text()='Paypal']")).click();
    	Pay1.SelectAmount(Utility.GetPaymentamount(1, 0));
    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,350)","");
    	 
    	 Thread.sleep(4000);
    	 
    }
    @Test(priority=5)
    public void PayCustomA() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
    {
     	driver.findElement(By.xpath("//a[text()='Paypal']")).click();
     	Pay1.SelectAmount(Utility.GetPaymentamount(2, 0));
     	
     	JavascriptExecutor js=(JavascriptExecutor)driver;
     	js.executeScript("window.scrollBy(0,350)","");
     	Thread.sleep(2000);
     	Pay1.Customselect(Utility.GetPaymentamount(1, 1));	
     	//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
  	  String expectedErrorMsg="Payments between $5.00 and $10000.00 are accepted.";
	 WebElement exp = driver.findElement(By.xpath("//p[@id='validation_message']"));
	 String actualErrorMsg = exp.getText();
	// System.out.println(actualErrorMsg);
	 
	if(expectedErrorMsg.equals(actualErrorMsg))
		{
		AssertJUnit.assertTrue(true);
		}
		else
		{
			AssertJUnit.assertTrue(false);
		}
  }
    @Test(priority=3)
    public void RozarCustomA() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
     {
      	driver.findElement(By.xpath("//a[text()='Razorpay']")).click();
      	Pay1.SelectRupee(Utility.GetPaymentamount(2, 2));
      	
      	JavascriptExecutor js=(JavascriptExecutor)driver;
      	js.executeScript("window.scrollBy(0,350)","");
      	Thread.sleep(2000);
      	Pay1.CustomselectRozar(Utility.GetPaymentamount(1, 3));	
   	  String expectedErrorMsg="Please enter amount greater then or equal to 100.";
 	 WebElement exp = driver.findElement(By.xpath("//span[@id='error']"));
 	  String actualErrorMsg = exp.getText();
 	 
 	 Pay1.Rozarbtn(); 	
 	if(expectedErrorMsg.equals(actualErrorMsg))
 		{
 		AssertJUnit.assertTrue(true);
 		}
 		else
 		{
 			AssertJUnit.assertTrue(false);
 		}
	
     }
    @Test(priority=4)
    public void Coupancreditalrady() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
    {
     	driver.findElement(By.xpath("//a[text()='Coupon Credit']")).click();
     	Pay1.SelectRupee(Utility.GetPaymentamount(1, 4));
     	JavascriptExecutor js=(JavascriptExecutor)driver;
     	js.executeScript("window.scrollBy(0,350)","");
     	Pay1.Coupancreditbtn();
     	String expectedErrorMsg="This coupon code not found in database!";
    	 WebElement exp = driver.findElement(By.xpath("//div[@class='row']"));
    	  String actualErrorMsg = exp.getText();	
    	if(expectedErrorMsg.equals(actualErrorMsg))
    		{
    		AssertJUnit.assertTrue(true);
    		}
    		else
    		{
    			AssertJUnit.assertTrue(false);
    		}
   	
     }
    @Test(priority=4)
    public void Clouancreditincorrect() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
    {
     	driver.findElement(By.xpath("//a[text()='Coupon Credit']")).click();
     	Pay1.SelectRupee(Utility.GetPaymentamount(1, 5));
     	JavascriptExecutor js=(JavascriptExecutor)driver;
     	js.executeScript("window.scrollBy(0,350)","");
    	Pay1.Coupancreditbtn();
     	String expectedErrorMsg="This coupon code not found in database!";
    	 WebElement exp = driver.findElement(By.xpath("//div[@class='row']"));
    	  String actualErrorMsg = exp.getText();	
    	if(expectedErrorMsg.equals(actualErrorMsg))
    		{
    		AssertJUnit.assertTrue(true);
    		}
    		else
    		{
    			AssertJUnit.assertTrue(false);
    		}
     }
    @Test(priority=4)
    public void CoupancreditCorrect() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
    {
     	driver.findElement(By.xpath("//a[text()='Coupon Credit']")).click();
     	Pay1.SelectRupee(Utility.GetPaymentamount(1, 6));
     	JavascriptExecutor js=(JavascriptExecutor)driver;
     	js.executeScript("window.scrollBy(0,350)","");
     	Pay1.Coupancreditbtn();
     	String expectedErrorMsg="This coupon code not found in database!";
    	 WebElement exp = driver.findElement(By.xpath("//div[@class='row']"));
    	  String actualErrorMsg = exp.getText();	
    	if(expectedErrorMsg.equals(actualErrorMsg))
    		{
    		AssertJUnit.assertTrue(true);
    		}
    		else
    		{
    			AssertJUnit.assertTrue(false);
    		}
  		

     }
    @Test(priority=4)
    public void RozarSelecta() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
    {
     	driver.findElement(By.xpath("//a[text()='Razorpay']")).click();
     	Pay1.SelectRupee(Utility.GetPaymentamount(1, 2));
     	JavascriptExecutor js=(JavascriptExecutor)driver;
     	js.executeScript("window.scrollBy(0,350)","");
     	Pay1.Rozarbtn();
     	//String expectedURL="https://cyfuture.cloud/vm/create-vm";
     	Thread.sleep(3000);
  		

     }
    @AfterTest
    public void teardown()
    {
   	 driver.quit();
    }
}