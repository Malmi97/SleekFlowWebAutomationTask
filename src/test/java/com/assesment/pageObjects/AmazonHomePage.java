package com.assesment.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assesment.TestBase.TB_Selenium;

public class AmazonHomePage extends TB_Selenium{
	
	public AmazonHomePage(WebDriver driver) {
		super(driver);
		this.PageURL="https://www.amazon.com/";
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//input[@placeholder='Search Amazon']") WebElement txtGlobalSearch;
	  
	@FindBy(xpath="//input[@id='nav-search-submit-button']") WebElement btnSearch;
	  
	@FindBy(xpath="(//h2[text()='Model']/following::div[text()='Apple iPhone 13']/parent::a)[1]") WebElement btnModel;
	
	@FindBy(xpath="(//div[@class='a-section']/child::div/child::div[2]/descendant::div[10]/descendant::span[@class='a-price-whole'])[1]") WebElement lblFirstItemPrice;
	
	@FindBy(xpath="(//div[@class='a-section']/child::div/child::div[2]/descendant::a)[1]") WebElement lnkFirstItem;
	
	public void navigateToAmazon(String amazonUrl) throws InterruptedException {
		switchToOtherTab(0);
		loadPage();
		pause(10000);	
	}
	public void searchProduct(String productName) throws InterruptedException {
		type(txtGlobalSearch, productName);
		click(btnSearch);
		pause(5000);	
	}
	
	public int getFirstItemPrice() {
		String price = getElementText(lblFirstItemPrice);	
		return Integer.parseInt(price);
	}

	public void clickOnFirstItem() throws InterruptedException {
		click(lnkFirstItem);
		pause(3000);
	}
	
	public String getProductUrl()  {
		return getCurrentUrl();
	}
	
	public void amazonItemDetails(int itemPrice, String itemUrl) {
		System.out.println("Name of the website : Amazon");
		System.out.println("Name of the product : iPhone 13");
		System.out.println("Price of the product : "+itemPrice);
		System.out.println("Link to the product : "+itemUrl);
	}

}
