package com.assesment.TestBase;

import org.testng.Assert;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import io.appium.java_client.functions.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;

public class TB_Selenium {

	public WebDriver driver;
	public String PageURL;
	public String PageTitle;
	private WebDriver tabs;

	public void loadPage() throws InterruptedException {
		driver.get(PageURL);
		driver.manage().window().maximize();
		pause(8000);
	}

	public TB_Selenium(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		element.click();
	}

	public void type(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		Assert.assertEquals(element.getAttribute("value"), text);

	}

	
	  public void pause(int duration) throws InterruptedException {
		   Thread.sleep(duration);
		 // WebDriverWait wait=new WebDriverWait(driver, 20); 
		  }
	 

	public void verifyTitle(String Title) {
		Assert.assertEquals(driver.getTitle(), Title);

	}

	public String getPageURL() {
		return PageURL;
	}

	public String getPageTitle() {
		return PageTitle;
	}
	public boolean displayed(WebElement element) {
		if(element.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void verifyText(WebElement ElementPath, String ExpectedText) {
		String ActualText = ElementPath.getText();
		Assert.assertSame(ActualText, ExpectedText, ExpectedText + "Verified");
		/*
		 * if(ActualText==ExpectedText) { //System.out.println("Verified " +ActualText);
		 * org.testng.Assert.assertSame(ActualText, ExpectedText, ExpectedText
		 * +"Verified");
		 * 
		 * }else { org.testng.Assert.fail("Cannot Find " +ActualText); }
		 */

	}
	public void waitTilElementLoad(WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}
	
	public void clickBy(By element) {
		driver.findElement(element).click();
	}
	public String getElementText(WebElement element) {
		String elementText=element.getText();
		return elementText;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public void navigateToUrl(String url) {
		driver.navigate().to(url);
	}
	public void switchToOtherTab(int tabIndex) {
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(tabIndex));
	}
	//String price= lblFirstItemPrice.getAttribute("content");
	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	public String getCurrentUrl(By element,String tag) {
		String price= ((WebElement) element).getAttribute(tag);
		return price;
	}
}
