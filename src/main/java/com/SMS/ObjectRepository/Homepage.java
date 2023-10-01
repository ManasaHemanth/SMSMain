package com.SMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage
{
@FindBy(xpath="//span[text()='My Profile']")
private WebElement myprofile;

@FindBy(xpath="//span[text()='Teacher']")
private WebElement teacher;

@FindBy(xpath=" //a[text()=' Add Teacher']")
private WebElement editteacher;

@FindBy(xpath="//span[text()='Subject Routing']")
private WebElement subject;

@FindBy(xpath=" //a[text()=' Add Teacher']")
private WebElement addteacher;

public Homepage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
public WebElement getMyprofile() {
	return myprofile;
}
public WebElement getTeacher() {
	return teacher;
}
public WebElement getEditteacher() {
	return editteacher;
}
public WebElement getSubject() {
	return subject;
}

public WebElement getAddteacher() {
	return addteacher;
}
//business layeer
public void ClickOnProfilePage() {
	myprofile.click();
}
	public void Clickteacher() {
	teacher.click();
	}
	public void ClickAddTeacher() {
		addteacher.click();
	}
}
