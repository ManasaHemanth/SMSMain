package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadiTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.prokabaddi.com/");
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//span[text()='Standings']")).click();
		//String team = "Patna Pirates";
		List<WebElement> teams = driver.findElements(By.xpath("//div[@class='team-name']"));
		List<WebElement> play = driver.findElements(By.xpath("//div[@class='team-name']/../../../div[@class='table-data matches-play']"));
		List<WebElement> won = driver.findElements(By.xpath("//div[@class='team-name']/../../../div[@class='table-data matches-won']"));
		List<WebElement> lost = driver.findElements(By.xpath("//div[@class='team-name']/../../../div[@class='table-data matches-lost']"));
		List<WebElement> draw = driver.findElements(By.xpath("//div[@class='team-name']/../../../div[@class='table-data matches-draw']"));
		for(int i=0;i<lost.size();i++) {
			String t=teams.get(i).getText();
			String p = play.get(i).getText();
			String w = won.get(i).getText();
			String l = lost.get(i).getText();
			String d = draw.get(i).getText();
			//if(t.equals(team))
			System.out.println(t+"-->"+p+"-"+w+"-"+l+"-"+d);
		}
		driver.close();
	}}