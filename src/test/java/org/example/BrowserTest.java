package org.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BrowserTest {
	public AndroidDriver driver;
	@Test
	public void configureAppium() throws MalformedURLException, InterruptedException {
		 DesiredCapabilities capabilities=new DesiredCapabilities();
         capabilities.setCapability("chromedriverExecutable","C:\\\\Users\\\\k.kirubakaran\\\\Downloads\\\\chromedriver_win32 (15)\\\\chromedriver.exe");
              capabilities.setCapability("automationName", "UiAutomator2");

       capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
               capabilities.setCapability("device", "Android");
       capabilities.setCapability("deviceName", "kirubaphone2");
       capabilities.setCapability("platformVersion","13");
       capabilities.setCapability("platformName", "Android");
       capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		
//		options.setPlatformName("Android");
		//creating a object of android driver
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("http://www.goolge.com");
	        Thread.sleep(10000);
	        driver.quit();
	}
}
