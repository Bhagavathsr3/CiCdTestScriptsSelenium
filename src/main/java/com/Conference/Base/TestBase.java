package com.Conference.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import com.Conference.ConfigReader.ConfigReader;
import com.Conference.DriverFactory.DriverFactory;

public class TestBase {
	
  protected static WebDriver driver;
@BeforeClass
	public void setup() throws IOException {
		ConfigReader.loadConfig("prod");
		DriverFactory.initDriver();
		driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getKeyValue("url"));
	//	DriverFactory.getDriver().get(ConfigReader.getKeyValue("url"));;
		
	}
}
