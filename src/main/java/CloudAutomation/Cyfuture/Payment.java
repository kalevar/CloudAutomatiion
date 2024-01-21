package CloudAutomation.Cyfuture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Payment
{
	WebDriver driver;
	//PayPal
	    @FindBy (xpath="//select[@id='paypal_define_amount']") private WebElement Payamount;
	    @FindBy (xpath="//input[@id='paypal_custom_amount']") private WebElement custamount;
	   // @FindBy (xpath="//body/div[2]/div[2]/div[4]/div[3]/div[1]") private WebElement PayPalbtn;

	//RozarPay
		@FindBy (xpath="//select[@id='paypal_define_amount']") private WebElement RozarPay1;
		@FindBy (xpath="//input[@name='custom_amount']") private WebElement Rcustamount;
		@FindBy (xpath="//button[text()='Proceed to Pay']") private WebElement Rozarpaybtn;
		
     //Coupon Credit
		@FindBy (xpath="//input[@name='coupon_code']") private WebElement Coupancode;
		@FindBy (xpath="//button[@class='btn btn-primary']") private WebElement coupanbtn;
	
		//a[text()='Coupon Credit']
		
	public Payment(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SelectAmount(String payamount)
	{
		WebElement List = Payamount;
		Select s=new Select(List);
		s.selectByVisibleText(payamount);
	}
	
	public void Customselect(String CustA)
	{
		
		custamount.sendKeys(CustA);
	}
	
	public void SelectRupee(String Rpay)
	{
		WebElement List = RozarPay1;
		Select s=new Select(List);
		s.selectByVisibleText(Rpay);
	}
	
	public void CustomselectRozar(String CustRozarA)
	{
	
		Rcustamount.sendKeys(CustRozarA);
	}
	public void Rozarbtn() throws InterruptedException
	{
		Thread.sleep(10000);
		Rozarpaybtn.click();
	}
	public void Coupancredit(String Coupancode1)
	{
		Coupancode.clear();
		Coupancode.sendKeys(Coupancode1);
	}
	public void Coupancreditbtn() throws InterruptedException
	{
		Thread.sleep(10000);
		coupanbtn.click();
	}
	

}
