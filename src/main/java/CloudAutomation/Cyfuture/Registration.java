package CloudAutomation.Cyfuture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration
{
	WebDriver driver;

	@FindBy (xpath="//input[@placeholder='Full Name']") private WebElement NAME ;
	@FindBy (xpath ="//input[@placeholder='Email Address']") private WebElement EMAIL;
	@FindBy (xpath ="//input[@id='password']") private WebElement PASS;
	@FindBy (xpath ="//input[@name='password_confirmation']") private WebElement CPASS;
	@FindBy (xpath ="//select[@id='country_id']") private WebElement Country;
	@FindBy (xpath ="//input[@id='phone']") private WebElement Phone;
	@FindBy (xpath ="//button[@type='submit']") private WebElement SignBtn;

	public Registration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void SignName(String Name)
	{    NAME.clear();
		NAME.sendKeys(Name);

	}
	public void SignEmail(String Email)
	{
		EMAIL.clear();
		EMAIL.sendKeys(Email);
	}
	public void SignPass(String Pass)
	{
		PASS.clear();
		PASS.sendKeys(Pass);
	}
	public void SignCPass(String CPass)
	{
		CPASS.clear();
		CPASS.sendKeys(CPass);
	}
	public void SignCountry(String COUNTRY)
	{
		WebElement List = Country;
		Select s=new Select(List);
		s.selectByVisibleText(COUNTRY);
	}
	public void SignPhone(String Phone1)
	{
		Phone.clear();
		Phone.sendKeys(Phone1);
	}
	public void SignBtn() throws InterruptedException
	{
		Thread.sleep(10000);
		SignBtn.click();
	}

}
