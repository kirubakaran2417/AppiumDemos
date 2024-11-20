package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class POM {
	AndroidDriver driver;
	By prefernceid=AppiumBy.accessibilityId("Preference");
	public WebElement preference() {
		return driver.findElement(prefernceid);
	}
	
}
