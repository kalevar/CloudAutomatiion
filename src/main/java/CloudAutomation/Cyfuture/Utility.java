package CloudAutomation.Cyfuture;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
 
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility
{
	
 public static String getRegisterData(int rowIndex, int cellIndex) throws EncryptedDocumentException, InvalidFormatException, IOException
	{	
		FileInputStream file=new FileInputStream("E:\\CloudAutomation\\Cyfuture\\TestData\\SignUp.xlsx");
        Sheet Log=WorkbookFactory.create(file).getSheet("SignUp");
       String value = Log.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;

	}
	public static String forgotpasswordTestData(int rowIndex, int cellIndex) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream file=new FileInputStream("E:\\CloudAutomation\\Cyfuture\\TestData\\SignUp.xlsx");

		Sheet Log=WorkbookFactory.create(file).getSheet("Forgotpassword");
		String value = Log.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;

	}
	public static String EditProfile(int rowIndex, int cellIndex) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream file=new FileInputStream("E:\\CloudAutomation\\Cyfuture\\TestData\\SignUp.xlsx");

		Sheet Log=WorkbookFactory.create(file).getSheet("UpdateProfile");
		String value = Log.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;


	}
	public static String getTestData(int rowIndex, int cellIndex) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream file=new FileInputStream("E:\\CloudAutomation\\Cyfuture\\TestData\\SignUp.xlsx");
		Sheet Log=WorkbookFactory.create(file).getSheet("Login");
		String value = Log.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;

	}
	public static String GetPaymentamount(int rowIndex, int cellIndex) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream file=new FileInputStream("E:\\CloudAutomation\\Cyfuture\\TestData\\SignUp.xlsx");
		Sheet Log=WorkbookFactory.create(file).getSheet("Payment");
		String value = Log.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;

	}
	public static String getPropertyFileDataR1(String key) throws IOException
	{
		Properties obj=new Properties();
		FileInputStream objfile=new FileInputStream(System.getProperty("user.dir")+"\\URL.properties");
		obj.load(objfile);
		String value1=obj.getProperty("URLR");

		return value1;
	}
public static String getPropertyFileData(String key) throws IOException
{
	Properties obj=new Properties();
	FileInputStream objfile=new FileInputStream(System.getProperty("user.dir")+"\\URL.properties");
	obj.load(objfile);

	String value2=obj.getProperty("URL");
	return value2;
}
public static String getPropertyFileDataR(String key) throws IOException
{
	Properties objR=new Properties();
	FileInputStream objfileR=new FileInputStream(System.getProperty("user.dir")+"\\URL.properties");
	objR.load(objfileR);
	String value3=objR.getProperty("URLLogin");
	return value3;
}
}
