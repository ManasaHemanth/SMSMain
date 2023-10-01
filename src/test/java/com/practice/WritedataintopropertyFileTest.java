package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritedataintopropertyFileTest {

	public static void main(String[] args) throws Throwable {
		Properties p=new Properties();
		p.setProperty("username", "admin@gmail.com");
		p.setProperty("password", "12345");
		p.setProperty("url", "http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		p.setProperty("browser", "chrome");
		FileOutputStream fos=new FileOutputStream("./src\\test\\resources\\common.properties");
	p.store(fos, "write data");
	fos.close();
	//reading data
	FileInputStream fis=new FileInputStream("./src\\test\\resources\\common.properties");
	String USERNAME = p.getProperty("username");
	String PASSWORD = p.getProperty("password");
	String URL = p.getProperty("url");
	String BROWSER = p.getProperty("browser");
	
	WebDriver driver =new ChromeDriver();
	driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
	driver.manage().window().maximize();
	driver.findElement(By.id("email")).sendKeys(USERNAME);
	driver.findElement(By.id("password")).sendKeys(PASSWORD);
	driver.findElement(By.id("btnSubmit")).click();

	}

}
