package com.admin_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SubjectRouting {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		Thread.sleep(3000);
		
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		 driver.findElement(By.id("password")).sendKeys("12345");
		 driver.findElement(By.id("btnSubmit")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//span[text()='Subject Routing']")).click();
		 driver.findElement(By.xpath("//a[text()='Add ']")).click();
		 
		 WebElement grade = driver.findElement(By.xpath("//select[@id='grade']"));
		 grade.click();
		 Select s = new Select(grade);
		 s.selectByVisibleText("A+344");
		 
		WebElement sub =  driver.findElement(By.xpath("//select[@id='subject']"));
		sub.click();
		Select s1 = new Select(sub);
		 s1.selectByVisibleText("SQL");
		 
		 WebElement teacher =  driver.findElement(By.xpath("//select[@id='teacher']"));
			sub.click();
			Select s2 = new Select(teacher);
			 s2.selectByVisibleText("mr.david");
			 
		driver.findElement(By.xpath("//input[@placeholder='Enter subject fee']")).sendKeys("4500");
		
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@class='user-image' and @alt='User Image']")).click();
		driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[4]/a/img")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		
		//get the confirmation message
		  String header = driver.findElement(By.xpath("//h4[text()='Information...!']")).getText();
		 System.out.println(header);
		 
		 //validate
		 if(header.contains(" Your information"))
		 {
			 System.out.println(" created");
		 }
		 else
		 {
			 System.out.println(" not created");
		 }
		
		 

	}

}