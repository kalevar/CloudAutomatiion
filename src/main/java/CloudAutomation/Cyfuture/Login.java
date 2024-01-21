package CloudAutomation.Cyfuture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{
	
	@FindBy (xpath="//input[@name='email']") private WebElement EMAIL;
	@FindBy (xpath="//input[@name='password']") private WebElement PASS;
	@FindBy (xpath="//strong[text()='Login to your Account!']") private WebElement LoginBtn;
	@FindBy (xpath="//a[text()=' Sign Up Here ']") private WebElement SignupBtn;
	@FindBy (xpath="(//div[@class='login-form'])/p") private WebElement MSG;

	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void LoginEmail(String Email)
	{
		EMAIL.clear();
	    EMAIL.sendKeys(Email);

	}
	public void LoginPass(String Pass)
	{
		PASS.clear();
		PASS.sendKeys(Pass);

	}
	
	public void LoginBtn() throws InterruptedException
	{
		Thread.sleep(10000);
		LoginBtn.click();

	}
	
}
