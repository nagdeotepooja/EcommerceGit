package com.eCommerce.pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eCommerce.utilities.SeleniumUtils;
import com.eCommerce.utilities.TestBase;

public class MyAccountPage extends TestBase{
	
	
	SeleniumUtils utils = new SeleniumUtils();
	
	
	
	public MyAccountPage()
	{
		
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//h1[@class=\"page-heading\"]")
	WebElement myaccountpage;

	@FindBy(how = How.XPATH, using = "//a[@title=\"Women\"]")
	WebElement womensection;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"subcategory-image\"]//child::a[@title=\"Dresses\"]")
	WebElement subcatdresses;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"subcategory-image\"]//child::a[@title=\"Evening Dresses\"]")
	WebElement subcatevedresses;
	
	@FindBy(how = How.XPATH, using = "//img[@title=\"Printed Dress\"]")
	WebElement Product_img;
	
	@FindBy(how = How.XPATH, using = "//a[@class=\"quick-view\"]")
	WebElement quick_view;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,\"product-container\")]//child::a[@class=\"product-name\"]")
	WebElement listOfProducts;
	
	@Test
	public void getMyAccountPageHeader()
	{
		
		String myAccountPageTitle = driver.getTitle();
		Assert.assertEquals("My account - My Store", myAccountPageTitle);
		
	}
	@Test
	public void selectWomenSection()
	{
		
		utils.click(womensection, 10, "Women  Section");


	}
	
	public void selectDressesSection()
	{

		utils.click(subcatdresses,10, "Subcategory Dresses");

	}
	
	
	
	public void selectEveningDresses()
	{

		 utils.click(subcatevedresses, 10,"Subcategory Evening Dresses");

	}
	
	public void getListOfProducts()
	{
		List<WebElement> productList = driver.findElements(By.xpath("//div[contains(@class,'product-container')]//child::a[@class='product-name']"));
		System.out.println("No of products on page: "+productList.size());
		
		for(WebElement pList : productList)
		{
			System.out.println("Product list: "+pList.getText());
		}

	}
	
	public void selectProduct()
	{
		 
	     utils.moveToElementAndClick(Product_img, quick_view, 20, "move to product image element to quick view element");
	     
	}
	
	
	
}
