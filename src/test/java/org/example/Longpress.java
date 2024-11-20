package org.example;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import junit.framework.Assert;

public class Longpress extends BaseTest {

	@Test
	public void wifisettingsName() throws MalformedURLException {
		//code to start server
//		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\k.kirubakaran\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		//Androiddriver,IOS Driver
		//Appiumcode->Appium Server->Mobile Device 
	
		//Actual automation
		//xpath,id,accessiblityId,classname,androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longpressAction(ele);
		/*
		 * ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId", 
				((RemoteWebElement) ele).getId(),"duration",2000));
		 */
		boolean menutext=driver.findElement(By.id("android:id/title")).isDisplayed();
		assertTrue(menutext);
		//stop the server
	}
	public void longpressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId", 
				((RemoteWebElement) ele).getId(),"duration",2000));
	}
}
