package com.SMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	
@FindBy(name = "email")
private WebElement user;

@FindBy(name = "password")
private WebElement pw;

@FindBy(id = "btnSubmit")
private WebElement btnSubmit;

public LoginPage1(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getUser() {
	return user;
}

public WebElement getPw() {
	return pw;
}

public WebElement getBtnSubmit() {
	return btnSubmit;
}

public void loginMethod(String username,String password) {
	user.sendKeys(username);
	pw.sendKeys(password);
	btnSubmit.click();
}


}