package ArabBank.LeadsSanity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pages.LoginPage;
import Utils.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static XSSFSheet data;
	Connection con;
	Statement stmt;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	 ReadConfig config=new ReadConfig();
	 
	public WebDriver Browser()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pranav Chavan\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;
	}
	public static XSSFSheet ReadTestData() throws IOException
	{
		File TestData=new File(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
		FileInputStream fis=new FileInputStream(TestData);
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("TestData");
		return sh;
	}
	@BeforeSuite
	public void DataBaseConnection() throws ClassNotFoundException, SQLException, IOException
	{
		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  

		//step2 create  the connection object  
		 con=DriverManager.getConnection(config.DBConnection(),config.DbUserName(),config.DbUPassword());  

		//step3 create the statement object  
		stmt=con.createStatement();
		//step4 execute query  
		stmt.executeQuery("update BusinessRuleEnforcement set firedoption=0 where keyid=6 and ruletype=3");  
		//while(rs.next())
		//System.out.println(rs.getInt(1));
		//step5 close the connection object 
		System.out.println("Connection started");
		driver=Browser();
		data=ReadTestData();

	}
	
	@AfterSuite
	public void CloseDBConnection() throws SQLException
	{
		stmt.executeQuery("update BusinessRuleEnforcement set firedoption=1 where keyid=6 and ruletype=3");
		con.close();
		driver.quit();
		System.out.println("Connection Closed");
	}
	
	@BeforeTest
	public void Configuration() throws IOException, SQLException
	{
			
	    String CurrentDate=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	    String RepName="Test-Report-"+CurrentDate+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+RepName);
		htmlReporter.config().setDocumentTitle("Arab Bank Palestine");
		htmlReporter.config().setReportName("Leads Assignment Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Executed By", config.ExecutedBy());
		extent.setSystemInfo("Browser", "Chorme");
		extent.setSystemInfo("Country", config.Country());
		
	}
	
	@AfterTest
	public void endConfiguration()
	{
		extent.flush();
	}
	public  String capturescreen(String TestCaseName) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Destination=System.getProperty("user.dir")+ "/Screenshots/"+TestCaseName+".png";
		File dst=new File(Destination);
		FileUtils.copyFile(source,dst);
		return Destination;
	}

	@AfterMethod
	public void onFinish(ITestResult result) throws IOException 
	{
		// methoed to execute after every Test Case
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test Cases Failed is "+result.getName());
			test.log(Status.FAIL, "Error occured is  "+result.getThrowable());
			String path=capturescreen(result.getName());
			test.addScreenCaptureFromPath(path);
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Cases Passed is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test Cases Skiped is "+result.getName());
		}
			
		
	}
	public void login(int rowno) throws InterruptedException
	{
		//Test to Login and Navigate to Lead Home page//
		LoginPage l1=new LoginPage(driver);
		driver.get(config.GetUrl());
		driver.manage().window().maximize();
		l1.Username(data.getRow(rowno).getCell(0).getStringCellValue());
		l1.Password("acid_qa");
		l1.LoginButton();
		l1.LeadHomePage=new Actions(driver);
		l1.Sales=l1.SalesObject();
		l1.LeadHomePage.moveToElement(l1.Sales).build().perform();
		Thread.sleep(2000);
		l1.LeadObject().click();
	}
}

