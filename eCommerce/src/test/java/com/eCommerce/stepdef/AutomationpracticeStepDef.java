package com.eCommerce.stepdef;

import org.openqa.selenium.WebDriver;

import com.eCommerce.pageobjects.Addtocart;
import com.eCommerce.pageobjects.CheckoutAndPayment;
import com.eCommerce.pageobjects.HomePage;
import com.eCommerce.pageobjects.MyAccountPage;
import com.eCommerce.pageobjects.OrderHistory;
import com.eCommerce.pageobjects.SignIn;
import com.eCommerce.utilities.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationpracticeStepDef extends TestBase{

	HomePage homepage;
	SignIn signin;
	MyAccountPage myaccountpage;
	Addtocart addtocart;
	CheckoutAndPayment checkout;
	OrderHistory orderhistory;
	
	@Given("User navigates to eCommerce site")
	public void user_navigates_to_ecommerce_site() {
		
		TestBase.initialization();
		
		homepage = new HomePage();
		homepage.clickSignInLink();
	}

	@When("User enters Email address {string}")
	public void user_enters_email_address(String emailAdd) {
	    signin = new SignIn();
	    
	    signin.setEmailAddress(emailAdd);
	}

	@When("User enters Password {string}")
	public void user_enters_password(String password) {
	    signin.setPassword(password);
	}

	@When("User click on sign in")
	public void user_click_on_sign_in() {
	    signin.clickSignIn();
	}

	@Then("User navigates to myaccount page")
	public void user_navigates_to_myaccount_page() {
	    signin.verifyMyAccountName();
	}

	@Given("User is on myaccount page")
	public void user_is_on_myaccount_page() {
		
	 myaccountpage = new MyAccountPage();
	 myaccountpage.getMyAccountPageHeader();
		
	}

	@When("User clicks on Women section")
	public void user_clicks_on_women_section() {
		myaccountpage.selectWomenSection();
		
	}

	@When("User clicks on Dresses under subcategories of Women section")
	public void user_clicks_on_dresses_under_subcategories_of_women_section() {
		myaccountpage.selectDressesSection();
	}

	@When("User clicks on Evening Dresses under subcategories of Dresses section")
	public void user_clicks_on_evening_dresses_under_subcategories_of_dresses_section() {
		myaccountpage.selectEveningDresses();
	}

	@Then("User views list of products under Evening Dresses section")
	public void user_views_list_of_products_under_evening_dresses_section() {
		//product information
		myaccountpage.getListOfProducts();
	}

	@Then("User clicks on Quick view link of product")
	public void user_clicks_on_quick_view_link_of_product() {
		
		myaccountpage.selectProduct();
	}

	@Given("User views selected product information")
	public void user_views_selected_product_information() {
		addtocart = new Addtocart();
		addtocart.switchToFrame();
		addtocart.viewProductDetails();
	}

	@When("User selects quantity of product")
	public void user_selects_quantity_of_product() {
		
	    addtocart.selectQuantity();
	}

	@When("User selects size {string} of product")
	public void user_selects_size_of_product(String size) {
		
	    addtocart.selectSize();
	}

	@When("User clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() {
		
		addtocart.clickOnAddToCart();
	    
	}

	@Then("User views product details on Add to cart confirmation pop up")
	public void user_views_product_details_on_add_to_cart_confirmation_pop_up() {
		
		addtocart.addToCartConfirmationPopUp();
	    
	}

	@Then("User clicks on Proceed to checkout button")
	public void user_clicks_on_proceed_to_checkout_button() {
	    
		addtocart.clickOnProceedToCheckoutBtn();
	}

	@Given("User views shopping cart summary")
	public void user_views_shopping_cart_summary() {
	    
		checkout = new CheckoutAndPayment();
		checkout.cartSummaryDetails();
	}

	@When("User clicks on Proceed to checkout button of shopping cart summary page")
	public void user_clicks_on_proceed_to_checkout_button_of_shopping_cart_summary_page() {
	    
		checkout.clickOnProceedToCheckout();
	}

	@When("User verify delivery address")
	public void user_verify_delivery_address() {
	    
		checkout.addressDetails();
	}

	@When("User clicks on Proceed to checkout button of address page")
	public void user_clicks_on_proceed_to_checkout_button_of_address_page() {
	    
		checkout.clickOnAddressPageProceedToCheckout();
	}

	@When("User agrees Terms of services")
	public void user_agrees_terms_of_services() {
	    
		checkout.shipingDetails();
	}

	@When("User clicks on Proceed to checkout button of Shipping page")
	public void user_clicks_on_proceed_to_checkout_button_of_shipping_page() {
	 
		checkout.clickOnShippingPageCheckout();
	}

	@When("User selects Payment method")
	public void user_selects_payment_method() {
	   
		checkout.paymentDetails();
	}

	@When("User views Order summary details")
	public void user_views_order_summary_details() {
	    
		checkout.orderSummaryDetails();
	}

	@When("User clicks on I confirm my order button")
	public void user_clicks_on_i_confirm_my_order_button() {
	    
		checkout.clickOnIconfirmMyOrderBtn();
	}

	@Then("User views Order confirmation message")
	public void user_views_order_confirmation_message() {
	    
		checkout.orderConfirmationStatus();
	}

	@Given("User is on My account page")
	public void user_is_on_my_account_page() {
	    
		orderhistory  = new OrderHistory();
		orderhistory.clickOnMyAccountName();
	}

	@When("User clicks on Order history and details link")
	public void user_clicks_on_order_history_and_details_link() {
		
		orderhistory.clickOnOrderHistoryAndDetails();
	   
	}

	@Then("User views Order history details")
	public void user_views_order_history_details() {
	    
		orderhistory.viewOrderDetails();
	}

	@Then("User clicks on Signout link")
	public void user_clicks_on_signout_link() {
	    
		orderhistory.clickOnSignOut();
		TestBase.terminate();
	}

	
}
