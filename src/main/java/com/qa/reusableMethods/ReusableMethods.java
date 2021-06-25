package com.qa.reusableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods {
	
	public static WebDriver driver;
	
	
	public static Object[][] utility() throws IOException {
		File file=new File("C:\\Users\\bmeher.SIMEIOSOLUTIONS\\eclipse-workspace\\RestoreJavaAndSelenium\\src\\main\\java\\ExternalSheet\\getData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheetAt(0);
		Object[][] data=new Object[ws.getLastRowNum()][ws.getRow(0).getLastCellNum()];
		for(int i=0;i<ws.getLastRowNum();i++) {
			for(int j=0;j<ws.getRow(0).getLastCellNum();j++) {
				data[i][j]=ws.getRow(i+1).getCell(j).toString();
			}
		}		
		return data;		
	}
	
	public static void selectDate(String exDay,String exMonth,String exYear) {		
		
		String monthyearval=driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthyearval);		
		while(!(ReusableMethods.getMonthYear(monthyearval)[0].equals(exMonth) && ReusableMethods.getMonthYear(monthyearval)[1].equals(exYear))){
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthyearval=driver.findElement(By.className("ui-datepicker-title")).getText();
			
		}
		driver.findElement(By.xpath("//a[text()='"+exDay+"']")).click();
	}
	
	public static String[] getMonthYear(String monthyearval) {
		return monthyearval.split(" ");
	}
	
	public static void selectValueFromDropdown(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}

}
