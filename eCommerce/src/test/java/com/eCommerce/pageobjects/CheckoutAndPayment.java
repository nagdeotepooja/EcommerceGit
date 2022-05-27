package com.eCommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eCommerce.utilities.SeleniumUtils;
import com.eCommerce.utilities.TestBase;

public class CheckoutAndPayment extends TestBase {


	SeleniumUtils utils = new SeleniumUtils();
	public CheckoutAndPayment()
	{

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h1[@id=\"cart_title\"]")
	WebElement cartSummary;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,\"standard-checkout\")]")
	WebElement cartSummaryCheckout;

	@FindBy(how = How.XPATH, using = "//h1[@class=\"page-heading\"]")
	WebElement addressPageHeader;

	@FindBy(how = How.NAME, using = "processAddress")
	WebElement addressPageCheckout;

	@FindBy(how = How.XPATH, using = "//h1[@class=\"page-heading\"]")
	WebElement shippingPageHeader;

	@FindBy(how = How.XPATH, using = "//input[@name=\"cgv\" and @type=\"checkbox\"]")
	WebElement termsAndServiceCheckbox;

	@FindBy(how = How.XPATH, using = "//button[@name=\"processCarrier\"]")
	WebElement shippingPageCheckout; 

	@FindBy(how = How.XPATH, using = "//h1[@class=\"page-heading\"]")
	WebElement paymentPageHeader;

	@FindBy(how = How.CLASS_NAME, using = "bankwire")
	WebElement paymentMode;

	@FindBy(how = How.XPATH, using = "//h1[@class=\"page-heading\"]")
	WebElement ordersummarypageHeader;

	@FindBy(how = How.CLASS_NAME, using = "page-subheading")
	WebElement selectedPaymentMode;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),\"I confirm my order\")]")
	WebElement iConfirmMyOrderBtn;

	@FindBy(how = How.XPATH, using = "//h1[@class=\"page-heading\"]")
	WebElement orderconfirmpageHeader;

	@FindBy(how = How.XPATH, using = "//strong[text()=\"Your order on My Store is complete.\"]")
	WebElement orderStatus;

	/* public void shippingCartSummaryPageHeader()
		{
			String cartHeader=cartSummary.getText();
			System.out.println("You are on "+cartHeader+" page");
		}*/

	public void cartSummaryDetails()
	{
		String cartHeader=cartSummary.getText();
		System.out.println("You are on "+cartHeader+" page");

		String Totalprice=driver.findElement(By.xpath("//table[@id=\"cart_summary\"]/tbody/tr/td[@data-title=\"Total\"]/child::span[@class=\"price\"]")).getText();
		System.out.println("total price is: "+Totalprice);
		// utils.click(cartSummaryCheckout, 10, "click on proceed to checkout on shopping cart summary page");
	}	

	public void clickOnProceedToCheckout()
	{
		utils.click(cartSummaryCheckout, 10, "click on proceed to checkout on shopping cart summary page");
	}

	public void addressDetails()
	{
		String addressTitle=addressPageHeader.getText();
		System.out.println("Your on "+addressTitle+" page");

		// utils.click(addressPageCheckout, 10, "Click on proceed to checkout of address page");

	}

	public void clickOnAddressPageProceedToCheckout()
	{
		utils.click(addressPageCheckout, 10, "Click on proceed to checkout of address page");
	}

	public void shipingDetails()
	{
		String shippingHeader=shippingPageHeader.getText();
		System.out.println("You are on "+shippingHeader+" page");

		JavascriptExecutor javaScriptExecutor = ((JavascriptExecutor)driver);
		javaScriptExecutor.executeScript("arguments[0].click();",
				termsAndServiceCheckbox);

		//utils.click(termsAndServiceCheckbox, "click on checkbox", 10);
		//utils.click(shippingPageCheckout, 10, "click on proceed to checkout of shipping page");

	}

	public void clickOnShippingPageCheckout()
	{
		utils.click(shippingPageCheckout, 10, "click on proceed to checkout of shipping page");
	}

	public void paymentDetails()
	{
		String paymentpage=paymentPageHeader.getText();
		System.out.println("Your on "+paymentpage+" page");
		utils.click(paymentMode, 10, "select payment method");

	}

	public void orderSummaryDetails()
	{
		String ordersummarypage=ordersummarypageHeader.getText();
		System.out.println("Your on "+ordersummarypage+" page");
		String paymentmode=selectedPaymentMode.getText();
		System.out.println("payment by using "+paymentmode);

		//  utils.click(iConfirmMyOrderBtn, 10, "click on i confirm my order button ");

	}

	public void clickOnIconfirmMyOrderBtn()
	{
		utils.click(iConfirmMyOrderBtn, 10, "click on i confirm my order button ");
	}

	public void orderConfirmationStatus()
	{
		String orderconfirmationpage=orderconfirmpageHeader.getText();
		System.out.println("Your on "+orderconfirmationpage+" page");
		String ordercomplete=orderStatus.getText();
		System.out.println(ordercomplete); 

	}

}
