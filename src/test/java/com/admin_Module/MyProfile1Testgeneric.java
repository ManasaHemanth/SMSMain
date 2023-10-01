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

import com.SMS.genericutils.Databaseutility;
import com.SMS.genericutils.Excelutility;
import com.SMS.genericutils.FileUtility;
import com.SMS.genericutils.JavaUtility;
import com.SMS.genericutils.WebdriverUtilities;

public class MyProfile1Testgeneric {
	

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		//Databaseutility dlib=new Databaseutility();
		Excelutility elib=new Excelutility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtilities wlib=new WebdriverUtilities();
		//fetch the common data from property file 
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		Properties p=new Properties();
//		p.load(fis);
		String Browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("URL");
		String un=flib.getPropertyKeyValue("UN");
		String password=flib.getPropertyKeyValue("pwd");
		
		//read the data from Excel sheet
//		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\testdata45.xlsx");
//		Workbook wb=WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet("MY profie data");
		int count = elib.getrowCount("MyProfileDetails");
        // String Gender = sh.getRow(1).getCell(3).getStringCellValue();
		String gender = elib.readExcelData("MyProfileDetails", 1, 3);
	
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
		Thread.sleep(2000);
		
		//enter Valid un and pw
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//click on Myprofile link
		driver.findElement(By.xpath("//span[text()='My Profile']")).click();
		driver.findElement(By.id("btnEdit")).click();
		Thread.sleep(2000);
		//enter the mandatory fields
		elib.getMultipleDataFromExcel("MyProfileDetails", 0, 1, driver, jlib);
//				HashMap<String,String> map=new HashMap<String,String>(); //empty map
//				for(int i=1;i<=count;i++) {
//					String key=sh.getRow(i).getCell(0).getStringCellValue();
//					String value=sh.getRow(i).getCell(1).getStringCellValue();
//					map.put(key, value);
//				}
//				for(Entry<String, String> set:map.entrySet()) 
//				{
//					driver.findElement(By.name(set.getKey())).clear();
//						driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//				}
				
		WebElement a = driver.findElement(By.xpath("//select[@class='form-control' and @id='gender2']"));
		wlib.selectDropText(gender, a);
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		//wlib.selectDropDown
		//Select s=new Select(a);
		//s.selectByVisibleText("");
		//driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		

		
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
