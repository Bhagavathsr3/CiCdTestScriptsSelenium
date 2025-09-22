package com.Conference.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.Conference.ConfigReader.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
private static WebDriver tldriver;
	public static void initDriver() {
		
		String browserValue = ConfigReader.getKeyValue("browser").toLowerCase();
		switch (browserValue) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			 ChromeOptions options = new ChromeOptions();

             // Add headless options only for Linux (like in GitHub Actions)
             String os = System.getProperty("os.name").toLowerCase();
             if (os.contains("linux") || os.contains("unix")) {
                 options.addArguments("--headless=new");
                 options.addArguments("--no-sandbox");
                 options.addArguments("--disable-dev-shm-usage");
                 options.addArguments("--disable-gpu"); // Optional
                 options.addArguments("--window-size=1920,1080");
             }
             System.out.println("OS Detected: " + os);
             System.out.println("Running Chrome with options: " + options.toString());

             options.addArguments("--remote-allow-origins=*"); // Optional (for newer Chrome)

             tldriver = new ChromeDriver(options);
			// tldriver = new ChromeDriver();
			break;

		default:
			break;
		}
	}
		public static WebDriver getDriver() {
			return tldriver;
		}
	}

