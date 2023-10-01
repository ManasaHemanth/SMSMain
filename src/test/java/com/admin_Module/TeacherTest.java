package com.admin_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TeacherTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("//span[text()='Teacher']")).click();
		driver.findElement(By.xpath("//a[text()=' Add Teacher']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='index_number']")).sendKeys("191");
		driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys("RahulRaj");
		driver.findElement(By.xpath("//input[@id='i_name']")).sendKeys("Rahul_1");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Bangalore");
		WebElement gender = driver.findElement(By.xpath("//select[@id='gender']"));
		gender.click();
		Select s=new Select(gender);
		s.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("123-456-7821");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcd@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@style='margin-top:7px;' and @name='fileToUpload']")).sendKeys("C:\\Users\\Aditya Kumar\\Downloads\\img.doc.jpeg");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

	}

}
