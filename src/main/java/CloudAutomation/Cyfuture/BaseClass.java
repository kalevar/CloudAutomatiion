package CloudAutomation.Cyfuture;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass
{
    static WebDriver driver;

	public static WebDriver browserOpen() throws IOException, InterruptedException
	{
	  Properties prop=new Properties();
	  FileInputStream objfile=new FileInputStream(System.getProperty("user.dir")+"\\URL.properties");
      prop.load(objfile);
	  String browsername=prop.getProperty("browser");
	  if(browsername.equals("chrome"))
	  {
	 
	    System.setProperty("webdriver.chrome.driver", "F:\\Selenium Rahul Shetty\\CloudAutomation\\Cyfuture\\BrowserExe\\chromedriver.exe");
	    ChromeOptions options=new ChromeOptions();
	    options.addArguments("--disable-notifications");    
	    driver=new ChromeDriver();
	  }else if(browsername.equals("firefox"))	   
	  {
	   System.setProperty("webdriver.geckodriver.driver", "E:\\CloudAutomation\\Cloud\\BrowserExe\\geckodriver.exe");
	   driver=new  FirefoxDriver();
      }else if(browsername.equals("IE"))
	        {
			   driver=new InternetExplorerDriver();
	        }

		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();

		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       driver.get(Utility.getPropertyFileData("URL"));
		   Thread.sleep(2000);
	       driver.findElement(By.xpath("//button[@id='cyft-modal']/img")).click();
	       Thread.sleep(4000);
	  //driver.get(Utility.getPropertyFileDataR1("URLR"));
	 
	   // (//a[text()='Join Now'])[1]

	   // Thread.sleep(2000);
	   //driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/button[2]/*[name()='svg'][1]")).click();
     	   return driver;
	}
	
   	public WebDriver GetRegister() throws InterruptedException {
	    for (String handle : driver.getWindowHandles())
		{
	      driver.switchTo().window(handle);
	    }
        driver.findElement(By.xpath("(//a[text()='Join Now'])[1]")).click();
	    //driver.findElement(By.xpath("(//div[@id='livechat-eye-catcher'])[1]")).click();
		Thread.sleep(8000);
		return driver;	
	}
	public WebDriver getLoginUrl() throws IOException, InterruptedException
	{
		 driver.findElement(By.xpath("(//ul[@class='login'])/li/a")).click();
		 Thread.sleep(8000);
		return driver;
	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}
