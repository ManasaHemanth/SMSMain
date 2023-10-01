package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboCalenderTest {

	public static void main(String[] args) {
		String MonthAndYear="December 2023";
		int date=21;
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
	//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String actual = "//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
        String nextArrow = "//span[@aria-label='Next Month']";
        for(;;) {
        	try {
        		driver.findElement(By.xpath(actual)).click();
        		break;
        		}
        	catch(Exception e)
        	{
        		driver.findElement(By.xpath(nextArrow)).click();
        	}
        	}
        	driver.findElement(By.xpath("//span[text()='Done']")).click();                  
        	//driver.findElement(By.xpath("//a[@class='sc-12foipm-77 hhOMGd']")).click();   
        
	}

}
