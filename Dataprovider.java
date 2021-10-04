package com.sriram.testng.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class Dataprovider {
	WebDriver driver;
 
 @BeforeMethod
  
public void launchBrowser() {
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	
  }
 @BeforeTest
 public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
 }
 @DataProvider(name="TestData")
 public Object[][] getData()
 {
	 Object[][] data=new Object[3][2];
	 
	 data[0][0]="user1";
	 data[0][1]="password1";
	 
	 data[1][0]="user2";
	 data[1][1]="password2";

	 data[2][0]="user3";
	 data[2][1]="password3";

	 return data;
	 
	 
 }
 
@Test(dataProvider="TestData")
public void login(String username,String password)
 {
	 driver.findElement(By.id("email")).sendKeys(username);
	 driver.findElement(By.id("pass")).sendKeys(password);
	 driver.findElement(By.id("loginbutton")).click();
	 driver.close();
	 
 }
 
 
}
