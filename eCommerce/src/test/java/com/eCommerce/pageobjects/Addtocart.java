package com.eCommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.eCommerce.utilities.SeleniumUtils;
import com.eCommerce.utilities.TestBase;

public class Addtocart extends TestBase {
	
	
	SeleniumUtils utils = new SeleniumUtils();
	
	public Addtocart()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//iframe[contains(@id,\"fancybox-frame\")]")
	WebElement AdddtocartFrame;
	
	@FindBy(how = How.XPATH, using = "//a[@class=\"btn btn-default button-plus product_quantity_up\"]")
	WebElement qtyButton;
	
	@FindBy(how = How.XPATH, using = "//select[@id=\"group_1\"]")
	WebElement selectSize;
	
	@FindBy(how = How.XPATH, using = "//button[@name=\"Submit\"]//child::span[text()=\"Add to cart\"]")
	WebElement AddtocartBtn;	
	
	@FindBy(how = How.XPATH, using = "//h2[contains(.,\"Product successfully added to your shopping cart\")]")
	WebElement confirmMsg;
	
	@FindBy (how = How.XPATH, using = "//a[@title=\"Proceed to checkout\"]")
	WebElement cartCheckout;
	
	@FindBy(how = How.XPATH, using = "//h1[text()=\"Printed Dress\"]")
	WebElement productName;
	
	@FindBy(how = How.XPATH, using = "//div[@id='short_description_content']//child::p[contains(text(),'Printed evening dress with straight sleeves')]")
	WebElement productDescription;
	
	public void viewProductDetails()
	{
		String productname=productName.getText();
		System.out.println("Product Name "+productName);
		String productdesc=productDescription.getText();
		System.out.println("Product Description "+productdesc );

	}
	
/*	public void viewProductDesc()
	{
		String productdesc=productDescription.getText();
		System.out.println("Product Description "+productdesc );
	}*/
			
	
	public void switchToFrame()
	{
		utils.switchToFrameByWebElement(AdddtocartFrame, 30, "switch to frame");
		
	}
	public void selectQuantity()
	{
		utils.click(qtyButton, 10, "click on qty");
	}
	public void selectSize()
	{
	    Select sel = new Select(selectSize);
		sel.selectByValue("2");
		//utils.selectByValue(selectSize, "2", 10, "size is M");
	}
	public void clickOnAddToCart()
	{
		utils.click(AddtocartBtn, 30, "click on add to cart");
		driver.switchTo().defaultContent();
		
	}
	
	public void addToCartConfirmationPopUp()
	{
		String ConfirmationPopUp = confirmMsg.getText();
		Assert.assertEquals(ConfirmationPopUp, "Product successfully added to your shopping cart");
		System.out.println(ConfirmationPopUp);
		
	}
	
	public void clickOnProceedToCheckoutBtn()
	{
		
		utils.click(cartCheckout, 10, "click on proceed to checkout");
	}
   
	
}
