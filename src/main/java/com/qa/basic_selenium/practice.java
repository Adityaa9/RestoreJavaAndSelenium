package com.qa.basic_selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class practice {
	
	public static WebDriver driver;
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	
	@Test(enabled=false)
	public void test1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(driver.findElement(By.linkText("Gmail"))).keyUp(Keys.SHIFT)
		.keyUp(Keys.CONTROL).build().perform();
		Set<String> windows=driver.getWindowHandles();
		driver.switchTo().window((String)windows.toArray()[0]);
	}
	
	@Test(enabled=false)
	public void test2() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Actions action=new Actions(driver);
		action.keyDown(Keys.SHIFT).click(driver.findElement(By.linkText("Gmail"))).keyUp(Keys.SHIFT).build().perform();
		Set<String> tabs=driver.getWindowHandles();
		driver.switchTo().window((String)tabs.toArray()[0]);
	}
	
	@Test(enabled=false)
	public void test3() throws IOException {
		file=new File("C:\\Users\\bmeher.SIMEIOSOLUTIONS\\eclipse-workspace\\RestoreJavaAndSelenium\\src\\main\\java\\ExternalSheet\\getData.xlsx");
		fis=new FileInputStream(file);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheetAt(0);
		int x=ws.getLastRowNum();
		int y=ws.getRow(0).getLastCellNum();
		Object[][] data=new Object[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				data[i][j]=ws.getRow(i+1).getCell(j).toString().trim();
			}
		}
	}
	
	@Test
	public void test4() throws IOException {
		file=new File("C:\\Users\\bmeher.SIMEIOSOLUTIONS\\eclipse-workspace\\RestoreJavaAndSelenium\\src\\main\\java\\ExternalSheet\\getData.xlsx");
		fis=new FileInputStream(file);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheetAt(0);
		int x=ws.getLastRowNum();
		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=0;i<x;i++) {
			Row row=ws.getRow(i+1);
			String key=row.getCell(0).getStringCellValue().trim();			
			String value=row.getCell(1).getStringCellValue().trim();
			map.put(key, value);			
		}
		System.out.println(map);
		
	}

}
