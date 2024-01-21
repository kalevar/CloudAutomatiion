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

public class PayButton extends BaseClass
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
	 @Test(priority=0)
	  public void PayButton() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
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
	 			driver.findElement(By.xpath("//a[text()='Pay']")).click();
	 			
	 			AssertJUnit.assertTrue(true);
	 			}
	 			else
	 			{
	 				AssertJUnit.assertTrue(false);
	 			}
	 	 }
	 @Test(priority=1)
	   public void paypalSelecta() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	   {
	    	driver.findElement(By.xpath("//a[text()='Paypal']")).click();
	    	Pay1.SelectAmount(Utility.GetPaymentamount(1, 0));
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("window.scrollBy(0,350)","");
	    	 driver.findElement(By.xpath("//body/div[2]/div[2]/div[4]/div[3]/div[1]")).click();
	    	 Thread.sleep(4000);	
	    }
	    @Test(priority=2)
	    public void PayCustomA() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	    {
	     	driver.findElement(By.xpath("//a[text()='Paypal']")).click();
	     	Pay1.SelectAmount(Utility.GetPaymentamount(2, 0));
	     	
	     	JavascriptExecutor js=(JavascriptExecutor)driver;
	     	js.executeScript("window.scrollBy(0,350)","");
	     	Thread.sleep(2000);
	     	Pay1.Customselect(Utility.GetPaymentamount(1, 1));	
	     	 driver.findElement(By.xpath("//div[@role='button']")).click();
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
	   	 driver.close();
	    }
}
