package com.qa.amazon.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.amazon.basepage.BasePage;

public class ElementUtil extends BasePage {
	WebDriver driver;
	Actions action;
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
		action=new Actions(this.driver);
	}
	public WebElement waitForElementPresent(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
		
	}
	
	public String getTitlePresent(String text,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.titleContains(text));
		return driver.getTitle();
	

	}
	public WebElement getElement(By locator)
	{
		waitForElementPresent(locator,10);
		WebElement element =driver.findElement(locator);
		return element;
	}
	public List<WebElement> getElements(By locator)
	{
		List<WebElement> elements=driver.findElements(locator);
		return elements;
	}
	public void doSendKeys(By locator,String value) 
	{
	getElement(locator).sendKeys(value);
	}
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	public String doGetText(By locator)
	{
		return getElement(locator).getText();
	}
	public boolean doIsDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	public void moveCursor(By locator)
	{
		 //action=new Actions(driver);
		waitForElementPresent(locator,10);

		action.moveToElement(getElement(locator)).build().perform();
	}
	public String doGetTitle()
	{
		return driver.getTitle();
	}
	public void doActionSendKeys(By locator,String text)
	{
    WebElement element=getElement(locator);
    action.sendKeys(element, text).perform();
    
	}
	public void doActionClick(By locator)
	{
	    WebElement element=getElement(locator);
	    action.click(element).perform();

	}

}
