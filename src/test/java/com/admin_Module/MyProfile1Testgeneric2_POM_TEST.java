package com.admin_Module;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.SMS.ObjectRepository.LP_Page;
import com.SMS.ObjectRepository.LoginPage;
import com.SMS.ObjectRepository.LoginPage1;
import com.SMS.genericutils.Databaseutility;
import com.SMS.genericutils.Excelutility;
import com.SMS.genericutils.FileUtility;
import com.SMS.genericutils.JavaUtility;
import com.SMS.genericutils.WebdriverUtilities;

public class MyProfile1Testgeneric2_POM_TEST {


	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;

		//Databaseutility dlib=new Databaseutility();
		Excelutility elib=new Excelutility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtilities wlib=new WebdriverUtilities();

		String Browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("URL");
		String un=flib.getPropertyKeyValue("UN");
		String password=flib.getPropertyKeyValue("pwd");

		System.out.println(un+" "+password);

		//Launch the browser
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}

		//		driver.manage().window().maximize();
		wlib.maximizetheBrowser(driver);

		//enter the url
		driver.get(url);

		LP_Page lp1=new LP_Page(driver);
		lp1.login(un, password);

		//click on Myprofile link
		driver.findElement(By.xpath("//span[text()='My Profile']")).click();
		driver.findElement(By.id("btnEdit")).click();
		Thread.sleep(2000);
		//enter the mandatory fields
		elib.getMultipleDataFromExcel("MyProfileDetails", 0, 1, driver, jlib);

		WebElement a = driver.findElement(By.xpath("//select[@class='form-control' and @id='gender2']"));
		//	wlib.selectDropText(gender,a);
		driver.findElement(By.xpath("//button[text()='Update']")).click();

		//validation
		String Intialname = driver.findElement(By.xpath("//h4[@id='hname']")).getText();
		System.out.println(Intialname);
		if(Intialname.equals("Ashish_7")) 
		{
			System.out.println("updated");
		}
		else {
			System.out.println("not updated");
		}
		driver.quit();
	}

}
