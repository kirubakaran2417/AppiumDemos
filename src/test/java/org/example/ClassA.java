package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassA {

	WebDriver driver;
	
	public ClassA(WebDriver driver) {
	this.driver=driver;	
	}
	public WebElement username() {
		return driver.findElement(By.id("name"));
	}
}
