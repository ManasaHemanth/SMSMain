package com.admin_Module;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyProfileTest  {
	public static void main(String[] args) throws InterruptedException, Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("//span[text()='My Profile']")).click();
		driver.findElement(By.id("btnEdit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='full_name1']")).clear();

		WebElement initialname = driver.findElement(By.xpath("//input[@id='full_name1']"));
		initialname.sendKeys("Rahul");
		Thread.sleep(2000);
		WebElement a = driver.findElement(By.xpath("//input[@id='i_name1']"));
		a.clear();
		a.sendKeys("Rahul 3");
		WebElement add = driver.findElement(By.xpath("//input[@id='address1']"));
		add.clear();
		add.sendKeys("Delhi");
		WebElement gender = driver.findElement(By.xpath("//select[@name='gender']"));
		Select s=new Select(gender);
		s.selectByVisibleText("Male");
		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.clear();
		phone.sendKeys("111-111-1111");
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		//get the confirmation 
		String Intialname = driver.findElement(By.xpath("//h4[@id='hname']")).getText();
		System.out.println(Intialname);
		//validation
		if(Intialname.equals("Rahul 3")) {
			System.out.println("updated");
		}
		else {
			System.out.println("not updated");

		}
	}
}