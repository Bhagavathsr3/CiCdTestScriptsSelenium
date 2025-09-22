package com.Conference.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.Conference.utils.WaitUtils;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='login']")
	private WebElement loginTab;

	@FindBy(xpath = "//label[text()='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//input[@id='loginEmail']")
	private WebElement emailInput;

	@FindBy(xpath = "//input[@id='loginPassword']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginSubmitBtn;

	public void openLoginform() {
		WaitUtils.waitUntilClickable(loginTab);
		loginTab.click();
		loginBtn.click();
		logger.info("login form opened successfully");
	}

	public void enterEmail(String email) {
		WaitUtils.waitUntilClickable(emailInput);
		emailInput.clear();
		emailInput.sendKeys(email);
		logger.info("Entered Email: " + email);
	}

	public void enterPassword(String password) {
		WaitUtils.waitUntilClickable(passwordInput);
		passwordInput.clear();
		passwordInput.sendKeys(password);
		logger.info("Entered password");
	}

	public void clickLoginBtn() {
		WaitUtils.waitUntilClickable(passwordInput);
		loginSubmitBtn.click();
	}

	public void validlogin(String email, String password) {
		openLoginform();
		enterEmail(email);
		enterPassword(password);
		WaitUtils.waitUntilClickable(loginSubmitBtn);
		clickLoginBtn();
		logger.info("Logged in Successfully with user: " + email);

	}

}
