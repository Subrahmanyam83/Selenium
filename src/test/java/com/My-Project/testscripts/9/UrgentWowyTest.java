package com.tbb.testscripts.getfit;

import java.util.concurrent.TimeUnit;

import mx4j.log.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.tbb.framework.BaseTest;


/**
 * 
 * This test script contains test method for SuperGym page under Get-Fit module for creating one-click workout.
 * @author Gaurav
 */
public class UrgentWowyTest extends BaseTest {
	
	
	//private static final int iCount = Integer.parseInt(ConfigFileReader.getConfigItemValue("testng.test.invocationCount"));
	static int count = 0;
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		driver.get("http://10.10.18.247/get-fit/supergym");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	 
		WebElement email = driver.findElement(By.name("_58_login"));
		WebElement password = driver.findElement(By.name("_58_password"));
		WebElement signIn = driver.findElement(By.cssSelector("input[value='Sign In']"));
	 
		email.sendKeys("mjwcoach@beachbodytest.com");
		password.sendKeys("beachbody");
		signIn.sendKeys(Keys.ENTER);
		
	}
	
	@AfterClass
	public void tearDown() {
		 driver.quit();
		
	}
	
@Test(invocationCount=3000)
public void testOneClickWorkout() {
	
	WebElement routine = driver.findElement(By.cssSelector("select#supergym-mywo-dropdowns-selected-program > option[value='24000']"));
	routine.click();
	//try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}
	
 	WebElement program = driver.findElement(By.cssSelector("select#supergym-mywo-dropdowns-selected-routine > option[value='24100']"));
	program.click();
	//try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}
	
	WebElement start = driver.findElement(By.cssSelector("div#supergym-mywo-start-now-btn > a.btn-orange > span"));
    start.click();
    try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace();}
    WebElement finished = driver.findElement(By.cssSelector("input[value='Finished']"));
    finished.click();
	try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace();}
    
	logger.info("Completing A " + ++count + " One-click workout");
    WebElement msg = driver.findElement(By.id("supergym-wo-progress-bar-congrats"));
    logger.info(msg.getText());
  
    driver.get("http://10.10.18.247/get-fit/supergym");
	routine = driver.findElement(By.cssSelector("select#supergym-mywo-dropdowns-selected-program > option[value='24000']"));
	routine.click();
	//try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}
	
	program = driver.findElement(By.cssSelector("select#supergym-mywo-dropdowns-selected-routine > option[value='24200']"));
	program.click();
	//try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}
	
	start = driver.findElement(By.cssSelector("div#supergym-mywo-start-now-btn > a.btn-orange > span"));
	start.click();
	try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace();}
	
	finished = driver.findElement(By.cssSelector("input[value='Finished']"));
	finished.click();
	try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace();}
	
	logger.info("Completing A " + ++count + " One-click workout");
	msg = driver.findElement(By.id("supergym-wo-progress-bar-congrats"));
	logger.info(msg.getText());
	 
	driver.get("http://10.10.18.247/get-fit/supergym");
	routine = driver.findElement(By.cssSelector("select#supergym-mywo-dropdowns-selected-program > option[value='24000']"));
	routine.click();
	//try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}
	program = driver.findElement(By.cssSelector("select#supergym-mywo-dropdowns-selected-routine > option[value='24300']"));
	program.click();
	//try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}
	start = driver.findElement(By.cssSelector("div#supergym-mywo-start-now-btn > a.btn-orange > span"));
	start.click();
	try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace();}
	
	finished = driver.findElement(By.cssSelector("input[value='Finished']"));
    finished.click();
    try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace();}
    
    logger.info("Completing A " + ++count + " One-click workout");
    msg = driver.findElement(By.id("supergym-wo-progress-bar-congrats"));
    logger.info(msg.getText());
    
    driver.get("http://10.10.18.247/get-fit/supergym");
		    
	}

}
