package com.eCommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.eCommerce.utilities.SeleniumUtils;
import com.eCommerce.utilities.TestBase;

public class SignIn extends TestBase{
	
	
	SeleniumUtils utils = new SeleniumUtils();
	
	public SignIn()
	{
		PageFactory.initElements(driver,this);
		
	}	
	
	@FindBy(how = How.ID, using = "email")
	WebElement Emailaddress;
	
	@FindBy(how=How.ID, using = "passwd")
	WebElement Password;
	
	@FindBy(how = How.ID, using = "SubmitLogin")
	WebElement SigninButton;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Ana Paula')]")
	WebElement accountName;
	
	public void setEmailAddress(String email)
	{
		Assert.assertTrue(Emailaddress.isDisplayed());
		utils.enterText(Emailaddress, email, 30, "Enter Email address");
	}
	
	public void setPassword(String password)
	{
		Assert.assertTrue(Password.isDisplayed());
		utils.enterText(Password, password, 30, "Enter password");
	}
	
	public void clickSignIn()
	{
		Assert.assertTrue(SigninButton.isDisplayed());
		utils.click(SigninButton, 30, "click on sign in button");
	}
	public void verifyMyAccountName()
	{
		String myAccountName = accountName.getText();
		if(myAccountName.equals(TestBase.prop.getProperty("accountName")))
		{
			System.out.println("Welcome "+myAccountName);
		}
				
		
	}
	
	

}
