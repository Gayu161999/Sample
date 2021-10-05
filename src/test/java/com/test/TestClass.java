package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

	@DataProvider(name = "Excel")

	public Object[][] getData() throws IOException {
		File f = new File("C:\\Users\\91902\\eclipse-workspace\\SampleMaven\\excel\\Excel.xlsx");
		FileInputStream stream = new FileInputStream(f);

		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Excel Data");
		Row row = sheet.getRow(0);
		int rows = sheet.getPhysicalNumberOfRows();
		int lastCellNum = row.getLastCellNum();
		Object data[][] = new Object[rows - 1][lastCellNum];
		for (int i = 0; i < rows - 1; i++) {
			Row row2 = sheet.getRow(i + 1);
			for (int j = 0; j < lastCellNum; j++) {
				Cell cell = row2.getCell(j);

				DataFormatter Formatter = new DataFormatter();
				String formatCellValue = Formatter.formatCellValue(cell);
				data[i][j] = formatCellValue;
			}
		}
		return data;
	}
	WebDriver driver;
	@Test(dataProvider = "Excel")
	private void tC1(String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://adactinhotelapp.com/index.php");

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("gayu161999");
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys("Gayu@1999");
		WebElement logiN = driver.findElement(By.id("login"));
		logiN.click();
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
		select4.selectByIndex(2);

		WebElement ddpChro = driver.findElement(By.id("child_room"));
		Select select5 = new Select(ddpChro);
		select5.selectByIndex(2);

		WebElement submit = driver.findElement(By.id("Submit"));
		submit.click();

		WebElement radio = driver.findElement(By.id("radiobutton_0"));
		radio.click();

		WebElement continu = driver.findElement(By.id("continue"));
		continu.click();

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
		driver.quit();

	}
	
}
