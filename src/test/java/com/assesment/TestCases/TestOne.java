package com.assesment.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assesment.pageObjects.AmazonHomePage;
import com.assesment.pageObjects.EbayHomePage;
import com.assesment.utils.Config;

public class TestOne{
	
	public WebDriver driver;
	Config config;
	EbayHomePage ebay;
	AmazonHomePage amazon;

	@BeforeTest(alwaysRun=true)
	public void setup() {
	
		config=PageFactory.initElements(driver, Config.class);
		driver=config.configure("Chrome");
		ebay=PageFactory.initElements(driver, EbayHomePage.class);
		amazon=PageFactory.initElements(driver, AmazonHomePage.class);
		
	} 
	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		this.driver.quit();
	}

	@Test(description="Verify that can check the price of a product in Ebay and Amazon, and list the details in ascending order",priority=1)
	public void gettingPricesOfGivenProducts() throws InterruptedException, IOException {
		//getting product details from Ebay
		ebay.navigateToEbay("https://www.ebay.com/");
		ebay.searchProduct("iPhone 13");
		ebay.selectModel();
		ebay.clickOnFirstItem();
		int ebayItemPrice=ebay.getFirstItemPrice("content");
		String ebayItemUrl=ebay.getProductUrl();
		
		//getting product details from Amazon
		amazon.navigateToAmazon("https://www.amazon.com/");
		amazon.searchProduct("iPhone 13");
		int amazonItemPrice=amazon.getFirstItemPrice();
		amazon.clickOnFirstItem();
		String amazonItemUrl=ebay.getProductUrl();
		
		//compare the prices and list product details in an ascending order
		if(ebayItemPrice<amazonItemPrice) {
			ebay.ebayItemDetails(ebayItemPrice,ebayItemUrl);
			System.out.println("\n");
			amazon.amazonItemDetails(amazonItemPrice,amazonItemUrl);
		}else {
			amazon.amazonItemDetails(amazonItemPrice,amazonItemUrl);
			System.out.println("\n");
			ebay.ebayItemDetails(ebayItemPrice,ebayItemUrl);
		}
	}
	
}
