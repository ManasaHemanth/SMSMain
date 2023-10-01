package com.admin_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SMS.genericutils.Databaseutility;
import com.SMS.genericutils.Excelutility;
import com.SMS.genericutils.FileUtility;
import com.SMS.genericutils.JavaUtility;
import com.SMS.genericutils.WebdriverUtilities;
import com.mysql.jdbc.Driver;

public class MyprofileTest2 {

	public static void main(String[] args) {
		Databaseutility dlib=new Databaseutility();
		Excelutility elib=new Excelutility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtilities wlib=new WebdriverUtilities();
		//launch the browser
		WebDriver driver=new ChromeDriver();
		wlib.maximizetheBrowser(driver);

	}
}
