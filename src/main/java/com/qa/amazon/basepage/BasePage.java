package com.qa.amazon.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.amazon.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage 
{
    WebDriver driver;
	public ElementUtil elementutil;
	public Properties prop;
	 
	public WebDriver launchdriver(Properties prop)
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("safari"))
		{
			WebDriverManager.getInstance(SafariDriver.class).setup();
            driver=new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}
	public Properties launchProperties()
	{
		prop=new Properties();
		try {
			FileInputStream ip = new FileInputStream("/Users/phanikumar/eclipse-workspace/AmazonAutomationProject/src/main/java/com/qa/amazon/configprop/configproperties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

		
	}

}
