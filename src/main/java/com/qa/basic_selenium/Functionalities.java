package com.qa.basic_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.reusableMethods.ReusableMethods;

public class Functionalities {
	
	public static WebDriver driver;
	
	
	@Test(enabled=false)
	public void test1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled=false)  //dropdowns test
	public void test2() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		WebElement day=driver.findElement(By.id("day"));
		WebElement month=driver.findElement(By.id("month"));
		WebElement year=driver.findElement(By.id("year"));
//		Select select1=new Select(day);
//		select1.selectByVisibleText("26");
//		Select select2=new Select(month);
//		select2.selectByVisibleText("Aug");
//		Select select3=new Select(year);
//		select3.selectByVisibleText("1992");
		String dob="26-Aug-1992";
		String dobArr[]=dob.split("-");
		
		ReusableMethods.selectValueFromDropdown(day, dobArr[0]);
		ReusableMethods.selectValueFromDropdown(month, dobArr[1]);
		ReusableMethods.selectValueFromDropdown(year, dobArr[2]);
	}
	
	@Test(enabled=true) //parameters 
	@Parameters({"email","password"})
	public void test3(String username,String password) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		driver.get("https://www.amazon.in/?ext_vrnc=hi&tag=googhydrabk-21&ascsubtag=_k_Cj0KCQjwpdqDBhCSARIsAEUJ0hNINcZDG5CfFk0dcRGCjgFSS9W3DhfCPiPv0yASZKrcDTLIcMu9UeAaAs9wEALw_wcB_k_&ext_vrnc=hi&gclid=Cj0KCQjwpdqDBhCSARIsAEUJ0hNINcZDG5CfFk0dcRGCjgFSS9W3DhfCPiPv0yASZKrcDTLIcMu9UeAaAs9wEALw_wcB");
		WebElement element1=driver.findElement(By.id("nav-link-accountList-nav-line-1"));		
		action.moveToElement(element1).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'Sign in')]//parent::a[@class='nav-action-button']//parent::div[@id='nav-flyout-ya-signin']")).click();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();
		
	}
	
	@Test(enabled=true)
	public void test4() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmeher.SIMEIOSOLUTIONS\\Desktop\\eclipse"
				+ "\\Laureate_Automation-master\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get("https://learn.letskodeit.com/p/practice");
		
	}
	
	

}
