package com.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonBrokenlinkTest {

	public static void main(String[] args) {
     
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size());																		
		ArrayList<String> listlink=new ArrayList<String>();
		for(int i=0;i<links.size();i++)
		{
			String eachlink = links.get(i).getAttribute("href");
			URL url=null;
			int statusCode =0;
			HttpURLConnection httpconn = null;
			try {
			 url=new URL(eachlink);
			 httpconn=(HttpURLConnection)url.openConnection();
			 httpconn.connect();
			if(httpconn.getResponseCode()>=400)
			 {
				 System.out.println(url + " - " + httpconn.getResponseMessage()+"  "+httpconn.getResponseCode());
				 
				} 
			// else {
					//System.out.println(url + " - " + httpconn.getResponseMessage() + " - " + "is a broken link"+"  "+httpconn.getResponseCode());
			//	}
			} catch (Exception e) {
		
				System.out.println(url + " - " + "is a broken link");
			}
				 
			 }
			}
	

}
