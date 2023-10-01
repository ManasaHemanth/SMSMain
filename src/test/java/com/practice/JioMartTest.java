package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jiomart.com/");
		WebElement groceries = driver.findElement(By.xpath("//a[text()='Groceries']"));
		Actions a=new Actions(driver);
		a.moveToElement(groceries).perform();
		WebElement fruits = driver.findElement(By.xpath("//a[text()='Fruits & Vegetables']"));
		a.moveToElement(fruits).perform();
		String b = driver.findElement(By.xpath("//ul[@class='header-nav-l3 custom-scrollbar']")).getText();
		System.out.println(b);
		//WebElement dairy = driver.findElement(By.xpath("//a[text()='Dairy & Bakery']"));
		//a.moveToElement(dairy).perform();
		//String c = driver.findElement(By.xpath("//ul[@class='header-nav-l3 custom-scrollbar']")).getText();
		//System.out.println(c);
	}


}


