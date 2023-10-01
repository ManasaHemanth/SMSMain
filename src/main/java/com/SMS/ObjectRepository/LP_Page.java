package com.SMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LP_Page {

	@FindBy(xpath="//input[@name='email']")
	private WebElement emailEdt;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement pwdEdt;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	public LP_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getPwdEdt() {
		return pwdEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	public void login(String email, String pwd)
	{
		emailEdt.sendKeys(email);
		pwdEdt.sendKeys(pwd);
		submitBtn.click();
	}
}
