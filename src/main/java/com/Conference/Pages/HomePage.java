package com.Conference.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[contains(text(), 'login')]")
 private WebElement loginTab;
	
	@FindBy(xpath = "")
	WebElement signUPTab;
	
	public void clickLogin() {
		loginTab.click();
	}
}
