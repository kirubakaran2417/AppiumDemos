package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ClassB {

	WebDriver driver;
	
	@Test
	public void run() {
		ClassA c=new ClassA(driver);
		c.username().sendKeys("kiruba");
	}
}
