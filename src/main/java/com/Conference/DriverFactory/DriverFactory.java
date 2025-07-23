package com.Conference.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Conference.ConfigReader.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
private static WebDriver tldriver;
	public static void initDriver() {
		
		String browserValue = ConfigReader.getKeyValue("browser").toLowerCase();
		switch (browserValue) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			 tldriver = new ChromeDriver();
			break;

		default:
			break;
		}
	}
		public static WebDriver getDriver() {
			return tldriver;
		}
	}

