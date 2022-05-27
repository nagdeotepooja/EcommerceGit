package com.eCommerce.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommerce.utilities.SeleniumUtils;
import com.eCommerce.utilities.TestBase;

public class HomePage extends TestBase{
	
	
	SeleniumUtils utils = new SeleniumUtils();
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
	@CacheLookup
	WebElement signinlink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickSignInLink()
	{
		Assert.assertTrue(signinlink.isDisplayed());
		utils.click(signinlink, 10, "SignIn link");	
	}

}
