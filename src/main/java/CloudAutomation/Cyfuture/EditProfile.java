package CloudAutomation.Cyfuture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditProfile
{
	
	WebDriver driver;
	@FindBy (xpath="//input[@id='user_name']") private WebElement NAME ;
	@FindBy (xpath ="//input[@id='address_1']") private WebElement Address;
	@FindBy (xpath ="//input[@id='city']") private WebElement City;
	@FindBy (xpath ="//select[@id='state_region']") private WebElement State;
	@FindBy (xpath ="//select[@class='custom-select']") private WebElement custom;
	@FindBy (xpath ="//input[@id='postcode']") private WebElement PostCode;
	@FindBy (xpath ="//input[@id='company_name']") private WebElement CompanyName;
	@FindBy (xpath ="//input[@id='tax_id']") private WebElement Taxid;
	@FindBy (xpath ="//select[@id='account_manager']") private WebElement ManagerName;
	@FindBy (xpath ="(//button[@class='cancel'])[3]") private WebElement UpdateBtn;
	
	public EditProfile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void updateName(String Name)
	{   
		NAME.clear();
		NAME.sendKeys(Name);

	}
	public void updateAddress(String address)
	{
		Address.clear();
		Address.sendKeys(address);
	}
	public void updateCity(String city)
	{
		City.clear();
        City.sendKeys(city);
			
	}
	public void updateState(String state)
	{
		WebElement List = State;
		Select s=new Select(List);
		s.selectByVisibleText(state);
	}
	public void updateCustom(String Custom)
	{
	custom.sendKeys(Custom);
	}
	public void updatepostcode(String postcode)
	{
		PostCode.sendKeys(postcode);
	}

	public void updateCompanyName(String companyname)
	{
		CompanyName.clear();
		CompanyName.sendKeys(companyname);
	}
	public void updateTaxId(String taxid)
	{
		Taxid.clear();
		Taxid.sendKeys(taxid);
	}
	public void updateManagerName(String Mname)
	{
		
		WebElement List = ManagerName;
		Select s=new Select(List);
		s.selectByVisibleText(Mname);
	}

	public void Updatebtn() throws InterruptedException
	{
		Thread.sleep(8000);
		UpdateBtn.click();
	}

}

