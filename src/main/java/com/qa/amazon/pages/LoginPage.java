package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.amazon.basepage.BasePage;
import com.qa.amazon.utils.ElementUtil;

public class LoginPage extends BasePage {
    WebDriver driver;
    ElementUtil elementutil;
    public LoginPage(WebDriver driver)
    {
    	this.driver=driver;
    	elementutil=new ElementUtil(this.driver);
    }
	By Account=By.xpath("//span[@class='nav-line-2 nav-long-width']");
	By Signin_one = By.xpath("(//span[@class='nav-action-inner'][contains(text(),'Sign in')])[1]");
	By email = By.xpath("//input[@type='email']");
	By continue_click = By.xpath("//input[@id='continue']");
	By password = By.xpath("//input[@type='password']");
	By Login = By.xpath("//input[@id='signInSubmit']");
	
	public String doGetLoginPageTitle()
	{
		return elementutil.doGetTitle();
		
	}
	public HomePage doSignin(String username,String password)
	{
		elementutil.moveCursor(Account);
		elementutil.doClick(Signin_one);
		elementutil.doSendKeys(email,username);
		elementutil.doClick(continue_click);
		elementutil.doSendKeys(this.password, password);
		elementutil.doClick(Login);
		return new HomePage(driver);
		
	}
	public String doGetHomePageTitle()
	{
		return elementutil.doGetTitle();
	}
	

}
