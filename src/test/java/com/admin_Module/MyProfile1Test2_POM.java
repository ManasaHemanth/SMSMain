package com.admin_Module;

import java.io.FileInputStream;
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

import com.SMS.ObjectRepository.Homepage;
import com.SMS.ObjectRepository.LoginPage;
import com.SMS.ObjectRepository.MyprofileUpdatePage;
import com.SMS.ObjectRepository.ProfileClickEditPage;
import com.SMS.genericutils.FileUtility;

public class MyProfile1Test2_POM {
	

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		//fetch the common data from property file 
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String Browser=p.getProperty("browser");
		String url=p.getProperty("URL");
		String un=p.getProperty("UN");
		String password=p.getProperty("pwd");
		
		//read the data from Excel sheet
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\testscript.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("MyProfileDetails");
		int count = sh.getLastRowNum();
		String Gender = sh.getRow(1).getCell(3).getStringCellValue();
		
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
		driver.manage().window().maximize();
		
		//enter the url
		driver.get(url);
		//Thread.sleep(2000);
		
		//enter Valid un and pw
		
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(un);
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		//driver.findElement(By.xpath("//button[text()='Submit']")).click();
		LoginPage lp=new LoginPage(driver);
		lp.putLogin(un, password);
		
		//click on Myprofile link
		//driver.findElement(By.xpath("//span[text()='My Profile']")).click();
		Homepage hp=new Homepage(driver);
		hp.ClickOnProfilePage();
		//driver.findElement(By.id("btnEdit")).click();
		ProfileClickEditPage pce=new ProfileClickEditPage(driver);
		pce.Editpage();
		
		//enter the mandatory fields
		HashMap<String,String> map=new HashMap<String,String>(); //empty map
				for(int i=1;i<=count;i++) {
					String key=sh.getRow(i).getCell(0).getStringCellValue();
					String value=sh.getRow(i).getCell(1).getStringCellValue();
					map.put(key, value);
				}
				for(Entry<String, String> set:map.entrySet()) 
				{	
					driver.findElement(By.name(set.getKey())).clear();
						driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
				
		WebElement a = driver.findElement(By.xpath("//select[@id='gender2']"));
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		Select s=new Select(a);
		s.selectByVisibleText(Gender);
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
		MyprofileUpdatePage mfp	=new MyprofileUpdatePage();
		mfp.ProfileDetails(map, driver, Gender);
	

	}}
