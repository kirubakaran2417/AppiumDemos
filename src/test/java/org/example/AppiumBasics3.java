package org.example;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import junit.framework.Assert;

public class AppiumBasics3 extends BaseTest {

	@BeforeMethod
	public void preSetup()
	{
		//screen to home page
		Activity activity = new Activity("com.google.android.apps.messaging", "com.google.android.apps.messaging.ui.ConversationListActivity");
		driver.startActivity(activity);
		
		
	}
	
	@Test
	    public void runMessagesTest() {
	        try {
	            driver.findElement(By.id("com.google.android.apps.messaging:id/conversation_list_google_tos_popup_positive_button"))
	                  .click();
	            driver.findElement(By.id("android:id/button2"))
	                  .click();
	            driver.findElement(By.id("android:id/button1"))
	                  .click();
	        } catch(Exception e) {
	            System.out.println("Agree button not seen");
	        }
	        driver.findElement(AppiumBy.accessibilityId("Start chat"))
	              .click();
	        driver.findElement(AppiumBy.accessibilityId("Switch between entering text and numbers"))
	              .click();
	        driver.findElement(By.id("com.google.android.apps.messaging:id/recipient_text_view"))
	              .sendKeys("anand");
	        waitFor(5);
	    }
    private void waitFor(int numberOfSeconds) {
        try {
            log("Sleep for " + numberOfSeconds);
            Thread.sleep(numberOfSeconds * 1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    private void log(String message) {
        System.out.println(" ### " + new Date() + " ### " + message);
    }

}
