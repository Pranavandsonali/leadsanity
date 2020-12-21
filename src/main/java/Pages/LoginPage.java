package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// This Page Contains Login and Summary Page Elements like login,passowrd, sales object etc;
public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	public Actions LeadHomePage;
	public WebElement Sales;
	
	@FindBy(xpath="//input[@id=\"TxtName\"]")
	WebElement Username;
	public void Username(String LoginId)
	{
		Username.sendKeys(LoginId);
	}
	
	@FindBy(id="TxtPassword")
	WebElement Password;
	public void Password(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginButton;
	public void  LoginButton()
	{
		LoginButton.click();
	}
	
	By SalesObject=By.xpath("//i[@class='icon icon-sales']");
	public WebElement SalesObject()
	{
		return driver.findElement(SalesObject);
	}
	
	By LeadObject=By.xpath("//span[text()='Leads']");
	public WebElement LeadObject()
	{
		return driver.findElement(LeadObject);
	}
	
}
