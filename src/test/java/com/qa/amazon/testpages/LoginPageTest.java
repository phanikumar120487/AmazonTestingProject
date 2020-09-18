package com.qa.amazon.testpages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.amazon.basepage.BasePage;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.utils.Constantsutil;

public class LoginPageTest {
	LoginPage loginpage;
	BasePage basepage;
	WebDriver driver;
	Properties prop;
	Constantsutil constants;
	
@BeforeTest
public void Setup() 
{
	basepage = new BasePage();
	prop = basepage.launchProperties();
	driver=basepage.launchdriver(prop);
	loginpage = new LoginPage(driver);

	//constants=new Constantsutil();
	
	
}
@Test(priority=1)
public void doVerifyLoginPageTitle()
{
	String title=loginpage.doGetLoginPageTitle();
	System.out.println(title);
	Assert.assertEquals(title,Constantsutil.LoginPageTitile,"LoginPage Title is not matched");
	
}
@Test(priority=2)
public void doVerifyLogin()
{
	loginpage.doSignin(prop.getProperty("username"),prop.getProperty("password"));
}
@Test(priority=3)
public void doVerifyHomePageTitle()
{
	String title_home=loginpage.doGetHomePageTitle();
	System.out.println(title_home);
	Assert.assertEquals(title_home,Constantsutil.HomePageTitle,"LoginPage Title is not matched");

}
@AfterTest
public void tearDown()
{
	driver.quit();
}


}
