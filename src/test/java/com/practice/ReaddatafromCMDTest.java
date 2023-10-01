package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReaddatafromCMDTest {
	@Test
  
	public void readCMD() throws InterruptedException {
		String Browser =System.getProperty("browser");
		String url=System.getProperty("URL");
		String un=System.getProperty("UN");
		String password=System.getProperty("pwd");
		
		System.out.println(Browser);
		System.out.println(url);
		System.out.println(un);
		System.out.println(password);
		
		//launch the browser
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	     Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("btnSubmit")).click();
	}

}
