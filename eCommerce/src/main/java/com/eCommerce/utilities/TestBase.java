package com.eCommerce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public static Logger log = LogManager.getLogger(TestBase.class);
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("E:\\Users\\Welcome\\BDDAutomation\\eCommerce\\src\\main\\java\\com\\eCommerce\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {

			e.getMessage();
		} catch (IOException e) {

			e.getMessage();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Users\\Welcome\\BDDAutomation\\eCommerce\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			log.info(browserName+" launched successfully");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void terminate()
	{
		//driver.close();
		driver.quit();
		log.info("Browser closed and driver terminated successfully");
	}

}
