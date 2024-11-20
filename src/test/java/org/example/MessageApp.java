package org.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.options.app.SupportsAppPackageOption;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MessageApp {
	public AndroidDriver driver;
@Test
	public void test() throws MalformedURLException, InterruptedException {
	//what is happening
	// DesiredCapabilities capabilities = new DesiredCapabilities();
	UiAutomator2Options options=new UiAutomator2Options();
    
	// com.google.android.apps.messaging/com.google.android.apps.messaging.ui.ConversationListActivity
     // Set your desired capabilities for the Android device or emulator
     capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
     capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "kirubaphone2");
     capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.messaging"); // Replace with the actual package name
     capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.messaging.ui.ConversationListActivity"); // Replace with the actual activity name
     driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Got it\")")).click();
	 driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
	 Thread.sleep(3000);
	 driver.findElement(AppiumBy.className("android.widget.MultiAutoCompleteTextView")).sendKeys("7448322417");
	 driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Go"));
	}
}
