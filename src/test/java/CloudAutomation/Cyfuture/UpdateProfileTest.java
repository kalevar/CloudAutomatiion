package CloudAutomation.Cyfuture;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateProfileTest extends BaseClass
{ 
	Login Login1 ;
	//LogOut logout;

@BeforeClass
public void openBrowser1() throws IOException, InterruptedException
{
 driver=browserOpen();
driver=getLoginUrl();
Login1=new Login(driver);
}
 @Test(priority=1)
	 public void UpadatProfile() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException
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
				driver.findElement(By.xpath("//a[text()='Update Profile']")).click();
				
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
