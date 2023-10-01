package com.practice;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyfileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String Browser=p.getProperty("browser");
		String URL=p.getProperty("URL");
		String username=p.getProperty("UN");
		String password=p.getProperty("pwd");
		System.out.println(Browser);
		System.out.println(URL);
		System.out.println(username);
		System.out.println(password);
		

	}

}
