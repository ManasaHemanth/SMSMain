package com.SMS.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SMS.genericutils.WebdriverUtilities;

public class TeacherPreviewPOM_Test extends WebdriverUtilities {
@FindBy(xpath="//input[@name='index_number']")
private WebElement index;

@FindBy(xpath="//input[@name='full_name']")
private WebElement name;

@FindBy(xpath="//input[@name='i_name']")
private WebElement initialName;

@FindBy(xpath="//input[@name='address']")
private WebElement address;

@FindBy(xpath="//select[@name='gender']")
private WebElement gender;

@FindBy(xpath="//input[@name='phone']")
private WebElement phoneEdit;

@FindBy(xpath="//input[@name='email']")
private WebElement emailEdit;

@FindBy(xpath="//input[@name='fileToUpload']")
private WebElement uploadFile;

@FindBy(xpath="//button[@id='btnSubmit']")
private WebElement submitEdit;

public TeacherPreviewPOM_Test(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}


public WebElement getIndex() {
	return index;
}

public WebElement getName() {
	return name;
}

public WebElement getInitialName() {
	return initialName;
}

public WebElement getAddress() {
	return address;
}

public WebElement getGender() {
	return gender;
}

public WebElement getPhoneEdit() {
	return phoneEdit;
}

public WebElement getEmailEdit() {
	return emailEdit;
}

public WebElement getUploadFile() {
	return uploadFile;
}

public WebElement getSubmitEdit() {
	return submitEdit;
}

//businesss liberrairs

public void teacherPreview(HashMap<String, String> hashMap,WebDriver driver,String name1,String name2,String location,String gender1,String no,String mail) 
{
	for(Entry<String, String> set:hashMap.entrySet()) {
		driver.findElement(By.xpath(set.getKey())).clear();
		driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
		selectDropText(gender1, gender);
		submitEdit.click();
		
		
	}
//	index.sendKeys(hashMap);
//	name.sendKeys(name1);
//	initialName.sendKeys(name2);
//	address.sendKeys(location);
//	gender.click();
//	phoneEdit.sendKeys(no);
//	emailEdit.sendKeys(mail);
//	uploadFile.click();
	//submitEdit.click();
//	
	
	
	
	
	
	
	
	
}
}

