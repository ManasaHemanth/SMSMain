package com.admin_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.support.ui.Select;

public class SubjestroutineTest1 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;

		//fetch the common data using property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String url=p.getProperty("URL");
		String un=p.getProperty("UN");
		String password=p.getProperty("pwd");

		//fetch testdata by using Excelsheet
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\testdata45.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		Sheet sh = wb.getSheet("Sheet2");
		int count = sh.getLastRowNum();
		String grade=sh.getRow(1).getCell(0).getStringCellValue();
		String subject=sh.getRow(2).getCell(0).getStringCellValue();
		String teacher=sh.getRow(3).getCell(0).getStringCellValue();

		//launch the browser
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else {
			System.out.println("invalid");
		}
		driver.manage().window().maximize();


		//enter the url
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		//click on subject routine
		driver.findElement(By.xpath("//span[text()='Subject Routing']")).click();
		driver.findElement(By.xpath("//a[text()='Add '] ")).click();

		//store the data into the map

		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=1;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> set:map.entrySet())
		{
			if(set.getKey().contains(subject)) {
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}

		WebElement a = driver.findElement(By.xpath("//select[@id='grade'] "));
		WebElement a1 = driver.findElement(By.xpath("//select[@id='subject']"));
		WebElement a2 = driver.findElement(By.xpath("//select[@id='teacher']"));
		Select s=new Select(a);
		s.selectByVisibleText(grade);

		Select s1=new Select(a1);
		s1.selectByVisibleText(subject);

		Select s2=new Select(a2);
		s2.selectByVisibleText(teacher);

	}



}}
