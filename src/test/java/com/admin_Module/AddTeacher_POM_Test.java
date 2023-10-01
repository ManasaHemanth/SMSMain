package com.admin_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SMS.ObjectRepository.Homepage;
import com.SMS.ObjectRepository.LP_Page;
import com.SMS.ObjectRepository.TeacherPreviewPOM_Test;
import com.SMS.genericutils.BaseClass;
import com.SMS.genericutils.Excelutility;
import com.SMS.genericutils.FileUtility;
import com.SMS.genericutils.JavaUtility;
import com.SMS.genericutils.WebdriverUtilities;

public class AddTeacher_POM_Test extends BaseClass {
	@Test
	
	public void addTeacherTest() throws Throwable {
		
	
	Excelutility elib=new Excelutility();
	FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	WebdriverUtilities wlib=new WebdriverUtilities();
	
	//fetching the data from property file
	
	
WebDriver driver=new ChromeDriver();
wlib.maximizetheBrowser(driver);
String Browser = flib.getPropertyKeyValue("browser");
String url = flib.getPropertyKeyValue("URL");
String username = flib.getPropertyKeyValue("UN");
String password = flib.getPropertyKeyValue("pwd");

driver.get(url);


//login the application 
LP_Page l=new LP_Page(driver);
l.login(username, password);

//click on the teacher componenet
Homepage h=new Homepage(driver) ;
h.Clickteacher();
h.ClickAddTeacher();

//enter the mandatory details
TeacherPreviewPOM_Test tp=new TeacherPreviewPOM_Test(driver);






}}