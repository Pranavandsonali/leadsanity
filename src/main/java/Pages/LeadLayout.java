package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogCombiner;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LeadLayout {
	
WebDriver driver;
public LeadLayout(WebDriver d)
{
	driver=d;
	PageFactory.initElements(d, this);
}

@FindBy(xpath="//select[@data-autoid=\"LE_PRODUCT_ctrl\"]")
WebElement Product;
public void SelectProduct(String product)
{
	Select productvalue=new Select(Product);
	productvalue.selectByVisibleText(product);
}

@FindBy(xpath="//input[@data-autoid=\"LE_MOBILE_ctrl\"]")
WebElement Mobile;
public void EnterMobile(String mobile)
{
	Mobile.sendKeys(mobile);
}

@FindBy(xpath="//input[@data-autoid=\"LE_EMAIL_ctrl\"]")
WebElement emailid;
public void EnterEmail(String email)
{
	emailid.sendKeys(email);
}

@FindBy(xpath="//select[@data-autoid=\"cust_823_ctrl\"]")
WebElement Currency;
public void  SelectCurrency(String currency)
{
	Select Currencyvalue=new Select(Currency);
	Currencyvalue.selectByVisibleText(currency);
}

@FindBy(xpath="//input[@data-autoid=\"cust_825_ctrl\"]")
WebElement Amount;
public void EnterAmount(String amount)
{
	Amount.sendKeys(amount);
}

@FindBy(xpath="//select[@data-autoid=\"SALUTATION_ctrl\"]")
WebElement Salutation;
public void SelectSalutation(String salutation)
{
	Select SalutationValue=new Select(Salutation);
	SalutationValue.selectByVisibleText(salutation);
}

@FindBy(xpath="//input[@data-autoid=\"FULLNAME_ctrl\"]")
WebElement Name;
public void  EnterName(String name)
{
	Name.sendKeys(name);
}

@FindBy(xpath="//select[@data-autoid=\"cust_42_ctrl\"]")
WebElement VIP;
public void SelectVip(String vip)
{
	Select VIPValue=new Select(VIP);
	VIPValue.selectByVisibleText(vip);
	
}

@FindBy(xpath="//select[@data-autoid=\"LE_PREFERRED_ctrl\"]")
WebElement PreferredChannel;
public void SelectPreferredChannel(String Preferredchannel)
{
	Select PreferredChannelValue = new Select(PreferredChannel);
	PreferredChannelValue.selectByVisibleText(Preferredchannel);
}

@FindBy(xpath="//textarea[@data-autoid=\"cust_76_ctrl\"]")
WebElement Comments;
public void EnterComments(String comments)
{
	Comments.sendKeys(comments);
}

@FindBy(xpath="//input[@data-autoid=\"LE_ZIP_CODE_ctrl\"]")
WebElement PreferredBranch;
public WebElement EnterPreferredBranch()
{
	return PreferredBranch;
	
}

@FindBy(xpath="//a[@data-autoid=\"FlowNext\"]/span")
WebElement SaveButton;
public void CliclSave()
{
	SaveButton.click();
}

@FindBy(xpath="(//a[@name=\"ProfileImage_header\"])[1]")
WebElement AccountSetting;
public void AccountSetting()
{
	AccountSetting.click();
}

@FindBy(xpath="//a[@title=\"Logout\"]")
WebElement Logout;
public void Logout()
{
	Logout.click();
}

@FindBy(xpath="//span[@data-autoid=\"LE_LEADOWNER_ctrl\"]")
WebElement LeadOwner;
public String GetLeadOwner()
{
	String Owner=LeadOwner.getText();
	return Owner;
	
}


@FindBy(xpath="//a[@data-autoid='btn_toggle']")
WebElement ToggleButton;
public void ClickToggleButton()
{
	ToggleButton.click();
}



}