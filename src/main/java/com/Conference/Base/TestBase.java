package com.Conference.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.Conference.ConfigReader.ConfigReader;
import com.Conference.DriverFactory.DriverFactory;

public class TestBase {
	
  protected WebDriver driver;
@BeforeClass  
	public void setup() throws IOException {
		ConfigReader.loadConfig("prod");
		DriverFactory.initDriver();
		DriverFactory.getDriver().get(ConfigReader.getKeyValue("url"));;
		driver = DriverFactory.getDriver();
	}
}
