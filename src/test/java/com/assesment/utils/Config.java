package com.assesment.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Config {

public WebDriver driver;
	
	
	//public String ChromeDriverPath="C:\\Users\\Malmi\\Desktop\\FinalProject\\Implementation\\Drivers\\chromedriver.exe";
	public String GeckoDriverPath="C:\\Users\\Malmi\\Desktop\\FinalProject\\Implementation\\Drivers\\geckodriver.exe";
	public String IEDriverPath="C:\\Users\\Malmi\\Desktop\\FinalProject\\Implementation\\Drivers\\IEDriverServer.exe";
	
	public WebDriver configure(String Browser) {
		 String homeDirectory ="user.dir";
	
		if(Browser.equalsIgnoreCase("Chrome")) {
			// System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
			 System.setProperty("webdriver.chrome.driver", System.getProperty(homeDirectory)+"/src/test/resources/drivers/chromedriver.exe");
			 this.driver = new ChromeDriver(); 
			 
		}else if (Browser.equalsIgnoreCase("Firefox")) {
			 System.setProperty("webdriver.gecko.driver", GeckoDriverPath);
			 this.driver = new FirefoxDriver(); 	 
		}else if (Browser.equalsIgnoreCase("IE")) {
			 System.setProperty("webdriver.ie.driver", GeckoDriverPath);
			 this.driver = new InternetExplorerDriver(); 
		}
		
		return this.driver;
	} 
}
