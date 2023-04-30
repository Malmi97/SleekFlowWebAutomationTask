package com.assesment.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assesment.TestBase.TB_Selenium;

public class EbayHomePage extends TB_Selenium{
	
	public EbayHomePage(WebDriver driver) {
		super(driver);
		this.PageURL="https://www.ebay.com/";
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//input[@placeholder='Search for anything']") WebElement txtGlobalSearch;
	  
	@FindBy(xpath="//input[@value='Search']") WebElement btnSearch;
	  
	@FindBy(xpath="(//h2[text()='Model']/following::div[text()='Apple iPhone 13']/parent::a)[1]") WebElement btnModel;
	
	@FindBy(xpath="//form[@name='viactiondetails']/descendant::span[@itemprop='price']") WebElement lblFirstItemPrice;
		
	@FindBy(xpath="//ul[@class='srp-results srp-list clearfix']/child::li[2]/descendant::div[@class='s-item__info clearfix']/child::a") WebElement lnkFirstItem;
	
	public void navigateToEbay(String ebayUrl) throws InterruptedException {
		loadPage();
		pause(10000);	
	}
	public void searchProduct(String productName) throws InterruptedException {
		type(txtGlobalSearch, productName);
		click(btnSearch);
		pause(5000);	
	}
	
	public void selectModel() throws InterruptedException {
		click(btnModel);
		pause(2000);	
	}
	
	public int getFirstItemPrice(String tag) {
		switchToOtherTab(1);
		//Float price= Float.parseFloat(lblFirstItemPrice.getAttribute("content"));
		Float price= Float.parseFloat(getAttributeValue(lblFirstItemPrice, tag));
		
		return Math.round(price);
	}

	public void clickOnFirstItem() throws InterruptedException {
		click(lnkFirstItem);
		pause(2000);
	}
	
	public String getProductUrl()  {
		return getCurrentUrl();
	}
	
	public void ebayItemDetails(int itemPrice, String itemUrl) {
		System.out.println("Name of the website : Ebay");
		System.out.println("Name of the product : iPhone 13");
		System.out.println("Price of the product : "+itemPrice);
		System.out.println("Link to the product : "+itemUrl);
	}

}
