package com.SMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	//declaration
	@FindBy(xpath="//input[@name='email']")
	private WebElement user;

	@FindBy(xpath="//input[@name='password']")
	private WebElement Passw;

	@FindBy(id = "btnSubmit")
	private WebElement submit;

	//Initialition
public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
 



	public WebElement getuser() {
		return user;
	}



	public WebElement getPassw() {
		return Passw;
	}



	public WebElement getsubmit() {
		return submit;
	}



	//business logic
	public void putLogin(String USER,String PW) {
		user.sendKeys(USER);
		Passw.sendKeys(PW);
		submit.click();
	}
}


