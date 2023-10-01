package com.practice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenlinofirctcTest {

	public static void main(String[] args) throws MalformedURLException {


		// Navigate to BStackDemo Website
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/");


		// Finding all the available links on webpage
		List<WebElement> links = driver.findElements(By.tagName("//a"));
		System.out.println(links.size());
		ArrayList<String> listlink=new ArrayList<String>();


		// Iterating each link and checking the response status
		for (int i=0;i<=links.size();i++) {
			
			String eachlink = links.get(i).getAttribute("href");
			URL url = new URL(eachlink);
			//try {
				
			//String url = link.getAttribute("href");
			//verifyLink(url);
		}


		driver.quit();
	}


	public static void verifyLink(String url) {
		try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();


			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
		} catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");
		}
	

}

}
