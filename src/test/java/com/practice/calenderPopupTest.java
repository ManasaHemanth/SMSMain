package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenderPopupTest {
	static {
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		int date=31;
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ksrtc.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[.='"+date+"']")).click();
		

	}

}
