package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SMS.genericutils.WebdriverUtilities;

public class PageLoad_Test extends WebdriverUtilities{
	 

	public static void main(String[] args) {
		 WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		

}
}