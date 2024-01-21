package CloudAutomation.Cyfuture;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Windows 
{
	WebDriver driver;
	@FindBy (xpath ="//*[@id=\"vm_form\"]/div[1]/ul/li[1]/div/div/label") private WebElement DelhiNCR ;
	@FindBy (xpath ="//li[@id=\"1_id\"]") private WebElement windowsD;
	@FindBy (xpath ="(//div[@class='linxnavtabimg'])[1]") private WebElement winOption;
	@FindBy (xpath="(//select[@id='Windows'])[1]") private WebElement WindowSelect ;

	
	public Windows(WebDriver driver)  
	{
		PageFactory.initElements(driver, this);
	}
	public void DELHINCR() throws InterruptedException
	{    
		Thread.sleep(1000);
		DelhiNCR.click();
	}
	public void WindowsD1()
	{
		windowsD.click();
	}
	public void WINOPTION()
	{
		winOption.click();
	}
	public void windowselect()
	{
		Select s=new Select(WindowSelect);
	  	  s.selectByVisibleText("Windows Server 2012"); 
	}
}



