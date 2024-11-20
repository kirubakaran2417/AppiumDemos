package org.example;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import junit.framework.Assert;

public class MiscellaneousAppiumActions extends BaseTest {
	By prefernceid=AppiumBy.accessibilityId("Preference");
	public WebElement preference() {
		return driver.findElement(prefernceid);
	}
	@Test
	public void  MiscellaneousAppiumActionstest() throws MalformedURLException {
		//code to start server
//		AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\k.kirubakaran\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		//Androiddriver,IOS Driver
		//Appiumcode->Appium Server->Mobile Device 
	
		//Actual automation
		//xpath,id,accessiblityId,classname,androidUIAutomator
		//app package and app activity
		Activity activity =new Activity("io.appium.android.apis"," io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		//rotate the device to landscape
		DeviceRotation landscape=new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alerttext=driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(alerttext, "WiFi settings");
		driver.setClipboardText("msd wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//press back button
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		//press home button
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		//stop the server
	}
}
