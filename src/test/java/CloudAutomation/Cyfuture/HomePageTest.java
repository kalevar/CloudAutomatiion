package CloudAutomation.Cyfuture;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HomePageTest extends BaseClass
{
	WebDriver driver;

	 @BeforeClass
	 public void openBrowser1() throws IOException, InterruptedException
	 {
		 driver=browserOpen();
		// driver=GetRegister();
		//R=new Registration(driver);
	 }
  
	@Test
	public void verifySignandSignUpPressence()
	{
		WebElement SignIn=driver.findElement(By.xpath("(//a[text()='Sign In'])[1]"));
		WebElement SignUp=driver.findElement(By.xpath("(//a[text()='Join Now'])[1]"));
		AssertJUnit.assertTrue(SignIn.isDisplayed());
		AssertJUnit.assertTrue(SignUp.isDisplayed());
	}
   
	 @AfterTest
	 public void teardown()
	 {
		 driver.quit();
	 }

}
