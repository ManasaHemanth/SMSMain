package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OlympicmedalTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/");
		driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
		//WebElement olympicgames = driver.findElement(By.xpath("//a[@id='menu-olympic-games']"));
		//Actions a=new Actions(driver);
		//a.moveToElement(olympicgames).perform();
		driver.findElement(By.xpath("//a[@href='https://olympics.com/en/olympic-games/tokyo-2020']")).click();
		driver.findElement(By.xpath("//p[text()='See table']")).click();
		
		

	}

}
