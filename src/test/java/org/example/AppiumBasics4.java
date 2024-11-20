package org.example;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import junit.framework.Assert;

public class AppiumBasics4 extends BaseTest {

	@Test
	public void Testcase1() throws MalformedURLException {
//Kiruba, ID: 
		driver.get("https://www.dailymail.co.uk");
		driver.findElement(By.linkText("CLASSIC HOMEPAGE")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("j_username")).sendKeys("choannadurai@yahoo.com");
		driver.findElement(By.name("j_password")).sendKeys("Annamail123#");
		driver .findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'pics-scandal.html#comments')]")).click();
		driver.findElement(By.name("message")).sendKeys("first comment");
		driver.findElement(By.id("post-new-comment")).click();
	//	driver.quit();
		//stop the server
	}
	@Test
	public void Testcase2() throws MalformedURLException {
		driver.get("https://www.dailymail.co.uk");
		driver.findElement(By.linkText("CLASSIC HOMEPAGE")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'articletext')]//img)[1]")).click();
		driver.findElement(By.xpath("//img[contains(@id,'i-')]")).click();
		String text=driver.findElement(By.cssSelector("div.counter-1RYOX")).getText();
		int count=Integer.parseInt(text.split(" ")[2]);
		WebElement clickable=driver.findElement(By.cssSelector("button.nextButton-3SUcS"));
		for (int i = 0; i < count; i++) {
		    clickable.click();
		}	
		driver.findElement(By.cssSelector("button.closeButton-3n9vO")).click();

	}
	@Test
	public void Testcase3() throws MalformedURLException, InterruptedException {
		driver.get("https://www.dailymail.co.uk/video/index.html");
		//driver.findElement(By.linkText("CLASSIC HOMEPAGE")).click();
		//driver.findElement(By.xpath( ".//android.widget.Button[@text='Allow']")).click();
		WebElement b1=driver.findElement(By.cssSelector(".vjs-play-control.vjs-control"));
		Actions a=new Actions(driver);
		a.moveToElement(b1).click(b1).build().perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='vjs-play-control vjs-control  vjs-playing']")).click();
		
	}
	@Test
	public void Testcase4() throws MalformedURLException, InterruptedException {
		driver.get("https://www.dailymail.co.uk/video/index.html");
		driver.findElement(By.xpath("//a[@title='Search']")).click();
		driver.findElement(By.id("searchPhrase")).sendKeys("Putin");
		driver .findElement(By.xpath("//button[@title='Search']")).click();
		driver.findElement(By.id("orderBy2")).click();
		
	}
	}

