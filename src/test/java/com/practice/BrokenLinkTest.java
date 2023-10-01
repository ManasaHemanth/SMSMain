package com.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8888/");
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		List<WebElement> listlinks = driver.findElements(By.xpath("//a"));
		System.out.println(listlinks.size());
		ArrayList<String> link=new ArrayList<String>();
		
		for(int i=0;i<listlinks.size();i++) {
		     String eachlink = listlinks.get(i).getAttribute("href");
		     URL url = null;
		     HttpURLConnection httpconn=null;
		     int statusCode=500;
		     try {
		    	 url=new URL(eachlink);
		    	 HttpURLConnection httpConn=(HttpURLConnection)url.openConnection();
		    	 if(httpconn.getResponseCode()>=400) 
		    	 {
		    		 System.out.println(url+"    "+httpconn.getResponseCode());
		    		 link.add(eachlink);
		    		// System.out.println(eachlink);
		    	 }
		     }
		     catch(Exception e)
		     {
		    	 link.add(eachlink+"----->"     +statusCode);
		    	 
		     }
		     System.out.println(eachlink+"----->"       +statusCode);
		}

	}

}
