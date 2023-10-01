package com.Teacher_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyPettyCashRTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("t1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("//span[text()='My Petty Cash']")).click();
		driver.findElement(By.xpath("//a[text()='Add ']")).click();
		driver.findElement(By.xpath("//input[@name='_desc[]']")).sendKeys("Teacher Salary");
		driver.findElement(By.xpath("//input[@name='amount[]']")).sendKeys("25000");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		//validate
		String confirmationpage=driver.findElement(By.xpath("//strong[text()='Success!']")).getText();
		System.out.println();
		if(confirmationpage.contains("confirmationpage")) {
			System.out.println("petty cash amount is added");
		}
		else {
			System.out.println("petty cash amount is added");
		}
		
		
		

	}

}
