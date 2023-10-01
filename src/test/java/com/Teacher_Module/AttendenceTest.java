package com.Teacher_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttendenceTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("t1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("//span[text()='Attendance']")).click();
		driver.findElement(By.xpath("//a[text()=' My Attendance']")).click();
		//validation
		String headingtitle=driver.findElement(By.xpath("//h3[text()='My Attendance in this Month']")).getText();
		System.out.println(headingtitle);
		if(headingtitle.contains("My Attendance in this Month")) {
			System.out.println("Attendence page displayed successfully");
		}
		else {
			System.out.println("Attendence page not displayed");
		}
	}

}
