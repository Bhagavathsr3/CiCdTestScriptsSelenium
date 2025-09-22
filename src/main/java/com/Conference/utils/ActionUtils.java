package com.Conference.utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Conference.Base.TestBase;



public class ActionUtils extends TestBase {

	public static void dropdownByVisibleText(WebElement element, String visisbleText) {
		
		
		//WebElement ele = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(visisbleText);
	}	
		public static void scrollToElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}

