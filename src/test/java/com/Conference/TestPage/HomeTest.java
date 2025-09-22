package com.Conference.TestPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Conference.Base.TestBase;
import com.Conference.Listeners.TestListener;
import com.Conference.Pages.HomePage;

@Listeners(TestListener.class)
public class HomeTest extends TestBase {
	@Test
	public void clickLogin() {
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		// hp.verifyTitle();
		hp.logger.info("Executed");
	}
}
