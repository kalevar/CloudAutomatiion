package CloudAutomation.Cyfuture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword
{
public WebDriver driver;
	
    @FindBy (xpath="//input[@class='form-control ']") private WebElement Forgot;
    @FindBy (xpath="//input[@name='email']") private WebElement EMAIL;
    @FindBy (xpath="//strong[text()='Submit']") private WebElement forgotSubmitBtn;
    
    
	public ForgotPassword(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public void forgotEmail(String Email)
	{
		EMAIL.clear();
		EMAIL.sendKeys(Email);

	}
	public void Forgotsubmit() throws InterruptedException
	{
		
		Thread.sleep(8000);
		forgotSubmitBtn.click();

	}
	


}
