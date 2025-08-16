package com.Conference.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
	public void verifyTitle() {
		String text = loginTab.getText();
	    Assert.assertEquals(text, "LOGINN");
	    logger.info("Passed");
	}
}
