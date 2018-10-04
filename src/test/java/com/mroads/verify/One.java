package com.mroads.verify;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class One {
	public WebDriver driver;
	String Loginurl = "https://panna-play.mroads.com/panna/#/login";
	String unmae = "sandeep@mroads.com";
	String pwd = "mRoads@123";
	String reports = "https://panna-play.mroads.com/panna/#/reports";
	Logger log = Logger.getLogger(One.class.getName());
	
  @Test
  public void first() throws InterruptedException {
	  
	  WebElement userEmail=driver.findElement(By.id("yourEmail"));
      userEmail.sendKeys(unmae);
      log.info("entered username");
      
      
      WebElement userPwd=driver.findElement(By.id("yourPwd"));
      userPwd.sendKeys(pwd);
      
      driver.findElement(By.id("login-submit-btn")).click();
      
      Thread.sleep(3000);
      
      driver.get(reports);
		Thread.sleep(3000);
      
    //Verifying the success
    		String bodyText = driver.findElement(By.xpath("/html/body/app-root/app-reports/div/div[1]")).getText();
    		
    		String expectedText = "Candidates interview reports";
    		 
    		if (bodyText.equals(expectedText)){
    			System.out.println("Verification Successful");
    		}else{
    			System.out.println("Verification Failed");
    			//In case of Fail, you like to print the actual and expected MSG for the record purpose
    			System.out.println("Actual URL is : " + bodyText);
    			System.out.println("Expected URL is : " + expectedText);
    		}
      
  }
  
  @Parameters("myBrowser")
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
//	  if(myBrowser.equalsIgnoreCase("firefox")) {
//		  
//	  }
//	  System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");
//		driver = new ChromeDriver();
	  
	  System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/geckodriver");
	  WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().fullscreen();
	  
		driver.get(Loginurl);
		Thread.sleep(3000);
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
