package com.SMS.genericutils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * 
 * @author Aditya Kumar
 *
 */

public class WebdriverUtilities
{

	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizetheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */

	public void minimizetheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait until elements gets load
	 * @param driver
	 * @param duration
	 */

	public void implicitlyWait(WebDriver driver,int duration) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * This method will wait until the url of the page get loads
	 * @param driver
	 * @param duration
	 * @param expectedurl
	 */
	public void waituntilUrlLoads(WebDriver driver,int duration,String expectedurl)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration)) ;
		wait.until(ExpectedConditions.urlContains(expectedurl));
	}
	/**
	 * This method will wait until the title of the page get loads
	 * @param driver
	 * @param duration
	 * @param expectedtitles
	 */

	public void waituntilTitle(WebDriver driver,int duration,String expectedtitles) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedtitles));

	}
	/**
	 * This method will wait until the element of the page get loads
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waituntilElementtobeClickable(WebDriver driver,int duration,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will ignore NosuchElementException and continue the exception
	 * @param driver
	 * @param duration
	 */
	public void ignorenosuchElementException(WebDriver driver,int duration) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method will wait until the element to be visible in the page
	 * @param element
	 * @throws Throwable
	 */
	public void CustomeWait(WebElement element) throws Throwable {
		int count=0;
		while(count<20)
		{
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(2000);
				count++;
			}
		}
	}
	/**
	 * This method will be select the dropdown menu button based on value
	 * @param element
	 * @param value
	 */

	public void SelectdropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will be select the dropdown menu button based on visibletext
	 * @param text
	 * @param element
	 */
	public void selectDropText(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will be select the dropdown menu button based on index
	 * @param ele
	 * @param index
	 */
	public void SeelectdropDown(WebElement ele, int index) {
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to mousehover the element
	 * @param driver
	 * @param element
	 */

	public void mousehOver(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * this method is used to drag and drop the element one position to another 
	 * @param src
	 * @param dest
	 * @param driver
	 */
	public void dragandDrop(WebElement src, WebElement dest,WebDriver driver) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	/**
	 *  This method is used to rightclick on the element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions a1=new Actions(driver);
		a1.contextClick();
	}
	/**
	 * This method is used to double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * this method is used to click enter button
	 * @param driver
	 */
	public void clickonEnterKey(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to switch from one frame to another frame
	 * @param driver
	 * @param index
	 */
	public void switvchFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * his method is used to switch from one frame to another frame using id
	 * @param driver
	 * @param id
	 */
	public void SwitchFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * his method is used to switch from one frame to another frame using webelement
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * his method is used to switch to main frame
	 * @param driver
	 */
	public void switchtomainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used accept alert popup
	 * @param driver
	 * @param expectedmsg
	 */
	public void alertPopup(WebDriver driver, String expectedmsg) {
		Alert a = driver.switchTo().alert();
		if(a.getText().equalsIgnoreCase(expectedmsg)) {
			System.out.println("alert msg is verified");
		}
		else {
			System.out.println("alert msg is not verified");

		}
		a.accept();
	}
	/**
	 * This method is used accept dismiss popup
	 * @param driver
	 * @param Expectedmsg
	 */
	public void dismissPouup(WebDriver driver,String Expectedmsg) {
		Alert b = driver.switchTo().alert();
		if(b.getText().equalsIgnoreCase(Expectedmsg)) {
			System.out.println("alert msg is verified");
		}else

		{
			System.out.println("alert msg is not verified");
		}
		b.dismiss();
	}
	/**
	 * this method is used to switch from one window to another based on title
	 * @param driver
	 * @param expectedtitle
	 */
	public void switchWindowBased(WebDriver driver,String expectedtitle)
	{
		Set<String> set = driver.getWindowHandles();
		for(String s:set) {
			driver.switchTo().window(s);
			String title=driver.getTitle();
			if(title.contains(expectedtitle)) {
				break;
			}
		}
	}
	/**
	 * this method is used to switch from one window to another based on url
	 * @param driver
	 * @param expectedurl
	 * @param TakesScreenshot 
	 */
	public void switchwindowbasedonURL(WebDriver driver,String expectedurl, TakesScreenshot TakesScreenshot) {
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> it = s1.iterator();
		while(it.hasNext()) {
			String wid=it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if(url.contains(expectedurl)) {
				break;
			}
		}}
	/**
	 * This method is used to take screenshot whenever the testscripts getting failed
	 * @param driver
	 * @param screenshot
	 * @return
	 */
		public static String screenshotDemo(WebDriver driver,String screenshot) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("./screenshot/"+screenshot+".png");
			try {
				Files.copy(src, dest);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			return screenshot;
}
		/**
		 * This method is used to scroll the particular element
		 * @param driver
		 * @param element
		 */
		public void ScrollToParticularElement(WebDriver driver,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("argument[0].scrollIntoView()", element);
			
		}
		/**
		 * this method is used to release the key
		 * @throws Throwable
		 */
		public void enterkey() throws Throwable {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		}
		/**
		 * this method is used to release the key
		 * @param driver
		 * @throws Throwable
		 */
		public void enterRelease(WebDriver driver) throws Throwable
		{
			Robot r=new Robot();
			r.keyRelease(KeyEvent.VK_ENTER);
			}
		}

