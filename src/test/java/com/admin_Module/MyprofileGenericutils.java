package com.admin_Module;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SMS.genericutils.Databaseutility;
import com.SMS.genericutils.Excelutility;
import com.SMS.genericutils.FileUtility;
import com.SMS.genericutils.JavaUtility;
import com.SMS.genericutils.WebdriverUtilities;
import com.mysql.jdbc.Driver;

public class MyprofileGenericutils {

	public static void main(String[] args) throws Throwable {
		Databaseutility dlib=new Databaseutility();
		Excelutility elib=new Excelutility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtilities wlib=new WebdriverUtilities();
		
		//read data from property file
		String BROWSER=flib.getPropertyKeyValue("browser");
		String URL=flib.getPropertyKeyValue("url");
		String USERNAME=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("pwd");
		//launch the browser
		WebDriver driver=new ChromeDriver();
		wlib.maximizetheBrowser(driver);
		driver.get(URL);

	}
}
