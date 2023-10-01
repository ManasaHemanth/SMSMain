package com.SMS.genericutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	public Databaseutility dlib=new Databaseutility();
	public Excelutility elib=new Excelutility();
	 public FileUtility flib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebdriverUtilities wlib=new WebdriverUtilities();
	public static WebDriver sdriver;

	public WebDriver driver;

	//connect to db

	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dlib.connectToDB();
		System.out.println("----connect DB------");
	}

	//launch the browser
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable {
		String Browser = flib.getPropertyKeyValue("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("---matched----");
		}
		if(Browser.equalsIgnoreCase("firefox")) {
			driver=new EdgeDriver();
			System.out.println("----notmatched-----");
		}
		System.out.println("launch the browser");
		
		sdriver = driver;
		wlib.maximizetheBrowser(driver);
		}

	// login to the application
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		String url = flib.getPropertyKeyValue("URL");
		String username=flib.getPropertyKeyValue("UN");
		String pw=flib.getPropertyKeyValue("pwd");
		//driver.get(url);
	}

	//signout the application
	@AfterMethod(alwaysRun = true)
	public void configAM() 
	{
		System.out.println("signout");
	}

	//close the browser
	@AfterClass(alwaysRun = true)
	public void configAC() {
		driver.quit();
		System.out.println("close the browser");
	}

	//close the database
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable {
		dlib.closeDB();
	}
}

