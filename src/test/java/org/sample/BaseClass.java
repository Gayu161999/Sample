package org.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public WebDriver getDriver(String browser) {
	
//BROWSER LAUNCH 1
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("INVALID BROWSER" + browser);
			break;
		}
		return driver;
	}

//LAUNCH URL 2
	public void getUrl(String url) {
		driver.get(url);

	}

//LOCATORS 3
	public WebElement findLocators(String locators, String value) {
		WebElement element = null;

		switch (locators) {
		case "id":
			element = driver.findElement(By.id(value));
			break;
		case "name":
			element = driver.findElement(By.name(value));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(value));
			break;
		default:
			System.out.println("INVALID lOCATOR" + locators);
			break;
		}
		return element;
	}

//SENDKEYS 4
	public WebElement giveSendkeys(WebElement element, String data) {

		element.sendKeys(data);
		return element;
	}

//CLICK 5
	public void clickOption(WebElement element) {
		element.click();
	}

//CLEAR 6
	public void clearOption(WebElement element) {
		element.clear();
	}

//QUIT 7
	public WebDriver quitOption() {
		driver.quit();
		return driver;

	}

//CLOSE 8
	public WebDriver closeOption() {
		driver.close();
		return driver;

	}

//GETTEXT 9
	public void getTextoption(WebElement element) {
	element.getText();
	}
	
//GET CURRENT URL 10
	public void getCurrentUrl(WebElement element,String data) {
	element.getAttribute(data);
	} 
	
	
}
