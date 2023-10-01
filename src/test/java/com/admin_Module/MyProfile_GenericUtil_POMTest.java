package com.admin_Module;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SMS.ObjectRepository.Homepage;
import com.SMS.ObjectRepository.LP_Page;
import com.SMS.ObjectRepository.MyprofileUpdatePage;
import com.SMS.ObjectRepository.ProfileClickEditPage;
import com.SMS.genericutils.BaseClass;
import com.SMS.genericutils.Excelutility;
import com.SMS.genericutils.FileUtility;
import com.SMS.genericutils.JavaUtility;
import com.SMS.genericutils.WebdriverUtilities;

public class MyProfile_GenericUtil_POMTest extends BaseClass {

	@Test
	public void profileTest() throws Throwable
	{
		//Creating object of every utility classes

		Excelutility elib=new Excelutility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtilities wlib=new WebdriverUtilities();
		//fetching data from properties file

		WebDriver driver=new ChromeDriver();
		String Browser=flib.getPropertyKeyValue("browser");
        String URL=flib.getPropertyKeyValue("URL");
		String USERNAME=flib.getPropertyKeyValue("UN");
		String PASSWORD=flib.getPropertyKeyValue("pwd");
		//
		String fullName = elib.readExcelData("MyProfileDetails", 1, 1);
		String name =  elib.readExcelData("MyProfileDetails", 2, 1);	
		String address = elib.readExcelData("MyProfileDetails", 3, 1);
		String phone = elib.readExcelData("MyProfileDetails", 4, 1);
		
		//int count = elib.getrowCount("MyProfile");
		String  gender= elib.readExcelData("MyProfileDetails", 1, 3);
		
		
		//WebDriver driver=new ChromeDriver();
		wlib.maximizetheBrowser(driver);
		driver.get(URL);
		//	wlib.implicitlyWait(driver);
		LP_Page lp = new LP_Page(driver);
		lp.getEmailEdt().sendKeys(USERNAME);
		lp.getPwdEdt().sendKeys(PASSWORD);
		lp.getSubmitBtn().click();

		//	driver.findElement(By.xpath("//span[text()='My Profile']")).click();
		//	driver.findElement(By.id("btnEdit")).click();

		//click on my profilePage
		Homepage hp=new Homepage(driver);
		hp.ClickOnProfilePage();
		ProfileClickEditPage mfp=new ProfileClickEditPage(driver);
		mfp.Editpage();

		//enter the details 
		
		 MyprofileUpdatePage update = new MyprofileUpdatePage();
		 update.getNamePage().sendKeys(fullName);
		 update.getInitialname().sendKeys(name);
		 update.getAddress().sendKeys(address);
		 update.getPhone().sendKeys(phone);
		 wlib.selectDropText(gender, update.getGender());
		 update.getButton().click();
//		MyprofileUpdatePage mpu=new MyprofileUpdatePage();
//		mpu.ProfileDetails(elib.getMultipleDataFromExcel("MyProfileDetails", 0, 1, driver, jlib),driver,elib.readExcelData("MyProfileDetails", 1, 3));
//		driver.quit();

	}

}
