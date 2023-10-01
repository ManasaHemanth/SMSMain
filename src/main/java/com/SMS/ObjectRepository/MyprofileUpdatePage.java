package com.SMS.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SMS.genericutils.WebdriverUtilities;

public class MyprofileUpdatePage extends WebdriverUtilities
{
	@FindBy(xpath="//input[@class='form-control' and @id='full_name1' ] ")
	private WebElement namePage;

	@FindBy(xpath="//input[@id='i_name1']")
	private WebElement initialname;

	@FindBy(xpath="//input[@id='address1']")
	private WebElement Address;

	@FindBy(xpath="//select[@name='gender']")
	private WebElement gender;

	@FindBy(xpath="//input[@id='phone1']")
	private WebElement phone;

	@FindBy(xpath="//button[text()='Update']")
	private WebElement button;

	public WebElement getNamePage() {
		return namePage;
	}

	public WebElement getInitialname() {
		return initialname;
	}

	public WebElement getAddress() {
		return Address;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getButton() {
		return button;
	}
	//business liberaries
	public void ProfileDetails(HashMap<String, String> map,WebDriver driver,String gen) 
	{

		for(Entry<String, String> set:map.entrySet()) 
		{
			driver.findElement(By.name(set.getKey())).clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());

			//		selectDropText(gen,gender );
			//		button.click();
		}
		selectDropText(gen,gender );
		button.click();
	}
}





//WebElement a = driver.findElement(By.xpath("//select[@id='gender2']"));





