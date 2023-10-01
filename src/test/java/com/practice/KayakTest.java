package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KayakTest {

	public static void main(String[] args) {
		//String MonthandYear="October 2023";
		//int date=20;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.kayak.co.in/");
		driver.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys("Bangalore");
		//driver.findElement(By.xpath("driver.findElement(By.xpath")).click();
		driver.findElement(By.xpath("//input[@aria-label='Flight destination input']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		 //String actual = "//div[text()='"+MonthandYear+"']/ancestor::div[@class='ATGJ-monthWrapper']/descendant::div[@class='"+date+"']";
		 //String nextArrow = "//button[@aria-label='Next month']";
	//	driver.findElement(By.xpath("//div[text()='September 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']/div[@class='onx_-days']/div[@class='Sunday 3 September, 2023'"));
		//driver.findElement(By.xpath("//div[@aria-label='Wednesday 4 October, 2023']")).click();
		// for(;;)
		// {
		//	 try {
				// driver.findElement(By.xpath(actual)).click();
			//	 break;
			// }
			// catch(Exception e)
			// {
				// driver.findElement(By.xpath(nextArrow)).click();
			// }
		// }
	}

}
