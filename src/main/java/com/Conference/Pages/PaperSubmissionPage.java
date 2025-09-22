package com.Conference.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Conference.utils.ActionUtils;
import com.Conference.utils.WaitUtils;

public class PaperSubmissionPage extends BasePage {

	public PaperSubmissionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Publish Now")
	private WebElement publishNowtab;

	@FindBy(xpath = "//input[@name='txt']")
	private WebElement nameInput;
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailInput;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement descriptionInput;
	@FindBy(linkText = "Submit")
	private WebElement submitnowBtn;

	public void openPublishNowPage() {
		ActionUtils.scrollToElement(publishNowtab);
		WaitUtils.waitUntilClickable(publishNowtab);
		publishNowtab.click();
		logger.info("Paper submission Page Opened");
	}

	public void fillPaperSubmissionForm(String name, String email, String description) {

		nameInput.sendKeys(name);
		emailInput.sendKeys(email);
		WaitUtils.waitUntilClickable(descriptionInput);
		descriptionInput.sendKeys(description);
		submitnowBtn.click();
		logger.info("All details entered Successfully, the user details: " + name + " " + email);
	}
}
