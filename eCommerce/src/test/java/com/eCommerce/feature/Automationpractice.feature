Feature: Purchase a product from a Ecommerce Website

Scenario: Successful Login with valid credentials

      Given User navigates to eCommerce site
      When  User enters Email address "paula@gmail.com" 
     	And   User enters Password "Spring2022"
     	And   User click on sign in
     	Then  User navigates to myaccount page
     	
Scenario: Select any product

      Given User is on myaccount page
      When  User clicks on Women section
      And   User clicks on Dresses under subcategories of Women section
      And   User clicks on Evening Dresses under subcategories of Dresses section
      Then  User views list of products under Evening Dresses section
      And   User clicks on Quick view link of product  
      
Scenario: Add to cart 

      Given User views selected product information
      When  User selects quantity of product 
      And   User selects size "M" of product
      And   User clicks on Add to cart button
      Then  User views product details on Add to cart confirmation pop up
      And   User clicks on Proceed to checkout button
      
Scenario: Checkout and Payment
   
     Given User views shopping cart summary 
     When  User clicks on Proceed to checkout button of shopping cart summary page
     And   User verify delivery address
     And   User clicks on Proceed to checkout button of address page
     And   User agrees Terms of services
     And   User clicks on Proceed to checkout button of Shipping page
     And   User selects Payment method
     And   User views Order summary details
     And   User clicks on I confirm my order button  
     Then  User views Order confirmation message
     
Scenario: Order history

     Given User is on My account page
     When  User clicks on Order history and details link
     Then  User views Order history details
     And   User clicks on Signout link      
             
      
      
                       	