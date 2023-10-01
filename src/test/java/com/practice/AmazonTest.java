package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AmazonTest {

	public static void main(String[] args) {
		String mobile="phones";
		//int p=4799;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@aria-label='See more, Brand']//span[@class='a-expander-prompt'][text()='See more']")).click();
		driver.findElement(By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-none']//span[@class='a-size-base a-color-base'][text()='IKALL']")).click();
		//String price = "//span[@class='//span[@class='a-price-whole']'";
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		}


	}

