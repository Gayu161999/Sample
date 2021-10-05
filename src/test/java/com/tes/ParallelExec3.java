package com.tes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExec3 {
	WebDriver driver;

	@Test
	private void tc10() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	
		
	
	
		WebElement useName = driver.findElement(By.id("email"));
		useName.sendKeys("Gayu123");
		WebElement passWord = driver.findElement(By.id("pass"));
		passWord.sendKeys("Gayu123@12");
		WebElement loGin = driver.findElement(By.name("login"));
		loGin.click();
	
		driver.quit();
	}

}
