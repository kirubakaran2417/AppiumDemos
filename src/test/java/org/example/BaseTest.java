package org.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.options.app.SupportsAutoGrantPermissionsOption;
//npm install appium --chromedriver_version="2.16"
public class BaseTest {
	public AndroidDriver driver;
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("kirubaphone");
//		options.setApp("D:\\Workspaces\\CapgeminiAppium\\AppiumDemo\\src\\test\\java\\resources\\ApiDemos-debug.apk");
	//	options.setApp("D:\\Workspaces\\CapgeminiAppium\\AppiumDemo\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		//options.setCapability("app", "Chrome");
		options.setCapability("chromedriverExecutable", "C:\\Users\\k.kirubakaran\\Downloads\\chromedriver_win32 (11)\\chromedriver.exe");
		options.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		ChromeOptions options2 = new ChromeOptions();
		options2.addArguments("--disable-notifications");
		options2.addArguments("--remote-allow-origins=*");
        options.setCapability(ChromeOptions.CAPABILITY, options2);
//		options.setPlatformName("Android");
		//creating a object of android driver
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void longpressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId", 
				((RemoteWebElement) ele).getId(),"duration",2000));
	}
	public void scrolltoendAction() {
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}while(canScrollMore);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
