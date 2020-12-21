package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

public ReadConfig()
{

File configfile=new File("./Configuration/config.properties");

	try 
	{
	prop=new Properties();
	FileInputStream FIS = new FileInputStream(configfile);
	prop.load(FIS);
	} 
	catch (FileNotFoundException e) 
	{
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

Properties prop;
public String GetUrl()
{
	String URL=prop.getProperty("url");
	return URL;
}

public String Country()
{
	String Country=prop.getProperty("Country");
	return Country;
}

public String DBConnection()
{
	String ConnectionString=prop.getProperty("DBconnection");
	return ConnectionString;
}

public String DbUserName()
{
	String UserName=prop.getProperty("DbUserName");
	return UserName;
}

public String DbUPassword()
{
	String Password=prop.getProperty("DbPassword");
	return Password;
}

public String ExecutedBy()
{
	String ExecutedBy=prop.getProperty("TesterName");
	return ExecutedBy;
}

}


