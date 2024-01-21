package CloudAutomation.Cyfuture;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchCloud extends BaseClass
{
	EditProfile ediP;
	Login Login1;
	Windows window;
	
   @BeforeClass
	public void openBrowser1() throws IOException, InterruptedException
	{
	driver=browserOpen();
	driver=getLoginUrl();
	Login1=new Login(driver);
	window=new Windows(driver);
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
	  	driver.findElement(By.xpath("//img[@alt='vm']")).click();
	  	AssertJUnit.assertTrue(true);
	  }
	  else
	  {
	 	AssertJUnit.assertTrue(false);
	  }
 }
	
	@Test(priority=1)
	public void StandardPlannotChoose() throws InterruptedException
	{ 
		window.DELHINCR();
		window.WindowsD1();
		window.WINOPTION();
       JavascriptExecutor js=(JavascriptExecutor)driver;
       js.executeScript("window.scrollBy(0,350)","");  
       window.windowselect();
       
		WebElement element = driver.findElement(By.xpath("((//div[@class='tab-box'])//span[1])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("(//label[@class='radiocheckbox'])[4]")).click();
		
		Thread.sleep(5000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
   	    js1.executeScript("window.scrollBy(0,1200)","");
		driver.findElement(By.xpath("//input[@data-id='password']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
    	js2.executeScript("window.scrollBy(0,2000)","");
		driver.findElement(By.xpath("//label[contains(@for,'enable_backup')]")).click();
		driver.findElement(By.xpath("//input[@id='vm_name']")).sendKeys("windows2012");
		driver.findElement(By.xpath("//input[@class='crt-mchn-btn']")).click();     
		
		String ExpectedErrorMsg="Choose a plan for your Cloud Server";
	  	WebElement actual=driver.findElement(By.xpath("//div[@id='error-msg']"));
	  	String ActualErrormsg=actual.getText();
	    
	      if(ExpectedErrorMsg.equals(ActualErrormsg))
	      {
	    	  AssertJUnit.assertTrue(true);
	      }
	      else
	      {
	    	  AssertJUnit.assertTrue(false);
	      }  
	      
	}
	
	
	@Test(priority=2)
	public void Servernameduplicate() throws InterruptedException
	{
		driver.navigate().refresh();
		JavascriptExecutor js4=(JavascriptExecutor)driver;
	    js4.executeScript("window.scrollBy(0,350)","");
	
		WebElement element = driver.findElement(By.xpath("((//div[@class='tab-box'])//span[1])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(5000);
		JavascriptExecutor js3=(JavascriptExecutor)driver;
	    js3.executeScript("window.scrollBy(0,450)","");
	    driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[2]/div[4]/div[1]/div[9]/div[1]/label[1]")).click();
		
		Thread.sleep(5000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
   	    js1.executeScript("window.scrollBy(0,1200)","");
		//driver.findElement(By.xpath("//input[@data-id='password']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
    	js2.executeScript("window.scrollBy(0,2000)","");
		driver.findElement(By.xpath("//label[contains(@for,'enable_backup')]")).click();
		driver.findElement(By.xpath("//input[@id='vm_name']")).sendKeys("windows2012Wind");
		driver.findElement(By.xpath("//input[@class='crt-mchn-btn']")).click();     
		
		String ExpectedErrorMsg="Machine name is already taken in the cloud";
	  	WebElement actual=driver.findElement(By.xpath("//span[text()='Machine name is already taken in the cloud']"));
	  	String ActualErrormsg=actual.getText();
	    
	      if(ExpectedErrorMsg.equals(ActualErrormsg))
	      {
	    	  AssertJUnit.assertTrue(true);
	      }
	      else
	      {
	    	  AssertJUnit.assertTrue(false);
	      }  
	      
	}
	@Test(priority=3)
	public void ChooseDistribution() throws InterruptedException
	{  
		
	    String s=driver.getCurrentUrl();
	    ((JavascriptExecutor)driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
	    driver.get(s);
	
		 JavascriptExecutor js4=(JavascriptExecutor)driver;
	       js4.executeScript("window.scrollBy(0,350)","");
	       
	   	WebElement WindowSelect = driver.findElement(By.xpath("(//select[@id='Windows'])[1]"));
	     Select s1=new Select(WindowSelect);
	   	  s1.selectByVisibleText("Choose Option"); 
	   	
	
		WebElement element = driver.findElement(By.xpath("((//div[@class='tab-box'])//span[1])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(5000);
		JavascriptExecutor js3=(JavascriptExecutor)driver;
	       js3.executeScript("window.scrollBy(0,450)","");
	    driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[2]/div[4]/div[1]/div[9]/div[1]/label[1]")).click();
		
		
		Thread.sleep(5000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
   	    js1.executeScript("window.scrollBy(0,1200)","");
		//driver.findElement(By.xpath("//input[@data-id='password']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
    	js2.executeScript("window.scrollBy(0,2000)","");
		driver.findElement(By.xpath("//label[contains(@for,'enable_backup')]")).click();
		driver.findElement(By.xpath("//input[@id='vm_name']")).sendKeys("windows");
		driver.findElement(By.xpath("//input[@class='crt-mchn-btn']")).click();     
		
		String ExpectedErrorMsg="You need to select a distribution before you can create a Cloud Server";
	  	WebElement actual=driver.findElement(By.xpath("//div[@id='error-msg']"));
	  	String ActualErrormsg=actual.getText();
	  	//System.out.println(ActualErrormsg);
	    Thread.sleep(2000);
	    
	      if(ExpectedErrorMsg.equals(ActualErrormsg))
	      {
	    	  AssertJUnit.assertTrue(true);
	      }
	      else
	      {
	    	  AssertJUnit.assertTrue(false);
	    	  
	      }  
	      
	}
	@Test(priority=4)
	public void Machinenameblank() throws InterruptedException
	{
		 JavascriptExecutor js4=(JavascriptExecutor)driver;
	       js4.executeScript("window.scrollBy(0,350)","");
	       
	   	WebElement WindowSelect = driver.findElement(By.xpath("(//select[@id='Windows'])[1]"));
	     Select s1=new Select(WindowSelect);
	   	  s1.selectByVisibleText("Windows Server 2012"); 
	   	
	
		WebElement element = driver.findElement(By.xpath("((//div[@class='tab-box'])//span[1])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(5000);
		JavascriptExecutor js3=(JavascriptExecutor)driver;
	       js3.executeScript("window.scrollBy(0,450)","");
	    driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[2]/div[4]/div[1]/div[9]/div[1]/label[1]")).click();
		
		
		Thread.sleep(5000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
   	    js1.executeScript("window.scrollBy(0,1200)","");
		//driver.findElement(By.xpath("//input[@data-id='password']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
    	js2.executeScript("window.scrollBy(0,2000)","");
		driver.findElement(By.xpath("//label[contains(@for,'enable_backup')]")).click();
		//driver.findElement(By.xpath("//input[@id='vm_name']")).sendKeys("");
		driver.findElement(By.xpath("//input[@class='crt-mchn-btn']")).click();     
		
		String ExpectedErrorMsg="Can’t create a Cloud Server unless name is mentioned";
	  	WebElement actual=driver.findElement(By.xpath("//span[text()='Can’t create a Cloud Server unless name is mentioned']"));
	  	String ActualErrormsg=actual.getText();
	  	//System.out.println(ActualErrormsg);
	    Thread.sleep(2000);
	    
	      if(ExpectedErrorMsg.equals(ActualErrormsg))
	      {
	    	  AssertJUnit.assertTrue(true);
	      }
	      else
	      {
	    	  AssertJUnit.assertTrue(false);
	    	  
	      }  
	      
	}
	
	@Test(priority=5)
	public void CreateMachine() throws InterruptedException
	{ 
		 JavascriptExecutor js4=(JavascriptExecutor)driver;
	       js4.executeScript("window.scrollBy(0,350)","");
	       
	   	WebElement WindowSelect = driver.findElement(By.xpath("(//select[@id='Windows'])[1]"));
	     Select s1=new Select(WindowSelect);
	   	  s1.selectByVisibleText("Windows Server 2012"); 
	   	
	
		WebElement element = driver.findElement(By.xpath("((//div[@class='tab-box'])//span[1])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(5000);
		JavascriptExecutor js3=(JavascriptExecutor)driver;
	       js3.executeScript("window.scrollBy(0,450)","");
	    driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[2]/div[4]/div[1]/div[9]/div[1]/label[1]")).click();
		
		
		Thread.sleep(5000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
   	    js1.executeScript("window.scrollBy(0,1200)","");
		//driver.findElement(By.xpath("//input[@data-id='password']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
    	js2.executeScript("window.scrollBy(0,2000)","");
		driver.findElement(By.xpath("//label[contains(@for,'enable_backup')]")).click();
		driver.findElement(By.xpath("//input[@id='vm_name']")).sendKeys("vgdg4451");
		driver.findElement(By.xpath("//input[@class='crt-mchn-btn']")).click(); 
		Thread.sleep(50000);
		
		String ExpectedMsg="Thank you! Your machine has been created successfully. Kindly check your registered email for Machine specifications with in 300 seconds.";
		
		WebElement actual=driver.findElement(By.xpath("(//div[@class='modal-body'])[1]"));
		String s=actual.getText();
		
		if(ExpectedMsg.equals(s))
		{
			 AssertJUnit.assertTrue(true);
			 driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
			  
		 }
	     else
	     {
	    	  AssertJUnit.assertTrue(false);
	    	  
	      }          
	}
	
	@Test(priority=6)
	public void CreateMachineIssue() throws InterruptedException
	{ 
		 JavascriptExecutor js4=(JavascriptExecutor)driver;
	       js4.executeScript("window.scrollBy(0,350)","");
	       
	   	WebElement WindowSelect = driver.findElement(By.xpath("(//select[@id='Windows'])[1]"));
	     Select s1=new Select(WindowSelect);
	   	  s1.selectByVisibleText("Windows Server 2012"); 
	   	
	
		WebElement element = driver.findElement(By.xpath("((//div[@class='tab-box'])//span[1])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(5000);
		JavascriptExecutor js3=(JavascriptExecutor)driver;
	       js3.executeScript("window.scrollBy(0,450)","");
	    driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[2]/div[4]/div[1]/div[9]/div[1]/label[1]")).click();
		
		
		Thread.sleep(5000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
   	    js1.executeScript("window.scrollBy(0,1200)","");
		//driver.findElement(By.xpath("//input[@data-id='password']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
    	js2.executeScript("window.scrollBy(0,2000)","");
		driver.findElement(By.xpath("//label[contains(@for,'enable_backup')]")).click();
		driver.findElement(By.xpath("//input[@id='vm_name']")).sendKeys("vinod2121q");
		driver.findElement(By.xpath("//input[@class='crt-mchn-btn']")).click(); 
		Thread.sleep(10000);
		//*[@id="myModal-new"]/div/div
		
		try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            Thread.sleep(3000);
           String Expectederror="There is problem during your Machine creation process please try again";
           
           String actual=simpleAlert.getText();
           if(Expectederror.equals(actual))
           {
             AssertJUnit.assertTrue(true);
     	   }
     	    else
     	    {
     	    	  AssertJUnit.assertTrue(false);
     	    	  
     	    }   
            simpleAlert.dismiss();
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }	    
	}
	 @AfterTest
	 public void teardown()
	 {
		 driver.quit();
	 }
	
}
