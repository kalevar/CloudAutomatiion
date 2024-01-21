package CloudAutomation.Cyfuture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut
{
	@FindBy (xpath="/html/body/div[3]/div[1]/div/div/ul/li[4]/p") private WebElement dropArrow;
	@FindBy (xpath="//span[text()='Logout']") private WebElement Logout;


   public LogOut(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void droudown()
{
	dropArrow.click();

}
public void logout()
{
	Logout.click();

}
}
