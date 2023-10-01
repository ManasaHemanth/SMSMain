package com.admin_Module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class MyprofilePage_UsingBaseClass extends BaseClass {

@Test
public void myProfilePage() throws Throwable {
WebDriver driver=new ChromeDriver();
	
	String Browser=flib.getPropertyKeyValue("browser");
	String URL=flib.getPropertyKeyValue("URL");
	String USERNAME=flib.getPropertyKeyValue("UN");
	String PASSWORD=flib.getPropertyKeyValue("pwd");
	
	//WebDriver driver=new ChromeDriver();
	wlib.maximizetheBrowser(driver);
	driver.get(URL);
	//	wlib.implicitlyWait(driver);
	LP_Page lp = new LP_Page(driver);
	lp.getEmailEdt().sendKeys(USERNAME);
	lp.getPwdEdt().sendKeys(PASSWORD);
	lp.getSubmitBtn().click();

	//click on my profilePage
	Homepage hp=new Homepage(driver);
	hp.ClickOnProfilePage();
	ProfileClickEditPage mfp=new ProfileClickEditPage(driver);
	mfp.Editpage();

	//enter the details 
	MyprofileUpdatePage mpu=new MyprofileUpdatePage();
	mpu.ProfileDetails(elib.getMultipleDataFromExcel("MyProfileDetails", 0, 1, driver, jlib),driver,elib.readExcelData("MyProfileDetails", 1, 3));



}

}
