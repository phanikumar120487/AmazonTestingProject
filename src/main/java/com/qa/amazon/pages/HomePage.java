package com.qa.amazon.pages;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazon.basepage.BasePage;
import com.qa.amazon.utils.ElementUtil;

public class HomePage extends BasePage 
{
WebDriver driver;
LoginPage loginpage;
ElementUtil elementutil;

public HomePage(WebDriver driver)
{
	this.driver=driver;
	elementutil=new ElementUtil(this.driver);
}
By Account_home=By.id("nav-link-accountList");
By YourAccount=By.linkText("Your Account");
By YourOrders=By.linkText("Your Orders");
By WishList=By.linkText("Your Wish List");
By PrimeMembership=By.linkText("Your Prime Membership");
By PrimeVideo=By.linkText("Your Prime Video");
By SignOut=By.linkText("Sign Out");
By Fresh=By.linkText("Fresh");
By AmazonPay=By.linkText("Amazon Pay");
By SearchInput=By.xpath("//input[@id='twotabsearchtextbox']");
By Search_Click=By.xpath("//span[@id='nav-search-submit-text']");
By LogoName=By.xpath("//a[@class='nav-logo-link']");
By LanguageSelector=By.xpath("//a[@class='nav-a nav-a-2 icp-link-style-2']");

public String doGetHomepageTitle()
{
	return elementutil.doGetTitle();
}
public String doGetAccountName()
{
	return elementutil.doGetText(Account_home);
}
public String doGetLogoName()
{
	return elementutil.doGetText(LogoName);
	
}

}
