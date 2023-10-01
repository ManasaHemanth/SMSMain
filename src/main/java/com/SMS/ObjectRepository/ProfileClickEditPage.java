package com.SMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileClickEditPage{
@FindBy(id="btnEdit")
private WebElement edit;

public ProfileClickEditPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getEdit() {
	return edit;
}
public void Editpage() {
	edit.click();
}
}

