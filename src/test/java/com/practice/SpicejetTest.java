package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpicejetTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Delhi']")).click();
		//driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		String month="October";
		String year="2023";
		String date="4";
		String returnmonth="January";
		String returnyear="2024";
		String returndate="4";
		driver.findElement(By.xpath("//div[text()='"+month+" 'and text()='"+year+"']/../..//div[@data-testid='undefined-calendar-day-"+date+"']/div")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")).click();
		driver.findElement(By.xpath("//div[text()='"+returnmonth+" 'and text()='"+returnyear+"']/../../../..//div[@data-focusable='"+returndate+"']")).click();
		
	}

}
