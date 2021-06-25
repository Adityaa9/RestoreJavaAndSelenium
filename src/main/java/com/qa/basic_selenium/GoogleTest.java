package com.qa.basic_selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.reusableMethods.ReusableMethods;

public class GoogleTest {
	
	public static WebDriver driver;
	
	
	@Test (priority=1, enabled=false, description="multiple tabs") 
	public void test1() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
			+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com");
	Actions action=new Actions(driver);
	action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(driver.findElement(By.linkText("Gmail"))).keyUp(Keys.SHIFT)
	.keyUp(Keys.CONTROL).build().perform();
	Thread.sleep(3000);
	Set<String> tabs=driver.getWindowHandles();
	driver.switchTo().window((String)tabs.toArray()[0]);
	Thread.sleep(3000);
	driver.quit();	
	}
	
	@Test (priority=2, enabled=false, description="multiple windows")  
	public void test2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Actions action=new Actions(driver);
		action.keyDown(Keys.SHIFT).click(driver.findElement(By.linkText("Gmail"))).keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(3000);
		Set<String> windows= driver.getWindowHandles();
		driver.switchTo().window((String)windows.toArray()[0]);
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test (priority=3,enabled=false)
	public void test3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/gp/help/customer/display.html?nodeId=GGE5X8EV7VNVTK6R");
		WebElement element1=driver.findElement(By.xpath("//a[contains(text(),'Gifts,  and Lists')]"));
		WebElement solutionBox=driver.findElement(By.cssSelector("input[class='a-input-text a-span12']"));
		solutionBox.sendKeys("TrackPant");
		Thread.sleep(3000);
		element1.click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Gift Orders")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}
	@Test(priority=4,enabled=false,description="active links") 
	public void test4() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/gp/help/customer/display.html?nodeId=GGE5X8EV7VNVTK6R");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int x=links.size();
		System.out.println(x);
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		for(int i=0;i<x;i++) {
			if(links.get(i).getAttribute("href")!=null) {
				activeLinks.add(links.get(i));
			}
		}
		System.out.println(activeLinks.size());
		driver.quit();		
	}
	
	
	@Test(priority=5,enabled=false)
	public void test5() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/gp/help/customer/display.html?nodeId=GGE5X8EV7VNVTK6R");
		driver.findElement(By.xpath("//a[@href='https://amazon.jobs']")).click();
		driver.navigate().back();
		driver.quit();		
	}
	
	@Test(priority=6,enabled=false) //dataprovider
	public void test6() throws IOException
	{
		File file=new File("C:\\Users\\bmeher.SIMEIOSOLUTIONS\\eclipse-workspace\\RestoreJavaAndSelenium\\src\\main\\java\\ExternalSheet\\getData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheetAt(0);
		int LastRow=ws.getLastRowNum();
		String user1=ws.getRow(1).getCell(0).getStringCellValue();
		System.out.println(user1);
		for(int i=1;i<=LastRow;i++) {
			System.out.print(ws.getRow(i).getCell(0).getStringCellValue().trim());
			System.out.print(" ");
			System.out.println(ws.getRow(i).getCell(1).getStringCellValue().trim());
		}
		Row row;
		Cell cell;
		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=1;i<=LastRow;i++) {
			row=ws.getRow(i);
			Cell keycell=row.getCell(0);
			String key=keycell.getStringCellValue().trim();
			
			Cell valuecell=row.getCell(1);
			String value=valuecell.getStringCellValue().trim();
			
			map.put(key, value);
		}
		System.out.println(map.size());
		Map.Entry<String,String> entry=map.entrySet().iterator().next();
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
		String[] mapData=(String[]) map.keySet().toArray();
		
	}
	
	@DataProvider   //data provider
	public Object[][] getData() throws IOException {
		Object[][] excelData=ReusableMethods.utility();
		return excelData;
	}
	
	@Test(priority=7,enabled= true,dataProvider="getData")
	public void test7(String username,String password) {
		System.out.println(username+" "+password);
	}
	
	@Test(priority=8,enabled=false)
	public void test8() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.cssSelector("input[id='datepicker']")).click();
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5))
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));		
		String monthyearval=driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthyearval);
		String month=monthyearval.split(" ")[0].trim();
		String year=monthyearval.split(" ")[1].trim();
		while(!(month.equals("June") && year.equals("2022"))){
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthyearval=driver.findElement(By.className("ui-datepicker-title")).getText();
			month=monthyearval.split(" ")[0].trim();
			year=monthyearval.split(" ")[1].trim();
		}
		driver.findElement(By.xpath("//a[text()='23']")).click();
	}
	
	@Test(priority=9,enabled=false)
	public void test9() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.cssSelector("input[id='datepicker']")).click();		
		ReusableMethods.selectDate("16", "June", "2022");		
		Thread.sleep(3000);
	}	
	
	@Test(priority=10,enabled=false) //dynamic webtable
	public void test10() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		int x=driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr")).size();
		int y=driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr[1]//td")).size();
		System.out.println("Number of rows=" + x + "Number of columns=" + y);
		
		String xpath1="//table[@class='tsc_table_s13']//tbody//tr[";
		String xpath2="]//td[";
		String value=driver.findElement(By.xpath(xpath1+"2"+xpath2+"3"+"]")).getText();
		System.out.println("Element present in 2nd row 3rd column is: "+ value );
		for(int i=1;i<=x;i++) {
			for (int j=1;j<=y;j++) {
				if(driver.findElement(By.xpath(xpath1+i+xpath2+j+"]")).getText().equalsIgnoreCase("Mecca")) {
					System.out.println("The row is: "+ i+"The column is: "+ j);
					break;
				}
			}
		}
		driver.quit();
	}
	

}
