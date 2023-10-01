package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraTest {

	public static void main(String[] args) throws Throwable {
		String expected="TY_PROJ_sdet0050";
		Connection con = null;
		try {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expected);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Deepak HR");
		WebElement element = driver.findElement(By.xpath("//select[@name='status']"));
		Select s=new Select(element);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		
		//register the database
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
	    con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query="select* from project;";
		 ResultSet result = state.executeQuery(query);
		 boolean flag=false;
		 while(result.next()) {
			 String actual = result.getString(4);
			 if(actual.equalsIgnoreCase(expected)) {
				flag = true;
				break;
			 }
		 }
		 if(flag==true) {
			 System.out.println("project is created");
		 }
		else {
	System.out.println("project is not created");
}

	}
catch(Exception e) {
	
}
		finally {
			
			con.close();
		}
}}
