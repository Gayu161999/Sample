package com.tes;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExec {
	@Parameters({ "browser" })
	@Test
	private void tc1(String s) {
		if (s.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			System.out.println(Thread.currentThread().getId());
			driver.quit();

		} else if (s.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			System.out.println(Thread.currentThread().getId());
			driver.quit();

		} else if (s.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			System.out.println(Thread.currentThread().getId());
			driver.quit();
		}
	}
}

////		WebElement useName = driver.findElement(By.id("email"));
////		useName.sendKeys("Gayu123");
////		WebElement passWord = driver.findElement(By.id("pass"));
////		passWord.sendKeys("Gayu123@12");
////		WebElement loGin = driver.findElement(By.name("login"));
////		loGin.click();
//	}	
//@Test
//
//	private void tc2() {
//
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://www.amazon.in/");
//		driver.quit();
//		
//	}
