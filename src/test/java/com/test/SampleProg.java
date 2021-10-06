package com.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleProg {
	WebDriver driver;

	@BeforeClass

	private void bF() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");

	}

	@BeforeMethod
	private void bM() {
		Date date = new Date();
		System.out.println(date);

	}

	@Parameters({ "username", "password" })
	@Test
	private void tC0(String s, String s1) {
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(s);
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(s1);
		WebElement logiN = driver.findElement(By.id("login"));
		logiN.click();
	}

	@Parameters({ "datepick_in", "datepick_out" })
	@Test
	private void tC1(String s2, String s3) {
		WebElement ddpLoc = driver.findElement(By.id("location"));
		Select select = new Select(ddpLoc);
		select.selectByIndex(1);

		WebElement ddpHot = driver.findElement(By.id("hotels"));
		Select select1 = new Select(ddpHot);
		select1.selectByIndex(3);

		WebElement ddpRty = driver.findElement(By.id("room_type"));
		Select select2 = new Select(ddpRty);
		select2.selectByIndex(3);

		WebElement ddpRno = driver.findElement(By.id("room_nos"));
		Select select3 = new Select(ddpRno);
		select3.selectByIndex(3);

		WebElement dateIn = driver.findElement(By.id("datepick_in"));
		dateIn.clear();
		dateIn.sendKeys(s2);

		WebElement dateOut = driver.findElement(By.id("datepick_out"));
		dateOut.clear();
		dateOut.sendKeys(s3);

		WebElement ddpAdro = driver.findElement(By.id("adult_room"));
		Select select4 = new Select(ddpAdro);
		select4.selectByIndex(3);

		WebElement ddpChro = driver.findElement(By.id("child_room"));
		Select select5 = new Select(ddpChro);
		select5.selectByIndex(2);

		WebElement submit = driver.findElement(By.id("Submit"));
		submit.click();
	}

	@Test
	private void tC2() {

		WebElement radio = driver.findElement(By.id("radiobutton_0"));
		radio.click();

		WebElement continu = driver.findElement(By.id("continue"));
		continu.click();
		
		System.out.println("hello");
		System.out.println("hello");


	}

	@Parameters({ "first_name", "last_name", "address", "cc_num", "cc_cvv" })
	@Test
	private void tC3(String s4, String s5, String s6, String s7, String s8) {
		System.out.println("hi");
		WebElement fname = driver.findElement(By.id("first_name"));
		fname.sendKeys(s4);
		WebElement lname = driver.findElement(By.id("last_name"));
		lname.sendKeys(s5);
		WebElement aDdress = driver.findElement(By.id("address"));
		aDdress.sendKeys(s6);
		WebElement ccN = driver.findElement(By.id("cc_num"));
		ccN.sendKeys(s7);
		WebElement ddpCcty = driver.findElement(By.id("cc_type"));
		Select select6 = new Select(ddpCcty);
		select6.selectByIndex(2);
		WebElement ddpExp = driver.findElement(By.id("cc_exp_month"));
		Select select7 = new Select(ddpExp);
		select7.selectByIndex(2);
		WebElement ddpExpy = driver.findElement(By.id("cc_exp_year"));
		Select select8 = new Select(ddpExpy);
		select8.selectByIndex(2);
		WebElement cCv = driver.findElement(By.id("cc_cvv"));
		cCv.sendKeys(s8);

		WebElement bookNow = driver.findElement(By.id("book_now"));
		bookNow.click();

	}

	@AfterMethod
	private void tC4(Method m) throws IOException {
		Date date = new Date();
		System.out.println(date);
		String name = m.getName();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ScreenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ScreenshotAs, new File(name + ".png"));

	}

	@AfterClass
	private void aC() {
		driver.quit();
	}
}
