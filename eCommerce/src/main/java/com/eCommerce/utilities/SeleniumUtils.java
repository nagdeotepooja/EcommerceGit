package com.eCommerce.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumUtils extends TestBase{
	
	public static Logger log = LogManager.getLogger(SeleniumUtils.class);
	
	public void click(WebElement elementToBeClicked, long timeOut, String elemName)
	{
		if(timeOut == 0 || timeOut<=15)
		{
			timeOut = 45;
		}
		try {
			WebDriverWait wait= new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.visibilityOf(elementToBeClicked));
			log.info("Successfully found "+ elemName);
			elementToBeClicked.click();
		} catch (Exception exceptionClick) {
            System.out.println("Exception occurred on clicking the element "+ elemName + " " + exceptionClick.getMessage());
		}
	}
	
	public void click(WebElement elementToBeClicked,  String elemName, long timeOut)
	{
		// Click by Javascript executor
		if(timeOut == 0 || timeOut<=15)
		{
			timeOut = 45;
		}
		try {
			WebDriverWait wait= new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.visibilityOf(elementToBeClicked));
			JavascriptExecutor javaScriptExecutor = ((JavascriptExecutor)driver);
			javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", elementToBeClicked);
			javaScriptExecutor.executeScript("arguments[0].click();", elementToBeClicked);
		} catch (Exception exceptionClick) {
            System.out.println("Exception occurred on clicking the element "+ elemName + " " + exceptionClick.getMessage());
		}
	}
	
	public void click(String elemName)
	{
		
		try {
		    Actions action = new Actions(driver);
			action.click();
		} catch (Exception exceptionClick) {
            System.out.println("Exception occurred on clicking the element "+ elemName + " " + exceptionClick.getMessage());
		}
	}
	
	
	public void enterText(WebElement elementToEnter, String textToBeEntered, long timeOut, String elemName)
	{
		if(timeOut == 0 || timeOut<=15)
		{
			timeOut = 45;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.visibilityOf(elementToEnter));
			System.out.println("Successfully found "+ elemName);
			elementToEnter.clear();
			elementToEnter.sendKeys(textToBeEntered.trim());
		} catch (Exception exceptionEnterText) {
			System.out.println("Exception occurred on entering the text "+ elemName + " " + exceptionEnterText.getMessage());
		}
		
		
	}
	
	public void switchToFrameByWebElement(WebElement elementToSwitch, long timeOut, String eleName)
	{
		if(timeOut == 0 || timeOut<=15)
		{
			timeOut = 45;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elementToSwitch));
			//driver.switchTo().frame(elementToSwitch);
		} catch (Exception frameWebElementException) {
			System.out.println("Exception occurred on switching frames "+ eleName + " " + frameWebElementException.getMessage());
		}
	}
	
	public void selectByValue(WebElement elementToBeSelected, String eleValue, long timeOut, String eleName )
	{
		if(timeOut == 0 || timeOut<=15)
		{
			timeOut = 45;
		}
		Select sel = new Select(elementToBeSelected);
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(elementToBeSelected));
			System.out.println("Successfully selected element"+ eleName);
			sel.selectByValue(eleValue);
		} catch (Exception selectWebElementException) {
			System.out.println("Exception occured on selecting webelement" + eleName + " " + selectWebElementException.getMessage());
		}
	}
	
	public void selectByVisibleText(WebElement elementToBeSelected, long timeOut, String eleText, String eleName)
	{
		if(timeOut == 0 || timeOut<=15)
		{
			timeOut = 45;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeSelected(elementToBeSelected));
			//System.out.println("Successfully selected element "+ eleName);
			Select sel = new Select(elementToBeSelected);
			sel.selectByVisibleText(eleText);
		} catch (Exception selectWebElementException) {
			System.out.println("Exception occured on selecting webelement" + eleName + " " + selectWebElementException.getMessage());
		}
		
		
	}
	
	public void selectByIndex(WebElement elementToBeSelected, long timeOut, int index, String eleName)
	{
		if(timeOut == 0 || timeOut<=15)
		{
			timeOut = 45;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeSelected(elementToBeSelected));
			System.out.println("Successfully selected element "+ eleName);
			Select sel = new Select(elementToBeSelected);
			sel.selectByIndex(index);
		} catch (Exception selectWebElementException) {
			System.out.println("Exception occured on selecting webelement" + eleName + " " + selectWebElementException.getMessage());
		}
		
	}
	
	public void moveToElementAndClick(WebElement elementToHover, WebElement elementToClick, long timeOut, String eleName)
	{
		if(timeOut == 0 || timeOut<=15)
		{
			timeOut = 45;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(elementToHover));
			System.out.println("Successfully selected element "+ eleName);
			Actions action = new Actions(driver);
			action.moveToElement(elementToHover).moveToElement(elementToClick).click().perform();
		} catch (Exception selectWebElementException) {
			System.out.println("Exception occured on selecting webelement" + eleName + " " + selectWebElementException.getMessage());
		}
	}
	
	public void clickOnCheckBox(WebElement elementToClick, long timeOut, String eleName)
	{
		if(timeOut == 0 || timeOut<=15)
		{
			timeOut = 45;
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(elementToClick));
			if(elementToClick.isSelected())
			{
				Assert.assertTrue(false, "checkbox " +eleName+ " is already selected");
			}
			else
			{
				elementToClick.click();
				Assert.assertTrue(elementToClick.isSelected(), "checkbox "+eleName+" is not selected");
			}
			
		} catch (Exception selectWebElementException) {
			System.out.println("Exception occured on selecting webelement" + eleName + " " + selectWebElementException.getMessage());
		}
	}
	
	
}
