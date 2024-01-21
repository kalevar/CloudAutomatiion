package CloudAutomation.Cyfuture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChengePassword 
{

	@FindBy (xpath="//input[@name='current_password']") private WebElement CurrentPassword;
	@FindBy (xpath="//input[@name='new_password']") private WebElement NewPASS;
	@FindBy (xpath="//input[@name='new_confirm_password']") private WebElement Repassword;
	@FindBy (xpath="(//button[@type='submit'])[1]") private WebElement Updatebtn;


	public ChengePassword(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void OldPass(String Opass)
	{
		CurrentPassword.clear();
		CurrentPassword.sendKeys(Opass);

	}
	public void Newpass(String NPass)
	{
		NewPASS.clear();
		NewPASS.sendKeys(NPass);

	}
	public void RePass(String RePass)
	{
		Repassword.clear();
		Repassword.sendKeys(RePass);

	}
	
	public void Updatebtn()
	{
		Updatebtn.click();

	}
	
	
	
}
