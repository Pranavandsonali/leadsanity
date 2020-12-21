package ArabBank.LeadsSanity;

import static org.testng.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Pages.LeadLayout;



public class Bancassurance  extends BaseClass{
@SuppressWarnings("unused")
private static final String Passed = null;

String LeadOwner;
String PreferredBranch;
int ActualResult;
Object ExpectedResult;

@Test()
public void Scenerio_1_CallCenter() throws InterruptedException, SQLException
{
	//Asignment Scenerio 1//
	LeadLayout l2=new LeadLayout(driver);
	test=extent.createTest("Scenerio_1_CallCenter");
	login(1);
	
	driver.get("http://arabretail.crmnext.com/g6/app/crmnextobject/RunFlow/Lead?x=wmlptkyqwxpv4bxdnz3cm5b2aqzb5nwqd3ffuxvaqmx8rt2232ef6l5c5pum7qnq6ek3vb5sseahgknkdx6hz4cfcnpf4fl6darftztuysjavwb6sr5a");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	l2.SelectProduct(data.getRow(1).getCell(3).getStringCellValue());
	l2.EnterMobile(data.getRow(1).getCell(4).getStringCellValue());
	l2.EnterEmail(data.getRow(1).getCell(5).getStringCellValue());
	l2.SelectCurrency(data.getRow(1).getCell(6).getStringCellValue());
	l2.EnterAmount(data.getRow(1).getCell(7).getStringCellValue());
	l2.SelectSalutation(data.getRow(1).getCell(8).getStringCellValue());
	l2.EnterName(data.getRow(1).getCell(9).getStringCellValue());
	l2.SelectVip(data.getRow(1).getCell(10).getStringCellValue());
	l2.EnterComments(data.getRow(1).getCell(15).getStringCellValue());
	l2.CliclSave();
	l2.ClickToggleButton();
	LeadOwner=l2.GetLeadOwner();
	test.info(LeadOwner);
	ResultSet Resultset1=stmt.executeQuery("select userid from az_user where shortname='"+LeadOwner+"'");
	while(Resultset1.next())
	ActualResult = Resultset1.getInt(1);
	ResultSet Resultset2=stmt.executeQuery("select memberid from queuemembers where queueid=3 and memberid=(select userid from az_user where shortname='"+LeadOwner+"')");
	while(Resultset2.next())
	ExpectedResult=Resultset2.getInt(1);
	assertEquals(ActualResult, ExpectedResult);
	ExpectedResult= null;
}

@Test()
public void Scenerio_5_7_CallCenter() throws InterruptedException, SQLException
{
	System.out.println(ExpectedResult);
	LeadLayout l2=new LeadLayout(driver);
	test=extent.createTest("Scenerio_5_7_CallCenter");
	//Asignment Scenerio 5 and 7//
	login(2);
	driver.get("http://arabretail.crmnext.com/g6/app/crmnextobject/RunFlow/Lead?x=wmlptkyqwxpv4bxdnz3cm5b2aqzb5nwqd3ffuxvaqmx8rt2232ef6l5c5pum7qnq6ek3vb5sseahgknkdx6hz4cfcnpf4fl6darftztuysjavwb6sr5a");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	l2.SelectProduct(data.getRow(2).getCell(3).getStringCellValue());
	l2.EnterMobile(data.getRow(2).getCell(4).getStringCellValue());
	l2.EnterEmail(data.getRow(2).getCell(5).getStringCellValue());
	l2.SelectCurrency(data.getRow(2).getCell(6).getStringCellValue());
	l2.EnterAmount(data.getRow(2).getCell(7).getStringCellValue());
	l2.SelectSalutation(data.getRow(2).getCell(8).getStringCellValue());
	l2.EnterName(data.getRow(2).getCell(9).getStringCellValue());
	l2.SelectVip(data.getRow(2).getCell(10).getStringCellValue());
	l2.EnterComments(data.getRow(2).getCell(15).getStringCellValue());
	l2.EnterPreferredBranch().sendKeys(data.getRow(2).getCell(14).getStringCellValue());	
	Thread.sleep(2000);
	l2.EnterPreferredBranch().sendKeys(Keys.ARROW_DOWN);
	
	Thread.sleep(1000);
	l2.EnterPreferredBranch().sendKeys(Keys.ENTER);
	
	l2.CliclSave();
	l2.ClickToggleButton();
	LeadOwner=l2.GetLeadOwner();
	test.info(LeadOwner);
	ResultSet Owner=stmt.executeQuery("select userid from az_user where shortname='"+LeadOwner+"'");
	
	while(Owner.next())
	ActualResult=Owner.getInt(1);
	ResultSet memberid=stmt.executeQuery("select memberid from queuemembers where queueid in (1,12) and memberid=(select userid from az_user where shortname='"+LeadOwner+"')");
	
	while(memberid.next())
	ExpectedResult=memberid.getInt(1);
	assertEquals(ActualResult, ExpectedResult);
}

@Test()
public void Scenerio_6_CallCenter() throws InterruptedException, SQLException
{
	//Asignment Scenerio 6// 
	
	test=extent.createTest("Scenerio_6_CallCenter");
	login(3);
	driver.get("http://arabretail.crmnext.com/g6/app/crmnextobject/RunFlow/Lead?x=wmlptkyqwxpv4bxdnz3cm5b2aqzb5nwqd3ffuxvaqmx8rt2232ef6l5c5pum7qnq6ek3vb5sseahgknkdx6hz4cfcnpf4fl6darftztuysjavwb6sr5a");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	LeadLayout l2= new LeadLayout(driver);
	l2.SelectProduct(data.getRow(3).getCell(3).getStringCellValue());
	l2.EnterMobile(data.getRow(3).getCell(4).getStringCellValue());
	l2.EnterEmail(data.getRow(3).getCell(5).getStringCellValue());
	l2.SelectCurrency(data.getRow(3).getCell(6).getStringCellValue());
	l2.EnterAmount(data.getRow(3).getCell(7).getStringCellValue());
	l2.SelectSalutation(data.getRow(3).getCell(8).getStringCellValue());
	l2.EnterName(data.getRow(3).getCell(9).getStringCellValue());
	l2.SelectVip(data.getRow(3).getCell(10).getStringCellValue());
	l2.SelectPreferredChannel(data.getRow(3).getCell(11).getStringCellValue());
	l2.EnterComments(data.getRow(3).getCell(15).getStringCellValue());	
	l2.CliclSave();
	l2.ClickToggleButton();
	LeadOwner=l2.GetLeadOwner();
	test.info(LeadOwner);
	ResultSet Owner=stmt.executeQuery("select userid from az_user where shortname='"+LeadOwner+"'");
	
	while(Owner.next())
	ActualResult=Owner.getInt(1);
	ResultSet memberid=stmt.executeQuery("select memberid from queuemembers where queueid in (7) and memberid=(select userid from az_user where shortname='"+LeadOwner+"' and appownerid=912)");
	
	while(memberid.next())
	ExpectedResult=memberid.getInt(1);
	assertEquals(ActualResult, ExpectedResult);
	
	
	
}

@Test()
public void Scenerio_14_Branch() throws InterruptedException, SQLException
{
	//Assignment Scenerio no 14//
	test=extent.createTest("Scenerio_14_Branch");
	LeadLayout l2=new LeadLayout(driver);
	login(5);
	driver.get("http://arabretail.crmnext.com/g6/app/crmnextobject/RunFlow/Lead?x=wmlptkyqwxpv4bxdnz3cm5b2aqzb5nwqd3ffuxvaqmx8rt2232ef6l5c5pum7qnq6ek3vb5sseahgknkdx6hz4cfcnpf4fl6darftztuysjavwb6sr5a");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	l2.SelectProduct(data.getRow(5).getCell(3).getStringCellValue());
	l2.EnterMobile(data.getRow(5).getCell(4).getStringCellValue());
	l2.EnterEmail(data.getRow(5).getCell(5).getStringCellValue());
	l2.SelectCurrency(data.getRow(5).getCell(6).getStringCellValue());
	l2.EnterAmount(data.getRow(5).getCell(7).getStringCellValue());
	
	l2.SelectSalutation(data.getRow(5).getCell(8).getStringCellValue());
	l2.EnterName(data.getRow(5).getCell(9).getStringCellValue());
	
	l2.SelectVip(data.getRow(5).getCell(10).getStringCellValue());
	l2.EnterAmount(data.getRow(5).getCell(15).getStringCellValue());
	l2.CliclSave();
	l2.ClickToggleButton();
	LeadOwner=l2.GetLeadOwner();
	test.info(LeadOwner);
	if(stmt.execute("select * from queuemembers where queueid=3 and memberid=(select userid from az_user where shortname='"+LeadOwner+"')"))
	{
		System.out.println("Passed");
	}
	else
	{
		System.out.println("Failed");
	}
	
}

@Test()
public void Scenerio_17_Branch() throws InterruptedException, SQLException
{
	//Assignment Scenerio no 14 and 17// 
	test=extent.createTest("Scenerio_17_Branch");
	login(6);
	LeadLayout l2=new LeadLayout(driver);
	driver.get("http://arabretail.crmnext.com/g6/app/crmnextobject/RunFlow/Lead?x=wmlptkyqwxpv4bxdnz3cm5b2aqzb5nwqd3ffuxvaqmx8rt2232ef6l5c5pum7qnq6ek3vb5sseahgknkdx6hz4cfcnpf4fl6darftztuysjavwb6sr5a");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	l2.SelectProduct(data.getRow(6).getCell(3).getStringCellValue());
	l2.EnterMobile(data.getRow(6).getCell(4).getStringCellValue());
	l2.EnterEmail(data.getRow(6).getCell(5).getStringCellValue());
	
	l2.SelectCurrency(data.getRow(6).getCell(6).getStringCellValue());
	l2.EnterAmount(data.getRow(6).getCell(7).getStringCellValue());
	
	l2.SelectSalutation(data.getRow(6).getCell(8).getStringCellValue());
	l2.EnterName(data.getRow(6).getCell(9).getStringCellValue());
	
	l2.SelectVip(data.getRow(6).getCell(10).getStringCellValue());
	l2.SelectPreferredChannel(data.getRow(6).getCell(11).getStringCellValue());
	
	l2.EnterPreferredBranch().sendKeys(data.getRow(6).getCell(14).getStringCellValue());
	Thread.sleep(2000);
	l2.EnterPreferredBranch().sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(1000);
	l2.EnterPreferredBranch().sendKeys(Keys.ENTER);
	
	l2.EnterComments(data.getRow(6).getCell(15).getStringCellValue());
	l2.CliclSave();
	l2.ClickToggleButton();
	LeadOwner=l2.GetLeadOwner();
	test.info(LeadOwner);
	ResultSet Owner=stmt.executeQuery("select userid from az_user where shortname='"+LeadOwner+"'");
	
	while(Owner.next())
	ActualResult=Owner.getInt(1);
	ResultSet memberid=stmt.executeQuery("select memberid from queuemembers where queueid in (4) and memberid=(select userid from az_user where shortname='"+LeadOwner+"' and appownerid=912)");
	
	while(memberid.next())
	ExpectedResult=memberid.getInt(1);
	assertEquals(ActualResult, ExpectedResult);
	
}

@Test()
public void Scenerio_24_DirectSales() throws InterruptedException, SQLException
{
	//Assignment Scenerio no 24//
	test=extent.createTest("Scenerio_24_DirectSales");
	LeadLayout l2=new LeadLayout(driver);
	login(7);
	driver.get("http://arabretail.crmnext.com/g6/app/crmnextobject/RunFlow/Lead?x=wmlptkyqwxpv4bxdnz3cm5b2aqzb5nwqd3ffuxvaqmx8rt2232ef6l5c5pum7qnq6ek3vb5sseahgknkdx6hz4cfcnpf4fl6darftztuysjavwb6sr5a");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	l2.SelectProduct(data.getRow(7).getCell(3).getStringCellValue());
	l2.EnterMobile(data.getRow(7).getCell(4).getStringCellValue());
	l2.EnterEmail(data.getRow(7).getCell(5).getStringCellValue());
	
	l2.SelectCurrency(data.getRow(7).getCell(6).getStringCellValue());
	l2.EnterAmount(data.getRow(7).getCell(7).getStringCellValue());
	
	l2.SelectSalutation(data.getRow(7).getCell(8).getStringCellValue());
	l2.EnterName(data.getRow(7).getCell(9).getStringCellValue());
	
	l2.SelectVip(data.getRow(7).getCell(10).getStringCellValue());
	l2.EnterComments(data.getRow(7).getCell(15).getStringCellValue());
	l2.CliclSave();
	l2.ClickToggleButton();
	LeadOwner=l2.GetLeadOwner();
	test.info(LeadOwner);
	
	if(stmt.execute("select * from queuemembers where queueid=3 and memberid=(select userid from az_user where shortname='"+LeadOwner+"' and appownerid=912)"))
	{
		System.out.println("Passed");
	}
	else
	{
		System.out.println("Failed");
	}

}

}
