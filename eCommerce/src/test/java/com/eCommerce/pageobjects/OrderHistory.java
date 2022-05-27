package com.eCommerce.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eCommerce.utilities.TestBase;

import io.opentelemetry.api.internal.Utils;

public class OrderHistory extends TestBase {

	
	
	public OrderHistory()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@title=\"View my customer account\"]")
	WebElement accountName;
	
	@FindBy(how = How.XPATH, using = "//a[@title=\"Orders\"]")
	WebElement orderAndHistoryDetails;
	
	@FindBy(how = How.XPATH, using = "//h1[text()=\"Order history\"]")
	WebElement orderHistoryHeader;
	
	@FindBy(how = How.XPATH, using = "//a[@class=\"logout\"]")
	WebElement signOut;
	
	public void clickOnMyAccountName()
	{
		accountName.click();
	}
	
	public void clickOnOrderHistoryAndDetails()
	{
		orderAndHistoryDetails.click();
	}
	
	public void viewOrderDetails()
	{
		String orderHistoryPageHeader = orderHistoryHeader.getText();
		System.out.println(orderHistoryPageHeader);
		
        String lsHead = "";
		
		String lsData = "";
		
		Map<String, String> map = new HashMap<String, String>();
		
		for(int i=1; i<=5; i++)
		{
			lsHead = driver.findElement(By.xpath("//table[@id=\"order-list\"]//tr//th["+ i +"]\r\n"
					+ "")).getText();
			
			lsData = driver.findElement(By.xpath("(//table[@id=\"order-list\"]//tr//td["+ i +"])[1]")).getText();
			
			map.put(lsHead, lsData);
		}
		
		Set s = map.entrySet();
		System.out.println(s);
		
		Iterator it = s.iterator();
		while(it.hasNext())
		{
			Map.Entry m = (Map.Entry) it.next();
			System.out.println(m.getKey()+"-------"+m.getValue());
		}
		
	}
	
	public void clickOnSignOut()
	{
		signOut.click();
	}
	
	
	
	
	
	
	
}
